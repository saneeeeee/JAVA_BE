package days14;

import java.util.Random;

//static 메소드
//static 멤버 필드와 같이 프로그램의 구동전에 메모리에 로딩되어
//객체의 생성없이 클래스의 이름을 사용해 호출할 수 있는 메소드. 클래스 이름을 앞에도구 
//(.)으로 연결해서 사용. 객체생성없이 사용이 가능합니다.
public class Class21 {

	public static void main(String[] args) {
		// 클래스 내부에서 사용ㄷ
		abc();
		
		// java.lang 패키지에 있는 클래스의 static메서드 실제 사용 예
		// 간단한 공용기능을 제공하기 위한 Math 클래스
		// Math 클래스 안에 public static int abs(int n){ } 와  같은 양식의 
		// sqrt, random 메서드 가 있습니다
		
		// abs : 절대값 계산 메서드, 
		// sqrt : 제곱근 계산 메서드, 
		// random : 난수 발생 매서드
		// Math 클래스의 random 메서드는 Random 클래스의 nextInt() 메서드와 
		// 양식은 다르지만 역할을 같은 메서들입니다
		// 다만 Math 클래스의 random 메서드는 static 메서드 이므로   
		// Math.random();와 같이 사용하고
		// Random 클래스의 nextInt() 메서드는 동적멤버메서드 이므로 객체 생성후 
		// 호출객체를 앞에 두고 사용합니다
		Random rd = new Random();
		int a = rd.nextInt();
		// Math 클래스에 있는  random() 메서드는 스태틱 메서들이므로
		// Math.random() 으로 사용합니다.
		double b = Math.random();
		
		//abs 의 사용
		int num = -10;
		System.out.printf("num = %d, num 변수의 절대값 = %d\n", 
				num, Math.abs(num));
		//sqrt의 사용
		num = 9;
		System.out.printf("num 변수의 제곱근 = %.2f\n", Math.sqrt(num));
		
		// random 의 사용
		System.out.println("Math클래스 난수발생 스태틱매서드 값 : " 
				+  Math.random() );
		
		System.out.println("0~32 난수발생 스태틱매서드 값 : " 
				+  (int)(Math.random()*33) );
		
		// Integer 클래스 (int 타입과 매핑되는 클래스)
		// Integer 클래스의 parseInt 메소드는 문자열로 되어있는 정수값을 
		// int 타입으로 반환
		String strNum1 = "123";
		String strNum2 = "456";
		System.out.println("문자연산 : " + (strNum1 + strNum2) );
		System.out.println("정수변환후 연산 : " + (Integer.parseInt(strNum1) 
				+ Integer.parseInt(strNum2))  );
		// String 클래스
		// int 또는 double 형 자료를  String 으로 변환 -   valueOf()
		int intNum1 = 456;
		int intNum2 = 789;
		System.out.println("정수연산 : " + (intNum1 + intNum2));
		System.out.println("문자변환 연산 : " + (String.valueOf(intNum1)
				+ String.valueOf(intNum2)) );
		
		// (  strNum1.charAt(0) - '0' ) * 100 
		// + (  strNum1.charAt(1) - '0' ) * 10
		// + (  strNum1.charAt(2) - '0' ) * 1
		
		// 'A' - 'B'  : 변환이 되지 않아도 아스키코드로 연산이 되는 경우
		
		
		
		
		// Double 클래스 (double 타입과 매핑되는 클래스)
		// Double 클래스의 parseDouble 메소드는 문자열로 되어있는 실수값을 
		// double 타입으로 반환
		strNum1 = "10.75";
		strNum2 = "5.2";
		// 문자열 결합
		System.out.println("문자 연산 : " + (strNum1 + strNum2) );
		// 문자열의 값을 실수로 변환한 후 연산
		System.out.println("실수 변환후 연산 :  " + 
		(Double.parseDouble(strNum1)+ Double.parseDouble(strNum2)) );
	}

	public static void abc() {
		
	}
}
// 클래스 외부에서 사용 -> Class21.abc();
