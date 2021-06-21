import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class SwingMain extends JFrame implements ActionListener{
	private String[] columnNames = {"아이디","이름","입고수량","단가","카테고리","입고일자"};
	private Object[][] rowData = null;
	private JTable table = null;
	private JScrollPane scrollPane = null;
	ProductDao dao = null;
	ArrayList<ProductBean> list = null;
	Container con = null;
	String[] btnTitle = {"등록","수정","삭제","조회","종료"};
	private JButton[] btn = new JButton[btnTitle.length];  
	
	JTextField txtId = new JTextField();
	JTextField txtName = new JTextField();
	JTextField txtStock = new JTextField();
	JTextField txtPrice = new JTextField();
	JTextField txtCategory = new JTextField();
	JTextField txtInputupdate = new JTextField();
	
	SwingMain(String title){
		super(title);
		dao = new ProductDao();
		list = dao.AllProductData();
		
		rowData = new Object[list.size()][6];
		fillRowData();
		
		table = new JTable (rowData,columnNames);
		table.addMouseListener(new MouseHandler());
		scrollPane = new JScrollPane(table);
		
		con = getContentPane();
		con.add(scrollPane,BorderLayout.NORTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		compse();
		super.setSize(500,650);
		setVisible(true);
	}
	
	class MouseHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			txtId.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
			txtName.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
			txtStock.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
			txtPrice.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
			txtCategory.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
			txtInputupdate.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
		}
	}
	public void AllProductData() {
		list = dao.AllProductData();
		
		rowData = new Object[list.size()][6];
		fillRowData();
		
		table = new JTable (rowData,columnNames);
		table.addMouseListener(new MouseHandler());
		scrollPane.remove(table);
		table.revalidate();
		table.repaint();
		scrollPane.setViewportView(table);
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
		
		txtId.setBounds(120,20,100,20);
		txtName.setBounds(120,40,100,20);
		txtStock.setBounds(120,60,100,20);
		txtPrice.setBounds(120,80,100,20);
		txtCategory.setBounds(120,100,100,20);
		txtInputupdate.setBounds(120,120,100,20);
		
		txtId.setText("0");
		txtId.setEnabled(false);
		
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
			ProductBean sb = (ProductBean)arr[i];
			
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
			insertData();
		}else if(obj == btn[1]) {
			updateData();
		}else if(obj == btn[2]) {
			deleteDate();
		}else if(obj == btn[3]) {
			selectData(table.getSelectedRow());
		}else if(obj == btn[4]) {
			System.exit(0);
		}
	}
	private void selectData(int row) {
		JFrame sub = new JFrame();

		JLabel lblId2 = new JLabel("아이디");
		JLabel lblName2 = new JLabel("이름");
		JLabel lblStock2 = new JLabel("입고수량");
		JLabel lblPrice2 = new JLabel("단가");
		JLabel lblCategory2 = new JLabel("카테고리");
		JLabel lblInputupdate2 = new JLabel("입고일자");

		lblId2.setBounds(20,20,100,20);
		lblName2.setBounds(20,40,100,20);
		lblStock2.setBounds(20,60,100,20);
		lblPrice2.setBounds(20,80,100,20);
		lblCategory2.setBounds(20,100,100,20);
		lblInputupdate2.setBounds(20,120,100,20);

		JPanel pCenter = new JPanel();
		pCenter.setLayout(null);
		pCenter.add(lblId2);
		pCenter.add(lblName2);
		pCenter.add(lblStock2);
		pCenter.add(lblPrice2);
		pCenter.add(lblCategory2);
		pCenter.add(lblInputupdate2);

		Font f1 = new Font("고딕",Font.BOLD,20);
		lblId2.setFont(f1);
		lblId2.setText(table.getValueAt(row, 0).toString());
		lblName2.setText(table.getValueAt(row, 1).toString());
		lblStock2.setText(table.getValueAt(row, 2).toString());
		lblPrice2.setText(table.getValueAt(row, 3).toString());
		lblCategory2.setText(table.getValueAt(row, 4).toString());
		lblInputupdate2.setText(table.getValueAt(row, 5).toString());
		
		sub.add(pCenter,BorderLayout.CENTER);
		
		sub.setSize(400,550);
		sub.setVisible(true);
	}

	private void deleteDate() {
		int cnt = 0;
		if(txtId.getText().equals("0")||txtId.getText().length()==0) {
			JOptionPane.showMessageDialog(this,"삭제할 항목을 선택해주세요","에러 발생",JOptionPane.ERROR_MESSAGE);
		}else {
			txtId.getText();
			cnt = dao.deleteData(Integer.parseInt(txtId.getText()));
		}
		if(cnt == 0) {
			System.out.println("삭제 실패");
		}else{
			System.out.println("삭제 성공");
			AllProductData();
			clearData();
		}
	}

	private void updateData() {
		boolean result = checkData();
		if(result == false) {
			System.out.println("데이터 누락");
		}else {
			System.out.println("데이터 입력");
		}
		ProductBean sb = new ProductBean();
		sb.setId(Integer.parseInt(txtId.getText()));
		sb.setName(txtName.getText());
		sb.setStock(Integer.parseInt(txtStock.getText()));
		sb.setPrice(Integer.parseInt(txtPrice.getText()));
		sb.setCategory(txtCategory.getText());
		sb.setInputdate(txtInputupdate.getText());
		int cnt = dao.updateData(sb);
		if(cnt == 0) {
			System.out.println("수정 실패");
		}else{
			System.out.println("수정 성공");
			AllProductData();
			clearData();
		}
	}
	private void insertData() {
		boolean result = checkData();
		if(result == false) {
			System.out.println("데이터 누락");
		}else {
			System.out.println("데이터 입력");
		}
		ProductBean sb = new ProductBean();
		sb.setName(txtName.getText());
		sb.setStock(Integer.parseInt(txtStock.getText()));
		sb.setPrice(Integer.parseInt(txtPrice.getText()));
		sb.setCategory(txtCategory.getText());
		sb.setInputdate(txtInputupdate.getText());
		
		int cnt = dao.insertData(sb);
		if(cnt == 0) {
			System.out.println("삽입 실패");
		}else{
			System.out.println("삽입 성공");
			AllProductData();
			clearData();
		}
		
	}
	private boolean checkData() {
		if(txtName.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,"이름을 입력하세요","에러 발생",JOptionPane.ERROR_MESSAGE);
			txtName.requestFocus();
			return false;
		}
		if(txtStock.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,"입고수량을 입력하세요","에러 발생",JOptionPane.WARNING_MESSAGE);
			txtStock.requestFocus();
			return false;
		}
		if(txtPrice.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,"가격을 입력하세요","에러 발생",JOptionPane.WARNING_MESSAGE);
			txtPrice.requestFocus();
			return false;
		}
		if(txtCategory.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,"카테고리를 입력하세요","에러 발생",JOptionPane.WARNING_MESSAGE);
			txtCategory.requestFocus();
			return false;
		}
		if(txtInputupdate.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,"입고일을 입력하세요","에러 발생",JOptionPane.WARNING_MESSAGE);
			txtInputupdate.requestFocus();
			return false;
		}
		return true;
	}
	private void clearData() {
		txtId.setText("");
		txtName.setText("");
		txtStock.setText("");
		txtPrice.setText("");
		txtCategory.setText("");
		txtInputupdate.setText("");
	}
}