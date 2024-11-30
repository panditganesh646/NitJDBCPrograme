package com.ganesh.crudoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DisplayBankCustomer {
    public static void main(String[] args) {
		   Scanner sc = new Scanner(System.in);
		   try(sc;){
			     System.out.println("Enter the Account Number to show details: ");
			     long aNumber = sc.nextLong();
			     Class.forName("oracle.jdbc.driver.OracleDriver");
			     Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ganesh","ganesh");
			     Statement st = con.createStatement();
			     ResultSet rs = st.executeQuery("SELECT *FROM BANKCUSTOMER WHERE ACCNO = "+aNumber+"");
			     if(rs.next()) {
			    	   System.out.println("Customer-AccNo: "+rs.getInt(1));
			    	   System.out.println("Customer Name: "+rs.getString(2));
			    	   System.out.println("Customer Balance: "+rs.getFloat(3));
			    	   System.out.println("Customer AccType: "+rs.getString(4));
			     }else {
			    	   System.out.println("Invalid Account Number..!");
			     }
		   }catch(Exception e) {
			     e.printStackTrace();
		   }
	}
}
