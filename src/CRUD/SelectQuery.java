package CRUD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.JDBCUtil.JDBCUtil;

public class SelectQuery {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		Scanner scan = new Scanner(System.in);
		
		try {
			connection =JDBCUtil.getJdbcConnection();
			
		//this code block is for prepared statement 
			if (connection != null) {
				String mysqlQuery =  " select * from Database where id=? ";
				
				preparedstatement = connection.prepareStatement(mysqlQuery);
				
				if(preparedstatement != null) {
					System.out.println("Enter the id whch u want to get details from MYSQL");
					int id = scan.nextInt();
					preparedstatement.setInt(1,id);
					
					resultset = preparedstatement.executeQuery();
					
					if(resultset != null) {
						if(resultset.next()) {
							System.out.println("ID\tName\tRollNumber\tResult");
							System.out.println(resultset.getInt(1) + "\t" + resultset.getString(2) + "\t"+resultset.getInt(3) + "\t"+resultset.getString(4));
							
						}
					}
				}
			}
			
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.closeResource(connection, preparedstatement,resultset);
				scan.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
