package newatm;

import javax.swing.*;  

import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.sql.*;  

public class MainLogin extends JFrame implements ActionListener {  
  
    //�����¼��������  
    JButton jb1,jb2=null;  //��ť
    JPanel jp1,jp2,jp3,jp4=null;  //���
    static JTextField jtf=null;     //�ı�
    JLabel jlb1,jlb2=null;  //��ǩ
    JPasswordField jpf=null;  //����
    ButtonGroup bg=null;      
    
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        MainLogin  ms=new MainLogin(); 
    }
    
    //���캯��  
    public MainLogin()  
    {  
         //�������  
        jb1=new JButton("��¼");  
        jb2=new JButton("�˳�ϵͳ");   
        //���ü���  
        jb1.addActionListener(this);  
        jb2.addActionListener(this);  
        
          
        jp1=new JPanel();  
        jp2=new JPanel();  
        jp3=new JPanel();  
        jp4=new JPanel();                 
          
        jlb1=new JLabel("���ţ�");  
        jlb2=new JLabel("���룺");  
        jtf=new JTextField(10);  
        jpf=new JPasswordField(10);  
        //���뵽JPanel��  
        jp1.add(jlb1);  
        jp1.add(jtf);  
          
        jp2.add(jlb2);  
        jp2.add(jpf);  
          
        /*jp3.add(jlb3);  
        jp3.add(jrb1);  
        jp3.add(jrb2); */ 
          
        jp4.add(jb1);  
        jp4.add(jb2);  
        //jp4.add(jb3);  
          
        //����JFrame��  
        //this.setJMenuBar(jmb);  
        this.add(jp1);  
        this.add(jp2);  
        this.add(jp3);  
        this.add(jp4);  
        //���ò��ֹ�����  
        this.setLayout(new GridLayout(4,1));  
        //���������ñ���  
        this.setTitle("�ű�����");  
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
        DataOperator a=new DataOperator();
        a.loadDatabaseDriver();
        a.connect();
        
    	if(e.getSource()==jb1){
    		if(a.userQuery(jtf.getText().trim(),jpf.getText().trim()) > 0)  
            {   
                JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
                //this.clear();  
                //�رյ�ǰ����  
                 dispose();  
                 //����һ���½���  
                 AtmWindow ui=new AtmWindow(); 
            }
            else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())  
            {  
                JOptionPane.showMessageDialog(null,"�����뿨�ź����룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
            }else if(jtf.getText().isEmpty())  
            {  
            	JOptionPane.showMessageDialog(null,"�����뿨�ţ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
            }else if(jpf.getText().isEmpty())  
            {  
                JOptionPane.showMessageDialog(null,"���������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
            }else  
            {  
                JOptionPane.showMessageDialog(null,"���Ż����������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);  
                //��������  
               //this.clear();  
            } 
    	}
   
    	if(e.getSource()==jb2){
    		dispose();
    	}
    /*//����ı���������  
    public  void clear()  
        {  
            jtf.setText("");  
            jpf.setText("");  
        } */ 
}
   
            //�û���¼�жϷ���  
            /*public void stulogin()  
            {  
            	ActionEvent e;
            	if(e.getSource()==jb1){
                   if(DataOperate.userword.equals(jtf.getText())&&DataOperate.pwd.equals(jpf.getText()))  
                {   
                    JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
                    this.clear();  
                    //�رյ�ǰ����  
                     dispose();  
                     //����һ���½���  
                     AtmWindow ui=new AtmWindow();  
                }else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())  
                {  
                    JOptionPane.showMessageDialog(null,"�������û��������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
                }else if(jtf.getText().isEmpty())  
                {  
                    JOptionPane.showMessageDialog(null,"�������û�����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
                }else if(jpf.getText().isEmpty())  
                {  
                    JOptionPane.showMessageDialog(null,"���������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
                }else  
                {  
                    JOptionPane.showMessageDialog(null,"�û��������������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);  
                    //��������  
                    this.clear();  
                }  
            } */
            
              
}