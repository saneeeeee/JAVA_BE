package jdbc03;

import java.util.Scanner;

public class Book_Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n--- 메뉴 선택 ---");
			System.out.printf("1. 데이터열람  2. 데이터추가  3. 데이터수정  4. 데이터삭제");
			System.out.printf("  5. 프로그램종료 >> 메뉴 선택 : ");
			String choice = sc.nextLine();
			if(choice.equals("5"))break;
			Book_Dao bdao = new Book_Dao();
			switch(choice) {
			case "1":	
				bdao.select();
				break;
			case "2":
				System.out.println("제목을 입력하세요 : ");
				String subject = sc.nextLine();
				System.out.println("출판년도 입력하세요 : ");
				int makeyear = Integer.parseInt(sc.nextLine());
				System.out.println("입고가격을 입력하세요 : ");
				int inprice = Integer.parseInt(sc.nextLine());
				System.out.println("출고가격 입력하세요 : ");
				int rentprice = Integer.parseInt(sc.nextLine());
				System.out.println("등급 입력하세요 : ");
				String grade = sc.nextLine();
				
				Book_Dto bdto = new Book_Dto();
				bdto.setSubject(subject);
				bdto.setMakeyear(makeyear);
				bdto.setInprice(inprice);
				bdto.setRentprice(rentprice);
				bdto.setGrade(grade);
				bdao.insert(bdto);
				break;
			case "3":
				bdao.update();
				break;
			case "4":	
				bdao.delete();
				break;
			default	:	System.out.println("메뉴 선택이 잘못되었습니다.");
			}
		}
		
		System.out.println("프로그램을 종료합니다.");;
	}

}
