package addrEx;

import java.util.ArrayList;

public class AddrServiceImple implements Service {
	private DataAccessObject dao;
	public AddrServiceImple() {
		dao = new AddrDAOImple();
	}

	@Override
	public boolean register(Address addr) {
		return dao.insert(addr) > 0 ? true : false;
	}

	@Override
	public ArrayList<Address> getList() {
		return dao.selectList();
	}

	@Override
	public ArrayList<Address> getDetailByName(String name) {
		return dao.selectName(name);
	}

	@Override
	public Address getDetailByTel(String tel) {
		return dao.selectTel(tel);
	}

	@Override
	public ArrayList<Address> getDetailByAge(int age) {
		return dao.selectAge(age);
	}

	@Override
	public boolean modify(Address addr) {
		return dao.update(addr) > 0 ? true : false;
	}

	@Override
	public boolean remove(String name) {
		return dao.delete(name) > 0 ? true : false;
	}


}
