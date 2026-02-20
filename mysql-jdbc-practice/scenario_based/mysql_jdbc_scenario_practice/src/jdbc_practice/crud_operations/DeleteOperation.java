package jdbc_practice.crud_operations;
import java.sql.*;

public class DeleteOperation {
	public static void main(String[] args) {
		String sql="DELETE FROM students WHERE id BETWEEN ? AND ?;";
		
		final String URL ="jdbc:mysql://localhost:3306/jdbclearning";
		final String USER="root";
		final String PASS="Abhiji@2001";
		
		
		//using try based resources
		try(Connection con=DriverManager.getConnection(URL,USER,PASS); PreparedStatement stmt=con.prepareStatement(sql)){
			stmt.setInt(1,30);
			stmt.setInt(2,169);
			
			int rowsAffected=stmt.executeUpdate();
			System.out.println("Process complete");
		}
		
		
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		
	}
}
