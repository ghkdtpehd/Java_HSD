class CarName{
	String model="";
	int year=0;
	
	CarName(String model,int year){
		this.model = model;
		this.year = year;
	}
}
class Car{
	CarName name;
	String color;
	
	Car(String model,int year,String color){
		this.name = new CarName(model,year);
		this.color = color;
	}
	
	void info() {
		System.out.println(name.model);
		System.out.println(name.year);
		System.out.println(color);
	}
}
public class Ex08_01_내부클래스사용안함 {
	public static void main(String[] args) {
		CarName sonata = new CarName("소나타",2011);
		
		System.out.println(sonata.model+", "+sonata.year);
		
		Car pride = new Car ("프라이드",2019,"파랑");
		
		System.out.println(pride.name.model+", "+pride.name.year+", "+pride.color);
		
		pride.info();
	}
}