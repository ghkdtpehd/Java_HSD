package JTable성적_황세동;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AddJTable implements ActionListener{
	JTable table = null;
	JTextField[] tf = null;
	
	public AddJTable(JTable table, JTextField[] tf){
		this.table = table;
		this.tf = tf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String[] s = new String[4];
		for(int i=0;i<tf.length;i++) {
			s[i] = tf[i].getText();
		}
		DefaultTableModel tm = (DefaultTableModel)table.getModel();
		
		tm.addRow(s);
		
		for(int i=0;i<tf.length;i++) {
			tf[i].setText("");
		}
		tf[0].requestFocus();
	}

}
