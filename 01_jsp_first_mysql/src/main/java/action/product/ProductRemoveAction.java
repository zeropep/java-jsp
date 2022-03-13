package action.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import action.Action;
import service.ProductService;
import service.ProductServiceImple;

public class ProductRemoveAction implements Action {
	private static Logger log = LoggerFactory.getLogger(ProductRemoveAction.class);

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		int pno = Integer.parseInt(req.getParameter("pno"));
		
		ProductService psv = new ProductServiceImple();
		
		int isDel = psv.remove(pno);
		log.info(">>> Product Modify > {}", isDel > 0 ? "Success" : "Fail");
	}

}
