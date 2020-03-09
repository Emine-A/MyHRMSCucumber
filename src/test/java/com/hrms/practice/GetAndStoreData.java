package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;



public class GetAndStoreData {

	String dbUrl="jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
	String dbUsername="syntax_hrm";
	String dbPassword=	"syntaxhrm123";	

	@Test
	public void getAndStoreData() throws SQLException {
		System.out.println("nextline");
		Connection con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);	
		Statement st =  con.createStatement();
		ResultSet rs =st.executeQuery("select * from ohrm_location;");
		
		ResultSetMetaData rsetMetaData=rs.getMetaData();
		
		List<Map<String,String>> listData = new ArrayList<>();
		Map<String,String> rowMap;
		
		while(rs.next()) {
			rowMap=new LinkedHashMap<>();
			
			for(int i=1;i<=rsetMetaData.getColumnCount();i++) {
				rowMap.put(rsetMetaData.getColumnName(i), rs.getObject(i).toString());	
			}
			listData.add(rowMap);
		}
		System.out.println(listData);
}
}