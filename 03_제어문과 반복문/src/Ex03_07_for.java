import java.util.Scanner;

public class Ex03_07_for {
	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
			System.out.println("java"+i);
		}
		
		for(int i=10;i<=14;i++) {
			System.out.println("apple");
			System.out.println("banana");
		}
		
		int sum=0;
		
		for(int i=1; i<=100;i++) {
			if(i%5==0) {
				sum+=i;
//				System.out.println(sum);
			}
		}
		System.out.println("5의배수 합:"+sum);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("구구단의 단을 선택해주세요.");
		int num = sc.nextInt();
		
//		for(int i=1;i<10;i++) {
//			System.out.println(num+"*"+i+"= "+(i*num));
//		}
		
		switch(num%2) {
			case 0:
				for(int i=1;i<10;i++) {
					System.out.println(num+"*"+i+"= "+(i*num));
				};
				break;
			case 1:System.out.println("짝수 단이 아닙니다.");break;
		}
		
		sc.close();
	}
}
