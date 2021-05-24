import java.util.Scanner;

public class Ex03_11_break_continue {
	public static void main(String[] args) {
		for(int i=1;i<=10;i++) {
			if(i==5) break;
			System.out.print(i+" ");
		}
		
		System.out.println();
		
		for(int i=1;i<=10;i++) {
			if(i==5) continue;
			System.out.print(i+" ");
		}
		
		System.out.println();
		
		int i=0;
		while(i<5) {
			++i;
			System.out.println(i+" ");
			if(i>5)break;
		}
		
		Scanner sc = new Scanner(System.in);
		int num,sum=0;
		while(true) {
			System.out.print("╪Ж ют╥б:");
			num = sc.nextInt();
			
			if(num<0) {
				break;
			}
			
			sum+=num;
			System.out.println("sum:"+sum);
		}
		sc.close();
	}
}