package users;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import database.Database;

public class ModifyInformation extends JFrame{
	private Container container;
	private JTextField userName;
	private JLabel labelOfUserName;
	private String printUserName;
	private String presentUserName;
	
	private JTextField userNumber;
	private JLabel labelOfUserNumber;
	private String printNumber;
	
    private JPasswordField modifyPassword;
    private JLabel labelOfModifyPassword;
    private String printPassword;
   
    private JPasswordField comfirmPassword;
    private JLabel labelOfComfirmPassword;
    private String modifiedPassword;
    
	private JTextField gender;
	private JLabel labelOfGender;
	private String printGender;
	
	private JTextArea userMood;
	private JLabel labelOfUserMood;
	private String printMood;
	private String modifiedMood;
	
	private JComboBox addIntoGroup;	
	private JLabel labelOfAddIntoGroup;
	private String allGroups[];
	private String newAddGroup;
	
	private JComboBox deleteFromGroup;
	private JLabel labelOfDeleteGroup;
	private String hasInGroups[];
	private String newDeleteGroup;
	
	private JButton submit;
	private JButton cancel;
	
	//private ResultSet personalInformationResultSet;
	//private ResultSet activedGroupInformationResultSet;
	
	public ModifyInformation()
	{
		 super("修改个人信息");
		 setSize(500,400);
		 this.setResizable(false);
		 try{
			 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		 }catch (Exception e){}
		 
	     container = getContentPane();
		 //container.setLayout(new GridLayout(5,2));
	     container.setLayout(null);
		 container.setBackground(Color.getHSBColor(100, 100, 100));
		 //container.setBackground(getForeground());
	}
	
	private void getUserID()
	{
		//login Login = new login();
		presentUserName = "08386244";
	}
	
	private void getAllGroups()
	{
		allGroups = new String[20];
	}
	
	private void getActivedGroup()
	{
		hasInGroups = new String[20];
	}
	
	private void initialTextComponent() throws SQLException
	{
		 getPersonalInformationFromDatabase();
		 userName = new JTextField(printUserName); 
		 userNumber = new JTextField(printNumber,8);
         modifyPassword = new JPasswordField(printPassword,8);
		 comfirmPassword = new JPasswordField(printPassword,8);
		 gender = new JTextField(printGender,2);
		 userMood = new JTextArea(printMood,2,100);
	}
	
	private void initialLabelComponent()
	{
		labelOfUserName = new JLabel("姓名");
		labelOfUserNumber = new JLabel("学号");
		labelOfModifyPassword = new JLabel("输入密码");
		labelOfComfirmPassword = new JLabel("确认密码");	
		labelOfGender = new JLabel("性别");	
		labelOfUserMood = new JLabel("心情");
	    labelOfAddIntoGroup = new JLabel("所有组织");
		labelOfDeleteGroup = new JLabel("已选组织");
	}
	
	private void initialButton()
	{
		submit = new JButton("提交");
		cancel = new JButton("取消");
	}
	
	private void initialComboBox() throws SQLException
	{
		getAllGroups();
		getActivedGroup();
		getActivedGroupsFromDatabase();
		addIntoGroup = new JComboBox(allGroups);
		deleteFromGroup = new JComboBox(hasInGroups);
	}
	
	private void setTextProperty()
	{
		 userName.setBounds(100,50,60,25);
		 userName.setEditable(false);
		 
		 userNumber.setBounds(100,100,65,25);
		 userNumber.setEditable(false);
		 
		 modifyPassword.setBounds(100,150,65,25);
		 modifyPassword.setEchoChar('*');
		 
		 comfirmPassword.setBounds(100,200,65,25);
		 comfirmPassword.setEchoChar('*');
		 
		 gender.setBounds(100, 250, 25, 25);
		 gender.setEditable(false);
		 
		 userMood.setLineWrap(true);				
		 userMood.setWrapStyleWord(true);
		 userMood.setBounds(100,300,300,25);
	}
	
	private void setLabelProperty()
	{
		labelOfUserName.setBounds(50, 50, 65, 25);
		labelOfUserNumber.setBounds(50, 100, 65, 25);
		labelOfModifyPassword.setBounds(50, 150, 80, 25);
		labelOfComfirmPassword.setBounds(50,200, 80, 25);
		labelOfGender.setBounds(50, 250, 25, 25);
		labelOfUserMood.setBounds(50, 300, 65, 25);
		labelOfAddIntoGroup.setBounds(350, 70, 65, 25);
		labelOfAddIntoGroup.setFont(new Font("Serif",Font.PLAIN,14));
		labelOfDeleteGroup.setBounds(250, 70, 65, 25);
		labelOfDeleteGroup.setFont(new Font("Serif",Font.PLAIN,14));
	}
	
