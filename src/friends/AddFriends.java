package friends;

import java.sql.*;

import javax.swing.JOptionPane;

import database.Database;

public class AddFriends
{
	private ResultSet resultset;
	private ResultSet resultset1;
	private void createDatabaseConnection(String ID) throws SQLException 
	{
		String drivername = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433; DatabaseName=system_of_friends";
		String username = "sa";
		String userpass = "";
		String sql = "select UID,password from users where UID="+"'"+ID+"'";
		Database database = new Database();
		resultset = database.creatResultSet(drivername,url,username,userpass,sql);
	}
	private boolean isLengthOfUsernameLegal(String ID)
	{
		
		if(ID.length()>0 && ID.length()!=8)
		    return false;
		else
			return true;
	}
	public void worningOfCantFindUserInDatabase(String ID) throws SQLException 
	{
		createDatabaseConnection(ID);	
		if(!resultset.next())
		{
			 System.out.println("用户不存在，请重新操作");
		}	
	}
	public void worningOfLengthProblem(String ID)
	{
		if(!isLengthOfUsernameLegal(ID))
		{
			System.out.println("用户名长度不正确");
		}		
	}
   public static void input_has(String ID1,String ID2) throws ClassNotFoundException, SQLException
    {
      String className,url,uid,pwd; 
      className = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
      url       = "jdbc:sqlserver://localhost:1433; DatabaseName=system_of_friends"; 
      uid       = "sa"; 
      pwd       = ""; 
      Class.forName(className); 
      Connection cn = DriverManager.getConnection(url,uid,pwd); 
      String sql; 
      Statement sm = cn.createStatement(); 
 //     sql="select * from users where UID='ID1'";
 //     sm.executeQuery(sql); // 执行数据查询语句（select） 
      sql="INSERT INTO has values('"+ID1+"','"+ID2+"')";
      sm.executeUpdate(sql); // 执行数据更新语句（delete、update、insert、drop等) 
      cn.close(); 
    }
   public static void output_list(String ID1) throws ClassNotFoundException, SQLException
   {
	   String className,url,uid,pwd; 
	   ResultSet rs;
	   className = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
	   url       = "jdbc:sqlserver://localhost:1433; DatabaseName=system_of_friends"; 
	   uid       = "sa"; 
	   pwd       = ""; 
	   Class.forName(className); 
	   Connection cn = DriverManager.getConnection(url,uid,pwd); 
	   String sql; 
	   Statement sm = cn.createStatement();
	   sql = "select * from has where UID = '"+ID1+"'";
	   sm.executeQuery(sql);
	   rs = sm.getResultSet();
   }
   public static void main(String args[]) throws ClassNotFoundException, SQLException
   {
	   String ID1="08386231";
	   String ID2="08386232";
	   ResultSet rs;
//	   worningOfCantFindUserInDatabase(ID1);
//	   worningOfCantFindUserInDatabase(ID2);
	  // input_has(ID1,ID2);
	   
	   String className,url,uid,pwd; 
	   className = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
	   url       = "jdbc:sqlserver://localhost:1433; DatabaseName=system_of_friends"; 
	   uid       = "sa"; 
	   pwd       = ""; 
	   Class.forName(className); 
	   Connection cn = DriverManager.getConnection(url,uid,pwd); 
	   String sql; 
	   Statement sm = cn.createStatement(); 
	   sql = "select * from has where UID = '"+ID1+"'";
	   sm.executeQuery(sql);
	   rs = sm.getResultSet();
	   while(rs.next())
	   {
		   System.out.println(rs.getString("UID")+"    "+rs.getString("FID")+'\n');
	   }
	   //System.out.println( sm.getResultSet().next());
	   cn.close();
	   
	  
	   
	   
   }
}
