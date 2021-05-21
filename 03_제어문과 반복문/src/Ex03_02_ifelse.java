import java.util.Scanner;

public class Ex03_02_ifelse {
	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);

		System.out.println("숫자입력하세요.");
		num = sc.nextInt();

		if (num <= 10 || num >= 0) {
			System.out.println("1~10사이 숫자");
		} else if (num <= 20 || num > 10) {
			System.out.println("11~20사이 숫자");
		} else {
			System.out.println("0~20이 아닌 숫자 숫자");
		}

		if (num % 5 == 0) {
			System.out.println("5의 배수");
			if (num % 10 == 0) {
				System.out.println("10의 배수");
			} else {
				System.out.println("10의 배수 아님");
			}
		}
		sc.close();
	}

}
