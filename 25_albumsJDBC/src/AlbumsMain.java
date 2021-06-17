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
			System.out.println("====�޴� �����ϱ�====");
			System.out.println("1.��� ���� ��ȸ");
			System.out.println("4.�ٹ� ����");
			System.out.println("5.�ٹ� ����");
			System.out.println("6.�ٹ� �߰�");
			System.out.println("8.���α׷� ����");
			System.out.print("�޴� ���� >>");
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
					System.out.println("���α׷��� �����մϴ�.");
					System.exit(0);
					break;	
				default	:
					System.out.println("1~8�� ���ڸ� �Է����ּ���.");
			}
		}
	}
	private void insertAlbum() {
		AlbumsBean ab = new AlbumsBean();
		System.out.println("��ȣ�� �������� �ڵ� ó���˴ϴ�.");
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
		new AlbumsMain();
	}
}