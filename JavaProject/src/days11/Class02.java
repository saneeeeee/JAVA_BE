package days11;
class Student{
	int bunho;
	String name;
	int kor;  int eng;  	int mat;
	int tot;
	double ave;
}
public class Class02 {
	public static void main(String[] args) {
		Student std1 = new Student();
		Student std2 = new Student();
		std1.bunho = 1;
		std1.name = "홍길동";
		std1.kor = 89; std1.eng = 87; std1.mat = 93;
		std2.bunho = 2;
		std2.name = "홍길서";
		std2.kor = 87; std2.eng = 25; std2.mat = 65;
	}
}
