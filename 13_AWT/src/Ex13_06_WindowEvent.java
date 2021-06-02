import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class Ex13_06_sub extends Frame implements WindowListener{
	Ex13_06_sub(){
		super.addWindowListener(this);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified");
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("창활성화");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("최소화");
	}
}
public class Ex13_06_WindowEvent {
	public static void main(String[] args) {
		Frame f = new Ex13_06_sub();
		f.setSize(300,300);
		f.setVisible(true);
	}
}