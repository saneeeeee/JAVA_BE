package days20;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class ButtonTest2 extends JFrame {
	public ButtonTest2() {
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		JButton[] jb = new JButton[16];
		String[] jb_l = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "x", "=", "0", "C", "÷" };
		for (int i = 0; i < jb.length; i++) {
			jb[i] = new JButton(jb_l[i]);
			con.add(jb[i]);
		}
		
		setTitle("버튼 컴퍼넌트 테스트2");
		setSize(220,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class Swing02 {

	public static void main(String[] args) {
		new ButtonTest2();
	}

}
