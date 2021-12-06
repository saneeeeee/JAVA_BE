package days14;
// 객체 배열
class Student2{
	int bun;
	String name;
	int [] score;
	static int count=0;
	Student2(){
		score = new int[3];
		bun = ++count; 
		name = "std-" + bun;
	}
	Student2(int a, int b, int c){
		this();
		score[0] = a; score[1] = b; score[2] = c;
	}
}
public class Class27 {

	public static void main(String[] args) {
		// int [] a = new int[5];
		// String [] s = new String[5];
		Student2 [] std = new Student2[5];
		// std[0].bun = 1;   // std[0] 이 널이기때문에 에러
		//  23 라인 명령은 객체를 만든것이 아니라 배열을 만든 것이기 때문입니다.
		// 다섯개의 참조값(주소)을 저장할 수 있는 참조변수들의 배열을 생성
		
		Student2 std0 =  new Student2();
		// 객체 하나 만들듯이, 배열의 한개의 요소에 new Student2() 를 실행합니다
		std[0] = new Student2(98,78,98);
		std[1] = new Student2(78,78,56);
		std[2] = new Student2(65,98,34);
		std[3] = new Student2(89,65,54);
		std[4] = new Student2(76,45,56);
		
		// 결론 : 배열만 만들면 끝이아니라 배열의 한칸 한칸에 뉴인스턴스의 주소를
		//         채워줘야 배열의 요소 갯수 만큼 객체 사용이 가능합니다.
		for(int i=0; i< std.length; i++)
			std[i] = new Student2(100,100,100);
	}

}
