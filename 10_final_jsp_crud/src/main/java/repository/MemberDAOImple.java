package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import orm.DataBaseBuilder;

public class MemberDAOImple implements MemberDAO {
	private static Logger log = LoggerFactory.getLogger(MemberDAOImple.class);
	private SqlSession sql;
	private final String ns = "MemberMapper.";
	
	public MemberDAOImple() {
		new DataBaseBuilder();
		sql = DataBaseBuilder.getFactory().openSession();
		// session을 열어서 사용자가 각각의 세션을 가진다.
		// 이 세션을 아래의 다양한 곳에서 사용해야 하기 때문에 전역변수로 지정한다.
		// sql이 요청을 받을때 어디에서 오는지 알게 하기 위해서 ns(name space)를 가져야 한다.
		// 여기서는 ns를 membermapper라고 정한 것 뿐이다.
		// 이 ns이름은 mybatisconfig에 등록해야 한다.(주의할점은 이름이 아니라 파일 자체를 등록하는 것이다.)
		// 그리고 그 xml파일 내용에 namespace를 등록하는 부분이 있고 여기에 설정한 ns와 같아야 한다.
	}

	@Override
	public int insert(MemberVO mvo) {
		int isUp = sql.insert(ns+"reg", mvo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
		// MemberMapper.xml에 membermapper를 사용하는데 어떤 쿼리를 부를지 결정하는 것을 ns+"..."로 한다.
		// DAO의 모양만 다르지 preparedstatement와 executeupdate를 다 해주는 역할은 같다.
		// query에 변수는 #{}로 넣어야 하는 것을 잊지말자
		// try-catch도 다 해준다.
		// 단 우리는 라이브러리만 갖다가 쓰는 것이기 때문에 최적화가 안되있어서 commit을 수동으로 해주어야 한다.(executeupdate일 경우)
	}

	@Override
	public List<MemberVO> selectList() {
		return sql.selectList(ns+"list");
		// selectList라는 객체를 부르면 애초에 List타입을 반환해준다.
		// 단지 resultType으로 그 리스트에 담길 타입인 MemberVO만 지정해주면 된다.
		// 어차피 객체로 만들어주기 때문에 rs를 받아와서 객체로 만들어줄 필요가 없다.
	}

	@Override
	public MemberVO selectOne(String email) {
		return sql.selectOne(ns+"detail", email);
	}

	@Override
	public int update(MemberVO mvo) {
		int isUp = sql.update(ns+"mod", mvo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int delete(String email) {
		int isUp = sql.delete(ns+"del", email);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public MemberVO selectOne(MemberVO mvo) {
		return sql.selectOne(ns+"login", mvo);
	}

	@Override
	public void update(String email) {
		int isUp = sql.update(ns+"lastLogin", email);
		if (isUp > 0) sql.commit();
	}

}
