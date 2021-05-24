
public class Ex01_02_정수형 {
	public static void main(String[] arg) {
		System.out.println(10);

		int a;
		a = 10;

		// int a = 10; 선언과 동시에 초기화
		System.out.println("a");
		System.out.println(a);

		byte b1, b2;
		b1 = 10;
		b2 = 20;

		System.out.println(b1);
		int b3; // byte b3 에러 발생 이유 : int보다 작은 크기의 자료형일 경우 연산시 int로 형변환이 되어 도출됨
		b3 = b1 + b2;
		System.out.println("b3="+b3);
		/*
		byte + byte = int
		short + short = int
		byre + short = int
		*/
		
		int c = 1000000;
		int d = 2000000;
		
		long result = c * (long) d;
		System.out.println("result="+result);
	}
}
