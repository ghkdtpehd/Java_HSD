class Data1 {
	int i = 0;
}
class AA extends Thread{
	public void run() {
		for(int i=0;i<100000;i++) {
			Ex11_08_notSyncTest.d.i++;
		}
		System.out.println("AA : "+Ex11_08_notSyncTest.d.i);
	}
}
class BB extends Thread{
	public void run() {
		for(int i=0;i<100000;i++) {
			Ex11_08_notSyncTest.d.i++;
		}
		System.out.println("BB : "+Ex11_08_notSyncTest.d.i);
	}
}
public class Ex11_08_notSyncTest {
	
	static Data1 d = new Data1();
	
	public static void main(String[] args) {
		System.out.println("main ½ÃÀÛ");
		AA a = new AA();
		a.start();
		BB b = new BB();
		b.start();
		System.out.println("main ³¡");
	}
}