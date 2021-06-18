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
			System.out.println("====�޴� �����ϱ�====");
			System.out.println("1.��� ���� ��ȸ");
			System.out.println("2.���� ���� ��ȸ");
			System.out.println("3.���� ���� ���� ��ȸ(����:��������, ����:��������)");
			System.out.println("4.�ٹ� ����");
			System.out.println("5.�ٹ� ����");
			System.out.println("6.�ٹ� �߰�");
			System.out.println("7.�ٹ� ����");
			System.out.println("8.���α׷� ����");
			System.out.print("�޴� ���� >>");
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
					System.out.println("���α׷��� �����մϴ�.");
					System.exit(0);
					break;	
				default	:
					System.out.println("1~8�� ���ڸ� �Է����ּ���.");
			}
		}
	}
	private void refindAlbum() {
		String[][] str = {{"num","song","singer"},{"asc","desc"}};
		System.out.println("������ �׸� ����");
		System.out.print("��ȣ:1\t�뷡����:2\t������:3\t ��ȣ�Է�>>");
		int num1 = sc.nextInt()-1; 
		System.out.println("���Ĺ�� ����");
		System.out.print("��������:1\t��������:2\t��ȣ�Է�>>");
		int num2 = sc.nextInt()-1;
		
		printList(dao.refindAlbum(str[0][num1],str[1][num2]));
	}

	private void getAlbumByRange() throws NumberFormatException, IOException {
		System.out.print("���� ��� �Է�:");
		int stratNum = Integer.parseInt(br.readLine());
		System.out.print("�� ��� �Է�:");
		int endNum = Integer.parseInt(br.readLine());
		
		printList(dao.getAlbumByRange(stratNum,endNum));
	}

	private void getAlubmBySerch() {
		String[][] str = {{"����","song"},{"����","singer"},{"ȸ��","company"}};
		System.out.println("����˻�:1\t�����˻�:2\tȸ��˻�");
		System.out.print("�˻��� �׸��� ����: ");
		
		int num = sc.nextInt();
		if(num>0 && num<=3) {
			System.out.print("�˻��� "+str[num-1][0]+"�� ����: ");
			try {
				printList(dao.getAlubmBySerch(str[num-1][1],br.readLine()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("1~3�� ���ڸ� �Է����ּ���.");
		}
	}

	private void insertAlbum() throws IOException {
		AlbumsBean ab = new AlbumsBean();
		System.out.println("��ȣ�� �������� �ڵ� ó���˴ϴ�.");
		System.out.println("�뷡�� �Է�: ");
		ab.setSong(br.readLine());
		System.out.println("������ �Է�: ");
		ab.setSinger(br.readLine());
		System.out.println("ȸ�縦 �Է�: ");
		ab.setCompany(br.readLine());
		System.out.println("���ݸ� �Է�: ");
		do {
			try {
				ab.setPrice(Integer.parseInt(br.readLine()));
				break;
			}catch(NumberFormatException e) {
				System.out.println("������ ���ڸ� �Է����ּ���.");
			}
		}while(true);
		System.out.println("����ϸ� �Է�: ");
		ab.setPub_day(sc.next());
		
		int cnt = dao.insertAlbum(ab);
		if(cnt == 0) {
			System.out.println("������ �����Ͽ����ϴ�.");
		}else {
			System.out.println("������ �����Ͽ����ϴ�.");
		}
	}

	private void deleteAlbum() {
		System.out.println("��ȣ�� �Է�: ");
		int cnt = dao.deleteAlbum(sc.nextInt());
		if(cnt == 0) {
			System.out.println("������ �����Ͽ����ϴ�.");
		}else {
			System.out.println("������ �����Ͽ����ϴ�.");
		}
	}

	private void updateAlbum() {
		AlbumsBean ab = new AlbumsBean();
		System.out.println("��ȣ�� �Է�: ");
		ab.setNum(sc.nextInt());
		System.out.println("�뷡�� �Է�: ");
		ab.setSong(sc.next());
		System.out.println("������ �Է�: ");
		ab.setSinger(sc.next());
		System.out.println("ȸ�縦 �Է�: ");
		ab.setCompany(sc.next());
		System.out.println("���ݸ� �Է�: ");
		ab.setPrice(sc.nextInt());
		System.out.println("����ϸ� �Է�: ");
		ab.setPub_day(sc.next());
		
		int cnt = dao.updateAlbum(ab);
		if(cnt == 0) {
			System.out.println("������ �����Ͽ����ϴ�.");
		}else {
			System.out.println("������ �����Ͽ����ϴ�.");
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
			System.out.println("�����Ͱ� �����ϴ�.");
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