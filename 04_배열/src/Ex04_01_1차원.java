public class Ex04_01_1���� {
	public static void main(String[] args) {
		int a = 1, b = 2, c = 3, d = 4, e = 5;

//		int[] x= {1,2,3,4,5};
//		int[] x= new int[] {1,2,3,4,5};
		int[] x = new int[5];

		System.out.println(x[0]);
		System.out.println(x[4]);

		System.out.println(x.length);

		for (int i = 0; i < 5; i++) {
			System.out.println(x[i]);
		}

		for (int temp : x) {
			System.out.println(x[temp]);
		}
	}
}