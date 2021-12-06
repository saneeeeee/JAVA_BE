package days21;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class Calendars extends JFrame  implements ActionListener{
	
	static int year=0;
	static int month=0;
	static JTextField [] jt = new JTextField[42];
	
	JTextField y;
	JTextField m;
	
	Calendars(){

		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		
		jp1.setLayout(new GridLayout(1,7));
		jp2.setLayout(new GridLayout(6,7));
		jp3.setLayout(new FlowLayout());
		
		jp1.add(new JButton("일")).setForeground(Color.RED);
		jp1.add(new JButton("월"));
		jp1.add(new JButton("화"));
		jp1.add(new JButton("수"));
		jp1.add(new JButton("목"));
		jp1.add(new JButton("금"));
		jp1.add(new JButton("토")).setForeground(Color.BLUE);
		
		Font f = new Font("굴림", Font.BOLD, 20);
		
		for( int i = 0; i<42; i++) {
			jt[i] = new JTextField();
			jt[i].setFont(f);
			jt[i].setHorizontalAlignment(SwingConstants.RIGHT);
			jt[i].setEditable(false);
			jt[i].setBackground(Color.WHITE);
			if(i%7==6) jt[i].setForeground(Color.BLUE);
			else if(i%7==0) jt[i].setForeground(Color.RED);
			else jt[i].setForeground(Color.BLACK);
			jp2.add(jt[i]);
		}
		
		y =new JTextField(6);
		y.setFont(f);
		y.setHorizontalAlignment(SwingConstants.CENTER);
		//y.setEditable(false);
		y.setBackground(Color.WHITE);
		
		m =new JTextField(3);
		m.setFont(f);
		m.setHorizontalAlignment(SwingConstants.CENTER);
		//m.setEditable(false);
		m.setBackground(Color.WHITE);
		
		Calendar today = Calendar.getInstance();
		y.setText(String.valueOf(today.get(Calendar.YEAR)));
		m.setText(String.valueOf( today.get(Calendar.MONTH)+1 ));
		
		JButton b = new JButton("확인");
		JButton b1 = new JButton("이전달");
		JButton b2 = new JButton("다음달");
		
		b.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		jp3.add(b1);	
		jp3.add(y);   
		jp3.add(new JLabel("년 "));
		jp3.add(m);	
		jp3.add(new JLabel("월 "));
		jp3.add(b);		
		jp3.add(b2);
		
		con.add(jp1, BorderLayout.NORTH);
		con.add(jp2,BorderLayout.CENTER);
		con.add(jp3,BorderLayout.SOUTH);

		setTitle("스윙 캘린더");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		year = Integer.parseInt( y.getText() );
		month = Integer.parseInt( m.getText() );
		drawCalendar();
	}
	@Override
	public void actionPerformed(ActionEvent e) {	
		// 버튼에 따라서  year  변수와 month 변수 계산 하고  drawCalender() 호출
		String s = e.getActionCommand();
		switch(s) {
			case "이전달":
				if( month==1 ) {
					year--; month=12;
				}else {
					month--;
				}
				break;
			case "다음달":
				if( month==12 ) {
					year++; month=1;
				}else {
					month++;
				}
				break;
			case "확인":
				int tempy = Integer.parseInt(y.getText());
				int tempm = Integer.parseInt(m.getText());
				
				if(tempy>=1 && tempy<=2200)
					year = Integer.parseInt(y.getText());
				else
					return;
				
				if(tempm>=1 && tempm<=12)
					month=Integer.parseInt(m.getText());
				else 
					return;
		}
		
		y.setText( String.valueOf(year) );
		m.setText( String.valueOf(month) );
		
		for(int i=0; i<jt.length; i++) jt[i].setText("");
		drawCalendar();
	}
	
	private static void drawCalendar() {
		// 해당 년월의 달력을 화면에 표시
		Calendar sDay = Calendar.getInstance();
		Calendar eDay = Calendar.getInstance(); 
		
		sDay.set(year, month-1, 1);  // 오늘 날짜 월의 1일로
        eDay.set(year, month, 1);
        eDay.add(Calendar.DATE, -1);  // 오늘 날짜 월의 말일로... 
        
        int START_WEEK = sDay.get(Calendar.DAY_OF_WEEK); 
        // sDay 의 요일 계산
        
        // TextField 가 다 비워져 있는 상태에서 시작
        // 1일자의 요일(1,2,3,4..)-(START_WEEK-1) 의 TextField 부터 날짜 표시 시작
        // 이전 칸들은 비워둔채로 시작
        // 각 TextField에 sDay 의 값들을 표시 -> 일짜만 표시 
        // 한번 반복마다 날짜는 1일씩 늘어납니다.
        // eDay 보다 sDay 가 작거나 같을때까지 반복
        for(int i=START_WEEK-1; sDay.before(eDay)||sDay.equals(eDay); 
        												sDay.add(Calendar.DATE, 1) ){
        	int day = sDay.get(Calendar.DATE);
        	jt[i++].setText( String.valueOf(day) );
        }
	}

}

public class Swing14 {
	public static void main(String[] args) {
		new Calendars();
	}
}
