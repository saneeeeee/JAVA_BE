package days13;
// static 키워드
// 멤버변수, 멤버메소드에 적용할 수 있는 키워드
// 정적 변수(클래스의 변수), 정적 메소드(클래스의 메소드)를 선언할 때 사용


//자바프로그램의 구동 과정
//1. JVM에 의해서 실행할 모든 클래스 중, static 메소드, static 멤버필드를 수집해서 
//메모리에 로딩되고, 프로그램의 시작(main메소드의 실행)전에 메모리 적재됩니다
//2. 메모리에 로딩된 static 메소드 중, main 이름을 검색
//3. main 메소드가 검색되었다면 JVM 해당 main 메소드를 호출하여 프로그램을 시작

//static 필드/메소드의 특징
//프로그램의 구동 전부터 메모리를 확보하고 있는 멤버필드 및 메서드!!!

class StaticA{
	int num;     // 인스턴스 변수 - 멤버변수이지만, 스태틱이냐 아니냐에 따라 
	// 인스턴스 변수라고도 불립니다(동적 멤버변수)
	static int number = 100;  // 스태틱변수(정적 멤버변수)
	// 스태틱 변수는 프로그램 실행전에 먼저 생성되어서 사용할 준비가 완료되는
	// 변수입니다.
}
public class Class18 {

	public static void main(String[] args) {
		// 동적멤버변수(인스턴스멤버변수)는 객체가 반드시 생성되어야 그 변수를
		// 사용할 수가 있습니다
		StaticA a = new StaticA();
		a.num = 100;
		System.out.println("a  객체의 동적 멤버변수 값 : " + a.num);
		
		// 그러나 스태틱 변수는 main 메서드 실행전에 , 객체생성 전에
		// 미리 생성되어 있는 변수, 객체와는 독립적이면서, 클래스에는 종속적으로 사용하도록 
		// 생성됩니다. 객체를 생성하지 않고도 사용할 수 있는 클래스의 멤버변수입니다.
		
		// 동적변수는 객체생성마다 그 객체안에 생성되서 객체의 갯수만큼 생성되지만
		// 정적변수는 프로그램 전체를 통틀어 한개 만들어집니다.
		// 그 값도 일관성있게 끝까지 유지됩니다.
				
		// 다만 클래스 외부에서 static 변수에 접근하려면 위와 같이 클래스 이름과 
		// 함께 사용합니다.
		StaticA a2 = new StaticA(); a2.num = 200;
		System.out.println("a2  객체의 동적 멤버변수 값 : " + a2.num);
		StaticA a3 = new StaticA(); a3.num = 300;
		System.out.println("a3  객체의 동적 멤버변수 값 : " + a3.num);
		System.out.println(StaticA.number);

		// 동적 변수와 마찬가지로 private 으로 보호 되지 않았다면 임의 접근이 가능하고
		StaticA.number = 10;
		System.out.println(StaticA.number);
		// private로 보호된 static 변수는  static 메서드를 사용하여 값을 저장하거나 
		// 얻어 냅니다.
		// static  이 아닌 멤버메서들에서는 접근이 불가능합니다.
	}
	
	

}
