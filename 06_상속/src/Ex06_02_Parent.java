class Parent{
	int x=10;
	void method() {
		System.out.println("P_x:"+x);
	}
}
class Child extends Parent{
	int x=20;
	void method() {
		x=30;
		System.out.println("x:"+x);
		System.out.println("this.x:"+this.x);
		System.out.println("super.x:"+super.x);
		
		super.method();
	}
}
public class Ex06_02_Parent {
	public static void main(String[] args) {
		Parent p = new Parent();
		p.method();
		System.out.println();
		Child c = new Child();
		c.method();
	}
}