
public class Ex02_02_복합대입 {
	public static void main(String[] args) {
		int a = 10, b = 20, c = 30, d = 40, e = 50;
		char ch = 97; 
		System.out.println("a=" + a);

		a += 3;
		System.out.println("a=" + a);
		
		a += b;
		System.out.println("a=" + a);
		
		b -= 3;
		System.out.println("b=" + b);
		
		c *= 3;
		System.out.println("c=" + c);
		
		d /= 3;
		System.out.println("d=" + d);
		
		e %= 3;
		System.out.println("e=" + e);
		
		ch = (char)(ch+3);
		System.out.println("ch=" + ch);
		
		String fruit = "apple";
		System.out.println("fruit=" + fruit);
		
		fruit += "banana";
		System.out.println("fruit=" + fruit);
	}
}
