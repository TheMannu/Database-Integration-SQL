package CRUD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import in.JDBCUtil.JDBCUtil;

public class InsermysqlQuery {

	public static void main(String[] args) {
		Connection connection = null;
//		Statement statement = null;
		PreparedStatement preparedstatement = null;
		try {
			connection =JDBCUtil.getJdbcConnection();
			
		//	THIS CODE BLOCK IS FOR CREATE STATEMENT
//			if(connection != null) {
//				statement = connection.createStatement();
//				String myinsertQuery = "insert into tableName (Name.RollNumber,Result) values (mannu,123,Pass)";
//				
//				int roweffected = statement.executeUpdate(myinsertQuery);
//				
//				if(roweffected == 1) {
//					System.out.println("Row Inserted");
//				} else {
//					System.out.println("Row NOT Inserted");
//				}
//		    }
			
			//this code block is for prepared statement 
			if (connection != null) {
				String mysqlQuery =  "insert into student (name,RollNo,result) values (?,?,?)";
				
				preparedstatement = connection.prepareStatement(mysqlQuery);
				
				if(preparedstatement != null) {
					// use scanner of taking input from the user
					preparedstatement.setString(1, "chirag");
					preparedstatement.setInt(2,123);
					preparedstatement.setString(3, "Pass");
					
					
					int roweffected = preparedstatement.executeUpdate();
					
					if(roweffected == 1) {
						System.out.println("Row Inserted");
					} else {
						System.out.println("Row NOT Inserted");
					}
				}
			}
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.closeResource(connection, preparedstatement,null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
