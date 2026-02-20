package jdbc_practice.transaction_management;

import java.sql.*;
import java.util.Scanner;

public class BankingSystem {
    
    //database connection details
    static String url="jdbc:mysql://localhost:3306/jdbclearning";
    static String user="root";
    static String password="---------";
    
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        
        while(true){
            System.out.println("\n===== Banking System =====");
            System.out.println("1. Create Account");
            System.out.println("2. Check Balance");
            System.out.println("3. Transfer Money");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            
            int choice=sc.nextInt();
            
            switch(choice){
                case 1:
                    createAccount(sc);
                    break;
                case 2:
                    checkBalance(sc);
                    break;
                case 3:
                    transferMoney(sc);
                    break;
                case 4:
                    viewHistory(sc);
                    break;
                case 5:
                    System.out.println("Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    
    
    //create new account
    static void createAccount(Scanner sc){
        try{
            Connection conn=DriverManager.getConnection(url,user,password);
            
            System.out.print("Enter account number: ");
            int accNum=sc.nextInt();
            sc.nextLine();
            System.out.print("Enter account holder name: ");
            String name=sc.nextLine();
            System.out.print("Enter initial balance: ");
            double balance=sc.nextDouble();
            
            String sql="INSERT INTO accounts(account_number,holder_name,balance) VALUES(?,?,?)";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setInt(1,accNum);
            pst.setString(2,name);
            pst.setDouble(3,balance);
            
            int rows=pst.executeUpdate();
            if(rows>0){
                System.out.println("Account created successfully!");
            }
            
            pst.close();
            conn.close();
            
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    
    //check balance
    static void checkBalance(Scanner sc){
        try{
            Connection conn=DriverManager.getConnection(url,user,password);
            
            System.out.print("Enter account number: ");
            int accNum=sc.nextInt();
            
            String sql="SELECT holder_name,balance FROM accounts WHERE account_number=?";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setInt(1,accNum);
            
            ResultSet rs=pst.executeQuery();
            
            if(rs.next()){
                System.out.println("Account Holder: "+rs.getString("holder_name"));
                System.out.println("Balance: Rs."+rs.getDouble("balance"));
            }else{
                System.out.println("Account not found");
            }
            
            rs.close();
            pst.close();
            conn.close();
            
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    
    //transfer money using transaction
    static void transferMoney(Scanner sc){
        Connection conn=null;
        try{
            conn=DriverManager.getConnection(url,user,password);
            
            //disable auto commit for transaction
            conn.setAutoCommit(false);
            
            System.out.print("Enter from account: ");
            int fromAcc=sc.nextInt();
            System.out.print("Enter to account: ");
            int toAcc=sc.nextInt();
            System.out.print("Enter amount: ");
            double amount=sc.nextDouble();
            
            
            //check if from account has sufficient balance
            String checkSql="SELECT balance FROM accounts WHERE account_number=?";
            PreparedStatement checkPst=conn.prepareStatement(checkSql);
            checkPst.setInt(1,fromAcc);
            ResultSet rs=checkPst.executeQuery();
            
            if(!rs.next()){
                System.out.println("From account not found");
                conn.rollback();
                return;
            }
            
            double fromBalance=rs.getDouble("balance");
            if(fromBalance<amount){
                System.out.println("Insufficient balance!");
                conn.rollback();
                return;
            }
            
            
            //deduct from sender
            String deductSql="UPDATE accounts SET balance=balance-? WHERE account_number=?";
            PreparedStatement deductPst=conn.prepareStatement(deductSql);
            deductPst.setDouble(1,amount);
            deductPst.setInt(2,fromAcc);
            deductPst.executeUpdate();
            
            
            //add to receiver
            String addSql="UPDATE accounts SET balance=balance+? WHERE account_number=?";
            PreparedStatement addPst=conn.prepareStatement(addSql);
            addPst.setDouble(1,amount);
            addPst.setInt(2,toAcc);
            int rows=addPst.executeUpdate();
            
            if(rows==0){
                System.out.println("To account not found");
                conn.rollback();
                return;
            }
            
            
            //record transaction
            String transSql="INSERT INTO transactions(from_account,to_account,amount,transaction_date) VALUES(?,?,?,NOW())";
            PreparedStatement transPst=conn.prepareStatement(transSql);
            transPst.setInt(1,fromAcc);
            transPst.setInt(2,toAcc);
            transPst.setDouble(3,amount);
            transPst.executeUpdate();
            
            
            //commit transaction
            conn.commit();
            System.out.println("Transfer successful!");
            
            
            rs.close();
            checkPst.close();
            deductPst.close();
            addPst.close();
            transPst.close();
            
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
            try{
                if(conn!=null){
                    conn.rollback();
                }
            }catch(SQLException se){
                se.printStackTrace();
            }
        }finally{
            try{
                if(conn!=null){
                    conn.setAutoCommit(true);
                    conn.close();
                }
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
    
    
    //view transaction history
    static void viewHistory(Scanner sc){
        try{
            Connection conn=DriverManager.getConnection(url,user,password);
            
            System.out.print("Enter account number: ");
            int accNum=sc.nextInt();
            
            String sql="SELECT * FROM transactions WHERE from_account=? OR to_account=? ORDER BY transaction_date DESC";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setInt(1,accNum);
            pst.setInt(2,accNum);
            
            ResultSet rs=pst.executeQuery();
            
            System.out.println("\n==== Transaction History ====");
            boolean found=false;
            while(rs.next()){
                found=true;
                System.out.println("Transaction ID: "+rs.getInt("transaction_id"));
                System.out.println("From: "+rs.getInt("from_account")+" To: "+rs.getInt("to_account"));
                System.out.println("Amount: Rs."+rs.getDouble("amount"));
                System.out.println("Date: "+rs.getTimestamp("transaction_date"));
                System.out.println("----------------------------");
            }
            
            if(!found){
                System.out.println("No transactions found");
            }
            
            rs.close();
            pst.close();
            conn.close();
            
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
