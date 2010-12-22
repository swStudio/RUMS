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
	public String trueID = null;   //表示若用户名和密码正确之后返回的用户名。
 
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
	  username = new JTextField(8);         //学号必须为8位
	  password = new JPasswordField(8);     //密码默认是8位，修改了也只能是八位
	 
	  button_OK = new JButton("确定");
	  button_Cancel = new JButton("取消");
	  
	  labelOfUsername = new JLabel("学号");
	  labelOfPassword = new JLabel("密码");
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
			//JOptionPane.showMessageDialog(null,"用户名不存在，请重新输入","错误", JOptionPane.PLAIN_MESSAGE);
		}*/
		try {
			if(!worningOfCantFindUserInDatabase())
				try {
					getTrueNameFromDatabase(resultset.getString(1));
					System.out.println(trueID);
					JOptionPane.showMessageDialog(null,"恭喜你登录成功","成功", JOptionPane.PLAIN_MESSAGE);
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
			JOptionPane.showMessageDialog(null,"用户名不存在，请重新输入","错误", JOptionPane.PLAIN_MESSAGE);
		    return true;
		}
		else
		if(!resultset.getString(2).equals(pass) && isLengthOfPasswordLegal())
		{   
			JOptionPane.showMessageDialog(null,"用户输入密码错误，请重新输入","错误", JOptionPane.PLAIN_MESSAGE);
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
		//resultset.next();//这一步很重要，耽误了我很久的时间，就是因为没有向下移动，这时候找不到当前行。
	}
	
	private void worningOfLengthProblem() {
		if(!isLengthOfUsernameLegal())
		{
			JOptionPane.showMessageDialog(null,"用户名长度不正确","错误", JOptionPane.PLAIN_MESSAGE);
		}
		if(!isLengthOfPasswordLegal() && isLengthOfUsernameLegal())
		{
			JOptionPane.showMessageDialog(null,"密码长度不正确","错误", JOptionPane.PLAIN_MESSAGE);
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
    {    //用户名密码不为空
    	 if (isUsernameEmpty())
    	 {
	         JOptionPane.showMessageDialog(null,"用户名为空，请重新输入","错误", JOptionPane.PLAIN_MESSAGE);
	     }
		 if(isPasswordEmpty() && !isUsernameEmpty())
		 {
			 JOptionPane.showMessageDialog(null,"密码为空，请重新输入","错误", JOptionPane.PLAIN_MESSAGE);
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