package newatm;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SaveWindow extends JFrame implements ActionListener
{

	     //�������
		JButton jb1,jb2,jb3=null;
		JPanel jp1,jp2,jp3=null;
		JLabel jlb1=null;
		static JTextField jtf1=null; 
	
	    //���캯��
		public SaveWindow()    //��������Ϊvoid!!!!!���򵯲����½���
		{
			//���ñ���  
	        super("�ű�����");  //setTile("");
	        //���ô�С  
			init();
		    setSize(1000,700);  //setBounds(1,1,1,1) 
	        //����λ��  
	        setLocation(200,150);  
	        //����ͼƬ��·���������·�����߾���·��������ͼƬ����"java��Ŀ��"���ļ��£�  
	        String path = "����.jpg";  
	        // ����ͼƬ  
	        ImageIcon background = new ImageIcon(path);  
	        // �ѱ���ͼƬ��ʾ��һ����ǩ����  
	        JLabel label = new JLabel(background);  
	        // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������  
	        label.setBounds(0, 0, this.getWidth(), this.getHeight());  
	        // �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��  
	        JPanel imagePanel = (JPanel) this.getContentPane();  
	        imagePanel.setOpaque(false);  
	        // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����  
	        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
	        //���ÿɼ�  
	        setVisible(true);  
	        //��رհ�ťʱ�˳�  
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
}
		public void init(){
		jb1=new JButton("  ȷ   ��    ");
		jb2=new JButton("�������˵�");
		
		jlb1=new JLabel("�����:");
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
		    icon = new ImageIcon("����.jpg");
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
			//�������

			
			jb1=new JButton("  ȷ   ��    ");
			jb2=new JButton("�������˵�");
	        jlb1=new JLabel("�ɴ����:");
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
			
			fr.setTitle("�ű�����");
			//jp2=new JPanel();
			fr.setVisible(true);
		    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    fr.setLocation(200,150);                  //�ô��������ʾ
			 //���ü���  
	        jb1.addActionListener(this);  
	        jb2.addActionListener(this);  
	        

			
	        
	      //���ò��ֹ�����
			//this.setLayout(null);
			//this.setTitle("�ű�����");
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
	        
			
