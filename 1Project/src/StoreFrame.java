import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class StoreFrame extends JFrame implements ActionListener{
	StoreMain sm = new StoreMain();
	StoreDao dao = new StoreDao();
	Container loginC = null;
	JTextField txtId = null;
	JTextField txtPw = null;
	JButton loginBtn = new JButton();
//	JFrame ListF = null;
	Container ListC = null;
	JTable table = null;
	private JScrollPane scrollPane = null;

	private String[] columnNames = {"번호","책이름","저자","단가","출판사","입고일자","대여여부"};
	private Object[][] rowData = null;
	ArrayList<StoreBean> list = null;
	
	String[] btn = 
	
	public StoreFrame(String title){
		super(title);
		setResizable(false);
		loginC = getContentPane();
		loginC.setLayout(null);
		
		JLabel lblId = new JLabel("아이디");
		JLabel lblPw = new JLabel("비밀번호");

		txtId = new JTextField();
		txtPw = new JTextField();
		
		Font loginFont = new Font("고딕",Font.BOLD,17);
		
		lblId.setBounds(90,80,100,20);
		lblId.setFont(loginFont);
		lblPw.setBounds(90,130,100,20);
		lblPw.setFont(loginFont);
		
		txtId.setBounds(190,78,130,25);
		txtId.setFont(loginFont);
		txtPw.setBounds(190,128,130,25);
		txtPw.setFont(loginFont);
		
		loginBtn.setText("로그인");
		loginBtn.setBounds(340,75,80,80);
		
		loginC.add(lblId);
		loginC.add(lblPw);
		loginC.add(txtId);
		loginC.add(txtPw);
		loginC.add(loginBtn);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 300);
		setVisible(true);
	}
	
	public void mainFram() {
		JFrame ListF = new JFrame("대장서점");
		
		list = sm.getAllBookList();
		rowData = new Object[list.size()][columnNames.length];
		fillRowData();
		
		table = new JTable (rowData,columnNames);
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(700,300));

		ListF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		compse();
		ListF.add(scrollPane,BorderLayout.NORTH);
		ListF.setResizable(false);
		ListF.setSize(700,600);
		ListF.setVisible(true);
	}

	private void compse() {
		//사용자 등급에 따른 UI변경
	}

	private void fillRowData() {
		Object[] arr = list.toArray();
		int cnt = 0;
		
		for(int i=0;i<arr.length;i++) {
			StoreBean sb = (StoreBean)arr[i];
			
			rowData[i][cnt++] = sb.getNo();
			rowData[i][cnt++] = sb.getTitle();
			rowData[i][cnt++] = sb.getAuthor();
			rowData[i][cnt++] = sb.getPrice();
			rowData[i][cnt++] = sb.getPublisher();
			rowData[i][cnt++] = sb.getPub_date();
			rowData[i][cnt++] = sb.getRental() == 0 ? "가능":"불가능";
			cnt = 0;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == loginBtn) {
			StoreBean userData = dao.checkUser(txtId.getText(),txtPw.getText());
			if(userData.getNo() != 0) {
				JOptionPane.showMessageDialog(this,"로그인 되었습니다.","로그인",JOptionPane.DEFAULT_OPTION);
				setVisible(false);
				sm.ListLoad(userData);
			}else {
				JOptionPane.showMessageDialog(this,"ID 또는 PW 를 확인해주세요.","로그인",JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}