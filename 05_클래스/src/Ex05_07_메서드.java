public class Ex05_07_�޼��� {
	static void sub(int[] arr) {
		System.out.println("sub");
		for(int a : arr) {
			System.out.println(a);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {10,20,30};
		
		sub(arr);
	}
}