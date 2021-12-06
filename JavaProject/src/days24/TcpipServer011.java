import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpipServer011 {
	public static void main(String[] args) {

		// String serverIp = "192.168.0.91";
		// ������ ���� ����
		ServerSocket ss = null;
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");

		try {
			ss = new ServerSocket(7777);
			System.out.println(f.format(new Date()) + " ������ �غ�Ǿ����ϴ�.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("���������� �����߽��ϴ�. ���α׷��� �����մϴ�.");
			return;
		}

		try {
			// ������ Ŭ���̾�Ʈ�� ��û�� ��ٸ��� �����ϴ� ���
			System.out.println(f.format(new Date()) + " �����û�� ��ٸ��ϴ�.");
			Socket s = ss.accept();
			// ���� ��ɿ��� ��ġ sc.nextLine() �� ������� ȭ�� �Է��� ��ٸ�����
			// Ŭ���̾�Ʈ�� �����û�� ��ٸ��ϴ�.
			// ServerSocket �� Ŭ���̾�Ʈ�� �����û�� ����
			// Ŭ���̾�Ʈ ���ϰ� �������� ����� ���ο� ��ſ� ������ �����մϴ�.
			// �̶� �������� ����ϴ� ��ż����� Ŭ���̾�Ʈ ������ �̿��Ͽ� �����˴ϴ�
			// ���⼭ ���ϴ� Ŭ���̾�Ʈ ������� ���� Ŭ���̾�Ʈ�� �����ǿ� ��Ʈ ��ȣ, ��� ���� ���Դϴ�.
			System.out.println(f.format(new Date()) + s.getInetAddress() + " �κ��� �����û�� ���Խ��ϴ�.");
			// s.getInetAddress() : Ŭ���̾�Ʈ�� ������ �ּҸ� �����ϴ� �޼���

			// Ŭ���̾�Ʈ���� �޼����� ����(���)�� �� �ִ� ������ Socket s �κ��� ��
			// OutputStream ��ü�� �����մϴ�.
			OutputStream out = s.getOutputStream();

			// ���ѿ� ���� ��� ������ �����Ϸ��� out �� �����ڷ� ������ DataOutputStream
			// ��ü�� �ʿ��մϴ�.
			DataOutputStream dos = new DataOutputStream(out);
			// ���� ��� ��� ���� : dos

			// dos �� ���ؼ� Ŭ���̾�Ʈ���� ���� �޼����� �����մϴ�.
			dos.writeUTF("[����] ���� ����~!!! 204ȣ 00�� ������ ���ӵǼ̽��ϴ�.");

			System.out.println(f.format(new Date()) + " �޼����� �����߽��ϴ�.");
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
