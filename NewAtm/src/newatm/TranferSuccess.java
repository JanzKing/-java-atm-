package newatm;

import javax.swing.*;  

import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.sql.*;  

public class TranferSuccess extends JFrame implements ActionListener {  
  
    //定义登录界面的组件  
    JButton jb1,jb2=null;  //按钮
    JPanel jp1,jp2,jp3,jp4=null;  //面板
    //JTextField jtf=null;     //文本
    JLabel jlb1=null;  //标签
    //JPasswordField jpf=null;  //密码
    ButtonGroup bg=null;     
    
    //构造函数  
    public TranferSuccess()  
    {  
         //创建组件  
        jb1=new JButton("继续转账");  
        jb2=new JButton("确定");   
        //设置监听  
        jb1.addActionListener(this);  
        jb2.addActionListener(this);  
        
          
        jp1=new JPanel();  
        jp2=new JPanel();
        jlb1=new JLabel("转账成功！");
          
        
        jp1.add(jlb1);
        jp2.add(jb1);  
        jp2.add(jb2);  
        
        
        this.add(jp1);  
        this.add(jp2); 
        //设置布局管理器  
        this.setLayout(new GridLayout(2,1));  
        //给窗口设置标题  
        this.setTitle("提示消息");  
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
    	if(e.getSource()==jb1){
    		dispose();
    		TransferWindow p=new TransferWindow();
    	}
    	else if(e.getSource()==jb2){
        	dispose();
        	AtmWindow ui2=new AtmWindow();
        }
     }
}
