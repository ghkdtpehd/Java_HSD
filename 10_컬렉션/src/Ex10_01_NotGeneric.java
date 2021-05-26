class Top{
	private String str;
	
	void setStr(String str) {
		this.str = str;
	}
	String getStr() {
		return str;
	}
}
public class Ex10_01_NotGeneric {
	public static void main(String[] args) {
		String str = "Hello";
		
		Top t = new Top();
		t.setStr(str);
		
		System.out.println(t.getStr());
	}
}