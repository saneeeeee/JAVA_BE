package days05;

import java.util.Scanner;

public class ControllOpIf01 {

	public static void main(String[] args) {
		// 사용자로 부터 정수 하나를 입력 받습니다
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int a = sc.nextInt();
		int b = a % 2;
		//boolean result = a%2 == 0;
		//System.out.println("입력한 정수는 짝수? : " + result);
		
		// 관계(비교) 연산의 결과를 갖고 해당 명령을 실행할지 안할지를 결정하는 명령
		// if
		if(b == 0) {
			System.out.println("입력한 정수는 짝수입니다");
		} 
		
		if(b != 0) System.out.println("입력한 정수는 홀수입니다");
		
		// if 문의 특징
		// ( ) 안의 값이 true 이면  { } 안의 명령을 실행, false 이면 실행하지 않는 명령
		// ( ) 안의 값이 true 이면 실행해야할 명령이 두개 이상일수 있으므로, 
		// 			{  }로 그 경계를 구분해줍니다. 실행하거나 실행하지 않을 영역 구분
		// ( ) 안의 값이 true 일때 실행할 명령이 한개라면, 중괄호{}를 생략가능합니다 
		// 만약 ()안에 일부러 true 를 썼다면 -> if( true ){  }
		//      { }안의 내용은 무조건 실행됩니다. 
		//      if(false){  } 반대의 경우 무조건 실행안하고 건너뜁니다
		//  (  ) 안에는 비교연산과 논리연산이 조합된 복합연산식 표현이 가능합니다
		//     if( (x==0)&&(y!=0)||(z==0)  ){   }
		boolean result = a%2 == 0;
		if( result ) System.out.println("입력한 정수는 짝수입니다");
		if( a%2 == 0 ) System.out.println("입력한 정수는 짝수입니다");
		if( result == true ) System.out.println("입력한 정수는 짝수입니다");
		
		if(b == 0) System.out.println("입력한 정수는 짝수입니다");
		// 짝수인 경우 위 네가지 표현으로 출력이 가능합니다
		
		if( !result ) System.out.println("입력한 정수는 홀수입니다");
		// result 에 false 가 저장되어 있어야  !에 의해  true 로 변환되고,
		// if문이  true 를 인식해서 해당 명령이 실행됩니다.
		if( a%2 != 0 ) System.out.println("입력한 정수는 홀수입니다");
		if( result == false ) System.out.println("입력한 정수는 홀수입니다");
		
		if(b != 0) System.out.println("입력한 정수는 홀수입니다");
	}
}




