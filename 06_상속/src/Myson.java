class MyFather{
	public String name;
	private String nick;
	public MyFather() {
		name="�Ƥ���";
		nick = "����";
	}
	public String getNickName() {
		return nick;
	}
}
public class Myson extends MyFather{
	public void sayFatherName() {
		System.out.println(name);
		System.out.println(getNickName());
	}
	public static void main(String[] args) {
		Myson m = new Myson();
		m.sayFatherName();
	}
}