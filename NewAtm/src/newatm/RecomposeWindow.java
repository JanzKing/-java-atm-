package newatm;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class RecomposeWindow extends JFrame implements ActionListener
{
	//定义登录界面的组件  
    JButton jb1,jb2=null;  //按钮
    JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7=null;  //面板
    JTextField jtf1,jtf2,jtf3=null;     //文本
    JLabel jlb1,jlb2,jlb3,jlb4,jlb5,jlb6=null;  //标签
    JPasswordField jpf1,jpf2,jpf3=null;  //密码
    //ButtonGroup bg=null;
    ImageIcon icon;
    Image image;
	
	    //构造函数
    public RecomposeWindow()    //不能申明为void!!!!!否则弹不出新界面
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
	
	jlb1=new JLabel(" 客户姓名 :");  
	jlb2=new JLabel(" 身份证号 :"); 
	jlb3=new JLabel(" 预留电话 :");
    jlb4=new JLabel(" 输入密码 :");
	jlb5=new JLabel(" 修改密码 :");
	jlb6=new JLabel(" 重复输入 :");
	
	jlb1.setFont(new   java.awt.Font("Dialog",   1,   15));
    jlb1.setForeground(Color.white);
    
    jlb2.setFont(new   java.awt.Font("Dialog",   1,   15));
    jlb2.setForeground(Color.white);
    
    jlb3.setFont(new   java.awt.Font("Dialog",   1,   15));
    jlb3.setForeground(Color.white);
    
    jlb4.setFont(new   java.awt.Font("Dialog",   1,   15));
    jlb4.setForeground(Color.white);
    
    jlb5.setFont(new   java.awt.Font("Dialog",   1,   15));
    jlb5.setForeground(Color.white);
    
    jlb6.setFont(new   java.awt.Font("Dialog",   1,   15));
    jlb6.setForeground(Color.white);
    
    
    
    jtf1=new JTextField(10); 
    jtf2=new JTextField(10); 
    jtf3=new JTextField(10); 
    jpf1=new JPasswordField(10); 
    jpf2=new JPasswordField(10); 
    jpf3=new JPasswordField(10); 
    
    Box baseBox,a,b;
    Box vBox = Box.createVerticalBox();
    Box hBox = Box.createHorizontalBox();
    Box hBox2 = Box.createHorizontalBox();
    Box hBox3 = Box.createHorizontalBox();
    Box hBox4 = Box.createHorizontalBox();
    Box hBox5 = Box.createHorizontalBox();
    Box hBox6 = Box.createHorizontalBox();
    Box hBox7 = Box.createHorizontalBox();
    //hBox2.add(Box.createHorizontalStrut(100));
    hBox2.add(jlb1);
    hBox2.add(Box.createHorizontalStrut(10));
    hBox2.add(jtf1);
    hBox2.add(Box.createHorizontalStrut(160));
    
    hBox3.add(jlb2);
    hBox3.add(Box.createHorizontalStrut(10));
    hBox3.add(jtf2);
    hBox3.add(Box.createHorizontalStrut(160));
    
    hBox4.add(jlb3);
    hBox4.add(Box.createHorizontalStrut(10));
    hBox4.add(jtf3);
    hBox4.add(Box.createHorizontalStrut(160));
    
    hBox5.add(jlb4);
    hBox5.add(Box.createHorizontalStrut(10));
    hBox5.add(jpf1);
    hBox5.add(Box.createHorizontalStrut(160));
    
    hBox6.add(jlb5);
    hBox6.add(Box.createHorizontalStrut(10));
    hBox6.add(jpf2);
    hBox6.add(Box.createHorizontalStrut(160));
    
    hBox7.add(jlb6);
    hBox7.add(Box.createHorizontalStrut(10));
    hBox7.add(jpf3);
    hBox7.add(Box.createHorizontalStrut(160));
    
    hBox.add(jb1);
    hBox.add(Box.createHorizontalStrut(50));
    hBox.add(jb2);
    vBox.add(Box.createVerticalStrut(300));
    
    vBox.add(hBox2);
    vBox.add(Box.createVerticalStrut(25));
    vBox.add(hBox3);
    vBox.add(Box.createVerticalStrut(25));
    vBox.add(hBox4);
    vBox.add(Box.createVerticalStrut(25));
    vBox.add(hBox5);
    vBox.add(Box.createVerticalStrut(25));
    vBox.add(hBox6);
    vBox.add(Box.createVerticalStrut(25));
    vBox.add(hBox7);
    vBox.add(Box.createVerticalStrut(25));
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
	}
  
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==jb2){
	    		dispose();
	    		AtmWindow a=new AtmWindow();
	    		a.setVisible(true);
			}
			if(e.getSource()==jb1){
	    		dispose();
	    		DataOperator d=new DataOperator();
	    		if(d.changePassword(jtf1.getText(),jtf2.getText(),jtf3.getText(),jpf1.getText(),jpf2.getText(),jpf3.getText())){
	    			RecomposeSuccess a=new RecomposeSuccess();
	    		}
	    		else{
	    			RecomposeFail b=new RecomposeFail();
	    		}
	    		//AtmWindow a=new AtmWindow();
	    		//a.setVisible(true);
			}
		}
}