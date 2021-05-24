public class Ex03_08_이중for문 {
	public static void main(String[] args) {
		for(int i=1;i<=3;i++) {
			for(int j=5;j<=7;j++) {
				System.out.println(i+","+j);
			}
		}

		System.out.println();
		
		System.out.println("구구단 세로 출력");
		
		for(int i=2;i<=9;i++) {
			System.out.println("****"+i+"단****");
			for(int j=1;j<=9;j++) {
				System.out.println(i+"*"+j+"="+i*j);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("구구단 가로 출력");
		
		for(int i=1;i<=9;i++) {
			for(int j=2;j<=9;j++) {
				System.out.print(j+"*"+i+"="+i*j+"\t");
			}
			System.out.println();
		}
		
	}
}