package jdbc_practice.crud_operations;

import java.sql.*;


public class InsertOperation {
	
	
	
	public static void main(String[] args) {
		//the sql to execute
		String sql="Insert INTO students (name,email,age,grade) values(?,?,?,?);";
		
		//database required connection fields
		
		final String url="jdbc:mysql://localhost:3306/jdbclearning";
		final String user="root";
		final String pass="Abhiji@2001";
		
		//using try with resources to create connections
		
		try(Connection con=DriverManager.getConnection(url,user,pass); PreparedStatement stmt=con.prepareStatement(sql)){
			con.setAutoCommit(false);
			
			
			//looping and batching to save statement
			for(int i=0;i<200;i++) {
				stmt.setString(1,"Student"+String.valueOf(i));
				stmt.setString(2,"Student"+String.valueOf(i)+"@example.com");
				stmt.setInt(3,18+(i%10));
				stmt.setString(4,"A");
				
				
				
				//batching the statement
				stmt.addBatch();
				
				if(i%50==0) {
					stmt.executeBatch();
				}
				
			}
			
			
			stmt.executeBatch();// executing remaining
			
			con.commit(); //commit messages
			
			System.out.println("");
			
		}
		catch (SQLException e) {System.out.println(e.getMessage()+"\n"+e.getErrorCode()+" "+e.getSQLState());}
	}
}
