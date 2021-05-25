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

public class Test01_Ȳ���� {
	public static void main(String[] args) {
		//youn1223@daum.net
		Product p = new Product("p01","�߾�");
		Computer c = new Computer("c02","�Ｚ","window10",64);
		Book b = new Book("b03","��������","�ڹ�","������");
		
		//���� �� ���
		System.out.println("--Product--");
		p.display();
		System.out.println("--Computer--");
		c.display();
		System.out.println("--Book--");
		b.display();
		System.out.println();
		
		System.out.println("----�迭�� ���----");
		//�� ��ä 3���� �迭�� ����, display()�� ���
		Product[] pArr = {p,c,b};
		for(int i=0;i<pArr.length;i++) {
			System.out.println();
			pArr[i].display();
		}
	}
}