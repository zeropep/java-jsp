package product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ShopConnect {
	private static ShopConnect sct = new ShopConnect();
	private Connection conn = null;
	private String jdbcDriver = "com.mysql.jdbc.Driver";
	private String jdbcUrl = "jdbc:mysql://localhost/javatest";
	
	private ShopConnect() {
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcUrl, "root", "mysql");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없음.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결 정보가 불일치함.");
			e.printStackTrace();
		}
	}
	
	public static ShopConnect getInstance() {
		return sct;
	}
	
	public Connection getConnection() {
		return conn;
	}
}
