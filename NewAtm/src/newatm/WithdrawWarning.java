package newatm;

import javax.swing.*;  

import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  

public class WithdrawWarning extends JFrame implements ActionListener {  
  
    //�����¼��������  
    JButton jb1,jb2=null;  //��ť
    JPanel jp1,jp2,jp3,jp4=null;  //���
    //JTextField jtf=null;     //�ı�
    JLabel jlb1=null;  //��ǩ
    //JPasswordField jpf=null;  //����
    ButtonGroup bg=null;     
	DataOperator c=new DataOperator();
    //���캯��  
    public WithdrawWarning()  
    {  
         //�������  
        jb1=new JButton("ȡ��");  
        jb2=new JButton("ȷ��");   
        //���ü���  
        jb1.addActionListener(this);  
        jb2.addActionListener(this);  
        
          
        jp1=new JPanel();  
        jp2=new JPanel();
        jlb1=new JLabel("��ȡ��Ľ��Ϊ��"+WithdrawWindow.jtf1.getText()+" Ԫ��");
          
        
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
