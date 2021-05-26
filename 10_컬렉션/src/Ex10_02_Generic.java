class Top2<T>{
	private T str;
	
	void setStr(T str) {
		this.str = str;
	}
	T getStr() {
		return str;
	}
}
public class Ex10_02_Generic {
	public static void main(String[] args) {
		//Class 한개로 여러 타입으로 사용가능하게 만드는 것
		
		String str = "Hello";
		
		Top2<String> t = new Top2<String>();
		t.setStr(str);
		
		System.out.println(t.getStr());
		
		Top2<Integer> t2 = new Top2<Integer>();
		Integer it = new Integer(123);
		t2.setStr(it);
		
		System.out.println(t2.getStr());

	}
}