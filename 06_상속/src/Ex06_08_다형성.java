class Car{
	String color="white";
	int door;
	void drive(){
		System.out.println("drive");
	}
	void stop() {
		System.out.println("stop");
	}
}
class FireEngine extends Car{
	int door = 6;
	int wheel = 10;
	
	void drive() {
		System.out.println("FEdrive");
	}
	
	void water() {
		System.out.println("water");
	}
}
public class Ex06_08_������ {
	public static void main(String[] args) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water();
		car = fe;
		System.out.println(car.door);
		System.out.println(car.color);
		
		System.out.println(fe.door);
		System.out.println(fe.wheel);
		System.out.println(fe.color);
		
		car.drive();
		car.stop();
		// �ڽ� >> �θ� �϶� �θ� ���ǵ��� ���� �޼���� ����� �Ұ� �ϴ�.
		//		  ���� �ڽ��� �޼��尡 �켱 ȣ��ȴ�.
		
		System.out.println();
		
		//instanceof ��ȯ ���� ���� Ȯ�� ������
		if(car instanceof FireEngine) {
			System.out.println("��ȯ ����");
			fe2 = (FireEngine) car;
		}else {
			System.out.println("��ȯ �Ұ���");
		}
		
		fe2.drive();
		fe2.water();
		
	}
}