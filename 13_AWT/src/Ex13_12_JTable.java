import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex13_12_JTable {
	public static void main(String[] args) {
		JFrame frame = new JFrame("������ ���");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String[] col = {"�̸�","����","����"};
		Object[][] row = {
							{"��ö��",24,"��"},
							{"�̼���",21,"��"},
							{"������",26,"��"},
							{"��ȣ��",31,"��"}
		};
		
		Container con = frame.getContentPane();
		JTable table = new JTable(row,col);
		JScrollPane js = new JScrollPane(table);
		JButton bt = new JButton("���");

		con.add(js);
		con.add(bt,BorderLayout.SOUTH);
		
		bt.addActionListener(new TablePrint(table));
		
		frame.setSize(400,200);
		frame.setVisible(true);
	}
}
class TablePrint implements ActionListener{
	JTable table = null;
	TablePrint (JTable table){ 
		this.table = table;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int row = table.getRowCount();
		int col = table.getColumnCount();
		
		System.out.println(row + "�� "+col +"ĭ");
		for(int i=0;i<col;i++) {
			System.out.printf("%s\t",table.getColumnName(i));
		}
		System.out.println();
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.printf("%s\t",table.getValueAt(i, j));
			}
			System.out.println();
		}
	}
	
}