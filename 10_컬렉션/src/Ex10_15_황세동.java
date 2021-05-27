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
public class Ex10_15_황세동 {
	public static void main(String[] args) {
		HashMap<String, Student> info = new HashMap<String, Student>();
		Scanner sc = new Scanner(System.in);
		
		//학생 정보 입력
		while(true) {
			System.out.print("이름 :");
			String name = sc.next();
			System.out.print("주소 :");
			String addr = sc.next();
			System.out.print("키 :");
			double height = sc.nextDouble();
			System.out.print("국어 :");
			int kor = sc.nextInt();
			
			info.put(name, new Student(addr, height, kor));
			
			System.out.print("계속?");
			String falg = sc.next();
			if(falg.equals("n")||falg.equals("N")) {
				break;
			}
		}
		
		
		
		//학생 정보 찾기
		while(true) {
			System.out.println(info);
			System.out.println();
			
			System.out.print("찾는 이름 :");
			String name = sc.next();
			
			if(info.get(name) == null) {
				System.out.println("해당 이름의 학생은 없습니다.");
			}else{
				System.out.println(info.get(name));
			}
			
			System.out.print("계속?");
			String falg = sc.next();
			if(falg.equals("n")||falg.equals("N")) {
				break;
			}
		}
		
		//학생 정보 삭제
		while(true) {
			System.out.println(info);
			
			System.out.println();
			
			System.out.print("삭제할 이름 :");
			String name = sc.next();
			
			if(info.get(name) == null) {
				System.out.println("해당 이름의 학생은 없습니다.");
			}else{
				info.remove(name);
				System.out.println(info);
			}
			
			System.out.print("계속?");
			String falg = sc.next();
			if(falg.equals("n")||falg.equals("N")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}