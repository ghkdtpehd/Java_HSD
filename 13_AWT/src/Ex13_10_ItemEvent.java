import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class Ex13_10_ItemEvent extends JFrame{
	String[] text = {"사과","배","체리"};
	JRadioButton[] radio = new JRadioButton[3];
	
	ImageIcon[] image = {
			new ImageIcon("images/apple.jpg"), 
			new ImageIcon("images/pear.jpg"), 
			new ImageIcon("images/cherry.jpg") 
	};
	JLabel label = new JLabel("      ");
	
	Ex13_10_ItemEvent(){
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		
		Container con = getContentPane();
		Panel p = new Panel();
		p.setBackground(Color.gray);
		
		ButtonGroup group = new ButtonGroup();
		
		for(int i=0;i<radio.length;i++) {
			radio[i] = new JRadioButton(text[i]);
			group.add(radio[i]);
			p.add(radio[i]);
			radio[i].addItemListener(new MyRadio());
		}
		radio[0].setSelected(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		con.add(p,BorderLayout.NORTH);
		con.add(label,BorderLayout.CENTER);
		
		setSize(400,300);
		setVisible(true);
	}
	
	class MyRadio implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			if(radio[0].isSelected()) {
				label.setIcon(image[0]);
			}else if(radio[1].isSelected()) {
				label.setIcon(image[1]);
			}else {
				label.setIcon(image[2]);
			}
		}
	}
	
	public static void main(String[] args) {
		new Ex13_10_ItemEvent();
	}
	
}