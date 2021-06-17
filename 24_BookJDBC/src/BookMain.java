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
			System.out.println("=====메뉴 선택하기=====");
			System.out.println("1. 전체 정보 조회");
			System.out.println("2. 조건 조회");
			System.out.println("3. 정보 수정");
			System.out.println("4. 정보 삭제");
			System.out.println("5. 정보 추가");
			System.out.println("6. 프로그램 종료");
			System.out.print(">> 메뉴 번호 입력 : ");
			int menu = sc.nextInt();
			
			switch(menu) {
				case 1 : 
					printConsol(dao.getBookList());
					break;
				case 2 : 
					String[] chsList = choiceBook();
					System.out.print("조회할 "+chsList[1]+" :");
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
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
					break;
				default:
					System.out.println("잘못 입력하셨습니다.");
					System.out.println("1~6 까지의 숫자로 입력해주세요.");
			}
		}
	}
	private void insertBook() {
		BookBean bb = new BookBean();
		System.out.println("번호는 시퀀스로 입력됩니다(생략)");
		System.out.print("책제목 입력 :");
		bb.setTitle(sc.next());
		System.out.print("저자 입력 :");
		bb.setAuthor(sc.next());
		System.out.print("출판사 입력 :");
		bb.setPublisher(sc.next());
		System.out.print("가격 입력 :");
		bb.setPrice(sc.nextInt());
		System.out.print("출간일(yyyy/mm/dd 형식으로 입력하세요.) :");
		bb.setPub_day(sc.next());
		
		int cnt = dao.insertBook(bb);
		if(cnt == 1) {
			System.out.println("삽입 되었습니다.");
		}else {
			System.out.println("삽입을 실패하였습니다.");
		}
	}

	private void deleteBook() {
		System.out.print("삭제할 책번호 입력 :");
		int cnt = dao.deleteBook(sc.nextInt());
		if(cnt == 1) {
			System.out.println("삭제 되었습니다.");
		}else {
			System.out.println("삭제를 실패하였습니다.");
		}
	}

	private void updateBook() {
		BookBean bb = new BookBean();
		System.out.print("수정할 번호 입력 :");
		bb.setNo(sc.nextInt());
		System.out.print("책제목 입력 :");
		bb.setTitle(sc.next());
		System.out.print("저자 입력 :");
		bb.setAuthor(sc.next());
		System.out.print("출판사 입력 :");
		bb.setPublisher(sc.next());
		System.out.print("가격 입력 :");
		bb.setPrice(sc.nextInt());
		System.out.print("출간일(yyyy/mm/dd 형식으로 입력하세요.) :");
		bb.setPub_day(sc.next());
		
		int cnt = dao.updateBook(bb);
		if(cnt == 1) {
			System.out.println("수정 되었습니다.");
		}else {
			System.out.println("수정을 실패하였습니다.");
		}
	}

	private String[] choiceBook() {
		String[] chsList = new String[2]; 
		String nextQ = "";
		System.out.print("제목:1\t저자:2\t출판사:3\t번호입력>> ");
		switch(sc.nextInt()) {
		case 1:
			chsList[0] = "title";
			chsList[1] = "제목";
			break;
		case 2:
			chsList[0] = "author";
			chsList[1] = "저자";
			break;
		case 3:
			chsList[0] = "publisher";
			chsList[1] = "출판사";
			break;
		default:
			System.out.println("1~3사이의 번호를 입력해주세요.");
		}

		
		return chsList;
	}

	private void printConsol(ArrayList<BookBean> list) {
		System.out.println("번호\t책제목\t저자\t출판사\t가격\t출간일");
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