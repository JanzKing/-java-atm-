package newatm;

import java.sql.*;  
//import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*; 
import java.util.Date; 
import java.util.Calendar; 
  
public class DataOperator{  
        //获得提交的用户名和密码  
	Connection con;
	private PreparedStatement pstmt;
	private String sql;
	float rest;
	static String kahao;
    //连接数据库

public void loadDatabaseDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("加载数据库驱动失败！");
			System.err.println(e);
		}
	}
public void connect(){
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","");
			this.con = con;
		} catch (SQLException e) {
			System.err.println("数据库连接出错！");
			System.err.println(e);
		}
	}
public int userQuery(String userName, String password){
	//查询用户表，核对用户名和密码是否正确
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
		System.err.println("查询用户表出错！");
		System.err.println(se);
		return -1;
		}
	}
//查询语句
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
			s=rs.getString("name")+"先生您好，您的余额为："+rs.getFloat("rest");
			rest=rs.getFloat("rest");//为取款服务
		}
	}
		catch (SQLException se) {
		System.err.println("数据库查询出错！");
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
			insert(kahao/*卡号*/,0,withdrawAmount,getTime());//插入数据库：记录
		}
			catch (SQLException se) {
			System.err.println("数据库取款出错！");
			System.err.println(se);
			
		 }
	//	DecimalFormat momey = new DecimalFormat("0.00");
	//	s="您的取款金额是 :"+withdrawAmount+".";//形同虚设
		return true;
	}
	else{
	//	s="the withdrawal amount is too large. Selct Withdraw and enter a different amount.";
		
	}
	return false;
}


public boolean Save(float SaveAmount){
	this.getAll();//得到rest余额的
	if(SaveAmount<0 || SaveAmount%100!=0){//取款金额若小于0，或者不是100的整数倍
		return false;
	}
	rest=rest+SaveAmount;
	try{
		sql="UPDATE res SET rest=";
		pstmt = con.prepareStatement(sql);
		pstmt.executeUpdate(sql+rest+" WHERE userName = '"+kahao+"'");
	//	System.out.println(kahao+"   "+SaveAmount+"   "+getTime());
		insert(kahao/*卡号*/,SaveAmount,0,getTime());//插入数据库：记录
	}
		catch (SQLException se) {
		System.err.println("数据库存款出错！");
		System.err.println(se);
		
	 }
	return true;
	
}
public boolean pay(float payAmount){
	this.getAll();//获取余额rest
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
		System.err.println("获取待缴金额出错！");
		System.err.println(se);
		se.printStackTrace();
	}
	if(payAmount<=debt &&payAmount>0){//输入的金额不能大于代缴金额     这里要加事务处理
		rest=rest-payAmount;
		debt=debt-payAmount;
		try{
			sql="UPDATE res SET rest=";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate(sql+rest+" WHERE userName = '"+kahao+"'");
			
			//上面是余额减少 下面是代缴金额也减少
			sql="UPDATE pay SET debt=";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate(sql+debt+" WHERE userName = '"+kahao+"'");
			insert(kahao/*卡号*/,0,payAmount,getTime());//插入数据库：记录
			
		}
			catch (SQLException se) {
			System.err.println("数据库缴贷出错！");
			System.err.println(se);
			
		 }
		return true;
	}
	else{
		return false;
		//这里加提醒错误，错误为输入的金额比代缴金额大！
	}
	}
public boolean changePassword(String Name,String idCard,String phoneNumber,String password,String password2,String password3){
	this.connect();
	try{
		sql="SELECT * FROM changepassword";
		pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql+" WHERE userName = '"+kahao+"'");
		if(rs.next()){	//若输入的信息全部正确        事务处理！（3）
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
				//上面修改**** 下面修改登陆用户表
				sql="UPDATE user SET password=";
				pstmt = con.prepareStatement(sql);
				pstmt.executeUpdate(sql+password2+" WHERE userName = '"+kahao+"'");
			//	System.out.println("sssssssss");
				return true;
			}
			else{
				//这里加 System.out.println("信息错误！"); 之类的东西
				return false;
			}	
		}
		return true;
	}catch(SQLException se){
		System.out.println("数据库修改密码出错！");
		System.out.println(se);
		return false;
	}	
  }
public boolean Transfer(String userName,String userName1,float money){//转账    money 待转金额
	//判断是否存在该用户   遍历表中所有用户？？？
	//账户金额减少
	//被转用户金额增加
	//事务处理
	float rest1 = 0;
	float rest2=0;
	if(!userName.equals(userName1) || money<0){
		return false;
	}
	try{
		this.connect();
		sql="SELECT Rest FROM res";
		pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql+" WHERE userName ='"+kahao+"'");//'ad'都要改
		if(rs.next()){													//kahao是当前用户的userName
			rest1 = rs.getFloat("Rest");//得到用户的余额 rest1
		sql="SELECT userName FROM user";
		pstmt = con.prepareStatement(sql);
		if(pstmt.executeQuery(sql+" WHERE userName ='"+userName+"'") != null){//找到userName 存在
		//	System.out.println(rest1);//没到这
			//如果存在该用户，则得到被转账用户的余额rest2
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
					insert(kahao/*卡号*/,0,money,getTime());//插入数据库：记录
					//上面是对用户的金额减少    下面是对被转账用户金额增加   这里需要事务处理
					sql="UPDATE res SET Rest=";
					pstmt = con.prepareStatement(sql);
					pstmt.executeUpdate(sql+rest2+" WHERE userName ='"+userName+"'");
					insert(userName/*卡号*/,money,0,getTime());//插入数据库：记录
					return true;
				}
		else{
			return false;
		}
		}
	//	else{
	//		return false;
			//找不到该账户
	//	}
	}
	catch(SQLException es){
		System.out.println("数据库转账出错！");
		System.out.println(es);
	}
	return true;
}
public void insert(String userName/*卡号*/,float inMoney,float outMoney,String time){
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
		System.out.println("数据库插入出错！");
		System.out.println(es);
		
	}
}
public String getTime(){
	Date now = new Date(); 
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式 

	String s = dateFormat.format(now); 
	//System.out.println(s); 
	return s;
 }
}