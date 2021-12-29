package jdbc01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class MemberDriver {
	
	public static void main(String[] args) {
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("\n--- 메뉴 선택 ---");
			System.out.printf("1. 데이터열람.  ");System.out.printf("2. 데이터추가.  ");
			System.out.printf("3. 데이터수정.  ");System.out.printf("4. 데이터삭제.  ");
			System.out.printf("5. 프로그램종료.  ");System.out.printf(">> 메뉴선택 : ");
			String choice = sc.nextLine();
			if(choice.equals("5")) break;
			switch (choice) {
			case "1": 
				select();
				break;
			case "2": 
				insert(sc);
				break;
			case "3": 
				update(sc);
				break;
			case "4": 
				delete(sc);
				break;
			}
			
		}
	}
	
	private static void delete(Scanner sc) {
		MemberDao mdao = MemberDao.getInstance();
		System.out.printf("삭제할 회원의 번호를 입력해주세요 : ");
		int num = Integer.parseInt(sc.nextLine());
	
		int result = mdao.delete(num);
		if(result == 1) System.out.println("레코드 삭제 성공");
		else System.out.println("레코드 삭제 실패");
	}

	private static void update(Scanner sc) {
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = new MemberDto();
		System.out.printf("수정할 회원의 번호를 입력해주세요 : ");
		int num = Integer.parseInt(sc.nextLine());
		mdto = mdao.getMember(num);
		
		System.out.printf("회원이름 : %s > ",mdto.getName());
		String name = sc.nextLine();
		if(!name.equals("")) mdto.setName(name);
		
		System.out.printf("전화번호 : %s > ",mdto.getPhone());
		String phone = sc.nextLine();
		if(!phone.equals("")) mdto.setPhone(phone);
		
		System.out.printf("생년월일 : %s > ",mdto.getBirth());
		String birth = sc.nextLine();
		if(!birth.equals("")) { 
			mdto.setBirth(birth);
			String year = birth.substring(0,4);
			Calendar today = Calendar.getInstance();
			int age = today.get(Calendar.YEAR) - Integer.parseInt(year)+1;
			mdto.setAge(age);
		}
		
		System.out.printf("포인트 : %d > ",mdto.getBpoint());
		String bpoint = sc.nextLine();
		if(!bpoint.equals("")) mdto.setBpoint(Integer.parseInt(bpoint));
		
		System.out.printf("성별 : %s > ",mdto.getGender());
		String gender = sc.nextLine();
		if(!gender.equals("")) mdto.setGender(gender);
		
		System.out.printf("가입일 : %s > ",mdto.getJoindate());
		String join = sc.nextLine();
		if(!join.equals("")) mdto.setJoindate(join);
		
		int result = mdao.update(mdto);
		if(result == 1) System.out.println("레코드 수정 성공");
		else System.out.println("레코드 수정 실패");
	}

	private static void insert(Scanner sc) {
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = new MemberDto();
		System.out.printf("이름을 입력해주세요 : ");
		String name = sc.nextLine();
		mdto.setName(name);
		
		System.out.printf("전화번호를 입력해주세요 : ");
		String phone = sc.nextLine();
		mdto.setPhone(phone);
		
		System.out.printf("생년월일을 입력해주세요 : ");
		String birth = sc.nextLine();
		mdto.setBirth(birth);
		
		String year = birth.substring(0,4);
		Calendar today = Calendar.getInstance();
		int age = today.get(Calendar.YEAR) - Integer.parseInt(year)+1;
		mdto.setAge(age);
		
		System.out.printf("성별을 입력해주세요 : ");
		String gender = sc.nextLine();
		mdto.setGender(gender);
		
		int result = mdao.insert(mdto);
		if(result == 1) System.out.println("레코드 추가 성공");
		else System.out.println("레코드 추가 실패");
	}

	private static void select() {
		MemberDao mdao = MemberDao.getInstance();
		ArrayList<MemberDto> list = mdao.select();
		System.out.println("번호\t이름\t\t전화번호\t\t생년월일\t\t포인트\t\t나이\t성별\t가입일");
		System.out.println("---------------------------------------------------------------------------------------------------");
		for(MemberDto dto : list) {
			System.out.printf("%d\t%s\t\t%s\t%s\t%-8d\t%3d\t%s\t%s\n",
						dto.getNum(),dto.getName(),dto.getPhone(),dto.getBirth(),dto.getBpoint(),
						dto.getAge(),dto.getGender(),dto.getJoindate()
					);
		}
	}
}
