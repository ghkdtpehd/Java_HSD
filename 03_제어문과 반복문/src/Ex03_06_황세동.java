import java.util.Scanner;

public class Ex03_06_Ȳ���� {
	public static void main(String[] args) {
		// ��� 70���� C 80���� B 90���� A
		int kor, eng, math, total;
		double avg;
		String name, rank, rank2;

		Scanner sc = new Scanner(System.in);
		System.out.println("�̸��� �Է����ּ���.");
		name = sc.next();
		System.out.println("���� ������ �Է����ּ���.");
		kor = sc.nextInt();
		System.out.println("���� ������ �Է����ּ���.");
		eng = sc.nextInt();
		System.out.println("���� ������ �Է����ּ���.");
		math = sc.nextInt();

		total = kor + eng + math;
		avg = (double) total / 3;

		if (avg >= 90) {
			rank = "A";
		} else if (avg >= 80 && avg < 90) {
			rank = "B";
		} else if (avg >= 70 && avg < 80) {
			rank = "C";
		} else if (avg >= 60 && avg < 70) {
			rank = "D";
		} else {
			rank = "F";
		}

		switch ((int) avg / 10) {
		case 10:
		case 9:
			rank2 = "A";
			break;
		case 8:
			rank2 = "B";
			break;
		case 7:
			rank2 = "C";
			break;
		case 6:
			rank2 = "D";
			break;
		default:
			rank2 = "F";
		}

		System.out.println();
		System.out.println("------------------");
		System.out.println(" �̸�  ����  ����  ����");
		System.out.println("------------------");
		System.out.println(name + "  " + kor + "  " + eng + "  " + math);
		System.out.println("------------------");
		System.out.println("����: " + total);
		System.out.printf("���: %.2f\n" + avg);
		System.out.println("------------------");
		System.out.println("����: " + rank);
		System.out.println("����2: " + rank2);

		sc.close();
	}
}
