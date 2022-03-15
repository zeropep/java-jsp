package addrEx;

import java.util.ArrayList;

public interface DataAccessObject {
	// DAO : DataAccessObject. 다오라고 부른다.
	// db의 data에 접근해서 정보를 받아오고, 이를 서비스에 넘겨주는 중간역할.
	int insert(Address addr);
	ArrayList<Address> selectList();
	ArrayList<Address> selectName(String name);
	Address selectTel(String tel);
	ArrayList<Address> selectAge(int age);
	int update(Address addr);
	int delete(String name);
}
