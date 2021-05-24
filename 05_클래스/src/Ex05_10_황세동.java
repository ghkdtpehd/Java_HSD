import java.util.Scanner;

public class Ex05_10_황세동 {
	public static void main(String[] args) {
		// 숫자 정수 2개 입력
		// x의 y승을 구하라
		int x, y;
		Scanner sc = new Scanner(System.in);

		System.out.println("숫자를 입력해주세요.");
		System.out.print("x : ");
		x = sc.nextInt();
		System.out.print("y : ");
		y = sc.nextInt();

		System.out.print(x + "의 " + y + "승은 " + mul(x, y) + "입니다.");
		
		sc.close();
	}

	static int mul(int x, int y) {
		// for문

		/*
		 *  int num=1;
		 *  for(int i = y;i>1;i--) {
		 * 		num *= x; 
		 *  } 
		 *  return num;
		 */

		if (y == 0)
			return 1;
		else
			return x * mul(x, y - 1);
	}
}