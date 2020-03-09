package hrms.databaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class SqlTestingDemo {

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
		Statement statement =connection.createStatement();

		//execute query and store result from database in ResultSet Object
		ResultSet resultSet=statement
		//.executeQuery("select *from hs_hr_employees where emp_number<3700 order by emp_number");
		.executeQuery("select emp_firstname,emp_lastname from hs_hr_employees where emp_number <3700 order by emp_firstname");

		
		
		//get value from resultset
//		resultSet.next();
//		String columData=resultSet.getString("emp_firstname");
//		System.out.println(columData);
//		resultSet.next();
//		columData=resultSet.getString("emp_firstname");
//		System.out.println(columData);
		
		while(resultSet.next()) {
			//columData=
			System.out.println(resultSet.getString("emp_firstname"));
	//	System.out.println(columData);
		
		}
		//close all db collection
		resultSet.close();
		connection.close();
		statement.close();
	}

}
