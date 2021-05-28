import javax.swing.JOptionPane;

class Thread05 extends Thread{
	public void run() {
		for(int i=0;i<10;i++) {
			char a = (char) (97+i);
			System.out.println(a);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Ex11_05_multi {
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("입력하세요;");
		System.out.println(input);
		
		Thread05 t5 = new Thread05();
		t5.start();
	}
}