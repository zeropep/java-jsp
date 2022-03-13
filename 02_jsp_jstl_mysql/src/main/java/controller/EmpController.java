package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import action.Action;
import action.emp.EmpDetailAction;
import action.emp.EmpInsertAction;
import action.emp.EmpListAction;
import action.emp.EmpModifyAction;
import action.emp.EmpRemoveAction;

public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(EmpController.class);
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		log.info(">>> Controller > path > {}", path);
		
		Action action = null;
		String destpage = null;
		
		if (path.equals("/emp/register.em")) {
			destpage = "/emp/register.jsp";
		} else if (path.equals("/emp/insert.em")) {
			action = new EmpInsertAction();
			action.execute(req, res);
			destpage = "list.em";
		} else if (path.equals("/emp/list.em")) {
			action = new EmpListAction();
			action.execute(req, res);
			destpage = "/emp/list.jsp";
		} else if (path.equals("/emp/detail.em") || path.equals("/emp/modify.em")) {
			action = new EmpDetailAction();
			action.execute(req, res);
			destpage = path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf("/") + 2).equals("d")
					? "/emp/detail.jsp" : "/emp/modify.jsp";
		} else if (path.equals("/emp/update.em")) {
			action = new EmpModifyAction();
			action.execute(req, res);
			destpage = "/emp/detail.em?empno=" + req.getParameter("empno");
		} else if (path.equals("/emp/remove.em")) {
			action = new EmpRemoveAction();
			action.execute(req, res);
			destpage = "list.em";
		}
		RequestDispatcher rdp = req.getRequestDispatcher(destpage);
		rdp.forward(req, res);
	}
}
