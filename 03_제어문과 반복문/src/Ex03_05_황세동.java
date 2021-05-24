import java.util.Scanner;

public class Ex03_05_황세동 {
	public static void main(String[] args) {
		// 과제 - switch ~ case
		// m,M Morning
		// a,A Afternoon
		// e,E Evening
		Scanner sc = new Scanner(System.in);
		System.out.println("m a e중 하나를 입력해주세요.");
		char ch = sc.next().charAt(0);


		System.out.println("if문으로 작동중입니다.");

		if (ch == 'm' || ch == 'M') { 		// 109 , 77
			System.out.println("Morning");
		} else if (ch == 'a' || ch == 'A') { 	// 97 65
			System.out.println("Afternoon");
		} else if (ch == 'e' || ch == 'E') {	// 101 69
			System.out.println("Evening");
		}else {
			System.out.println("잘못입력하셨습니다.");
		}

		System.out.println("------------------");
		System.out.println("switch문으로 작동중입니다.");
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
			System.out.println("잘못입력하셨습니다.");
		}
		
		sc.close();
	}
}
