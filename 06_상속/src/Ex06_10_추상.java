abstract class Shape{
	Shape(){
		System.out.println("Shape");
	}
	abstract void draw();
	abstract void delete();
}
class Circle extends Shape{
	Circle(){
		System.out.println("Circle 생성자");
	}
	void draw() {
		System.out.println("원 그림");
	}
	void delete() {
		System.out.println("원 지움");
	}
}
class Rectangle extends Shape{
	Rectangle(){
		System.out.println("Rectangle 생성자");
	}
	void draw() {
		System.out.println("네모 그림");
	}
	void delete() {
		System.out.println("네모 지움");
	}
}
public class Ex06_10_추상 {
	public static void main(String[] args) {
		Circle c = new Circle();
		c.draw();
		c.delete();
		
		Rectangle r = new Rectangle();
		r.draw();
		r.delete();
		
	}
}