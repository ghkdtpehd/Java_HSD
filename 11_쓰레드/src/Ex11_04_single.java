import javax.swing.JOptionPane;

public class Ex11_04_single {
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("입력하세요");
		System.out.println("입력한 값은 "+input+" 입니다.");
		
		for(int i =10;i>0;i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}