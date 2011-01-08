package client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import users.ModifyInformation;
import users.User;

public class ClientPanel extends JFrame implements ActionListener,MouseListener{
	
	private ServerSocket server;
	private Socket client;
	
	private Thread chart = null;
	
	static ClientPanel clientpanel;
	
	private Font font = new Font("����",Font.PLAIN,12);
	
	private JLabel label1 = new JLabel("");
	private JLabel label2 = new JLabel("�ǳƣ�");
	private JLabel label3 = new JLabel("�Ա�");
	private JLabel label4 = new JLabel("ѧ�ţ��ʺţ���");
	private JLabel label5 = new JLabel("������");
	private JLabel label6 = new JLabel("���Ѷ�̬��");
	private JLabel label7 = new JLabel("����>>");
	
	private JButton change = new JButton("����ͼƬ");
	private JButton scan = new JButton("���>>");
	private JButton modified = new JButton("�޸�");
	private JButton settings = new JButton("����");
	private JButton button3 = new JButton("ѧϰ����");
	private JButton button4 = new JButton("��������");
	private JButton button5 = new JButton("�Ļ�����");
	private JButton button6 = new JButton("̸��˵��");
	private JButton button7 = new JButton("��������");
	private JButton button8 = new JButton("��������");
	
	private JTextField textfield1 = new JTextField("�����Ǹû����Ϣ��");
	private JTextField textfield2 = new JTextField("    \n    \n    \n");
	private JTextField textfield3 = new JTextField("    \n    \n    \n");
	
	private JTree friendsList = new JTree();
	
	private JMenu[] menu = {new JMenu("�ҵ�����"), new JMenu("���ܽ���"), new JMenu("����"), new JMenu("��������")};
	
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JPanel panel5 = new JPanel();
	private JPanel panel6 = new JPanel();
	private JPanel panel7 = new JPanel();
	private JPanel panel8 = new JPanel();
	private JPanel panel9 = new JPanel();
	private JPanel panel_client = new JPanel(null);
	
	private ImageIcon imageicon;
	
	//private ImagePanel headimage = new ImagePanel("MAN.jpg");
	Container container = this.getContentPane();
	
	public ClientPanel()
	{			
		this.setTitle("��У����ƽ̨2011");
		this.setResizable(false);
		this.setExtendedState(ClientPanel.MAXIMIZED_BOTH);
		this.setBounds(0, 0, 800, 600);		
		//this.setBounds(0, 0, 1024, 768);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setVisible(true);
		
		JMenuBar mb = new JMenuBar();
		for (JMenu m : menu)
			mb.add(m);
		//mb.setFont(font);
		mb.setOpaque(false);
		this.setJMenuBar(mb);
		
		this.setLayout(new GridLayout(3,3,20,20));
		
		/*this.AddHead();
		this.AddInfo();
		panel_client.setBackground(new Color(225,245,253));
		panel_client.add(panel1);*/
		panel1.setLayout(new GridLayout(2,2));
		imageicon = new ImageIcon("MAN.jpg");
		JLabel head = new JLabel(imageicon,JLabel.CENTER);
		head.setIcon(imageicon);
		panel1.add(head);
		panel1.add(label1);
		panel1.add(change);
		change.addActionListener(this);
		change.addMouseListener(this);
		panel1.add(scan);
		scan.addActionListener(this);
		scan.addMouseListener(this);
		panel1.setLocation(0, 0);
		this.add(panel1);
		
		panel2.add(button3);
		panel2.add(button4);
		panel2.add(button5);
		panel2.add(button6);
		this.add(panel2);
	
		panel3.add(button8);
		this.add(panel3);
		
		panel4.setLayout(new GridLayout(5,2));
		panel4.add(label2);
		panel4.add(label1);
		panel4.add(label3);
		panel4.add(label1);
		panel4.add(label4);
		panel4.add(label5);
		panel4.add(label1);
		panel4.add(modified);
		modified.addActionListener(this);
		panel4.add(settings);
		this.add(panel4);
		
		panel5.add(textfield1);
		panel5.setBorder(new TitledBorder("���Ϣ>>��"));
		this.add(panel5);
		
		panel6.add(button8);
		this.add(panel6);
		 
		panel7.add(textfield1);
		panel7.add(label7);
		panel7.add(textfield2);
		this.add(panel7);
		
		panel8.add(textfield2);
		panel8.add(button7);
		this.add(panel8);
		
		panel9.add(friendsList);
		this.add(panel9);
		
		
	}
	
	public User FindUsers(int i)
	{
		return null;
	}
	
	public void AddHead()
	{
		
	}
		
	public void AddInfo()
	{
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClientPanel clientpanel1 = new ClientPanel();
		clientpanel1.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		/*if (e.getSource() == modified)
		{
			ModifyInformation modifiedinfo = new ModifyInformation();
	
		}
		else if (e.getSource() == settings)
		{
			
		}
		*/
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == modified)
		{
			new ModifyInformation();
	
		}
	}
}
