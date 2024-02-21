package CRUD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import in.JDBCUtil.JDBCUtil;

public class DeleteQuery {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		
		try {
			connection =JDBCUtil.getJdbcConnection();
			 
			if (connection != null) {
				Scanner scan = new Scanner(System.in);
				String mysqlQuery =  "delete from table where id=?";
				
				preparedstatement = connection.prepareStatement(mysqlQuery);
				
				if(preparedstatement != null) {
					
					System.out.println("Enter the id which u want to Delete ");
					int id = scan.nextInt();
					
					
				preparedstatement.setInt(1,id);
					
					int roweffected = preparedstatement.executeUpdate();
					
					if(roweffected == 1) {
						System.out.println("Row Deleted");
					} else {
						System.out.println("Row NOT Deleted");
					}
				}
			}
			
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.closeResource(connection, preparedstatement,null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
