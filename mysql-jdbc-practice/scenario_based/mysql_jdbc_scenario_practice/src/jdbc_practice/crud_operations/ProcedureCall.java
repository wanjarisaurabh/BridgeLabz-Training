package jdbc_practice.crud_operations;

import java.sql.*;



public class ProcedureCall {
	public static void main(String[] args) {
		String sql="{CALL GetStudentsByGrade(?)};";
		
		final String URL ="jdbc:mysql://localhost:3306/jdbclearning";
		final String USER="root";
		final String PASS="Abhiji@2001";
		
		
		//using try based resources
		try(Connection con=DriverManager.getConnection(URL,USER,PASS); CallableStatement stmt=con.prepareCall(sql)){
			stmt.setString(1,"A");
			
			if(stmt.execute()) {
				ResultSet rs=stmt.getResultSet();
				while (rs.next()) {
					System.out.println("ID: " + rs.getInt("id"));

					System.out.println("Name: " + rs.getString("name"));
					System.out.println("Grade: " + rs.getString("grade"));
					System.out.println("----");
			}
				System.out.println("Process Complete");
			
			
			}
			
			
			int rowsAffected=stmt.executeUpdate();
			System.out.println(rowsAffected);
			System.out.println("Process complete");
		}
		
		
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		
	}
}
