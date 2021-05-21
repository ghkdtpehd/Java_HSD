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
public class Ex06_08_다형성 {
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
		// 자식 >> 부모 일때 부모에 정의되지 않은 메서드는 사용이 불가 하다.
		//		  또한 자식의 메서드가 우선 호출된다.
		
		System.out.println();
		
		//instanceof 변환 가능 여부 확인 연산자
		if(car instanceof FireEngine) {
			System.out.println("변환 가능");
			fe2 = (FireEngine) car;
		}else {
			System.out.println("변환 불가능");
		}
		
		fe2.drive();
		fe2.water();
		
	}
}