package addrEx;

import java.util.ArrayList;

// CRUD service 정의 > 가장 기본적인 작업
public interface Service {
	boolean register(Address addr);
	ArrayList<Address> getList();
	ArrayList<Address> getDetailByName(String name);
	Address getDetailByTel(String tel);
	ArrayList<Address> getDetailByAge(int age);
	boolean modify(Address addr);
	boolean remove(String name);
}
