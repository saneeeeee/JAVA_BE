package days19;

import javax.swing.JFrame;

class WindowTest extends JFrame{
	WindowTest(){
		setTitle("윈도우 테스트");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);  // 생성된 윈도우의 화면 표시
	}
}

public class SwingEx {

	public static void main(String[] args) {
		WindowTest win = new WindowTest();
		new WindowTest();
	}

}
