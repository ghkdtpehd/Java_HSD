import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ex14_03_Client {
	public static void main(String[] args) {
		Socket cs = null;
		PrintWriter pw = null;
		
		try {
//			cs = new Socket("172.30.1.3",5555);
			cs = new Socket("172.30.1.47",5555);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("문자를 입력하세요.");
		String str = "";
		try {
			str = br.readLine();
			pw = new PrintWriter(cs.getOutputStream());
			
			pw.println(str);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}