package days13;
class Person{
	String name;
	int age;
	String phone;
	
	// 멤버메서드
	// 메서드의 제1목적 : 반복 되는 코드를 한번 따로 작성하고, 필요할때 불러나 씁니다
	// 지금의 목적은 멤버 변수값을 양식에 맞춰 출력하는 목적이므로, 그에 해당하는
	// 멤버메서드를 제작합니다
	// 멤버메서드 : 클래스에 소속된 객체전용 메서드
	public void output() {
		System.out.println("이름 : " + name + "  나이 : " + age
				+ "  전화번호 : " + phone);
	}
	// 멤버메서드는 특별한 경우를 제외하고는  static 을 쓰지 않습니다.
	// 메서드가 현재 프로그램내부에서만 사용된다는 가정하에 public 도 생략 가능합니다
	void input(String n, int a, String p) {
		name = n; 
		age = a;
		phone = p;
	}
}
public class Class002 {
	public static void main(String[] args) {
		// 멤버메서드는 멤버변수처럼 객체전용 메서드이므로, 단독 사용이 불가능합니다
		// output();  // 에러
		// 멤버변수도 객체에 소속된 변수이므로 단독 사용이 불가능 합니다
		// name = "김하나";  // 에러
		Person p1 = new Person();
		Person p2 = new Person();
		/*p1.name = "홍길동";
		p1.age = 30;
		p1.phone = "010-9999-8888";
		p2.name = "홍길서";
		p2.age = 40;
		p2.phone = "010-7777-8888";*/
		p1.input("홍길동", 30, "010-9999-8888");
		p2.input("홍길서", 20, "010-7777-8888");
		
		// System.out.println("이름 : " + p1.name + "  나이 : " + p1.age
		//		+ "  전화번호 : " + p1.phone);
		p1.output();
		// 멤버메서드는 반드시 객체 생성후, 생성된 객체를 앞에 두고 
		// (.)점으로 이어서 호출사용합니다
		p2.output();
		// 멤버 메서드가 생성되면, 그 반복되던 명령을 생성된 메서드를 호출해서 
		// 실행할 수 있습니다
		// System.out.println("이름 : " + p2.name + "  나이 : " + p2.age
		//		+ "  전화번호 : " + p2.phone);

	}

}
