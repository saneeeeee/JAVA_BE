package days14;
class StaticD{
	// private 으로 지정된 static 멤버는 클래스의 내부에서만 사용이 가능한 멤버입니다
	private static int count;
	
	// static  멤버는 static  메서드와 인스턴스 메서드 둘에서 모두 접근이 가능하므로
	// private 으로 지정된  static 멤버를 이용하고자 한다면, public 으로 지정된
	// 멤버메서드(static, 인스턴스)로 이용합니다
	public static void setCount(int count) { StaticD.count = count; }	
	public static int getCount() {	return count;	}

	// 다만 인스턴스 메서드는 객체 생성후 이용이 가능합니다
	public void setCount1(int count) {  StaticD.count = count;  }	
	public int getCount1() {	return StaticD.count;	}
}
public class Class24 {
	public static void main(String[] args) {
		// private 으로 지정된 static 멤버는 클래스의 외부에서 접근이 차단됩니다.
		// StaticD.count = 100;  // 에러
		// public 접근지정자를 사용하는 static 메소드로  private 으로 지정된 
		// static 멤버의 값을 이용할 수 있습니다.
		System.out.printf("StaticD.count = %d\n", StaticD.getCount());		
		StaticD.setCount(15);		
		System.out.printf("StaticD.count = %d\n", StaticD.getCount());
		// 인스턴스 메서드는 객체 생성후 사용이 가능합니다
		StaticD d1 = new StaticD();
		System.out.printf("StaticD.count = %d\n", d1.getCount1());		
		d1.setCount1(15);		
		System.out.printf("StaticD.count = %d\n", d1.getCount1());
	}
}
