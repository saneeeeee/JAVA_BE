package days09;

import java.util.Scanner;

public class Array07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("년 입력 : "); 
		int y = sc.nextInt(); 
		System.out.printf("월 입력 : ");
		int m = sc.nextInt();
		int [] mdays = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if( (y%4 == 0) && ( y%100 != 0) || ( y%400 ==0 ) ) 
			mdays[2] = 29;
		int input;
		while(  true   ) {
				int days = 365 * (y-1);
				for( int i=1; i<y; i++) 
					if( i%4==0 && i%100!=0 ||  i%400==0) 
						days++;  
				for(int i=1; i<m; i++)
					days = days + mdays[i];  // 배열을 이용한 월날짜수 계산
				days = days + 1;
				int t = days % 7;
				System.out.println();
				System.out.println(y + "년  " + m + "월");
				System.out.println("----------------------------------------------");
				System.out.println("일\t월\t화\t수\t목\t금\t토");
				System.out.println("----------------------------------------------");
				int k;
				for(k=1; k<=t; k++) System.out.printf("\t");
				
				for(int i= 1; i<=mdays[m]; i++) {
					System.out.printf("%2d\t", i);
					if(k++ % 7==0) System.out.println();
				}
				
				System.out.printf("\n[1.이전달]\t[2.다음달]\t[3.종료] ");
				input = sc.nextInt();
				if(input==3) break;
				
				switch(input) {
					case 1:
						if( m==1) { m=12; y--;}
						else { m--; }
						break;
					case 2:
						if( m==12) { m=1; y++;}
						else { m++; }
						break;
				}
				
		}
		System.out.println("프로그램 종료");

	}

}
