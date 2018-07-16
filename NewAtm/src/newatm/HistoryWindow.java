package newatm;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class HistoryWindow extends JFrame implements ActionListener{
	JButton fanhui;
	JButton returnto;
    JTable table;
    Object body[][]=new Object[50][5];
    String title[]={"id","�˻�","������","֧�����","ʱ��"};;
    Statement stat;
    ResultSet rs;
    JTabbedPane tp,ps;
	HistoryWindow(){
	super("�ű�����");
        this.setSize(1000,700);
        this.setLocation(300,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel ps=new JPanel();
        returnto=new JButton("�������˵�");
        returnto.addActionListener(this);
        ps.add(returnto);
        table=new JTable(body,title);
        tp=new JTabbedPane();
        tp.add("��ʷ��¼",new JScrollPane(table));
        this.getContentPane().add(tp,"Center");
        this.getContentPane().add(ps,"South");
        this.setVisible(true);
        select();
	}
	public void actionPerformed(ActionEvent e) {
        if(e.getSource()==fanhui){
        	    this.dispose();
            	new HistoryWindow();   	
        }
        if(e.getSource()==returnto){
        	dispose();
            AtmWindow h=new AtmWindow();
        }
	}
	public void select() {
		try{
			   Class.forName("com.mysql.jdbc.Driver");
	    }
	    catch(ClassNotFoundException a){
	   	       System.out.println(""+a.getMessage());
		}
        try {
        	Connection con;
        	con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","");
        	Statement sql=con.createStatement();
            for(int x=1;x<body.length;x++){
            body[x][0]=null;
            body[x][1]=null;
            body[x][2]=null;
            body[x][3]=null;
            body[x][4]=null;
            }
          //  String history=null;
            ResultSet rs=null;
            switch(MainLogin.jtf.getText()){
            case "ad":rs=sql.executeQuery("select * from history1");break;
            case "ac":rs=sql.executeQuery("select * from history2");break;
            case "az":rs=sql.executeQuery("select * from history3");break;
            }
         //   System.out.println(MainLogin.jtf.getText()+"  "+history);
         //   ResultSet rs=sql.executeQuery("select * from '"+history+"'");
            /*
            String history=null;
            switch(MainLogin.jtf.getText()){
            case "ad":history="history1";break;
            case "ac":history="histoyr2";break;
            case "az":history="history3";break;
            }
         //   System.out.println(MainLogin.jtf.getText()+"  "+history);
            ResultSet rs=sql.executeQuery("select * from '"+history+"'");
            */
            
            int i=0;								//from history1
            while(rs.next()){
            body[i][0]=rs.getInt(1);
            body[i][1]=rs.getString(2);
            body[i][2]=rs.getFloat(3);
            body[i][3]=rs.getFloat(4);
            body[i][4]=rs.getString(5);
            i=i+1;
            }
            this.repaint();
        } catch (SQLException ex) {
        }

    }
}
