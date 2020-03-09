package hrms.databaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import org.junit.Test;

public class ResultFromDB {

	String dbUrl="jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
	String dbUsername="syntax_hrm";
	String dbPassword=	"syntaxhrm123";	
	@Test
	public void getResultSetData() throws SQLException {
	Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
	Statement st = conn.createStatement();
	ResultSet rs =
	st.executeQuery("SELECT FIRST_NAME, LAST_NAME FROM EMPLOYEES WHERE JOB_ID='IT_PROG'");
	List<Map<String, String>> rsList = new ArrayList<>();
	while (rs.next()) {
	Map<String, String> rsMap = new HashMap<>(); 
	rsMap.put("FIRST_NAME", rs.getString("FIRST_NAME"));
	rsMap.put("Last_name", rs.getString("Last_name"));
	rsList.add(rsMap); }
	rs.close();
	st.close();
	conn.close();
	}
}