import java.util.StringTokenizer;

public class Ex09_08_StringTokenizer {
	public static void main(String[] args) {
		StringTokenizer str = new StringTokenizer("2021/05,25#16:29",", /:");
		int count = str.countTokens();
		System.out.println("ÅäÅ« :"+count);
		
		while(str.hasMoreTokens()) {
			String token = str.nextToken();
			System.out.println("["+token+"]");
		}
	}
}