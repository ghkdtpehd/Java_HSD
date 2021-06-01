import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex12_12_Ȳ���� {
	public static void main(String[] args) throws IOException {
		String fileName = "C:\\sun\\word.txt";
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true));
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			System.out.println("1.�ܾ��Է� 2.�ܾ�˻� 3.����");
			switch(sc.nextInt()) {
				case 1:
					System.out.print("�ܾ�/�� �Է�>>");
					
					String iWord = sc.next();
					
					if(iWord.indexOf("/") == -1) {
						System.out.println("�ܾ��� ���°� �ùٸ��� �ʽ��ϴ�.");
						System.out.println("���ܾ� / �ܾ�");
						continue;
					}
					
					bw.write(iWord);
					bw.newLine();
					
					break;
				case 2:
					System.out.print("�˻� �ܾ� �Է�>>");
					String word = sc.next();
					String line = "";
					boolean flag = false;
					
					while((line = br.readLine()) != null) {
						Scanner subSc = new Scanner(line);
						
						subSc.useDelimiter("/");
						String sWord = subSc.next();
						if(sWord.equals(word)) {
							flag = true;
							System.out.println("�ܾ�> "+sWord); 
							System.out.println("�ܾ��� ��> "+subSc.next()); 
						}
						subSc.close();
					}
					
					if(!flag) {
						System.out.println("ã�� �ܾ� ����");
					}
					
					break;
				case 3:
					bw.close();
					br.close();
					sc.close();
					System.out.println("���α׷��� �����մϴ�.");
					System.exit(0);
					break;
			}
		}
	}
}