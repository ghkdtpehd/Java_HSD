import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Ex13_03_sub extends Frame implements ActionListener{
	Button b1 = new Button("�����"); 
	Button b2 = new Button("������"); 
	Button b3 = new Button("�Ķ���");
	Button b4 = new Button("�ʷϻ�");
	
	Ex13_03_sub(String title){
		super(title);
		
		super.addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
					public void windowActivated(WindowEvent e) {
					}
				}
			);
		
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
			System.out.println("����� ����");
		}else if(obj == b2) {
			setBackground(Color.red);
			System.out.println("������ ����");
		}else if(obj == b3){
			setBackground(Color.blue);
			System.out.println("�Ķ��� ����");
		}else if(obj == b4){
			setBackground(Color.green);
			System.out.println("�ʷϻ� ����");
		}
	}
}
public class Ex13_03_ActionEvent {
	public static void main(String[] args) {
		Ex13_03_sub sub = new Ex13_03_sub("AWT����");
	}
}