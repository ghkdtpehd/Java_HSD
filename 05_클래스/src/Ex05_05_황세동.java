import java.util.Scanner;

class Student{
	String name;
	int kor,eng,math;
	
	//합계 메서드
	//평균 메서드
	int total() {
		return kor+eng+math;
	}
	double avg() {
		return (double)(kor+eng+math)/3;
	}
}

public class Ex05_05_황세동 {
	public static void main(String[] args) {
		//이름 국 영 수 입력
		Scanner sc = new Scanner(System.in);
		Student std = new Student();
		
		System.out.print("이름:");
		std.name = sc.next();
		System.out.print("국어점수:");
		std.kor = sc.nextInt();
		System.out.print("영어점수:");
		std.eng = sc.nextInt();
		System.out.print("수학점수:");
		std.math = sc.nextInt();
		
		System.out.println("합계: "+std.total());
		System.out.printf("평균: %.2f",std.avg());
		
		sc.close();
	}
}