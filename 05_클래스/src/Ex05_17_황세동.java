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
public class Ex05_17_Ȳ���� {
	public static void main(String[] args) {
		//book Ŭ���� ��ü 3���� �迭�� �����
		Book[] arrBk = new Book[3];
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<arrBk.length;i++) {
			//title, price�Է�
			arrBk[i] = new Book();
			System.out.print("å �̸�: ");
			arrBk[i].setTitle(sc.next());
			System.out.print("å ����: ");
			arrBk[i].setPrice(sc.nextInt());
		}
		
		for(int i=0;i<arrBk.length;i++) {
			//���ٷ� ���
			System.out.println("å�̸� : "+arrBk[i].getTitle()+" / å ���� : "+arrBk[i].getPrice());
		}
	}
}