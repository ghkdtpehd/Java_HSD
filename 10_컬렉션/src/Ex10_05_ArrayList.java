import java.util.ArrayList;
import java.util.Scanner;

class Person{
	private String id;
	private String pw;
	
	public Person(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String toString() {
		return id+"/"+pw;
	}
}
public class Ex10_05_ArrayList {
	public static void main(String[] args) {
		Person p1 = new Person("Kim","1234");
		Person p2 = new Person("park","3333");
		Person p3 = new Person("jung","7777");
		
		ArrayList<Person> list = new ArrayList<Person>();
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		System.out.println(list);
		
		ArrayList<Person> list2 = new ArrayList<Person>();
		Person[] p = {p1,p2,p3};
		for(int i=0;i<p.length;i++) {
			list2.add(p[i]);
		}
		System.out.println("list2 :"+list2);
		
		ArrayList<Person> list3 = new ArrayList<Person>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("아이디:");
			String id =sc.next();
			System.out.print("비번:");
			String pw =sc.next();
			
			Person per = new Person(id,pw);
			list3.add(per);
			
			System.out.print("계속?");
			String retry=sc.next();
			
			if(retry.equals("n")) {
				break;
			}
		}
		System.out.println(list3);
		for(int i=0;i<list3.size();i++) {
			Person pp = list3.get(i);
			System.out.println(pp);
			System.out.println(pp.getId());
		}
	}
}