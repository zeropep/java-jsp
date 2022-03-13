package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.EmpVO;

public class EmpDAOImple implements EmpDAO {
	private static Logger log = LoggerFactory.getLogger(EmpDAOImple.class);
	private Connection cn;
	private PreparedStatement pst;
	private ResultSet rs;
	private String sql;
	
	public EmpDAOImple() {
		cn = DBConnector.getConnection();
	}

	@Override
	public int insert(EmpVO evo) {
		sql = "insert into emp (empno, ename, job, hiredate)"
				+ " values (?, ?, ?, ?)";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, evo.getEmpno());
			pst.setString(2, evo.getEname());
			pst.setString(3, evo.getJob());
			pst.setString(4, evo.getHiredate());
			return pst.executeUpdate();
		} catch (Exception e) {
			log.info(">>> DAO > insert() Error");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<EmpVO> selectList() {
		sql = "select empno, ename, job, deptno from emp order by empno";
		List<EmpVO> list = new ArrayList<>();
		try {
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new EmpVO(rs.getInt("empno"),
									rs.getString("ename"),
									rs.getString("job"),
									rs.getInt("deptno")));
			}
			return list;
		} catch (Exception e) {
			log.info(">>> DAO > selectList() Error");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public EmpVO selectOne(int empno) {
		sql = "select * from emp where empno = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, empno);
			rs = pst.executeQuery();
			if (rs.next()) {
				return new EmpVO(rs.getInt("empno"),
								rs.getString("ename"),
								rs.getString("job"),
								rs.getInt("mgr"),
								rs.getString("hiredate"),
								rs.getInt("sal"),
								rs.getInt("comm"),
								rs.getInt("deptno"));
			}
		} catch (Exception e) {
			log.info(">>> DAO > selectOne() Error");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(EmpVO evo) {
		sql = "update emp set ename = ?, job = ?, mgr = ?, hiredate = ?,"
				+ "  sal = ?, comm = ?, deptno = ? where empno = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, evo.getEname());
			pst.setString(2, evo.getJob());
			pst.setInt(3, evo.getMgr());
			pst.setString(4, evo.getHiredate());
			pst.setDouble(5, evo.getSal());
			pst.setDouble(6, evo.getComm());
			pst.setInt(7, evo.getDeptno());
			pst.setInt(8, evo.getEmpno());
			return pst.executeUpdate();
		} catch (Exception e) {
			log.info(">>> DAO > update() Error");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int empno) {
		sql = "delete from emp where empno = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, empno);
			return pst.executeUpdate();
		} catch (Exception e) {
			log.info(">>> DAO > delete() Error");
			e.printStackTrace();
		}
		return 0;
	}

}
