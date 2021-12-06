package days03;

import java.util.Scanner;

public class Variable04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num;
		double n, d;
		
		System.out.print("반지름을 입력하세요 : ");
		num = sc.nextInt();
		
		n = num*num*3.141592;
		d = 2*num*3.141592;
		
		System.out.println("입력한 원의 넓이는 " + (int)(n*100) / 100.0 + "입니다");
		System.out.println("입력한 원의 둘레는 " + d + "입니다");
		// 123.1234
		// 123.1234 * 100  ->  12312.34
		// (int)12312.34  ->  12312
		// 12312 / 100.0   ->  123.12

	}

}
