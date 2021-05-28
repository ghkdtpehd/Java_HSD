class Data2{
	int i;
}
class Sync1 extends Thread{
	public void run() {
		for(int i=0;i<100000;i++) {
			synchronized (Ex11_09_SyncTest.d) {
				Ex11_09_SyncTest.d.i++;
			}
		}
		System.out.println("Sync1 : "+Ex11_09_SyncTest.d.i);
	}
}
class Sync2 extends Thread{
	public void run() {
		for(int i=0;i<100000;i++) {
			synchronized (Ex11_09_SyncTest.d) {
				Ex11_09_SyncTest.d.i++;
			}
		}
		System.out.println("Sync2 : "+Ex11_09_SyncTest.d.i);
	}
}
public class Ex11_09_SyncTest {
	 
	static Data2 d = new Data2();
	
	public static void main(String[] args) {
		System.out.println("main ½ÃÀÛ");
		Sync1 a = new Sync1();
		a.start();
		Sync2 b = new Sync2();
		b.start();
		System.out.println("main ³¡");
	}
}