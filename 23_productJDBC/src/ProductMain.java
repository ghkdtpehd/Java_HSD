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
			System.out.println("===메뉴선택===");
			System.out.println("1.모든 상품 조회");
			System.out.println("2.상품 ID로 조회");
			System.out.println("3.카테고리 조회");
			System.out.println("4.상품 추가");
			System.out.println("5.상품 수정");
			System.out.println("6.상품 삭제");
			System.out.println("7.프로그램 종료");
			System.out.print("번호입력 :: ");
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
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("1~7 사이의 번호만 입력가능");
			}
		}
	}
	
	private void deleteData() {
		System.out.print("삭제할 물건의 ID :");
		int id = sc.nextInt();
		
		int cnt = dao.deleteData(id);
		
		if(cnt == 0) {
			System.out.println("삭제 실패");
		}else {
			System.out.println("삭제 성공");
		}
	}

	private void updateData() {
		ProductBean pb = new ProductBean();
		System.out.print("수정할 물건의 ID :");
		pb.setId(sc.nextInt());
		
		System.out.print("상품명 입력 :");
		pb.setName(sc.next());
		System.out.print("재고수량 입력 :");
		pb.setStock(sc.nextInt());
		System.out.print("단가 입력 :");
		pb.setPrice(sc.nextInt());
		System.out.print("카테고리 입력 :");
		pb.setCategory(sc.next());
		System.out.print("입고일 입력 :");
		pb.setInputdate(sc.next());
		
		int cnt = dao.updateData(pb);
		
		if(cnt == 0) {
			System.out.println("수정에 실패");
		}else {
			System.out.println("수정에 성공");
		}
	}

	private void insertData() {
		ProductBean pb = new ProductBean();
		System.out.println("아이디는 시퀀스로 자동 입력됩니다.");
		System.out.print("상품명 입력 :");
		pb.setName(sc.next());
		System.out.print("재고수량 입력 :");
		pb.setStock(sc.nextInt());
		System.out.print("단가 입력 :");
		pb.setPrice(sc.nextInt());
		System.out.print("카테고리 입력 :");
		pb.setCategory(sc.next());
		System.out.print("입고일 입력 :");
		pb.setInputdate(sc.next());
		
		int cnt = dao.insertData(pb);
		if(cnt == 0) {
			System.out.println("insert에 실패하였습니다.");
		}else {
			System.out.println("insert에 성공하였습니다.");
		}
		
	}

	private void getProductByCategory() {
		System.out.print("찾으실 카테고리 :");
		String category = sc.next();
		showProducts(dao.gerProductByCategory(category));
	}

	public void getProductById () {
		System.out.print("찾으실 상품의 ID :");
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
			System.out.println("데이터가 없습니다.");
		}
	}
	public static void main(String[] args) {
		new ProductMain();
	}
}