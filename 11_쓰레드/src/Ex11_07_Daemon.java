class DaemonTest extends Thread{
	public void run() {
		while(true) {
			try {
				sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(Ex11_07_Daemon.aSave)
			autoSave();
		}
	}
	
	public void autoSave() {
		System.out.println("자동 저장되었습니다."); 
	}
}
public class Ex11_07_Daemon {
	static boolean aSave = false;
	public static void main(String[] args) {
		DaemonTest d = new DaemonTest();
		d.setDaemon(true);
		d.start();
		
		for(int i=0;i<20;i++) {
			Thread t = new Thread();
			try {
				t.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(i==5) aSave = true;
			System.out.println(i);
		}
		
		System.out.println("프로그램 종료");
	}
}