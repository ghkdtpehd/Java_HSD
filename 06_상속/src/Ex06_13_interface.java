interface Camera {
	void takePhoto();
}
interface Mp3 {
	void playMp3();
}
interface Dmb {
	void viewTv();
}
class Shape2 {
	private int size;
	private String color;
	
	Shape2(int size,String color){
		this.size = size;
		this.color = color;
	}
	
	int getSize() {
		return size;
	}
	
	String getColor() {
		return color;
	}

}

class Phone extends Shape2 implements Camera,Mp3,Dmb{
	public void takePhoto() {
		System.out.println("사진");
	}
	public void playMp3() {
		System.out.println("음악");
	}
	public void viewTv() {
		System.out.println("티비");
	}
	Phone(int size,String color){
		super(size,color);
	}
}
public class Ex06_13_interface {
	public static void main(String[] args) {
		//인터페이스는 무조건 추상클레스만 들어갈수있고 변수는 무조건 상수가된다.
		//추상클레스는 완성된 메서드도 들어갈수있다.
		
		Phone p = new Phone(7,"blue");
		
		System.out.println("size: "+p.getSize());
		System.out.println("color: "+p.getColor());
		p.takePhoto();
		p.playMp3();
		p.viewTv();
	}
}