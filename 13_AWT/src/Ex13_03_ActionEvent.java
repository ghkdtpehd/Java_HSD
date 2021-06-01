import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Ex13_03_sub extends Frame implements ActionListener{
	Button b1 = new Button("노란색"); 
	Button b2 = new Button("빨간색"); 
	Button b3 = new Button("파란색");
	Button b4 = new Button("초록색");
	
	Ex13_03_sub(String title){
		super(title);
		setSize(400,300);
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();		
		
		int xpos = (int)(screen.getWidth()/2 - super.getWidth()/2);
		int ypos = (int)(screen.getHeight()/2 - super.getHeight()/2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		b1.setBackground(Color.pink);
		b1.setForeground(Color.green);
		
		setLocation(xpos,ypos);
		setLayout(new FlowLayout());
		
//		setBackground();
		
		super.add(b1);
		super.add(b2);
		super.add(b3);
		super.add(b4);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == b1) {
			setBackground(Color.yellow);
			System.out.println("노란색 눌림");
		}else if(obj == b2) {
			setBackground(Color.red);
			System.out.println("빨간색 눌림");
		}else if(obj == b3){
			setBackground(Color.blue);
			System.out.println("파란색 눌림");
		}else if(obj == b4){
			setBackground(Color.green);
			System.out.println("초록색 눌림");
		}
	}
}
public class Ex13_03_ActionEvent {
	public static void main(String[] args) {
		Ex13_03_sub sub = new Ex13_03_sub("AWT예제");
	}
}