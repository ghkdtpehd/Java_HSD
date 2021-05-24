interface Copymachine{
	int a = 3;
	void copy();
}
interface Printmachine{
	void print();
}
interface Faxmachine{
	void Fax();
}

class Compound implements Copymachine,Printmachine,Faxmachine{
	public void copy() {
		System.out.println("����");
	}
	public void print() {
		System.out.println("����Ʈ");
	}
	public void Fax() {
		System.out.println("�ѽ�");
	}
}
public class Ex06_12_inferface {
	public static void main(String[] args) {
		Compound com = new Compound();
		com.copy();
		com.Fax();
		com.print();
	}
}