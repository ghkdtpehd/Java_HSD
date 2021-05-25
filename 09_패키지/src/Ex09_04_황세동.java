import java.util.Scanner;

class Person {
	String id;
	String pw;
	String name;

	public Person(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
}

public class Ex09_04_Ȳ���� {
	public static void main(String[] args) {
		// Person ��ü 3�� �迭�� ����

		Person[] p = { new Person("joo1", "qwe23", "�ֿ�"),
				new Person("wj355", "q1w2e3", "����"),
				new Person("kimgh", "qwe123", "��ȣ") };
		Scanner sc = new Scanner(System.in);

		do {
			//���� ����
			String id = "", pw = "", result = "";
			boolean idChk = false,pwChk=false;
			Person token = null;

			//id�� �ޱ�
			System.out.print("id �Է� :");
			id = sc.next();
			
			//���̵� ��밪 �ʰ� Ȯ��
			if (id.length() > 8 || id.length() < 3) {
				System.out.println("���̵�� 3~8���ڸ� �Է��ؾ� �մϴ�.");
				continue;
			}
			
			//���̵� Ȯ��, �ش� �迭 �̾ƿ���
			//�ش���̵� �� �迭�� ���� ��� �ߺ��Ͽ� ����Ͽ��� �ڷ� ��
			for (int i = 0; i < p.length; i++) {
				if (p[i].id.equals(id)) {
					// id ��Ī �Ϸ�
					idChk = true;
					token = p[i];
				}
			}

			// ���̵� ������
			if (idChk == false) {
				System.out.println("�ش� ���̵� �����ϴ�.");
				
				//���ӿ��� Ȯ��
				System.out.print("��� �Ͻðڽ��ϱ�? Y/N");
				result = sc.next();
				
				if(result.equals("n")||result.equals("N")) {
					break;
				}else {
					continue;
				}
			}
			
			//��й�ȣ �Է�
			System.out.print("pw �Է� :");
			pw = sc.next();
			
			//��й�ȣ Ȯ��, ������ �α����
			for(int i = 0; i<p.length;i++) {
				if(token.pw.equals(pw)) {
					pwChk=true;
				}
			}
			
			//��й�ȣ�� ������ ���
			if(!pwChk) {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			}else {
				System.out.println(token.name+"�� �ݰ����ϴ�.");
			}
			
			//���� Ȯ��
			System.out.print("��� �Ͻðڽ��ϱ�?");
			result = sc.next();
			
			if (result.equals("n")||result.equals("N")) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
		} while (true);
		
		sc.close();
	}
}