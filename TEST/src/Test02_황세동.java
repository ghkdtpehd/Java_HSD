import java.util.ArrayList;
import java.util.Scanner;

public class Test02_Ȳ���� {
	public static void main(String[] args) {
		ArrayList<Student_hsd> arr = new ArrayList<Student_hsd>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("�̸��Է� :");
			String name = sc.next();
			System.out.print("�����Է� :");
			int age = sc.nextInt();
			System.out.print("�ڹ��Է� :");
			int java = sc.nextInt();
			System.out.print("jsp�Է� :");
			int jsp = sc.nextInt();
			
			Student_hsd std = new Student_hsd(name,age,java,jsp);
			arr.add(std);
			
			System.out.println("*****************");
			System.out.println();
			
			System.out.print("���? ");
			String anr = sc.next();
			if(anr.equals("n")||anr.equals("N"))break;
		}
		
		System.out.println("ArrayList ����� ���");
		for(int i=0;i<arr.size();i++) {
			double avg = (double)(arr.get(i).getJava() + arr.get(i).getJsp()) / 2;
			
			System.out.print(arr.get(i).toString());
			System.out.printf("\t ���: %.1f \n",avg);
		}
		
		while(true) {
			boolean falg = false;
			System.out.print("ã�� �̸� :");
			String name = sc.next();
			
			for(int i=0;i<arr.size();i++) {
				if(arr.get(i).getName().equals(name)) {
					falg = true;
					System.out.println(arr.get(i).getAge()+", "+arr.get(i).getJava()+", "+arr.get(i).getJsp());
					break;
				}
			}
			
			if(!falg) {
				System.out.println("ã�� �̸� ����");
			}

			System.out.print("���? ");
			String anr = sc.next();
			if(anr.equals("n")||anr.equals("N")) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
		}
	}
}