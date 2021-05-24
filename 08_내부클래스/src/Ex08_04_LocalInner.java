
class Car4 {
	int wheel;
	void Drive() {
		System.out.println("ºÎ¸ª ºÎ¸ª");
	}
}

public class Ex08_04_LocalInner {
	public static void main(String[] args) {
		class Truck extends Car4 {
			void Drive() {
				final int door=4;
				System.out.println("¿ì´çÅÁ ÄôÅÁ");
				System.out.println("wheel:"+wheel);
			}

		} // Truck Å¬·¡½ºÀÇ ³¡

		Truck porter = new Truck();
		porter.wheel = 8;
		System.out.println("wheel:"+porter.wheel);
		porter.Drive(); // ¿ì´çÅÁ ÄôÅÁ
	}
	
	Ex08_04_LocalInner e = new Ex08_04_LocalInner();
}

