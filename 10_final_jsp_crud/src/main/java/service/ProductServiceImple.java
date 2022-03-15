package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ProductVO;
import repository.CommentDAO;
import repository.ProductDAO;
import repository.ProductDAOImple;

public class ProductServiceImple implements ProductService {
	private static Logger log = LoggerFactory.getLogger(ProductServiceImple.class);
	private ProductDAO pdao;
	
	public ProductServiceImple() {
		pdao = new ProductDAOImple();
	}

	@Override
	public int register(ProductVO pvo) {
		return pdao.insert(pvo);
	}

	@Override
	public List<ProductVO> getList() {
		return pdao.selectList();
	}

	@Override
	public ProductVO getDetail(long pno) {
		ProductVO pvo = pdao.selectOne(pno);
		int isUp = pdao.updateRC(pno);
		pvo.setReadCount(pvo.getReadCount() + isUp);
		return pvo;
	}

	@Override
	public int modify(ProductVO pvo) {
		return pdao.update(pvo);
	}

	@Override
	public int remove(long pno) {
		return pdao.delete(pno);
	}
	// AOP (Oriented Project)
	// service는 단순히 가교역할만 하는것이 아니라, readcount를 올린다거나 정보를 미리 확인하느 등 실제로 일어나는 일을 service단에서 실행한다.
	// DAO는 단순히 query의 수행역할만 담당한다.
	
}
