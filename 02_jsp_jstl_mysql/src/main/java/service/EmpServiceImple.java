package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.EmpVO;
import repository.EmpDAO;
import repository.EmpDAOImple;

public class EmpServiceImple implements EmpService {
	private static Logger log = LoggerFactory.getLogger(EmpServiceImple.class);
	private EmpDAO edao;
	
	public EmpServiceImple() {
		edao = new EmpDAOImple();
	}

	@Override
	public int register(EmpVO evo) {
		return edao.insert(evo);
	}

	@Override
	public List<EmpVO> getList() {
		return edao.selectList();
	}

	@Override
	public EmpVO getDetail(int empno) {
		return edao.selectOne(empno);
	}

	@Override
	public int modify(EmpVO evo) {
		return edao.update(evo);
	}

	@Override
	public int delete(int empno) {
		return edao.delete(empno);
	}

}
