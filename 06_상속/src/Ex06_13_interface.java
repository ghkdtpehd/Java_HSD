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
		System.out.println("����");
	}
	public void playMp3() {
		System.out.println("����");
	}
	public void viewTv() {
		System.out.println("Ƽ��");
	}
	Phone(int size,String color){
		super(size,color);
	}
}
public class Ex06_13_interface {
	public static void main(String[] args) {
		//�������̽��� ������ �߻�Ŭ������ �����ְ� ������ ������ ������ȴ�.
		//�߻�Ŭ������ �ϼ��� �޼��嵵 �����ִ�.
		
		Phone p = new Phone(7,"blue");
		
		System.out.println("size: "+p.getSize());
		System.out.println("color: "+p.getColor());
		p.takePhoto();
		p.playMp3();
		p.viewTv();
	}
}