package jdbc_practice.crud_operations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

//class to perform create operation
public class CreateOperation {

	public static void main(String[] args) {
		
		String createQuery="CREATE TABLE students( "
				+ "id INT AUTO_INCREMENT PRIMARY KEY, "
				+ "name VARCHAR(100) NOT NULL, "
				+ "email VARCHAR(100) UNIQUE NOT NULL, "
				+ "age INT,"
				+ "grade VARCHAR(10),"
				+ "enrollment_date DATE"
				+ ");";
		final String url="jdbc:mysql://localhost:3306/jdbclearning";
		final String user="root";
		final String pass="Abhiji@2001";
		
		
		
		//using try-with-resources to create connection
		try(Connection conn=DriverManager.getConnection(url,user,pass); PreparedStatement stmt=conn.prepareStatement(createQuery)){
			int rowsAffected=stmt.executeUpdate();
			System.out.print(rowsAffected);
			
			
		}catch(SQLException e) {System.out.println(e.getMessage());}
		System.out.println("table created successfully");
		

	}

}
