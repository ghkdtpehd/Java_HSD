class Car1 {
	 Car1name name;
	 String color;

	static class Car1name {
		static String model;  
		int year;
		Car1name(String model, int year) {
			this.model = model; 
			this.year = year;
		}
		Car1name(){
			
		}
		
	} // static inner�� ��

	Car1(String model, int year, String color) {
		this.name = new Car1name(model,year);
		this.color = color;
		//Car1name.model = "a";
	}
	Car1(){
		
	}
	void OutInfo() {
		System.out.printf("�� = %s, ��� = %d, ���� = %s\n",
				name.model, name.year, color);
	}
}

public class Ex08_02_staticInner {
	public static void main(String[] args) {
		Car1 pride = new Car1("�����̵�", 2005, "�Ķ�");
		pride.OutInfo(); 
		System.out.println(pride.color);
		System.out.println(pride.name.model);
		System.out.println(pride.name.year);
		System.out.println();
		
		Car1 pride2 = new Car1();
		System.out.println(pride2.name.model);   
//		System.out.println(pride2.name.year);
		
		System.out.println("=====================");
		
		Car1.Car1name sonata = new Car1.Car1name("�ҳ�Ÿ", 2009);
		System.out.printf("�� = %s, ��� = %d\n", sonata.model,sonata.year);
		// �� = �ҳ�Ÿ, ��� = 2009

		Car1.Car1name sonata2 = new Car1.Car1name();
		System.out.printf("�� = %s, ��� = %d\n", sonata2.model,sonata2.year);
	}
}

