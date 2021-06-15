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
			System.out.println("====�޴� ����====");
			System.out.println("1.��ü ���� ��ȸ");
			System.out.println("2.������ ��ȸ");
			System.out.println("3.���� ����");
			System.out.println("4.���� ����");
			System.out.println("5.���� �߰�");
			System.out.println("6.���α׷� ����");
			System.out.print(">> �޴� ��ȣ �Է� : ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				ArrayList<PersonBean> list = dao.getAllPerson();
				
				System.out.println("��ȣ\t�̸�\t����\t����\t�������");
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
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
				break;
			default:
				System.out.println("1~6������ ��ȣ�� �Է� ����");
			}
		}
	}
	private void deleteData() {
		System.out.print("������ ��ȣ �Է�:");
		int num = sc.nextInt();
		
		int cnt = dao.deleteData(num);
		if(cnt == 0) {
			System.out.println("������ ������ �����Ͽ����ϴ�.");
		}else {
			System.out.println("������ ������ �����Ͽ����ϴ�.");
		}
	}

	private void updateData() {
		System.out.print("������ ��ȣ �Է�:");
		int num = sc.nextInt();
		System.out.print("������ �̸� �Է�:");
		String name = sc.next();
		System.out.print("������ ���� �Է�:");
		int age = sc.nextInt();
		System.out.print("������ ���� �Է�:");
		String gender = sc.next();
		System.out.print("������ ������� �Է�(yyyy/mm/dd)");
		String birth = sc.next();
		
		PersonBean pb = new PersonBean();
		pb.setNum(num);
		pb.setAge(age);
		pb.setName(name);
		pb.setGender(gender);
		pb.setBirth(birth);
		
		int cnt = dao.updateData(pb);
		if(cnt == 0)
			System.out.println("������ �Ϸ���� �ʾҽ��ϴ�.");
	}

	private void insertData() {
		System.out.println("��ȣ�� �������� �Էµ˴ϴ�.(����)");
		System.out.print("�̸� �Է�:");
		String name = sc.next();
		System.out.print("���� �Է�:");
		int age = sc.nextInt();
		System.out.print("���� �Է�:");
		String gender = sc.next();
		System.out.print("������� �Է�(yyyy/mm/dd)");
		String birth = sc.next();
		
		PersonBean pb = new PersonBean();
		pb.setAge(age);
		pb.setName(name);
		pb.setGender(gender);
		pb.setBirth(birth);
		
		int cnt = dao.insertDara(pb);
		if(cnt == 0) {
			System.out.println("�߰��� �����Ͽ����ϴ�.");
		}
	}

	public void getPersonByGender() {
		System.out.print("ã������ ������ �Է��ϼ���.");
		String find_gender = sc.next();
		
		ArrayList<PersonBean> list = dao.getPersonByGender(find_gender);
		System.out.println("��ȣ\t�̸�\t����\t����\t�������");
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