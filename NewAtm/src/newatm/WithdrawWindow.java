package newatm;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class WithdrawWindow extends JFrame implements ActionListener
{

	     //�������
		JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8=null;
		JPanel jp1,jp2=null;
		JLabel jlb1,jlb2=null;
		ImageIcon icon;
		Image image;
		//static JTextField jtf1=null; 
		static JTextField jtf1=new JTextField(5);
	
	    //���캯��
		public WithdrawWindow()    //��������Ϊvoid!!!!!���򵯲����½���
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
			//jp1=new JPanel();
			//jp2=new JPanel(null);
			//jp3=new JPanel();
			
			
			
			/*jlb1=new JLabel("����ѡ�������ȡ����");
			jlb2=new JLabel("���������ṩ���Ϊ100��ֽ��");*/
			
	        public void init(){
	        	jb1=new JButton("  100  ");
				jb2=new JButton("  300  ");
				jb3=new JButton("  500  ");
				jb4=new JButton(" �����˵�  ");
				jb5=new JButton("  1000  ");
				jb6=new JButton("  2000  ");
				jb7=new JButton("  3000  ");
				jb8=new JButton("  ȷ��    ");
				
				jlb1=new JLabel("�Զ���ȡ����");
		        jlb1.setFont(new   java.awt.Font("Dialog",   1,   25));
		        jlb1.setForeground(Color.red);
		        
				jlb2=new JLabel("ע��ȡ�������Ϊ100������");
				jlb2.setFont(new   java.awt.Font("Dialog",   1,   20));
		        jlb2.setForeground(Color.white);
		        
				
				
	    	    Box baseBox,b;
	    	    Box vBox = Box.createVerticalBox();
	    	    Box hBox = Box.createHorizontalBox();
	    	    Box hBox2 = Box.createHorizontalBox();
	    	    Box hBox4 = Box.createHorizontalBox();
	    	    Box hBox3 = Box.createHorizontalBox();
	    	    
	    	    //hBox2.add(Box.createHorizontalStrut(100));
	    	    hBox2.add(jlb1);
	    	    hBox4.add(Box.createHorizontalStrut(100));
	    	    hBox4.add(jlb2);
	    	    hBox2.add(Box.createHorizontalStrut(50));
	    	    hBox2.add(jtf1);
	    	    hBox2.add(Box.createHorizontalStrut(50));
	    	    hBox.add(jb1);
	    	    hBox.add(Box.createHorizontalStrut(50));
	    	    hBox.add(jb2);
	    	    hBox.add(Box.createHorizontalStrut(50));
	    	    hBox.add(jb3);
	    	    hBox.add(Box.createHorizontalStrut(50));
	    	    hBox.add(jb4);
	    	    hBox3.add(Box.createHorizontalStrut(50));
	    	    hBox3.add(jb5);
	    	    hBox3.add(Box.createHorizontalStrut(50));
	    	    hBox3.add(jb6);
	    	    hBox3.add(Box.createHorizontalStrut(50));
	    	    hBox3.add(jb7);
	    	    hBox3.add(Box.createHorizontalStrut(50));
	    	    hBox3.add(jb8);
	    	    vBox.add(Box.createVerticalStrut(300));
	    	    vBox.add(hBox2);
	    	    vBox.add(Box.createVerticalStrut(20));
	    	    vBox.add(hBox4);
	    	    vBox.add(Box.createVerticalStrut(100));
	    	    vBox.add(hBox);
	    	    vBox.add(Box.createVerticalStrut(100));
	    	    vBox.add(hBox3);
	    	    vBox.add(Box.createVerticalStrut(100));
	    	    b=Box.createHorizontalBox();
	    	    b.add(Box.createVerticalStrut(5));
	    	    b.add(vBox);
	    	    baseBox=Box.createVerticalBox();
	    	    baseBox.add(b);
	    	    add(baseBox); 
	    	    //���ü���  
		        jb1.addActionListener(this);  
		        jb2.addActionListener(this);  
		        jb3.addActionListener(this);  
		        jb4.addActionListener(this);  
		        
		        jb5.addActionListener(this);  
		        jb6.addActionListener(this);  
		        jb7.addActionListener(this);  
		        jb8.addActionListener(this);  
		        
	        }
	    	    
			
	        //���ð�ťλ��
	        /*jb1.setBounds(1,40,120,50);
	        jb2.setBounds(1,150,120,50);
	        jb3.setBounds(1,260,120,50);
	        jb4.setBounds(1,370,120,50);
	        
	        jb5.setBounds(562,40,120,50);
	        jb6.setBounds(562,150,120,50);
	        jb7.setBounds(562,260,120,50);
	        jb8.setBounds(562,370,120,50);*/
			//this.add(jp1);
			//this.add(jp4);
			//this.add(jp3);
			
			//���ò��ֹ�����
			/*this.setLayout(new GridLayout(1,1));
			this.setTitle("�ű�����");
			this.setSize(700,500);
			this.setLocation(200,150);		
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
			this.setResizable(false); */

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==jb1){
				DataOperator b= new DataOperator();
				b.Withdraw(100);
	    		dispose();
	    		//WaitingWindow a=new WaitingWindow();
	    		//a.setVisible(true);
	    		//dispose();
	    		WithdrawSuccess c=new WithdrawSuccess();
	    		c.setVisible(true);
			}
			else if(e.getSource()==jb2){
				DataOperator b= new DataOperator();
				b.Withdraw(300);
	    		dispose();
	    		//WaitingWindow a=new WaitingWindow();
	    		//a.setVisible(true);
	    		WithdrawSuccess c=new WithdrawSuccess();
	    		c.setVisible(true);
			}
			else if(e.getSource()==jb3){
				DataOperator b= new DataOperator();
				b.Withdraw(500);
	    		dispose();
	    		//WaitingWindow a=new WaitingWindow();
	    		//a.setVisible(true);
	    		WithdrawSuccess c=new WithdrawSuccess();
	    		c.setVisible(true);
			}
			else if(e.getSource()==jb4){
	    		dispose();
	    		AtmWindow a=new AtmWindow();
	    		a.setVisible(true);
			}
			else if(e.getSource()==jb5){
				DataOperator b= new DataOperator();
				b.Withdraw(1000);
	    		dispose();
	    		//WaitingWindow a=new WaitingWindow();
	    		//a.setVisible(true);
	    		WithdrawSuccess c=new WithdrawSuccess();
	    		c.setVisible(true);
			}
			else if(e.getSource()==jb6){
				DataOperator b= new DataOperator();
				b.Withdraw(2000);
	    		dispose();
	    		//WaitingWindow a=new WaitingWindow();
	    		//a.setVisible(true);
	    		WithdrawSuccess c=new WithdrawSuccess();
	    		c.setVisible(true);
			}
			else if(e.getSource()==jb7){
				DataOperator b= new DataOperator();
				b.Withdraw(3000);
	    		dispose();
	    		//WaitingWindow a=new WaitingWindow();
	    		//a.setVisible(true);
	    		WithdrawSuccess c=new WithdrawSuccess();
	    		c.setVisible(true);
			}
			else if(e.getSource()==jb8){
				DataOperator b= new DataOperator();
				String d=jtf1.getText();
				float f;
				f = Float.parseFloat(d);
				if(f%100==0){
					dispose();
		    		WithdrawWarning a=new WithdrawWarning();
		    		a.setVisible(true);
				}
				else{
					WithdrawFail h=new WithdrawFail();
					dispose();
				}
	    		
			}
		}
}
