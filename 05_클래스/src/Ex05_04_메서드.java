class Calculator {
	int a;
	static int b;

	static int sum(int x, int y) {
		return x + y;
	}
	int sub(int x, int y) {
		return x - y;
	}
}

public class Ex05_04_¸Þ¼­µå {
	public static void main(String[] args) {
		Calculator cal = new Calculator();

		cal.a = 50;
		Calculator.b = 12;
		System.out.println(Calculator.sum(53, 67));
		System.out.println(cal.sub(235, 23));
	}
}