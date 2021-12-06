package days18;

interface Repairable {

}

abstract class Unit {
	int hp; // 현재 체력
	int max_hp; // 최대 체력

	Unit(int p) {
		max_hp = p; // super()로 호출되고 전달된 체력을 max_hp 에 저장
		hp = (int) (p * 0.8);
	}

	public void prnHP() {
		System.out.println("최대 체력 : " + max_hp + ", 현재 체력 : " + hp);
	}

	public abstract void move(int x, int y);
	// public void move(int x, int y) {
	// System.out.println("x : " + x + ", y : " + y + "로 이동합니다");
	// }
}

class GroundUnit extends Unit {
	GroundUnit(int p) {
		super(p);
	}

	@Override
	public void move(int x, int y) {
		System.out.println("x : " + x + ", y : " + y + " 로 뛰어갑니다");
	}
}

class AirUnit extends Unit {
	AirUnit(int p) {
		super(p);
	}

	@Override
	public void move(int x, int y) {
		System.out.println("x : " + x + ", y : " + y + " 로 날아갑니다");
	}
}

class Tank extends GroundUnit implements Repairable {
	Tank() {
		super(150);
	}

	public String toString() {
		return "Tank";
	}
}

class Dropship extends AirUnit implements Repairable {
	Dropship() {
		super(150);
	}

	public String toString() {
		return "Dropship";
	}
}

class Marine extends GroundUnit {
	Marine() {
		super(40);
	}

	public String toString() {
		return "Marine";
	}
}

class SCV extends GroundUnit implements Repairable {
	SCV() {
		super(40);
	}

	public String toString() {
		return "SCV";
	}

	public void repair(Repairable r) {
		if (r instanceof Unit) {
			Unit u = (Unit) r;
			// Tank 나 Dropship 이나 SCV 로 형변환 하지 않고 ,
			// HP 와 MAX_HP 를 공통적으로 다룰 수 있는 부모클래스 Unit으로 변환
			if (u.hp != u.max_hp)
				System.out.println(u + "의 수리를 시작합니다.");
			else {
				System.out.println(u + "의 hp는 만땅입니다.");
				return;
			}

			while (u.hp != u.max_hp) {
				u.hp += 2;
				System.out.println("체력 2를 repair 했습니다. 현재 체력 : " + u.hp);
			}
			System.out.println(u + "의 수리가 끝났습니다.\n");
		}
	}
}

public class Extends11_Interface04 {

	public static void main(String[] args) {
		Tank t = new Tank();
		Dropship d = new Dropship();
		Marine m = new Marine();
		SCV s1 = new SCV();
		SCV s2 = new SCV();

		t.prnHP();
		System.out.print(t + " 이(가) ");
		t.move(10, 20);
		d.prnHP();
		System.out.print(d + " 이(가) ");
		d.move(100, 220);
		m.prnHP();
		System.out.print(m + " 이(가) ");
		m.move(130, 320);
		s1.prnHP();
		System.out.print(s1 + " 이(가) ");
		s1.move(110, 210);
		System.out.println();

		s1.repair(t);
		s1.repair(d);
		// s1.repair(m);
		s1.repair(s2);
	}
}
