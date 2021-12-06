package days08;

import java.util.Random;

public class ControllOpWhile05 {

	public static void main(String[] args) {
		
		// 랜덤한 숫자(난수)를 얻기 위해서는 랜덤한 숫자를 발행해주는 
		// 도구가 필요합니다.
		Random rd = new Random();
		
		// Scanner 의 sc 를 이용하여 외부에서 자료를 입력받듯이
		// Random 의 rd 를 이용해서 난수를 제공받습니다
		int i =0;
		while(i<10) {
			int num = rd.nextInt();
			// System.out.println(num);
			if( num < 0) num = num * -1;
			// System.out.println(num);
			num = num % 10;
			System.out.printf("%d  ", num);
			i++;
		}
	}

}
