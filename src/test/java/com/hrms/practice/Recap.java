package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Recap {


	String dbUrl="jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
	String dbUsername="syntax_hrm";
	String dbPassword=	"syntaxhrm123";	

	@Test
	public void getAndStoreData() throws SQLException {
		System.out.println("nextline");
		Connection con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);	
		Statement st =  con.createStatement();
		ResultSet rs =st.executeQuery("select id,name,country_code from ohrm_location; ");
		
		List<Map<String,String>> listData = new ArrayList<>();
		
		while(rs.next()) {
			Map<String,String> map = new LinkedHashMap<>();
			map.put("id", rs.getObject("id").toString());
			map.put("name", rs.getObject("name").toString());
			map.put("country_code", rs.getObject("country_code").toString());
		listData.add(map);
		
		}
		
		System.out.println(listData);

	}
}