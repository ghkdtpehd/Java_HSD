class Car2 {
	Car2name name;
	String color;

	class Car2name {
		String model;
		int year;
		Car2name(String model, int year) {
			this.model = model;
			this.year = year;
		}

		Car2name(String model, int year, String col) {
			this.model = model;
			this.year = year;
			color = col; 
		}

		void Outcolor() {
			System.out.println("model:"+model+" ����:"+year+" ����:" + color + "�Դϴ�.");
		}
	}

	Car2(String model, int year, String color) {
		name = new Car2name(model,year);
		this.color = color;
	}

	void OutInfo() {
		System.out.printf("�� = %s, ��� = %d, ���� = %s\n",
				name.model, name.year, color);
	}
}

public class Ex08_03_InstanceInner {
	public static void main(String[] args) {
		Car2 pride = new Car2("�����̵�", 2019, "�Ķ�");
		pride.OutInfo(); 
		System.out.println();
		
		pride.name.Outcolor(); 
		System.out.println();
		
		//Outer.Inner ������ = �ܺΰ�ü.new Inner(������ �μ�)
		Car2.Car2name pride2 = pride.new Car2name("������", 2009);
		pride2.Outcolor(); 
		System.out.println();
		
		Car2.Car2name pride3 = pride.new Car2name("���������", 2015,"���");
		pride3.Outcolor();
		System.out.println();
		
		pride.OutInfo(); 
		System.out.println();
		
		pride.name.Outcolor();
		
	}
}