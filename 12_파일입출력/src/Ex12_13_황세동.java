import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Ex12_13_Ȳ���� {
	public static void main(String[] args) throws IOException {
		//lineCount : 39 //�ټ� ���ϱ�
		//������: 1
		//������: 2 >>�ܾ �󵵼� ���ϱ�
		BufferedReader br = new BufferedReader(new FileReader("lyrics.txt"));
		HashMap<String,Integer> words = new HashMap<String,Integer>();
		String line ="";
		int count = 0;
		
		//���� ó��
		while((line = br.readLine())!=null) {
			Scanner sc = new Scanner(line);
			sc.useDelimiter(" ");
			
			//���� ���� �ܾ� ����,���� ����
			while(sc.hasNext()) {
				String wordPart = sc.next();
				if(words.get(wordPart) != null) {
					words.put(wordPart, (words.get(wordPart)+1));
				}else {
					words.put(wordPart,1);
				}
			}
			//�ټ� ����
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