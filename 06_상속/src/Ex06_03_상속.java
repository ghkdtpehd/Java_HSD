class Person{
	private String name;
	private int age;
//	Person(){}
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	void display() {
		System.out.println("name: "+name);
		System.out.println("age: "+age);
	}
	
	void setName(String name) {
		this.name = name;
	}
	void setAge(int age) {
		this.age = age;
	}
}
class Student extends Person{
//	private String name;
//	private int age;
	private int kor;
	private int eng;
	
	Student(String name,int age,int kor, int eng){
		super(name,age);
//		super.setName(name);
//		super.setAge(age);
		this.kor = kor;
		this.eng = eng;
	}
	void display() {
		super.display();
		System.out.println("kor: "+kor);
		System.out.println("eng: "+eng);
	}
}
class Employee extends Person{
//	private String name; 
//	private int age;
	private String company;
	private String part;
	
	Employee(String name,int age,String company,String part){
		super(name,age);
//		super.setName(name);
//		super.setAge(age);
		this.company = company;
		this.part = part;
	}
	void display() {
		super.display();
		System.out.println("company: "+company);
		System.out.println("part: "+part);
	}
}
public class Ex06_03_상속 {
	public static void main(String[] args) {
		Person p = new Person("효연",22);
		Student s = new Student("윤아",23,89,72);
		Employee e = new Employee("백현",64,"삼성","연구부");
		
		p.display();
		System.out.println();
		s.display();
		System.out.println();
		e.display();
	}
}