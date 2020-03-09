package hrms.databaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

import org.junit.Test;

public class ResultSetMetaData {
	
	String dbUrl="jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
	String dbUsername="syntax_hrm";
	String dbPassword=	"syntaxhrm123";	
	
	@Test
	public void dataBaseDemo() throws SQLException {
		System.out.println("nextline");
		//DatabaseMetaData will information about database by itself.
		Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		Statement st=connection.createStatement();
		ResultSet rs = st.executeQuery("select * from hs_hr_employees");
       java.sql.ResultSetMetaData rrsMetaData = rs.getMetaData();
       rrsMetaData.getColumnName(2);
	
	}
}





