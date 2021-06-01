import java.awt.Frame;

public class Ex13_01_Frame {
	public static void main(String[] args) {
		Frame f = new Frame("생성자");
		f.setTitle("기본 frame");
		
		f.setSize(400,300);
		f.setVisible(true);
		f.setLocation(100,300);
	}
}