import java.util.Scanner;

public class Ex03_02_ifelse {
	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);

		System.out.println("�����Է��ϼ���.");
		num = sc.nextInt();

		if (num <= 10 || num >= 0) {
			System.out.println("1~10���� ����");
		} else if (num <= 20 || num > 10) {
			System.out.println("11~20���� ����");
		} else {
			System.out.println("0~20�� �ƴ� ���� ����");
		}

		if (num % 5 == 0) {
			System.out.println("5�� ���");
			if (num % 10 == 0) {
				System.out.println("10�� ���");
			} else {
				System.out.println("10�� ��� �ƴ�");
			}
		}
		sc.close();
	}

}
