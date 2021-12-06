package days13;
class Dog{
	private String name;
	private int age;
	private String phone;
	// 멤버 메서드의 생성 주된 목적 : 멤버 변수에 값을 대입하고, 연산하고, 출력
	// 목적대로 한다면 d1.name = "댕댕이";  연산이 가능하므로, 메서드가
	// 필요 없을수도 있습니다.
	// 다만 멤버변수에  private  이 붙어 있다면 d1.name = "댕댕이";  가
	// 불가능하므로,  public  형태의 멤버 메서드를 생성하여 사용합니다
	
	// 그중에서도 이클리스에서 자동으로 생성되는 메서드(getter/setter) 를
	// 자주 사용하곤 합니다
	
	// getter 와 setter 의 자동 생성 
	// 현위치에서 마우스오른쪽 버튼 클릭 
	//   -> Source 메뉴 -> Generate Getters and Setters 선택
	// selectAll 클릭 -> Generate 클릭
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
public class Class004 {

	public static void main(String[] args) {
		Dog d1 = new Dog();
		// d1.name = "댕댕이";
		d1.setName("댕댕이");
		d1.setAge(6);
		d1.setPhone("010-5555-6666");
		
		System.out.println("이름:" + d1.getName() + "  나이 : " + 
				d1.getAge() + "  전화번호 : " + d1.getPhone() );

	}

}
