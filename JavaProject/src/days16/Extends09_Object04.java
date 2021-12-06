package days16;

class Human {
	private String name;
	private int age;

	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		String info = "name = " + this.name + ", ";
		info += "age = " + this.age;
		return info; // "name = 홍길동, age = 26"
	}
	
	//	s1.equals(s2)		this <- s1		obj <- s2
	public boolean equals(Object obj) {
		
		//	this.name 와 obj.name 의 비교, this.age 와 obj.age의 비교를 해야하는데
		//	obj 는 부모클래스의 참조변수 이므로, 자식클래스(Human)의 멤버변수인 name과
		//	age 에는 access 수가 없습니다. 그래서 아래와 같이 형변환이 필요합니다
		
		// 전달된 obj가 현재로선 어떤 인스턴스를 갖고 있는지 모르기때문에,
		//	instanceof 을 활용해서 형변환이 가능한지 보고 변환합니다.
		//	이상한 클래스가 왔으면 그냥바로 return false(메서드 종료)
		if(!(obj instanceof Human))return false;
		Human target = (Human)obj;
		
		boolean flag_name = this.name.equals(target.name);
		boolean flag_age = this.age == target.age;
		boolean result = flag_name && flag_age;
		
		return result;
	}
}

public class Extends09_Object04 {

	public static void main(String[] args) {
		Human s1 = new Human("홍길동",26);
		Human s2 = new Human("홍길동",26);
		Human s3 = new Human("홍길남",20);
		System.out.println("Human1의 정보 : " + s1);
		System.out.println("Human2의 정보 : " + s2);
		System.out.println("Human3의 정보 : " + s3);
		
		//	레퍼런스 변수들간의 비교
		if(s1==s2)
			System.out.println("s1 변수와 s2 변수는 같습니다.(s1==s2)");
		else System.out.println("s1 변수와 s2 변수는 다릅니다.(s1==s2)");
		
		// .equals 메서드를 사용하여 비교(equals 메서드 오버라이드 이전)
		if(s1.equals(s2))
			System.out.println("s1 변수와 s2 변수는 같습니다.(s1.equals(s2))");
		else System.out.println("s1 변수와 s2 변수는 다릅니다.(s1.equals(s2))");
		//	결과 : s1 변수와 s2 변수는 다릅니다.(s1.equals(s2))
		//	Object 클래스의 equals 메소드는 기본적으로 두 객체의 레퍼런스 값을 비교하는
		// 연산만을 수행합니다.
		if(s1.equals(s3))
			System.out.println("s1 변수와 s3 변수는 같습니다.(s1.equals(s3))");
		else System.out.println("s1 변수와 s3 변수는 다릅니다.(s1.equals(s3))");
	}

}
