package com.javastudy;

import java.util.Date;

public class Test {
	public static void main(String[] args) {
		Car c= new Car(60,35);
		
		c.prnCar();
		
		Date d= new Date();
		System.out.println("d:"+d);
	}
}