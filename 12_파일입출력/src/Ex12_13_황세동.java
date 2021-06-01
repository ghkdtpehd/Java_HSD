import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Ex12_13_황세동 {
	public static void main(String[] args) throws IOException {
		//lineCount : 39 //줄수 구하기
		//ㅁㅁㅁ: 1
		//ㄴㄴㄴ: 2 >>단어별 빈도수 구하기
		BufferedReader br = new BufferedReader(new FileReader("lyrics.txt"));
		HashMap<String,Integer> words = new HashMap<String,Integer>();
		String line ="";
		int count = 0;
		
		//한줄 처리
		while((line = br.readLine())!=null) {
			Scanner sc = new Scanner(line);
			sc.useDelimiter(" ");
			
			//한줄 내의 단어 삽입,개수 증가
			while(sc.hasNext()) {
				String wordPart = sc.next();
				if(words.get(wordPart) != null) {
					words.put(wordPart, (words.get(wordPart)+1));
				}else {
					words.put(wordPart,1);
				}
			}
			//줄수 증가
			count++;
		}
		
		System.out.println("lineCount : "+ count);
		System.out.println();
		
		Iterator<String> it = words.keySet().iterator();
		while(it.hasNext()) {
			String part = it.next();
			System.out.println(part+" : "+words.get(part));
		}
	}
}