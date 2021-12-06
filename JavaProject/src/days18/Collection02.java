package days18;

import java.util.ArrayList;

//	컬렉션 클래스 저장방식
//	모든 컬렉션 클래스들은 기본적으로 Object 타입을 저장/반환할 수 있습니다.

//	Object 타입을 매개변수 사용하는 모든 컬렉션 클래스들은 타입에 상관없이 저장할 수 있음
//	하지만, 저장된 데이터를 반환받는 과정에서 런타임 에러가 발생될 수 있습니다.
//	Object -> 자식클래스의 타입 : 강제형변환
public class Collection02 {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		//	다양한 타입을 저장할 수 있는 컬렉션 클래스의 객체
		a.add(10);
		a.add(1.1);
		a.add("Hello");
		Integer i0 = (Integer)a.get(0);
		//	컬렉션 내부의 데이터를 추출하는 과정에서 일치하지 않는 타입으로 형 변환이 일어나는
		// 경우 런타임 에러가 발생되어 프로그램이 강제 종료
		//	Integer i1 = (Integer)a.get(1);	//	에러
		Double i1 = (Double)a.get(1);
		//	String i2 = a.get(2); // 에러
		String i2 = (String)a.get(2);
		
		System.out.printf("i0 -> %d\n",i0);
		System.out.printf("i1 -> %.1f\n",i1);
		System.out.printf("i2 -> %s\n",i2);
		
		//	위와 같이 하나의 ArrayList 에 여러 자료형태를 섞어서 저장하고 사용할 수 있습니다.
		//	다만 자료형을 섞어서 저장하고 사용할 경우 위의 에러 내역과 같이 꺼내고,
		//	형변환할때 자료형이 맞지 않아 에러가 발생하거나 형변환을 하지 않아 에러가 발생할
		//	확률이 높아집니다.
		//	그래서 보통은 자료형을 하나로만 통일해서 저장하는 형식을 사용하게 되고, 
		//	규칙으로 만들어 지정한 자료형이 저장되지 못하도록 사용하기도 합니다
		ArrayList<Integer> list = new ArrayList<Integer>();
		//	get() 으로 자료를 꺼낼 때 강제 형변환이 없어도 됩니다.
		
		list.add(100);
		//	list.add("String"); 	//	에러 다른 자료형을 저장이 안되게
		Integer i = list.get(0);	// 자료를 꺼낼 때 강제 형변환을 안써도 되게
	}
}

//	컬렉션 프레임웍에서 제네릭의 사용
//	보통의 컬렉션 프레임웍은 여러타입이 혼용되어 저장은 가능하지만 실제로 혼용되어 저장되는
//	경우는 거의 없습니다
//	다만, 컬렉션 클래스의 입력, 반환에 관련한 모든 메서드들은 Object 타입을 기반으로 하기때문에
//	컬렉션에서 데이터 인출(.get()) 시에 강제형변환을 해야하는 불편함이 존재합니다.
//	이러한 문제점을 해결하기 위해 JDK 1.5 버젼 이후에는 제네릭 문법을 지원합니다
//	제네릭 문법을 사용하지 않은 ArrayList 의 사용 ----------------------------------
//	ArrayList a = new ArrayList();
// a.add(100);
//	Integer i = (Integer)a.get(0);		// 다시 꺼내어 쓸때 강제 형변환이 반드시 필요
//	제네릭 문법 ---------------------------------------------------------------
//	동일한 이름의 클래스이지만
//	객체 생성 시점에... 자료형을 지정하여 서로 다른 자료형을 지원하는 클래스의 생성할 수 있는 문법
//	(메소드 오버로딩과 유사한 문법)
//	제네릭 문법을 사용한 ArrayList 클래스의 객체 생성 예시
//	ArrayList<Integer> a = new ArrayList<Integer>();
//	new 다음의 클래스명에서는 제네릭 타입을 생략할 수 있음
//	ArrayList<Integer> a = new ArrayList<Integer>();
//	a.add(100);	Integer i = a.get(0);