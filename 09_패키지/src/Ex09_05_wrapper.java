
public class Ex09_05_wrapper {

	public static void main(String[] args) {
//		Integer it1 = new Integer(11);
		Integer it1 = 11; // 11 => new Integer(11) autoboxing
		Integer it2 = 12;
		System.out.println(it1+it2);
		
		System.out.println("100"+"200");
		int i = Integer.parseInt("100");
		int j = Integer.parseInt("100");
		System.out.println(i+j);
		
		Integer ii = Integer.valueOf("100");
		Integer jj = Integer.valueOf("200");
		System.out.println(ii+jj);
		
		double d = Double.parseDouble("123.4");
	}

}
