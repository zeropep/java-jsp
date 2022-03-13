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
import action.product.ProductDetailAction;
import action.product.ProductInsertAction;
import action.product.ProductListAction;
import action.product.ProductModifyAction;
import action.product.ProductRemoveAction;

public class ProductController extends HttpServlet {
	private static Logger log = LoggerFactory.getLogger(ProductController.class);
	private static final long serialVersionUID = 1L;
	// 이 class를 static으로 생성할 수 없으니, static처럼 사용할 수 있게 serial id를 준다.
	
	
	// 얘가 static이 되면 얘가 가지고있는 모든것들이 다 같이 올라가기 때문에 매핑으로 static처럼 만들어주는 것이다.
	// servlet mapping에서 .pd로 끝나는 파일을 productController에서 실행한다고 했으니,
	// HttpServlet 추상클래스를 extends해서 servlet화 시켜주는 것이다.
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); // view에서 java로 전송되는 데이터의 인코딩
		res.setCharacterEncoding("utf-8"); // java에서 view로 전송되는 데이터의 인코딩
		res.setContentType("text/html; charset=utf-8");
		// 화면출력을 담당하는 브라우저에 전달하는 문자코드
		// res는 결과적으로 브라우저로 보내야되기 때문에 contentType을 정확하게 기재해 주어야 한다.
		
		String uri = req.getRequestURI();
//		log.info(">>> uri > {}", uri);
		String context = req.getContextPath();
//		// uri에는 프로젝트 이름이 포함되어 나온다.
//		log.info(">>> context > {}", context);
		String path = uri.substring(context.length());
		log.info(">>> Controller > path > {}", path);
		
		Action action = null;
		String destpage = null;
		
		if (path.equals("/product/register.pd")) {
			destpage = "/product/register.jsp";
		} else if (path.equals("/product/insert.pd")) {
			// product folder 안에서 insert.pd를 요청했기 때문에 uri가 이러한 형식이다.
			action = new ProductInsertAction();
			action.execute(req, res);
			destpage = "list.pd";
			// redirect 방식.
		} else if (path.equals("/product/list.pd")) {
			// product folder상에서 insert.pd를 요청하고 바로 list.pd를 요청했기 때문에 위치값은 아직 product 폴더 안에 있다.
			action = new ProductListAction();
			action.execute(req, res);
			destpage = "/product/list.jsp";
		} else if (path.equals("/product/detail.pd") || path.equals("/product/modify.pd")) {
			action = new ProductDetailAction();
			action.execute(req, res);
			destpage = path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf("/") + 2).equals("d") 
					? "/product/detail.jsp" : "/product/modify.jsp";
		} else if (path.equals("/product/update.pd")) {
			action = new ProductModifyAction();
			action.execute(req, res);
			destpage = "detail.pd?pno=" + req.getParameter("pno");
		} else if (path.equals("/product/remove.pd")) {
			action = new ProductRemoveAction();
			action.execute(req, res);
			destpage = "list.pd";
		}
		RequestDispatcher rdp = req.getRequestDispatcher(destpage);
		rdp.forward(req, res);
	}
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		log.info(">>> doGet() > {}", req.getMethod());
//		log.info(">>> doGet() > {}", req.getRequestURI());
//		service(req, resp);
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		log.info(">>> doPost() > {}", req.getRequestURI());
//		service(req, resp);
//	}
	// 과거에는 doGet과 doPost를 만들고 service에게 위임해줬는데, servlet이 발전하면서 service가 doGet과 doPost까지 할 수 있게 해준다. (servlet 3.1 ~)
}
