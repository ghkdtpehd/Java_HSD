
public class Ex01_04_실수형 {
	public static void main(String[] args) {
		float f1;
		f1 = 1.234f;
		
		double d1;
		d1 = 1.234;
		
		System.out.println("f1:"+f1);
		System.out.println("d1:"+d1);
		
		float f2 = 0.12000f;
		System.out.println("f2:"+f2);
		
		float f3 = 1.123456789f;
		System.out.println("f3:"+f3);
		
		double d2 = .889E5;
		System.out.println("d2:"+d2);
		
		double d3 = .889E-5;
		System.out.println("d3:"+d3);
		
		float f4 = 3.567f;
		int i = (int)f4;	//강제형변환
		System.out.println("i:"+i);
		
		int i2 = 34;
		f4 = i2;
		System.out.println("f4:"+f4);
		
		f4 = (float) d3;
		System.out.println("f4:"+f4);
		
		double d4 = 1.1234567890111214741516;
		System.out.println("d4:"+d4);
	}

}
