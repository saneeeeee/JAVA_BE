package days18;
//	추상 클래스의 단점
//	추상 메서드의 구현의 강제성이 아래의 경우 단점이될 수 있습니다.
//	추상 메서드의 갯수가 많으면 상속에 부담을 주게 됩니다.
//	자식 클래스에서 사용하지 않을 추상메서드라도, 객체 생성을 위해 반드시 구현해야 하는 문제점이 있습니다.

abstract class AbstractA{
	public abstract void test1();
	public abstract void test2();
	public abstract void test3();
	public abstract void test4();
	public abstract void test5();
	public abstract void test6();
	public abstract void test7();
}

//	Abstract_B 클래스를 상속받은 클래스는 필요없는 메서드가 있어도, 추상 메서드를 모두
//	오버라이드(구현)해야합니다.

class AbstractA_Sub1 extends AbstractA{
	public void test1() {}
	public void test2() {}
	public void test3() {}
	public void test4() {}
	public void test5() {}
	public void test6() {}
	public void test7() {}
}

class AbstractA_Adapter extends AbstractA{
	public void test1() {}
	public void test2() {}
	public void test3() {}
	public void test4() {}
	public void test5() {}
	public void test6() {}
	public void test7() {}
}

class AbstractA_Sub2 extends AbstractA_Adapter{
	public void test1() {System.out.println("test1 오버라이딩~!");}	
}

public class Extends10_Abstract03 {

	public static void main(String[] args) {
		//	어댑터 클래스를 상속받은 클래스도 추상클래스의 자식(손자)클래스가 됩니다
		AbstractA obj = new AbstractA_Sub2();
		obj.test1();
		//	할아버지 손자간 다형성을 구현하여
		//	물려주고 오버라이딩된 메서드를 할아버지 레퍼런스가 사용할 수 있습니다
	}

}
