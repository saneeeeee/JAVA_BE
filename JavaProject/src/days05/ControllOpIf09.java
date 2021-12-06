package days05;

import java.util.Scanner;

public class ControllOpIf09 {

	public static void main(String[] args) {
		// 가위 바위 보  게임
		Scanner sc = new Scanner(System.in);
		String user;
		System.out.print("가위/바위/보 중 하나를 입력하세요");
		user = sc.nextLine();
		
		String com = "가위";  // 컴퓨터는 가위 말고 다른 걸 낼수도 있다고 가정합니다
		
		// 사용자 입력과 컴퓨터가 가진 텍스트를 각각 비교해서  이겼다, 졌다, 비겼다 출력
		
		if( user.equals("가위") && com.equals("가위") )
			System.out.println("무승부입니다");
		else if( user.equals("가위") && com.equals("바위") )
			System.out.println("졌습니다");
		else if( user.equals("가위") && com.equals("보") )
			System.out.println("이겼습니다");
		else if( user.equals("바위") && com.equals("가위") )
			System.out.println("이겼습니다");
		else if( user.equals("바위") && com.equals("바위") )
			System.out.println("무승부입니다");
		else if( user.equals("바위") && com.equals("보") )
			System.out.println("졌습니다");
		else if( user.equals("보") && com.equals("가위") )
			System.out.println("졌습니다");
		else if( user.equals("보") && com.equals("바위") )
			System.out.println("이겼습니다");
		else if( user.equals("보") && com.equals("보") )
			System.out.println("무승부입니다");
		
		
		
		if( user.equals("가위") && com.equals("보") )
			System.out.println("이겼습니다");
		else if( user.equals("바위") && com.equals("가위") )
			System.out.println("이겼습니다");
		else if( user.equals("보") && com.equals("바위") )
			System.out.println("이겼습니다");
		else if( user.equals(com) )
			System.out.println("무승부입니다");
		else
			System.out.println("졌습니다");
		
		
		
		
		if( user.equals("가위") && com.equals("바위") )
			System.out.println("졌습니다");
		else if( user.equals("바위") && com.equals("보") )
			System.out.println("졌습니다");
		else if( user.equals("보") && com.equals("가위") )
			System.out.println("졌습니다");
		else if( user.equals(com) )
			System.out.println("무승부입니다");
		else
			System.out.println("이겼습니다");
		
		
	}
}
