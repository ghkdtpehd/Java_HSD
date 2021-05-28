class ThreadRun2 extends Thread{
	public void run() {
		for(int i=1;i<=50;i++) {
			System.out.print(i+" ");
		}
	}
}
public class Ex11_02_Thread {
	public static void main(String[] args) {
		System.out.println("시작");
		
		ThreadRun2 trd = new ThreadRun2();
		trd.start();
		
		System.out.println("종료");
	}
}