package days16;

public class ArrayMethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = new int[9][];
		input(a);
		prn(a);
	}

	public static void input(int[][] a) {
		int k = 1;
		for (int i = 0; i < a.length; i++) {
			if (i < 5)
				a[i] = new int[i + 1];
			else
				a[i] = new int[9 - i];
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = k++;
				// System.out.printf("%d\t",a[i][j]);
			}
			// System.out.println();
		}

	}

	public static void prn(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf("%d\t", a[i][j]);
			}
			System.out.println();
		}
	}

}
