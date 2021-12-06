package days24;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpipServer01 {
	public static void main(String[] args) {

		// String serverIp = "192.168.0.91";
		// 서버의 정보 설정
		ServerSocket ss = null;
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");

		try {
			ss = new ServerSocket(7777);
			System.out.println(f.format(new Date()) + " 서버가 준비되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("서버설정에 실패했습니다. 프로그램을 종료합니다.");
			return;
		}

		try {
			// 서버가 클라이언트의 요청을 기다리기 시작하는 명령
			System.out.println(f.format(new Date()) + " 연결요청을 기다립니다.");
			Socket s = ss.accept();
			// 현재 명령에서 마치 sc.nextLine() 이 사용자의 화면 입력을 기다리듯이
			// 클라이언트의 연결요청을 기다립니다.
			// ServerSocket 이 클라이언트의 연결요청이 오면
			// 클라이언트 소켓과 서버에서 통신할 새로운 통신용 소켓을 연결합니다.
			// 이때 서버에서 사용하는 통신소켓이 클라이언트 정보를 이용하여 생성됩니다
			// 여기서 말하는 클라이언트 정보라는 것은 클라이언트의 아이피와 포트 번호, 출력 권한 등입니다.
			System.out.println(f.format(new Date()) + s.getInetAddress() + " 로부터 연결요청이 들어왔습니다.");
			// s.getInetAddress() : 클라이언트의 아이피 주소를 추출하는 메서드

			// 클라이언트에게 메세지를 전송(출력)할 수 있는 권한을 Socket s 로부터 얻어서
			// OutputStream 객체에 저장합니다.
			OutputStream out = s.getOutputStream();

			// 권한에 실제 출력 도구를 포함하려면 out 을 생성자로 전달한 DataOutputStream
			// 객체가 필요합니다.
			DataOutputStream dos = new DataOutputStream(out);
			// 최종 통신 출력 도구 : dos

			// dos 를 통해서 클라이언트에게 간단 메세지를 전송합니다.
			dos.writeUTF("[공지] 연결 성공~!!! 204호 00번 서버에 접속되셨습니다.");

			System.out.println(f.format(new Date()) + " 메세지를 전송했습니다.");
			dos.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
