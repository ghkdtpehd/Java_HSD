import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex12_06_BufferedStream {
	public static void main(String[] args) {

		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		FileInputStream fis = null;
		BufferedInputStream bis = null;

		try {
			fos = new FileOutputStream("test.txt");
			bos = new BufferedOutputStream(fos,5);

			for(int i=1;i<9;i++) { // 1 2 3 4 5 6 7 8
				bos.write(i+48); 
			}
			
			bos.flush(); // 1~8까지 test.txt에 출력
			
			// 1~5 출력
			
			fis = new FileInputStream("test.txt");
			bis = new BufferedInputStream(fis);
			int c;
			while( (c = bis.read()) != -1  ) {
				System.out.println((char)c);
			}
			
		}catch(FileNotFoundException e) {

		}catch (IOException e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(bos!=null)
					bos.close();
				if(bis!=null)
					bis.close();
			}catch(IOException e) {

			}
		}

	}
}

//'0':48
//'1':49
//'2':50












