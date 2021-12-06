package days12;
class Student{
	private int bun;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double ave;
	
	public void input(int b, String n, int k, int e, int m) {
		bun = b;
		name = n;
		kor = k;
		eng = e;
		mat = m;
		tot = k+e+m;
		ave = tot / 3.0;
	}
	void prnTitle() {
		System.out.println("---------------------------------------------------");
		System.out.println("번호\t성명\t\t국어\t영어\t수학\t총점\t평균");
		System.out.println("---------------------------------------------------");
	}
	void prn() {	
		System.out.println("---------------------------------------------------");
		System.out.println("번호\t성명\t\t국어\t영어\t수학\t총점\t평균");
		System.out.println("---------------------------------------------------");
		System.out.printf("%d\t%s\t\t", bun, name);
		System.out.printf("%d\t%d\t%d\t%d\t%.1f\n", kor,eng,mat,tot,ave);
	}
}
public class Class04 {

	public static void main(String[] args) {
		Student std1 = new Student();
		//std1.bun = 1;
		//std1.name = "홍길동";
		//std1.kor = 89; 
		//std1.eng = 87; 
		//std1.mat = 93;
		//std1.tot = std1.kor + std1.eng + std1.mat;
		//std1.ave = std1.tot / 3.0;
		std1.input(1, "홍길동", 88,77,99);
		
		Student std2 = new Student();
		std2.input( 2, "홍길서", 89,98,78 );
		
		// std1.prnTitle();
		std1.prn();
		std2.prn();
	}
}
