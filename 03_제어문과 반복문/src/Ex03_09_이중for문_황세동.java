public class Ex03_09_이중for문_황세동 {
	public static void main(String[] args) {
		for(int i=0;i<5;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=0;i<5;i++) {
			for(int j=4;j>i;j--) {
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//과제 1
		System.out.println("과1");
		for(int i=0;i<5;i++) {
			for(int j=0;j<i;j++) {
				System.out.print(" ");
			}
			for(int j=5;j>i;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		//과제2
		System.out.println("과2");
		for(int i=0;i<5;i++) {
			for(int j=5;j>i;j--) {
				System.out.print("*");
			}
			for(int j=0;j<=i;j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
		
		// 마름모
		for(int i=0;i<5;i++) {
			for(int j=4;j>i;j--) {
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			for(int j=0;j+1<=i;j++) {
				System.out.print("*");
			}
			for(int j=0;j+1<i;j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
		for(int i=0;i<4;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print(" ");
			}
			for(int j=4;j>i;j--) {
				System.out.print("*");
			}
			for(int j=4;j-1>i;j--) {
				System.out.print("*");
			}
			for(int j=0;j-1<=i;j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}