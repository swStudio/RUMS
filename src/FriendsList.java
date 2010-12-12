import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class FriendsList {
	
	public String[] list = new String[10];
	
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
		  
		   int n=0;
		   while(rs.next())
		   {
			   list[n] = rs.getString("FID");
			   n++;
		   }
	   }

}
