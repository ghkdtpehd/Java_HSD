class Horizontal extends Thread{
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print("-");
			if(i%50==0) {
				System.out.println();
			}
		}
	}
}
class Vertical extends Thread{
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print("|");
			if(i%50==0) {
				System.out.println();
			}
		}
	}
}
public class Ex11_06_우선순위 {
	public static void main(String[] args) {
		Horizontal h = new Horizontal();
		Vertical v = new Vertical();
		
		//쓰레드의 default 우선순위는 5이며 1~10까지 설정할수 있다.
		//숫자가 10에 가까울수록 순위가 높다.
		h.setName("철수");
		v.setName("영희");
		System.out.println(h.getPriority());
		System.out.println(v.getPriority());
		
		v.setPriority(7);

		h.start();
		v.start();
	}
}