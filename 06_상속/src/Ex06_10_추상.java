abstract class Shape{
	Shape(){
		System.out.println("Shape");
	}
	abstract void draw();
	abstract void delete();
}
class Circle extends Shape{
	Circle(){
		System.out.println("Circle ������");
	}
	void draw() {
		System.out.println("�� �׸�");
	}
	void delete() {
		System.out.println("�� ����");
	}
}
class Rectangle extends Shape{
	Rectangle(){
		System.out.println("Rectangle ������");
	}
	void draw() {
		System.out.println("�׸� �׸�");
	}
	void delete() {
		System.out.println("�׸� ����");
	}
}
public class Ex06_10_�߻� {
	public static void main(String[] args) {
		Circle c = new Circle();
		c.draw();
		c.delete();
		
		Rectangle r = new Rectangle();
		r.draw();
		r.delete();
		
	}
}