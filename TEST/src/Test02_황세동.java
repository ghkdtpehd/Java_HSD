import java.util.ArrayList;
import java.util.Scanner;

public class Test02_황세동 {
	public static void main(String[] args) {
		ArrayList<Student_hsd> arr = new ArrayList<Student_hsd>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("이름입력 :");
			String name = sc.next();
			System.out.print("나이입력 :");
			int age = sc.nextInt();
			System.out.print("자바입력 :");
			int java = sc.nextInt();
			System.out.print("jsp입력 :");
			int jsp = sc.nextInt();
			
			Student_hsd std = new Student_hsd(name,age,java,jsp);
			arr.add(std);
			
			System.out.println("*****************");
			System.out.println();
			
			System.out.print("계속? ");
			String anr = sc.next();
			if(anr.equals("n")||anr.equals("N"))break;
		}
		
		System.out.println("ArrayList 사용한 결과");
		for(int i=0;i<arr.size();i++) {
			double avg = (double)(arr.get(i).getJava() + arr.get(i).getJsp()) / 2;
			
			System.out.print(arr.get(i).toString());
			System.out.printf("\t 평균: %.1f \n",avg);
		}
		
		while(true) {
			boolean falg = false;
			System.out.print("찾는 이름 :");
			String name = sc.next();
			
			for(int i=0;i<arr.size();i++) {
				if(arr.get(i).getName().equals(name)) {
					falg = true;
					System.out.println(arr.get(i).getAge()+", "+arr.get(i).getJava()+", "+arr.get(i).getJsp());
					break;
				}
			}
			
			if(!falg) {
				System.out.println("찾는 이름 없음");
			}

			System.out.print("계속? ");
			String anr = sc.next();
			if(anr.equals("n")||anr.equals("N")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}