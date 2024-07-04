package jdbc;

import java.sql.*;

public class PreparedStatementEx {
public static void main(String[] args) {
	testPreparedStatementPerformance();
testStatementPerformance();
}

	private static void testPreparedStatementPerformance() {
		Connection connection =null;
		//Load the driver class
		try {
	//		Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded!");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "mysql");
			System.out.println("Connection established!");
			PreparedStatement  statement = connection.prepareStatement("insert into user (user_id, email, first_name, last_name) values (?,?,?,?)");
			System.out.println("Statement created");



	long startTime = System.currentTimeMillis();
			for(int i = 1; i<10001; i++){
	//			insert into user values (?,?,?,'ln101')
				statement.setString(4,"ln" +(i+100));
				//			insert into user values (1,?,?,'ln101')
				statement.setInt(1,i);//1 specifies the first parameter in the query
				//			insert into user values (1,test.com,?,'ln101')
				statement.setString(2,"test.com" + i);
				//			insert into user values (1,'text.com','fn1','ln101')
				statement.setString(3,"fn"+i);
	//			statement.setString(4,new Scanner(System.in).nextLine());

				statement.executeUpdate();
			}
			long endTime = System.currentTimeMillis();
			System.out.println("Time taken: " + (endTime - startTime) + "ms");


		}
	//	catch (ClassNotFoundException e) {
	//		// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private static void testStatementPerformance() {
		Connection connection =null;
		//Load the driver class
		try {
			//		Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded!");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "mysql");
			System.out.println("Connection established!");
			Statement statement = connection.createStatement();
			System.out.println("Statement created");



			long startTime = System.currentTimeMillis();
			for(int i = 1; i<10001; i++){
				String query = "insert into user (user_id, email, first_name, last_name) values (" + i + ",'test.com" + i + "','fn" + i + "','ln" + (i+100) + "')";
				statement.executeUpdate(query);
			}
			long endTime = System.currentTimeMillis();
			System.out.println("Time taken: " + (endTime - startTime) + "ms");
			//int noOfRows = statement.executeUpdate("update user set email = 'newmail@nm.com'");
			//		int noOfRows = statement.executeUpdate("update user set email = 'asf@nm.com' where id = 102");
			//			System.out.println(noOfRows + " updated!");

			//		int noOfRows = statement.executeUpdate("delete from user  where id = 102 ");
			//		System.out.println(noOfRows + " deleted!");


		}
		//	catch (ClassNotFoundException e) {
		//		// TODO Auto-generated catch block
		//		e.printStackTrace();
		//	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
