import java.util.HashMap;
import java.util.Scanner;

public class Ex10_14_HashMap {
	public static void main(String[] args) {
		HashMap<String,String> dic = new HashMap<String,String>();
		dic.put("pencil","����");
		dic.put("sky", "�ϴ�");
		dic.put("desk", "å��");
		dic.put("face", "��");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("ã�� �ܾ��? (q �Է½� ����)");
			String arg = sc.next();
			
			if(arg.equals("q")) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}else if(dic.get(arg)!=null) {
				System.out.println("�� : "+dic.get(arg));
			}else {
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}
		}
	}
}