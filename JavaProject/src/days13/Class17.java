package days13;
class Student{
	private int bunho;
	private String name;
	private int [] scores; // 성적을 저장하기 위한 배열 변수
	private String [] subjects = {"국어", "영어", "수학"};
	private int tot; // 총점을 저장하기 위한 변수
	private double avg; // 평균을 저장하기 위한 변수
	private char grade; // 학점을 저장하기 위한 변수
	
	Student(){
		scores = new int[ subjects.length ];
	}
	Student(String name){
		this();
		this.name = name;
	}
	Student(String name, int kor, int eng, int mat){
		this(name);
		scores[0] = kor; scores[1] = eng; scores[2] = mat;
	}
	
	public void copy1(Student b) {  // std1.copy1(std3);
		// this <- std1     b <- std3
		this.bunho = b.bunho;
		this.name = b.name;
		for(int i=0; i<subjects.length; i++) this.scores[i] = b.scores[i];
	}
	public Student copy2() {  //Student std4 = std3.copy2();
		// this <- std3
		Student t = new Student();
		t.bunho = this.bunho;
		t.name = this.name;
		for(int i=0; i<subjects.length; i++) t.scores[i] = this.scores[i];
		return t;  //  std4 <-  t
	}
}
// 디폴트 생성자에서 배열 저장소를 할당해주세요.  그외 동작 없음
// String 자료를 전달인수로 하는 생성자에서 전달된 이름을 멤버변수에 저장해주세요
// 디폴트 생서자, String 매개변수 생성자, String 와 정수 세개가 있는 생성자들 사이에
// 필요한 형제 생성자를  this로 호출해주세요
//  copy1 과 copy2 를 제작해주세요
public class Class17 {

	public static void main(String[] args) {
		Student std1 = new Student("홍길서", 88,99,66);
		Student std2 = new Student("홍길동", 98,87,89);
		Student std3 = new Student("홍길남", 100, 100, 100);
		std1.copy1(std3);
		Student std4 = std3.copy2();
	}

}
