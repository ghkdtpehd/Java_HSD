import java.util.HashSet;
import java.util.Iterator;

public class Ex10_10_HashSet {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		
		set.add("수영");
		set.add("유리");
		set.add("티파니");
		set.add("수영");
		
		System.out.println(set);
		
		System.out.println(set.contains("유리"));
		System.out.println(set.contains("써니"));
		
		System.out.println();
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
//List > ArrayList, Vector
//순서 있음, 중복 O
//Set > HashSet
//순서 없음
//중복 허용x