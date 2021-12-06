package days20;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//	액션 리스너를 사용하지 않고 버튼 자체에 존재하는 이벤트 메서드를 사용
class JButtonEvent extends JFrame{
	JLabel result;
	JButtonEvent() {
		Container con = getContentPane();

		ImageIcon korea = new ImageIcon("images/korea1.gif");
		ImageIcon germany = new ImageIcon("images/germany.gif");
		ImageIcon usa = new ImageIcon("images/usa.gif");
		//	이미지 3개 버튼은 1개
		
		JButton eventButton = new JButton(korea);
		eventButton.setRolloverIcon(usa);
		eventButton.setPressedIcon(germany);
		
		con.setLayout(new FlowLayout());
		con.add(eventButton);
		
		setTitle("버튼 자체 이벤트 처리 실습");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
public class Swing05 {

	public static void main(String[] args) {
		new JButtonEvent();
	}

}
