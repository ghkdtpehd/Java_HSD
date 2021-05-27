import java.util.HashSet;
import java.util.Iterator;

public class Ex10_10_HashSet {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		
		set.add("����");
		set.add("����");
		set.add("Ƽ�Ĵ�");
		set.add("����");
		
		System.out.println(set);
		
		System.out.println(set.contains("����"));
		System.out.println(set.contains("���"));
		
		System.out.println();
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
//List > ArrayList, Vector
//���� ����, �ߺ� O
//Set > HashSet
//���� ����
//�ߺ� ���x