package hrms.databaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class DataBaseMetaData1 {
	String dbUrl="jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
	String dbUsername="syntax_hrm";
	String dbPassword=	"syntaxhrm123";	

	@Test
	public void dataBaseDemo() throws SQLException {
		System.out.println("nextline");
		//DatabaseMetaData will information about database by itself.
		Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		DatabaseMetaData dbMetaData = (DatabaseMetaData) connection.getMetaData();
		String dbName =dbMetaData.getDatabaseProductName();
		System.out.println("Database product Name is "+dbName);
		String dbVersion=dbMetaData.getDatabaseProductVersion();
		System.out.println("Database Product Version is "+dbVersion);
	}
	
	
	
}