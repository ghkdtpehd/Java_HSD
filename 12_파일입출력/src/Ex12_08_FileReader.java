import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex12_08_FileReader {
	public static void main(String[] args) {

		try {
			FileWriter fw = new FileWriter("write.txt");
			fw.write("��ſ� �ڹټ���~");
			fw.close();
			
			FileReader fr = new FileReader("write.txt");
			int i;
			while( (i = fr.read()) != -1 ) {
				System.out.print((char)i);
			}
			
			fr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
