package newatm;

import javax.swing.*;  

import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  

public class WithdrawWarning extends JFrame implements ActionListener {  
  
    //定义登录界面的组件  
    JButton jb1,jb2=null;  //按钮
    JPanel jp1,jp2,jp3,jp4=null;  //面板
    //JTextField jtf=null;     //文本
    JLabel jlb1=null;  //标签
    //JPasswordField jpf=null;  //密码
    ButtonGroup bg=null;     
	DataOperator c=new DataOperator();
    //构造函数  
    public WithdrawWarning()  
    {  
         //创建组件  
        jb1=new JButton("取消");  
        jb2=new JButton("确定");   
        //设置监听  
        jb1.addActionListener(this);  
        jb2.addActionListener(this);  
        
          
        jp1=new JPanel();  
        jp2=new JPanel();
        jlb1=new JLabel("您取款的金额为："+WithdrawWindow.jtf1.getText()+" 元吗？");
          
        
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
    	}
    	else if(e.getSource()==jb2){
        	dispose();
        	String f=WithdrawWindow.jtf1.getText();
        	float weight;
        	try{
        		weight = Float.parseFloat(f);
        	}catch(Exception err){
        		weight = 0;
        	} 
        	//DataOperator c = new DataOperator();
        	//String g = RestWindow.jlb1.getText();
        	//float height;
        	//height = Float.parseFloat(g);
        	if(c.Withdraw(weight)){
        		WithdrawSuccess t=new WithdrawSuccess();
        	}
        	else{
        		WithdrawFail2 a=new WithdrawFail2();
        	}
        	
        
        ////	WithdrawFail2 a=new WithdrawFail2();
        	
            //dispose();
    	}

        }
 }
