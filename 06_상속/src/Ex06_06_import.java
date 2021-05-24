import java.util.Date;

import com.javastudy.Car;

public class Ex06_06_import {
	public static void main(String[] args) {
		Car c= new Car(60,35);
		
		c.prnCar();
		
		Date d= new Date();
		System.out.println("d:"+d);
	}
}