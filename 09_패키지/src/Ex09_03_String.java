
public class Ex09_03_String {
	public static void main(String[] args) {
		String s1 = "nice day";
		String s2 = "nice Day";
		
		String s3 = new String("nice day");
		String s4 = new String("nice day");
		
		System.out.println(s1==s2);
		System.out.println(s3==s4);
		
		int len = s1.length();
		System.out.println("len : "+len);
		
		boolean eq = s1.equals(s2);
		System.out.println("eq : "+eq);

		boolean eq2 = s3.equals(s4);
		System.out.println("eq2 : "+eq2);
		
		eq = s1.equalsIgnoreCase(s2);
		System.out.println("eq : "+eq);
		
		int result = s1.compareTo(s2);
		System.out.println(result);
		
		result = s1.compareToIgnoreCase(s2);
		System.out.println(result);
		
		System.out.println(s1.charAt(6));
		
		System.out.println(s1.indexOf('e'));
		
		System.out.println();
		
		System.out.println(s1.substring(3,6));
		
		System.out.println();
		
		System.out.println(s1.replace('c', 's'));
		System.out.println(s1.contains("nic"));
		
		String s5 = "  abc  ED  Fg h  ";
		System.out.println(s5.length());
		System.out.println(s5);
		String s6 = s5.trim();
		System.out.println(s6);
		System.out.println(s6.length());
		
		System.out.println();
		
		String fullName = "hello.java";
		String fileName = fullName.substring(0,fullName.indexOf("."));
		String ext = fullName.substring(fullName.indexOf(".")+1);
		
		System.out.println("fileName : "+fileName);
		System.out.println("ext : "+ext);
		
		String s7 = "rose,tulip,lily";
		String[] token = s7.split(",");
		for(int i=0;i<token.length;i++) {
			System.out.println(token[i]);
		}
	}
}