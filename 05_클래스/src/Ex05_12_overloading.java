public class Ex05_12_overloading {
	public static void main(String[] args) {
		Ex05_12_overloading e = new Ex05_12_overloading();
		e.plus(3,5);
		e.plus(1.1,2.2 );
	}

	void plus(int a,int b) {
		System.out.println(a+b);
	}
	void plus(double a,double b) {
		System.out.println(a+b);
	}
}