import java.util.Scanner;

public class Ex02_01_산술 {
	public static void main(String[] args) {
		//정수 2개 입력받아 num1, num2 변수에 넣기
		int num1,num2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 2개를 입력해주세요.");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		System.out.println("입력한 정수 2개는 "+num1+", "+num2+"입니다.");
		
		int pl = num1 + num2;
		int mi = num1 - num2;
		int x = num1 * num2;
		double l = (double)num1 / num2;
		
		System.out.println(num1 + " + "+num2+" = "+pl);
		System.out.println(num1 + " - "+num2+" = "+mi);
		System.out.println(num1 + " x "+num2+" = "+x);
		System.out.println(num1 + " / "+num2+" = "+l);
		
		System.out.println(num1 + " % "+num2+" = "+(num1 % num2));
		sc.close();
	}

}
