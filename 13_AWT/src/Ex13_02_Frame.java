import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;



class Ex13_02_sub extends Frame{
	Button east = new Button("悼率");
	Button west = new Button("辑率");
	Button south = new Button("巢率");
	Button north = new Button("合率");
	Button center = new Button("吝居");
	
	Ex13_02_sub(String title){
		super(title);
		setSize(400,300);
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();		
		System.out.println(screen);
		
		int xpos = (int)(screen.getWidth()/2 - super.getWidth()/2);
		int ypos = (int)(screen.getHeight()/2 - super.getHeight()/2);
		
		setLocation(xpos,ypos);
		
//		setLayout(new FlowLayout());
//		setLayout(new BorderLayout()); //default 蔼
		setLayout(new GridLayout(3,2));
		
//		super.add(east,BorderLayout.EAST);
//		super.add(west,BorderLayout.WEST);
//		super.add(south,BorderLayout.SOUTH);
//		super.add(north,BorderLayout.NORTH);
//		super.add(center,BorderLayout.CENTER);
		
		super.add(east);
		super.add(west);
		super.add(south);
		super.add(north);
		super.add(center);
		setVisible(true);
	}
}
public class Ex13_02_Frame {
	public static void main(String[] args) {
		Ex13_02_sub sub = new Ex13_02_sub("frame 力格");
	}
}