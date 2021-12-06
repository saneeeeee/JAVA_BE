package days18;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
//	HashSet 클래스
//	데이터의 중복을 허용하지 않고 저장하는 클래스
//	- 검색을 위해서 사용되는 클래스
//	(저장할 때 hash 연산의 결과로 저장하니, 검색할 때도 hash 연산 결과로 검색하여 빠른 
//	검색이 가능)
//	hash 연산 : 클래스 내에서 유일한값을 얻어낼 수 있는 고유 알고리즘 연산
//	- 중복된 값을 제거하면서 데이터를 저장하기 위해 사용 
public class Collection04 {

	public static void main(String[] args) {
		Vector<Integer> v = new Vector();
		v.add(1);	v.add(2);	v.add(2);
		System.out.println(v.size());	//	중복을 허용하기 때문에 3이 반환
		
		ArrayList<Integer> a = new ArrayList();
		a.add(1);	a.add(2);	a.add(2);
		System.out.println(a.size());	//	중복을 허용하기 때문에 3이 반환
		
		LinkedList<Integer> l = new LinkedList();
		l.add(1);	l.add(2);	l.add(2);
		System.out.println(l.size());	//	중복을 허용하기 때문에 3이 반환
		
		HashSet<Integer> h = new HashSet();
		h.add(1);	h.add(2);	h.add(2);
		System.out.println(h.size());	//	중복을 허용하지 않기 때문에 2이 반환
		
		HashSet<Integer> lotto = new HashSet<>();
		while (lotto.size() <6) {
			lotto.add((int)(Math.random()*45)+1);			
		}
		for(Integer i : lotto)System.out.printf("%2d\t",i);
		System.out.println();
		//	해쉬 세트 컬렉션에는 sort 메서드가 없습니다. 따라서 링크드 리스트
		//	부모클래스인 List 클래스에 전해줘서 리스트 변환과정을 거치고,
		//	Collections.sort 로 정렬을 수행하여야 합니다.
		List list = new LinkedList(lotto);
		Collections.sort(list);
		System.out.println(list);
	}

}
