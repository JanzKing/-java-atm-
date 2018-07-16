package newatm;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SaveWindow extends JFrame implements ActionListener
{

	     //定义组件
		JButton jb1,jb2,jb3=null;
		JPanel jp1,jp2,jp3=null;
		JLabel jlb1=null;
		static JTextField jtf1=null; 
	
	    //构造函数
		public SaveWindow()    //不能申明为void!!!!!否则弹不出新界面
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
		jb1=new JButton("  确   认    ");
		jb2=new JButton("返回主菜单");
		
		jlb1=new JLabel("存款金额:");
		jlb1.setFont(new   java.awt.Font("Dialog",   1,   25));
        jlb1.setForeground(Color.red);
        
        jtf1=new JTextField(5); 
        
	    Box baseBox,a,b;
	    Box vBox = Box.createVerticalBox();
	    Box hBox = Box.createHorizontalBox();
	    Box hBox2 = Box.createHorizontalBox();
	    hBox2.add(Box.createHorizontalStrut(100));
	    hBox2.add(jlb1);
	    hBox2.add(Box.createHorizontalStrut(10));
	    hBox2.add(jtf1);
	    hBox2.add(Box.createHorizontalStrut(100));
	    hBox.add(jb1);
	    hBox.add(Box.createHorizontalStrut(50));
	    hBox.add(jb2);
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
	    
	    jb1.addActionListener(this);  
        jb2.addActionListener(this); 
	  
			
			
			
		    
			/*this.setBounds(100,100,700,500);
			fr.setLayout(null);
		    icon = new ImageIcon("银行.jpg");
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
			//创建组件

			
			jb1=new JButton("  确   认    ");
			jb2=new JButton("返回主菜单");
	        jlb1=new JLabel("缴贷金额:");
	        jtf1=new JTextField(10); 
	        
	        //fr.getContentPane().add(jp4);
	        
			fr.getContentPane().add(jb1);
			jb2.setBounds(1,380,120,50);
			
			fr.getContentPane().add(jb2);
			jb1.setBounds(573,380,120,50);
			
			fr.getContentPane().add(jlb1);
			jlb1.setBounds(240,200,80,25);
			
			fr.getContentPane().add(jtf1);
			jtf1.setBounds(300,200,100,25);
			
			fr.setTitle("信本银行");
			//jp2=new JPanel();
			fr.setVisible(true);
		    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    fr.setLocation(200,150);                  //让窗体居中显示
			 //设置监听  
	        jb1.addActionListener(this);  
	        jb2.addActionListener(this);  
	        

			
	        
	      //设置布局管理器
			//this.setLayout(null);
			//this.setTitle("信本银行");
			//this.setSize(700,500);
			/*this.setLocation(200,150);		
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
			this.setResizable(false); */
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==jb1){
	    		dispose();
	    		SaveWarning b=new SaveWarning();
	    		b.setVisible(true);
			}
	    	else if(e.getSource()==jb2){
	    		dispose();
	    		AtmWindow a=new AtmWindow();
	    		a.setVisible(true);
			}
		}
}
	        
			
