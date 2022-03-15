package addrEx;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Service service = new AddrServiceImple();
		boolean flag = true;
		int age, menu = 0;
		String name, tel = null;
		
		
		System.out.println("------------ 주소록 시스템 -------------");
		while (flag) {
			System.out.println("메뉴를 선택하세요 > ");
			System.out.println("1.추가  2.전체검색  3.조회  4.수정  5.삭제  0.종료");
			menu = sc.nextInt();
			
			switch (menu) {
			case 1:
				System.out.println("이름 > ");
				name = sc.next();
				System.out.println("전화전호 > ");
				tel = sc.next();
				System.out.println("나이 > ");
				age = sc.nextInt();
				boolean isReg = service.register(new Address(name, tel, age));
				System.out.println("데이터 저장" + (isReg ? "성공" : "실패"));
				break;
			case 2:
				ArrayList<Address> list = service.getList();
				for (Address address : list) {
					System.out.println(address);
				}
				break;
			case 3:
				int choice = searchSelector();
				switch (choice) {
				case 1:
					System.out.println("검색할 이름 > ");
					name = sc.next();
					ArrayList<Address> listByName = service.getDetailByName(name);
					for (Address address : listByName) {
						System.out.println(address);
					}
					break;
				case 2:
					System.out.println("검색할 전화번호 > ");
					tel = sc.next();
					System.out.println(service.getDetailByTel(tel));
					break;
				case 3:
					System.out.println("검색할 나이 > ");
					age = sc.nextInt();
					ArrayList<Address> listByAge = service.getDetailByAge(age);
					for (Address address : listByAge) {
						System.out.println(address);
					}
					break;

				default:
					break;
				}
				break;
			case 4:
				System.out.println("수정할 이름 > ");
				name = sc.next();
				System.out.println("전화전호 수정 > ");
				tel = sc.next();
				System.out.println("나이 수정 > ");
				age = sc.nextInt();
				boolean isUp = service.modify(new Address(name, tel, age));
				System.out.println("데이터 수정" + (isUp ? "성공" : "실패"));
				break;
			case 5:
				System.out.println("이름 > ");
				name = sc.next();
				boolean isDel = service.remove(name);
				System.out.println("데이터 삭제" + (isDel ? "성공" : "실패"));
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				flag = false;
				break;

			default:
				System.out.println("정확한 메뉴 번호를 입력해주세요");
				break;
			}
		}
	}

	private static int searchSelector() {
		Scanner sc = new Scanner(System.in);
		System.out.println("찾을 정보 선택 > ");
		System.out.println("1.이름  2.전화번호  3.나이");
		
		return sc.nextInt();
	}

}
