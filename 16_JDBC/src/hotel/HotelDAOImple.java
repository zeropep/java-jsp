package hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelDAOImple implements HotelDAO {
	private Connection conn;
	private PreparedStatement pst;
	private String query = "";
	
	public HotelDAOImple() {
		DBConnect dbc = DBConnect.getInstance();
		conn = dbc.getConnection();
	}
	
	@Override
	public int insert(RoomVO roomvo) {
		query = "insert into room (rno) values (?)";
			try {
				pst = conn.prepareStatement(query);
				pst.setString(1, roomvo.getRno());
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
	public List<RoomVO> selectRoomList() {
		query = "select rno, isavail from room";
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			List<RoomVO> list = new ArrayList<>();
			while (rs.next()) {
				list.add(new RoomVO(rs.getString("rno"), rs.getBoolean("isavail")));
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
	public List<RoomVO> selectUserList() {
		query = "select rno, uname, uage, ugen from room where isavail = false";
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			List<RoomVO> list = new ArrayList<>();
			while (rs.next()) {
				list.add(new RoomVO(rs.getString("rno"), new UserVO(rs.getString("uname"), rs.getInt("uage"), rs.getInt("ugen"))));
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
	public RoomVO selectRoomDetail(String rno) {
		query = "select * from room where rno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, rno);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				UserVO user = new UserVO(rs.getString("uname"), rs.getInt("uage"), rs.getInt("ugen"));
				return new RoomVO(rs.getString("rno"),
								user, 
								rs.getBoolean("isavail"), 
								rs.getString("checkintime"),
								rs.getString("checkouttime"));
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
	public RoomVO selectRoomDetailByUser(String uname) {
		query = "select * from room where uname = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, uname);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				UserVO user = new UserVO(rs.getString("uname"), rs.getInt("uage"), rs.getInt("ugen"));
				return new RoomVO(rs.getString("rno"),
								user, 
								rs.getBoolean("isavail"), 
								rs.getString("checkintime"),
								rs.getString("checkouttime"));
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
	public int update(RoomVO room) {
		query = "update room"
				+ " set uname = ?, uage = ?, ugen = ?, isavail = false, checkintime = now()"
				+ " where rno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, room.getUser().getName());
			pst.setInt(2, room.getUser().getAge());
			pst.setInt(3, room.getUser().getGen());
			pst.setString(4, room.getRno());
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
	public int update(String rno) {
		query = "update room"
				+ " set uname = null, uage = null, ugen = null, isavail = true, checkintime = null, checkouttime = now()"
				+ " where rno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, rno);
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
	public boolean selectRoomAvail(String rno) {
		query = "select isavail from room where rno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, rno);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getBoolean("isavail");
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
		return false;
	}

	@Override
	public int truncateHotel() {
		query = "TRUNCATE room";
		try {
			pst = conn.prepareStatement(query);
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}



}
