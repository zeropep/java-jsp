package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ProductVO;

public class ProductDAOImple implements ProductDAO {
	private static Logger log = LoggerFactory.getLogger(ProductDAOImple.class);
	private Connection cn;
	private PreparedStatement pst;
	private ResultSet rs;
	private String sql;
	
	public ProductDAOImple() {
		cn = DBConnector.getConnection();
	}

	@Override
	public int insert(ProductVO pvo) {
		sql = "insert into product (pname, price, madeby) values (?, ?, ?)";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, pvo.getPname());
			pst.setInt(2, pvo.getPrice());
			pst.setString(3, pvo.getMadeBy());
			return pst.executeUpdate();
		} catch (SQLException e) {
			log.info(">>> DAO > insert() Error");
			e.printStackTrace();
		}
		// 보통은 finally로 연결을 끊어주겠지만, pooling을 사용하면 알아서 끊어주게된다.
		return 0;
	}

	@Override
	public List<ProductVO> selectList() {
		sql = "select pno, pname, price from product order by pno desc";
		List<ProductVO> list = new ArrayList<>();
		try {
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new ProductVO(rs.getInt("pno"), rs.getString("pname"), rs.getInt("price")));
			}
			return list;
		} catch (Exception e) {
			log.info(">>> DAO > selectList() Error");
		}
		return null;
	}

	@Override
	public ProductVO selectOne(int pno) {
		sql = "select * from product where pno = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, pno);
			rs = pst.executeQuery();
			if (rs.next()) {
				return new ProductVO(rs.getInt("pno"),
									rs.getString("pname"),
									rs.getInt("price"),
									rs.getString("regdate"),
									rs.getString("madeby"));
			}
		} catch (SQLException e) {
			log.info(">>> DAO > selectOne() Error");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int update(ProductVO pvo) {
		sql = "update product set pname = ?, price = ?, regdate = now(), madeby = ?"
				+ "where pno = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, pvo.getPname());
			pst.setInt(2, pvo.getPrice());
			pst.setString(3, pvo.getMadeBy());
			pst.setInt(4, pvo.getPno());
			return pst.executeUpdate();
		} catch (Exception e) {
			log.info(">>> DAO > update() Error");
		}
		return 0;
	}

	@Override
	public int delete(int pno) {
		sql = "delete from product where pno = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, pno);
			return pst.executeUpdate();
		} catch (Exception e) {
			log.info(">>> DAO > delete() Error");
		}
		return 0;
	}

}
