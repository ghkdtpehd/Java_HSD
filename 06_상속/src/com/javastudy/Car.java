package com.javastudy;

public class Car {
	private int speed;
	private int direction;
	
	public Car(int speed, int direction){
		this.speed = speed;
		this.direction = direction;
	}
	
	public void prnCar() {
		System.out.println("�ӵ�"+speed);
		System.out.println("����"+direction);
	}
}
