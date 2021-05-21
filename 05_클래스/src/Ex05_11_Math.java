public class Ex05_11_Math {
	public static void main(String[] args) {
		int a=30,b=40,c;
		c= Math.max(a,b);
		System.out.println(c);
	}
	static int max(int x,int y) {
		int a=x;
		if(y>x)a=y;
		return a;
	}
}