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
		System.out.println("복사");
	}
	public void print() {
		System.out.println("프린트");
	}
	public void Fax() {
		System.out.println("팩스");
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