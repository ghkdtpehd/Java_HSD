import java.util.HashSet;

public class Ex10_11_HashSet {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		
		int[] arr = new int[6];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*10+1);
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("-------------");
		
		for(int i=0;hs.size()<=5;i++) {
			int a = (int)(Math.random()*10+1);
			hs.add(a);
		}
		
		System.out.println(hs);
		
		System.out.println("-------------");
		
		hs.clear();
		
		while (hs.size()<=5) {
			hs.add((int)(Math.random()*10+1));
		}
		System.out.println(hs);
		
		
	}
}