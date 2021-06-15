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
			System.out.println("===메뉴선택===");
			System.out.println("1.모든 상품 조회");
			System.out.println("7.프로그램 종료");
			System.out.print("번호입력 :: ");
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
				System.out.println("프로그램을 종료합니다.");
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