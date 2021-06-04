import java.io.IOException;
import java.net.ServerSocket;

public class Ex14_01_port {
	public static void main(String[] args) {
		ServerSocket ss = null;
		for(int i=0;i<65536;i++) {
			try {
				ss = new ServerSocket(i);
				
				ss.close();
			} catch (IOException e) {
//				e.printStackTrace();
				System.out.println(i+"번 포트는 사용중");
			}
		}
	}
}