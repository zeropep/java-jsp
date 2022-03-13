package repository;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBConnector {
	private static Logger log = LoggerFactory.getLogger(DBConnector.class);
	
	public static Connection getConnection() {
		Connection cn = null;
		try {
			Context initContext = new InitialContext();
			// java가 java외의 자원을 java source로 바꿔주는 기술
			// JNDI(Java Naming and Directory Interface)
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			// 환경설정 context을 찾는다. 우리가 context.xml에 적은 내용이 java:/comp/env라는 이름으로 이미 설정되어 있음
			DataSource ds = (DataSource) envContext.lookup("jdbc/mysql");
			// DataSource는 db에서 connection pool을 사용하기 위해 만들어진 dataset이며, 그 이름이 jdbc/mysql이다.
			
			try {
				cn = ds.getConnection();
				// ds에서 getConnection을 하면 connection 정보를 가져올 수 있다.
			} catch (Exception e) {
				log.info(">>> DB 커넥션 오류");
				e.printStackTrace();
				return null;
			}
		} catch (Exception e) {
			log.info(">>> DBCP 설정 오류");
			e.printStackTrace();
			return null;
		}
		return cn;
	}
}
