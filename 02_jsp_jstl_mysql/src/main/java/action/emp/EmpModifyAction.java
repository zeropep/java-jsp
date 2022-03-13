package action.emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import action.Action;
import domain.EmpVO;
import service.EmpService;
import service.EmpServiceImple;

public class EmpModifyAction implements Action {
	private static Logger log = LoggerFactory.getLogger(EmpModifyAction.class);

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		EmpService esv = new EmpServiceImple();
		
		int isCom = esv.modify(new EmpVO(Integer.parseInt(req.getParameter("empno")), 
										req.getParameter("ename"), 
										req.getParameter("job"), 
										Integer.parseInt(req.getParameter("mgr")), 
										req.getParameter("hiredate"), 
										Integer.parseInt(req.getParameter("sal")), 
										Integer.parseInt(req.getParameter("comm")), 
										Integer.parseInt(req.getParameter("deptno"))));
		log.info("Emp Modify > {}", isCom > 0 ? "Success" : "Fail");
	}

}
