package com.ganesh.assignment;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.ganesh.databaseConnection.DatabaseConnection;
public class Assignment1 {
    public static void main(String[] args) {
		    try {
		    	Connection con = DatabaseConnection.getConnection();
		    	Statement st = con.createStatement();
		    	ResultSet rs = st.executeQuery("select *from BookDetails68");
		    	System.out.println("BookCode BookName BookAuthour BookPrice BookQty");
		    	while(rs.next()) {
		    		  System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4)+"\t"+rs.getInt(5));
		    	}
		    	  
		    }catch(SQLException e) {
		    	  e.printStackTrace();
		    }catch(Exception e) {
		    	  e.printStackTrace();
		    }
	}
}
