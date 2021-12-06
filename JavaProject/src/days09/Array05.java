package days09;

public class Array05 {

	public static void main(String[] args) {
		// 배열에 있는 값들중 최대값과 최소값을 찾아서 출력하세요
		int [] a = {56, 87, 96, 87, 45, 89, 69, 36, 13, 98};

		int max = a[0]; //  지금까지 나왔던 숫자중 가장 큰값을 저장해둘 변수
		for(int i=1; i<a.length; i++) {
			if( max < a[i] ) 
				max = a[i];
		}
		System.out.println("최대값 : " + max);
		
		int min = a[0];
		for(int i=1; i<a.length; i++) {
			if(min > a[i]) 
				min = a[i];
		}
		System.out.println("최소값 : " + min);
		
		// 배열의 값들을 오름차순 또는 내림차순으로 재배치(정렬)
		// 이중 반복문이 사용됩니다
		// 첫번째 반복문의 첨자 i
		// 두번째 반복문의 첨자 j
		// i=0 일때 j 는 1~9 로 반복시켜서 a[i] 와 a[j] 둘을 비교하고
		// a[j] 값이 더 작으면  a[i]와 a[j] 의 값을 오름 차순에 맞게 맞바꿉니다
		// 그 동작을 j가 끝까지 갈때까지 반복하면  a[i] 에는 배열중 가장 작은 값이
		// 저장되게 됩니다.
		
		int k = 20, b = 30;
		// k = b;
		// b = k;
		int temp;
		temp = k;
		k = b;
		b = temp;
		
		
		for(int i=0; i<a.length; i++) {
			for(int j=i+1; j<a.length; j++) {
				if( a[i] > a[j] ) {
					// a[i]와 a[j] 의 값을 바꿉니다
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		for(int i = 0; i<a.length; i++)	System.out.printf("%d  ", a[i]);
		System.out.println();
		for(int i=0; i<a.length; i++) {
			for(int j=i+1; j<a.length; j++) {
				if( a[i] < a[j] ) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		for(int i = 0; i<a.length; i++)	System.out.printf("%d  ", a[i]);
	}

}
