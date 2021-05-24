class Test{
	int x=2;
	void display() {
		System.out.println(x);
	}
}
class Test2 extends Test{
	void display() {
		System.out.println(x*x);
	}
}
public class Ex08_05_Anonymous {
	public static void main(String[] args) {
		Test t1= new Test();
		t1.display();
		Test2 t2= new Test2();
		t2.display();
		
		new Test() {
			void display() {
				System.out.println(x*x*x);
			}
		}.display();
		
	}
}