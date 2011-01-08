package users;
/**
 * 注册面板，用于用户的注册请求
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
    Border border2 = new TitledBorder(border1, "请仔细填写以下信息");
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
    
    String sex = "男"; //记录用户选择的性别

    //InetAddress logAddress = null;//服务器IP
    //int serverPort = 0;//服务器端口

    JPasswordField password = new JPasswordField();
    JPasswordField configPassword = new JPasswordField();
    
    public Register(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        jLabel5.setBounds(new Rectangle(41, 165, 61, 15));
        jLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
       
    }

    public Register() {
        this(new Frame(), "注册新用户", false);
    }

    private void InitialDialog() throws Exception {
        border2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,
                new Color(164, 163, 165)), "请仔细填写以下信息");
        panel1.setLayout(borderLayout2);
        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel1.setText("     用户名：");
        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel2.setText("         密码：");
        jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel3.setText("确认密码：");
        jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel4.setText("性别：         ");
        jLabel5.setBounds(new Rectangle(24, 165, 78, 15));
        jLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel5.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel5.setText("出生日期：");
        jLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel6.setText("        地址：");
        jLabel7.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel7.setText("        邮箱：");
        jLabel9.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel9.setText("自我介绍：");
        jPanel1.setBorder(border2);
        jPanel1.setLayout(xYLayout1);
        men.setSelected(true);
        men.setText("男");
        men.addItemListener(this);
        women.setSelected(false);
        women.setText("女");
        women.addItemListener(this);
        jLabel10.setText("年");
        jLabel11.setText("月");
        jPanel2.setLayout(flowLayout1);
        reset.setText("重置");
        reset.addActionListener(this);
        submit.setText("提交");
        submit.addActionListener(this);
        jLabel12.setForeground(Color.red);
        jLabel12.setText("*长度为4-12个字符");
        jLabel13.setForeground(Color.red);
        jLabel13.setText("*数字或字母，长度4-12位");
        jLabel14.setForeground(Color.red);
        jLabel14.setText("*两次输入的密码必须一致");
        jLabel15.setForeground(Color.red);
        jLabel15.setText("*合法的电子邮箱地址");
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

        int nameLength = name.length(); //测定用户名的长度
        int passwordLength = passwordInfo.length(); //测定密码的长度
        if (name == null || name.equals("")) {
            JOptionPane.showMessageDialog(this, "用户名不能为空！");
            userId.requestFocus();
        } else if (!passwordInfo.equals(configPasswordInfo)) {
            JOptionPane.showMessageDialog(this, "两次输入的密码不一致！");
        } else if (nameLength > 12 || nameLength < 4) {
            JOptionPane.showMessageDialog(this, "用户名的长度不在有效范围之内！");
            userId.setText("");
            userId.requestFocus();
        } else if (passwordLength > 12 || passwordLength < 4) {
            JOptionPane.showMessageDialog(this, "密码的长度不在有效范围之内！");
            password.setText("");
            configPassword.setText("");
            password.requestFocus();
        } else if (emailInfo == "" || emailInfo.indexOf('@') == -1 ||
                   emailInfo.indexOf('.') == -1) {
            JOptionPane.showMessageDialog(this, "请输入正确的e-mail地址！");
            email.requestFocus();
        }else if(place.equals("")||info.equals("")){
            JOptionPane.showMessageDialog(this, "输入信息不完整！");
        }
        else {
            long qqnum = registerNewUser(name, passwordInfo, info,
                                        sexInfo, emailInfo, place,
                                        birthday);
            if (qqnum == 0) {
                JOptionPane.showMessageDialog(this, "注册失败!");
            } else {
                JOptionPane.showMessageDialog(this, "注册成功！你的QQ号码为：" + qqnum);
            }
        }
    }

    public long registerNewUser(String name, String password, String info,
                               String sex, String email,
                               String place, String birthday) {
        long qqnum = 0;
        String serverInfo = "";
        try {
            //定义套接口
            Socket socket = new Socket();
            //定义输入流
            DataInputStream in = new DataInputStream(socket.getInputStream());
            //定义输出流
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            //向服务器发送注册新用户的申请
            out.writeUTF("registerNewUser");
            //向服务器发送注册用户的信息
            out.writeUTF(name);
            out.writeUTF(password);
            out.writeUTF(info);
            out.writeUTF(sex);
            out.writeUTF(email);
            out.writeUTF(place);
            out.writeUTF(birthday);
            //读取用户注册的学号
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
            sex = "男";
        } else if (women.isSelected()) {
            sex = "女";
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
