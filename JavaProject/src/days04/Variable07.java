package days04;

import java.util.Scanner;

public class Variable07 {

	public static void main(String[] args) {
		// (입력)사과 갯수 입력,  한상자에 담길 사과의 갯수 입력
		// (출력)입력조건으로 포장했을때, 포장된 박스갯수, 남은 사과 갯수 출력
		
		// 입력
		Scanner sc = new Scanner(System.in);
		int apple;
		System.out.print("사과의 갯수를 입력하세요");
		apple = sc.nextInt();
		
		int boxOneQuantity;
		System.out.print("한상자에 포장될 사과의 갯수를 입력하세요");
		boxOneQuantity = sc.nextInt();
		
		// 계산
		int boxQuantity = apple / boxOneQuantity;
		int theRest = apple % boxOneQuantity;
		
		// 출력
		System.out.println("포장된 사과박스 갯수 : " + boxQuantity);
		System.out.println("남은 사과갯수 : " + theRest );
		

	}

}
