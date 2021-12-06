package days08;

import java.util.Scanner;

public class ControllOpWhile03 {

	public static void main(String[] args) {
		// 정수를 입력받아서 입력된 정수의 팩터리얼을 출력해주세요
		//  while 문을 이용합니다
		// 6을 입력하면 6! = 1x2x3x4x5x6 = 720   
		Scanner sc = new Scanner(System.in);
		int n, fact=1;
		System.out.print("\n팩터리얼을 계산할 정수 입력 : ");
		n = sc.nextInt();
		
		System.out.printf("%d! = ", n);
		
		int i=1;
		while( i<n) {
			System.out.printf("%dx", i);
			fact = fact * i;
			i++;
		}	
		System.out.printf("%d = %d", n, fact*n);
		System.out.println("//---------------------------");
		fact = 1;
		System.out.printf("%d! = ", n);	
		while( n>1) {
			System.out.printf("%dx", n);
			fact = fact * n;
			n--;
		}	
		System.out.printf("1 = %d",  fact);
	}

}
