public class Ex05_03_메서드 {
	public static void main(String[] args) {
		prn();
		System.out.println("sub:"+sub(30.2, 1.3, 7));
		System.out.println("sum:"+sum(14,25));
		
		Ex05_03_메서드 ex = new Ex05_03_메서드();
		ex.mul();
		
		System.out.println("끝");
	}

	public static int sum(int a, int b) {
		return a + b;
	}

	static double sub(double a, double b, double c) {
		return a - b - c;
	}

	static void prn() {
		System.out.println("Print");
	}
	
	void mul() {
		System.out.println("mul");
	}
}