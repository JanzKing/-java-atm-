package newatm;

import java.awt.*;
import java.awt.event.*;
//import java.util.TimberTask.*;
import javax.swing.*;

public class WaitingWindow extends JFrame implements ActionListener
{
	//�����¼��������  
    JButton jb1,jb2=null;  //��ť
    JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7=null;  //���
    JTextField jtf1,jtf2,jtf3=null;     //�ı�
    JLabel jlb1,jlb2,jlb3,jlb4,jlb5,jlb6=null;  //��ǩ
    JPasswordField jpf1,jpf2,jpf3=null;  //����
    //ButtonGroup bg=null;
	
	    //���캯��
		public WaitingWindow()    //��������Ϊvoid!!!!!���򵯲����½���
		{
			//�������  
	        jp1=new JPanel();  
	        
	        jlb1=new JLabel("���ڳ�����Ժ�...");  
	        
	        jp1.add(jlb1);  
	
	        this.add(jp1);
	        
	      //���ò��ֹ�����
			this.setLayout(new GridLayout(7,1));
			this.setTitle("�ű�����");
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

    