import java.util.ArrayList;
import java.util.Scanner;

public class Ex10_03_ArrayList {
	public static void main(String[] args) {
		ArrayList<String> s = new ArrayList<String>();
		int size = s.size();
		System.out.println(size);
		System.out.println(s);
		
		s.add("����");
		s.add("����");
		s.add("ȿ��");
		s.add("����");
		
		System.out.println(s.size());
		System.out.println(s.get(0));
		
		s.add(2,"�¿�");
		System.out.println(s);
		
		ArrayList<String> redvelvet = new ArrayList<String>();
		
		redvelvet.add("����");
		redvelvet.add("����");
		System.out.println(s);
		
		s.addAll(redvelvet);
		System.out.println(s);
		System.out.println(s.size());
		
		s.remove(2);
		System.out.println(s);
		
		s.remove("����");
		
		ArrayList<String> rm = new ArrayList<String>();
		rm.add("����");

		s.removeAll(rm);
		System.out.println(s);
		
//		s.clear();
//		System.out.println(s);
		
		s.set(1, "���");
		System.out.println(s);
		
		s.add(1,"����");
		System.out.println(s);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�̸�");
		
		String name = sc.next();
		
		if(-1!=s.indexOf(name)) {
			System.out.println("������ ȸ��");
		}else {
			System.out.println("�̰��� ȸ��");
		}
		
//		for(int i=0;i<s.size();i++) {
//			if(s.get(i).equals(name)) {
//				System.out.println("������ ȸ��");
//				break;
//			}else if(i==s.size()-1){
//				System.out.println("�̰��� ȸ��");
//				break;
//			}
//		}
		
		boolean b = s.contains("����1");
		
	}
}