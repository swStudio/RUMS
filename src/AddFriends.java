import java.sql.*;

import javax.swing.JOptionPane;
public class AddFriends
{
	private ResultSet resultset;
	private void createDatabaseConnection(String ID) throws SQLException 
	{
		String drivername = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433; DatabaseName=system_of_friends";
		String username = "sa";
		String userpass = "";
		String sql = "select UID,password from users where UID="+"'"+ID+"'";
		database dataBase = new database();
		resultset = dataBase.creatResultSet(drivername,url,username,userpass,sql);
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
			 System.out.println("�û������ڣ������²���");
		}	
	}
	public void worningOfLengthProblem(String ID)
	{
		if(!isLengthOfUsernameLegal(ID))
		{
			System.out.println("�û������Ȳ���ȷ");
		}		
	}
   public void input_has(String ID1,String ID2) throws ClassNotFoundException, SQLException
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
 //     sm.executeQuery(sql); // ִ�����ݲ�ѯ��䣨select�� 
      sql="INSERT INTO has values('"+ID1+"','"+ID2+"')";
      sm.executeUpdate(sql); // ִ�����ݸ�����䣨delete��update��insert��drop��) 
      cn.close(); 
    }
   public void output_list(String ID1) throws ClassNotFoundException, SQLException
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
	   String ID1="08386227";
	   String ID2="08386236";
	   AddFriends key=new AddFriends();
	   key.worningOfCantFindUserInDatabase(ID1);
	   key.worningOfCantFindUserInDatabase(ID2);
	   key.worningOfLengthProblem(ID1);
	   key.worningOfLengthProblem(ID2);
	   key.input_has(ID1,ID2);
	   
/*	   ResultSet rs;   
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
	   cn.close();*/  //��δ�������ʾ�����к�ID1�����ѵĹ�ϵ��
   }
}