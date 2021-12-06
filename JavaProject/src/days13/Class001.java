package days13;
// 클래스(class)
// 프로그램에서 처리하고자하는 대상을 자료화 하여 , 실제 활용할 자료형을 정의한 것입니다
// 자료화 : 세부 내용을 변수로 만들고 그들을  class  로 묶어서 사용하는 방식.
// 예) 학생 class 에  이름, 국어, 영어, 수학, 총점, 총점, 평균을 정의 하고 
//      이를 하나의 자료라고 이름 부르는 것을 의미.

// 만드는 방법은
class  클래스이름{
	// 멤버변수
	int 변수1;
	double  변수2;
	String 변수3;
	// 멤버메서드
	public void 메서드1() {  }
	public static void 메서드2() {  }
}

class Human{
	String name;
	int age;
	String phone;
} // 클래스의 설계도 : 현재 프로그램에서 이클래스 자료형을 사용하겠습니다.라고 정의
public class Class001 {

	public static void main(String[] args) {
		int a; // 스택에 생성되는 기본자료형 변수
		String s; // 힙에 실제 데이이터가 저장되는 참조변수
		
		Human h1 = new Human();
		Human h2 = new Human();
		// class 생성이 끝나면, 생성된 객체의 변수를 만들어서 사용할수가 있습니다
		// new에 의해서 name 과 age 저장될 Human 데이터형의 공간이 
		// Heap  영역에 생성되고
		// 그 공간의 주소가 참조변수(h1, h2)에 저장됩니다
		
		String [] name = new String[10];
		int [] age = new int[10];
		// name[0]   age[0] 이  1번 사람의 자료...
		// name[1]   age[2] 이  2번 사람의 자료...
		String [] phone = new String[10];
		// phone[0], phone[1]....
		
		h1.name = "홍길동";
		h1.age = 30;
		
		h2.name = "홍길서";
		h2.age = 40;
		// 클래스를 사용함으로써 자료처리의 단위가 변경됩니다.
		// 프로그램이나 자료 중심의 처리 -> 개발자 중심의 처리
		Human [] h = new Human[10];  // 객체 배열
		// h[0]  에  name, age, phone 이 모두 포함되어 있습니다. 
		
		Human h3;  //  참조변수 선언
		h3 = new Human();    // 힙에 새로운 인스턴스 생성후 주소(참조값) 저장
		Human h4 = new Human();
		h3.name = "홍길남";
		h4.name = "홍길북";
		h3.age = 30;
		h4.age = 50;
		h3.phone = "010-1111-2222";
		h4.phone = "010-2222-3333";
		
		h1.phone = "010-5555-3333";
		System.out.println("이름 : " + h1.name + "  나이 : " + h1.age
				+ "  전화번호 : " + h1.phone);
		
		Human h5 = new Human();
		System.out.println("이름 : " + h5.name + "  나이 : " + h5.age
				+ "  전화번호 : " + h5.phone);
		// new 로 만든 공간은 정수는 0 실수는 0.0 문자는  null 로 초기화 됩니다
		
	}

}
