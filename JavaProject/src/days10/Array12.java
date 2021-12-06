package days10;

public class Array12 {

	public static void main(String[] args) {
		// 2차원 배열은 각행에 속한 열의 요소가 서로 다를수도 있습니다.
		// 2차원 배열 변수 선언
		int [][] a;   // 배열을 위한 참조변수만 생성한 상태

		// 각 1차원 배열들의 주소를 저장할 참조변수들의 배열을 만들어 주소 전달
		// 실제 데이터 저장 배열들은 아직 생성전
		a = new int[3][];
		
		// 3개의 참조 변수에 세개의 1차원 배열들을 생성하여 주소를 전달
		a[0] = new int[3];  //arr[0][0]  arr[0][1]  arr[0][2]
		a[1] = new int[5];  //arr[1][0]  arr[1][1]...arr[1][4]
		a[2] = new int[2];  //arr[2][0]  arr[2][1]
		
		int k=1;
		for(int i=0; i<a.length; i++) {
			for(int j =0; j<a[i].length  ;j++) {
				a[i][j] =  k++;
			}
		}
		for( int [] rowAddr : a) {
			for( int colValue : rowAddr) {
				System.out.printf("%d\t", colValue);
			}
			System.out.println();
		}
	}

}
