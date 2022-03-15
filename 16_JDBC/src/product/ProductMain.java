package product;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductMain {

	public static void main(String[] args) {
		// 상품 등록, 리스트조회, 개별조회, 수정, 삭제를 데이터베이스를 연동하여 구현.
		// 서비스 인터페이스, DAO 인터페이스를 통해 반드시 구현체로 객체를 생성.
		// 내일 수업 시작과 동시에 풀이. => 
		Scanner sc = new Scanner(System.in);
		Service service = new ShopServiceImple();
		boolean flag = true;
		int menu, price, pno = 0;
		String pname, madeby = null;
		
		System.out.println("=========== shop ===========");
		while (flag) {
			System.out.println("메뉴를 선택하세요");
			System.out.println("1.상품등록  2.리스트조회  3.개별조회  4.수정  5.삭제  0.종료");
			menu = sc.nextInt();
			
			switch (menu) {
			case 1:
				System.out.println("상품명 > ");
				pname = sc.next();
				System.out.println("상품가격 > ");
				price = sc.nextInt();
				System.out.println("제조사 > ");
				madeby = sc.next();
				boolean isReg = service.register(new Product(pname, price, madeby));
				System.out.println("상품등록" + (isReg ? "성공" : "실패"));
				break;
			case 2:
				ArrayList<Product> items = service.getList();
				for (Product item : items) {
					System.out.println("pno=" + item.getPno() + 
							", pname=" + item.getPname() + 
							", price=" + item.getPrice());
				}
				break;
			case 3:
				int choice = choiceSel();
				switch (choice) {
				case 1:
					System.out.println("검색할 상품번호 > ");
					pno = sc.nextInt();
					System.out.println(service.getDetailByPno(pno));
					break;
				case 2:
					System.out.println("검색할 상품이름 > ");
					pname = sc.next();
					ArrayList<Product> itemsByPname = service.getDetailByPname(pname);
					for (Product item : itemsByPname) {
						System.out.println(item);
					}
					break;
				case 3:
					System.out.println("검색할 상품이름 > ");
					madeby = sc.next();
					ArrayList<Product> itemsByMadeby = service.getDetailByMadeby(madeby);
					for (Product item : itemsByMadeby) {
						System.out.println(item);
					}
					break;

				default:
					System.out.println("정확한 검색조건을 선택하세요.");
					break;
				}
				break;
			case 4:
				System.out.println("수정할 상품번호를 입력 > ");
				pno = sc.nextInt();
				System.out.println("상품명 수정 > ");
				pname = sc.next();
				System.out.println("상품가격 수정 > ");
				price = sc.nextInt();
				System.out.println("제조사 수정 > ");
				madeby = sc.next();
				boolean isUp = service.modify(pno, new Product(pname, price, madeby));
				System.out.println("데이터 수정" + (isUp ? "성공" : "실패"));
				break;
			case 5:
				System.out.println("삭제할 상품번호를 입력 > ");
				pno = sc.nextInt();
				boolean isDel = service.remove(pno);
				System.out.println("데이터 수정" + (isDel ? "성공" : "실패"));
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				flag = false;
				break;

			default:
				System.out.println("정확한 메뉴 번호를 선택하세요.");
				break;
			}
		}
	}

	private static int choiceSel() {
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 정보를 선택 > ");
		System.out.println("1.상품번호  2.이름  3.제조사");
		
		return sc.nextInt();
	}
}
