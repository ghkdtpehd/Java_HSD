import java.util.Scanner;

public class Ex03_04_switch_case {
	public static void main(String[] args) {
		String fruit;
		Scanner sc = new Scanner(System.in);
		System.out.println("�����̸� :");
		fruit = sc.next();
		
		switch(fruit) {
		case "apple":
			System.out.println("���");
			break;
		case "banana":
			System.out.println("�ٳ���");
			break;
		case "orenge":
			System.out.println("������");
			break;
		default:
			System.out.println("��������");
			
		}	
		sc.close();
	}

}
