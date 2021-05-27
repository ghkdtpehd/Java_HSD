import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class Ex10_09_Vector {
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		System.out.println(v.size());
		
		v.add("º½");
		v.add(new String("¿©¸§"));
		v.add("º½");
		v.add("°Ü¿ï");
		
		System.out.println(v);
		
		Enumeration<String> en = v.elements();
		while(en.hasMoreElements()) {
			String s =en.nextElement();
			System.out.println(s);
		}
		
		System.out.println();
		
		Iterator<String> it = v.iterator();
		while(it.hasNext()) {
			String s2 = it.next();
			System.out.println("s2"+s2);
		}
		
		for(String x : v){
			System.out.println(x);
		}
	}
}