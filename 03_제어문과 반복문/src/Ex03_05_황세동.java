import java.util.Scanner;

public class Ex03_05_Ȳ���� {
	public static void main(String[] args) {
		// ���� - switch ~ case
		// m,M Morning
		// a,A Afternoon
		// e,E Evening
		Scanner sc = new Scanner(System.in);
		System.out.println("m a e�� �ϳ��� �Է����ּ���.");
		char ch = sc.next().charAt(0);


		System.out.println("if������ �۵����Դϴ�.");

		if (ch == 'm' || ch == 'M') { 		// 109 , 77
			System.out.println("Morning");
		} else if (ch == 'a' || ch == 'A') { 	// 97 65
			System.out.println("Afternoon");
		} else if (ch == 'e' || ch == 'E') {	// 101 69
			System.out.println("Evening");
		}else {
			System.out.println("�߸��Է��ϼ̽��ϴ�.");
		}

		System.out.println("------------------");
		System.out.println("switch������ �۵����Դϴ�.");
		switch (ch) {
		case 'm':
		case 'M':
			System.out.println("Morning");
			break;
		case 'a':
			System.out.println("Afternoon");
			break;
		case 'A':
			System.out.println("Afternoon");
			break;
		case 'E':
			System.out.println("Evening");
			break;
		case 'e':
			System.out.println("Evening");
			break;
		default:
			System.out.println("�߸��Է��ϼ̽��ϴ�.");
		}
		
		sc.close();
	}
}
