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
		System.out.print("������ ���� �̸�: ");
		
		try {
			String fileName = br.readLine();
			FileWriter fw = new FileWriter(fileName); //���� �̸� �Է�
			
			BufferedWriter bw = new BufferedWriter(fw);
			
			System.out.println("���Ͽ� ������ ���� �Է�");
			
			String contents;
			
//			String contents = br.readLine();
//			bw.write(contents); //contents�� �Է��� ���� �Է�
			
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