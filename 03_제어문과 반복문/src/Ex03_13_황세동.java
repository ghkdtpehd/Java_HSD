public class Ex03_13_황세동 {
	public static void main(String[] args) {
		//for문 1~100 출력
		//10의 배수일때만 출력
		
		//1~10 =55
		//1~20 =210
		int num1=0,num2=0;
		for(int i=1;i<=100;i++) {
			num1+=i;
			if(i%10 == 0) {
				System.out.println("1~"+i+"= "+num1);
			}
		}
		
		System.out.println();

		//1~10 =55
		//11~20 =155
		for(int i=1;i<=100;i++) {
			num2+=i;
			if(i%10 == 0) {
				System.out.println(i-9+"~"+i+"= "+num2);
				num2=0;
			}
		}
	}

}
