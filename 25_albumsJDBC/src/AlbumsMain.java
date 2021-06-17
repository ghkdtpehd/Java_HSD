import java.util.ArrayList;
import java.util.Scanner;

public class AlbumsMain {
	Scanner sc = new Scanner(System.in); 
	AlbumsDao dao = new AlbumsDao();
	AlbumsMain(){
		init();
	}
	
	void init(){
		while(true) {
			System.out.println("====메뉴 선택하기====");
			System.out.println("1.모든 정보 조회");
			System.out.println("4.앨범 수정");
			System.out.println("5.앨범 삭제");
			System.out.println("6.앨범 추가");
			System.out.println("8.프로그램 종료");
			System.out.print("메뉴 선택 >>");
			int menu = sc.nextInt();
			
			switch(menu) {
				case 1:
					printList(dao.getAllAlbumList());
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					updateAlbum();
					break;
				case 5:
					deleteAlbum();
					break;
				case 6:
					insertAlbum();
					break;
				case 7:
					break;
				case 8:
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
					break;	
				default	:
					System.out.println("1~8의 숫자만 입력해주세요.");
			}
		}
	}
	private void insertAlbum() {
		AlbumsBean ab = new AlbumsBean();
		System.out.println("번호는 시퀀스로 자동 처리됩니다.");
		System.out.println("노래를 입력: ");
		ab.setSong(sc.next());
		System.out.println("가수를 입력: ");
		ab.setSinger(sc.next());
		System.out.println("회사를 입력: ");
		ab.setCompany(sc.next());
		System.out.println("가격를 입력: ");
		ab.setPrice(sc.nextInt());
		System.out.println("출고일를 입력: ");
		ab.setPub_day(sc.next());
		
		int cnt = dao.insertAlbum(ab);
		if(cnt == 0) {
			System.out.println("삽입을 실패하였습니다.");
		}else {
			System.out.println("수정을 성공하였습니다.");
		}
	}

	private void deleteAlbum() {
		System.out.println("번호를 입력: ");
		int cnt = dao.deleteAlbum(sc.nextInt());
		if(cnt == 0) {
			System.out.println("삭제를 실패하였습니다.");
		}else {
			System.out.println("삭제를 성공하였습니다.");
		}
	}

	private void updateAlbum() {
		AlbumsBean ab = new AlbumsBean();
		System.out.println("번호를 입력: ");
		ab.setNum(sc.nextInt());
		System.out.println("노래를 입력: ");
		ab.setSong(sc.next());
		System.out.println("가수를 입력: ");
		ab.setSinger(sc.next());
		System.out.println("회사를 입력: ");
		ab.setCompany(sc.next());
		System.out.println("가격를 입력: ");
		ab.setPrice(sc.nextInt());
		System.out.println("출고일를 입력: ");
		ab.setPub_day(sc.next());
		
		int cnt = dao.updateAlbum(ab);
		if(cnt == 0) {
			System.out.println("수정을 실패하였습니다.");
		}else {
			System.out.println("수정을 성공하였습니다.");
		}
	}

	public void printList(ArrayList<AlbumsBean> list) {
		if(list.size() != 0) {
			System.out.println("num\tsong\tsinger\tcompany\tprice\tpub_day");
			for(AlbumsBean ab : list) {
				System.out.println(ab.getNum()+"\t"+
									ab.getSong()+"\t"+
									ab.getSinger()+"\t"+
									ab.getCompany()+"\t"+
									ab.getPrice()+"\t"+
									ab.getPub_day());
			}
			System.out.println();
		}else {
			System.out.println("데이터가 없습니다.");
		}
	}
	public static void main(String[] args) {
		new AlbumsMain();
	}
}