package newatm;

import java.sql.*;  
//import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*; 
import java.util.Date; 
import java.util.Calendar; 
  
public class DataOperator{  
        //����ύ���û���������  
	Connection con;
	private PreparedStatement pstmt;
	private String sql;
	float rest;
	static String kahao;
    //�������ݿ�

public void loadDatabaseDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("�������ݿ�����ʧ�ܣ�");
			System.err.println(e);
		}
	}
public void connect(){
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","");
			this.con = con;
		} catch (SQLException e) {
			System.err.println("���ݿ����ӳ���");
			System.err.println(e);
		}
	}
public int userQuery(String userName, String password){
	//��ѯ�û����˶��û����������Ƿ���ȷ
	try {
		this.connect();
		sql = "SELECT id from user WHERE userName = ? AND password = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userName);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		kahao=userName;
		if (rs.next()) {
			System.out.println(rs.getInt("id"));
		}
			return rs.getInt("id");	
	//	return 0;
	} 
	catch (SQLException se) {
		System.err.println("��ѯ�û������");
		System.err.println(se);
		return -1;
		}
	}
//��ѯ���
public String getAll(){
	//String table="res";
	String s=new String();
	try{
		this.connect();
		
		sql="SELECT * FROM res";
		pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql+" WHERE userName = '"+kahao+"'");
		//pstmt.setInt(1, lendRecordId);
		//pstmt.setString(1, name);
		//pstmt.setString(2, rest);
		
		if (rs.next()) {
			s=rs.getString("name")+"�������ã��������Ϊ��"+rs.getFloat("rest");
			rest=rs.getFloat("rest");//Ϊȡ�����
		}
	}
		catch (SQLException se) {
		System.err.println("���ݿ��ѯ����");
		System.err.println(se);
		
	 }
	return s;
}
public boolean Withdraw(float withdrawAmount){
	this.getAll();
//	String s=new String();
	if(withdrawAmount<=rest && withdrawAmount%100==0){
		rest=rest-withdrawAmount;
		try{
			sql="UPDATE res SET rest=";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate(sql+rest+" WHERE userName = '"+kahao+"'");
			insert(kahao/*����*/,0,withdrawAmount,getTime());//�������ݿ⣺��¼
		}
			catch (SQLException se) {
			System.err.println("���ݿ�ȡ�����");
			System.err.println(se);
			
		 }
	//	DecimalFormat momey = new DecimalFormat("0.00");
	//	s="����ȡ������ :"+withdrawAmount+".";//��ͬ����
		return true;
	}
	else{
	//	s="the withdrawal amount is too large. Selct Withdraw and enter a different amount.";
		
	}
	return false;
}


public boolean Save(float SaveAmount){
	this.getAll();//�õ�rest����
	if(SaveAmount<0 || SaveAmount%100!=0){//ȡ������С��0�����߲���100��������
		return false;
	}
	rest=rest+SaveAmount;
	try{
		sql="UPDATE res SET rest=";
		pstmt = con.prepareStatement(sql);
		pstmt.executeUpdate(sql+rest+" WHERE userName = '"+kahao+"'");
	//	System.out.println(kahao+"   "+SaveAmount+"   "+getTime());
		insert(kahao/*����*/,SaveAmount,0,getTime());//�������ݿ⣺��¼
	}
		catch (SQLException se) {
		System.err.println("���ݿ������");
		System.err.println(se);
		
	 }
	return true;
	
}
public boolean pay(float payAmount){
	this.getAll();//��ȡ���rest
//	String s=new String();
	float debt = 0;
	try{
		sql="SELECT debt FROM pay";
		pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql+" WHERE userName = '"+kahao+"'");
		if(rs.next()){
			debt=rs.getFloat("debt");
		}		
	}catch (SQLException se) {
		System.err.println("��ȡ���ɽ�����");
		System.err.println(se);
		se.printStackTrace();
	}
	if(payAmount<=debt &&payAmount>0){//����Ľ��ܴ��ڴ��ɽ��     ����Ҫ��������
		rest=rest-payAmount;
		debt=debt-payAmount;
		try{
			sql="UPDATE res SET rest=";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate(sql+rest+" WHERE userName = '"+kahao+"'");
			
			//������������ �����Ǵ��ɽ��Ҳ����
			sql="UPDATE pay SET debt=";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate(sql+debt+" WHERE userName = '"+kahao+"'");
			insert(kahao/*����*/,0,payAmount,getTime());//�������ݿ⣺��¼
			
		}
			catch (SQLException se) {
			System.err.println("���ݿ�ɴ�����");
			System.err.println(se);
			
		 }
		return true;
	}
	else{
		return false;
		//��������Ѵ��󣬴���Ϊ����Ľ��ȴ��ɽ���
	}
	}
