package newatm;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TransferWindow extends JFrame implements ActionListener
{
	//�����¼��������  
    JButton jb1,jb2=null;  //��ť
    JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7=null;  //���
    static JTextField jtf1,jtf2,jtf3=null;     //�ı�
    JLabel jlb1,jlb2,jlb3,jlb4,jlb5,jlb6=null;  //��ǩ
    JPasswordField jpf1,jpf2,jpf3=null;  //����
    //ButtonGroup bg=null;
    ImageIcon icon;
    Image image;
	
	    //���캯��
    public TransferWindow()    //��������Ϊvoid!!!!!���򵯲����½���
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
	
	jlb1=new JLabel("ת���˺�:");   
	jlb2=new JLabel("ȷ���˺�:"); 
	jlb3=new JLabel("ת�����:");

	
	jlb1.setFont(new   java.awt.Font("Dialog",   1,   15));
    jlb1.setForeground(Color.white);
    
    jlb2.setFont(new   java.awt.Font("Dialog",   1,   15));
    jlb2.setForeground(Color.white);
    
    jlb3.setFont(new   java.awt.Font("Dialog",   1,   15));
    jlb3.setForeground(Color.white);
       
    
    jtf1=new JTextField(10); 
    jtf2=new JTextField(10); 
    jtf3=new JTextField(10); 
  
    Box baseBox,b;
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
	    		DataOperator b=new DataOperator();
	    		float weight = Float.parseFloat(jtf3.getText());
	    		if(b.Transfer(jtf1.getText(),jtf2.getText(),weight)){
	    			TransferWarning a=new TransferWarning();
		    		a.setVisible(true);
	    		}else{
	    			TransferFail c=new TransferFail();
	    		}
	    		
			}
		}
}