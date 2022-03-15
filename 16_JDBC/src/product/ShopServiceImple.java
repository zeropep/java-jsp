package product;

import java.util.ArrayList;

public class ShopServiceImple implements Service {
	private DAO dao;
	
	public ShopServiceImple() {
		dao = new DAOImple();
	}
	
	@Override
	public boolean register(Product item) {
		return dao.insert(item) > 0 ? true : false;
	}

	@Override
	public ArrayList<Product> getList() {
		return dao.selectList();
	}

	@Override
	public Product getDetailByPno(int pno) {
		return dao.selectOneByPno(pno);
	}

	@Override
	public ArrayList<Product> getDetailByPname(String pname) {
		return dao.selectOneByPname(pname);
	}

	@Override
	public ArrayList<Product> getDetailByMadeby(String madeby) {
		return dao.selectOneByMadeby(madeby);
	}

	@Override
	public boolean modify(int pno, Product item) {
		return dao.update(pno, item) > 0 ? true : false;
	}

	@Override
	public boolean remove(int pno) {
		return dao.delete(pno) > 0 ? true : false;
	}

}
