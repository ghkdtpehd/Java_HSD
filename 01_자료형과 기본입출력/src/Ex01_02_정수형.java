
public class Ex01_02_������ {
	public static void main(String[] arg) {
		System.out.println(10);

		int a;
		a = 10;

		// int a = 10; ����� ���ÿ� �ʱ�ȭ
		System.out.println("a");
		System.out.println(a);

		byte b1, b2;
		b1 = 10;
		b2 = 20;

		System.out.println(b1);
		int b3; // byte b3 ���� �߻� ���� : int���� ���� ũ���� �ڷ����� ��� ����� int�� ����ȯ�� �Ǿ� �����
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
