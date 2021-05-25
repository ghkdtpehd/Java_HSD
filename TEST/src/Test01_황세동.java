class Product{
	private String code;
	private String company;
	
	Product(String code, String company){
		this.code = code;
		this.company = company;
	}
	
	void display() {
		System.out.println("code : "+ code);
		System.out.println("company : "+ company);
	}
}
class Computer extends Product{
	private String os;
	private int ram;
	
	Computer(String code, String company, String os, int ram){
		super(code, company);
		this.os = os;
		this.ram = ram;
	}
	void display() {
		super.display();
		System.out.println("os : "+ os);
		System.out.println("ram : "+ ram);
	}
}
class Book extends Product{
	private String title;
	private String author;
	
	Book(String code, String company, String title, String author){
		super(code, company);
		this.title = title;
		this.author = author;
	}
	void display() {
		super.display();
		System.out.println("title : "+ title);
		System.out.println("author : "+ author);
	}
}

public class Test01_황세동 {
	public static void main(String[] args) {
		//youn1223@daum.net
		Product p = new Product("p01","중앙");
		Computer c = new Computer("c02","삼성","window10",64);
		Book b = new Book("b03","교보문고","자바","김윤아");
		
		//위의 것 출력
		System.out.println("--Product--");
		p.display();
		System.out.println("--Computer--");
		c.display();
		System.out.println("--Book--");
		b.display();
		System.out.println();
		
		System.out.println("----배열로 출력----");
		//위 객채 3개를 배열로 생성, display()로 출력
		Product[] pArr = {p,c,b};
		for(int i=0;i<pArr.length;i++) {
			System.out.println();
			pArr[i].display();
		}
	}
}