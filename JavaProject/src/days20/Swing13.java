package days20;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class Calculator extends JFrame implements ActionListener {
	JTextField jtf;
	//String[] jb_l = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "x", "C", "0", "=", "÷" };

	Calculator() {
		Container con = getContentPane();
		con.setLayout(new GridLayout(5, 1));
		Font f = new Font("굴림",Font.BOLD,20);
		jtf = new JTextField(15);
		jtf.setFont(f);
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		
		p1.setLayout(new FlowLayout());
		jtf.setText("0");
		jtf.setHorizontalAlignment(SwingConstants.RIGHT);
		jtf.setEditable(false);
		p1.add(jtf);
		
		p2.setLayout(new GridLayout(1,4));
		p3.setLayout(new GridLayout(1,4));
		p4.setLayout(new GridLayout(1,4));
		p5.setLayout(new GridLayout(1,4));
		
		JButton b7 = new JButton("7");	b7.setFont(f);	b7.addActionListener(this);
		JButton b8 = new JButton("8");	b8.setFont(f);	b8.addActionListener(this);
		JButton b9 = new JButton("9");	b9.setFont(f);	b9.addActionListener(this);
		JButton bp = new JButton("+");	bp.setFont(f);	bp.addActionListener(this);
		p2.add(b7);
		p2.add(b8);
		p2.add(b9);
		p2.add(bp);
		
		JButton b4 = new JButton("4");	b4.setFont(f);	b4.addActionListener(this);
		JButton b5 = new JButton("5");	b5.setFont(f);	b5.addActionListener(this);
		JButton b6 = new JButton("6");	b6.setFont(f);	b6.addActionListener(this);
		JButton bm = new JButton("-");	bm.setFont(f);	bm.addActionListener(this);
		p3.add(b4);
		p3.add(b5);
		p3.add(b6);
		p3.add(bm);
		
		JButton b1 = new JButton("1");	b1.setFont(f);	b1.addActionListener(this);
		JButton b2 = new JButton("2");	b2.setFont(f);	b2.addActionListener(this);
		JButton b3 = new JButton("3");	b3.setFont(f);	b3.addActionListener(this);
		JButton bx = new JButton("x");	bx.setFont(f);	bx.addActionListener(this);
		p4.add(b1);
		p4.add(b2);
		p4.add(b3);
		p4.add(bx);
		
		JButton bc = new JButton("C");	bc.setFont(f);	bc.addActionListener(this);
		JButton b0 = new JButton("0");	b0.setFont(f);	b0.addActionListener(this);
		JButton be = new JButton("=");	be.setFont(f);	be.addActionListener(this);
		JButton bd = new JButton("÷");	bd.setFont(f);	bd.addActionListener(this);
		p5.add(bc);
		p5.add(b0);
		p5.add(be);
		p5.add(bd);
		
		/*
		JButton[] jb = new JButton[16];
		JPanel[] p = new JPanel[4];

		//p[0] = new JPanel();
		//p[0].setLayout(new FlowLayout());
		con.add(jtf);
		//con.add(p[0]);

		int k = 0;
		for (int i = 0; i < 4; i++) {
			p[i] = new JPanel();
			p[i].setLayout(new GridLayout(1, 4));
			for (int j = 0; j < 4; j++) {
				jb[k] = new JButton(jb_l[k]);
				jb[k].addActionListener(this);
				jb[k].setFont(f);
				p[i].add(jb[k++]);
			}
			con.add(p[i]);
		}
		 */
		con.add(p1);
		con.add(p2);
		con.add(p3);
		con.add(p4);
		con.add(p5);
		
		setTitle("계산기");
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String js = jtf.getText();
		String s = e.getActionCommand();
		System.out.println(s);
		
		//if(js.indexOf(js.length()-1)<'0' && js.indexOf(js.length()-1)>'9')
		switch(s) {
		case "C":
			jtf.setText("0");
			break;
		case "+":
			if(js.equals("0"))jtf.setText("0");
			else if(js.indexOf(js.length()-1)>='0' && js.indexOf(js.length()-1)<='9') jtf.setText(jtf.getText()+s);
			break;
		case "-":
			if(js.equals("0"))jtf.setText("0");
			else jtf.setText(jtf.getText()+s);
			break;
		case "x":
			if(js.equals("0"))jtf.setText("0");
			else jtf.setText(jtf.getText()+s);
			break;
		case "÷":
			if(js.equals("0"))jtf.setText("0");
			else jtf.setText(jtf.getText()+s);
			break;
		default:
			if(js.equals("0"))jtf.setText(s);
			else jtf.setText(jtf.getText()+s);
			break;
		}
		
		
		
		
	}
}

public class Swing13 {

	public static void main(String[] args) {
		new Calculator();
	}

}
