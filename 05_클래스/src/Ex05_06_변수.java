class Count{
	static int a;
	int b;
	void increment() {
		int c=0;
		a++;
		b++;
		c++;
		System.out.println("static ���� a:"+a);
		System.out.println("increment ���� b:"+b);
		System.out.println("���� ���� c:"+c);
		System.out.println();
	}
}

public class Ex05_06_���� {
	public static void main(String[] args) {
		Count cnt1 = new Count();
		cnt1.increment();
		cnt1.increment();
		
		Count cnt2 = new Count();
		cnt2.increment();
		cnt2.increment();
		
		Count cnt3 = new Count();
		cnt3.increment();
		cnt3.increment();
	}
}
//�Ű����� : �޼��带 ȣ���Ҷ� ���̴� ����
//�������� : �ż��带 �����Ҷ� �޴� ����
//��������
//Ŭ��������
//�ν��Ͻ�����