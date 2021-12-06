package days11;

import java.util.Scanner;

public class Method17 {

	public static void main(String[] args) {
		int [][] scores;
		double [] avg;
		//int s=getStudentNumber(); // 학생수를 입력 받아서 리턴하는 메서드
		//int k=getSubjectNumber(); // 과목수를 입력 받아서 리턴하는 메서드
		//scores = new int[s][k];
		scores = new int[getStudentNumber()][getSubjectNumber()+1];
		avg = new double[ scores.length ];
		input(scores);  // s 명의 학생의 k 개의 과목수 입력
		cals(scores, avg);  // 총점 평균 계산
		output(scores, avg); // 성적표 출력
	}
	public static void output( int [][] s, double [] a ) {
		int sub = s[0].length;
		int std = s.length;
		System.out.println("\t\t=====성적표=====");
		System.out.println("--------------------------------------------------");
		System.out.printf("번호\t");
		for(int i=0; i<sub-1; i++)
			System.out.printf("과목%d\t", i+1);
		System.out.printf("총점\t평균\n");
		System.out.println("--------------------------------------------------");
		for(int i=0; i<std; i++) {
			System.out.printf("%d\t", i+1);  // 번호
			for( int j =0; j<sub; j++)
				System.out.printf("%d\t", s[i][j]);
			System.out.printf("%.1f\n", a[i]);
		}
		System.out.println("--------------------------------------------------");
	}
	public static void cals(int [][] s, double [] a) {
		for(int i=0; i<s.length; i++) {
			for(int j=0; j<s[i].length-1; j++) {
				s[i][ s[i].length-1 ] += s[i][j];
			}
			a[i] = s[i][ s[i].length-1 ] / (double)( s[i].length-1 );
		}
	}
	public static void input(int [][] s) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<s.length; i++) {
			for(int j =0 ; j<s[i].length-1; j++) {
				System.out.printf("%d번 학생 %d 과목 점수 : ", i+1, j+1);
				s[i][j] = sc.nextInt();
			}
		}
	}
	public static int getSubjectNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("과목수를 입력하세요 : ");
		return sc.nextInt();
	}
	public static int getStudentNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("학생수를 입력하세요 : ");
		return sc.nextInt();
	}
}
