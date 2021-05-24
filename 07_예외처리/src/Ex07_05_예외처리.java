import java.util.InputMismatchException;
import java.util.Scanner;


public class Ex07_05_예외처리 {
	public static void main(String[] args) {
//		Math.max(3, 0);
//		double d = Math.random();
//		System.out.println(d);
//		System.out.println((int)(d*6+3));
		
		
//		17~62의 난수 62-17+1
		System.out.println((int)(Math.random()*46+17));
		
		int answer = (int)(Math.random()*100+1);
		int input;
		int count = 0;
		Scanner sc = new Scanner(System.in);
		
		do {
			try {
				input = sc.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("다시입력하세요");
				continue;
			}
			
			if(answer > input) {
				System.out.println("작음");
				count++;
			}else if(answer<input) {
				System.out.println("큼");
				count++;
			}else {
				System.out.println("맞음");
				System.out.println(count+"의 횟수");
				break;
			}
		}while(true);
	}
}