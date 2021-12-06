package days10;

import java.util.Scanner;

public class Array13 {

	public static void main(String[] args) {
		// 3명 학생의 3과목 점수 저장 배열.  마지막 열은 총점
		int [][] score = new int[3][4];
		String [] name = new String[3];
		double [] avg = new double[3];
		
		Scanner sc  = new Scanner(System.in);
		
		for( int i = 0; i<score.length; i++) {
			System.out.printf("%d 번 이름 : " , (i+1) );
			name[i] = sc.nextLine();
			for(int j =0; j<score[i].length-1; j++) {
				System.out.printf("%d번 학생의 ", i+1);
				if(j==0) System.out.printf("국어점수 입력 : ");
				else if(j==1) System.out.printf("영어점수 입력 : ");
				else System.out.printf("수학점수 입력 : ");
				score[i][j] = Integer.parseInt( sc.nextLine() );
				score[i][3] += score[i][j]; // 입력한 점수 총점에 누적
			}
			avg[i] = score[i][3] / 3.0;  //1 명의 입력종료후 바로 평균 계산
		}
		System.out.println("\t\t=====성적표=====");
		System.out.println("--------------------------------------------------");
		System.out.println("번호\t성명\t\t국어\t영어\t수학\t총점\t평균");
		System.out.println("--------------------------------------------------");
		for(int i=0; i<score.length; i++) {
			System.out.printf("%d\t", i+1);  
			System.out.printf("%s\t\t", name[i]);
			for(int j=0; j<score[i].length; j++) { 
				System.out.printf("%d\t", score[i][j]);
			}
			System.out.printf("%.2f\n", avg[i]);
		}
		System.out.println("--------------------------------------------------");
	}
}
