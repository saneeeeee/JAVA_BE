package days05;

import java.util.Scanner;

public class ControllOpIf05 {

	public static void main(String[] args) {
		int year;
		int age;
		Scanner sc = new Scanner(System.in);
		System.out.println("출생년도 입력 : ");
		year = sc.nextInt();
		age = 2021 - year + 1;
		//12세 미만 어린이, 12~18세 청소년, 19~25세 청년, 
		// 26세 이상(나머지) 성년  입니다.   라고 출력하는 if  문 작성
		if( (age>=1)&&(age<12) ) 
			System.out.println("어린이 입니다");
		else if( (age>=19)&&(age<=25) ) 
			System.out.println("청년 입니다");
		else if( (age>=12)&&(age<=18) ) 
			System.out.println("청소년 입니다");
		else if( age>25) 
			System.out.println("성년 입니다");
		else 
			System.out.println("잘못입력하셨습니다");
	}

}
