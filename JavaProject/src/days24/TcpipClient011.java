
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpipClient011 {

	public static void main(String[] args) {
		String serverIp = "192.168.0.70";
		
		try {
			Socket s = new Socket(serverIp, 7777);
			//	Socket : Ŭ���̾�Ʈ�� ������ ��û�� ����Ʈ����
			//	serverIp : Ŭ���̾�Ʈ�� ��û�� ������ ������ �ּ�
			//	7777 : �������� ������ ������ �׷��ȣ
			//	�ش� �����ǿ� ��Ʈ��ȣ�� ������ ������ ��Ʈ��ũ �� �־ ������ �����ϸ�
			//	�Ʒ� ������ ����. �����ϸ� catch ���� ����
			
			//	���Ͽ��� �Է� ��Ʈ���� ���޹޾� ����� ������ ���
			InputStream is = s.getInputStream();
			
			//	InputStream �� �ܼ� �ƽ�Ű�ڵ� ������� �����ڿ� ���� ����Ŭ���̾�Ʈ ��ſ�
			//	��밡���� ��Ʈ���� �����մϴ�
			DataInputStream dis = new DataInputStream(is);
			
			//	������ ��û�� ������ ���� ���޵� �޼����� �����մϴ�.
			String m = dis.readUTF();
			
			//	�������� ���� ���� �����͸� ����մϴ�
			System.out.println("���� �޽��� : "+m);
			System.out.println("������ �����մϴ�.");
			//	��Ʈ���� ������ �ݽ��ϴ�
			dis.close();
			s.close();
			System.out.println("������ ����Ǿ����ϴ�.");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
