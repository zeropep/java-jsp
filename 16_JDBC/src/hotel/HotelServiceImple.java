package hotel;

import java.util.List;

public class HotelServiceImple implements HotelService {
	private HotelDAO dao;
	
	public HotelServiceImple() {
		dao = new HotelDAOImple();
	}
	
	@Override
	public int buildHotel(RoomVO roomvo) {
		return dao.insert(roomvo);
	}

	@Override
	public List<RoomVO> getRoomList() {
		return dao.selectRoomList();
	}

	@Override
	public List<RoomVO> getUserList() {
		return dao.selectUserList();
	}
	
	@Override
	public RoomVO getRoomDetail(String rno) {
		return dao.selectRoomDetail(rno);
	}

	@Override
	public RoomVO getRoomDetailByUser(String uname) {
		return dao.selectRoomDetailByUser(uname);
	}
	
	@Override
	public int checkIn(RoomVO room) {
		return dao.update(room);
	}

	@Override
	public int checkOut(String rno) {
		return dao.update(rno);
	}

	@Override
	public boolean checkAvail(String rno) {
		return dao.selectRoomAvail(rno);
	}

	@Override
	public int removeAll() {
		return dao.truncateHotel();
	}



}
