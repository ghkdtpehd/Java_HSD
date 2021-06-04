import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex14_03_Server {
	public static void main(String[] args) {
		ServerSocket ss= null;
		Socket sc = null;
		try {
			ss = new ServerSocket(5555);
		} catch (IOException e) {
//			e.printStackTrace();
			System.err.println("�̹� 5555��Ʈ�� ������Դϴ�.");
			System.exit(1);
		}
		
		System.out.println("Server ready");
		
		try {
			sc = ss.accept();
			System.out.println("Ŭ���̾�Ʈ ����");
		} catch (IOException e) {
//			e.printStackTrace();
			System.err.println("accept ����");
			System.exit(1);
		}
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			String str = br.readLine();
			System.out.println("Ŭ���̾�Ʈ���� �Ѿ�� ������ "+str);
			br.close();
			sc.close();
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}