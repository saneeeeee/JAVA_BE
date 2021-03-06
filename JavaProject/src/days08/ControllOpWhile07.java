package days08;

import java.util.Scanner;

public class ControllOpWhile07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("년 입력 : "); 
		int y = sc.nextInt(); 
		System.out.printf("월 입력 : ");
		int m = sc.nextInt();
		// 일 입력 생략
		
		int input;
			
		while(  true   ) {
			
				int days = 365 * (y-1);
				for( int i=1; i<y; i++) 
					if( i%4==0 && i%100!=0 ||  i%400==0) 
						days++;  
				switch(m) {
					case 12: days = days + 30;
					case 11: days = days + 31;
					case 10: days = days + 30;
					case 9: days = days + 31; 
					case 8: days = days + 31; 
					case 7: days = days + 30; 
					case 6: days = days + 31;
					case 5: days = days + 30;
					case 4: days = days + 31;
					case 3: 
						if( y%4==0 && y%100!=0 || y%400==0)	days = days + 29;
						else 	days = days + 28;
					case 2: days = days + 31;
				}
				
				int lastDay=0;
				switch(m) {
					case 1: case 3: case 5: case 7: case 8: case 10: 	case 12: 
						lastDay = 31; break;
					case 2: 
						if( y%4==0 && y%100!=0 || y%400==0)	lastDay = 29;
						else 	lastDay = 28;
						break;
					case 4: case 6: case 9: case 11: 
						lastDay = 30; break;			
				}	
				days = days + 1; // 입력한 년, 월의 1일자의 요일을 계산하기 위해 1합산
				int t = days % 7;
				// t : 0-일, 1-월, 2-화, 3-수, 4-목, 5-금, 6-토  
				
				System.out.println();
				System.out.println(y + "년  " + m + "월");
				System.out.println("----------------------------------------------");
				System.out.println("일\t월\t화\t수\t목\t금\t토");
				System.out.println("----------------------------------------------");
				
				int k;
				for(k=1; k<=t; k++) System.out.printf("\t");
				
				for(int i= 1; i<=lastDay; i++) {
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
