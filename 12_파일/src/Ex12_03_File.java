import java.io.File;
import java.io.IOException;

public class Ex12_03_File {
	public static void main(String[] args) {
		File f1 = new File("A");
		File f2 = new File("B");
		File f3 = new File("C");
		File f4 = new File(f1,"aa.txt");
		
		boolean b =f1.exists();
		System.out.println("b: "+b);
		
		if(f1.exists()) {
			f1.renameTo(f2);
		}else {
			f1.mkdir();
			System.out.println("���� ����");
			
			try {
				f4.createNewFile();
				System.out.println("���� ����");
			}catch(IOException e){
				System.out.println(e.getMessage());
			}
		}
		
		if(f3.exists()) {
			boolean b2 = f3.delete();
			System.out.println("b2 : "+b2);
			System.out.println("�����Ϸ�");
		}
			
	}
}