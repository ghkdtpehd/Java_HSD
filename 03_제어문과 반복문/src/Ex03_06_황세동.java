import java.util.Scanner;

public class Ex03_06_황세동 {
	public static void main(String[] args) {
		// 평균 70점대 C 80점대 B 90점대 A
		int kor, eng, math, total;
		double avg;
		String name, rank, rank2;

		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력해주세요.");
		name = sc.next();
		System.out.println("국어 점수를 입력해주세요.");
		kor = sc.nextInt();
		System.out.println("영어 점수를 입력해주세요.");
		eng = sc.nextInt();
		System.out.println("수학 점수를 입력해주세요.");
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
		System.out.println(" 이름  국어  영어  수학");
		System.out.println("------------------");
		System.out.println(name + "  " + kor + "  " + eng + "  " + math);
		System.out.println("------------------");
		System.out.println("총점: " + total);
		System.out.printf("평균: %.2f\n" + avg);
		System.out.println("------------------");
		System.out.println("학점: " + rank);
		System.out.println("학점2: " + rank2);

		sc.close();
	}
}
