package action.emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import action.Action;
import service.EmpService;
import service.EmpServiceImple;

public class EmpRemoveAction implements Action {
	private static Logger log = LoggerFactory.getLogger(EmpRemoveAction.class);

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		EmpService esv = new EmpServiceImple();
		
		int isCom = esv.delete(Integer.parseInt(req.getParameter("empno")));
		log.info(">>> Product Modify > {}", isCom > 0 ? "Success" : "Fail");
	}

}
