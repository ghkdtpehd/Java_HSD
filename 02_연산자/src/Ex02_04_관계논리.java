public class Ex02_04_관계논리 {
	public static void main(String[] args) {
		int a=10,b=20;
		
		boolean c= a<b;
		System.out.println("a<b:"+c);
		System.out.println(a==b);
		System.out.println(a!=b);
		
		boolean result = a>5 && b>5;
		System.out.println("result:"+result);
		
		result = a>5 || b>5;
		System.out.println("result:"+result);
		
	}

}
