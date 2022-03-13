package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.EmpVO;

public interface EmpService {
	public int register(EmpVO evo);
	public List<EmpVO> getList();
	public EmpVO getDetail(int empno);
	public int modify(EmpVO evo);
	public int delete(int empno);
}
