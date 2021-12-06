package days20;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class GridFruts extends JFrame implements ActionListener {
	JLabel result;
	String[] i_name = { "apple.jpg", "persimmon.jpg", "pear.jpg", "banana.jpg", "cherry.jpg" };
	String[] f_name = { "사과", "감", "배", "바나나", "체리" };

	public GridFruts() {
		Container con = getContentPane();
		con.setLayout(new GridLayout(3, 2));

		ImageIcon[] ii = new ImageIcon[5];
		JButton[] jb = new JButton[5];

		for (int i = 0; i < ii.length; i++) {
			ii[i] = new ImageIcon("images/" + i_name[i]);
			jb[i] = new JButton(ii[i]);	// jb[i] = new JButton(f_name[i], ii[i]);
			jb[i].setActionCommand(f_name[i]);
			jb[i].addActionListener(this);
			con.add(jb[i]);
		}

		result = new JLabel("");
		con.add(result);

		setTitle("GridFruts");
		setSize(360, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		result.setText(e.getActionCommand() + "를/을 선택하였습니다");
	}
}

public class Swing09 {

	public static void main(String[] args) {
		new GridFruts();
	}

}
