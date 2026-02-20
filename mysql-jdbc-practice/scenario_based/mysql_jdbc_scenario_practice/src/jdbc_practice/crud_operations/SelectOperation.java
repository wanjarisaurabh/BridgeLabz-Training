package jdbc_practice.crud_operations;

import java.sql.*;


public class SelectOperation {
	public static void main(String[] args) {
		//the sql to execute
		String sql="SELECT * FROM students WHERE id BETWEEN 30 AND 80;";
		
		//database required connection fields
		
		final String url="jdbc:mysql://localhost:3306/jdbclearning";
		final String user="root";
		final String pass="Abhiji@2001";
		
		//using try with resources to create connections
		
		try(Connection con=DriverManager.getConnection(url,user,pass); PreparedStatement stmt=con.prepareStatement(sql); ResultSet rs=stmt.executeQuery()){
			
//			ResultSetMetaData resMetaData=rs.getMetaData();
//			
//			System.out.println("Number of columns: "+resMetaData.getColumnCount());
//			System.out.printf("%-20s %-20s","Column Name","Column Type");
//			System.out.println();
//			
//			for(int i=1;i<=resMetaData.getColumnCount();i++) {
//				System.out.printf("%-20s %-20s",resMetaData.getColumnName(i),resMetaData.getColumnTypeName(i));
//				System.out.println();
//				
//			}
			
			while(rs.next()) {
				System.out.printf("%-25s %-5d %-30s %-4s",rs.getString("name"),rs.getInt("age"),rs.getString("email"),rs.getString("grade"));
				System.out.println();
			}
			
			System.out.println("Execution complete");
			
		}
		catch (SQLException e) {System.out.println(e.getMessage()+"\n"+e.getErrorCode()+" "+e.getSQLState());}
	}
}
