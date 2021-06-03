import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class Ex13_13_sub extends JFrame{
	JTable table =null;
	JScrollPane sp = null;
	JButton btn = null;
	Container con = null;
	
	int count = 1;
	Vector<String> title = null;
	Vector<Vector<String>> data = null;
	
	Ex13_13_sub(){
		title = new Vector<String>();
		data = new Vector<Vector<String>>();
		btn = new JButton("Ãâ·Â");
		
		getReadFile();
		makeJTable();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,300);
		setResizable(false);
		setVisible(true);
	}

	private void makeJTable() {
		table = new JTable(data,title);
		Container con = getContentPane();
		JScrollPane sp = new JScrollPane(table);

		btn.addActionListener(new btnClick(table));
		
		con.add(sp);
		con.add(btn,BorderLayout.SOUTH);
	}
	private void getReadFile() {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("sungjuk.txt"));
			String line = "";
			while ((line = bf.readLine()) != null) {
				String[] arr = line.split("/");
				if(count++ == 1) {
					for(int i=0;i<arr.length;i++) {
						title.add(arr[i]);
					}
				}else {
					Vector<String> one = new Vector<String>();
					for(int i=0;i<arr.length;i++) {
						one.add(arr[i]);
					}
					data.add(one);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
class btnClick implements ActionListener{
	JTable table = new JTable();
	btnClick(JTable table){
		this.table = table;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int row = table.getRowCount();
		int col = table.getColumnCount();
		for(int i=0;i<col;i++) {
			System.out.print(table.getColumnName(i)+"\t");
		}
		System.out.println();
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(table.getValueAt(i, j)+"\t");
			}
			System.out.println();
		}
	}
	
}
public class Ex13_13_JTable {
	public static void main(String[] args) {
		new Ex13_13_sub();
	}
}