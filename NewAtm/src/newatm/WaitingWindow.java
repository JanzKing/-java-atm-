package newatm;

import java.awt.*;
import java.awt.event.*;
//import java.util.TimberTask.*;
import javax.swing.*;

public class WaitingWindow extends JFrame implements ActionListener
{
	//定义登录界面的组件  
    JButton jb1,jb2=null;  //按钮
    JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7=null;  //面板
    JTextField jtf1,jtf2,jtf3=null;     //文本
    JLabel jlb1,jlb2,jlb3,jlb4,jlb5,jlb6=null;  //标签
    JPasswordField jpf1,jpf2,jpf3=null;  //密码
    //ButtonGroup bg=null;
	
	    //构造函数
		public WaitingWindow()    //不能申明为void!!!!!否则弹不出新界面
		{
			//创建组件  
	        jp1=new JPanel();  
	        
	        jlb1=new JLabel("正在出款，请稍候...");  
	        
	        jp1.add(jlb1);  
	
	        this.add(jp1);
	        
	      //设置布局管理器
			this.setLayout(new GridLayout(7,1));
			this.setTitle("信本银行");
			this.setSize(700,500);
			this.setLocation(200,150);		
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
			this.setResizable(false); 
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			    //time.schedule(dispose(),5000);
	    		AtmWindow a=new AtmWindow();
	    		a.setVisible(true);
			}
		
}

    