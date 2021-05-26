import java.util.StringTokenizer;

public class Ex09_09_Stringtokenizer {
	public static void main(String[] args) {
		String str = "1+2+3+4+5";
		
		StringTokenizer stz = new StringTokenizer(str,"+");
		int x=0,y=0;
		while(stz.hasMoreTokens()) {
			x+=Integer.parseInt(stz.nextToken());
		}
		System.out.println("x"+x);
		
		String[] strA=str.split("\\+");
		for(int i=0;i<strA.length;i++) {
			y+=Integer.parseInt(strA[i]);
		}
		
		System.out.println("y"+y);
	}
}