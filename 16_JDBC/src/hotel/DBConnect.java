package hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	private static DBConnect dbc = new DBConnect();
	private Connection conn = null;
	private String jdbcDriver = "com.mysql.jdbc.Driver";
	private String jdbcUrl = "jdbc:mysql://localhost/javatest";
	
	private DBConnect() {
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcUrl, "root", "mysql");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결 정보가 정확하지 않습니다");
			e.printStackTrace();
		}
	}
	public static DBConnect getInstance() {
		return dbc;
	}
	public Connection getConnection() {
		return conn;
	}
}
