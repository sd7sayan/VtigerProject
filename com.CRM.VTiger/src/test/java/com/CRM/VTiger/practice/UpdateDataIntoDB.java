package com.CRM.VTiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateDataIntoDB {

	public static void main(String[] args) throws SQLException {
		// load driver
		Driver driver = new Driver();
		//register the driver
		DriverManager.registerDriver(driver);
		
		//get the connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sayandb", "root", "Sd@13011997");
		
		//create statement
		Statement statement = conn.createStatement();
		
		//update the data 
		//statement.executeUpdate("update testyantra set ename = 'deepeka' where ename = 'pushkar'");
		statement.executeUpdate("insert into testyantra values (4,'karan','typ5');");

	}

}
