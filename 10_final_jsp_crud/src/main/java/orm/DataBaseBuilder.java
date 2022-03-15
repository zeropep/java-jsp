package orm;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataBaseBuilder {
	private static Logger log = LoggerFactory.getLogger(DataBaseBuilder.class);
	// mybatis의 연결법을 사용할 예정
	// 데이터베이스를 마치 자신이 가지고있는것 처럼 처음의 db정보를 다 가져와서 저장하고, 이를 세션이라고 한다.(sql session)
	// sql session factory를 사용해서 db의 상태를 가져온다.
	// 그리고 가져온 정보를 지속적으로 가지고 있다가 데이터를 요청할때 여기서 가져온다.
	private static SqlSessionFactory factory; 
	
	static {
		// 계속 가지고 있어야 하므로 static으로 만들어야 하므로 생성자는 public static이 불가능하다.
		// 그래서 나온 것이 DataBaseBuilder라는 빌더를 만들면(부르면) static처럼 사용할 수 있게 만들어 놓은 이 static 생성자 방식이다.
		// 해당 빌더를 불렀을 때만 static이 되므로 메모리 관리에 효율적이다.
		try {
			// java와 xml이 다르기 때문에 stream방식으로 가져오므로 try-catch구문이 필요하다.
			factory = new SqlSessionFactoryBuilder().build(
					// 세션 팩토리 빌더의 빌드라는 method를 사용해서 config를 넣자.
					Resources.getResourceAsReader("orm/MybatisConfig.xml"));			
			// 우리가 미리 넣어놨던 MybatisConfig.xml을 가져오자
		} catch (Exception e) {
			log.info(">>> Mybatis Config Error");
			e.printStackTrace();
		}
		// 다양한 상황에서 요청하기 때문에 구조의 병렬화가 필요하다.
	}
	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
}
