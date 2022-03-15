package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import service.MemberSeriveceImple;
import service.MemberService;

@WebServlet("/memCtrl/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	private final MemberService msv;
	private RequestDispatcher rdp;
	private int isUp;
	
	public MemberController() {
		msv = new MemberSeriveceImple();
	}
	// 스프링 프레임워크에는 이 생성자와 멤버서비스를 부르는 method가 이미 내장되어 있어서 이 생성자가 필요 없다.
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		// @WebServlet("/memCtrl?svc=register")로 하려면
		// path = req.getParameter("member")이렇게 부르면 register가 나온다.
		
		switch (path) {
		case "register":
			rdp = req.getRequestDispatcher("/member/register.jsp");
			rdp.forward(req, res);
			break;
		case "insert":
			isUp = msv.register(new MemberVO(req.getParameter("email"), req.getParameter("pwd"), req.getParameter("nickName")));
			log.info(">>> Join > {}", isUp > 0 ? "Success" : "Fail");
			// es.sendRedirect("/memCtrl/list");
			// redirect방식이 있지만 가지고있던 정보가 다 날아가기 때문에 추천되지 않는다.
			// 굳이 사용하는 경우에는 로그아웃정도에 가능하다.
			// 페이지를 이동하는 방법은 script를 만들어서 보내거나, redirect를 하는 방법이 있다.
			req.setAttribute("msg_reg", isUp);
			rdp = req.getRequestDispatcher("/index.jsp");
			rdp.forward(req, res);
			break;
		case "list":
			req.setAttribute("list", msv.getList());
			rdp = req.getRequestDispatcher("/member/list.jsp");
			rdp.forward(req, res);
			break;
		case "detail":
			req.setAttribute("mvo", msv.getDetail(req.getParameter("email")));
			req.getRequestDispatcher("/member/detail.jsp").forward(req, res);
			break;
		case "modify":
			isUp = msv.modify(new MemberVO(req.getParameter("email"),
										req.getParameter("pwd"), req.getParameter("nickName")));
			log.info(">>> Modify > {}", isUp > 0 ? "Success" : "Fail");
			req.getRequestDispatcher("/memCtrl/detail?email="+req.getParameter("email")).forward(req, res);
			break;
		case "remove":
			isUp = msv.remove(req.getParameter("email"));
			log.info(">>> Remove > {}", isUp > 0 ? "Success" : "Fail");
			HttpSession currSES = req.getSession();
			currSES.invalidate();
			req.setAttribute("msg_resign", 1);
			rdp = req.getRequestDispatcher("/index.jsp");
			rdp.forward(req, res);
			break;
		case "login":
			MemberVO mvo = msv.login(new MemberVO(req.getParameter("email"), req.getParameter("pwd")));
			// request는 page에서 다른 page로 넘어가면 req가 들고있는 값이 사라진다.
			// 이를 계속 유지시키기 위해서는 다른 객체를 사용해야하고, 그것이 session이다.
			if (mvo != null) {
				HttpSession ses = req.getSession();
				ses.setAttribute("ses", mvo);
				ses.setMaxInactiveInterval(60 * 10); // 초 단위
			} else {
				req.setAttribute("msg_login", 0);
			}
			rdp = req.getRequestDispatcher("/index.jsp");
			rdp.forward(req, res);
			break;
		case "logout":
			HttpSession currSes = req.getSession();
			currSes.invalidate();
			req.setAttribute("msg_logout", 1);
			rdp = req.getRequestDispatcher("/index.jsp");
			rdp.forward(req, res);
			break;

		default:
			break;
		}
	}

}
