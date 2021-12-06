package days12;
//this 변수 : 레퍼런스(참조) 변수
//클래스의 멤버필드들은 new 라는 키워드에 의해서 각각의 객체별로 생성됩니다.
//(서로 다른(겹치지 않는) 메모리 공간)
//반면, 멤버 메서드는 생성된(오버로딩 포함) 메서드별로 하나만 존재하며 모든 객들이 
//공유해서 필요시 호출합니다.
//이때 현재 메서드를 호출한 객체가 어떤 객체인지 구분하여 실행될 수 있게 this 라는 
//숨겨진 참조변수를 제공합니다
class ThisB{
	private int num;
	public void setNum(int num  /*,  ThisB this*/ ) {
		this.num = num;
		// this 에는 현재 메서드를 호출한 객체의 참조변수값이 전달되어 저장됩니다.
		// 매개변수로 선언된 num 변수는 현재 메서드안에서만 사용되는 지역 변수로만 
		// 사용되고 소멸합니다.
		// 멤버 메서드에서는 멤버변수에 접근 권한이 있으므로, 참조변수 this와 
		// 멤버변수가 (.) 으로 연결되어 사용됩니다
	}
	public void prn( /*,  ThisB this*/ ) {
		System.out.printf("num = %d\n", num);
		// 보통 멤버변수를 this 없이 사용해도 이름이 중복된 매개변수가 아니라면 
		// 아래의 실행 코드는 내부적으로 this 가 붙어서 실행됩니다.
		// System.out.printf("num = %d\n", this.num);
	}
	// this 의 용도 1 : 멤버메서드를 호출한 호출객체의 참조변수값(주소값)을 
	// 전달받아 전달된 메서드를 호출한 객체를 식별하는 용도로 사용됩니다.
	
	
	// b4.copy( b2 );    this <- b4      temp <- b2
	public void copy( ThisB temp ) {
		this.num = temp.num;
	}
	
	
	//ThisB b5 = b4.copy2();     this <- b4
	public ThisB copy2() {
		ThisB temp = new ThisB();
		temp.num = this.num;
		return temp;
	}
	
}
public class Class15 {
	public static void main(String[] args) {
		ThisB b1 = new ThisB();
		ThisB b2 = new ThisB();
		
		b1.setNum(100);
		b2.setNum(200);
		b1.prn();
		b2.prn();
		
		ThisB b3 = b1;    // b1 이 저장한 참조값(주소)을  b3에 저장
		// 인스턴스는 하나, 같은 주소를 갖는 참조 변수는 두개의 효과 
		b3.setNum(300);  // b3 의 변수값변경은 b1 의 변경이기도 합니다.
		b1.prn();
		b3.prn();
		// 위 연산은  new 를 이용하여 b3 에 새로운 공간을 만든게 아니라,
		// b1위 레퍼런스 값만 복사 저장한 결과로, b1 과 b3 는 같은 공간의 주소를 
		// 저장하고 있기 때문입니다.
		
		// 새로운 공간을 만들고 변수값을 복사하려면,  
		// 어디선가는 반드시 new ThisB() 가 필요합니다
		ThisB b4 = new ThisB();
		b4.copy( b2 );  // 객체 복사 방법 #1
		// b4.num = b2.num; X
		b2.setNum(500);
		b2.prn();
		b4.prn();
		
		
		// 객체 복사 방법 #2
		ThisB b5 = b4.copy2();
		b4.prn();
		b5.prn();
	}
}
