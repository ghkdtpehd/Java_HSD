import java.util.Scanner;

class Book{
	private String title;
	private int price;
	
	void setTitle(String title) {
		this.title = title;
	}
	void setPrice(int price) {
		this.price = price;
	}
	
	String getTitle() {
		return title; 
	}
	int getPrice() {
		return price;
	}
}
public class Ex05_17_황세동 {
	public static void main(String[] args) {
		//book 클레스 객체 3개를 배열로 만들기
		Book[] arrBk = new Book[3];
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<arrBk.length;i++) {
			//title, price입력
			arrBk[i] = new Book();
			System.out.print("책 이름: ");
			arrBk[i].setTitle(sc.next());
			System.out.print("책 가격: ");
			arrBk[i].setPrice(sc.nextInt());
		}
		
		for(int i=0;i<arrBk.length;i++) {
			//한줄로 출력
			System.out.println("책이름 : "+arrBk[i].getTitle()+" / 책 가격 : "+arrBk[i].getPrice());
		}
	}
}