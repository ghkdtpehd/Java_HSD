import java.util.Scanner;

public class Ex04_04_�迭�Է� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�����Է�: ");
		
		int num=sc.nextInt(); 
		System.out.println("�Է��� ���ڴ�"+num+"�Դϴ�.");
		
		int[] arr = new int[3];
		
		for(int i=0;i<arr.length;i++) {
			System.out.print("�Է� :");
			arr[i] = sc.nextInt();
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
	}
}