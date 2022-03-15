package hotel;

import java.util.List;
import java.util.Scanner;

public class HotelMgr {
	Scanner sc = new Scanner(System.in);
	HotelService hsv = new HotelServiceImple();
	List<RoomVO> list = null;
	RoomVO roomvo = null;
	
	private String roomNum, uname = "";
	private int uage, ugen, isComplete = 0;
	
	public void buildHotel() {
		System.out.println("호텔의 층 수 설정 > ");
		int floorsOfHotel = sc.nextInt();
		System.out.println("각 층당 방 수 설정 > ");
		int roomsOfFloor = sc.nextInt();
		
		for (int i = 0; i < floorsOfHotel; i++) {
			for (int j = 0; j < roomsOfFloor; j++) {
				hsv.buildHotel(new RoomVO((i+1) + (j < 9 ? "0" : "") + (j+1)));
			}
		}
		System.out.println("호텔이 정상적으로 완성되었습니다.");
	}
	
	public void viewAllRoom() {
		list = hsv.getRoomList();
		for (RoomVO roomVO : list) {
			System.out.print(roomVO.getRno() + "번 방 : ");
			System.out.print(roomVO.isAvail() ? "입실가능\n" : "사용중\n");
		}
	}
	
	public void checkIn() {
		System.out.println("입실할 방 번호 > ");
		roomNum = sc.next();
		if (hsv.checkAvail(roomNum)) {
			System.out.println("예약자 명 > ");
			uname = sc.next();
			System.out.println("예약자 나이 > ");
			uage = sc.nextInt();
			System.out.println("예약자 성별 (남/여) > ");
			String inputGen = sc.next();
			ugen = inputGen.equals("남") ? 0 : 1;
			
			isComplete = hsv.checkIn(new RoomVO(roomNum, new UserVO(uname, uage, ugen)));
			System.out.println("입실 " + (isComplete > 0 ? "완료" : "실패"));
		} else {
			System.out.println("이미 사용중인 방입니다. 다른 방을 선택하세요.");
		}
	}
	
	public void CheckOut() {
		System.out.println("퇴실할 방 번호 > ");
		roomNum = sc.next();
		if (!hsv.checkAvail(roomNum)) {
			isComplete = hsv.checkOut(roomNum);
			System.out.println("퇴실 " + (isComplete > 0 ? "완료" : "실패"));
		} else {
			System.out.println("빈 방입니다. 다른 방을 선택하세요.");
		}
		
		hsv.checkOut(roomNum);
	}

	public void roomDetail() {
		System.out.println("확인할 방 번호 > ");
		roomNum = sc.next();
		
		roomvo = hsv.getRoomDetail(roomNum);
		System.out.println(roomvo);
	}

	public void UserInfo() {
		System.out.println("---- 현재 호텔의 이용자목록 ----");
		list = hsv.getUserList();
		for (RoomVO roomVO : list) {
			System.out.print(roomVO.getRno() + "호 사용자" + roomVO.getUser() + "\n");
		}
		System.out.println("확인할 고객 이름 > ");
		uname = sc.next();
		roomvo = hsv.getRoomDetailByUser(uname);
		System.out.println(roomvo);
	}
	
	public void resetHotel() {
		isComplete = hsv.removeAll();
		System.out.println("호텔 삭제" + (isComplete > 0 ? "완료" : "실패"));
	}

	
}
