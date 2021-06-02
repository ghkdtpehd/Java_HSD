import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex12_12_황세동 {
	public static void main(String[] args) throws IOException{
		String fileDir = "C:\\sun\\";
		String fileName = "word.txt";
		String fileFullDir = fileDir+fileName;
		
		File f = new File(fileDir);
		if(!f.isDirectory()) {
			f.mkdirs();
			System.out.println("파일 생성됨");
		}
			
		
		Scanner sc = new Scanner(System.in);

		while(true) {
			
			System.out.println("1.단어입력 2.단어검색 3.종료");
			switch(sc.nextInt()) {
				case 1:
					BufferedWriter bw = new BufferedWriter(new FileWriter(fileFullDir,true));
					System.out.print("단어/뜻 입력>>");
					
					String iWord = sc.next();
					
					if(iWord.indexOf("/") == -1) {
						System.out.println("단어의 형태가 올바르지 않습니다.");
						System.out.println("영단어 / 단어");
						continue;
					}
					
					bw.write(iWord);
					bw.newLine();
//					bw.flush();		//일정 (8192)용량이 안되어 넘어가지 못할 때 강제로 넘겨버림
									//flush를 쓰지않는다면 close를 써도 넘어간다.
					
					bw.close();
					break;
				case 2:
					BufferedReader br;
					br = new BufferedReader(new FileReader(fileFullDir));
					System.out.print("검색 단어 입력>>");
					String word = sc.next();
					String line = "";
					boolean flag = false;
					
					while((line = br.readLine()) != null) {
						Scanner subSc = new Scanner(line);
						
						subSc.useDelimiter("/");
						String sWord = subSc.next();
						if(sWord.equalsIgnoreCase(word)) {
							flag = true;
							System.out.println("단어> "+sWord); 
							System.out.println("단어의 뜻> "+subSc.next()); 
						}
						subSc.close();
					}
					
					if(!flag) {
						System.out.println("찾는 단어 없음");
					}
					
					br.close();
					break;
				case 3:
					sc.close();
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
					break;
			}
		}
	}
}