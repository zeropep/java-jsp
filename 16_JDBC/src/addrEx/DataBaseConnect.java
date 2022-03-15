package addrEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// single tone 방식
// data가 필요할 때마다 database에 접근하면 사용량이 많으므로,
// 처음 data를 받아올 때 static으로 올려두고 사용한다.
// 물론 현재는 이보다 더 발전된 방식이 있음.
public class DataBaseConnect {
	private static DataBaseConnect dbc = new DataBaseConnect();
	
	// 연결에 관련된 정의가 되어있는 interface
	private Connection conn = null;
	
	// 연결에 필요한 두가지(원래는 4개지만 일단은 두개)
	// 01. database와 java를 연결할 driver
	// 02. database의 위치값
	private String jdbcDriver = "com.mysql.jdbc.Driver"; // oracle의 경우 => oracle.jdbc.driver.OracleDriver
	private String jdbcUrl = "jdbc:mysql://localhost/javatest"; // oracle의 경우 => jdbc:oracle:thin:@localhost:1521:orcl
	
	private DataBaseConnect() {
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcUrl, "root", "mysql");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다."); // 라이브러리 연결 실패
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결 정보가 정확하지 않습니다.");
			e.printStackTrace();
		}
	}
	public static DataBaseConnect getInstance() {
		return dbc;
	}
	public Connection getConnection() {
		return conn;
	}
	// 위에는 다 private로 만들어 놓았기 때문에 외부에서 접근할 수 없음,
	// getInstance를 부르면 database에서 가져온 정보를 dbc에 올려놓고 사용.
	// 동시에 getconnection으로 가져온 conn으로 접근한다.
}
