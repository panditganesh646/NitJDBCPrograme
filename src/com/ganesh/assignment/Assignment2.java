package com.ganesh.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
		   Scanner sc = new Scanner(System.in);
		   try(sc;){
			     System.out.println("Enter the Book code to show Book details: ");
			     int bookCode = sc.nextInt();
			     
			     Class.forName("oracle.jdbc.driver.OracleDriver");
			     
			     Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ganesh","ganesh");
			     
			     Statement st = con.createStatement();
			     ResultSet rs = st.executeQuery("SELECT *FROM BOOKDETAILS68 WHERE BOOKCODE = "+bookCode+"");
			     
			     if(rs.next()) {
			    	   System.out.println("Book Code: "+rs.getInt(1));
			    	   System.out.println("Book Name: "+rs.getString(2));
			    	   System.out.println("Book Author: "+rs.getString(3));
			    	   System.out.println("Book price: "+rs.getFloat(4));
			    	   System.out.println("Book Qty: "+rs.getInt(5));
			     }else {
			    	   System.out.println("Invalid Book Code..!");
			     }
			     
			     
		   }catch(Exception e) {
			    e.printStackTrace();
		   }
	}
}
