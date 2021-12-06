package days17;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarClass05 {

	public static void main(String[] args) {
		int year, month; 
        int input=0;
        Scanner sc = new Scanner(System.in);
        System.out.printf("년도 입력 : ");
        year=Integer.parseInt( sc.nextLine() );
        System.out.printf("월 입력 : ");
        month=Integer.parseInt( sc.nextLine() );
        
        Calendar sDay = Calendar.getInstance();  // 출력할 달력의 시작날짜 (1일)
    	Calendar eDay = Calendar.getInstance();  // 출력할 달력의 끝날자(말일)
    	
    	//while(true) {
		    	sDay.set( year, month-1, 1 );  // 입력한 년,월,1일  로 시작일설정
		    	eDay.set( year, month, 1 );   // 다음달 1일
		    	eDay.add( Calendar.DATE, -1);  // -1일을 계산해서 이달 말일로 설정 
		while(true) {
		    	// sDay(1일)의 요일 계산
		    	int START_WEEK = sDay.get(Calendar.DAY_OF_WEEK);
		    	System.out.println("\n" + year + "년  " + month + "월  ");
		    	System.out.println("----------------------------------------------");
		        System.out.println("일\t월\t화\t수\t목\t금\t토");
		        System.out.println("----------------------------------------------");
		        // 1일자까지 빈칸
		        for( int i=1; i<START_WEEK; i++) System.out.printf("\t");
		        // 1일부터 마지막 날짜까지 출력
		        for( int i=1; i<= eDay.get(Calendar.DATE) ; i++) {
		        	System.out.printf("%2d\t", i);
		        	if(START_WEEK++ % 7 == 0) System.out.println();
		        }
		        System.out.println("\n----------------------------------------------");
		        System.out.print("\n[이전달(1)] | [다음달(2)] | [종료(3)]");
		        input = Integer.parseInt( sc.nextLine() );
		        if(input==3)break;
		        // 이전달 다음달 처리
		        //  set 와 add  메서드를 이용해서 이전달 다음달을 계산합니다
		        if( input ==1) {
		        	//if(month==1) { 	year--;  month=12;
		        	//}else {	month--;  	}
		        	sDay.add(Calendar.MONTH, -1); // 11월 1일 -> 10월 일
		        	// 원래월의 1일자로 변경(11월30일에서 12월1일로)
		        	eDay.add(Calendar.DATE, 1); 
		        	// 이전달 1일자로 이동(12월1일에서 11월1일로)
		        	eDay.add(Calendar.MONTH, -1); 
		        	// 그전달 말일로 이동(11월1일에서 10월 31일로)
		        	eDay.add(Calendar.DATE, -1);  		        	
		        }else if(input == 2) {
		        	//if(month==12) {	year++;  month=1;
		        	//}else {  month++;     	}
		        	sDay.add(Calendar.MONTH, 1);
		        	eDay.add(Calendar.DATE, 1);
		        	eDay.add(Calendar.MONTH, 1);
		        	eDay.add(Calendar.DATE, -1);
		        }
		        year = sDay.get(Calendar.YEAR);
		        month = sDay.get(Calendar.MONTH)+1;
    	}
	}

}
