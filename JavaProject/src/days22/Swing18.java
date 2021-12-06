package days22;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

class JComboBoxTest extends JFrame implements ItemListener{
	JLabel jl;
	ImageIcon ii;
	
	JComboBoxTest(){
		JComboBox<String> jcb = new JComboBox();	
		//	콤보상자는 목록으로 들어갈 데이터가 정해지지 않은상태. 서로 다른 자료형도 입력 가능하지만
		// 실제 사용시점에서 목롥으로 사용할 데이터 형식을 결정함
		//	(String, double, int, 등 객체도 사용가능)
		//	<> 에 자료형을 써넣어서 현재 사용할 콤보상자 목록의 데이터 형식을 결정합니다.
		jcb.addItem("banana");	//	.addItem()	콤보상자의 목록 추가
		jcb.addItem("apple");
		jcb.addItem("pear");
		jcb.addItem("cherry");
		jcb.addItem("grape");
		//	jcb.addItem(123);
		//	jcb.addItem(123.456);
		//	jcb.addItem('A');
		
		Font f = new Font("굴림", Font.BOLD, 20);
		jcb.setFont(f);
		
		ii = new ImageIcon("images/banana.jpg");
		jl = new JLabel(ii);	//	라벨의 이미지는 최초 상태 바나나로...
		
		jcb.addItemListener(this);
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		con.add(jcb);
		con.add(jl);
		
		setTitle("");
		setSize(500, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		String jcb1 = (String)e.getItem();		//	상태가 변한 컨트롤의 현재 선택값 추출
		ImageIcon ni = new ImageIcon("images/"+jcb1+".jpg");
		jl.setIcon(ni);	//	라벨에 setIcon 으로 이미지 아이콘을 교체합니다.
	}
	
}
public class Swing18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JComboBoxTest();
	}

}

