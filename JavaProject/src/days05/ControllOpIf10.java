package days05;

import java.util.Scanner;

public class ControllOpIf10 {

	public static void main(String[] args) {
		// 2021년 1월 1일은 금요일입니다.
		// 2021년에 한해서  월과 일을 입력 받고,
		// 요일을 출력하세요

		//  1월 10일 입력했다면   1월 1일 부터 10일까지 10일의 날짜가 계산됩니다
		//  그를 7로 나눈 나머지를 구하면  3이고,   1:금요일  2:토요일  3:일요일....
		// 위와 같이 요일을 계산합니다   해당 입력일은 일요일
			
		// 2월 5일 입력했다면 - 1월에 해당하는 31일 + 입력한 일 5 -> 36
		// 36을 7로 나눈 나머지 계산하면  1  해당입력일은 금요일   
		
		// 1. 요일을 계산할 월과 일을 입력 받습니다
		Scanner sc = new Scanner(System.in);
		System.out.printf("월 입력 : ");
		int m = sc.nextInt();
		System.out.printf("일 입력 : ");
		int d = sc.nextInt();
		
		int days = 0; // 날짜들이 합산되어 저장될 변수
		// 입력한 월의 전달까지 달의 날짜들을 모두 합산
		if( m==1) days = 0;
		else if( m==2) days = 31;
		else if( m==3) days = 31+28;
		else if( m==4) days = 31+28+31;
		else if( m==5) days = 31+28+31+30;
		else if( m==6) days = 31+28+31+30+31;
		else if( m==7) days = 31+28+31+30+31+30;
		else if( m==8) days = 31+28+31+30+31+30+31;
		else if( m==9) days = 31+28+31+30+31+30+31+31;
		else if( m==10) days = 31+28+31+30+31+30+31+31+30;
		else if( m==11) days = 31+28+31+30+31+30+31+31+30+31;
		else if( m==12) days = 31+28+31+30+31+30+31+31+30+31+30;
		
		// 위에서 합산된 날자수에  입력한 일을 더합니다
		days = days + d;
		
		// 최종 합산된 날짜들을  7로 나눈 나머지를 구합니다
		int t = days % 7;
		
		if( t==1 )System.out.println("금요일");
		else if( t==2 )System.out.println("토요일");
		else if( t==3 )System.out.println("일요일");
		else if( t==4 )System.out.println("월요일");
		else if( t==5 )System.out.println("화요일");
		else if( t==6 )System.out.println("수요일");
		else if( t==0 )System.out.println("목요일");
	
	}

}
