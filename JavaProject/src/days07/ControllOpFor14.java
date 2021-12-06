package days07;

public class ControllOpFor14 {

	public static void main(String[] args) {
		// 이중 반복문을 이용해서
		// 구구단 2단부터 9단까지를 출력하세요
		// 한개의 단이 출력되는 방향은 세로이든 가로이든 상관없습니다.
		for(int i=1; i<=9; i++) {
			for(int j=2; j<=5; j++) {
				System.out.printf("%dx%d=%2d  ", j, i, i*j);
			}
			System.out.println();
		}
		System.out.println();
		for(int i=1; i<=9; i++) {
			for(int j=6; j<=9; j++) {
				System.out.printf("%dx%d=%2d  ", j, i, i*j);
			}
			System.out.println();
		}
	}

}
