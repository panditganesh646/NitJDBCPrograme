package com.ganesh.databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
     private static Connection con = null;
     private DatabaseConnection(){
    	 
     };
     static {
    	    try {
    	    	    Class.forName(DatabaseInfo.driver);
    	    	    con = DriverManager.getConnection(DatabaseInfo.dbUrl,DatabaseInfo.dbUname,DatabaseInfo.dbPassword);
    	    	    
    	    	    
    	    }catch(Exception e) {
    	    	  e.printStackTrace();
    	    }
     }
     public static Connection getConnection() {
    	   return con;
     }
}
