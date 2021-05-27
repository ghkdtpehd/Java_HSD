import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Ex10_12_HashMap {
	public static void main(String[] args) {
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		
		hm.put("��", 89);
		hm.put("����", 98);
		hm.put("����", 56);
		hm.put("����", 35);
		
		System.out.println(hm);
		Integer intg = hm.get("����");
		System.out.println(intg);
		
		//�̸��Է�
		//�̸��� ������!!�Դϴ�.
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = sc.next();
		
		if(hm.get(name) != null) {
			System.out.println(name +"�� ������ " +hm.get(name)+" �� �Դϴ�.");
		}else {
			System.out.println("��ϵ��� ���� �̸��Դϴ�.");
		}
		
		
		System.out.println(hm.containsKey("����"));
		System.out.println(hm.containsKey("����ȩ"));
		
		System.out.println(hm.containsValue("����"));
		System.out.println(hm.containsValue(92));
		
		Set<String> key = hm.keySet();
		System.out.println(key);
		
		Iterator it = key.iterator();
		while (it.hasNext()) {
			String s = it.next().toString();
			System.out.println(s +" : "+hm.get(s));
		}
		
		hm.remove("����");
		System.out.println(hm);
	}
}