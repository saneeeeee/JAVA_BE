package days11;

import java.util.Scanner;

//리턴값이 존재하는 메소드의 선언
//메서드 호출 후 메서드에서 계산되어 진 결과를 호출한 지점에서 사용하고자 할때
//return 명령으로 호출된 지점으로 전달할 수 있습니다. 

public class Method07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		int sq = squar(num);
		System.out.printf("%d 의 제곱은 %d 입니다\n", num, sq);
		
		int max_result = max(10, 34, 67);
		System.out.printf("%d %d %d 중 가장 큰숫자는? -> %d\n", 
				10, 24, 67, max_result);
	}
	// main.num -> squar.num   
	// squar.num * squar.num  -> squar.sq
	// squar.sq -> main.sq
	public static int squar(int num) {
		int sq = num * num;
		// System.out.printf("%d 의 제곱은 %d 입니다\n", num, s);
		return sq;
	}
	// 메서드의 호출과 실행, 리턴값의 구조가  반드시 리턴값을 별도의 변수에 
	// 저장되게 구성해야하는것은 아닙니다.  sc.nextLine()
	// 다만 리턴명령의 목적이 메서드 실행결과를 리턴받아 사용할 목적이었다면
	// 리턴값을 별도의 별수에저장하는 것이 설계목적상 올바른 사용입니다
	// String k = sc.nextLine();
	
	public static int max(int a, int b, int c) {
		int result = 0;
		
		if( a>b) result = a;
		else result = b;
		
		if(result < c) result = c; 
		
		return result;
	}
	
	// 매서드 사용에 따른 매서드 형태
	// abc() - 전달인수 없고 리턴값도 없는 형태
	// abc(10, 20) - 전달인수 2개, 리턴값 없음
	// k = abc() - 전달인수 없고, 리턴값있는 형태
	// k = abc(10, 20) 전달인수 2개, 리턴값 있는 형태
	
	// ※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※
	// 개발자 필요에 의해 만들어지는 메서드는 반드시 클래스안에 정의 되어야 하며
	// 생성된 메서들 간에는 자유롭게 서로를 호출하여 사용할 수 있습니다
	// 그들은 그들을 둘러싼 클래스에 속해 있는 멤버들이라고도 부릅니다.
	// 다만 서로를 자유롭게 호출하는 대상에서 main 메서드는 제외합니다
	// main을 호출한다는건 프로그램을 시작한다는 뜻.
	// ※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※
}







