import java.util.Scanner;

public class Ex03_01_ifelse {
	public static void main(String[] args) {
		int num1,num2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("����1");
		num1 = sc.nextInt();
		System.out.println("����2");
		num2 = sc.nextInt();
		
		if(num1>num2) {
			System.out.println("num1�� ��ŭ");
		}else {
			System.out.println("num2�� ��ŭ");
		}
		
		if(num1>num2) {
			System.out.println("num1�� ��ŭ");
		}
		if(num1<num2) {
			System.out.println("num2�� ��ŭ");
		}
		sc.close();
	}

}
