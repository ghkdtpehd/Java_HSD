import java.util.Scanner;

public class Ex02_01_��� {
	public static void main(String[] args) {
		//���� 2�� �Է¹޾� num1, num2 ������ �ֱ�
		int num1,num2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� 2���� �Է����ּ���.");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		System.out.println("�Է��� ���� 2���� "+num1+", "+num2+"�Դϴ�.");
		
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
