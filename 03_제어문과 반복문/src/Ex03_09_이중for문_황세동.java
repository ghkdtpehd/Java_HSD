public class Ex03_09_����for��_Ȳ���� {
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
		
		//���� 1
		System.out.println("��1");
		for(int i=0;i<5;i++) {
			for(int j=0;j<i;j++) {
				System.out.print(" ");
			}
			for(int j=5;j>i;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		//����2
		System.out.println("��2");
		for(int i=0;i<5;i++) {
			for(int j=5;j>i;j--) {
				System.out.print("*");
			}
			for(int j=0;j<=i;j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
		
		// ������
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