package days06;

import java.util.Scanner;

public class ControllOpFor06 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int fact = 1;
		int i, k;
		System.out.printf("출력할 팩터리얼을 입력하세요 : ");
		k = sc.nextInt();
		// 6 을 입력했다면
		// 6! = 1x2x3x4x5x6 = 720
		
		// 6! = 
		System.out.printf("%d! = ", k);
		
		for( i=1; i < k; i++) {
			System.out.printf("%dx", i);
			fact = fact * i;
		}

		System.out.printf("%d = %d", k , fact*k);
	}

}
