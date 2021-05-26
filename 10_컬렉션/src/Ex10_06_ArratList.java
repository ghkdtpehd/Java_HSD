import java.util.ArrayList;
import java.util.Scanner;

class Book{
	private String title;
	private String author;
	private int price;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	public String toString () {
		return title+" / "+author+" / "+price;
	}
}
public class Ex10_06_ArratList {
	public static void main(String[] args) {
		//리스트로 한번에 출력
		//따로따로 다 출력
		//계속하시겠습니가?
		ArrayList<Book> arr = new ArrayList<Book>();
		Scanner sc = new Scanner(System.in);
		while(true) {
			String title,author;
			int price;
			
			System.out.print("제목 : ");
			title = sc.next();
			System.out.print("저작자 : ");
			author = sc.next();
			System.out.print("가격 : ");
			price = sc.nextInt();
			
			Book b = new Book(title,author,price);
			arr.add(b);
			
			System.out.print("계속 입력하시겠습니까?");
			if("n".equals(sc.next())) {
				break;
			}
		}
		
		System.out.println("---------------");
		
		for(int i=0;i<arr.size();i++) {
			System.out.println(arr.get(i));
		}
		
		sc.close();
	}
}