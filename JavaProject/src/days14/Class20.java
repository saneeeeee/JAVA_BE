package days14;
class Student{
	private int bun;
	private String name;
	private int [] scores;
	
	static int count = 0;
	
	public void prn() {
		System.out.println(this.bun + " : " + this.name + " : " 
		+ this.scores[0] + " : "	+ this.scores[1] + " : " + this.scores[2]);
	}
	
	Student(){
		scores = new int[3];
		bun = ++count;
	}
	Student(String name){
		this();
		this.name = name;
	}
	Student(String name, int kor, int eng, int mat){
		this(name);
		this.scores[0] = kor; this.scores[1] = eng; this.scores[2] = mat;
	}
	Student( Student s ){
		this(s.name, s.scores[0], s.scores[1], s.scores[2]);
	}
}
public class Class20 {
	public static void main(String[] args) {
		Student s1 = new Student("홍길남", 98,69,87);
		Student s2 = new Student("홍길서", 45,87,78);	
		Student s3 = new Student("홍길동", 56,99,55);	
		Student s4 = new Student( s3 );	
		System.out.println( Student.count );
		s1.prn(); 		s2.prn();		s3.prn();		s4.prn();
	}
}
