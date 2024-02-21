package in.JDBCUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JDBCUtil {
	
	//task to get the properties from the application file and loading the driver with connection.
	public static Connection getJdbcConnection() throws SQLException, IOException {
		FileInputStream FIS = new FileInputStream("App.properties");
		Properties P = new Properties();
		P.load(FIS);
		
		String url = P.getProperty("url");
		String user = P.getProperty("user");
		String passward = P.getProperty("passward");
		
		System.out.println(url);
		System.out.println(user);
		System.out.println(passward);
		
		Connection connection = DriverManager.getConnection(url,user,passward);
		
		return connection;
	}
	// THIS METHOD IS USED FOR CREATE STATEMENT 
//	public static void closeResource(Connection connection, Statement statement) throws SQLException {
//	if(connection!=null) {
//		connection.close();
//	} if(statement!=null) {
//		statement.close();
//	}
	
	//this method is used for Prepared Statement
	public static void closeResource(Connection connection, PreparedStatement preparedstatement,ResultSet resultset) throws SQLException {
		if(connection!=null) {
			connection.close();
		} if(preparedstatement!=null) {
			preparedstatement.close();
		} if (resultset != null) {
			resultset.close();
		}
}
}