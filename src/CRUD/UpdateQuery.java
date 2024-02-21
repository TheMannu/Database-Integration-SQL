package CRUD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.JDBCUtil.JDBCUtil;

public class UpdateQuery {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		
		try {
			connection =JDBCUtil.getJdbcConnection();
			 
			if (connection != null) {
				Scanner scan = new Scanner(System.in);
				String mysqlQuery =  "update table set result=? where id=?";
				
				preparedstatement = connection.prepareStatement(mysqlQuery);
				
				if(preparedstatement != null) {
					
					System.out.println("Enter the id which u want to update");
					int id = scan.nextInt();
					
					System.out.println("Enter the new result to update");
					String resultset = scan.next();
				
				preparedstatement.setString(1,resultset);
				preparedstatement.setInt(2,id);
					
					int roweffected = preparedstatement.executeUpdate();
					
					if(roweffected == 1) {
						System.out.println("Row Inserted");
					} else {
						System.out.println("Row NOT Inserted");
					}
				}
			}
			
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.closeResource(connection, preparedstatement, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
