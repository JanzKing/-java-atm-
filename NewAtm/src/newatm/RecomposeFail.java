package newatm;

import javax.swing.*;  

import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.sql.*;  

public class RecomposeFail extends JFrame implements ActionListener {  
  
    //�����¼��������  
    JButton jb1,jb2=null;  //��ť
    JPanel jp1,jp2,jp3,jp4=null;  //���
    //JTextField jtf=null;     //�ı�
    JLabel jlb1,jlb2=null;  //��ǩ
    //JPasswordField jpf=null;  //����  
    
    //���캯��  
    public RecomposeFail()  
    {  
         //�������  
        jb2=new JButton("ȷ��");   
        //���ü���  
        jb2.addActionListener(this);  
        
          
        jp1=new JPanel();  
        jp2=new JPanel();
        jlb1=new JLabel("�޸���Ϣ����");
        jlb2=new JLabel("��˶���Ϣ���ٴ�����");
          

        jp1.add(jlb1);
        jp1.add(jlb2);
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
        if(e.getSource()==jb2){
        	dispose();
        	RecomposeWindow g=new RecomposeWindow();
        }
     }
}