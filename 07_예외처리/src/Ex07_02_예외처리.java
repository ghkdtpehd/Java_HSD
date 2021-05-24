import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex07_02_����ó�� {
	public static void main(String[] args) {
		int x,y;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("����1");
		x=sc.nextInt();
		System.out.println("����2");
		y=sc.nextInt();
		
		System.out.println(diviad(x,y));
		
	}

	public static int diviad(int x, int y) {
		try {
			return x/y;
		}catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			return 0;
		}finally {
			System.out.println("finally");
		}
	}
}