package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ProductVO;
import service.ProductService;
import service.ProductServiceImple;

@WebServlet("/prodCtrl/*")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	private final ProductService psv;
	private RequestDispatcher rdp;
	private int isUp;
	
	public ProductController() {
		psv = new ProductServiceImple();
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html charset=utf-8");
		
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		log.info(path);
		
		switch (path) {
		case "register":
			req.getRequestDispatcher("/product/register.jsp").forward(req, res);
			break;
		case "insert":
			isUp = psv.register(new ProductVO(req.getParameter("pname"),
											Integer.parseInt(req.getParameter("price")),
											req.getParameter("madeBy"),
											req.getParameter("writer"),
											req.getParameter("category"),
											req.getParameter("desc"),
											null));
			log.info(">>> prod register {}", isUp > 0 ? "Success" : "Fail");
			req.getRequestDispatcher("prodCtrl/list").forward(req, res);
			break;
		case "list":
			req.setAttribute("list", psv.getList());
			req.getRequestDispatcher("/product/list.jsp").forward(req, res);
			break;
		case "detail":
			req.setAttribute("pvo", psv.getDetail(Long.parseLong(req.getParameter("pno"))));
			req.getRequestDispatcher("/product/detail.jsp").forward(req, res);
			break;
		case "modify":
			req.setAttribute("pvo", psv.getDetail(Long.parseLong(req.getParameter("pno"))));
			req.getRequestDispatcher("/product/modify.jsp").forward(req, res);
			break;
		case "update":
			isUp = psv.modify(new ProductVO(Long.parseLong(req.getParameter("pno")),
														req.getParameter("pname"),
														Integer.parseInt(req.getParameter("price")),
														req.getParameter("madeBy"),
														req.getParameter("category"),
														req.getParameter("desc"),
														null));
			log.info(">>> prod update {}", isUp > 0 ? "Success" : "Fail");
			req.getRequestDispatcher("prodCtrl/detail?pno=" + req.getParameter("pno")).forward(req, res);
			break;
		case "remove":
			isUp = psv.remove(Long.parseLong(req.getParameter("pno")));
			log.info(">>> prod delete {}", isUp > 0 ? "Success" : "Fail");
			req.getRequestDispatcher("/prodCtrl/list").forward(req, res);
			break;

		default:
			break;
		}
	}

}
