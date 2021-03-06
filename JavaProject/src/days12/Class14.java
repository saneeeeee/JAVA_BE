package days12;
class ThisA{
	private int num;
	public void init(int num) {
		this.num = num;
		// 멤버변수와 지역변수(매개변수)와 부득이하게 이름이 같았을때,
		// 그 둘을 구분하기 위해 멤버변수 앞에  this. 을 붙여서 사용합니다
	}
	// this 키워드는 클래스 내부에서사용되는 모든 멤버 변수에 원래 붙어 있지만
	// 사용 편의상 확실히 멤버변수로 구분할 수 있는 경우 생략해서 사용하고 있으며,
	// 위와 같이 매개변수와 이름이 같지 않은 경우도 this 를 붙여서 사용할 수 있습니다
	public void prn() {
		System.out.println("멤버변수 num 의 값 : " + this.num );
	}
}
public class Class14 {
	public static void main(String[] args) {
		ThisA  t1 = new ThisA();
		t1.init(100);
		t1.prn();
	}
}
