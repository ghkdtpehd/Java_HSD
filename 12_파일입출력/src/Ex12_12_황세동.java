import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex12_12_Ȳ���� {
	public static void main(String[] args) throws IOException{
		String fileDir = "C:\\sun\\";
		String fileName = "word.txt";
		String fileFullDir = fileDir+fileName;
		
		File f = new File(fileDir);
		if(!f.isDirectory()) {
			f.mkdirs();
			System.out.println("���� ������");
		}
			
		
		Scanner sc = new Scanner(System.in);

		while(true) {
			
			System.out.println("1.�ܾ��Է� 2.�ܾ�˻� 3.����");
			switch(sc.nextInt()) {
				case 1:
					BufferedWriter bw = new BufferedWriter(new FileWriter(fileFullDir,true));
					System.out.print("�ܾ�/�� �Է�>>");
					
					String iWord = sc.next();
					
					if(iWord.indexOf("/") == -1) {
						System.out.println("�ܾ��� ���°� �ùٸ��� �ʽ��ϴ�.");
						System.out.println("���ܾ� / �ܾ�");
						continue;
					}
					
					bw.write(iWord);
					bw.newLine();
//					bw.flush();		//���� (8192)�뷮�� �ȵǾ� �Ѿ�� ���� �� ������ �Ѱܹ���
									//flush�� �����ʴ´ٸ� close�� �ᵵ �Ѿ��.
					
					bw.close();
					break;
				case 2:
					BufferedReader br;
					br = new BufferedReader(new FileReader(fileFullDir));
					System.out.print("�˻� �ܾ� �Է�>>");
					String word = sc.next();
					String line = "";
					boolean flag = false;
					
					while((line = br.readLine()) != null) {
						Scanner subSc = new Scanner(line);
						
						subSc.useDelimiter("/");
						String sWord = subSc.next();
						if(sWord.equalsIgnoreCase(word)) {
							flag = true;
							System.out.println("�ܾ�> "+sWord); 
							System.out.println("�ܾ��� ��> "+subSc.next()); 
						}
						subSc.close();
					}
					
					if(!flag) {
						System.out.println("ã�� �ܾ� ����");
					}
					
					br.close();
					break;
				case 3:
					sc.close();
					System.out.println("���α׷��� �����մϴ�.");
					System.exit(0);
					break;
			}
		}
	}
}