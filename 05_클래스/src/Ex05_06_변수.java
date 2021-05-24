class Count{
	static int a;
	int b;
	void increment() {
		int c=0;
		a++;
		b++;
		c++;
		System.out.println("static 변수 a:"+a);
		System.out.println("increment 변수 b:"+b);
		System.out.println("지역 변수 c:"+c);
		System.out.println();
	}
}

public class Ex05_06_변수 {
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
//매개변수 : 메서드를 호출할때 쓰이는 변수
//참조변수 : 매서드를 실행할때 받는 변수
//지역변수
//클래스변수
//인스턴스변수