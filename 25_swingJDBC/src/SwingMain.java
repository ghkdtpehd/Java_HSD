import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class SwingMain extends JFrame implements ActionListener{
	private String[] columnNames = {"아이디","이름","입고수량","단가","카테고리","입고일자"};
	private Object[][] rowData = null;
	private JTable table = null;
	private JScrollPane scrollPane = null;
	SwingDao dao = null;
	ArrayList<SwingBean> list = null;
	Container con = null;
	String[] btnTitle = {"등록","수정","삭제","조회","종료"};
	private JButton[] btn = new JButton[btnTitle.length];  
	
	SwingMain(String title){
		super(title);
		dao = new SwingDao();
		list = dao.getAllProducts();
		
		rowData = new Object[list.size()][6];
		fillRowData();
		
		table = new JTable (rowData,columnNames);
		scrollPane = new JScrollPane(table);
		
		con = getContentPane();
		con.add(scrollPane,BorderLayout.NORTH);
		
		compse();
		super.setSize(500,650);
		setVisible(true);
	}
	private void compse() {
		JLabel lblId = new JLabel("아이디");
		JLabel lblName = new JLabel("이름");
		JLabel lblStock = new JLabel("입고수량");
		JLabel lblPrice = new JLabel("단가");
		JLabel lblCategory= new JLabel("카테고리");
		JLabel lblInputupdate = new JLabel("입고일자");
		
		lblId.setBounds(20,20,100,20);
		lblName.setBounds(20,40,100,20);
		lblStock.setBounds(20,60,100,20);
		lblPrice.setBounds(20,80,100,20);
		lblCategory.setBounds(20,100,100,20);
		lblInputupdate.setBounds(20,120,100,20);
		
		JTextField txtId = new JTextField();
		JTextField txtName = new JTextField();
		JTextField txtStock = new JTextField();
		JTextField txtPrice = new JTextField();
		JTextField txtCategory = new JTextField();
		JTextField txtInputupdate = new JTextField();
		
		txtId.setBounds(120,20,100,20);
		txtName.setBounds(120,40,100,20);
		txtStock.setBounds(120,60,100,20);
		txtPrice.setBounds(120,80,100,20);
		txtCategory.setBounds(120,100,100,20);
		txtInputupdate.setBounds(120,120,100,20);
		
		JPanel pCenter = new JPanel();
		pCenter.setLayout(null);
		pCenter.add(lblId);
		pCenter.add(lblName);
		pCenter.add(lblStock);
		pCenter.add(lblPrice);
		pCenter.add(lblCategory);
		pCenter.add(lblInputupdate);
		
		pCenter.add(txtId);
		pCenter.add(txtName);
		pCenter.add(txtStock);
		pCenter.add(txtPrice);
		pCenter.add(txtCategory);
		pCenter.add(txtInputupdate);
		
		con.add(pCenter,BorderLayout.CENTER);
		
		JPanel pSouth = new JPanel();
		pSouth.setLayout(new GridLayout(1,5));
		for(int i=0;i<btnTitle.length;i++) {
			btn[i] = new JButton(btnTitle[i]);
			btn[i].addActionListener(this);
			pSouth.add(btn[i]);
		}
		con.add(pSouth,"South");
	}
	
	private void fillRowData() {
		Object[] arr = list.toArray();
		int cnt = 0;
		for(int i=0;i<arr.length;i++) {
//			System.out.println(arr[i]);
			SwingBean sb = (SwingBean)arr[i];
			
			rowData[i][cnt++] = sb.getId();
			rowData[i][cnt++] = sb.getName();
			rowData[i][cnt++] = sb.getStock();
			rowData[i][cnt++] = sb.getPrice();
			rowData[i][cnt++] = sb.getCategory();
			rowData[i][cnt++] = sb.getInputdate();
			cnt = 0;
		}
	}
	
	public static void main(String[] args) {
		new SwingMain("상품관리 프로그램");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn[0]) {
			System.out.println("동록");
		}else if(obj == btn[1]) {
			System.out.println("수정");
		}else if(obj == btn[2]) {
			System.out.println("삭제");
		}else if(obj == btn[3]) {
			System.out.println("동록");
		}else if(obj == btn[4]) {
			System.out.println("동록");
		}else if(obj == btn[5]) {
			System.out.println("동록");
		}
	}
}