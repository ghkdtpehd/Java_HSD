import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex12_10_InputStramReader {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		System.out.print("저장할 파일 이름: ");
		
		try {
			String fileName = br.readLine();
			FileWriter fw = new FileWriter(fileName); //파일 이름 입력
			
			BufferedWriter bw = new BufferedWriter(fw);
			
			System.out.println("파일에 저장할 내용 입력");
			
			String contents;
			
//			String contents = br.readLine();
//			bw.write(contents); //contents에 입력한 내용 입력
			
			while((contents = br.readLine())!=null) {
				bw.write(contents);
				bw.newLine();
			}
			
			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}