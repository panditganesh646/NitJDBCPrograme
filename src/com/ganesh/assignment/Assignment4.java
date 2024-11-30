package com.ganesh.assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.ganesh.databaseConnection.DatabaseConnection;
import com.ganesh.databaseConnection.DatabaseInfo;

public class Assignment4 {
    private static Connection con = DatabaseConnection.getConnection();
    private static PreparedStatement ps = null;
    private static Statement st = null;
    private static Scanner sc = null;

    public static void main(String[] args) {
         sc = new Scanner(System.in);
       try{
    	   
    	  
    	  Class.forName(DatabaseInfo.driver);
    	   while (true) {
               System.out.println("1. Add Product.");
               System.out.println("2. View All Products");
               System.out.println("3. View Product By Id");
               System.out.println("4. Update Product By Id");
               System.out.println("5. Delete Product By Id");
               System.out.println("6. Exit");

               System.out.print("Enter your choice: ");
               switch (sc.nextInt()) {
                   case 1:
                       addProduct();
                       break;
                   case 2:
                       viewAllProducts();
                       break;
                   case 3:
                       viewProductById();
                       break;
                   case 4:
                       updateProductById();
                       break;
                   case 5:
                       deleteProductById();
                       break;
                   case 6:
                       System.out.println("Application Stopped..!");
                       System.exit(0);
                       break;
                   default:
                       System.out.println("Invalid choice..!");
               }
           }
    	   
       }catch(ClassNotFoundException e) {
    	   e.printStackTrace();
       }catch(SQLException e) {
    	   e.printStackTrace();
       }catch(Exception e) {
    	     e.printStackTrace();
       }finally {
		  sc.close();
	    }
       
    }

    public static void addProduct() throws SQLException {
        ps = con.prepareStatement("INSERT INTO PRODUCT(PCODE, PNAME, PRICE) VALUES (?, ?, ?)");
        System.out.print("Enter Product Code: ");
        int pcode = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Product Name: ");
        String pname = sc.nextLine();
        System.out.print("Enter Product Price: ");
        float price = sc.nextFloat();

        ps.setInt(1, pcode);
        ps.setString(2, pname);
        ps.setFloat(3, price);
        int inserted = ps.executeUpdate();
        if (inserted > 0) {
            System.out.println("Data inserted Successfully...!");
        } else {
            System.out.println("Data insertion failed..!");
        }
    }

    public static void viewAllProducts() throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM PRODUCT");
        System.out.println("PCODE\tPNAME\tPRICE");
        while (rs.next()) {
            System.out.println(rs.getInt("PCODE") + "\t" + rs.getString("PNAME") + "\t" + rs.getFloat("PRICE"));
        }
    }

    public static void viewProductById() throws SQLException {
        System.out.print("Enter Product Code to view: ");
        int pcode = sc.nextInt();
        ps = con.prepareStatement("SELECT * FROM PRODUCT WHERE PCODE = ?");
        ps.setInt(1, pcode);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            System.out.println("PCODE: " + rs.getInt("PCODE"));
            System.out.println("PNAME: " + rs.getString("PNAME"));
            System.out.println("PRICE: " + rs.getFloat("PRICE"));
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void updateProductById() throws SQLException {
        System.out.print("Enter Product Code to update: ");
        int pcode = sc.nextInt();
        ps = con.prepareStatement("SELECT * FROM PRODUCT WHERE PCODE = ?");
        ps.setInt(1, pcode);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            System.out.print("Enter new Product Name: ");
            sc.nextLine();
            String pname = sc.nextLine();
            System.out.print("Enter new Product Price: ");
            float price = sc.nextFloat();

            ps = con.prepareStatement("UPDATE PRODUCT SET PNAME = ?, PRICE = ? WHERE PCODE = ?");
            ps.setString(1, pname);
            ps.setFloat(2, price);
            ps.setInt(3, pcode);
            int updated = ps.executeUpdate();
            if (updated > 0) {
                System.out.println("Product updated successfully.");
            } else {
                System.out.println("Product update failed.");
            }
        } else {
            System.out.println(" Product not found.");
        }
    }

    public static void deleteProductById() throws SQLException {
        System.out.print("Enter Product Code to delete: ");
        int pcode = sc.nextInt();
        ps = con.prepareStatement("DELETE FROM PRODUCT WHERE PCODE = ?");
        ps.setInt(1, pcode);
        int deleted = ps.executeUpdate();
        if (deleted > 0) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product deletion failed or not found.");
        }
    }
}