	private void setButtonProperty()
	{
		submit.setBounds(400, 250, 60, 25);
		cancel.setBounds(400, 300, 60, 25);
	}
	
	private void setComboBoxProperty()
	{
		addIntoGroup.setBounds(350, 100, 100, 25);
		addIntoGroup.setSelectedIndex(19);
		addIntoGroup.setFont(new Font("Serif",Font.PLAIN,14));
		deleteFromGroup.setBounds(250, 100, 100, 25);
		deleteFromGroup.setSelectedIndex(19);
		deleteFromGroup.setFont(new Font("Serif",Font.PLAIN,14));
	}
	
	private void addTextFieldToContainer() throws SQLException
	{
		initialTextComponent();
		setTextProperty();
		container.add(userName);
		container.add(userNumber);
		container.add(modifyPassword);
		container.add(comfirmPassword);
		container.add(gender);
		container.add(userMood);
	}

	private void addLabelToContainer()
	{
		initialLabelComponent();
		setLabelProperty();
		container.add(labelOfUserName);
		container.add(labelOfUserNumber);
		container.add(labelOfModifyPassword);
		container.add(labelOfComfirmPassword);
		container.add(labelOfGender);
		container.add(labelOfUserMood);
		container.add(labelOfAddIntoGroup);
		container.add(labelOfDeleteGroup);
	}
	
	private void addComboBoxToContainer() throws SQLException
	{
		initialComboBox();
		setComboBoxProperty();
		container.add(addIntoGroup);
		container.add(deleteFromGroup);
	}
	
	private void addButtonToContainer()
	{
		initialButton();
		setButtonProperty();
		container.add(submit);
		container.add(cancel);
	}
	
	private void addListenerToButton()
	{
	    submit.addActionListener(new Listen_submit());
	    cancel.addActionListener(new Listen_cancel());
	}
	
	private void addListenerToComboBox()
	{
		addIntoGroup.addItemListener(new addComboBoxHandler());
		deleteFromGroup.addItemListener(new deleteComboBoxHandler());
	}
	
	private class Listen_submit implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try {
				if(!isPasswordLengthLegal())
					JOptionPane.showConfirmDialog(null, "您输入的密码长度不正确，请重新输入");
				if(!ifTwoPasswordEquals())
					JOptionPane.showMessageDialog(null, "两次输入的密码错误，请重新输入","错误",JOptionPane.PLAIN_MESSAGE);
				if(isPasswordLengthLegal() && ifTwoPasswordEquals() && JOptionPane.showConfirmDialog(null, "确定保存你所做的修改吗？","提示",JOptionPane.YES_NO_OPTION) == 0)
				{	
					modifyPersonalInformation();	
					modifyGroupInformation();
					setVisible(false);
				}
			} catch (HeadlessException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		private void modifyGroupInformation() throws SQLException {
			String drivername = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String url = "jdbc:sqlserver://localhost:1433; DatabaseName=system_of_friends";
			String username = "sa";
			String userpass = "";
			String sqlToDeleteGroup = "delete from activeIn "+
			                          "where GID = (select groups.GID "+
					                  "from groups,activeIn "+
					                  "where activeIn.GID = groups.GID and activeIn.UID = '"+presentUserName+"' and group_name = '"+newDeleteGroup+"')";
			String sqlToAddGroup = "declare @a int "+
			                       "set @a = (select GID from groups where group_name = '"+newAddGroup+"') "+
			                                 "insert into activeIn values('08386244',@a )";
			Database database = new Database();
		    if(newDeleteGroup != null)
		    {
			    database.updateDataBase(drivername,url,username,userpass,sqlToDeleteGroup);
			    database.closeConnection();
		    }
		    if(newAddGroup != null)
		    {
		      	database.updateDataBase(drivername,url,username,userpass,sqlToAddGroup); 
		      	database.closeConnection();
		    }
		   
		}

		private boolean isPasswordLengthLegal() {
			if(modifyPassword.getText().length() !=8 )
			    return false;
			else
				return true;
		}

		@SuppressWarnings("deprecation")
		private void modifyPersonalInformation() throws SQLException {
			modifiedMood = userMood.getText();
			modifiedPassword = comfirmPassword.getText();	
			String drivername = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String url = "jdbc:sqlserver://localhost:1433; DatabaseName=system_of_friends";
			String username = "sa";
			String userpass = "";
			String sqlToModifyMood = "update users set mood = '"+modifiedMood+"'where UID ='"+presentUserName+"'";
			String sqlToModifyPassword = "update users set password = '"+modifiedPassword+"'where UID ='"+presentUserName+"'";
			Database database = new Database();
		    database.updateDataBase(drivername,url,username,userpass,sqlToModifyPassword);
		    database.updateDataBase(drivername,url,username,userpass,sqlToModifyMood);
		    database.closeConnection();
		}

		@SuppressWarnings("deprecation")
		private boolean ifTwoPasswordEquals() 
		{
            if(!(comfirmPassword.getText().equals(modifyPassword.getText())))
			    return false;
            else
            	return true;
		}
	}

