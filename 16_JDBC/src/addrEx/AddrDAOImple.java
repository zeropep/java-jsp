package addrEx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddrDAOImple implements DataAccessObject{
	private Connection conn;
	private String query = "";
	private PreparedStatement pst;
	// pst란 ? 
	// database에 connection한 상태에서 어떠한 명령을 위해 객체를 담는 시작부터 ~ 어떤 결과가 나오는 때 까지 수행
	// database와 대화를 한다고 생각하면 편하다.
	
	public AddrDAOImple() {
		DataBaseConnect dbc = DataBaseConnect.getInstance();
		conn = dbc.getConnection();
	}
	// 나중에는 이 생성자도 single tone으로 앱 실행시 자동생성되게 만든다.
	
	@Override
	public int insert(Address addr) {
		query = "insert into addr values(?, ?, ?)";
		try {
			pst = conn.prepareStatement(query);
			// query값을 던지는 이유는 query가 완성되지 않았기 때문에 query값을 가져오기 위해서이다.
			// 이미 완성된 query라면 statement로 던지면 되지만 불편함때문에 쓰지는 않는다.
			pst.setString(1, addr.getName());
			// 위의 물음표(와일드카드)에 들어갈 index값과 그 value를 입력한다.
			// 단, 여기서의 index값은 database의 index값을 의미하며, database의 index는 1부터 시작함.
			pst.setString(2, addr.getTel());
			pst.setInt(3, addr.getAge());
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public ArrayList<Address> selectList() {
		query = "select * from addr order by age desc";
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			ArrayList<Address> list = new ArrayList<>();
			while (rs.next()) {
				list.add(new Address(rs.getString("name"), rs.getString("tel"), rs.getInt("age")));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public ArrayList<Address> selectName(String name) {
		query = "select * from addr where name = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
			// database에서 가져온 정보는 ResultSet의 데이터형식으로 가져온다.
			// size 또는 length는 측정불가.
			// iteration 형식으로 다음 요소가 있는지 확인하는 방식으로 내부 요소를 꺼낸다.
			ArrayList<Address> list = new ArrayList<>();
			while (rs.next()) {
				list.add(new Address(rs.getString("name"), rs.getString("tel"), rs.getInt("age")));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Override
	public Address selectTel(String tel) {
		query = "select * from addr where tel = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, tel);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return new Address(rs.getString("name"), rs.getString("tel"), rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Override
	public ArrayList<Address> selectAge(int age) {	
		query = "select * from addr where age = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, age);
			ResultSet rs = pst.executeQuery();
			ArrayList<Address> list = new ArrayList<>();
			while (rs.next()) {
				list.add(new Address(rs.getString("name"), rs.getString("tel"), rs.getInt("age")));
			}
			return list;			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int update(Address addr) {
		query = "update addr set tel = ?, age = ? where name = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, addr.getTel());
			pst.setInt(2, addr.getAge());
			pst.setString(3, addr.getName());
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int delete(String name) {
		query = "delete from addr where name = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, name);
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

}
