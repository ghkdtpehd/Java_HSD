import java.util.Scanner;

public class Ex03_01_ifelse {
	public static void main(String[] args) {
		int num1,num2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자1");
		num1 = sc.nextInt();
		System.out.println("숫자2");
		num2 = sc.nextInt();
		
		if(num1>num2) {
			System.out.println("num1이 더큼");
		}else {
			System.out.println("num2이 더큼");
		}
		
		if(num1>num2) {
			System.out.println("num1이 더큼");
		}
		if(num1<num2) {
			System.out.println("num2이 더큼");
		}
		sc.close();
	}

}