	private class Listen_cancel implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(JOptionPane.showConfirmDialog(null, "确定不保存你所做的修改，并且退出吗？","提示",JOptionPane.YES_NO_OPTION) == 0)
			setVisible(false);
		}
	}
	
	private class addComboBoxHandler implements ItemListener
	{
		public void itemStateChanged(ItemEvent event)
		{
			if(event.getStateChange() == event.SELECTED)
			{
				//if(JOptionPane.showConfirmDialog(null, "是否加入该组？","提示",JOptionPane.YES_NO_CANCEL_OPTION) != 0)
					
				if(JOptionPane.showConfirmDialog(null, "是否加入该组？","提示",JOptionPane.YES_NO_CANCEL_OPTION) == 0)
				{
                    if(isAddTwice(allGroups[addIntoGroup.getSelectedIndex()]))
                    {
                    	JOptionPane.showMessageDialog(null, "不能加入，因为你已经加入该组","错误",JOptionPane.PLAIN_MESSAGE);
                    }
                    else
					    newAddGroup = allGroups[addIntoGroup.getSelectedIndex()];
				}
			}
		}

		private boolean isAddTwice(String addedGroup) {
			for(int i = 0;i<hasInGroups.length;i++)
			{
				if(addedGroup.equals(hasInGroups[i]))
				{
					return true;				
				}
			}
			return false;
		}
	}
	
	private class deleteComboBoxHandler implements ItemListener
	{
		public void itemStateChanged(ItemEvent enent)
		{
			if(enent.getStateChange() == enent.SELECTED)
			{
				if(JOptionPane.showConfirmDialog(null, "是否退出该组？", "提示",JOptionPane.YES_NO_CANCEL_OPTION) == 0)
				{
					newDeleteGroup = hasInGroups[deleteFromGroup.getSelectedIndex()];
				}
			}
		}
	}

	private void getPersonalInformationFromDatabase() throws SQLException
	{
		getUserID();
		ResultSet resultSet;
		String drivername = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433; DatabaseName=system_of_friends";
		String username = "sa";
		String userpass = "";
		String sql = "select UID,userName,password,gender,mood from users where UID = "+"'"+presentUserName+"'";
		Database database = new Database();
		resultSet = database.creatResultSet(drivername,url,username,userpass,sql);
		resultSet.next();
		printUserName = ((ResultSet) resultSet).getString("userName");
		printNumber = resultSet.getString("UID");
		printGender = resultSet.getString("gender");
		printMood = resultSet.getString("mood");
		printPassword = resultSet.getString("password");
		database.closeConnection();
		database.closeResultSet();
	}
	
	private void getActivedGroupsFromDatabase() throws SQLException
	{
		getUserID();
		ResultSet resultSetOfActivedgroups;
		ResultSet resultSetOfAllGroups;
		int indexOfActivedgroups = 0;
		int indexOfAllgroups = 0; 
		String drivername = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433; DatabaseName=system_of_friends";
		String username = "sa";
		String userpass = "";
		String sqlToFindActivedGroups = "select group_name from users,activeIn,groups where groups.GID = activeIn.GID and users.UID ="+"'"+presentUserName+"'";
		String sqlToFindAllGroups = "select group_name from groups";
		Database database = new Database();
		resultSetOfActivedgroups = database.creatResultSet(drivername,url,username,userpass,sqlToFindActivedGroups);
		resultSetOfAllGroups = database.creatResultSet(drivername, url, username, userpass, sqlToFindAllGroups);
		while(resultSetOfActivedgroups.next())
		{
			hasInGroups[indexOfActivedgroups] = resultSetOfActivedgroups.getString("group_name");
			indexOfActivedgroups++;
		}
		while(resultSetOfAllGroups.next())
		{
			allGroups[indexOfAllgroups] = resultSetOfAllGroups.getString("group_name");
			indexOfAllgroups++;
		}
		
		database.closeConnection();
		database.closeResultSet();
	}
	
	private void setContainerProperty()
	{
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createWindow() throws SQLException
	{
		addTextFieldToContainer();
		addLabelToContainer();
		addButtonToContainer();
		addComboBoxToContainer();
		addListenerToButton();
		addListenerToComboBox();
		setContainerProperty();
	}
	
	public static void main(String[] args) throws SQLException
	{
		ModifyInformation window = new ModifyInformation();
		window.createWindow();
	}
}
