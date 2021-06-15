import java.util.ArrayList;
import java.util.Scanner;

public class PersonMain {
	PersonDao dao = new PersonDao();
	Scanner sc = new Scanner(System.in);
	
	PersonMain(){
		init();
	}
	
	public void init() {
		while(true) {
			System.out.println("====메뉴 선택====");
			System.out.println("1.전체 정보 조회");
			System.out.println("2.성별로 조회");
			System.out.println("3.정보 수정");
			System.out.println("4.정보 삭제");
			System.out.println("5.정보 추가");
			System.out.println("6.프로그램 종료");
			System.out.print(">> 메뉴 번호 입력 : ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				ArrayList<PersonBean> list = dao.getAllPerson();
				
				System.out.println("번호\t이름\t나이\t성별\t생년월일");
				for(int i=0;i<list.size();i++) {
					System.out.println(list.get(i).getNum()+"\t"+
										list.get(i).getName()+"\t"+
										list.get(i).getAge()+"\t"+
										list.get(i).getGender()+"\t"+
										list.get(i).getBirth());
				}
				break;
			case 2:
				getPersonByGender();
				break;
			case 3:
				updateData();
				break;
			case 4:
				deleteData();
				break;
			case 5:
				insertData();
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("1~6사이의 번호만 입력 가능");
			}
		}
	}
	private void deleteData() {
		System.out.print("삭제할 번호 입력:");
		int num = sc.nextInt();
		
		int cnt = dao.deleteData(num);
		if(cnt == 0) {
			System.out.println("데이터 삭제에 실패하였습니다.");
		}else {
			System.out.println("데이터 삭제에 성공하였습니다.");
		}
	}

	private void updateData() {
		System.out.print("수정할 번호 입력:");
		int num = sc.nextInt();
		System.out.print("수정할 이름 입력:");
		String name = sc.next();
		System.out.print("수정할 나이 입력:");
		int age = sc.nextInt();
		System.out.print("수정할 성별 입력:");
		String gender = sc.next();
		System.out.print("수정할 생년월일 입력(yyyy/mm/dd)");
		String birth = sc.next();
		
		PersonBean pb = new PersonBean();
		pb.setNum(num);
		pb.setAge(age);
		pb.setName(name);
		pb.setGender(gender);
		pb.setBirth(birth);
		
		int cnt = dao.updateData(pb);
		if(cnt == 0)
			System.out.println("수정이 완료되지 않았습니다.");
	}

	private void insertData() {
		System.out.println("번호는 시퀀스로 입력됩니다.(생략)");
		System.out.print("이름 입력:");
		String name = sc.next();
		System.out.print("나이 입력:");
		int age = sc.nextInt();
		System.out.print("성별 입력:");
		String gender = sc.next();
		System.out.print("생년월일 입력(yyyy/mm/dd)");
		String birth = sc.next();
		
		PersonBean pb = new PersonBean();
		pb.setAge(age);
		pb.setName(name);
		pb.setGender(gender);
		pb.setBirth(birth);
		
		int cnt = dao.insertDara(pb);
		if(cnt == 0) {
			System.out.println("추가에 실패하였습니다.");
		}
	}

	public void getPersonByGender() {
		System.out.print("찾으려는 성별을 입력하세요.");
		String find_gender = sc.next();
		
		ArrayList<PersonBean> list = dao.getPersonByGender(find_gender);
		System.out.println("번호\t이름\t나이\t성별\t생년월일");
		for(PersonBean data : list) {
			System.out.println(data.getNum()+"\t"+
							data.getName()+"\t"+
							data.getAge()+"\t"+
							data.getGender()+"\t"+
							data.getBirth());
		}
	}

	public static void main(String[] args) {
		PersonMain per = new PersonMain();
	}
}