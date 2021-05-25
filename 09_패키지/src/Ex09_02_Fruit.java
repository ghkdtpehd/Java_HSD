class Fruit {
	private String name;
	private int price;
	
	Fruit(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	String getMenu() {
		return name+", "+price;
	}
	
	public boolean equals(Object obj) {
		Fruit f = (Fruit)obj;
		return this.price == f.price;
	}
}

public class Ex09_02_Fruit {
	public static void main(String[] args) {
		Fruit f1 = new Fruit("apple",300);
		Fruit f2 = new Fruit("grape",700);
		Fruit f3 = new Fruit("banana",300);
		
		System.out.println("f1 : "+f1.getMenu()); //apple ,300 
		System.out.println("f2 : "+f2.getMenu());
		System.out.println("f3 : "+f3.getMenu());
		
		System.out.println(f1.equals(f2)); //가격비교 => false
		System.out.println(f1.equals(f3)); //가격비교 => ture
	}	
}