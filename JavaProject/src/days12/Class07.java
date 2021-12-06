package days12;
//멤버메서드의 주된 목적은 멤버변수의 값을 저장하거나 얻어오거나.... 
//그 둘의 목적이 비교적 큽니다
//때문에 특정멤버메서드(저장하고 얻어오는 메서드)를 별도의 사유가 없어도 
// 멤버변수에 따라 필요한 만큼 만들고 시작하는 경우가 많습니다.
//메서드의 이름은 setter와  getter 라는 이름을 사용하는 두개의 매서드 입니다
class GetSetTest {
	private int intVar;
	private double doubleVar;
	private String stringVar;
	// 멤버 변수가 하나 만들어지면, 그변수에 전달값을 저장할수 있는 메서드와 값을 얻어 
	// 낼수 있는 메서드를 생성합니다
	
	
	// getter 와 setter 의 자동 생성 
	// 현위치에서 마우스오른쪽 버튼 클릭 
	//   -> Source 메뉴 -> Generate Getters and Setters 선택
	// selectAll 클릭 -> Generate 클릭
	

	public double getDoubleVar() {
		return doubleVar;
	}
	public int getIntVar() {
		return intVar;
	}
	public void setIntVar(int intVar) {
		this.intVar = intVar;
	}
	public void setDoubleVar(double doubleVar) {
		this.doubleVar = doubleVar;
	}
	public String getStringVar() {
		return stringVar;
	}
	public void setStringVar(String stringVar) {
		this.stringVar = stringVar;
	}
	
	// 멤버 변수의 값을 저장하는 메서드 이름 : setIntVar
	//public void setIntVar(int n) { 	intVar = n; }
	// 멤버 변수의 값을 리턴해주는 메서드 이름 : getIntVar
	//public int getIntVar() { return intVar;	}
	//public void setDoubleVar(double d) { doubleVar = d; }
	//public double getDoubleVar() { return doubleVar;	}
	//public void setStringVar(String s) { 	stringVar = s; }
	//public String getStringVar() { return stringVar;	}
	
}
public class Class07 {

	public static void main(String[] args) {
		GetSetTest gs = new GetSetTest();
		gs.setIntVar(123);
		System.out.println("멤버변수 intVar : " + gs.getIntVar() );
	}

}
