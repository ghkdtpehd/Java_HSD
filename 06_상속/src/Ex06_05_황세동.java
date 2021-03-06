class Member {
	private String name;
	private int age;

	Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	void display() {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
	}
}

class Worker extends Member {
	private String company;
	private String part;

	Worker(String name, int age, String company, String part) {
		super(name, age);
		this.company = company;
		this.part = part;
	}

	void display() {
		super.display();
		System.out.println("company : " + company);
		System.out.println("part : " + part);
	}
}

class Teacher extends Worker {
	private String subject;

	Teacher(String name, int age, String company, String part, String subject) {
		super(name, age, company, part);
		this.subject = subject;
	}

	void display() {
		super.display();
		System.out.println("subject : " + subject);
	}
}

public class Ex06_05_황세동 {
	public static void main(String[] args) {
		// 전부 상속후 display 메서드를 이용하여 출력
		Member m = new Member("성시경", 30);
		Worker w = new Worker("세경", 40, "중앙", "홍보부");
		Teacher t = new Teacher("혜리", 50, "현대고등학교", "생활지도부", "음악");
		
		m.display();
		System.out.println();
		w.display();
		System.out.println();
		t.display();
	}
}