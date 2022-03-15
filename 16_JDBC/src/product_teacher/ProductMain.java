package product_teacher;

import java.util.List;
import java.util.Scanner;

public class ProductMain {

	public static void main(String[] args) {
		// 상품 등록, 리스트조회, 개별조회, 수정, 삭제를 데이터베이스를 연동하여 구현하세요
		// 서비스 인터페이스, DAO 인터페이스를 통해 반드시 구현체로 객체를 만드세요
		// 내일 수업 시작과 동시에 풀이 합니다. => 풀이 속도가 빠를 수 있다라는 의미...
		
		Scanner sc = new Scanner(System.in);
		ProductService psv = new ProductServiceImple();
		List<ProductVO> list = null;
		ProductVO pvo = null;
		
		boolean flag = true;
		int menu, price, pno, isOk = 0;
		String name, madeBy = "";
		
		while (flag) {
			System.out.println("=====================상품관리 시스템====================");
			System.out.println("1.등록  2.목록  3.찾기  4.수정  5.삭제  0.종료");
			System.out.println(">>>>>>>>>>>>>>>>>>> 원하는 메뉴 선택 >>>>>>>>>>>>>>>>>>>>");
			
			menu = sc.nextInt();
			
			switch (menu) {
			case 1:
				System.out.println("상품명 > ");
				name = sc.next();
				System.out.println("상품가격 > ");
				price = sc.nextInt();
				System.out.println("제조사 > ");
				madeBy = sc.next();
//				pvo = new ProductVO(name, price, madeBy);
				isOk = psv.register(new ProductVO(name, price, madeBy));
				System.out.println("상품 등록 " + (isOk > 0 ? "성공":"실패"));
				break;
			case 2:
				list = psv.getList();
				for (ProductVO prdVo : list) {
					System.out.println(prdVo);
				}
				break;
			case 3:
				System.out.println("상품번호 > ");
				pno = sc.nextInt();
				pvo = psv.getDetail(pno);
				System.out.println(pvo);
				break;
			case 4:
				System.out.println("상품번호 > ");
				pno = sc.nextInt();
				System.out.println("상품명 > ");
				name = sc.next();
				System.out.println("상품가격 > ");
				price = sc.nextInt();
				System.out.println("제조사 > ");
				madeBy = sc.next();
				isOk = psv.modify(new ProductVO(pno, name, price, madeBy));
				System.out.println("상품 수정 " + (isOk > 0 ? "성공":"실패"));
				break;
			case 5:
				System.out.println("상품번호 > ");
				pno = sc.nextInt();
				isOk = psv.remove(pno);
				System.out.println("상품 삭제 " + (isOk > 0 ? "성공":"실패"));
				break;

			default:
				System.out.println("이용해주셔서 감사합니다");
				flag = false;
				break;
			}
		}
	}
}
