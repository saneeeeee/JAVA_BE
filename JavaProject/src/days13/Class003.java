package days13;
class Animal{
	String name;
	int age;
	String phone;
	
	// a1.output();    객체에 의해 메서드가 호출되면, 메서드를 호출한 객체(호출객체)의
	// 참조값(주소)이 메서드에 숨어 있는  this 참조변수에 전달되어, 
	// 누가 호출했는지를 구분하여 사용하게 도와 줍니다
	//  this <- a1;
	// this : 메서드의 호출 객체의 참조값이 저장되는 참조변수.
	public void output( /* Animal this */) {
		// 매개변수가 멤버 변수와 이름이 중복되어 구분되지 않은 상황이 아니드라고,
		//  this 는 사용되고 있으며 아래와 같이 생략 또는 명시가 모두 가능합니다.
		System.out.println("이름 : " + this.name + "  나이 : " + age
				+ "  전화번호 : " + this.phone);
	}
	// 특히 아래와 같이 매개변수와 멤버변수 이름이 중복된다면,  this  는 반드시 명시하여
	// 사용합니다
	void input(String name, int a, String p) {
		this.name = name; 
		age = a;
		phone = p;
	}
	
	//Animal a3 = a1.copy1();       this <- a1
	Animal copy1() {
		Animal temp = new Animal();
		temp.name = this.name;
		temp.age = this.age;
		temp.phone = this.phone;
		return temp;
	}
	
	// a4.copy2(a2);      temp <- a2     this<-a4
	void copy2( Animal temp ) {
		this.name = temp.name;
		this.age = temp.age;
		this.phone = temp.phone;
	}
}
public class Class003 {
	public static void main(String[] args) {
		Animal a1 = new Animal();
		Animal a2 = new Animal();
		
		a1.name = "a";
		a2.name = "b";
		// new 에 의해서 다른 공간에 만들어진 a1 과 a2 는 당연히,
		// 멤버변수들도 제각각 공간을 따로 차지 있습니다
		// 그래서 위처럼 변수의 값을 따로 다른값으로 대입하는 동작에 전혀 문제가 없습니다
		
		// 하지만 멤버메서드는 정의된 메서드가 하나만 존재하고, 각 객체들이 공유하여
		// 사용합니다. 따라서  어떤 객체가 해당 멤버 메서드를 호출했는지, 메서드내에서
		// 구분될 필요가 있습니다.
		// 그것을 구분해주는 참조변수가 this  입니다.
		a1.input("홍길동", 30, "010-9999-8888");
		a2.input("홍길서", 20, "010-7777-8888");
		
		a1.output();
		a2.output();
		
		// Animal a3 = a1;  
		// 이는 참조값의 복사이므로, 완벽한 객체생성과 복사가 이루어지지 않습니다
		// 새로운 객체 생성(저장공간생성포함)과 복사가 이루어 지려면,
		// 어디선가 new Animal() 명령이 반드시 있어야 하며,
		// 객체가 복사보다 멤버변수간 값의 복사가 이루어 져야 합니다
		// 그 복합 동작들을  메서드로 정의하고 실행하게 합니다.
		Animal a3 = a1.copy1();
		a3.output();
		
		Animal a4 = new Animal();
		// a4 = a2; // 참조값의 복사
		a4.copy2(a2);
		a4.output();
	}

}
