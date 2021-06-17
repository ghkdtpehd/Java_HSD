import java.util.ArrayList;
import java.util.Scanner;

public class BookMain {
	BookDao dao = new BookDao();
	Scanner sc = new Scanner(System.in);
	
	BookMain(){
		init();
	}
	
	void init() {
		while(true) {
			System.out.println("=====�޴� �����ϱ�=====");
			System.out.println("1. ��ü ���� ��ȸ");
			System.out.println("2. ���� ��ȸ");
			System.out.println("3. ���� ����");
			System.out.println("4. ���� ����");
			System.out.println("5. ���� �߰�");
			System.out.println("6. ���α׷� ����");
			System.out.print(">> �޴� ��ȣ �Է� : ");
			int menu = sc.nextInt();
			
			switch(menu) {
				case 1 : 
					printConsol(dao.getBookList());
					break;
				case 2 : 
					String[] chsList = choiceBook();
					System.out.print("��ȸ�� "+chsList[1]+" :");
					chsList[1] = sc.next();
					
					printConsol(dao.getBookChoiceList(chsList));
					break;
				case 3 : 
					updateBook();
					break;
				case 4 :
					deleteBook();
					break;
				case 5 : 
					insertBook();
					break;
				case 6 : 
					System.out.println("���α׷��� �����մϴ�.");
					System.exit(0);
					break;
				default:
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
					System.out.println("1~6 ������ ���ڷ� �Է����ּ���.");
			}
		}
	}
	private void insertBook() {
		BookBean bb = new BookBean();
		System.out.println("��ȣ�� �������� �Էµ˴ϴ�(����)");
		System.out.print("å���� �Է� :");
		bb.setTitle(sc.next());
		System.out.print("���� �Է� :");
		bb.setAuthor(sc.next());
		System.out.print("���ǻ� �Է� :");
		bb.setPublisher(sc.next());
		System.out.print("���� �Է� :");
		bb.setPrice(sc.nextInt());
		System.out.print("�Ⱓ��(yyyy/mm/dd �������� �Է��ϼ���.) :");
		bb.setPub_day(sc.next());
		
		int cnt = dao.insertBook(bb);
		if(cnt == 1) {
			System.out.println("���� �Ǿ����ϴ�.");
		}else {
			System.out.println("������ �����Ͽ����ϴ�.");
		}
	}

	private void deleteBook() {
		System.out.print("������ å��ȣ �Է� :");
		int cnt = dao.deleteBook(sc.nextInt());
		if(cnt == 1) {
			System.out.println("���� �Ǿ����ϴ�.");
		}else {
			System.out.println("������ �����Ͽ����ϴ�.");
		}
	}

	private void updateBook() {
		BookBean bb = new BookBean();
		System.out.print("������ ��ȣ �Է� :");
		bb.setNo(sc.nextInt());
		System.out.print("å���� �Է� :");
		bb.setTitle(sc.next());
		System.out.print("���� �Է� :");
		bb.setAuthor(sc.next());
		System.out.print("���ǻ� �Է� :");
		bb.setPublisher(sc.next());
		System.out.print("���� �Է� :");
		bb.setPrice(sc.nextInt());
		System.out.print("�Ⱓ��(yyyy/mm/dd �������� �Է��ϼ���.) :");
		bb.setPub_day(sc.next());
		
		int cnt = dao.updateBook(bb);
		if(cnt == 1) {
			System.out.println("���� �Ǿ����ϴ�.");
		}else {
			System.out.println("������ �����Ͽ����ϴ�.");
		}
	}

	private String[] choiceBook() {
		String[] chsList = new String[2]; 
		String nextQ = "";
		System.out.print("����:1\t����:2\t���ǻ�:3\t��ȣ�Է�>> ");
		switch(sc.nextInt()) {
		case 1:
			chsList[0] = "title";
			chsList[1] = "����";
			break;
		case 2:
			chsList[0] = "author";
			chsList[1] = "����";
			break;
		case 3:
			chsList[0] = "publisher";
			chsList[1] = "���ǻ�";
			break;
		default:
			System.out.println("1~3������ ��ȣ�� �Է����ּ���.");
		}

		
		return chsList;
	}

	private void printConsol(ArrayList<BookBean> list) {
		System.out.println("��ȣ\tå����\t����\t���ǻ�\t����\t�Ⱓ��");
		for(BookBean data : list) {
			System.out.println(data.getNo()+"\t"+
								data.getTitle()+"\t"+
								data.getAuthor()+"\t"+
								data.getPublisher()+"\t"+
								data.getPrice()+"\t"+
								data.getPub_day());
		}
		System.out.println();
	}

	public static void main(String[] args) {
		new BookMain();
	}
}