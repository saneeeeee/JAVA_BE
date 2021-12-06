package days18;

//	인터페이스는 멤버필드로 public static final 멤버만 가질 수 있습니다.
//	인터페이스는 멤버메서드로 public abstract 메서드만 가질 수 있습니다.
interface InterB {
	public static final int n1 = 1;
	public static final int n2 = 2;
	// 인터페이스 내부에 선언되는 멤버 필드는 public static final 을 생략할 수 있습니다.
	int n3 = 3;

	// public static final 이 생략된 변수와 일반 멤버 변수의 구분은 초기화값의 유무에 따라 구분됩니다.
	// int n3; // 값이 초기화 되지 않는 변수는 일반 멤버 변수로 인식되어 에러
	public abstract void test1();

	public abstract void test2();

	// 인터페이스 내부에 선언되는 메서드는 public abstract 을 생략할 수 있습니다.
	void test3();
	// public abstract 가 생략된 메서드와 허용되지 않는 일반 메서드의 구분은 {}의
	// 유무에 따라 구분합니다.
}

public class Extends11_Interface02 {
	public static void main(String[] args) {

	}
}
