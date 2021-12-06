package days22;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class Resume extends JFrame implements ActionListener {
	JPanel[] jp;
	JPanel[] jp_r;
	JLabel[] jl_l;
	JTextField jtf_name;
	JTextField[] jtf_phone2;
	JRadioButton[] jrb_gender;
	ButtonGroup bg;
	JCheckBox[] jckb_h;
	JComboBox<String> jcb_phone1;
	JComboBox<String> jcb_city;;

	String[] l = { " 성         명 : ", " 성         별 : ", " 취         미 : ", " 전 화 번 호 : ", " 거 주 지 역 : " };
	String[] g = { "남성", "여성" };
	String[] h = { "스포츠", "영화", "독서", "기타" };
	String[] phone1 = { "010", "011", "016", "019" };
	String[] c = { "서울", "경기", "충청", "전라", "경상", "제주" };

	Resume() {
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		Font f = new Font("굴림", Font.BOLD, 20);

		jp = new JPanel[2];
		jp_r = new JPanel[6];
		jl_l = new JLabel[5];
		jp[0] = new JPanel();
		jp[1] = new JPanel();
		jrb_gender = new JRadioButton[2];
		jtf_name = new JTextField(10);
		jtf_phone2 = new JTextField[2];
		bg = new ButtonGroup();
		jckb_h = new JCheckBox[4];
		jcb_phone1 = new JComboBox();
		jcb_city = new JComboBox();
		JLabel bar1 = new JLabel(" - ");
		JLabel bar2 = new JLabel(" - ");

		for (int i = 0; i < 6; i++) {

			jp_r[i] = new JPanel();
			jp_r[i].setLayout(new FlowLayout(FlowLayout.LEFT, 0, 15));
			jp[1].add(jp_r[i]);
		}
		for (int i = 0; i < 6; i++) {

			if (i < 2) {
				jrb_gender[i] = new JRadioButton(g[i]);
				jrb_gender[i].setFont(f);
				bg.add(jrb_gender[i]);
				jp_r[1].add(jrb_gender[i]);

				jtf_phone2[i] = new JTextField(4);
				jtf_phone2[i].setFont(f);
				;
			}

			if (i < 4) {
				jckb_h[i] = new JCheckBox(h[i]);
				jckb_h[i].setFont(f);
				jp_r[2].add(jckb_h[i]);

				jcb_phone1.addItem(phone1[i]);
			}
			if (i < 5) {
				jl_l[i] = new JLabel(l[i]);
				jp[0].add(jl_l[i]);
				jl_l[i].setFont(f);
			}

			jcb_city.addItem(c[i]);
		}

		jp[0].setLayout(new GridLayout(6, 1));
		jp[1].setLayout(new GridLayout(6, 1));

		jp_r[0].add(jtf_name);
		jtf_name.setFont(f);

		jp_r[3].add(jcb_phone1);
		jcb_phone1.setFont(f);
		bar1.setFont(f);
		bar2.setFont(f);
		jp_r[3].add(bar1);
		jp_r[3].add(jtf_phone2[0]);
		jp_r[3].add(bar2);
		jp_r[3].add(jtf_phone2[1]);

		jp_r[4].add(jcb_city);
		jcb_city.setFont(f);
		
		JButton submit = new JButton("확인");
		submit.setFont(f);
		jp_r[5].add(submit);
		jp_r[5].setLayout(new FlowLayout(FlowLayout.CENTER,0,15));

		submit.addActionListener(this);
		
		con.add(jp[0], BorderLayout.WEST);
		con.add(jp[1], BorderLayout.CENTER);
		setTitle("");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String result = "";
		
		result = result + "성명 : "+ jtf_name.getText() ;
		
		result = result + "\n성별 : ";
		if(jrb_gender[0].isSelected())result = result + jrb_gender[0].getActionCommand() ;
		else if(jrb_gender[1].isSelected())result = result + jrb_gender[1].getActionCommand() ;
		
		result = result + "\n취미 : ";
		if(jckb_h[0].isSelected())result=result + jckb_h[0].getActionCommand()+" ";
		if(jckb_h[1].isSelected())result=result + jckb_h[1].getActionCommand()+" ";
		if(jckb_h[2].isSelected())result=result + jckb_h[2].getActionCommand()+" ";
		if(jckb_h[3].isSelected())result=result + jckb_h[3].getActionCommand()+" ";
		
		result = result + "\n전화번호 : "+jcb_phone1.getSelectedItem()+"-"+jtf_phone2[0].getText()+"-"+jtf_phone2[1].getText() ;
		
		result = result + "\n거주지역 : "+jcb_city.getSelectedItem()+"\n" ;
				
		System.out.println(result);
	}
}

public class Swing19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Resume();
	}

}
