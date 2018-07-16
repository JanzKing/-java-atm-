package newatm;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class RestWindow extends JFrame implements ActionListener
{

	     //�������
		JButton jb1,jb2,jb3=null;
		JPanel jp1,jp2=null;
		static JLabel jlb1,jlb2=null;
		ImageIcon icon;
	    //���캯��
		public RestWindow()    //��������Ϊvoid!!!!!���򵯲����½���
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
			
		DataOperator c = new DataOperator();
		jlb1=new JLabel(c.getAll());
		jlb1.setFont(new   java.awt.Font("Dialog",   1,   25));
        jlb1.setForeground(Color.white);
        
		jb1=new JButton("ת��");
		jb2=new JButton("ȡ��");
		jb3=new JButton("����");

        
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
		 //���ü���  
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
