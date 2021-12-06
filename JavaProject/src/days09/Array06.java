package days09;

import java.util.Random;

public class Array06 {

	public static void main(String[] args) {
		int[] a = new int[6];
		Random rd = new Random();
		
		for(int k=1; k<=5; k++) {
			
				for(int i=0; i<=5; i++) {
					a[i] = rd.nextInt();
					if( a[i] < 0 ) a[i] *= -1;
					a[i] = a[i] % 45 + 1;
					// 로또 번호 6개 반복실행문으로 발생해서 저장합니다
					int j;
					for( j=0; j<i; j++)
						if( a[i]==a[j] ) break;
					
					if( i != j ) i--;			
				}
				// 정렬합니다
				for(int i=0; i<a.length; i++) {
					for(int j=i+1; j<a.length; j++) {
						if( a[i] > a[j] ) {
							int temp = a[i];
							a[i] = a[j];
							a[j] = temp;
						}
					}
				}
				// 출력합니다.
				for(int i = 0; i<a.length; i++)	
					System.out.printf("%d  ", a[i]);
				
				System.out.println();
		}
	}
	
}
