package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DataBaseArrayList {

	String dbUrl="jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
	String dbUsername="syntax_hrm";
	String dbPassword= "syntaxhrm123";		
	
	@Test
	public void dataBaseDemo() throws SQLException {
	
		Connection con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		Statement st =con.createStatement();
		ResultSet rs =st.executeQuery("select * from ohrm_job_title");
		List<String>arrData = new ArrayList<>();
		
		while(rs.next()) {
			arrData.add(rs.getString("job_title"));
			
		}
		System.out.println(arrData);
	}
	
	
	
	
}
