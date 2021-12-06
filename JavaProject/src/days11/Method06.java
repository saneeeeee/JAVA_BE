package days11;

public class Method06 {

	public static void main(String[] args) {
		int [] a = {56,54,87,89,25,36,57,98,59,87};
		// 아래명령 sum(a); 이 정상 실행되어서 배열내의 값의 합계를 출력도록
		// sum 함수를 제작하세요
		sum(a);
	}
	
	public static void sum(int [] b) {
		int total = 0;
		for(int i=0; i<b.length; i++)
			total += b[i];
		System.out.println("배열의 합계 : " + total);
	}

}
