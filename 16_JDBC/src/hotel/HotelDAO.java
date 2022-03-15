package hotel;

import java.util.List;

public interface HotelDAO {
	int insert(RoomVO roomvo);
	List<RoomVO> selectRoomList();
	List<RoomVO> selectUserList();
	RoomVO selectRoomDetail(String rno);
	RoomVO selectRoomDetailByUser(String uname);
	int update(RoomVO room);
	int update(String rno);
	boolean selectRoomAvail(String rno);
	int truncateHotel();
}
