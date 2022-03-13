package action.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import action.Action;
import domain.ProductVO;
import service.ProductService;
import service.ProductServiceImple;

public class ProductListAction implements Action {
	private static Logger log = LoggerFactory.getLogger(ProductListAction.class);

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		ProductService psv = new ProductServiceImple();
		List<ProductVO> list = psv.getList();
		log.info(">>> product list > {}", list.size());
		
		req.setAttribute("list", list);
		
		// req.setAttribute(null, list);
		// 자바에서 request 객체에 이름=객체 라는 형태로 전송하는 방법 (자바 to 자바, 자바 to 브라우저)
		// req.getAttribute(null);
		// setAttribute("name", Obj)로 보낸 데이터를 받는 방법
		// req.getParameter(null);
		// String 타입의 단일 객체값만 가능
	}

}
