package newatm;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class RestWindow extends JFrame implements ActionListener
{

	     //定义组件
		JButton jb1,jb2,jb3=null;
		JPanel jp1,jp2=null;
		static JLabel jlb1,jlb2=null;
		ImageIcon icon;
	    //构造函数
		public RestWindow()    //不能申明为void!!!!!否则弹不出新界面
		{
			//设置标题  
	        super("信本银行");  //setTile("");
	        //设置大小  
			init();
		    setSize(1000,700);  //setBounds(1,1,1,1) 
	        //设置位置  
	        setLocation(200,150);  
	        //背景图片的路径。（相对路径或者绝对路径。本例图片放于"java项目名"的文件下）  
	        String path = "银行.jpg";  
	        // 背景图片  
	        ImageIcon background = new ImageIcon(path);  
	        // 把背景图片显示在一个标签里面  
	        JLabel label = new JLabel(background);  
	        // 把标签的大小位置设置为图片刚好填充整个面板  
	        label.setBounds(0, 0, this.getWidth(), this.getHeight());  
	        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明  
	        JPanel imagePanel = (JPanel) this.getContentPane();  
	        imagePanel.setOpaque(false);  
	        // 把背景图片添加到分层窗格的最底层作为背景  
	        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
	        //设置可见  
	        setVisible(true);  
	        //点关闭按钮时退出  
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
}
		public void init(){
			
		DataOperator c = new DataOperator();
		jlb1=new JLabel(c.getAll());
		jlb1.setFont(new   java.awt.Font("Dialog",   1,   25));
        jlb1.setForeground(Color.white);
        
		jb1=new JButton("转账");
		jb2=new JButton("取款");
		jb3=new JButton("返回");

        
	    Box baseBox,a,b;
	    Box vBox = Box.createVerticalBox();
	    Box hBox = Box.createHorizontalBox();
	    Box hBox2 = Box.createHorizontalBox();
	    hBox2.add(Box.createHorizontalStrut(100));
	    hBox2.add(jlb1);
	    hBox2.add(Box.createHorizontalStrut(100));
	    hBox.add(jb1);
	    hBox.add(Box.createHorizontalStrut(50));
	    hBox.add(jb2);
	    hBox.add(Box.createHorizontalStrut(50));
	    hBox.add(jb3);
	    vBox.add(Box.createVerticalStrut(300));
	    vBox.add(hBox2);
	    vBox.add(Box.createVerticalStrut(100));
	    vBox.add(hBox);
	    vBox.add(Box.createVerticalStrut(300));
	    b=Box.createHorizontalBox();
	    b.add(Box.createVerticalStrut(5));
	    b.add(vBox);
	    baseBox=Box.createVerticalBox();
	    baseBox.add(b);
	    add(baseBox); 
		 //设置监听  
        jb1.addActionListener(this);  
        jb2.addActionListener(this);  
        jb3.addActionListener(this);  
	  
			
        }
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==jb1){
	        	dispose();
	        	TransferWindow ui1=new TransferWindow();
	    	}
			if(e.getSource()==jb2){
	    		dispose();
	    		WithdrawWindow ui2=new WithdrawWindow();
	    	}
			if(e.getSource()==jb3){
	    		dispose();
	    		AtmWindow a=new AtmWindow();
	    		a.setVisible(true);
			}
		}
}
