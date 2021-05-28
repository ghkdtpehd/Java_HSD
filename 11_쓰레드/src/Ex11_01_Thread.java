class ThreadRun implements Runnable{

	public void run() {
		for(int i=1;i<=50;i++) {
			System.out.print(i+" ");
		}
	}
	
}
public class Ex11_01_Thread {
	public static void main(String[] args) {
		System.out.println("시작");
		
		ThreadRun t = new ThreadRun();
//		t.run();
		Thread trd = new Thread(t);
		trd.start();
		
		System.out.println("종료");
	}
}

//쓰레드 : 프로세스를 구성하는 제일 작은 단위
//멀티 쓰레드 : 쓰레드를 동시에 쓸수있게 하는것
//무조건 인터페이스 또는 클레스를 상속받아야 하며 run()을 오버라이딩 하여야한다