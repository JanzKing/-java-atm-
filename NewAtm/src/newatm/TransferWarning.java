package newatm;

import javax.swing.*;  

import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  

public class TransferWarning extends JFrame implements ActionListener {  
  
    //�����¼��������  
    JButton jb1,jb2=null;  //��ť
    JPanel jp1,jp2,jp3,jp4=null;  //���
    //JTextField jtf=null;     //�ı�
    JLabel jlb1=null;  //��ǩ
    //JPasswordField jpf=null;  //����
    ButtonGroup bg=null;     
	DataOperator c=new DataOperator();
    //���캯��  
    public TransferWarning()  
    {  
         //�������  
        jb1=new JButton("ȡ��");  
        jb2=new JButton("ȷ��");   
        //���ü���  
        jb1.addActionListener(this);  
        jb2.addActionListener(this);  
        
          
        jp1=new JPanel();  
        jp2=new JPanel();
        jlb1=new JLabel("��ת�˵Ľ��Ϊ��"+TransferWindow.jtf3.getText()+" Ԫ��");
          
        
        jp1.add(jlb1);
        jp2.add(jb1);  
        jp2.add(jb2);  
        
        
        this.add(jp1);  
        this.add(jp2); 
        //���ò��ֹ�����  
        this.setLayout(new GridLayout(2,1));  
        //���������ñ���  
        this.setTitle("��ʾ��Ϣ");  
        //���ô����С  
        this.setSize(300,170);  
        //���ô����ʼλ��  
        this.setLocation(200, 150);  
        //���õ��رմ���ʱ����֤JVMҲ�˳�  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //��ʾ����  
        this.setVisible(true);  
        this.setResizable(false);  
      } 
    public void actionPerformed(ActionEvent e){
    	if(e.getSource()==jb1){
    		dispose();
    	}
    	else if(e.getSource()==jb2){
        	dispose();
        	String g=TransferWindow.jtf3.getText();
        	float c;
        	try{
        		c = Float.parseFloat(g);
        	}catch(Exception err){
        		c = 0;
        	}  	
        	DataOperator b=new DataOperator();
        	b.Withdraw(c);
            //dispose();
        	TranferSuccess t=new TranferSuccess();
        	//SaveWindow ui2=new SaveWindow();
        }
     }
}