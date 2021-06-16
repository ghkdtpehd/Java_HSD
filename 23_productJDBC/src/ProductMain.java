import java.util.ArrayList;
import java.util.Scanner;

public class ProductMain {
	ProductDao dao = new ProductDao();
	Scanner sc = new Scanner(System.in);
	
	ProductMain(){
		init();
	}
	
	public void init(){
		while(true) {
			ArrayList<ProductBean> list = null;
			System.out.println("===�޴�����===");
			System.out.println("1.��� ��ǰ ��ȸ");
			System.out.println("2.��ǰ ID�� ��ȸ");
			System.out.println("3.ī�װ� ��ȸ");
			System.out.println("4.��ǰ �߰�");
			System.out.println("5.��ǰ ����");
			System.out.println("6.��ǰ ����");
			System.out.println("7.���α׷� ����");
			System.out.print("��ȣ�Է� :: ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1: 
				showProducts(dao.AllProductData());
				break;
			case 2:
				getProductById();
				break;
			case 3:
				getProductByCategory();
				break;
			case 4:
				insertData();
				break;
			case 5:
				updateData();
				break;
			case 6:
				deleteData();
				break;
			case 7:
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
				break;
			default:
				System.out.println("1~7 ������ ��ȣ�� �Է°���");
			}
		}
	}
	
	private void deleteData() {
		System.out.print("������ ������ ID :");
		int id = sc.nextInt();
		
		int cnt = dao.deleteData(id);
		
		if(cnt == 0) {
			System.out.println("���� ����");
		}else {
			System.out.println("���� ����");
		}
	}

	private void updateData() {
		ProductBean pb = new ProductBean();
		System.out.print("������ ������ ID :");
		pb.setId(sc.nextInt());
		
		System.out.print("��ǰ�� �Է� :");
		pb.setName(sc.next());
		System.out.print("������ �Է� :");
		pb.setStock(sc.nextInt());
		System.out.print("�ܰ� �Է� :");
		pb.setPrice(sc.nextInt());
		System.out.print("ī�װ� �Է� :");
		pb.setCategory(sc.next());
		System.out.print("�԰��� �Է� :");
		pb.setInputdate(sc.next());
		
		int cnt = dao.updateData(pb);
		
		if(cnt == 0) {
			System.out.println("������ ����");
		}else {
			System.out.println("������ ����");
		}
	}

	private void insertData() {
		ProductBean pb = new ProductBean();
		System.out.println("���̵�� �������� �ڵ� �Էµ˴ϴ�.");
		System.out.print("��ǰ�� �Է� :");
		pb.setName(sc.next());
		System.out.print("������ �Է� :");
		pb.setStock(sc.nextInt());
		System.out.print("�ܰ� �Է� :");
		pb.setPrice(sc.nextInt());
		System.out.print("ī�װ� �Է� :");
		pb.setCategory(sc.next());
		System.out.print("�԰��� �Է� :");
		pb.setInputdate(sc.next());
		
		int cnt = dao.insertData(pb);
		if(cnt == 0) {
			System.out.println("insert�� �����Ͽ����ϴ�.");
		}else {
			System.out.println("insert�� �����Ͽ����ϴ�.");
		}
		
	}

	private void getProductByCategory() {
		System.out.print("ã���� ī�װ� :");
		String category = sc.next();
		showProducts(dao.gerProductByCategory(category));
	}

	public void getProductById () {
		System.out.print("ã���� ��ǰ�� ID :");
		int id = sc.nextInt();
		showProducts(dao.nameProductData(id));
	}
	
	public void showProducts(ArrayList<ProductBean> list) {
		if(list.size() != 0) {
			System.out.println("ID\tNAME\tSTOCK\tPRICE\tCATEGORY\tINPUTDATE");
			for(ProductBean data : list) {
				System.out.println(data.getId()+"\t"+
									data.getName()+"\t"+
									data.getStock()+"\t"+
									data.getPrice()+"\t"+
									data.getCategory()+"\t"+
									data.getInputdate()
									);
			}
		}else {
			System.out.println("�����Ͱ� �����ϴ�.");
		}
	}
	public static void main(String[] args) {
		new ProductMain();
	}
}