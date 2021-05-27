import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Ex10_12_HashMap {
	public static void main(String[] args) {
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		
		hm.put("진", 89);
		hm.put("지민", 98);
		hm.put("정국", 56);
		hm.put("지민", 35);
		
		System.out.println(hm);
		Integer intg = hm.get("정국");
		System.out.println(intg);
		
		//이름입력
		//이름의 점수는!!입니다.
		
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next();
		
		if(hm.get(name) != null) {
			System.out.println(name +"의 점수는 " +hm.get(name)+" 점 입니다.");
		}else {
			System.out.println("등록되지 않은 이름입니다.");
		}
		
		
		System.out.println(hm.containsKey("슈가"));
		System.out.println(hm.containsKey("제이홉"));
		
		System.out.println(hm.containsValue("슈가"));
		System.out.println(hm.containsValue(92));
		
		Set<String> key = hm.keySet();
		System.out.println(key);
		
		Iterator it = key.iterator();
		while (it.hasNext()) {
			String s = it.next().toString();
			System.out.println(s +" : "+hm.get(s));
		}
		
		hm.remove("슈가");
		System.out.println(hm);
	}
}