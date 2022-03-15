package product_teacher;

import java.util.List;

public interface ProductDAO {
	int insert(ProductVO pvo);
	List<ProductVO> selectList();
	ProductVO selectOne(int pno);
	int update(ProductVO pvo);
	int delete(int pno);
}
