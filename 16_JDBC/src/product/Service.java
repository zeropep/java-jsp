package product;

import java.util.ArrayList;

public interface Service {
	boolean register(Product item);
	ArrayList<Product> getList();
	Product getDetailByPno(int pno);
	ArrayList<Product> getDetailByPname(String pname);
	ArrayList<Product> getDetailByMadeby(String madeby);
	boolean modify(int pno, Product item);
	boolean remove(int pno);
}
