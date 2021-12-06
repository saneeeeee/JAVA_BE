package days15;
//클래스의 상속
//다수개의 클래스드이 중복되는 멤버 변수, 멤버 메서드를 포함하고 있는 경우
//부모 자식 관계를 생성하여 코드의 중복을 방지하는 것을 1차 목적으로 사용합니다
//2차 목적으로 코드의 재활용 방법을 목적으로 사용합니다.
//코드의 중복이 발생하고 있는 클래스에서 중복되는 멤버드을 별도의 클래스로 선언하고
//상속을 구현하여 사용합니다.

// 코드의 중복이 발생하고 있는 클래스들
/* class PersonA{
	String name;   int age;
	String hakbun;
}
class PersonB{
	String name;   int age;
	String empbum;
}*/

// 중복되는 멤버들 이나 메서드 등 코드를 구성요소로한 부모클래스를 생성
class Person{
	String name;   int age;
}
// 부모를 상속한(상속을 구현한) 자식클래스를 생성
class PersonA extends Person{
	String hakbun;
}
class PersonB extends Person{
	String empbum;
}
public class Extends01 {

	public static void main(String[] args) {
		PersonA a = new PersonA();
		PersonB b = new PersonB();
		a.name = "홍길동";
		b.age = 26;
		System.out.println(a.name);
		System.out.println(b.age);	

	}

}
