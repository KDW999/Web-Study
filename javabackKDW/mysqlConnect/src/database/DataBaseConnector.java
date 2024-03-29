package database;

import java.sql.Connection;
import java.sql.DriverManager;


// DB 파일과 연결 
public class DataBaseConnector {
	
    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/peed";
	private static final String USER_NAME = "root";
	private static final String USER_PASSWORD = "root";
	
	public static Connection createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			return DriverManager.getConnection(DATABASE_URL, USER_NAME, USER_PASSWORD);
		} catch (Exception e) {
			return null;
		}
		
	}
	
}
