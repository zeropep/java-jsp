package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import repository.CommentDAO;
import repository.CommentDAOImple;

public class CommentServiceImple implements CommentService {
	private static Logger log = LoggerFactory.getLogger(CommentServiceImple.class);
	private CommentDAO cdao;
	
	public CommentServiceImple() {
		cdao = new CommentDAOImple();
	}

	@Override
	public int register(CommentVO cvo) {
		return cdao.insert(cvo);
	}

	@Override
	public List<CommentVO> getList(long pno) {
		return cdao.selectList(pno);
	}

	@Override
	public int modify(CommentVO cvo) {
		return cdao.update(cvo);
	}

	@Override
	public int remove(long cno) {
		return cdao.delete(cno);
	}

}
