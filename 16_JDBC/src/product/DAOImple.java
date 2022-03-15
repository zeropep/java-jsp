package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOImple implements DAO{
	private Connection conn;
	private String query = "";
	private PreparedStatement pst;
	
	public DAOImple() {
		ShopConnect dao = ShopConnect.getInstance();
		conn = dao.getConnection();
	}

	@Override
	public int insert(Product item) {
		query = "insert into product (pname, price, madeby) values(?, ?, ?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, item.getPname());
			pst.setInt(2, item.getPrice());
			pst.setString(3, item.getMadeby());
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
	public ArrayList<Product> selectList() {
		query = "select pno, pname, price from product";
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			ArrayList<Product> list = new ArrayList<>();
			while (rs.next()) {
				list.add(new Product(rs.getInt("pno"), rs.getString("pname"), rs.getInt("price")));
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
	public Product selectOneByPno(int pno) {
		query = "select * from product where pno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return new Product(rs.getInt("pno"), 
						rs.getString("pname"), 
						rs.getInt("price"), 
						rs.getString("regdate"), 
						rs.getString("madeby"));
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
	public ArrayList<Product> selectOneByPname(String pname) {
		query = "select * from product where pname = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, pname);
			ResultSet rs = pst.executeQuery();
			ArrayList<Product> list = new ArrayList<>();
			while (rs.next()) {
				list.add(new Product(rs.getInt("pno"), 
						rs.getString("pname"), 
						rs.getInt("price"), 
						rs.getString("regdate"), 
						rs.getString("madeby")));
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
	public ArrayList<Product> selectOneByMadeby(String madeby) {
		query = "select * from product where madeby = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, madeby);
			ResultSet rs = pst.executeQuery();
			ArrayList<Product> list = new ArrayList<>();
			while (rs.next()) {
				list.add(new Product(rs.getInt("pno"), 
						rs.getString("pname"), 
						rs.getInt("price"), 
						rs.getString("regdate"), 
						rs.getString("madeby")));
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
	public int update(int pno, Product item) {
		query = "update product set pname = ?, price = ?, regdate = now(), madeby = ? where pno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, item.getPname());
			pst.setInt(2, item.getPrice());
			pst.setString(3, item.getMadeby());
			pst.setInt(4, pno);
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
	public int delete(int pno) {
		query = "delete from product where pno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
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