public boolean changePassword(String Name,String idCard,String phoneNumber,String password,String password2,String password3){
	this.connect();
	try{
		sql="SELECT * FROM changepassword";
		pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql+" WHERE userName = '"+kahao+"'");
		if(rs.next()){	//���������Ϣȫ����ȷ        ��������3��
		//	System.out.println(Name+".."+ idCard+".."+phoneNumber+".."+password+".."+password2+".."+password3);
	//		System.out.println(rs.getString("Name")+"zz"+ rs.getString("idCard")+"zz"+rs.getString("phoneNumber")+"zz"+rs.getString("password")+"zz"+password2+"zz"+password3);
			String n1=rs.getString("Name");
			String n2=rs.getString("idCard");
			String n3=rs.getString("phoneNumber");
			String n4=rs.getString("password");
			if(Name.equals(n1) && idCard.equals(n2) && phoneNumber.equals(n3) && password.equals(n4) && password2.equals(password3)){
		//		System.out.println("sssssssss");
				sql="UPDATE changepassword SET password=";
				pstmt = con.prepareStatement(sql);
				pstmt.executeUpdate(sql+password2+" WHERE userName = '"+kahao+"'");
				//�����޸�**** �����޸ĵ�½�û���
				sql="UPDATE user SET password=";
				pstmt = con.prepareStatement(sql);
				pstmt.executeUpdate(sql+password2+" WHERE userName = '"+kahao+"'");
			//	System.out.println("sssssssss");
				return true;
			}
			else{
				//����� System.out.println("��Ϣ����"); ֮��Ķ���
				return false;
			}	
		}
		return true;
	}catch(SQLException se){
		System.out.println("���ݿ��޸��������");
		System.out.println(se);
		return false;
	}	
  }
public boolean Transfer(String userName,String userName1,float money){//ת��    money ��ת���
	//�ж��Ƿ���ڸ��û�   �������������û�������
	//�˻�������
	//��ת�û��������
	//������
	float rest1 = 0;
	float rest2=0;
	if(!userName.equals(userName1) || money<0){
		return false;
	}
	try{
		this.connect();
		sql="SELECT Rest FROM res";
		pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql+" WHERE userName ='"+kahao+"'");//'ad'��Ҫ��
		if(rs.next()){													//kahao�ǵ�ǰ�û���userName
			rest1 = rs.getFloat("Rest");//�õ��û������ rest1
		sql="SELECT userName FROM user";
		pstmt = con.prepareStatement(sql);
		if(pstmt.executeQuery(sql+" WHERE userName ='"+userName+"'") != null){//�ҵ�userName ����
		//	System.out.println(rest1);//û����
			//������ڸ��û�����õ���ת���û������rest2
					sql="SELECT Rest FROM res";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery(sql+" WHERE userName ='"+userName+"'");
					
					if(rs.next()){
						rest2 = rs.getFloat("Rest");
				//		System.out.println(rest2);
					}
					rest1=rest1-money;
				//	System.out.println(rest1);
					rest2=rest2+money;
				//	System.out.println(rest2);
					
					sql="UPDATE res SET Rest=";
					pstmt = con.prepareStatement(sql);
					pstmt.executeUpdate(sql+rest1+" WHERE userName ='"+kahao+"'");
					insert(kahao/*����*/,0,money,getTime());//�������ݿ⣺��¼
					//�����Ƕ��û��Ľ�����    �����ǶԱ�ת���û��������   ������Ҫ������
					sql="UPDATE res SET Rest=";
					pstmt = con.prepareStatement(sql);
					pstmt.executeUpdate(sql+rest2+" WHERE userName ='"+userName+"'");
					insert(userName/*����*/,money,0,getTime());//�������ݿ⣺��¼
					return true;
				}
		else{
			return false;
		}
		}
	//	else{
	//		return false;
			//�Ҳ������˻�
	//	}
	}
	catch(SQLException es){
		System.out.println("���ݿ�ת�˳���");
		System.out.println(es);
	}
	return true;
}
public void insert(String userName/*����*/,float inMoney,float outMoney,String time){
	this.connect();
	switch (userName){
	case "ad":sql="INSERT into history1";break;
	case "ac":sql="INSERT into history2";break;
	case "az":sql="INSERT into history3";break;
	}
	try{
		pstmt = con.prepareStatement(sql);
		pstmt.execute(sql+" VALUE ('"+0+"','"+kahao+"','"+inMoney+"','"+outMoney+"','"+time+"');");
		
	}catch(SQLException es){
		System.out.println("���ݿ�������");
		System.out.println(es);
		
	}
}
public String getTime(){
	Date now = new Date(); 
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//���Է�����޸����ڸ�ʽ 

	String s = dateFormat.format(now); 
	//System.out.println(s); 
	return s;
 }
}