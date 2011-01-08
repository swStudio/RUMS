package users;
/**
 * ע����壬�����û���ע������
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

//import client.ClientPanel;

public class Register extends JDialog implements ItemListener,ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel1 = new JPanel();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JLabel jLabel7 = new JLabel();
    JLabel jLabel8 = new JLabel();
    JLabel jLabel9 = new JLabel();
    JPanel jPanel1 = new JPanel();
    Border border1 = BorderFactory.createLineBorder(UIManager.getColor(
            "EditorPane.selectionBackground"), 1);
    Border border2 = new TitledBorder(border1, "����ϸ��д������Ϣ");
    JTextField userId = new JTextField();
    JTextField email = new JTextField();
    JTextField address = new JTextField();
    JTextArea introduceMe = new JTextArea();
    ButtonGroup group = new ButtonGroup();
    JRadioButton men = new JRadioButton();
    JRadioButton women = new JRadioButton();
    DefaultComboBoxModel yearModel = new DefaultComboBoxModel();
    DefaultComboBoxModel monthModel = new DefaultComboBoxModel();
    JComboBox year = new JComboBox();
    JLabel jLabel10 = new JLabel();
    JComboBox month = new JComboBox();
    JLabel jLabel11 = new JLabel();
    JPanel jPanel2 = new JPanel();
    JButton reset = new JButton();
    JButton submit = new JButton();
    JLabel jLabel12 = new JLabel();
    JLabel jLabel13 = new JLabel();
    JLabel jLabel14 = new JLabel();
    JLabel jLabel15 = new JLabel();
    JLabel imageLabel = new JLabel();
    JScrollPane iconScrollPane = new JScrollPane();
    JList pictureList = new JList();
    BorderLayout borderLayout1 = new BorderLayout();
    FlowLayout flowLayout1 = new FlowLayout();
    BorderLayout borderLayout2 = new BorderLayout();
    FlowLayout xYLayout1 = new FlowLayout();
    String file_separate = System.getProperty("file.separator");
    
    String sex = "��"; //��¼�û�ѡ����Ա�

    //InetAddress logAddress = null;//������IP
    //int serverPort = 0;//�������˿�

    JPasswordField password = new JPasswordField();
    JPasswordField configPassword = new JPasswordField();
    
    public Register(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        jLabel5.setBounds(new Rectangle(41, 165, 61, 15));
        jLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
       
    }

    public Register() {
        this(new Frame(), "ע�����û�", false);
    }

    private void InitialDialog() throws Exception {
        border2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,
                new Color(164, 163, 165)), "����ϸ��д������Ϣ");
        panel1.setLayout(borderLayout2);
        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel1.setText("     �û�����");
        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel2.setText("         ���룺");
        jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel3.setText("ȷ�����룺");
        jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel4.setText("�Ա�         ");
        jLabel5.setBounds(new Rectangle(24, 165, 78, 15));
        jLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel5.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel5.setText("�������ڣ�");
        jLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel6.setText("        ��ַ��");
        jLabel7.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel7.setText("        ���䣺");
        jLabel9.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel9.setText("���ҽ��ܣ�");
        jPanel1.setBorder(border2);
        jPanel1.setLayout(xYLayout1);
        men.setSelected(true);
        men.setText("��");
        men.addItemListener(this);
        women.setSelected(false);
        women.setText("Ů");
        women.addItemListener(this);
        jLabel10.setText("��");
        jLabel11.setText("��");
        jPanel2.setLayout(flowLayout1);
        reset.setText("����");
        reset.addActionListener(this);
        submit.setText("�ύ");
        submit.addActionListener(this);
        jLabel12.setForeground(Color.red);
        jLabel12.setText("*����Ϊ4-12���ַ�");
        jLabel13.setForeground(Color.red);
        jLabel13.setText("*���ֻ���ĸ������4-12λ");
        jLabel14.setForeground(Color.red);
        jLabel14.setText("*����������������һ��");
        jLabel15.setForeground(Color.red);
        jLabel15.setText("*�Ϸ��ĵ��������ַ");
        this.getContentPane().setLayout(borderLayout1);
        jPanel2.setBorder(BorderFactory.createEtchedBorder());
        flowLayout1.setHgap(50);
        iconScrollPane.setVerticalScrollBarPolicy(JScrollPane.
                                                  VERTICAL_SCROLLBAR_NEVER);
        this.getContentPane().add(panel1, java.awt.BorderLayout.CENTER);
        jPanel2.add(submit, null);
        jPanel2.add(reset, null);
        panel1.add(jPanel1, java.awt.BorderLayout.CENTER);
        panel1.add(jPanel2, java.awt.BorderLayout.SOUTH);
        for (int i = 1986; i <= Calendar.getInstance().get(Calendar.YEAR); i++) {
            yearModel.addElement(i);
        }
        for (int j = 1; j <= 12; j++) {
            monthModel.addElement(j);
        }
        year.setModel((ComboBoxModel) yearModel);
        month.setModel((ComboBoxModel) monthModel);
        pictureList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        this.setResizable(false);
        jPanel1.add(jLabel1);
        userId.setColumns(12);
        jPanel1.add(userId);
        jPanel1.add(jLabel2);
        password.setColumns(12);
        jPanel1.add(password);
        jPanel1.add(jLabel3);
        configPassword.setColumns(12);
        jPanel1.add(configPassword);
        jPanel1.add(jLabel4);
        group.add(women);
        group.add(men);
        jPanel1.add(men);
        jPanel1.add(women);
        
        jPanel1.add(jLabel5);
        jPanel1.add(year);
        jPanel1.add(jLabel10);
        jPanel1.add(month);
        jPanel1.add(jLabel11);
        jPanel1.add(jLabel6);
        address.setColumns(12);
        jPanel1.add(address);
        
        jPanel1.add(jLabel7);
        email.setColumns(12);
        jPanel1.add(email);      
        jPanel1.add(jLabel9);
        introduceMe.setColumns(12);
        introduceMe.setRows(3);
        jPanel1.add(introduceMe);
   
    }

    public void submit_actionPerformed(ActionEvent e) {
        String name = userId.getText().trim();
        String passwordInfo = new String(password.getPassword()).trim();
        String configPasswordInfo = new String(configPassword.getPassword()).
                                    trim();
        String info = introduceMe.getText().trim();
        String sexInfo = sex;
        String birthday = year.getSelectedItem().toString() + "-" +
                          month.getSelectedItem().toString();
        String place = address.getText().trim();
        String emailInfo = email.getText().trim();

        int nameLength = name.length(); //�ⶨ�û����ĳ���
        int passwordLength = passwordInfo.length(); //�ⶨ����ĳ���
        if (name == null || name.equals("")) {
            JOptionPane.showMessageDialog(this, "�û�������Ϊ�գ�");
            userId.requestFocus();
        } else if (!passwordInfo.equals(configPasswordInfo)) {
            JOptionPane.showMessageDialog(this, "������������벻һ�£�");
        } else if (nameLength > 12 || nameLength < 4) {
            JOptionPane.showMessageDialog(this, "�û����ĳ��Ȳ�����Ч��Χ֮�ڣ�");
            userId.setText("");
            userId.requestFocus();
        } else if (passwordLength > 12 || passwordLength < 4) {
            JOptionPane.showMessageDialog(this, "����ĳ��Ȳ�����Ч��Χ֮�ڣ�");
            password.setText("");
            configPassword.setText("");
            password.requestFocus();
        } else if (emailInfo == "" || emailInfo.indexOf('@') == -1 ||
                   emailInfo.indexOf('.') == -1) {
            JOptionPane.showMessageDialog(this, "��������ȷ��e-mail��ַ��");
            email.requestFocus();
        }else if(place.equals("")||info.equals("")){
            JOptionPane.showMessageDialog(this, "������Ϣ��������");
        }
        else {
            long qqnum = registerNewUser(name, passwordInfo, info,
                                        sexInfo, emailInfo, place,
                                        birthday);
            if (qqnum == 0) {
                JOptionPane.showMessageDialog(this, "ע��ʧ��!");
            } else {
                JOptionPane.showMessageDialog(this, "ע��ɹ������QQ����Ϊ��" + qqnum);
            }
        }
    }

    public long registerNewUser(String name, String password, String info,
                               String sex, String email,
                               String place, String birthday) {
        long qqnum = 0;
        String serverInfo = "";
        try {
            //�����׽ӿ�
            Socket socket = new Socket();
            //����������
            DataInputStream in = new DataInputStream(socket.getInputStream());
            //���������
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            //�����������ע�����û�������
            out.writeUTF("registerNewUser");
            //�����������ע���û�����Ϣ
            out.writeUTF(name);
            out.writeUTF(password);
            out.writeUTF(info);
            out.writeUTF(sex);
            out.writeUTF(email);
            out.writeUTF(place);
            out.writeUTF(birthday);
            //��ȡ�û�ע���ѧ��
            serverInfo = in.readUTF();
            if (serverInfo.equals("registerFail")) {
                return 0;
            } else {
                qqnum = in.readInt();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return qqnum;
    }

    public void reset_actionPerformed(ActionEvent e) {
        userId.setText("");
        password.setText("");
        configPassword.setText("");
        introduceMe.setText("");
        men.setSelected(true);
        year.setSelectedIndex(0);
        month.setSelectedIndex(0);
        address.setText("");
        email.setText("");
    }

    public void radioButton_itemStateChanged(ItemEvent e) {
        if (men.isSelected()) {
            sex = "��";
        } else if (women.isSelected()) {
            sex = "Ů";
        }
    }
    
    public void itemStateChanged(ItemEvent e) {
        radioButton_itemStateChanged(e);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==reset)
          reset_actionPerformed(e);
        else if (e.getSource() == submit)  
          submit_actionPerformed(e);
    }   
    
    public static void main(String[] args) throws Exception {
		Register newUser = new Register();
		newUser.InitialDialog();
		newUser.setBounds(500, 250, 240, 380);
		newUser.setVisible(true);
	}
}
