import java.util.Scanner;

public class Ex04_04_배열입력 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자입력: ");
		
		int num=sc.nextInt(); 
		System.out.println("입력한 숫자는"+num+"입니다.");
		
		int[] arr = new int[3];
		
		for(int i=0;i<arr.length;i++) {
			System.out.print("입력 :");
			arr[i] = sc.nextInt();
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
	}
}