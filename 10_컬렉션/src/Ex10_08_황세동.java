import java.util.ArrayList;
import java.util.Scanner;

class Card{
	private String name;
	private String tel;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Card(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
}
public class Ex10_08_Ȳ���� {
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		ArrayList<Card> arr = new ArrayList<Card>();
		
		while(true) {
			String name,tel;
			boolean nameChk = false;
			
			System.out.print("1.�����߰� 2.���Ի��� 3.���Լ��� 4.���Ժ��� 5.���� : ");
			int num = sc.nextInt();
			
			switch(num) {
				case 1:
					System.out.print("�̸��� �Է����ּ��� :");
					name = sc.next();
					System.out.print("��ȭ��ȣ�� �Է����ּ��� :");
					tel = sc.next();
					
					Card c = new Card(name,tel);
					arr.add(c);
					
					break;
				case 2:
					System.out.print("�̸��� �Է��ϼ��� :");
					name = sc.next();
					
					for(int i=0;i<arr.size();i++) {
						if(name.equals(arr.get(i).getName())) {
							arr.remove(i);
							System.out.println("�����Ǿ����ϴ�.");
							nameChk = true;
							break;
						}
					}
					
					if(!nameChk) {
						System.out.println("�̸��� �߸��Է��ϼ̽��ϴ�.");
					}
					
					break;
				case 3:
					System.out.print("�̸��� �Է��ϼ��� :");
					name = sc.next();
					
					for(int i=0;i<arr.size();i++) {
						if(name.equals(arr.get(i).getName())) {
							System.out.print("�����Ͻ� ��ȭ��ȣ�� : ");
							tel = sc.next();
							arr.get(i).setTel(tel);;
							nameChk = true;
							
							System.out.println("�����Ǿ����ϴ�.");
							break;
						}
					}
					if(!nameChk) {
						System.out.println("�̸��� �߸��Է��ϼ̽��ϴ�.");
					}
					
					break;
				case 4:
					System.out.printf("�̸� \t ��ȭ��ȣ\n");
					for(int i=0;i<arr.size();i++) {
						System.out.printf(arr.get(i).getName()+"\t"+arr.get(i).getTel()+"\n");
					}
					break;
				case 5:
					System.out.println("���α׷��� �����մϴ�.");
					System.exit(0);
				default :
					System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}
		}
	}
}