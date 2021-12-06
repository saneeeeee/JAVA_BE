package days05;

import java.util.Scanner;

public class ControllOpIf08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int kor, eng, mat, tot;
		double ave;
		System.out.printf("국어점수 : ");
		kor = sc.nextInt();
		System.out.printf("영어점수 : ");
		eng = sc.nextInt();
		System.out.printf("수학점수 : ");
		mat = sc.nextInt();
		tot = kor+eng+mat;
		ave = tot / 3.0;
		
		// 평균 60점 이상이면서 모든 과목 40이상이면 합격
		// 그렇지 않다면 불합격을 출력하되, 
		// 해당되는 불합격사유(평균 미달, 국어 과락, 영어과락, 수학과락)를 
		// 모두 함께 출력하세요
		
		/*
		if( ave>=60 && kor>=40 && eng>=40 && mat>=40)
			System.out.println("합격");
		else if( ave<60 && kor>=40 && eng>=40 && mat>=40 )
			System.out.println("불합격\n평균미달");
		else if( ave>=60 && kor<40 && eng>=40 && mat>=40 )
			System.out.println("불합격\n국어과락");
		else if( ave>=60 && kor>=40 && eng<40 && mat>=40 )
			System.out.println("불합격\n영어과락");
		else if( ave>=60 && kor>=40 && eng>=40 && mat<40 )
			System.out.println("불합격\n수학과락");
		else if( ave<60 && kor<40 && eng>=40 && mat>=40 )
			System.out.println("불합격\n평균미달\n국어과락");
		// .... 경우의 수 약 30개
		else if( ave<60 && kor<40 && eng<40 && mat<40 )
			System.out.println("불합격\n수학과락");
		*/
		
		if(ave>=60 && kor>=40 && eng>=40 && mat>=40 )
			System.out.println("합격");
		else {
			System.out.println("불합격");
			if( ave<60) System.out.println("평균미달");
			if( kor<40) System.out.println("국어과락");
			if( eng<40) System.out.println("영어과락");
			if( mat<40) System.out.println("수학과락");
		}
	}

}
