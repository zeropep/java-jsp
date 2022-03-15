package product;

import java.util.ArrayList;

public interface DAO {
	int insert(Product item);
	ArrayList<Product> selectList();
	Product selectOneByPno(int pno);
	ArrayList<Product> selectOneByPname(String pname);
	ArrayList<Product> selectOneByMadeby(String madeby);
	int update(int pno, Product item);
	int delete(int pno);
}
