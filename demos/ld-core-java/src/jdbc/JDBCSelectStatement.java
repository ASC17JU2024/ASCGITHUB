package jdbc;

import java.sql.*;

public class JDBCSelectStatement {
public static void main(String[] args) {
	Connection connection =null;
	//Load the driver class
	try {
//		Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
//		Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'.
//		The driver is automatically registered and manual loading of the driver class is generally unnecessary.
		System.out.println("Driver Loaded!");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "mysql");
		//connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "postgresql");
		System.out.println("Connection established!");
		Statement  statement = connection.createStatement();
		System.out.println("Statement created");
		ResultSet  resultSet = statement.executeQuery("select * from user order by user_id limit 5");
		System.out.println("Result set returned");
		while(resultSet.next()) {
//			System.out.println(resultSet.getInt(1));
//			System.out.println(resultSet.getString("email"));
//			System.out.println(resultSet.getString("last_name"));
			System.out.println("User Id: "+resultSet.getInt(1) + " Email: "+resultSet.getString("email") + " Last Name: "+resultSet.getString("last_name"));
			System.out.println("********");
		}
//		else
//		{
//			System.out.println("No data found!");
//		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

}
}
