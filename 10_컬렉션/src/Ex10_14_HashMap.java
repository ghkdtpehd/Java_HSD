import java.util.HashMap;
import java.util.Scanner;

public class Ex10_14_HashMap {
	public static void main(String[] args) {
		HashMap<String,String> dic = new HashMap<String,String>();
		dic.put("pencil","연필");
		dic.put("sky", "하늘");
		dic.put("desk", "책상");
		dic.put("face", "얼굴");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("찾는 단어는? (q 입력시 종료)");
			String arg = sc.next();
			
			if(arg.equals("q")) {
				System.out.println("프로그랩을 종료합니다.");
				break;
			}else if(dic.get(arg)!=null) {
				System.out.println("뜻 : "+dic.get(arg));
			}else {
				System.out.println("잘못입력하셨습니다.");
			}
		}
	}
}