package days14;

//싱글턴 패턴(Singleton Pattern)
//특정 클래스의 인스턴스를 반드시 한개만 생성할 수 있도록 강제하는 패턴 
//멤버필드값이 객체들간 스태틱 변수가 아니면서 일관된 값을 가져야하고, 객체도 둘이상 
//더 만들필요가 없다면, 하나의 인스턴스를 여러 레퍼런스 변수가 공유하여 사용하도록 
//제어하는 싱글턴 방식이 사용됩니다.
class SingletonEx {
	int n1; 
	int n2;
	
	// 1. 생성자를 private 로 보호 합니다
	private SingletonEx(){ 	}
	//2. 클래스 내부에서 생성자를 호출해서 객체하나(new 인스턴스)를 생성합니다.
	//    이역시도  private 으로 생성합니다. & static 으로 생성합니다
	private static SingletonEx itc = new SingletonEx();
	// 3.생성해놓은 객체의 참조변수값을 리턴하는 public 형의 메서드를 생성합니다.
	// 메서드 이름 getInstance() - static 으로 생성합니다
	public static SingletonEx getInstance() {
		return itc;
	}
}

class MultitoneEx{
}
public class Class26 {

	public static void main(String[] args) {
		MultitoneEx m1 = new MultitoneEx();
		MultitoneEx m2 = new MultitoneEx();
		System.out.println(m1);
		System.out.println(m2);
		System.out.println();
		// SingletonEx s1 = new SingletonEx();
		// SingletonEx s2 = new SingletonEx();
		// 싱글턴 방식이란 위의 s1와 s2의 레퍼런스 변수가 같은 주소를 같게 하는
		// 방식입니다.   현재는  다른 주소입니다. new 때문에...
		
		//SingletonEx s3 = new SingletonEx();
		//SingletonEx s4 = s3;
		// 싱글턴은 이와 같이 하나의 인스턴스를 공유해서 쓰는것과 비슷합니다.
		// 다만 s3과 s4 는 같은 영역({  }) 안에 있는 변수이기때문에 주소전달이 가능하지만
		// 만약 다른 메서드상에서 사용하는 레퍼런스 변수도 같은 주소를 갖게 하려한다면
		// 위의 방법으론 적절치 않습니다
		
		//abc(s3); // 해당 메서드를 호출할때마다  객체주소를 전달해야하는 불편함이 있습니다
		
		SingletonEx s1 = SingletonEx.getInstance();
		SingletonEx s2 = SingletonEx.getInstance();
		SingletonEx s3 = SingletonEx.getInstance();
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		// 객체 참조 변수를 println으로 출력하면, 클래스이름과 해쉬코드가 출력됩니다
		// 해쉬코드 : 각 객체들을 서로 구분할 수 있는 고유값 -> 새로운 저장장소의 
		// 주소를 계산하는 피연산자이기도 합니다 
		
		s1.n1 = 150;
		System.out.println(s2.n1);
		s2.n2 = 200;
		System.out.println(s3.n1 + " " + s3.n2);
	}
	public static void abc(SingletonEx s) {
		// SingletonEx s5 = new SingletonEx();
		// 이명령이 실행됨으로써 이미 두개의 인스턴스가 만들어진거나 마찬가지 입니다.
	}
	
	// 생성자가 private 로 보호되어 main 메서드 안에서 new SingletonEx() 로 
	// 새로운 객체 생성이 되지 않습니다. 
	// SingletonEx s1 = new SingletonEx(); 에러
	// 싱글톤 방식은 클래스내부에 유일한 객체(itc)를 생성해두고(private static 
	// 으로 생성) public static 으로 만들어진 getInstance() 메서드를 호출하여
	// itc 를 리턴받아 객체를 사용합니다
	// 생성자 매서드는 static 인스턴스 itc 만들때 최초 실행된 때 말고는 실행되지 
	// 않습니다
	// 주로 유지되어야 할 정보와 매서드를 많이 갖고 있는 클래스에서 많이 사용됩니다
	// 두개의 객체가 유지되면 부담스러운 부분을 하나로 공유하고 필요한 내용을
	// 멤버 변수로 해결하는 방식입니다
	// 싱글턴 패턴이 구현된 클래스의 활용
	// 날짜, 시간에 관련된 정보를 제공하는 Calendar : 
	// 클래스 싱글턴 패턴이 구현되어 new 인스턴스를 사용하여 객체생성이 안됩니다
	//반드시 getInstance 메소드를 사용하여야 합니다.
}
