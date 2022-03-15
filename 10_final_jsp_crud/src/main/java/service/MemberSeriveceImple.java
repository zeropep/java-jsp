package service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImple;

public class MemberSeriveceImple implements MemberService {
	private static Logger log = LoggerFactory.getLogger(MemberSeriveceImple.class);
	private MemberDAO mdao;
	// 사실 다 나뉘어져 있기 때문에 dao로 통일해도 되지만 나중에는 구분해줘야 할 경우도 있다.
	
	public MemberSeriveceImple() {
		mdao = new MemberDAOImple();
	}

	@Override
	public int register(MemberVO mvo) {
		return mdao.insert(mvo);
	}

	@Override
	public List<MemberVO> getList() {
		return mdao.selectList();
	}

	@Override
	public MemberVO getDetail(String email) {
		return mdao.selectOne(email);
	}

	@Override
	public int modify(MemberVO mvo) {
		return mdao.update(mvo);
	}

	@Override
	public int remove(String email) {
		return mdao.delete(email);
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		MemberVO loginMvo = mdao.selectOne(mvo);
		if (loginMvo != null) mdao.update(mvo.getEmail());
		loginMvo.setLastLogin(LocalDateTime.now().toString());
		return loginMvo;
		// 원래는 마지막 로그인시간을 update하고 그걸 다시 select해와야 한다.
		// 하지만 그러기 위해서는 update와 select사이에 어떠한 간섭도 일어나선 안되며, 이를 보증해주는 기술이 필요하다.
		// jsp에서는 이러한 transaction 기술이 잘 없으며.. 그래서 그냥 따로 넣어주는 것으로 한다.
	}

}
