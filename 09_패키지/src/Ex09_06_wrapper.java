
public class Ex09_06_wrapper {
	public static void main(String[] args) {
		int[] num = {1,2,3,4,5};
		
		String[] str = {"1","2","3","4","5"};
		
		int x=0;
		for(int i=0;i<str.length;i++) {
			x+=Integer.parseInt(str[i]);
		}
		
		System.out.println(x);
		
		String[] str2 = {"아이유:30","웬디:90","크리스탈:70"};
		
		int total =0;
		
		for(int i=0;i<str2.length;i++) {
			total += Integer.parseInt(str2[i].substring(str2[i].indexOf(":")+1));
		}
		
		System.out.println("합계점수"+total);
	}
}
