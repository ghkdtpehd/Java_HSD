import java.util.InputMismatchException;
import java.util.Scanner;


public class Ex07_05_����ó�� {
	public static void main(String[] args) {
//		Math.max(3, 0);
//		double d = Math.random();
//		System.out.println(d);
//		System.out.println((int)(d*6+3));
		
		
//		17~62�� ���� 62-17+1
		System.out.println((int)(Math.random()*46+17));
		
		int answer = (int)(Math.random()*100+1);
		int input;
		int count = 0;
		Scanner sc = new Scanner(System.in);
		
		do {
			try {
				input = sc.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("�ٽ��Է��ϼ���");
				continue;
			}
			
			if(answer > input) {
				System.out.println("����");
				count++;
			}else if(answer<input) {
				System.out.println("ŭ");
				count++;
			}else {
				System.out.println("����");
				System.out.println(count+"�� Ƚ��");
				break;
			}
		}while(true);
	}
}