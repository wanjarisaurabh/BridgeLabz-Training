package jdbc_practice.library_management;

import java.sql.*;
import java.util.Scanner;

public class LibraryManagement {
    
    //db connection
    static String url="jdbc:mysql://localhost:3306/jdbclearning";
    static String user="root";
    static String password="---------";
    
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        
        while(true){
            System.out.println("\n===== Library Management =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add Student");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Calculate Fine");
            System.out.println("6. Search Books");
            System.out.println("7. View All Books");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            
            int choice=sc.nextInt();
            
            switch(choice){
                case 1:
                    addBook(sc);
                    break;
                case 2:
                    addStudent(sc);
                    break;
                case 3:
                    issueBook(sc);
                    break;
                case 4:
                    returnBook(sc);
                    break;
                case 5:
                    calculateFine(sc);
                    break;
                case 6:
                    searchBooks(sc);
                    break;
                case 7:
                    viewAllBooks();
                    break;
                case 8:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    
    
    //add book to inventory
    static void addBook(Scanner sc){
        try{
            Connection conn=DriverManager.getConnection(url,user,password);
            
            System.out.print("Enter book ID: ");
            int bookId=sc.nextInt();
            sc.nextLine();
            System.out.print("Enter book title: ");
            String title=sc.nextLine();
            System.out.print("Enter author: ");
            String author=sc.nextLine();
            System.out.print("Enter category: ");
            String category=sc.nextLine();
            System.out.print("Enter quantity: ");
            int quantity=sc.nextInt();
            
            String sql="INSERT INTO books(book_id,title,author,category,quantity,available) VALUES(?,?,?,?,?,?)";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setInt(1,bookId);
            pst.setString(2,title);
            pst.setString(3,author);
            pst.setString(4,category);
            pst.setInt(5,quantity);
            pst.setInt(6,quantity);
            
            int rows=pst.executeUpdate();
            if(rows>0){
                System.out.println("Book added successfully!");
            }
            
            pst.close();
            conn.close();
            
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    
    //add student
    static void addStudent(Scanner sc){
        try{
            Connection conn=DriverManager.getConnection(url,user,password);
            
            System.out.print("Enter student ID: ");
            int studentId=sc.nextInt();
            sc.nextLine();
            System.out.print("Enter student name: ");
            String name=sc.nextLine();
            System.out.print("Enter email: ");
            String email=sc.nextLine();
            
            String sql="INSERT INTO students(student_id,name,email) VALUES(?,?,?)";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setInt(1,studentId);
            pst.setString(2,name);
            pst.setString(3,email);
            
            int rows=pst.executeUpdate();
            if(rows>0){
                System.out.println("Student added successfully!");
            }
            
            pst.close();
            conn.close();
            
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    
    //issue book to student
    static void issueBook(Scanner sc){
        try{
            Connection conn=DriverManager.getConnection(url,user,password);
            
            System.out.print("Enter student ID: ");
            int studentId=sc.nextInt();
            System.out.print("Enter book ID: ");
            int bookId=sc.nextInt();
            
            //check if book is available
            String checkSql="SELECT available FROM books WHERE book_id=?";
            PreparedStatement checkPst=conn.prepareStatement(checkSql);
            checkPst.setInt(1,bookId);
            ResultSet rs=checkPst.executeQuery();
            
            if(!rs.next()){
                System.out.println("Book not found");
                return;
            }
            
            int available=rs.getInt("available");
            if(available<=0){
                System.out.println("Book not available");
                return;
            }
            
            
            //issue book
            String issueSql="INSERT INTO borrowing(student_id,book_id,issue_date,return_date,status) VALUES(?,?,NOW(),DATE_ADD(NOW(),INTERVAL 14 DAY),'ISSUED')";
            PreparedStatement issuePst=conn.prepareStatement(issueSql);
            issuePst.setInt(1,studentId);
            issuePst.setInt(2,bookId);
            issuePst.executeUpdate();
            
            
            //update book availability
            String updateSql="UPDATE books SET available=available-1 WHERE book_id=?";
            PreparedStatement updatePst=conn.prepareStatement(updateSql);
            updatePst.setInt(1,bookId);
            updatePst.executeUpdate();
            
            System.out.println("Book issued successfully! Return date is 14 days from today");
            
            rs.close();
            checkPst.close();
            issuePst.close();
            updatePst.close();
            conn.close();
            
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    
    //return book
    static void returnBook(Scanner sc){
        try{
            Connection conn=DriverManager.getConnection(url,user,password);
            
            System.out.print("Enter borrowing ID: ");
            int borrowId=sc.nextInt();
            
            //update borrowing status
            String updateBorrowSql="UPDATE borrowing SET status='RETURNED',actual_return_date=NOW() WHERE borrow_id=?";
            PreparedStatement updateBorrowPst=conn.prepareStatement(updateBorrowSql);
            updateBorrowPst.setInt(1,borrowId);
            int rows=updateBorrowPst.executeUpdate();
            
            if(rows==0){
                System.out.println("Borrowing record not found");
                return;
            }
            
            
            //get book id
            String getBookSql="SELECT book_id FROM borrowing WHERE borrow_id=?";
            PreparedStatement getBookPst=conn.prepareStatement(getBookSql);
            getBookPst.setInt(1,borrowId);
            ResultSet rs=getBookPst.executeQuery();
            
            if(rs.next()){
                int bookId=rs.getInt("book_id");
                
                //update book availability
                String updateBookSql="UPDATE books SET available=available+1 WHERE book_id=?";
                PreparedStatement updateBookPst=conn.prepareStatement(updateBookSql);
                updateBookPst.setInt(1,bookId);
                updateBookPst.executeUpdate();
                
                updateBookPst.close();
            }
            
            System.out.println("Book returned successfully!");
            
            rs.close();
            updateBorrowPst.close();
            getBookPst.close();
            conn.close();
            
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    
    //calculate fine
    static void calculateFine(Scanner sc){
        try{
            Connection conn=DriverManager.getConnection(url,user,password);
            
            System.out.print("Enter borrowing ID: ");
            int borrowId=sc.nextInt();
            
            String sql="SELECT return_date,actual_return_date,status FROM borrowing WHERE borrow_id=?";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setInt(1,borrowId);
            
            ResultSet rs=pst.executeQuery();
            
            if(!rs.next()){
                System.out.println("Borrowing record not found");
                return;
            }
            
            Date returnDate=rs.getDate("return_date");
            Date actualReturnDate=rs.getDate("actual_return_date");
            String status=rs.getString("status");
            
            if(status.equals("RETURNED")){
                //calculate days delayed
                long diff=actualReturnDate.getTime()-returnDate.getTime();
                long daysDelayed=diff/(1000*60*60*24);
                
                if(daysDelayed>0){
                    double fine=daysDelayed*10;  //Rs.10 per day
                    System.out.println("Days delayed: "+daysDelayed);
                    System.out.println("Fine amount: Rs."+fine);
                }else{
                    System.out.println("No fine. Book returned on time!");
                }
            }else{
                //book not yet returned
                Date today=new Date(System.currentTimeMillis());
                long diff=today.getTime()-returnDate.getTime();
                long daysDelayed=diff/(1000*60*60*24);
                
                if(daysDelayed>0){
                    double fine=daysDelayed*10;
                    System.out.println("Book not yet returned!");
                    System.out.println("Days overdue: "+daysDelayed);
                    System.out.println("Pending fine: Rs."+fine);
                }else{
                    System.out.println("No fine yet. Book still within return period");
                }
            }
            
            rs.close();
            pst.close();
            conn.close();
            
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    
    //search books with filters
    static void searchBooks(Scanner sc){
        try{
            Connection conn=DriverManager.getConnection(url,user,password);
            
            System.out.println("\nSearch by:");
            System.out.println("1. Title");
            System.out.println("2. Author");
            System.out.println("3. Category");
            System.out.print("Enter choice: ");
            int searchChoice=sc.nextInt();
            sc.nextLine();
            
            String sql="";
            String searchTerm="";
            
            if(searchChoice==1){
                System.out.print("Enter title: ");
                searchTerm=sc.nextLine();
                sql="SELECT * FROM books WHERE title LIKE ?";
            }else if(searchChoice==2){
                System.out.print("Enter author: ");
                searchTerm=sc.nextLine();
                sql="SELECT * FROM books WHERE author LIKE ?";
            }else if(searchChoice==3){
                System.out.print("Enter category: ");
                searchTerm=sc.nextLine();
                sql="SELECT * FROM books WHERE category LIKE ?";
            }else{
                System.out.println("Invalid choice");
                return;
            }
            
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,"%"+searchTerm+"%");
            
            ResultSet rs=pst.executeQuery();
            
            System.out.println("\n==== Search Results ====");
            boolean found=false;
            while(rs.next()){
                found=true;
                System.out.println("Book ID: "+rs.getInt("book_id"));
                System.out.println("Title: "+rs.getString("title"));
                System.out.println("Author: "+rs.getString("author"));
                System.out.println("Category: "+rs.getString("category"));
                System.out.println("Available: "+rs.getInt("available")+"/"+rs.getInt("quantity"));
                System.out.println("------------------------");
            }
            
            if(!found){
                System.out.println("No books found");
            }
            
            rs.close();
            pst.close();
            conn.close();
            
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    
    //view all books
    static void viewAllBooks(){
        try{
            Connection conn=DriverManager.getConnection(url,user,password);
            
            String sql="SELECT * FROM books";
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            
            System.out.println("\n==== All Books ====");
            while(rs.next()){
                System.out.println("Book ID: "+rs.getInt("book_id"));
                System.out.println("Title: "+rs.getString("title"));
                System.out.println("Author: "+rs.getString("author"));
                System.out.println("Category: "+rs.getString("category"));
                System.out.println("Available: "+rs.getInt("available")+"/"+rs.getInt("quantity"));
                System.out.println("-------------------");
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
