import java.net.UnknownHostException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class Sender extends Thread {
	Socket socket = null;
	DataOutputStream out;
	String name;

	Sender(Socket s) {
		this.socket = s;
		try {
			out = new DataOutputStream(socket.getOutputStream());
			name = "[" + socket.getInetAddress() + ":" + socket.getPort() + "]";
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		while(out!=null) {
			try {
				out.writeUTF(name+sc.nextLine());
				//	화면에 입력한 내용을 만들어둔 말머리와 함께 전송
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

class Receiver extends Thread {
	Socket socket = null;
	DataInputStream in;

	Receiver(Socket s) {
		this.socket = s;
		try {
			in = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while(in!=null) {
			try {
				System.out.println(in.readUTF());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

public class TcpipClient031 {

	public static void main(String[] args) {
		String serverIp = "192.168.0.91";
		try {
			Socket s = new Socket(serverIp,7777);
			System.out.println("서버에 연결되었습니다.");
			Sender sender = new Sender(s);
			Receiver receiver = new Receiver(s);
			sender.start();
			receiver.start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
