import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class QuizClient {
	public static void main(String[] arg) throws IOException {
		Socket sc = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		BufferedReader cinput = null;
		try {
			sc = new Socket("localhost",9999);
//			sc = new Socket("172.30.1.47",9999);
			
			pw = new PrintWriter(sc.getOutputStream(),true);
			br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			cinput = new BufferedReader(new InputStreamReader(System.in));
		} catch (UnknownHostException e) {
//			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
//			e.printStackTrace();
			System.exit(1);
		}
		
		String fromServer,fromClinet;
		while((fromServer = br.readLine()) != null) {
			System.out.println("서버:"+fromServer);
			
			if(fromServer.equals("quit")) {
				break;
			}
			
			fromClinet = cinput.readLine();
			System.out.println("클라이언트: "+fromClinet);
			pw.println(fromClinet);
		}
		cinput.close();
		br.close();
		sc.close();
		pw.close();
	}
}
