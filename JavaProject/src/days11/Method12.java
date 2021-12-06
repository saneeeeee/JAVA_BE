package days11;

public class Method12 {

	public static void main(String[] args) {
		int[] a = {56, 87, 96, 59, 25, 48, 13, 33, 65 };
		int tot = 0;
		double ave;
		tot = sum(a);  //배열의 합계를 계산하여 리턴하는 메서드
		ave = average(a);  // 배열의 평균을 계산하여 리턴하는 메서드
		prn(a, tot, ave); // 배열의 요소와 합계, 평균 출력
	}
	public static void prn(int [] b, int tot, double ave) {
		System.out.printf("배열의 값들 : ");
		for(int k : b) System.out.printf("%d  ", k);
		System.out.printf("\n합계 : %d, 평균 : %.2f", tot, ave);
	}
	public static double average(int [] b) {
		int tot = sum(b); // 사용자가 정의한 메스드들간에도 자유롭게 호출이 가능합니다
		double ave = tot / b.length;
		return ave;
	}
	public static int sum(int [] b) {
		int tot = 0;
		for(int i=0; i<b.length; i++) tot += b[i];
		return tot;
	}

}
