import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex12_12_황세동 {
	public static void main(String[] args) throws IOException {
		String fileName = "C:\\sun\\word.txt";
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true));
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			System.out.println("1.단어입력 2.단어검색 3.종료");
			switch(sc.nextInt()) {
				case 1:
					System.out.print("단어/뜻 입력>>");
					
					String iWord = sc.next();
					
					if(iWord.indexOf("/") == -1) {
						System.out.println("단어의 형태가 올바르지 않습니다.");
						System.out.println("영단어 / 단어");
						continue;
					}
					
					bw.write(iWord);
					bw.newLine();
					
					break;
				case 2:
					System.out.print("검색 단어 입력>>");
					String word = sc.next();
					String line = "";
					boolean flag = false;
					
					while((line = br.readLine()) != null) {
						Scanner subSc = new Scanner(line);
						
						subSc.useDelimiter("/");
						String sWord = subSc.next();
						if(sWord.equals(word)) {
							flag = true;
							System.out.println("단어> "+sWord); 
							System.out.println("단어의 뜻> "+subSc.next()); 
						}
						subSc.close();
					}
					
					if(!flag) {
						System.out.println("찾는 단어 없음");
					}
					
					break;
				case 3:
					bw.close();
					br.close();
					sc.close();
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
					break;
			}
		}
	}
}