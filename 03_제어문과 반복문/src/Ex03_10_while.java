public class Ex03_10_while {
	public static void main(String[] args) {
		//1~5 Ãâ·Â
		int i=1;
		for(i=1;i<=5;i++) {
			System.out.println("for:"+i);
		}
		
		i=1;
		while(i<=5) {
			System.out.println("while:"+i);
			i++;
		}
		
		i=0;
		do {
			System.out.println("do:"+i);
			i++;
		}
		while(i<10);
	}
}
