package JTable성적_황세동;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RemoveJTable implements ActionListener{
	JTable table = null;
	RemoveJTable(JTable table){
		this.table = table;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int row = table.getSelectedRow();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.removeRow(row);
	}

}
