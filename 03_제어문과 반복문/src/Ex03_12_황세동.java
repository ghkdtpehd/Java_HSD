public class Ex03_12_Ȳ���� {
	public static void main(String[] args) {
		for(int i=2;i<=9;i++) {
			if(i%2 != 0) {
				continue;
			}
			for(int j=1;j<=9;j++) {
				if(j>i) {
					break;
				}
				System.out.println(i+"*"+j+"="+i*j);
			}
			System.out.println();
		}
	}
}
