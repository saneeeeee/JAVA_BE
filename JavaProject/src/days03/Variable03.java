package days03;

import java.util.Scanner;

public class Variable03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1, num2;
		double result;
		
		System.out.print("삼각형의 밑변을 입력하세요 : ");
		num1 = sc.nextInt();
		System.out.print("삼각형의 높이을 입력하세요 : ");
		num2 = sc.nextInt();
		
		result = num1 * num2 * 0.5;
		
		System.out.printf("입력한 삼각형의 넓이는 %.1f 입니다\n", result);

	}

}
