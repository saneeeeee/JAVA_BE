package days07;

import java.util.Scanner;

public class ControllOpFor16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		System.out.print("소수인지 판단할 숫자를 입력하세요");
		int num = sc.nextInt();
		*/
		int  i,cnt = 0;
		/*
		for(i=1;i<=num;i++) {
			if(num%i==0) cnt++;
		}
		if(cnt==2) System.out.println("입력한 정수는 소수입니다.");
		else System.out.println("입력한 정수는 소수가 아닙니다.");
		*/
		
		int j;
		for(i = 2; i <= 100; i++) {
			for(j = 2; j <= i/2; j++) {
				if(i % j == 0) cnt++;
			}
			if(cnt == 0) System.out.print(i + " ");
			cnt = 0;
		}
	}
}
