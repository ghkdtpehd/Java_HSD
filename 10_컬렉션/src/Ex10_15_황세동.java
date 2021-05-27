import java.util.HashMap;
import java.util.Scanner;

class Student{
	private String addr;
	private double height;
	private int kor;
	
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public Student(String addr, double height, int kor) {
		this.addr = addr;
		this.height = height;
		this.kor = kor;
	}

	public String toString() {
		return addr + " / " + height + " / " + kor;
	}
}
public class Ex10_15_Ȳ���� {
	public static void main(String[] args) {
		HashMap<String, Student> info = new HashMap<String, Student>();
		Scanner sc = new Scanner(System.in);
		
		//�л� ���� �Է�
		while(true) {
			System.out.print("�̸� :");
			String name = sc.next();
			System.out.print("�ּ� :");
			String addr = sc.next();
			System.out.print("Ű :");
			double height = sc.nextDouble();
			System.out.print("���� :");
			int kor = sc.nextInt();
			
			info.put(name, new Student(addr, height, kor));
			
			System.out.print("���?");
			String falg = sc.next();
			if(falg.equals("n")||falg.equals("N")) {
				break;
			}
		}
		
		
		
		//�л� ���� ã��
		while(true) {
			System.out.println(info);
			System.out.println();
			
			System.out.print("ã�� �̸� :");
			String name = sc.next();
			
			if(info.get(name) == null) {
				System.out.println("�ش� �̸��� �л��� �����ϴ�.");
			}else{
				System.out.println(info.get(name));
			}
			
			System.out.print("���?");
			String falg = sc.next();
			if(falg.equals("n")||falg.equals("N")) {
				break;
			}
		}
		
		//�л� ���� ����
		while(true) {
			System.out.println(info);
			
			System.out.println();
			
			System.out.print("������ �̸� :");
			String name = sc.next();
			
			if(info.get(name) == null) {
				System.out.println("�ش� �̸��� �л��� �����ϴ�.");
			}else{
				info.remove(name);
				System.out.println(info);
			}
			
			System.out.print("���?");
			String falg = sc.next();
			if(falg.equals("n")||falg.equals("N")) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
		}
	}
}