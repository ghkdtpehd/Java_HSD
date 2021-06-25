import java.awt.Color;
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

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class StoreFrame extends JFrame implements ActionListener{
	boolean idDuChk = false;
	StoreMain sm = new StoreMain();
	StoreDao dao = new StoreDao();
	Container loginC = null;
	JTextField txtId = null;
	JPasswordField txtPw = null;
	JButton loginBtn = new JButton();
	JFrame ListF = null;
	JFrame ListSignup = null;
	JFrame ListFI = null;
	JFrame ListU = null;
	JFrame ListUa = null;
	JFrame ListInfo = null;
	JFrame ListA = null;
	Container ListC = null;
	JTable table = null;
	JTable userTable = null;
	JTable applayTable = null;
	private JScrollPane scrollPane = null;
	private JScrollPane userScrollPane = null;
	private JScrollPane applayScrollPane = null;

	private HashMap<Integer,String> rankList = new HashMap<Integer,String>();
	private String[] columnNames = {"번호","책이름","저자","단가","출판사","입고일자","대여여부"};
	private String[] columnUsers = {"번호","이름","아이디","비밀번호","나이","성별","거주지","이메일","가입일","등급","대여한책"};
	private String[] columnApplay = {"번호","제목","장르","저자","출판사","내용","신청일","입고여부","신청자"};
	private Object[][] rowData = null;
	ArrayList<StoreBean> list = null;
	ArrayList<StoreBean> listUser = null;
	ArrayList<StoreBean> applayUser = null;
	
	String[] serchStr = {"번호","이름","주소","이메일","등급"};
	String[] serchBookStr = {"번호","책이름","저자","출판사"};
	String[] serchApplayStr = {"번호","책이름","저자","출판사","사용자번호"};
	String[] adminBtn = {"등록","삭제","회원목록","강제반납","신청목록"}; 
	String[] userBtn = {"대여","반납","내정보","책신청"}; 
	String[] BookInertBtn = {"대여","반납"}; 
	private JButton btnSOk = new JButton("확인");
	private JButton btnSCen =  new JButton("취소");
	private JButton btnSIdChk =  new JButton("중복체크");
	private JButton btnInsert = new JButton("저장");
	private JButton btnCancel =  new JButton("취소");
	private JButton btnAuEdit =  new JButton("수정");
	private JButton btnAuDis =  new JButton("탈퇴");
	private JButton btnInfoEidt =  new JButton("수정");
	private JButton btnInfoCan =  new JButton("돌아가기");
	private JButton btnAuCencle =  new JButton("취소");
	private JButton btnApplay =  new JButton("등록");
	private JButton btnACencle =  new JButton("취소");
	private JButton[] btnA = new JButton[adminBtn.length];
	private JButton[] btnU = new JButton[userBtn.length];
	private JButton btnUserch = new JButton("검색");
	private JButton btnAserch = new JButton("검색");
	private JButton btnBserch = new JButton("검색");
	
	private JButton btnApplay1 = new JButton("미입고");
	private JButton btnApplay2 = new JButton("입고");
	private JButton btnApplay3 = new JButton("거부");
	private JButton btnApplayCan = new JButton("닫기");
	
	String[] userRadioName = {"오름차순","내림차순"};
	String[] InfoRadioName = {"남자","여자"};
	JRadioButton[] oRadio = new JRadioButton[2];
	JRadioButton[] iRadio = new JRadioButton[2];
	JRadioButton[] aRadio = new JRadioButton[2];
	JRadioButton[] sRadio = new JRadioButton[2];
	JCheckBox achk0 = new JCheckBox("미입고");
	JCheckBox achk1 = new JCheckBox("입고");
	JCheckBox achk2 = new JCheckBox("거부");
	JComboBox<String> sherchCombo1 = new JComboBox<String>(serchStr);
	JComboBox<String> sherchCombo2 = new JComboBox<String>(serchStr);
	JComboBox<String> sherchBCombo1 = new JComboBox<String>(serchBookStr);
	JComboBox<String> sherchBCombo2 = new JComboBox<String>(serchBookStr);
	JComboBox<String> sherchACombo1 = new JComboBox<String>(serchApplayStr);
	JComboBox<String> sherchACombo2 = new JComboBox<String>(serchApplayStr);
	
	JLabel lblPSignUp = new JLabel("회원가입");
	JLabel lblPRank_write = new JLabel("");
	ImageIcon ReImg = new ImageIcon("src/refresh_icon.png");
	JLabel ReImgTable = new JLabel(ReImg);
	JLabel ReImgUserTable = new JLabel(ReImg);
	JTextField bookSerch = new JTextField(15);
	JTextField userSerch = new JTextField(15);
	JTextField applaySerch = new JTextField(20);
	JTextField txtTitle = new JTextField();
	JTextField txtAuthor = new JTextField();
	JTextField txtPrice = new JTextField();
	JTextField txtPublisher = new JTextField();
	JTextField txtPub_date = new JTextField();

	JTextField txtSName	= new JTextField(15);
	JTextField txtSId 	= new JTextField(15);
	JPasswordField txtSPw 	= new JPasswordField(15);
	JTextField txtSAge	= new JTextField(15);
	JTextField txtSAddress = new JTextField(15);
	JTextField txtSEmail = new JTextField(30);
	JTextField txtPName	= new JTextField(15);
	JTextField txtPId 	= new JTextField(15);
	JTextField txtPPw 	= new JPasswordField(15);
	JTextField txtPAge	= new JTextField(15);
	JTextField txtPGender = new JTextField(15);
	JTextField txtPAddress = new JTextField(15);
	JTextField txtPEmail = new JTextField(30);
	JTextField txtPSign_up = new JTextField(15);
	JTextField txtPRank = new JTextField(15);
	JTextField txtIName= new JTextField(15);
	JTextField txtIId= new JTextField(15);
	JPasswordField txtIPw= new JPasswordField(15);
	JTextField txtIAge= new JTextField(15);
	JTextField txtIAddress= new JTextField(15);
	JTextField txtIEmail= new JTextField(30);
	JTextField txtISign_up= new JTextField(15);
	JTextField txtATitle= new JTextField(20);
	JTextField txtAGenre= new JTextField(20);
	JTextField txtAAuthor= new JTextField(15);
	JTextField txtAPublisher= new JTextField(20);
	JTextArea txtAContent= new JTextArea();
	
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
		
		Font signupFont = new Font("고딕",Font.PLAIN,11);
		lblPSignUp.setBounds(50,110,100,20);
		lblPSignUp.setFont(signupFont);
		
		txtId.setBounds(120,50,130,20);
		txtId.setFont(loginFont);
		txtId.addKeyListener(new KeyHandler());
		txtPw.setBounds(120,80,130,20);
		txtPw.setFont(loginFont);
		txtPw.addKeyListener(new KeyHandler());
		
		lblPSignUp.addMouseListener(new MouseHandler());
		
		loginBtn.setText("로그인");
		loginBtn.setBounds(260,50,70,50);
		
		loginC.add(lblPSignUp);
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
	
	public void signupFrame() {
		ListSignup = new JFrame("회원가입");
		ListSignup.setLayout(null);
		
		singupCompse();

		ListSignup.setResizable(false);
		ListSignup.setSize(450, 300);
		
		Dimension frameSize = ListSignup.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		ListSignup.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		ListSignup.setVisible(true);
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
		scrollPane.setBounds(0,40,685,330);
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
	
	public void applayFrame() {
		//책신청
		ListUa = new JFrame("책신청");
		ListUa.setLayout(null);
		
		applayCompse();
		ListUa.setResizable(false);
		ListUa.setSize(400,500);
		
		Dimension frameSize = ListUa.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		ListUa.setLocation((screenSize.width - frameSize.width)/2+550, (screenSize.height - frameSize.height)/2);
		ListUa.setVisible(true);
	}

	public void applayAFrame() {
		//신청관리
		ListA = new JFrame("신청관리");
		ListA.setLayout(null);
		
		applayUser = sm.getAllApplayList(); 
		rowData = new Object[applayUser.size()][columnApplay.length];
		fillApplayRowData();

		applayTable = new JTable (rowData,columnApplay);
		applayScrollPane = new JScrollPane(applayTable);
		
		applayACompse();
		applayScrollPane.setBounds(0,40,770,330);
		ListA.add(applayScrollPane);
		ListA.setResizable(false);
		ListA.setSize(780,500);
		
		Dimension frameSize = ListA.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		ListA.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		ListA.setVisible(true);
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
	
	public void loadApplayListData(ArrayList<StoreBean> val_list) {
		applayUser = val_list;
		rowData = new Object[applayUser.size()][columnApplay.length];
		fillApplayRowData();
		
		applayTable = new JTable (rowData,columnApplay);
		applayScrollPane.remove(applayTable);
		applayTable.revalidate();
		applayTable.repaint();
		applayScrollPane.setViewportView(applayTable);
	}

	private void compse(int rank) {
		//사용자 등급에 따른 UI변경
		JPanel pSouth = new JPanel();
		JPanel Radio = new JPanel();
		ButtonGroup userRg = new ButtonGroup(); 
		
		Radio.setLayout(null);
		pSouth.setLayout(null);
		ReImgTable.setBounds(640, 4, 30, 30);
		ReImgTable.addMouseListener(new MouseHandler());
		Radio.setBounds(0, 3, 700, 35);
		pSouth.setBounds(0, 250, 700, 400);
		Radio.add(sherchBCombo1);
		sherchBCombo1.setBounds(80, 2, 60, 30);
		for(int i=0;i<userRadioName.length;i++) {
			oRadio[i] = new JRadioButton(userRadioName[i]);
			userRg.add(oRadio[i]);
			Radio.add(oRadio[i]);
		}
		oRadio[0].setBounds(140, 2, 75, 30);
		oRadio[1].setBounds(215, 2, 75, 30);
		Radio.add(sherchBCombo2);   
		sherchBCombo2.setBounds(300,2, 60, 30);
		Radio.add(bookSerch);
		bookSerch.setBounds(370,2,150,30);
		Radio.add(btnBserch);
		btnBserch.setBounds(530,2,80,28);
		
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
		ListF.add(ReImgTable);
		ListF.add(Radio);
		ListF.add(pSouth);
	}
	
	private void singupCompse() {
		ButtonGroup userRg = new ButtonGroup();

		for(int i=0;i<InfoRadioName.length;i++) {
			sRadio[i] = new JRadioButton(InfoRadioName[i]);
			userRg.add(sRadio[i]);
			ListSignup.add(sRadio[i]);
		}
		
		JLabel lblId = new JLabel("아이디");
		JLabel lblPw = new JLabel("비밀번호");
		JLabel lblName = new JLabel("이름");
		JLabel lblAge = new JLabel("나이");
		JLabel lblGender = new JLabel("성별");
		JLabel lblAddress = new JLabel("거주지");
		JLabel lblEmail = new JLabel("이메일");
		
		lblId.setBounds(30,30,50,30);
		lblPw.setBounds(250,30,50,30);
		lblName.setBounds(30,70,50,30);
		lblAge.setBounds(230,70,50,30);
		lblGender.setBounds(30,110,50,30);
		lblAddress.setBounds(30,150,50,30);
		lblEmail.setBounds(230,150,50,30);
		
		txtSId.setBounds(70, 32, 95, 25);
		btnSIdChk.setBounds(168, 31, 80, 25);
		Font btnFont = new Font("고딕",Font.PLAIN,11);
		btnSIdChk.setFont(btnFont);
		txtSPw.setBounds(300, 32, 95, 25);
		txtSName.setBounds(90, 72, 110, 25);
		txtSAge.setBounds(290, 72, 110, 25);
		sRadio[0].setBounds(90,112,70,25);
		sRadio[1].setBounds(170,112,70,25);
		txtSAddress.setBounds(90, 152, 110, 25);
		txtSEmail.setBounds(290, 152, 110, 25);
		
		btnSOk.setBounds(67, 200, 90, 30);
		btnSCen.setBounds(280, 200, 90, 30);
		btnSIdChk.addActionListener(this);
		btnSOk.addActionListener(this);
		btnSCen.addActionListener(this);
		
		ListSignup.add(lblId);
		ListSignup.add(btnSIdChk);
		ListSignup.add(lblPw);
		ListSignup.add(lblName);
		ListSignup.add(lblAge);
		ListSignup.add(lblGender);
		ListSignup.add(lblAddress);
		ListSignup.add(lblEmail);
		ListSignup.add(txtSId);
		ListSignup.add(txtSPw);
		ListSignup.add(txtSName);
		ListSignup.add(txtSAge);
		ListSignup.add(txtSAddress);
		ListSignup.add(txtSEmail);
		ListSignup.add(btnSOk);
		ListSignup.add(btnSCen);
	}
	
	private void userCompse() {
		JPanel pRadio = new JPanel();
		JPanel pSouth = new JPanel();
		ButtonGroup userRg = new ButtonGroup(); 
		
		pRadio.setLayout(null);
		pSouth.setLayout(null);
		ReImgUserTable.setBounds(640, 4, 30, 30);
		ReImgUserTable.addMouseListener(new MouseHandler());
		pRadio.add(ReImgUserTable);
		pRadio.setBounds(0, 0, 700, 40);
		pSouth.setBounds(0, 250, 700, 400);
		pRadio.add(sherchCombo1);
		sherchCombo1.setBounds(80, 0, 60, 30);
		for(int i=0;i<userRadioName.length;i++) {
			oRadio[i] = new JRadioButton(userRadioName[i]);
			userRg.add(oRadio[i]);
			pRadio.add(oRadio[i]);
		}
		oRadio[0].setBounds(140, 0, 75, 30);
		oRadio[1].setBounds(215, 0, 75, 30);
		pRadio.add(sherchCombo2);   
		sherchCombo2.setBounds(300, 0, 60, 30);
		pRadio.add(userSerch);
		userSerch.setBounds(370,0,150,30);
		pRadio.add(btnUserch);
		btnUserch.setBounds(530,0,80,28);
		
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
		ListU.add(pSouth);
	}
	
	private void userInfoCompse() {
		JPanel iPRadio = new JPanel();
		ButtonGroup inforRg = new ButtonGroup(); 
		
		StoreBean sb =  sm.getMyInfoData();
		
		Font infoGenderFont = new Font("Fixedsys", Font.BOLD,13);
		Font infoFont = new Font("Fixedsys", Font.BOLD,14);
		
		iPRadio.setLayout(null);
		for(int i=0;i<InfoRadioName.length;i++) {
			iRadio[i] = new JRadioButton(InfoRadioName[i]);
			inforRg.add(iRadio[i]);
			iPRadio.add(iRadio[i]);
			iRadio[i].setFont(infoGenderFont);
		}
		JLabel lblIName = new JLabel("이름"); 
		lblIName.setFont(infoFont);
		JLabel lblIId = new JLabel("아이디"); 
		lblIId.setFont(infoFont);
		JLabel lblIPw = new JLabel("비밀번호"); 
		lblIPw.setFont(infoFont);
		JLabel lblIAge = new JLabel("나이"); 
		lblIAge.setFont(infoFont);
		JLabel lblIGender = new JLabel("성별"); 
		lblIGender.setFont(infoFont);
		JLabel lblIAddress = new JLabel("거주지"); 
		lblIAddress.setFont(infoFont);
		JLabel lblIEmail = new JLabel("이메일"); 
		lblIEmail.setFont(infoFont);
		JLabel lblISign_up = new JLabel("가입일"); 
		lblISign_up.setFont(infoFont);
		
		lblIName.setBounds(30, 50, 80, 30);
		lblIId.setBounds(30, 90, 80, 30);
		lblIPw.setBounds(30, 130, 80, 30);
		lblIAge.setBounds(30, 170, 80, 30);
		lblIGender.setBounds(30, 210, 80, 30);
		lblIAddress.setBounds(30, 250, 80, 30);
		lblIEmail.setBounds(30, 290, 80, 30);
		lblISign_up.setBounds(30, 330, 80, 30);
		
		txtIName.setBounds(100,52,150,25);
		txtIName.setEditable(false);
		txtIId.setBounds(100,92,150,25);
		txtIId.setEditable(false);
		txtIPw.setBounds(100,132,150,25);
		txtIAge.setBounds(100,172,150,25);
		iRadio[0].setBounds(100,212,80,25);
		iRadio[1].setBounds(180,212,80,25);
		txtIAddress.setBounds(100,252,150,25);
		txtIEmail.setBounds(100,292,150,25);
		txtISign_up.setBounds(100,332,150,25);
		txtISign_up.setEditable(false);
		
		btnInfoEidt.setBounds(26,400,90,25);
		btnInfoCan.setBounds(173,400,90,25);
		btnInfoEidt.addActionListener(this);
		btnInfoCan.addActionListener(this);
		
		txtIName.setText(sb.getName());
		txtIId.setText(sb.getId());
		txtIPw.setText(sb.getPw());
		txtIAge.setText(String.valueOf( sb.getAge()));
		switch(sb.getGender()) {
			case "남자":
				iRadio[0].setSelected(true);
				break;
			case "여자":
				iRadio[1].setSelected(true);
				break;
		}
		txtIAddress.setText(sb.getAddress());
		txtIEmail.setText(sb.getEmail());
		txtISign_up.setText(sb.getSign_up());
		
		ListInfo.add(btnInfoEidt);
		ListInfo.add(btnInfoCan);
		ListInfo.add(lblIName);
		ListInfo.add(lblIId);
		ListInfo.add(lblIPw);
		ListInfo.add(lblIAge);
		ListInfo.add(lblIGender);
		ListInfo.add(lblIAddress);
		ListInfo.add(lblIEmail);
		ListInfo.add(lblISign_up);
		ListInfo.add(txtIName);
		ListInfo.add(txtIId);
		ListInfo.add(txtIPw);
		ListInfo.add(txtIAge);
		ListInfo.add(iRadio[0]);
		ListInfo.add(iRadio[1]);
		ListInfo.add(txtIAddress);
		ListInfo.add(txtIEmail);
		ListInfo.add(txtISign_up);
	}
	
	private void applayCompse() {
		StoreBean sb =  sm.getMyInfoData();
		
		Font infoFont = new Font("Fixedsys", Font.BOLD,14);
		
		JLabel lblATitle = new JLabel("책제목"); 
		lblATitle.setFont(infoFont);
		JLabel lblAGenre = new JLabel("장르"); 
		lblAGenre.setFont(infoFont);
		JLabel lblAAuthor = new JLabel("작자"); 
		lblAAuthor.setFont(infoFont);
		JLabel lblAPublisher = new JLabel("출판사"); 
		lblAPublisher.setFont(infoFont);
		JLabel lblAContent = new JLabel("내용"); 
		lblAContent.setFont(infoFont);
		
		lblATitle.setBounds(30, 50, 80, 30);
		lblAGenre.setBounds(30, 90, 80, 30);
		lblAAuthor.setBounds(30, 130, 80, 30);
		lblAPublisher.setBounds(30, 170, 80, 30);
		lblAContent.setBounds(30, 210, 80, 30);
		
		txtATitle.setBounds(100,52,240,25);
		txtAGenre.setBounds(100,92,240,25);
		txtAAuthor.setBounds(100,132,240,25);
		txtAPublisher.setBounds(100,172,240,25);
		txtAContent.setBounds(100,212,240,170);
		Border border = BorderFactory.createLineBorder(Color.gray);
		txtAContent.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(1, 1, 1, 1)));
		txtAContent.setLineWrap(true);
		
		btnApplay.setBounds(50,400,100,25);
		btnACencle.setBounds(240,400,100,25);
		btnApplay.addActionListener(this);
		btnACencle.addActionListener(this);
		
		ListUa.add(btnApplay);
		ListUa.add(btnACencle);
		ListUa.add(lblATitle);
		ListUa.add(lblAGenre);
		ListUa.add(lblAAuthor);
		ListUa.add(lblAPublisher);
		ListUa.add(lblAContent);
		ListUa.add(txtATitle);
		ListUa.add(txtAGenre);
		ListUa.add(txtAAuthor);
		ListUa.add(txtAPublisher);
		ListUa.add(txtAContent);
	}
	
	private void applayACompse() {
		ButtonGroup userRg = new ButtonGroup(); 
		//ApplayRadioName
		sherchACombo1.setBounds(10, 5, 80, 30);
		ListA.add(sherchACombo1);
		sherchACombo2.setBounds(260, 5, 80, 30);
		ListA.add(sherchACombo2);   
		for(int i=0;i<userRadioName.length;i++) {
			aRadio[i] = new JRadioButton(userRadioName[i]);
			userRg.add(aRadio[i]);
			ListA.add(aRadio[i]);
		}
		aRadio[0].setSelected(true);
		aRadio[0].setBounds(100, 5, 75, 30);
		aRadio[1].setBounds(180, 5, 75, 30);
		applaySerch.setBounds(348,5,150,30);
		btnAserch.setBounds(500,5,60,30);
		btnAserch.addActionListener(this);
		btnApplay1.setBounds(37,400,120,30);
		btnApplay2.setBounds(231,400,120,30);
		btnApplay3.setBounds(424,400,120,30);
		btnApplayCan.setBounds(615,400,120,30);
		btnApplay1.addActionListener(this);
		btnApplay2.addActionListener(this);
		btnApplay3.addActionListener(this);
		btnApplayCan.addActionListener(this);
		
		achk0.setBounds(570, 5, 70, 30);
		achk1.setBounds(640, 5, 60, 30);
		achk2.setBounds(700, 5, 70, 30);
		achk0.setSelected(true);
		achk1.setSelected(true);
		achk2.setSelected(true);
		
		ListA.add(btnApplay1);
		ListA.add(btnApplay2);
		ListA.add(btnApplay3);
		ListA.add(btnApplayCan);
		ListA.add(btnAserch);
		ListA.add(applaySerch);
		ListA.add(achk0);
		ListA.add(achk1);
		ListA.add(achk2);
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
	
	private void fillApplayRowData() {
		//신청 리스트
		Object[] arr = applayUser.toArray();
		int cnt = 0;
		
		for(int i=0;i<arr.length;i++) {
			StoreBean sb = (StoreBean)arr[i];
			
			rowData[i][cnt++] = sb.getNo();
			rowData[i][cnt++] = sb.getTitle();
			rowData[i][cnt++] = sb.getGenre();
			rowData[i][cnt++] = sb.getAuthor();
			rowData[i][cnt++] = sb.getPublisher();
			rowData[i][cnt++] = sb.getContent();
			rowData[i][cnt++] = sb.getInputdate();
			switch(sb.getYn()) {
			case 0:
				rowData[i][cnt++] = "미입고";
				break;
			case 1:
				rowData[i][cnt++] = "입고";
				break;
			case 2:
				rowData[i][cnt++] = "거부";
				break;
			}
			rowData[i][cnt++] = sb.getUserno();
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
				dispose();
				sm.ListLoad(userData);
			}else {
				JOptionPane.showMessageDialog(this,"ID 또는 PW 를 확인해주세요.","로그인",JOptionPane.WARNING_MESSAGE);
			}
		}else if(obj == btnSIdChk){
			boolean chk = sm.checkId(txtSId.getText());
			idDuChk = false;
			if(chk) {
				JOptionPane.showMessageDialog(this,"이미 존재하는 ID입니다.","경고",JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(this,"사용가능한 ID입니다.","중복체크",JOptionPane.DEFAULT_OPTION);
				txtSId.setEnabled(false);
				idDuChk = true;
			}
		}else if(obj == btnSOk){
			if(idDuChk) {
				int cnt = 0;
				String[] sqlStr = new String[7]; 
				
				sqlStr[0] = txtSId.getText();
				sqlStr[1] = txtSPw.getText();
				sqlStr[2] = txtSName.getText();
				sqlStr[3] = txtSAge.getText();
				if(sRadio[0].isSelected()) {
					sqlStr[4] = "남자";
				}else if(sRadio[1].isSelected()){
					sqlStr[4] = "여자";
				}else {
					sqlStr[4] = "";
				}
				sqlStr[5] = txtIAddress.getText();
				sqlStr[6] = txtIEmail.getText();
				
				if(sqlStr[0].isEmpty()) {
					JOptionPane.showMessageDialog(this,"ID를 입력해주세요.\n중복체크를 해주십시오.","경고",JOptionPane.WARNING_MESSAGE);
				}else if(sqlStr[1].isEmpty()) {
					JOptionPane.showMessageDialog(this,"비밀번호를 입력해주세요.","경고",JOptionPane.WARNING_MESSAGE);
				}else if(sqlStr[2].isEmpty()) {
					JOptionPane.showMessageDialog(this,"이름을 입력해주세요.","경고",JOptionPane.WARNING_MESSAGE);
				}else if(sqlStr[3].isEmpty()) {
					JOptionPane.showMessageDialog(this,"나이를 입력해주세요.","경고",JOptionPane.WARNING_MESSAGE);
				}else if(sqlStr[4].isEmpty()) {
					JOptionPane.showMessageDialog(this,"성별을 선택해주세요.","경고",JOptionPane.WARNING_MESSAGE);
				}else {
					cnt = sm.InsertUser(sqlStr);
					if(cnt == 0) {
						JOptionPane.showMessageDialog(this,"회원가입에 실패하였습니다.","가입 실패",JOptionPane.ERROR_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(this,"회원 가입에 성공하였습니다.\n반갑습니다."+txtSName.getText()+"님","가입 완료",JOptionPane.DEFAULT_OPTION);
						ListSignupExit();
					}
				}
			}else {
				JOptionPane.showMessageDialog(this,"ID중복체크를 해주십시오.","경고",JOptionPane.WARNING_MESSAGE);
			}
		}else if(obj == btnSCen){
			ListSignupExit();
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
					ListFIExit();
					loadListData(sm.getAllBookList());
				}
			}
		}else if(obj == btnCancel){
			clearData();
			ListFIExit();
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
			ListUExit();
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
			applayAFrame();
		}else if(obj == btnApplay1){
			if(applayTable.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this,"변경할 행을 선택해주세요.","변경 실패",JOptionPane.ERROR_MESSAGE);
			}else {
				int chk = JOptionPane.showConfirmDialog(this,"변경 하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
				if(chk == JOptionPane.YES_OPTION) {
					int applayNo =Integer.parseInt(applayTable.getValueAt(applayTable.getSelectedRow(), 0).toString());
					
					int cnt = sm.userApplayChange(applayNo,0);
					if(cnt == 0) {
						JOptionPane.showMessageDialog(this,"변경중 오류가 발생하였습니다.","변경 실패",JOptionPane.ERROR_MESSAGE);
					}else {
						loadApplayListData(sm.getAllApplayList());
						JOptionPane.showMessageDialog(this,"변경되었습니다.","변경 완료",JOptionPane.DEFAULT_OPTION);
					}
				}	
			}
		}else if(obj == btnApplay2){
			if(applayTable.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this,"변경할 행을 선택해주세요.","변경 실패",JOptionPane.ERROR_MESSAGE);
			}else {
				int chk = JOptionPane.showConfirmDialog(this,"변경 하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
				if(chk == JOptionPane.YES_OPTION) {
					int applayNo =Integer.parseInt(applayTable.getValueAt(applayTable.getSelectedRow(), 0).toString());
					
					int cnt = sm.userApplayChange(applayNo,1);
					if(cnt == 0) {
						JOptionPane.showMessageDialog(this,"변경중 오류가 발생하였습니다.","변경 실패",JOptionPane.ERROR_MESSAGE);
					}else {
						loadApplayListData(sm.getAllApplayList());
						JOptionPane.showMessageDialog(this,"변경되었습니다.","변경 완료",JOptionPane.DEFAULT_OPTION);
					}
				}	
			}
		}else if(obj == btnApplay3){
			if(applayTable.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this,"변경할 행을 선택해주세요.","변경 실패",JOptionPane.ERROR_MESSAGE);
			}else {
				int chk = JOptionPane.showConfirmDialog(this,"변경 하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
				if(chk == JOptionPane.YES_OPTION) {
					int applayNo =Integer.parseInt(applayTable.getValueAt(applayTable.getSelectedRow(), 0).toString());
					
					int cnt = sm.userApplayChange(applayNo,2);
					if(cnt == 0) {
						JOptionPane.showMessageDialog(this,"변경중 오류가 발생하였습니다.","변경 실패",JOptionPane.ERROR_MESSAGE);
					}else {
						loadApplayListData(sm.getAllApplayList());
						JOptionPane.showMessageDialog(this,"변경되었습니다.","변경 완료",JOptionPane.DEFAULT_OPTION);
					}
				}	
			}
		}else if(obj == btnApplayCan){
			ListAExit();
		}else if(obj == btnAserch){
			String[] sqlStr = new String[7]; 
			if(aRadio[0].isSelected()) {
				sqlStr[0] = "asc";
			}else {
				sqlStr[0] = "desc";
			}
			//"번호","책이름","저자","출판사","사용자번호"
			switch(sherchACombo1.getItemAt(sherchBCombo1.getSelectedIndex())) {
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
				case "사용자번호":
					sqlStr[1] = "userno";
					break;
			}
			
			//where
			switch(sherchACombo2.getItemAt(sherchBCombo2.getSelectedIndex())) {
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
				case "사용자번호":
					sqlStr[2] = "userno";
					break;
			}
			sqlStr[3] = applaySerch.getText();
			if(achk0.isSelected()) {
				sqlStr[4] = "0";
			}else {
				sqlStr[4] = "";
			}
				
			if(achk1.isSelected()) {
				sqlStr[5] = "1";
			}else {
				sqlStr[5] = "";
			}
			if(achk2.isSelected()) {
				sqlStr[6] = "2";
			}else {
				sqlStr[6] = "";
			}
			ArrayList<StoreBean> list = sm.selectApplayData(sqlStr);
			loadApplayListData(list);
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
		}else if(obj == btnInfoEidt){
			int chk = JOptionPane.showConfirmDialog(this,"수정하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
			if(chk==JOptionPane.YES_OPTION) {
				StoreBean sb = new StoreBean();
				sb.setPw(txtIPw.getText());
				sb.setAge(Integer.parseInt( txtIAge.getText()));
				for(int i=0;i<iRadio.length;i++) {
					if(iRadio[i].isSelected()){
						sb.setGender(iRadio[i].getText());
					}
				}
				sb.setAddress(txtIAddress.getText());
				sb.setEmail(txtIEmail.getText());
				
				int cnt = sm.updateInfoData(sb);
				if(cnt == 0) {
					JOptionPane.showMessageDialog(this,"수정중 오류가 발생하였습니다.","반납 실패",JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(this,"수정되었습니다.","수정 완료",JOptionPane.DEFAULT_OPTION);
					ListInfoExit();
				}
			}
		}else if(obj == btnInfoCan){
			ListInfoExit();
		}else if(obj == btnU[3]){
			applayFrame();
		}else if(obj == btnApplay){
			int chk = JOptionPane.showConfirmDialog(this,"신청하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
			if(txtATitle.getText().isEmpty()&&txtAGenre.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this,"제목 또는 장르를 기입해주세요.","신청 실패",JOptionPane.ERROR_MESSAGE);
			}else {
				if(chk==JOptionPane.YES_OPTION) {
					StoreBean sb = new StoreBean();
					sb.setTitle(txtATitle.getText());
					sb.setGender(txtAGenre.getText());
					sb.setAuthor(txtAAuthor.getText());
					sb.setPublisher(txtAPublisher.getText());
					sb.setContent(txtAContent.getText());
					
					int cnt = sm.insertApplayData(sb);
					if(cnt == 0) {
						JOptionPane.showMessageDialog(this,"신청중 오류가 발생하였습니다.","신청 실패",JOptionPane.ERROR_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(this,"신청되었습니다.","신청 완료",JOptionPane.DEFAULT_OPTION);
						ListUaExit();
					}
				}
			}
		}else if(obj == btnACencle){
			ListUaExit();
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
			Object obj = e.getSource();
			if(obj == userTable) {
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
			}else if(obj == lblPSignUp) {
				signupFrame();
			}else if(obj == ReImgTable) {
				loadListData(sm.getAllBookList());
			}else if(obj == ReImgUserTable) {
				loadUserListData(sm.getAllUserList());
			}
		}
	}
	class KeyHandler extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				loginBtn.doClick();
			}
		}
	}

	//종료 메서드
	private void ListSignupExit() {
		ListSignup.dispose();
		btnSOk.removeMouseListener(new MouseHandler());
		btnSCen.removeMouseListener(new MouseHandler());
		
		txtSId.setEnabled(true);
		txtSId.setText("");
		txtSPw.setText("");
		txtSName.setText("");
		txtSAge.setText("");
		sRadio[0].setSelected(false);
		sRadio[1].setSelected(false);
		txtSAddress.setText("");
		txtSEmail.setText("");
	}
	
	private void ListUExit() {
		ListU.dispose();

		userTable.removeMouseListener(new MouseHandler());
		btnUserch.removeActionListener(this);
		
		btnAuEdit.removeActionListener(this);
		btnAuDis.removeActionListener(this);
		btnAuCencle.removeActionListener(this);
	}

	private void ListFIExit() {
		ListFI.dispose();
		btnCancel.removeActionListener(this);
		btnInsert.removeActionListener(this);
	}

	private void ListInfoExit() {
		ListInfo.dispose();
		btnInfoEidt.removeActionListener(this);
		btnInfoCan.removeActionListener(this);
	}

	private void ListUaExit() {
		//신청초기화
		ListUa.dispose();
		btnApplay.removeActionListener(this);
		btnACencle.removeActionListener(this);
		
		txtATitle.setText("");
		txtAGenre.setText("");
		txtAAuthor.setText("");
		txtAPublisher.setText("");
		txtAContent.setText("");
	}

	private void ListAExit() {
		ListA.dispose();

		btnApplay1.removeActionListener(this);
		btnApplay2.removeActionListener(this);
		btnApplay3.removeActionListener(this);
		btnApplayCan.removeActionListener(this);
	}
}