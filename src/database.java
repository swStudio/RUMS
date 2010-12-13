package login;
import java.sql.*; 

public class database {
	private
	String driverName;
	String dbURL;
	String userName;
	String userPwd;
	Connection dbConn = null; 
	Statement statement;
	ResultSet resultSet;
	
private void databaseConnection(String drivername,String url,String username,String userpass)
{
	driverName = drivername;
	dbURL = url;
	userName = username;
	userPwd = userpass;
	try { 
		Class.forName(driverName); 
		dbConn = DriverManager.getConnection(dbURL, userName, userPwd); 
		} 
		catch (Exception e) { e.printStackTrace(); }
}


public ResultSet creatResultSet(String drivername,String url,String username,String userpass,String sql) throws SQLException
{
	databaseConnection(drivername,url,username,userpass);
	statement = dbConn.createStatement();
	resultSet = statement.executeQuery(sql);
	return resultSet;	
}

public void updateDataBase(String drivername,String url,String username,String userpass,String sql) throws SQLException
{
	databaseConnection(drivername,url,username,userpass);
	statement = dbConn.createStatement();
	statement.executeUpdate(sql);
}

public void closeConnection() throws SQLException
{
	dbConn.close();
	statement.close();
}

public void closeResultSet() throws SQLException
{
	resultSet.close();
}
public static void main(String args[]) throws SQLException
{
	String drivername = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433; DatabaseName=try";
	String username = "sa";
	String userpass = "";
	String sql = "select number from users where number='08386243'";
	ResultSet resultset;
	database dataBase = new database();
	resultset = dataBase.creatResultSet(drivername,url,username,userpass,sql);
	//resultset.next();//这一步很重要，耽误了我很久的时间，就是因为没有向下移动，这时候找不到当前行。
    if(resultset.next())
    {
    	System.out.println("Find the record!");
	}
    else
    	System.out.println("Can't find the record!!!");
	//String number =resultset.getString(2);
}

}
