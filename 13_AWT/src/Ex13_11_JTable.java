import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

class Ex13_11_sub extends JFrame{
	String[] title = {"���","����","�μ�"};
	Object[][] data = {
						{1,"����","�λ��"},
						{2,"�¿�","���ߺ�"},
						{3,"����","�ѹ���"}
					};
	JTable table = null;
	JScrollPane sp = null;
	Ex13_11_sub(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con =getContentPane();
		
		table = new JTable(data,title);

		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		sp = new JScrollPane(table,v,h);
		
		con.add(sp);
		super.setSize(300,200);
		setVisible(true);
	}
}
public class Ex13_11_JTable {
	public static void main(String[] args) {
		new Ex13_11_sub();
	}
}