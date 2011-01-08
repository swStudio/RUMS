package server;

import javax.swing.*;

import users.User;

import java.awt.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Server extends JFrame implements ActionListener,ItemListener,Runnable{

	public static int port = 8888;
	
	ServerSocket server;
	Socket client = null;
	BufferedReader cin = null;
  	PrintWriter cout = null;
  	Thread chartThread = null;
	JButton runButton = new JButton("运行");
	JButton stopButton = new JButton("停止");
	JButton exitButton = new JButton("退出");
	JButton messageButton = new JButton("发送消息");
	JTextField serMessage = new JTextField("",18);
	Vector userName = new Vector<String>(100);
	JComboBox userList = new JComboBox(userName);
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JScrollPane messageScrollPane;
	JTextArea message = new JTextArea();
	Hashtable users = new Hashtable();//定义哈希表
	String currentUserName  =null;
	User currentUser = null;
	boolean isRunning = false;
	ServerThread serverThread = null;
	
	public Server(){
		
		this.setTitle("交友平台服务器");
		p1.setLayout(new GridLayout(1,5,5,5));
		p1.add(runButton);
		p1.add(stopButton);
		p1.add(exitButton);
		p1.add(userList);
		runButton.addActionListener(this);
		stopButton.addActionListener(this);
		exitButton.addActionListener(this);
		messageButton.addActionListener(this);
		userList.addItem("好友列表");
		userList.setModel(new DefaultComboBoxModel(new String[] {"08386216","08386205","08386242","08386224"}));
		userList.addItemListener(this);
		p2.add(serMessage);
		p2.add(messageButton);
		messageScrollPane = new JScrollPane(message,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.getContentPane().add(p1,"North");
		this.getContentPane().add(p2,"South");
		this.getContentPane().add(messageScrollPane,"Center");
		this.setSize(320,380);
		this.setLocation(500, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == runButton)
		{
			chartThread = new Thread(this);
			chartThread.start();
			runButton.setVisible(false);
			message.append("服务器启动……"+"\n");
			 
		}else if (e.getSource() == stopButton)
		{
			chartThread=null;
			runButton.setVisible(true);
			if(cout != null) cout.println("stop");
		try{
				if(server!=null) 
					server.close();
			}catch(Exception exp){}
			message.append("服务器停止"+"\n");
		}else if(e.getSource()==exitButton)
		{
			chartThread=null;
			if(cout!=null) cout.println("exit");
			System.exit(0);
		}else if (e.getSource()==messageButton)
		{
			if(chartThread!=null)
			{
				if(currentUserName=="所有人")
				{
					int count=userList.getItemCount();
					for(int i = 1;i < count; i++)
					{
						User user=(User)users.get(userList.getItemAt(i).toString());
						//user.dos.println(serMessage.getText());
						message.append("发送："+serMessage.getText()+"\n");
					}
				}
				else
				{
					sendMessage(serMessage.getText());
					message.append("发送："+serMessage.getText()+"\n");
				}								
			}
		}
	}
	public void itemStateChanged(ItemEvent event)
	{
		if(event.getStateChange()==ItemEvent.SELECTED)
		{
			currentUserName=userName.elementAt(userList.getSelectedIndex()).toString();
		}
	}
	public void run()
	{
		
		try{
      server=new ServerSocket(port);
      while(chartThread!=null)
      {
        client=server.accept() ;
        Thread.sleep(500);
        cin=new BufferedReader(new InputStreamReader(client.getInputStream()));
        cout=new PrintWriter(client.getOutputStream(),true);
        String username;
        String password;
        username=cin.readLine();
        password=cin.readLine();
        if(userOK(username,password))
        {
        	message.append("客户:"+username+"进入\n");
        	cout.println("ok");
        	userName.add(username);
			cout.println(userName.toString());
        	cout.flush();
        	String aline;
        	//User user=new User(username);
        	//user.setSocket(client,cin,cout);
        	//users.put(username,user);
        	//new	ServerThread(user).start();
        	//for(int i=1;i<userName.size();i++)
        	//{
        		//User user=(User)users.get(userList.getItemAt(i).toString());
				//user.dos.println("adduser");
				
        	//}
    			
   
        }else cout.println("error");
        
        }
 
        cin.close() ;
        cout.close() ;
        client.close() ;
        server.close();
      
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
}

	


	public boolean userOK(String username,String password)
	{
		boolean ok=false;
		try {
            //①加载驱动程序
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          }
          catch (ClassNotFoundException e) {
            //驱动程序加载不成功，打印错误信息并退出
            System.out.println("Can not find driver " );
            System.exit( -1);
          }
          Connection con;
          try {
            //②获得jdbc 连接
            con = DriverManager.getConnection("jdbc:odbc:userlist", "user", "");
            //③创建Statement对象
            Statement stmt = con.createStatement();
            //④得到查询结果集
            String sql = "select * from userlist where username='" 
				+ username + "'";
            ResultSet rs = stmt.executeQuery(sql);
                       
            //列印结果集
            while(rs.next())
			{
				String ps = rs.getString("password");
				
				if (ps.equals(password)) {
					//验证通过
					ok=true;
				}
			}
            //⑤关闭数据库连接
            rs.close();
            stmt.close();
            con.close();
          }
          catch (SQLException sqe) {
            sqe.printStackTrace();
          }
        
		return ok;
	}
	
	public void sendMessage(String message)
	{
		User user=(User)users.get(currentUserName);
		
	}
	

	class ServerThread extends Thread{
	
		User client;
		String aline;
		public ServerThread(){
		}
			public ServerThread(User client)
			{
						this.client=client;
			}
			public void setUser(User client)
			{
		
			}
			public void run(){
				try{
				}catch(Exception eeee){	}
			}
		}
	public static void main(String args[])
		{
			Server chat_server = new Server();
		}

}
