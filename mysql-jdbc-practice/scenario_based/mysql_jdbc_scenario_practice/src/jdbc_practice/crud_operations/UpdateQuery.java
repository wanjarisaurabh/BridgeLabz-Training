package jdbc_practice.crud_operations;

import java.sql.*;

public class UpdateQuery {
	public static void main(String[] args) {
		String sql="UPDATE students SET grade=? WHERE id BETWEEN 6 AND 180;";
		
		String url="jdbc:mysql://localhost:3306/jdbclearning";
		String user="root";
		String pass="Abhiji@2001";
		
		try(Connection con=DriverManager.getConnection(url,user,pass); PreparedStatement stmt=con.prepareStatement(sql)){
			stmt.setString(1, "C+");
//			stmt.setInt(2, 2);
			
			int rowsAffected=stmt.executeUpdate();
			System.out.println(rowsAffected);
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
