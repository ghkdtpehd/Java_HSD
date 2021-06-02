import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex13_09_JFrame extends JFrame{
	public Ex13_09_JFrame(String str) {
		super(str);
		
		Container con = getContentPane();
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.yellow);
		
		JPanel p2 = new JPanel();
		p2.setBackground(Color.cyan);
		
		con.add(p1,BorderLayout.CENTER);
		con.add(p2,BorderLayout.SOUTH);
		
		JTextField text1 = new JTextField(5);
		JTextField text2 = new JTextField(5);
		JTextField text3 = new JTextField(5);
		text3.setEditable(false);
		
		JButton b1 = new JButton("확인");
		JButton b2 = new JButton("취소");
		
		p1.add(text1);
		p1.add(new JLabel("+"));
		p1.add(text2);
		p1.add(new JLabel("="));
		p1.add(text3);
		
		p2.add(b1);
		p2.add(b2);
		
		b1.addActionListener(new OkButton(text1,text2,text3));
		b2.addActionListener(new CancelButton(text1,text2,text3));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		setSize(400,100);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex13_09_JFrame("덧셈 프로그램");  
	}
}

class OkButton implements ActionListener{
	JTextField text1,text2,text3;
	
	public OkButton(JTextField text1, JTextField text2, JTextField text3) {
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			int num1 = Integer.parseInt(text1.getText());
			int num2 = Integer.parseInt(text2.getText());
			int sum = num1+num2;
			
			text3.setText(String.valueOf(sum));
		}catch(NumberFormatException er) {
			JOptionPane.showMessageDialog(null, "숫자만 입력 가능합니다.");
			text1.setText("");
			text2.setText("");
			text3.setText("");
		}
	}
}
class CancelButton implements ActionListener{
	JTextField text1,text2,text3;
	public CancelButton(JTextField text1, JTextField text2, JTextField text3) {
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
	}

	public void actionPerformed(ActionEvent e) {
		text1.setText("");
		text2.setText("");
		text3.setText("");
	}
	
}