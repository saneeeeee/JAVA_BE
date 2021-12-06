package days14;
// 스태틱변수는 클래스내부에 존재하지만, 객체 생성과 상관없이 프로그램 시작전 한번만 
// 생성되고, 프로그램 종료시까지 변수가 갖는 값을 일관되게 유지 또는 변경 관리합니다. 
class StaticB {
	int bunho;
	static int count = 0;
	StaticB(){
		count++;
		bunho = count;
		//생성자 메서드에서 count 값을 1씩 증가시키며, 그값을 num 에 저장
	}
}
public class Class19 {
	public static void main(String[] args) {
		System.out.printf("count = %d\n", StaticB.count);
		StaticB b1 = new StaticB();
		System.out.printf("b1.num = %d, count = %d\n", 
				b1.bunho, StaticB.count);
		StaticB b2 = new StaticB();
		System.out.printf("b2.num = %d, count = %d\n", 
				b2.bunho, StaticB.count);
		StaticB b3 = new StaticB();
		System.out.printf("b3.num = %d, count = %d\n", 
				b3.bunho, StaticB.count);
	}

}
