package JTable성적_황세동;

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
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
public class JTable_main extends JFrame implements ActionListener{
	Vector<String> title = null;
	Vector<Vector<String>> data = null;
	
	Container con = null;
	JTable table = null;
	int count = 1;
	JButton btn1 = new JButton("추가");
	JButton btn2 = new JButton("삭제");
	JButton btn3 = new JButton("파일출력");
	JButton btn4 = new JButton("종료");
	
	JTextField[] tf = new JTextField[4];
	
	String[] caption = {"이름:","국어:","영어:","수학:"};
	
	JTable_main(String titleName){
		super(titleName);
		
		this.title = new Vector<String>();
		this.data = new Vector<Vector<String>>();
		
		getReadFile();
		display();
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,300);
		setVisible(true);
	}
	private void getReadFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("sungjuk.txt"));
			
			String line = "";
			while((line = br.readLine()) !=null) {
				String[] arr = line.split("/");
				if(count++ == 1) {
					for(int i=0; i<arr.length;i++) {
						title.add(arr[i]);
					} 
				}else {
					Vector<String> v = new Vector<String>();
					for(int i=0; i<arr.length;i++) {
						v.add(arr[i]);
					}
					data.add(v);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void display() {
		con = getContentPane();
		con.setLayout(null);
		
		table = new JTable(data, title);
		JScrollPane sp = new JScrollPane(table);
		con.add(sp);
		
		sp.setBounds(250,30,400,200);
		
		for(int i=0;i<4;i++) {
			JLabel lb = new JLabel(caption[i]);
			lb.setBounds(10, (i+1)*30, 50, 20);
			
			con.add(lb);
			
			tf[i] = new JTextField();
			tf[i].setBounds(60, (i+1)*30, 80, 20);
			
			con.add(tf[i]);
		}
		btn1.setBounds(10, 160, 100, 20);
		btn2.setBounds(120, 160, 100, 20);
		btn3.setBounds(10, 190, 100, 20);
		btn4.setBounds(120, 190, 100, 20);
		
		btn1.addActionListener(new AddJTable(table,tf));
		btn2.addActionListener(new RemoveJTable(table));
		btn3.addActionListener(new FilePrint(table));
		btn4.addActionListener(this);
		
		con.add(btn1);
		con.add(btn2);
		con.add(btn3);
		con.add(btn4);
	}
	public static void main(String[] args) {
		new JTable_main("성적 처리 프로그램");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}
}
