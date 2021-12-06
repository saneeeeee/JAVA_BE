package days19;

import java.util.HashMap;

class Rect{
	private int x;
	private int y;
	public Rect(int x, int y) { 	this.x = x;	this.y = y;	}	
	public String toString() { return "x:" + this.x + ",y:" + this.y;}
	public boolean equals(Object obj) {
		if( !(obj instanceof Rect) )return false; 
		Rect target = (Rect)obj;
		boolean flag = ((this.x == target.x) && (this.y == target.y));
		return flag;
	}
	// Hash 기반의 클래스에 의해서 호출되는 메소드를  오버라이딩하여 동일한 형태의 객체를 검색하기 위해서 
	// 사용되게 함. 동일한 hashCode를 반환하는 경우에만 equals 메서드  수행
	public int hashCode() {
		System.out.println("Rect 클래스의 hashCode 실행");
		return this.x + this.y;
	}
	// hashCode  메서드의 오버라이딩은 특별한 경우를 제외하고는 권장하지 않습니다.
	// 이미 중복값이 발생되지 않도록 철저히 준비된 연산을 다른 연사능로 바꿔서 실행하는 것 자체가
	// 자바의 코딩규칙을 무너뜨릴 가능성이 있기때문입니다. 다만 오버라이딩은 불가능한 동작이 
	// 아니므로 가능은 하다고 이해하면 됩니다.
	// 해쉬맵의 키값중 특정 값을 찾으려면   keys 나 keyset 메서드를 이용해서 직접 비교하는것을
	// 권장합니다.
}
public class Collection09 {
	public static void main(String[] args) {
		HashMap<Rect, Integer> map = new HashMap<>();
		map.put( new Rect(10, 10) , 10);
		map.put( new Rect(20, 20) , 20);
		map.put( new Rect(30, 30) , 30);
		for( Rect k : map.keySet()) 	
			System.out.printf("(%s)->%d    ", k, map.get(k));

		System.out.printf("\n(30, 30)의 유무 : %b\n", 
				map.containsKey(new Rect(30, 30)));
		// Hash 알고리즘을 기반으로 구현된 클래스에서는  equals 메소드가 호출되지 않는 문제점이 
		// 있습니다
		// Hash 기반의 클래스에서 키 값의 중복을 제거하기 위해서 실행되는 과정(키값이 사용자 정의 
		// 클래스 객체일때)
		// 1. 입력된(검색할) 객체의 hashCode 메소드 실행
		// 2. 반환받은 hashCode 메소드의 결과를  현재 저장되어 있는 모든 객체들의  
		//     hashCode 메소드의 반환값과 비교
		// 3. 만약 동일한 hashCode 메소드의 결과가 존재한다면 equals 메소드를 실행하여 
		//     두 객체가 동일한지 비교
	}
}
