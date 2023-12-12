package com.CRM.VTiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabase {

	public static void main(String[] args) throws Throwable {
		
		//load and register the driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//get the connection from mysql db
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sayandb", "root", "Sd@13011997");
		 
		 //create a statement
		 Statement statement = conn.createStatement();
		 
		 ResultSet result = statement.executeQuery("select * from testyantra where ename='sayan';");
		 
		 while(result.next()) {
			 String data = result.getInt(1)+" "+result.getString(2)+" "+result.getString(3);
			//to execute single cell data
			// String data = result.getString(2);
			 System.out.println(data);
		 }

	}

}
