package com.ganesh.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Assignment3 {
      public static void main(String[] args) {
		     Scanner sc  =  new Scanner(System.in);
		     try(sc;){
		    	   System.out.println("Enter Book Code Number: ");
		    	   long  bookCode = Long.parseLong(sc.nextLine());
		    	   System.out.println("Enter Book Name: ");
                   String bookName = sc.nextLine();
                   System.out.println("Enter Book Author Name: ");
                   String bookAuthor = sc.nextLine();
                   
                   System.out.println("Enter the book Price: ");
                   float bookPrice = Float.parseFloat(sc.nextLine());
                   
                   System.out.println("Enter the book Qty: ");
                   int bookQty = Integer.parseInt(sc.nextLine());
                   
                   Class.forName("oracle.jdbc.driver.OracleDriver");
                   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ganesh","ganesh");
                   
                   Statement st = con.createStatement();
                   
                   int result = st.executeUpdate("INSERT INTO BOOKDETAILS(BCODE,BNAME,BAUTHOR,BPRICE,BQTY)VALUES("+bookCode+",'"+bookName+"','"+bookAuthor+"',"+bookPrice+","+bookQty+")");
                		   
                   if(result>0) {
                	     System.out.println("Data Inserted Successfully in the bookdetails table..!");
                   }else {
                	    System.out.println("Data insertion failed..!");
                   }
                   
                   
                   
		     }catch(ClassNotFoundException e) {
		    	   e.printStackTrace();
		     }catch(SQLException e) {
		    	   e.printStackTrace();
		     }catch(Exception e) {
		    	   e.printStackTrace();
		     }
	}
}
