class Student{
	private int hakbun;
	private String name;
	
	Student(int hakbun,String name){
		this.hakbun = hakbun;
		this.name = name;
	}
	
	void sethakbun (int x) {
		this.hakbun = x;
	}
	void setname (String x) {
		this.name = x;
	}
	
	int getHakbun () {
		return hakbun;
	}
	String getName (String x) {
		return name;
	}
	
	public boolean equals(Object obj) {
		Student s = (Student) obj;
		
		if(obj instanceof Student) {
			return this.hakbun == s.hakbun && this.name.equals(s.name);
		}else {
			return this == obj;
		}
	}
}

public class Ex09_01_toString {
	public static void main(String[] args) {
		Student s1 = new Student(2000,"윤하");
		Student s2 = new Student(1990,"태현");
		
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		
		Student s3 = new Student(2000,"효연");
		Student s4 = new Student(2000,"효연");
		System.out.println(s3==s4);
		
		boolean bool = s3.equals(s4);
		System.out.println(bool);
	}
}