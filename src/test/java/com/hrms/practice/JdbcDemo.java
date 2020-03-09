package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JdbcDemo {

	String dbUrl="jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
	String dbUsername="syntax_hrm";
	String dbPassword=	"syntaxhrm123";	

	@Test
	public void dataBaseDemo() throws SQLException {
		System.out.println("nextline");
		//creating connection
		Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		System.out.println("Connection is created");
		//create statement
		Statement st =connection.createStatement();
		ResultSet rs =st.executeQuery("select * from ohrm_nationality");
		rs.next();
		String firstRowData =rs.getString("name");
		rs.next();
		String secondRowData = rs.getObject("name").toString();
		System.out.println(secondRowData);
		System.out.println("AFTER  SECOND ROW");
		String data;
		while(rs.next()) {
			data = rs.getObject("name").toString();
			System.out.println(data);
		}
		rs.close();
		st.close();
		
		connection.close();
}   
}
