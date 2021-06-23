import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class StoreFrame extends JFrame implements ActionListener{
	StoreMain sm = new StoreMain();
	StoreDao dao = new StoreDao();
	Container loginC = null;
	JTextField txtId = null;
	JPasswordField txtPw = null;
	JButton loginBtn = new JButton();
	JFrame ListF = null;
	JFrame ListFI = null;
	JFrame ListU = null;
	JFrame ListInfo = null;
	Container ListC = null;
	JTable table = null;
	JTable userTable = null;
	private JScrollPane scrollPane = null;
	private JScrollPane userScrollPane = null;

	private HashMap<Integer,String> rankList = new HashMap<Integer,String>();
	private String[] columnNames = {"번호","책이름","저자","단가","출판사","입고일자","대여여부"};
	private String[] columnUsers = {"번호","이름","아이디","비밀번호","나이","성별","거주지","이메일","가입일","등급","대여한책"};
	private Object[][] rowData = null;
	ArrayList<StoreBean> list = null;
	ArrayList<StoreBean> listUser = null;
	
	String[] serchStr = {"번호","이름","주소","이메일","등급"};
	String[] serchBookStr = {"번호","책이름","저자","출판사"};
	String[] adminBtn = {"등록","삭제","회원목록","강제반납","신청목록"}; 
	String[] userBtn = {"대여","반납","내정보","책신청"}; 
	String[] BookInertBtn = {"대여","반납"}; 
	private JButton btnInsert = new JButton("저장");
	private JButton btnCancel =  new JButton("취소");
	private JButton btnAuEdit =  new JButton("수정");
	private JButton btnAuDis =  new JButton("탈퇴");
	private JButton btnAuCencle =  new JButton("취소");
	private JButton[] btnA = new JButton[adminBtn.length];
	private JButton[] btnU = new JButton[userBtn.length];
	private JButton btnUserch = new JButton("검색");
	private JButton btnBserch = new JButton("검색");
	
	JRadioButton[] oRadio = new JRadioButton[2];
	String[] userRadioName = {"오름차순","내림차순"};
	JComboBox<String> sherchCombo1 = new JComboBox<String>(serchStr);
	JComboBox<String> sherchCombo2 = new JComboBox<String>(serchStr);
	JComboBox<String> sherchBCombo1 = new JComboBox<String>(serchBookStr);
	JComboBox<String> sherchBCombo2 = new JComboBox<String>(serchBookStr);
	JLabel lblPRank_write = new JLabel("");
	JTextField bookSerch = new JTextField(15);
	JTextField userSerch = new JTextField(15);
	JTextField txtTitle = new JTextField();
	JTextField txtAuthor = new JTextField();
	JTextField txtPrice = new JTextField();
	JTextField txtPublisher = new JTextField();
	JTextField txtPub_date = new JTextField();

	JTextField txtPName	= new JTextField(15);
	JTextField txtPId 	= new JTextField(15);
	JTextField txtPPw 	= new JTextField(15);
	JTextField txtPAge	= new JTextField(15);
	JTextField txtPGender = new JTextField(15);
	JTextField txtPAddress = new JTextField(15);
	JTextField txtPEmail = new JTextField(15);
	JTextField txtPSign_up = new JTextField(15);
	JTextField txtPRank = new JTextField(15);
	
	public StoreFrame(String title){
		//로그인
		super(title);
		setResizable(false);
		
		loginC = getContentPane();
		loginC.setLayout(null);
		
		JLabel lblId = new JLabel("아이디");
		JLabel lblPw = new JLabel("비밀번호");

		txtId = new JTextField();
		txtPw = new JPasswordField();
		
		Font loginFont = new Font("고딕",Font.BOLD,15);
		
		lblId.setBounds(50,50,100,20);
		lblId.setFont(loginFont);
		lblPw.setBounds(50,80,100,20);
		lblPw.setFont(loginFont);
		
		txtId.setBounds(120,50,130,20);
		txtId.setFont(loginFont);
		txtId.addKeyListener(new KeyHandler());
		txtPw.setBounds(120,80,130,20);
		txtPw.setFont(loginFont);
		txtPw.addKeyListener(new KeyHandler());
		
		loginBtn.setText("로그인");
		loginBtn.setBounds(260,50,70,50);
		
		loginC.add(lblId);
		loginC.add(lblPw);
		loginC.add(txtId);
		loginC.add(txtPw);
		loginC.add(loginBtn);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 200);
		
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		
		setVisible(true);
	}
	
	public void mainFram(int rank) {
		//리스트
		ListF = new JFrame("대장서점");
		ListF.setLayout(null);
		
		list = sm.getAllBookList();
		rowData = new Object[list.size()][columnNames.length];
		fillRowData();
		
		table = new JTable (rowData,columnNames);
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(700,400));

		ListF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		compse(rank);
		scrollPane.setBounds(0,40,685,350);
		ListF.add(scrollPane);
		ListF.setResizable(false);
		ListF.setSize(700,500);
		
		Dimension frameSize = ListF.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		ListF.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		ListF.setVisible(true);
	}
	
	public void userFram() {
		//회원관리
		ListU = new JFrame("회원관리");
		ListU.setLayout(null);
		rankList = dao.getRankList();
		
		listUser = sm.getAllUserList(); 
		rowData = new Object[listUser.size()][columnUsers.length];
		fillUserRowData();

		userTable = new JTable (rowData,columnUsers);
		userTable.addMouseListener(new MouseHandler());
		userScrollPane = new JScrollPane(userTable);
		
		userCompse();
		userScrollPane.setBounds(0,40,685,200);
		ListU.add(userScrollPane);
		ListU.setResizable(false);
		ListU.setSize(700,500);
		
		Dimension frameSize = ListU.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		ListU.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		ListU.setVisible(true);
	}
	
	public void infoFrame() {
		//나의 정보
		ListInfo = new JFrame("내정보");
		ListInfo.setLayout(null);
		
		userInfoCompse();
		ListInfo.setResizable(false);
		ListInfo.setSize(300,500);
		
		Dimension frameSize = ListInfo.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		ListInfo.setLocation(((screenSize.width - frameSize.width)/2)+500, (screenSize.height - frameSize.height)/2);
		ListInfo.setVisible(true);
	}
	
	public void loadListData(ArrayList<StoreBean> val_list) {
		list = val_list;
		rowData = new Object[list.size()][columnNames.length];
		fillRowData();
		
		table = new JTable (rowData,columnNames);
		scrollPane.remove(table);
		table.revalidate();
		table.repaint();
		scrollPane.setViewportView(table);
	}
	public void loadUserListData(ArrayList<StoreBean> val_list) {
		listUser = val_list;
		rowData = new Object[listUser.size()][columnUsers.length];
		fillUserRowData();
		
		userTable = new JTable (rowData,columnUsers);
		userTable.addMouseListener(new MouseHandler());
		scrollPane.remove(userTable);
		userTable.revalidate();
		userTable.repaint();
		userScrollPane.setViewportView(userTable);
	}

	private void compse(int rank) {
		//사용자 등급에 따른 UI변경
		JPanel pSouth = new JPanel();
		JPanel Radio = new JPanel();
		ButtonGroup userRg = new ButtonGroup(); 
		
		Radio.setLayout(null);
		pSouth.setLayout(null);
		Radio.setBounds(0, 0, 700, 40);
		pSouth.setBounds(0, 250, 700, 400);
		Radio.add(sherchBCombo1);
		sherchBCombo1.setBounds(110, 0, 60, 30);
		for(int i=0;i<userRadioName.length;i++) {
			oRadio[i] = new JRadioButton(userRadioName[i]);
			userRg.add(oRadio[i]);
			Radio.add(oRadio[i]);
		}
		oRadio[0].setBounds(180, 0, 75, 30);
		oRadio[1].setBounds(255, 0, 75, 30);
		Radio.add(sherchBCombo2);   
		sherchBCombo2.setBounds(340, 0, 60, 30);
		Radio.add(bookSerch);
		bookSerch.setBounds(410,0,150,30);
		Radio.add(btnBserch);
		btnBserch.setBounds(570,0,80,28);
		
		oRadio[0].setSelected(true);
		btnBserch.addActionListener(this);
		
		if(rank != 2) {
			for(int i=0;i<userBtn.length;i++) {
				btnU[i] = new JButton(userBtn[i]);
				btnU[i].addActionListener(this);
				int w = (700/userBtn.length);
				btnU[i].setBounds(i*w+35, 160, 100, 30);
				pSouth.add(btnU[i]);
			}
		}else {
			for(int i=0;i<adminBtn.length;i++) {
				btnA[i] = new JButton(adminBtn[i]);
				btnA[i].addActionListener(this);
				int w = (700/adminBtn.length);
				btnA[i].setBounds(i*w+13, 160, 100, 30);
				pSouth.add(btnA[i]);
			}
		}
		ListF.add(Radio);
		ListF.add(pSouth);
	}
	
	private void userCompse() {
		JPanel pRadio = new JPanel();
		JPanel pSouth = new JPanel();
		ButtonGroup userRg = new ButtonGroup(); 
		
		pRadio.setLayout(null);
		pSouth.setLayout(null);
		pRadio.setBounds(0, 0, 700, 40);
		pSouth.setBounds(0, 250, 700, 400);
		pRadio.add(sherchCombo1);
		sherchCombo1.setBounds(110, 0, 60, 30);
		for(int i=0;i<userRadioName.length;i++) {
			oRadio[i] = new JRadioButton(userRadioName[i]);
			userRg.add(oRadio[i]);
			pRadio.add(oRadio[i]);
		}
		oRadio[0].setBounds(180, 0, 75, 30);
		oRadio[1].setBounds(255, 0, 75, 30);
		pRadio.add(sherchCombo2);   
		sherchCombo2.setBounds(340, 0, 60, 30);
		pRadio.add(userSerch);
		userSerch.setBounds(410,0,150,30);
		pRadio.add(btnUserch);
		btnUserch.setBounds(570,0,80,28);
		
		oRadio[0].setSelected(true);
		btnUserch.addActionListener(this);
		
		btnAuEdit.addActionListener(this);
		btnAuDis.addActionListener(this);
		btnAuCencle.addActionListener(this);
		
		btnAuEdit.setBounds(80,300,80,25);
		btnAuDis.setBounds(130,300,80,25);
		btnAuCencle.setBounds(180,300,80,25);
		
		pRadio.setBounds(0, 3, 700, 35);
		ListU.add(pRadio);
		//pInfo
		
		JLabel lblName = new JLabel("이름");
		JLabel lblId = new JLabel("아이디");
		JLabel lblPw = new JLabel("비밀번호");
		JLabel lblAge = new JLabel("나이");
		JLabel lblGender = new JLabel("성별");
		JLabel lblAddress = new JLabel("거주지");
		JLabel lblEmail = new JLabel("이메일");
		JLabel lblSign_up = new JLabel("가입일");
		JLabel lblRank = new JLabel("등급");
		
		pSouth.add(lblName);
		lblName.setBounds(100, 40, 70, 30);
		pSouth.add(lblAge);    
		lblPw.setBounds(370, 10, 70, 30);
		pSouth.add(lblId);      
		lblId.setBounds(100, 10, 70, 30);
		pSouth.add(lblPw);      
		lblAge.setBounds(370, 40, 40, 30);
		pSouth.add(lblGender);  
		lblGender.setBounds(100, 70, 40, 30);
		pSouth.add(lblAddress); 
		lblAddress.setBounds(370, 70, 40, 30);
		pSouth.add(lblSign_up); 
		lblSign_up.setBounds(100, 100, 40, 30);
		pSouth.add(lblEmail);   
		lblEmail.setBounds(370, 100, 40, 30);
		pSouth.add(lblRank);    
		lblRank.setBounds(100, 130, 40, 30);
		pSouth.add(txtPId);
		txtPId.setBounds(150, 12, 140, 25);
		pSouth.add(txtPName);
		txtPName.setBounds(150, 42, 140, 25);
		pSouth.add(txtPPw);
		txtPPw.setBounds(430, 12, 140, 25);
		pSouth.add(txtPAge);
		txtPAge.setBounds(430, 42, 140, 25);
		pSouth.add(txtPGender);
		txtPGender.setBounds(150, 72, 140, 25);
		pSouth.add(txtPAddress);
		txtPAddress.setBounds(430, 72, 140, 25);
		pSouth.add(txtPEmail);
		txtPEmail.setBounds(430, 102, 140, 25);
		pSouth.add(txtPSign_up);
		txtPSign_up.setBounds(150, 102, 140, 25);
		pSouth.add(txtPRank);
		txtPRank.setBounds(150, 132, 60, 25);
		pSouth.add(lblPRank_write);
		lblPRank_write.setBounds(217, 132, 60, 25);
		
		pSouth.add(btnAuEdit);
		btnAuEdit.setBounds(180, 170, 80, 25);
		pSouth.add(btnAuDis);
		btnAuDis.setBounds(310, 170, 80, 25);
		pSouth.add(btnAuCencle);
		btnAuCencle.setBounds(440, 170, 80, 25);
		ListU.add(pSouth,"South");
	}
	
	private void userInfoCompse() {
		
	}

	private void fillRowData() {
		//리스트
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
	
	private void fillUserRowData() {
		//유저 리스트
		Object[] arr = listUser.toArray();
		int cnt = 0;
		
		for(int i=0;i<arr.length;i++) {
			StoreBean sb = (StoreBean)arr[i];
			
			rowData[i][cnt++] = sb.getNo();
			rowData[i][cnt++] = sb.getName();
			rowData[i][cnt++] = sb.getId();
			rowData[i][cnt++] = sb.getPw();
			rowData[i][cnt++] = sb.getAge();
			rowData[i][cnt++] = sb.getGender();
			rowData[i][cnt++] = sb.getAddress();
			rowData[i][cnt++] = sb.getEmail();
			rowData[i][cnt++] = sb.getSign_up();
			rowData[i][cnt++] = sb.getRank();
			rowData[i][cnt++] = sb.getRental_cnt();
			cnt = 0;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == loginBtn) {
			StoreBean userData = dao.checkUser(txtId.getText().trim(),txtPw.getText().trim());
			if(userData.getNo() != 0) {
				JOptionPane.showMessageDialog(this,"로그인 되었습니다.","로그인",JOptionPane.DEFAULT_OPTION);
				setVisible(false);
				sm.ListLoad(userData);
			}else {
				JOptionPane.showMessageDialog(this,"ID 또는 PW 를 확인해주세요.","로그인",JOptionPane.WARNING_MESSAGE);
			}
		}else if(obj == btnA[0]){
			insertInit();
		}else if(obj == btnInsert){
			int price = 0;
			boolean chk = true;
			String pub = "sysdate";
			StoreBean sb = new StoreBean();
			if(txtTitle.getText().equals("")) {
				JOptionPane.showMessageDialog(this,"제목을 입력해주세요","에러 발생",JOptionPane.ERROR_MESSAGE);
				chk = false;
			}
			if(txtAuthor.getText().equals("")) {
				JOptionPane.showMessageDialog(this,"저자를 입력해주세요","에러 발생",JOptionPane.ERROR_MESSAGE);
				chk = false;
			}
			if(!txtPub_date.getText().equals("")) {
				pub = txtPub_date.getText();
			}
			try {
				price = Integer.parseInt(txtPrice.getText());
			}catch(NumberFormatException inertFormatE) { 
				if(!txtPrice.getText().equals("")) {
					chk = false;
					JOptionPane.showMessageDialog(this,"가격은 숫자만 입력해주세요","에러 발생",JOptionPane.ERROR_MESSAGE);
				}
			}
			sb.setTitle(txtTitle.getText());
			sb.setAuthor(txtAuthor.getText());
			sb.setPrice(price);
			sb.setPublisher(txtPublisher.getText());
			sb.setPub_date(pub);
			
			if(chk) {
				int cnt = sm.insertBook(sb);
				if(cnt == 0) {
					JOptionPane.showMessageDialog(this,"등록에 실패하였습니다.","등록 실패",JOptionPane.ERROR_MESSAGE);
				}else {
					ListFI.setVisible(false);
					loadListData(sm.getAllUserList());
				}
			}
		}else if(obj == btnCancel){
			clearData();
			ListFI.setVisible(false);
		}else if(obj == btnA[1]){
			int bookno =Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
			String bookName =table.getValueAt(table.getSelectedRow(), 1).toString();
			int result = JOptionPane.showConfirmDialog(this,"'"+bookName+"'을 삭제 하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION) {
				int cnt = sm.deleteBook(bookno);
				if(cnt == 0) {
					JOptionPane.showMessageDialog(this,"삭제에 실패하였습니다.","등록 실패",JOptionPane.ERROR_MESSAGE);
				}else {
					loadListData(sm.getAllUserList());
				}
			}
		}else if(obj == btnA[2]){
			userFram();
		}else if(obj == btnUserch){
			//order , 조건 , 값
			String[] sqlStr = new String[4]; 
			if(oRadio[0].isSelected()) {
				sqlStr[0] = "asc";
			}else {
				sqlStr[0] = "desc";
			}
			
			//order by
			switch(sherchCombo1.getItemAt(sherchCombo1.getSelectedIndex())) {
				case "번호":
					sqlStr[1] = "no";
					break;
				case "이름":
					sqlStr[1] = "name";
					break;
				case "주소":
					sqlStr[1] = "address";
					break;
				case "이메일":
					sqlStr[1] = "email";
					break;
				case "등급":
					sqlStr[1] = "rank";
					break;
			}
			
			//where
			switch(sherchCombo2.getItemAt(sherchCombo2.getSelectedIndex())) {
			case "번호":
				sqlStr[2] = "no";
				break;
			case "이름":
				sqlStr[2] = "name";
				break;
			case "주소":
				sqlStr[2] = "address";
				break;
			case "이메일":
				sqlStr[2] = "email";
				break;
			case "등급":
				sqlStr[2] = "rank";
				break;
			}
			sqlStr[3] = userSerch.getText();
			
			ArrayList<StoreBean> list = sm.selectBookUser(sqlStr);
			loadUserListData(list);
		}else if(obj == btnAuEdit){
			StoreBean vo = new StoreBean();
			vo.setNo(Integer.parseInt(userTable.getValueAt(userTable.getSelectedRow(),0).toString()));
			vo.setName(txtPName.getText());
			vo.setId(txtPId.getText());
			vo.setPw(txtPPw.getText());
			vo.setAge(Integer.parseInt(txtPAge.getText()));
			vo.setGender(txtPGender.getText());
			vo.setSign_up(txtPSign_up.getText());
			vo.setRank(Integer.parseInt(txtPRank.getText()));
			
			vo.setEmail(txtPEmail.getText());
			vo.setAddress(txtPAddress.getText());
			
			int cnt = sm.updateUserData(vo);
			if(cnt == 0) {
				JOptionPane.showMessageDialog(this,"수정에 실패하였습니다.","등록 실패",JOptionPane.ERROR_MESSAGE);
			}else {
				ArrayList<StoreBean> list = sm.selectBookUser(null);
				loadUserListData(list);
				clearUserData();
			}
		}else if(obj == btnAuDis){
			int chk = JOptionPane.showConfirmDialog(this,"해당 유저를 삭제 하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
			if(chk == JOptionPane.YES_OPTION) {
				int no = Integer.parseInt(userTable.getValueAt(userTable.getSelectedRow(),0).toString());
				int cnt = sm.deleteUserData(no);
				if(cnt == 0) {
					JOptionPane.showMessageDialog(this,"삭제에 실패하였습니다.","수정 실패",JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(this,"수정되었습니다.","수정 완료",JOptionPane.DEFAULT_OPTION);
					ArrayList<StoreBean> list = sm.selectBookUser(null);
					loadUserListData(list);
					clearUserData();
				}
			}
		}else if(obj == btnAuCencle){
			clearUserData();
			ListU.setVisible(false);
		}else if(obj == btnBserch){
			//order , 조건 , 값
			String[] sqlStr = new String[4]; 
			if(oRadio[0].isSelected()) {
				sqlStr[0] = "asc";
			}else {
				sqlStr[0] = "desc";
			}
			
			//order by
			switch(sherchBCombo1.getItemAt(sherchBCombo1.getSelectedIndex())) {
				case "번호":
					sqlStr[1] = "no";
					break;
				case "책이름":
					sqlStr[1] = "title";
					break;
				case "저자":
					sqlStr[1] = "author";
					break;
				case "출판사":
					sqlStr[1] = "publisher";
					break;
			}
			
			//where
			switch(sherchBCombo2.getItemAt(sherchBCombo2.getSelectedIndex())) {
				case "번호":
					sqlStr[2] = "no";
					break;
				case "책이름":
					sqlStr[2] = "title";
					break;
				case "저자":
					sqlStr[2] = "author";
					break;
				case "출판사":
					sqlStr[2] = "publisher";
					break;
			}
			sqlStr[3] = bookSerch.getText();
			
			ArrayList<StoreBean> list = sm.selectBookData(sqlStr);
			loadListData(list);
		}else if(obj == btnA[3]){
			int bookNo =Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
			
			int cnt = sm.coReturnBook(bookNo);
			if(cnt > 2) {
				JOptionPane.showMessageDialog(this,"반납중 오류가 발생하였습니다.","등록 실패",JOptionPane.ERROR_MESSAGE);
			}else {
				loadListData(sm.getAllBookList());
			}
		}else if(obj == btnA[4]){
		}else if(obj == btnU[0]){
			if(table.getValueAt(table.getSelectedRow(),6).toString()=="불가능"?true:false) {
				JOptionPane.showMessageDialog(this,"대여가 불가능 합니다.","대여 실패",JOptionPane.ERROR_MESSAGE);
			}else {
				int chk = JOptionPane.showConfirmDialog(this,"대여하시겠습니까?\n(최대 3권까지 대여가능)","확인",JOptionPane.YES_NO_OPTION);
				if(chk == JOptionPane.YES_OPTION) {
					boolean maxRetalchk = sm.checkRentalCnt();
					if(maxRetalchk) {
						int bookNo =Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
						
						int cnt = sm.userRentalBook(bookNo);
						if(cnt > 2) {
							JOptionPane.showMessageDialog(this,"대여중 오류가 발생하였습니다.","대여 실패",JOptionPane.ERROR_MESSAGE);
						}else {
							loadListData(sm.getAllBookList());
						}
					}else {
						JOptionPane.showMessageDialog(this,"대여 최대 개수를 초과하였습니다.","대여 실패",JOptionPane.ERROR_MESSAGE);
					}
				}	
			}
		}else if(obj == btnU[1]){
			int bookNo = Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString());
			boolean userChk = sm.getRentalUserNo(bookNo);
			if(userChk) {
				int chk = JOptionPane.showConfirmDialog(this,"반납하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
				if(chk==JOptionPane.YES_OPTION) {
					int cnt = sm.userReturnBook(bookNo);
					if(cnt > 2) {
						JOptionPane.showMessageDialog(this,"반납중 오류가 발생하였습니다.","반납 실패",JOptionPane.ERROR_MESSAGE);
					}else {
						loadListData(sm.getAllBookList());
					}
				}
			}else {
				JOptionPane.showMessageDialog(this,"빌린 도서만 반납 가능합니다.","반납 실패",JOptionPane.ERROR_MESSAGE);
			}
		}else if(obj == btnU[2]){
			infoFrame();
		}else if(obj == btnU[3]){
		}
	}

	private void insertInit() {
		ListFI = new JFrame("대장서점[책 등록]");
//		ListFI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ListFI.setLayout(null);
		ListFI.setResizable(false);

		clearData();
		ListFI.setSize(250,260);
		
		Dimension frameSize = ListFI.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		ListFI.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		
		JLabel lblTitle = new JLabel("제목");
		JLabel lblAuthor = new JLabel("저자");
		JLabel lblPrice = new JLabel("가격");
		JLabel lblPublisher = new JLabel("출판사");
		JLabel lblPub_date = new JLabel("출간일");
		
		lblTitle.setBounds(30,20,100,20);
		lblAuthor.setBounds(30,50,100,20);
		lblPrice.setBounds(30,80,100,20);
		lblPublisher.setBounds(30,110,100,20);
		lblPub_date.setBounds(30,140,100,20);
		txtTitle.setBounds(80,20,130,20);
		txtAuthor.setBounds(80,50,130,20);
		txtPrice.setBounds(80,80,130,20);
		txtPublisher.setBounds(80,110,130,20);
		txtPub_date.setBounds(80,140,130,20);
		btnCancel.setBounds(30,180,80,25);
		btnInsert.setBounds(130,180,80,25);
		btnCancel.addActionListener(this);
		btnInsert.addActionListener(this);
		
		ListFI.add(lblTitle);
		ListFI.add(lblAuthor);
		ListFI.add(lblPrice);
		ListFI.add(lblPublisher);
		ListFI.add(lblPub_date);
		ListFI.add(txtTitle);
		ListFI.add(txtAuthor);
		ListFI.add(txtPrice);
		ListFI.add(txtPublisher);
		ListFI.add(txtPub_date);
		ListFI.add(btnInsert);
		ListFI.add(btnCancel);
		
		ListFI.setVisible(true);
	}
	
	private void clearData() {
		txtTitle.setText("");
		txtAuthor.setText("");
		txtPrice.setText("");
		txtPublisher.setText("");
		txtPub_date.setText("");
	}
	
	private void clearUserData() {
		txtPId.setText("");
		txtPName.setText("");
		txtPPw.setText("");
		txtPAge.setText("");
		txtPGender.setText("");
		txtPAddress.setText("");
		txtPEmail.setText("");
		txtPSign_up.setText("");
		txtPRank.setText("");
		lblPRank_write.setText("");
	}
	
	class MouseHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			txtPName.setText(userTable.getValueAt(userTable.getSelectedRow(), 1).toString());
			txtPId.setText(userTable.getValueAt(userTable.getSelectedRow(), 2).toString());
			txtPPw.setText(userTable.getValueAt(userTable.getSelectedRow(), 3).toString());
			txtPAge.setText(userTable.getValueAt(userTable.getSelectedRow(), 4).toString());
				txtPGender.setText(userTable.getValueAt(userTable.getSelectedRow(), 5).toString());
			try {
				txtPAddress.setText(userTable.getValueAt(userTable.getSelectedRow(), 6).toString());
			}catch(NullPointerException ne) {
				txtPAddress.setText("");
			}
			try {
				txtPEmail.setText(userTable.getValueAt(userTable.getSelectedRow(), 7).toString());
			}catch(NullPointerException ne) {
				txtPEmail.setText("");
			}
			try {
				txtPSign_up.setText(userTable.getValueAt(userTable.getSelectedRow(), 8).toString());
			}catch(NullPointerException ne) {
				txtPSign_up.setText("");
			}
			String rank = userTable.getValueAt(userTable.getSelectedRow(), 9).toString();
			txtPRank.setText(rank);
			lblPRank_write.setText(rankList.get(Integer.parseInt(rank)));
		}
	}
	class KeyHandler extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				loginBtn.doClick();
			}
		}
	}
}