package days08;

import java.util.Random;
import java.util.Scanner;

public class ControllOpWhile06 {

	public static void main(String[] args) {
		
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.print("가위(1), 바위(2), 보(3) 중 선택(종료-0) : ");
		int user = sc.nextInt();
		
		int com;
		while(user != 0) {
			// 컴퓨터에 난수로 발생한 숫자 하나(1 or 2 or 3)를 저장하고,
			com = rd.nextInt();
			if( com<0 ) com *= -1;
			com = com % 3 + 1;
			// 사용자가 입력한 숫자와 비교해서 가위바위보의 결과를 출력하세요
			if( com == 1 ) System.out.printf("컴퓨터 : %s", "가위");
			else if( com == 2 ) System.out.printf("컴퓨터 : %s", "바위");
			else System.out.printf("컴퓨터 : %s", "보");
			
			if( user == 1 ) System.out.printf("\t\t나 : %s", "가위");
			else if( user == 2 ) System.out.printf("\t\t나 : %s", "바위");
			else System.out.printf("\t\t나 : %s", "보");
			
			if( com == user ) System.out.println("\n무승부입니다");
			else if( com ==1 && user==2)System.out.println("\n이겼습니다");
			else if( com ==2 && user==3)System.out.println("\n이겼습니다");
			else if( com ==3 && user==1)System.out.println("\n이겼습니다");
			else System.out.println("\n졌습니다");
			
			//System.out.printf("\n계속하시겠습니까?(y(1)/n(0) ) ");
			//if( sc.nextInt() == 0)break;
			
			System.out.print("\n가위(1), 바위(2), 보(3) 중 선택(종료-0) : ");
			user = sc.nextInt();
		}
		System.out.println("프로그램이 종료됩니다");
	}

}
