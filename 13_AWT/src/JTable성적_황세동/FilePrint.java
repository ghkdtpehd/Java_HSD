package JTable성적_황세동;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FilePrint implements ActionListener{
	//파일 생성
	//패키지 제출
	JTable table = null;
	FilePrint(JTable table){
		this.table = table;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int count = 1;
		try {
			File chkFile = new File("sd_sungjuk.txt");
			if(chkFile.isFile()) {
				//만약 파일이 존재 할때 아예 초기화 
				chkFile.delete();
			}
			BufferedWriter bf = new BufferedWriter(new FileWriter("sd_sungjuk.txt",true));
			
			for(int row=0;row<table.getRowCount();row++) {
				String line = "";
				for(int col=0;col<table.getColumnCount();col++) {
					line += makeStr(row,col,count);
				}
				if(count == 1) {
					row--;
				}
				count++;
				bf.write(line);
				bf.newLine();
			}
			System.out.println("파일 출력이 완료되었습니다.");
			System.out.println("(row : "+table.getRowCount() +")");
			bf.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	private String makeStr(int row, int col, int count) {
		if(count == 1) {
			if(col+1 != table.getColumnCount()) {
				return table.getColumnName(col)+"/";
			}else {
				return table.getColumnName(col)+"";
			}
		}else {
			if(col+1 != table.getColumnCount()) {
				return table.getValueAt(row, col)+"/";
			}else {
				//마지막 col일시 '/' 제외
				return table.getValueAt(row, col)+"";
			}
		}
	}
}
