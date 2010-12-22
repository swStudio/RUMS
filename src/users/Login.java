package users;

import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

import database.Database;

public class Login extends JFrame
{
	private String name;
	private String pass;
	private JTextField username;
	private JPasswordField password;
	private JLabel labelOfUsername;
	private JLabel labelOfPassword;
	private JButton button_OK;
	private JButton button_Cancel;
	private Container container;
	private ResultSet resultset;
	public String trueID = null;   //��ʾ���û�����������ȷ֮�󷵻ص��û�����
 
 public Login()
 {
	 super("Login window");
	 setSize(280,230);
	 this.setResizable(false);
	 try{
		 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	 }catch (Exception e){}
	 
     container = getContentPane();
	 container.setLayout(null);
	 container.setBackground(Color.gray);
 }
 
 public String getTrueID()
 {
	 return trueID;
 }
 
 @SuppressWarnings("deprecation")
public String getPassword()
 {
	 return password.getText();
 }
 
 private void createComponent()
 {
	  username = new JTextField(8);         //ѧ�ű���Ϊ8λ
	  password = new JPasswordField(8);     //����Ĭ����8λ���޸���Ҳֻ���ǰ�λ
	 
	  button_OK = new JButton("ȷ��");
	  button_Cancel = new JButton("ȡ��");
	  
	  labelOfUsername = new JLabel("ѧ��");
	  labelOfPassword = new JLabel("����");
 }
 
private void addComponentToContainer()
 {
	 setTextProperty();
	 setTextProperty();
	 container.add(username);
	 container.add(password);	 
	 
	 setButtonProperty();
	 setButtonProperty();
	 container.add(button_OK);
	 container.add(button_Cancel);	 
	 
	 setLabelProperty();
	 setLabelProperty();	 
	 container.add(labelOfUsername);
	 container.add(labelOfPassword);
 }

private void setLabelProperty() {	
	labelOfUsername.setBounds(140, 50, 70, 25);
	labelOfPassword.setBounds(140, 85, 70, 25);
}

private void setButtonProperty() {
	button_OK.setBounds(50, 120, 60, 25);
	button_Cancel.setBounds(130, 120, 60, 25);
}

private void setTextProperty() {
	username.setBounds(80, 50, 60, 25);
	password.setBounds(80, 85, 60, 25);
	password.setEchoChar('*');
}

private void setPropertyOfContainer()
 {
	 container.setSize(300,150);
	 setVisible(true);
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }

 private void addActionListenerToButton()
 {
	 button_OK.addActionListener(new Listener_ok());
	 button_Cancel.addActionListener(new Listener_cancel());
 } 
 
 public void createLoginWindow()
 {
	 createComponent();
	 addComponentToContainer();
	 setPropertyOfContainer();
	 addActionListenerToButton();
 } 
  
class Listener_ok implements ActionListener 
{
     public void actionPerformed(ActionEvent e)
	 {
		 name = username.getText();
		 pass = password.getText();
		 worningOfEmptyUsernameAndPassWord();	
		 worningOfLengthProblem();
		 /*try {
			worningOfCantFindUserInDatabase();
		} catch (SQLException e1) {
			e1.printStackTrace();
			//JOptionPane.showMessageDialog(null,"�û��������ڣ�����������","����", JOptionPane.PLAIN_MESSAGE);
		}*/
		try {
			if(!worningOfCantFindUserInDatabase())
				try {
					getTrueNameFromDatabase(resultset.getString(1));
					System.out.println(trueID);
					JOptionPane.showMessageDialog(null,"��ϲ���¼�ɹ�","�ɹ�", JOptionPane.PLAIN_MESSAGE);
					setVisible(false);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				else {}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	 }
     
	private void getTrueNameFromDatabase(String truename) {
		trueID=truename;
	}

	private boolean worningOfCantFindUserInDatabase() throws SQLException {
		createDatabaseConnection();	
		if(!resultset.next() && !isPasswordEmpty() && isLengthOfPasswordLegal())
		{
			JOptionPane.showMessageDialog(null,"�û��������ڣ�����������","����", JOptionPane.PLAIN_MESSAGE);
		    return true;
		}
		else
		if(!resultset.getString(2).equals(pass) && isLengthOfPasswordLegal())
		{   
			JOptionPane.showMessageDialog(null,"�û����������������������","����", JOptionPane.PLAIN_MESSAGE);
		    return true;
		}			
		else
			return false;
	}
	
	private void createDatabaseConnection() throws SQLException {
		String drivername = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433; DatabaseName=try";
		String username = "sa";
		String userpass = "";
		String sql = "select number,password from users where number="+"'"+name+"'";
		Database dataBase = new Database();
		resultset = dataBase.creatResultSet(drivername,url,username,userpass,sql);
		//resultset.next();//��һ������Ҫ���������Һܾõ�ʱ�䣬������Ϊû�������ƶ�����ʱ���Ҳ�����ǰ�С�
	}
	
	private void worningOfLengthProblem() {
		if(!isLengthOfUsernameLegal())
		{
			JOptionPane.showMessageDialog(null,"�û������Ȳ���ȷ","����", JOptionPane.PLAIN_MESSAGE);
		}
		if(!isLengthOfPasswordLegal() && isLengthOfUsernameLegal())
		{
			JOptionPane.showMessageDialog(null,"���볤�Ȳ���ȷ","����", JOptionPane.PLAIN_MESSAGE);
		}		
	}
	private boolean isLengthOfPasswordLegal() {
		if(pass.length()>0 && pass.length()!=8)
		    return false;
		else
			return true;
	}
	private boolean isLengthOfUsernameLegal() {
		if(name.length()>0 && name.length()!=8)
		    return false;
		else
			return true;
	}
	
	private void worningOfEmptyUsernameAndPassWord() 
    {    //�û������벻Ϊ��
    	 if (isUsernameEmpty())
    	 {
	         JOptionPane.showMessageDialog(null,"�û���Ϊ�գ�����������","����", JOptionPane.PLAIN_MESSAGE);
	     }
		 if(isPasswordEmpty() && !isUsernameEmpty())
		 {
			 JOptionPane.showMessageDialog(null,"����Ϊ�գ�����������","����", JOptionPane.PLAIN_MESSAGE);
		 }		
	}
	private boolean isPasswordEmpty() {
		if(pass.compareTo("")==0)
           return true;
		else 
		   return false;
	}
	
	private boolean isUsernameEmpty() {
		if(name.compareTo("")==0)
			return true;
		else
		    return false;
	}	
 }
	  	  
 class Listener_cancel implements ActionListener 
 {
	   public void actionPerformed(ActionEvent e)
	   {
	       System.exit(1);
	   }
} 
 
 public static void main(String[] args) throws SQLException
 {
	 Login login = new Login();
	 login.createLoginWindow();
 }
 
}