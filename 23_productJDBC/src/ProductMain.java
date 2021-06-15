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
			System.out.println("===�޴�����===");
			System.out.println("1.��� ��ǰ ��ȸ");
			System.out.println("7.���α׷� ����");
			System.out.print("��ȣ�Է� :: ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1: 
				ArrayList<ProductBean> list = dao.AllProductData();
				System.out.println("ID\tNAME\tSTOCK\tPRICE\tCATEGOTY\tINPUTDATE");
				for(ProductBean data : list) {
					System.out.println(data.getId()+"\t"+
										data.getName()+"\t"+
										data.getStock()+"\t"+
										data.getPrice()+"\t"+
										data.getCategory()+"\t"+
										data.getInputdate()
										);
				}
					
				break;
			case 7:
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
				break;
			default:
			}
		}
	}
	
	public static void main(String[] args) {
		new ProductMain();
	}
}