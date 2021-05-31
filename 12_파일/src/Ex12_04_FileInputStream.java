import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex12_04_FileInputStream {
	public static void main(String[] args) throws FileNotFoundException,IOException{
		File f = new File("C:\\sun\\abc.txt");
		
		FileInputStream fis = new FileInputStream(f);
		FileOutputStream fos = new FileOutputStream("result.txt",true);
		//false 지우고 생성 (default값)
		//true 기존에 추가
		
		while(true) {
			int str = fis.read();
			if(str == -1)break;
			System.out.println(str+" : " +(char) str);
			
			fos.write(str);
		}
		fis.close();
		fos.close();
	}
}