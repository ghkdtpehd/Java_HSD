import java.util.ArrayList;
import java.util.Scanner;

public class Ex10_03_ArrayList {
	public static void main(String[] args) {
		ArrayList<String> s = new ArrayList<String>();
		int size = s.size();
		System.out.println(size);
		System.out.println(s);
		
		s.add("윤아");
		s.add("수영");
		s.add("효연");
		s.add("수영");
		
		System.out.println(s.size());
		System.out.println(s.get(0));
		
		s.add(2,"태연");
		System.out.println(s);
		
		ArrayList<String> redvelvet = new ArrayList<String>();
		
		redvelvet.add("웬디");
		redvelvet.add("조이");
		System.out.println(s);
		
		s.addAll(redvelvet);
		System.out.println(s);
		System.out.println(s.size());
		
		s.remove(2);
		System.out.println(s);
		
		s.remove("수영");
		
		ArrayList<String> rm = new ArrayList<String>();
		rm.add("수영");

		s.removeAll(rm);
		System.out.println(s);
		
//		s.clear();
//		System.out.println(s);
		
		s.set(1, "써니");
		System.out.println(s);
		
		s.add(1,"수영");
		System.out.println(s);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름");
		
		String name = sc.next();
		
		if(-1!=s.indexOf(name)) {
			System.out.println("가입한 회원");
		}else {
			System.out.println("미가입 회원");
		}
		
//		for(int i=0;i<s.size();i++) {
//			if(s.get(i).equals(name)) {
//				System.out.println("가입한 회원");
//				break;
//			}else if(i==s.size()-1){
//				System.out.println("미가입 회원");
//				break;
//			}
//		}
		
		boolean b = s.contains("수영1");
		
	}
}