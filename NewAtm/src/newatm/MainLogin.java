package newatm;

import javax.swing.*;  

import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.sql.*;  

public class MainLogin extends JFrame implements ActionListener {  
  
    //定义登录界面的组件  
    JButton jb1,jb2=null;  //按钮
    JPanel jp1,jp2,jp3,jp4=null;  //面板
    static JTextField jtf=null;     //文本
    JLabel jlb1,jlb2=null;  //标签
    JPasswordField jpf=null;  //密码
    ButtonGroup bg=null;      
    
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        MainLogin  ms=new MainLogin(); 
    }
    
    //构造函数  
    public MainLogin()  
    {  
         //创建组件  
        jb1=new JButton("登录");  
        jb2=new JButton("退出系统");   
        //设置监听  
        jb1.addActionListener(this);  
        jb2.addActionListener(this);  
        
          
        jp1=new JPanel();  
        jp2=new JPanel();  
        jp3=new JPanel();  
        jp4=new JPanel();                 
          
        jlb1=new JLabel("卡号：");  
        jlb2=new JLabel("密码：");  
        jtf=new JTextField(10);  
        jpf=new JPasswordField(10);  
        //加入到JPanel中  
        jp1.add(jlb1);  
        jp1.add(jtf);  
          
        jp2.add(jlb2);  
        jp2.add(jpf);  
          
        /*jp3.add(jlb3);  
        jp3.add(jrb1);  
        jp3.add(jrb2); */ 
          
        jp4.add(jb1);  
        jp4.add(jb2);  
        //jp4.add(jb3);  
          
        //加入JFrame中  
        //this.setJMenuBar(jmb);  
        this.add(jp1);  
        this.add(jp2);  
        this.add(jp3);  
        this.add(jp4);  
        //设置布局管理器  
        this.setLayout(new GridLayout(4,1));  
        //给窗口设置标题  
        this.setTitle("信本银行");  
        //设置窗体大小  
        this.setSize(300,170);  
        //设置窗体初始位置  
        this.setLocation(200, 150);  
        //设置当关闭窗口时，保证JVM也退出  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //显示窗体  
        this.setVisible(true);  
        this.setResizable(false);  
          
    } 
    public void actionPerformed(ActionEvent e){
        DataOperator a=new DataOperator();
        a.loadDatabaseDriver();
        a.connect();
        
    	if(e.getSource()==jb1){
    		if(a.userQuery(jtf.getText().trim(),jpf.getText().trim()) > 0)  
            {   
                JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);  
                //this.clear();  
                //关闭当前界面  
                 dispose();  
                 //创建一个新界面  
                 AtmWindow ui=new AtmWindow(); 
            }
            else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())  
            {  
                JOptionPane.showMessageDialog(null,"请输入卡号和密码！","提示消息",JOptionPane.WARNING_MESSAGE);  
            }else if(jtf.getText().isEmpty())  
            {  
            	JOptionPane.showMessageDialog(null,"请输入卡号！","提示消息",JOptionPane.WARNING_MESSAGE);  
            }else if(jpf.getText().isEmpty())  
            {  
                JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);  
            }else  
            {  
                JOptionPane.showMessageDialog(null,"卡号或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);  
                //清空输入框  
               //this.clear();  
            } 
    	}
   
    	if(e.getSource()==jb2){
    		dispose();
    	}
    /*//清空文本框和密码框  
    public  void clear()  
        {  
            jtf.setText("");  
            jpf.setText("");  
        } */ 
}
   
            //用户登录判断方法  
            /*public void stulogin()  
            {  
            	ActionEvent e;
            	if(e.getSource()==jb1){
                   if(DataOperate.userword.equals(jtf.getText())&&DataOperate.pwd.equals(jpf.getText()))  
                {   
                    JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);  
                    this.clear();  
                    //关闭当前界面  
                     dispose();  
                     //创建一个新界面  
                     AtmWindow ui=new AtmWindow();  
                }else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())  
                {  
                    JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);  
                }else if(jtf.getText().isEmpty())  
                {  
                    JOptionPane.showMessageDialog(null,"请输入用户名！","提示消息",JOptionPane.WARNING_MESSAGE);  
                }else if(jpf.getText().isEmpty())  
                {  
                    JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);  
                }else  
                {  
                    JOptionPane.showMessageDialog(null,"用户名或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);  
                    //清空输入框  
                    this.clear();  
                }  
            } */
            
              
}