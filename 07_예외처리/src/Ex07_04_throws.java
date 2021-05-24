
public class Ex07_04_throws {
	public static void main(String[] args) {
		System.out.println("start");
		try {
			call();
		}catch(ArithmeticException e) {
			System.out.println(e);
		}
	}

	static void call() throws ArithmeticException{
		int result = 7/0;
	}
}