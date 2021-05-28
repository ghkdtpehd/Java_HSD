class AZ1 implements Runnable {//대문자 A~Z Runnable

	@Override
	public void run() {
		for (int i=0;i<26;i++) {
			char a = (char) (65+i);
			System.out.print(a + " ");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	} 
	 
}
class AZ2 extends Thread{ //소문자 a~z
	public void run() {
		for (int i=0;i<26;i++) {
			char a = (char) (97+i);
			System.out.print(a + " ");
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}
}
public class Ex11_03_Thread {
	public static void main(String[] args) {
		
		System.out.println("시작");
		
		AZ1 A1 = new AZ1();
		Thread tr = new Thread(A1);
		tr.start();
		
		AZ2 A2 = new AZ2();
		A2.start();
		
		for(int i=0;i<30;i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		
		System.out.println("종료");
		
	}
}