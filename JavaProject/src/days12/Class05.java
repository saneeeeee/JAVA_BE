package days12;
class Account{
	private double balance; // 계좌정보 클래스에 잔액이 저장된 멤버변수
	// 클래스의 멤버필드/메소드는 접근지정자(private, protected, public)에 
	// 의해서 외부에서의 접근을 제어할 수 있습니다.
	// 접근지정자를 사용하지 않는 경우 기본지정으로 public 이 설정되며, 클래스외부에서
	// 임의의 사용으로 값을 대입하거나 얻을수 있습니다. 
	// 이는 멤버필드의 값이 강제로 수정될 수 있다는 뜻이기도합니다. 
	// 이를 방지하고 무분별한 접근을 막기위해 멤버변수에 private 를 지정합니다.
	//  private 은 자기자신 class 의 멤버메서드만 접근 가능합니다
	// 멤버메서드는 대개 public 으로 지정되며, 외부에서 자유로운 접근이 가능합니다.
	public void initBanance(int i) {
		// 검증 절차를 거쳐서 값이 대입될 수 있는 구조
		balance = i; 
	}
	public void display() {
		System.out.printf("현재 잔액은 %.2f 원 입니다.\n", balance);
	}// 잔고 확인 기능
	public void withraw(int money) {
		balance -= money;
	}	// 출금 기능
	public void deposit(int money) {
		balance += money;
	} // 입금 기능
}
public class Class05 {

	public static void main(String[] args) {
		Account a = new Account();
		// a.balance = 50000; //  에러
		// System.out.printf("현재 잔액은 %.2f 원 입니다.\n", a.balance); //에러
		a.initBanance(100000);
		a.display();
		a.withraw(5000);  		a.display(); //출금
		a.deposit(20000); 		a.display(); // 입금

	}

	// 정보은닉
	// 클래스 내부에 선언된 멤버필드들은 현실에 존재하는 대상의 정보를 저장합니다. 
	// 일반적으로 이러한 정보들은 직접적으로 접근 및 수정해서는 안됩니다. 
	// 이러한 이유로 모든 멤버필드들은 private으로 선언하고, 멤버필드들을 제어할 
	// 수 있는 메소드들을 public 으로 선언합니다.
}
