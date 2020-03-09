package utils;

public class APIConstants {

	public static final String  CREATE_GENARATE_TOKEN_URI="http://54.167.125.15/syntaxapi/api/generateToken.php";
	
	public static final String  CREATE_GENARATE_TOKEN_JSON=System.getProperty("user.dir")+"/src/test/resources/JSONFiles/genarateToken.json";

	public static final String CREATE_EMPLOYEE_URI="http://54.167.125.15/syntaxapi/api/createEmployee.php";

	public static final String CREATE_EMPLOYEE_JSON=System.getProperty("user.dir")+"/src/test/resources/JSONFiles/createEmployee.json";

	public static final String CREATE_USER_URI ="http://54.167.125.15/syntaxapi/api";

	public static final String  GET_ALL_EMPLOYEE_URI="http://54.167.125.15/syntaxapi/api/getAllEmployees.php";

	public static final String GET_ONE_EMPLOYEE_URI="http://54.167.125.15/syntaxapi/api/getOneEmployee.php";

	public static final String GET_EMPLOYEE_STATUS_URI="http://54.167.125.15/syntaxapi/api/employeeStatus.php";

	public static final String PUT_UPDATE_EMPLOYEE_URI="http://54.167.125.15/syntaxapi/api/updateEmployee.php";
	
	public static final String UPDATE_EMPLOYEE_JSON=System.getProperty("user.dir")+"/src/test/resources/JSONFiles/updateEmployee.json";
	public static final String DELETE_EMPLOYEE_URI="54.167.125.15/syntaxapi/api/deleteEmployee.php";

}
