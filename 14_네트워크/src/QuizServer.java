import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class QuizServer {
	public static void main(String[] arg) throws IOException {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(9999);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		System.out.println("Server ready!!");
		
		Socket sc = null;
		try {
			sc = ss.accept();
			System.out.println("¡¢º”µ ");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		PrintWriter pw = null;
		BufferedReader br = null;
		try {
			pw = new PrintWriter(sc.getOutputStream(),true);
			br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String coutput,fromClinet,pbm;
		QuizBank bank = new QuizBank();
		coutput = bank.process(null); //ƒ˚¡Ó Ω√¿€ y/n
		pw.println(coutput);
		
		while((fromClinet = br.readLine()) != null) {
			pbm = bank.process(fromClinet);
			pw.println(pbm);
			if(pbm.equals("quit")) {
				br.close();
				pw.close();
			}
		}
	}
}
