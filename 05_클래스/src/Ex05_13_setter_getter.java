class Person2{
	private String name;
	private int age;
	double height;
	
	void setName (String name) {
		this.name = name;
	}
	void setAge (int age) {
		this.age = age;
	}
	
	String getName() {
		return name;
	}
	int getAge() {
		return age;
	}
}
public class Ex05_13_setter_getter {
	public static void main(String[] args) {
		Person2 p = new Person2();
		p.height = 163;
		p.setAge(30);
		p.setName("ลยว๖");
		
		System.out.println(p.getAge());
		System.out.println(p.getName());
		System.out.println(p.height);
	}
}