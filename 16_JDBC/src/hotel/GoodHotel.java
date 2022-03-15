package hotel;

import java.util.Scanner;

public class GoodHotel {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HotelMgr hotel = new HotelMgr();
		
		boolean flag = true;
		int menu = 0;
		String save = "";
		
		System.out.println("======== Welcome to GoodHotel ========");
		System.out.println("기존 호텔을 이어서 관리하시겠습니까? (y/n)");
		save = sc.next();
		if (save.equals("y")) {
			
		} else {
			hotel.resetHotel();
			System.out.println("::::: Build Your Hotel ::::");
			hotel.buildHotel();	
		}
		
		while (flag) {
			System.out.println("<<<<<<<<<<<<<<<<<<< Select Menu >>>>>>>>>>>>>>>>>>>");
			System.out.println("1.객실현황  2.입실  3.퇴실  4.객실조회  5.투숙객조회  0.종료");
			menu = sc.nextInt();
			
			switch (menu) {
			case 1:
				hotel.viewAllRoom();
				break;
			case 2:
				hotel.checkIn();
				break;
			case 3:
				hotel.CheckOut();
				break;
			case 4:
				hotel.roomDetail();
				break;
			case 5:
				hotel.UserInfo();
				break;
			case 0:
				System.out.println("현재 호텔을 삭제하시겠습니까? (y/n)");
				save = sc.next();
				if (save.equals("y")) {
					hotel.resetHotel();
				} else if (save.equals("n")) {
				} else {
					System.out.println("y 또는 n 중에 선택하십시오.");
				}
				System.out.println("프로그램을 종료합니다.");					
				flag = false;
				break;

			default:
				System.out.println("정확한 메뉴 번호를 선택하세요.");
				break;
			}
		}
	}

}
