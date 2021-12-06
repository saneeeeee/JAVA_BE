package days16;

import java.util.Random;

class Mymath {
	private int a, b;
	static int c = 0;

	Mymath() {
		c++;
	}

	int add() {
		return a + b;
	}

	int subtract() {
		return a - b;
	}

	int multiply() {
		return a * b;
	}

	double divide() {
		return a / (double) b;
	}

	void init() {
		a = c * 100;
		b = c * 100;
	}

	int add(int e, int d) {
		return a + b + c + d + e;
	}

	static int subtract(int e, int d) {
		return e - d + c;
	}

	static int multiply(int e, int d) {
		return e * d + c;
	}

	static double divide(double e, double d) {
		return e / d + c;
	}
}
class Aclass{
	public void copyobject(Aclass b) {
		System.out.println(this);
		System.out.println(b);
	}
}
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rd = new Random();

		int i = rd.nextInt() % 40;
		if(i<0)i*=(-1);
		System.out.println(i);
		
		Aclass a1 = new Aclass();
		Aclass a2 = new Aclass();
		a1.copyobject(a2);
	}
	// public
}
