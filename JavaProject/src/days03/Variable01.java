package days03;

public class Variable01 {

	public static void main(String[] args) {
		// 35 + 38 = 73
		System.out.println(35 + "+" + 38 + "=" + (35+38) );
		System.out.println(35 + "-" + 38 + "=" + (35-38) );
		System.out.println(35 + "x" + 38 + "=" + (35*38) );
		System.out.println(35 + "/" + 38 + "=" + (35/38.0) );
		System.out.println(35 + "%" + 38 + "=" + (35%38) );
		
		// 변수 : 프로그램 실행중 발생또는 입력되는 데이터를 저장할 목적으로 만들어서
		// 사용하는 임시 저장장소.  생성 명령 실행시 생성되고, 프로그램 종료시 소멸됩니다.
		
		// 변수의 이름을 만드는 규칙
		// 1. 인터넷 사이트의 회원가입시  만드는 아이디 이름 규칙과 비슷합니다
		// 2. 영문과 숫자, 그리고 일부 특수문자(_)를 섞어서 사용가능하지만
		// 3. 첫글자는 반드시 영문으로 사용합니다
		// 4. 중간에 공백이 있을수 없습니다
		// 5. 너무 짧지 않게 약간의 의미를 부여해서 이름 생성하는 편입니다
		// 6. 변수의 이름이 너무 짧으면, 변수의 갯수가 많아졌을때 서로의 용도를 구분하기 
		//     어렵습니다
		// 7. 변수의 이름이 너무 길면, 사용할때마다 그 긴 이름을 타이핑해야하는 불편함이 
		//     있습니다
		// 8. 두가지 의미의 단어가 조합되어 변수이름이 만들어 진다면 첫단어는 소문자로, 
		//    두번째 단어첫글자 대문자로 생성합니다
		// ex) 덧셈의 결과 를 저장할 변수 이름 : plusResult
		
		// 9. 변수는 자료형(정수, 실수, 문자)에 따라 만드는 명령이 달라집니다
		// int : 정수,  double : 실수 , String : 문자 등

		// int a;  // 정수형 변수
		// double b;   // 실수형 변수
		// String c;   // 문자형 변수
		
		int a;  //a 라는 이름의 변수를 생성(정수를 저장하기 위한 변수)
		int b;  //b 라는 이름의 변수를 생성(정수를 저장하기 위한 변수)
		int plusResult, minusResult, multiplyResult; // 한번에 여러변수를 생성
		double divideResult; //divideResult 라는 이름의 변수 생성(실수를 저장할 변수)

		// a = 10.25;  // 실수 -> 정수  소수점 아래 데이터 손실에 의한 에러
		divideResult = 100;
		
		boolean b1;   // 참(true) 또는 거짓(false) 중 하나를 저장하는 자료형(변수)
		b1 = true;
		System.out.printf("변수 b1 의 값 : %b\n", b1);
		System.out.println("변수 b1 의 값 : " + b1);
		// boolean 자료를 printf 로 출력할때 %b 를 사용합니다
		
		//int - 정수형 자료형    4 Byte형 정수
		//long - 정수형 자료형  8 Byte형 정수
		//float - 실수형 자료형  4 Byte형 실수
		//double - 실수형 자료형  8Byte 형 실수
		//char - 문자(글자) 자료형  'a', 'b'    2Byte - String 과 다릅니다
		
		char c;
		c = 'A';
		System.out.printf("변수 c 의 값 : %c\n", c);
		System.out.println("변수 c 의 값 : " + c);
		
		//String - 문자열 자료형: 현재는 자료형이라고 부르지만 엄밀히 자료형은 
		//            아니며 이후 객체단원에서 자세히 학습 할 예정입니다. 
		//           지금은 그냥 여러문자를 하나의 자료로 저장할 수 있는 자료형으로 이해하시면
		//           됩니다.
		// 문자열 : "a", "Abc", "aBCD", ""
		String s;
		s = "ABCD";
		System.out.printf("변수 s 의 값 : %s\n", s);
		System.out.println("변수 s 의 값 : " + s);
		
		
		// 2진수 1자리 숫자    0  or  1
		// 2진수 1자리 숫자를 저장할 수 있는 공간  : 1bit
		// 2자리   2bit  (00  01  10  11)   십진수로 치면 0~3
		// 3bit - 000 001 010 011 100 101 110 111   8개   0~7
		// 4bit - 16개(0000~1111)  0~15
		// 5bit - 32
		// 6bit - 64
		// 7bit - 128
		// 8bit - 256  (0~255)   1 BYTE
		// 문자 하나 종류 : 150  
		// 00000000 : A   000000001 : B   00000010 : C.....
		// 예전 시스템은 글자 하나를 저장하기 위해 8bit( 1Byte) 를 사용했습니다
		
		// 9 - 512
		// 10 - 1024
		// 11 - 2048
		// 12 - 4096
		// 13 - 8192
		// 14 - 16384
		// 15 - 32768
		// 16 - 65536  
		
		// 예전 시스템의 int - 2byte  (-32768 ~ 32767 )
		// 현재 시스템의 int - 4byte  (-2147483648 ~ 2147483647 )
		
		// double - 8byte   0.00002  => 0.2 x 10의 -4승
		//  10 의 -308승 부터 308승까지...
		
		
		a = 15;
		b = 11;
		c = '+';
		plusResult = a + b;
		minusResult = a - b;
		multiplyResult = a * b;
		divideResult = a / b;
		
		System.out.printf("%d %c %d = %d\n", a, c, b, plusResult);
		c = '-';
		System.out.printf("%d %c %d = %d\n", a, c, b, minusResult);
		c = 'x';
		System.out.printf("%d %c %d = %d\n", a, c, b, multiplyResult);
		c = '÷';
		System.out.printf("%d %c %d = %.2f\n", a, c, b, divideResult);
		
		divideResult = a / (double)b;
		// 현재 위치에서만  잠시  double 으로 변환.  이명령이 지나면 다시 int형으로
		System.out.printf("%d %c %d = %f\n", a, c, b, divideResult);
		
		// 위의 네개의 출력을 println 으로 바꿔서 출력하세요
		c = '+';
		// System.out.println( 'A' + 10 );
		System.out.println(a + " " + c + " " + b + " = " + plusResult);
		c = '-';
		System.out.println(a + " " + c + " " + b + "=" + minusResult);
		c = 'x';
		System.out.println(a + " " + c + " " + b + "=" + multiplyResult);
		c = '÷';
		System.out.println(a + " " + c + " " + b + "=" + divideResult);
	}

}
