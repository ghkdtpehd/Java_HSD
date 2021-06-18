import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AlbumsMain {
	Scanner sc = new Scanner(System.in); 
	AlbumsDao dao = new AlbumsDao();
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	AlbumsMain() throws IOException{
		init();
	}
	
	void init() throws IOException{
		while(true) {
			System.out.println("====메뉴 선택하기====");
			System.out.println("1.모든 정보 조회");
			System.out.println("2.조건 정보 조회");
			System.out.println("3.가격 범위 조건 조회(가격:내림차순, 가수:오름차순)");
			System.out.println("4.앨범 수정");
			System.out.println("5.앨범 삭제");
			System.out.println("6.앨범 추가");
			System.out.println("7.앨범 정렬");
			System.out.println("8.프로그램 종료");
			System.out.print("메뉴 선택 >>");
			int menu = sc.nextInt();
			
			switch(menu) {
				case 1:
					printList(dao.getAllAlbumList());
					break;
				case 2:
					getAlubmBySerch();
					break;
				case 3:
					getAlbumByRange();
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
					refindAlbum();
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
	private void refindAlbum() {
		String[][] str = {{"num","song","singer"},{"asc","desc"}};
		System.out.println("정렬할 항목 선택");
		System.out.print("번호:1\t노래제목:2\t가수명:3\t 번호입력>>");
		int num1 = sc.nextInt()-1; 
		System.out.println("정렬방법 선택");
		System.out.print("오름차순:1\t내림차순:2\t번호입력>>");
		int num2 = sc.nextInt()-1;
		
		printList(dao.refindAlbum(str[0][num1],str[1][num2]));
	}

	private void getAlbumByRange() throws NumberFormatException, IOException {
		System.out.print("시작 등수 입력:");
		int stratNum = Integer.parseInt(br.readLine());
		System.out.print("끝 등수 입력:");
		int endNum = Integer.parseInt(br.readLine());
		
		printList(dao.getAlbumByRange(stratNum,endNum));
	}

	private void getAlubmBySerch() {
		String[][] str = {{"제목","song"},{"가수","singer"},{"회사","company"}};
		System.out.println("제목검색:1\t가수검색:2\t회사검색");
		System.out.print("검색할 항목을 선택: ");
		
		int num = sc.nextInt();
		if(num>0 && num<=3) {
			System.out.print("검색할 "+str[num-1][0]+"을 선택: ");
			try {
				printList(dao.getAlubmBySerch(str[num-1][1],br.readLine()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("1~3의 숫자만 입력해주세요.");
		}
	}

	private void insertAlbum() throws IOException {
		AlbumsBean ab = new AlbumsBean();
		System.out.println("번호는 시퀀스로 자동 처리됩니다.");
		System.out.println("노래를 입력: ");
		ab.setSong(br.readLine());
		System.out.println("가수를 입력: ");
		ab.setSinger(br.readLine());
		System.out.println("회사를 입력: ");
		ab.setCompany(br.readLine());
		System.out.println("가격를 입력: ");
		do {
			try {
				ab.setPrice(Integer.parseInt(br.readLine()));
				break;
			}catch(NumberFormatException e) {
				System.out.println("가격은 숫자만 입력해주세요.");
			}
		}while(true);
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
		try {
			new AlbumsMain();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}