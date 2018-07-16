package newatm;

import javax.swing.*;  

import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener; 
import java.awt.event.*;
import java.sql.*;  

public class AtmWindow extends JFrame implements ActionListener { 
	
	//定义主界面的组件  
    JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8=null;
    JPanel jp4=null;//按钮
    final ImageIcon icon;
    Image image;
    
    //构造函数  
    public AtmWindow()  
    {  
         //创建组件  
        jb1=new JButton("  取 款  ");  
        jb2=new JButton("  存 款  ");   
        jb3=new JButton("  转 账  ");  
        jb4=new JButton("  缴 贷  ");  
        
        jb5=new JButton("修改密码");
        jb6=new JButton("查询余额"); 
        jb7=new JButton("历史记录");  
        jb8=new JButton("退出系统");  
        
        icon = new ImageIcon("Bank.jpg");
		JPanel jp4 = new JPanel(null)
		{
			protected void paintComponent(Graphics g)
			{
				g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), icon.getImageObserver());
				super.paintComponent(g);
			}
		};
		jp4.setOpaque(false);
		jp4.setPreferredSize( new Dimension(500, 500) );
		add(jp4);	
		
 //       jp4=new JPanel(null);
         
        //设置监听  
        jb1.addActionListener(this);  
        jb2.addActionListener(this);  
        jb3.addActionListener(this);  
        jb4.addActionListener(this);  
        
        jb5.addActionListener(this);  
        jb6.addActionListener(this);  
        jb7.addActionListener(this);  
        jb8.addActionListener(this);  
          
        jp4.add(jb1);
        jp4.add(jb2);  
        jp4.add(jb3);  
        jp4.add(jb4);  
        
        jp4.add(jb5);  
        jp4.add(jb6);  
        jp4.add(jb7);  
        jp4.add(jb8);  
         
        //设置按钮的位置
        jb1.setBounds(1,120,120,70);//x,y,length,width
        jb2.setBounds(1,270,120,70);
        jb3.setBounds(1,420,120,70);
        jb4.setBounds(1,570,120,70);
        
        jb5.setBounds(873,120,120,70);
        jb6.setBounds(873,270,120,70);
        jb7.setBounds(873,420,120,70);
        jb8.setBounds(873,570,120,70);
        //加入JFrame中  

        this.add(jp4);  
        //设置布局管理器  
        this.setLayout(new GridLayout(1,1));  
        //给窗口设置标题  
        this.setTitle("信本银行");  
        //设置窗体大小  
        this.setSize(1000,700);  
        //设置窗体初始位置  
        this.setLocation(200,150);  
        //设置当关闭窗口时，保证JVM也退出  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //显示窗体  
        this.setVisible(true);  
        this.setResizable(false);  
    }
    public void actionPerformed(ActionEvent e){
    	if(e.getSource()==jb1){
    		dispose();
    		WithdrawWindow ui1=new WithdrawWindow();
    	}
    	else if(e.getSource()==jb2){
        	dispose();
        	SaveWindow ui2=new SaveWindow();
    	}
    	else if(e.getSource()==jb3){
        	dispose();
        	TransferWindow ui3=new TransferWindow();
    	}
    	else if(e.getSource()==jb4){
        	dispose();
        	PayWindow ui4=new PayWindow();
    	}
    	else if(e.getSource()==jb5){
        	dispose();
        	RecomposeWindow ui5=new RecomposeWindow();
    	}
    	else if(e.getSource()==jb6){
        	dispose();
        	RestWindow ui6=new RestWindow();
    	}
    	else if(e.getSource()==jb7){
        	dispose();
        	HistoryWindow ui7=new HistoryWindow();
    	}
    	else if(e.getSource()==jb8){
        	dispose();
    	}
    }
}

