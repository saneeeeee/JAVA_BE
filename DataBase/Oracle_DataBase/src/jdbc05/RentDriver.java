package jdbc05;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.Scanner;

import jdbc03.Book_Dao;

public class RentDriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while( true ) {
			System.out.println("\n--- 메뉴 선택 ---");
			System.out.printf("1. 데이터열람.  2. 데이터추가.  3. 데이터수정. ");
			System.out.printf("4. 데이터삭제.  5. 프로그램 종료.  \n>>메뉴 선택 : ");			
			String choice = sc.nextLine();
			if( choice.equals("5")) break;
			Book_Dao bdao = new Book_Dao();
			switch( choice ) {
				case "1": 
					select(sc); 
					break;	
				case "2": 
					insert(sc); 
					break;
				case "3": 
					update(sc); 
					break;
				case "4": 
					//delete(sc);
					break;
				default : System.out.println("메뉴 선택이 잘못되었습니다");
			}
		}
		System.out.println("프로그램을 종료합니다");
	}

	private static void update(Scanner sc) {
		RentDao rdao = RentDao.getInstance();
		RentDto rdto = null;
		
		System.out.printf("수정할 대여건의 number를 입력하세요");
		String input;
		while (true) {
			input = sc.nextLine();
			if (input.equals(""))	System.out.println("number 입력은 필수입니다.");
			else break;
		}
		
		int num = Integer.parseInt(input);
		rdto = rdao.getRent(num);
		
		if(rdto == null) {
			System.out.println("입력한 numer 의 대여건이 없습니다.");
			return;
		}
		
		//	수정할 대여날짜 입력
		System.out.printf("대여날짜 : %s 수정할 날짜를 입력하세요(YYYY-MM-DD) -> ",rdto.getRentdate());
		String rentdate = sc.nextLine();
		if(!rentdate.equals("")) rdto.setRentdate(rentdate);
		
//		대여하는 회원의 번호 입력
		int booknum = 0;
		System.out.printf("도서번호 : %d 수정할 도서번호를 입력하세요 -> ",rdto.getBooknum());
		while(true) {
			input = sc.nextLine();
			if(input.equals("")) break;
			else {
				booknum = Integer.parseInt(input);
				boolean state = rdao.checkBooknum(booknum);
				if(state) {
					rdto.setBooknum(booknum);
					break;
				}else System.out.println("입력한 번호의 도서가 존재하지 않습니다. 다시입력하세요 ->");
			}
		}
			
			//	대여하는 회원의 번호 입력
		int membernum= 0;
		System.out.printf("회원번호 : %d 수정할 회원번호를 입력하세요 -> ",rdto.getMembernum());
		while(true) {
			input = sc.nextLine();
			if(input.equals("")) break;
			else {
				membernum = Integer.parseInt(input);
				boolean state = rdao.checkMembernum(membernum);
				if(state) {
					rdto.setMembernum(membernum);
					break;
				}else System.out.println("입력한 번호의 회원이 존재하지 않습니다. 다시입력하세요 ->");
			}
		}
		
		System.out.printf("할인금액 : %d 수정할 할인금액 입력하세요 -> ",rdto.getDiscount());
		String discount = sc.nextLine();
		if(!discount.equals("")) rdto.setDiscount(Integer.parseInt(discount));
		
		int result = rdao.update(rdto);
		if(result == 1) System.out.println("레코드 수정 성공");
		else System.out.println("레코드 수정 실패");
		// to_date ("||?||",'YYYY-MM-DD')
	}
	
	private static void insert(Scanner sc) {
		RentDao rdao = RentDao.getInstance();
		RentDto rdto = new RentDto();
		
		//	rentdate 는 오라클의 sysdate 또는 default 값을 이용합니다.
		//	대여할 도서의 번호 입력
		int booknum = 0;
		System.out.printf("대여할 도서의 번호를 입력하세요 -> ");
		while(true) {
			booknum = Integer.parseInt(sc.nextLine());
			boolean state = rdao.checkBooknum(booknum);
			if(state) break;
			else System.out.print("입력한 도서번호의 도서가 존재하지 않습니다. 다시 입력하세요 -> ");
		}
		rdto.setBooknum(booknum);
		
		//	대여하는 회원의 번호 입력
		int membernum = 0;
		System.out.printf("회원번호를 입력하세요 -> ");
		while(true) {
			membernum = Integer.parseInt(sc.nextLine());
			boolean state = rdao.checkMembernum(membernum);
			if(state) break;
			else System.out.print("입력한 회원이 존재하지 않습니다. 다시 입력하세요 -> ");
		}
		rdto.setMembernum(membernum);
		
		//	할인 금액
		System.out.printf("할인금액를 입력하세요 -> ");
		String input = sc.nextLine();
		int discount = 0;
		if(!input.equals("")) discount = Integer.parseInt(input);
		rdto.setDiscount(discount);
		int result = rdao.insert(rdto);
		if(result == 1) System.out.println("레코드 추가 성공");
		else System.out.println("레코드 추가 실패");
	}

	private static void select(Scanner sc) {	
		RentDao rdao = RentDao.getInstance();
		ArrayList<RentDto> list = rdao.select();
		System.out.println("날짜\t\t\t순번\t도서번호\t회원번호\t할인금액");
		System.out.println("-------------------------------------------------------");
		for(RentDto dto : list) {
			System.out.printf("%s\t%d\t%s\t\t%s\t\t%d\n",dto.getRentdate(),dto.getNum(),dto.getBooknum(),dto.getMembernum(),dto.getDiscount());
		}
	}

	

}
