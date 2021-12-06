package days20;

import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import days16.test;

class TextFieldEx extends JFrame implements ActionListener {
	JTextField t1;
	JTextField t2;

	TextFieldEx() {
		Container con = getContentPane();
		con.setLayout(new FlowLayout());

		t1 = new JTextField(15);
		t2 = new JTextField(15);
		JButton b1 = new JButton(">");
		JButton b2 = new JButton("<");
		b1.addActionListener(this);
		b2.addActionListener(this);

		con.add(t1);
		con.add(b1);
		con.add(b2);
		con.add(t2);

		setTitle("텍스트 필드 예제");
		setSize(500, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String op = e.getActionCommand();
		if (t1.getText().equals("") && t2.getText().equals("")) {
			System.out.println("TextFields are Empty");
		} else {
			if (op.equals("<")) {
				// String temp = t1.getText();
				if (!t2.getText().equals("")) {
					t1.setText(t2.getText());
					t2.setText("");
				} else
					System.out.println("t2 is Empty");
			} else if (op.equals(">")) {
				// String temp = t2.getText();
				if (!t1.getText().equals("")) {
					t2.setText(t1.getText());
					t1.setText("");
				} else
					System.out.println("t1 is Empty");
			}
		}
	}
}

public class Swing11 {

	public static void main(String[] args) {
		new TextFieldEx();
	}

}
