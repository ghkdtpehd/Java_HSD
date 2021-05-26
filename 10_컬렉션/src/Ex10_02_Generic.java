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
		//Class �Ѱ��� ���� Ÿ������ ��밡���ϰ� ����� ��
		
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