package hotel;

import java.util.List;

public interface HotelService {
	int buildHotel(RoomVO roomvo);
	List<RoomVO> getRoomList();
	List<RoomVO> getUserList();
	RoomVO getRoomDetail(String rno);
	RoomVO getRoomDetailByUser(String uname);
	int checkIn(RoomVO room);
	int checkOut(String rno);
	boolean checkAvail(String rno);
	int removeAll();
}
