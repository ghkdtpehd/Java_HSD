public class Ex03_13_Ȳ���� {
	public static void main(String[] args) {
		//for�� 1~100 ���
		//10�� ����϶��� ���
		
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
