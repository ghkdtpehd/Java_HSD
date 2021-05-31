import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex12_09_InputStreamReader {
	public static void main(String[] args) {

		System.out.print("입력:");
		
		InputStream is =  System.in; // adf, 가나다X
		
		InputStreamReader isr = new InputStreamReader(is);
		
		BufferedReader br = new BufferedReader(isr);
		
		//BufferedReader br = new BufferedReader(
		//						new InputStreamReader(System.in));
		
		try {
			String str = br.readLine();
			System.out.println("str:"+str);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
