package days07;

public class ContorllOpFor16 {

	public static void main(String[] args) {
		// 1부터 100사이의  소수(prime number) 를 출력해주세요
		// 소수(prime number) : 1 과 자기 자신의 숫자로만 나누어 떨어지는 숫자
		// 방법은 역시 단순 무식하게...하나의 숫자가 소수인지 알아 보기위해...
		// 1 부터 자기자신의 숫자 사이의 모든 숫자로 나눠보고
		// 나누어 떨어진 횟수가 2회이면 소수인걸로 간주하여   출력
		// 그렇지 않으면 다음 숫자(다음 반복)로 넘어갑니다
		// 이중 반복문이 사용됩니다.  중간에 if 문도 사용됩니다.
		// cnt 변수를 만들어서, 나눠 떨어질때마다  cnt++ 연산을 하고
		// cnt 값이 2일때 소수인걸로 판단합니다
		for( int i=1; i<=100; i++) {
			for(int j=1; j<=i; j++) {
				//if(    ) {     }
			}
		}
		// 1부터 100까지 하나하나 판단하는 것이 어렵다면 숫자하나를 입력받고
		// 그숫자가 소수인지 아닌지 판단하여 출력해보고, 대상을 1부터 100으로
		// 늘리는 방식을 이용하면 조금 도움이 될듯합니다
	}

}
