import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
	JFrame ListF = null;
	JFrame ListFI = null;
	JFrame ListU = null;
	Container ListC = null;
	JTable table = null;
	JTable userTable = null;
	private JScrollPane scrollPane = null;
	private JScrollPane userScrollPane = null;

	private String[] columnNames = {"��ȣ","å�̸�","����","�ܰ�","���ǻ�","�԰�����","�뿩����"};
	private String[] columnUsers = {"��ȣ","�̸�","���̵�","��й�ȣ","����","����","������","�̸���","������","���","�뿩��å"};
	private Object[][] rowData = null;
	ArrayList<StoreBean> list = null;
	ArrayList<StoreBean> listUser = null;
	
	String[] userSerchStr = {"��ȣ","�̸�","�ּ�","�̸���","���"};
	String[] adminBtn = {"���","����","ȸ�����","�����ݳ�","��û���"}; 
	String[] userBtn = {"�뿩","�ݳ�","������","å��û"}; 
	String[] BookInertBtn = {"�뿩","�ݳ�"}; 
	private JButton btnInsert = new JButton("����");
	private JButton btnCancel =  new JButton("���");
	private JButton btnAuEdit =  new JButton("����");
	private JButton btnAuDis =  new JButton("Ż��");
	private JButton btnAuCencle =  new JButton("���");
	private JButton[] btnA = new JButton[adminBtn.length];
	private JButton[] btnU = new JButton[userBtn.length];
	private JButton btnUserch = new JButton("�˻�");
	
	JRadioButton[] userRadio = new JRadioButton[2];
	String[] userRadioName = {"��������","��������"};
	JComboBox<String> userSherchCombo1 = new JComboBox<String>(userSerchStr);
	JComboBox<String> userSherchCombo2 = new JComboBox<String>(userSerchStr);
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
		//�α���
		super(title);
		setResizable(false);
		loginC = getContentPane();
		loginC.setLayout(null);
		
		JLabel lblId = new JLabel("���̵�");
		JLabel lblPw = new JLabel("��й�ȣ");

		txtId = new JTextField();
		txtPw = new JTextField();
		
		Font loginFont = new Font("���",Font.BOLD,15);
		
		lblId.setBounds(50,50,100,20);
		lblId.setFont(loginFont);
		lblPw.setBounds(50,80,100,20);
		lblPw.setFont(loginFont);
		
		txtId.setBounds(120,50,130,20);
		txtId.setFont(loginFont);
		txtPw.setBounds(120,80,130,20);
		txtPw.setFont(loginFont);
		
		loginBtn.setText("�α���");
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
		//����Ʈ
		ListF = new JFrame("���弭��");
		
		list = sm.getAllBookList();
		rowData = new Object[list.size()][columnNames.length];
		fillRowData();
		
		table = new JTable (rowData,columnNames);
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(700,300));

		ListF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		compse(rank);
		ListF.add(scrollPane,BorderLayout.NORTH);
		ListF.setResizable(false);
		ListF.setSize(700,500);
		
		Dimension frameSize = ListF.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		ListF.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		ListF.setVisible(true);
	}
	
	public void userFram() {
		//ȸ������
		ListU = new JFrame("ȸ������");
		ListU.setLayout(null);
		
		listUser = sm.getAllUserList(); 
		System.out.println(listUser.size());
		rowData = new Object[listUser.size()][columnUsers.length];
		fillUserRowData();

		userTable = new JTable (rowData,columnUsers);
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
		scrollPane.remove(userTable);
		userTable.revalidate();
		userTable.repaint();
		userScrollPane.setViewportView(userTable);
	}

	private void compse(int rank) {
		//����� ��޿� ���� UI����
		JPanel pSouth = new JPanel();
		if(rank != 2) {
			pSouth.setLayout(new GridLayout(1,userBtn.length));
			for(int i=0;i<userBtn.length;i++) {
				btnU[i] = new JButton(userBtn[i]);
				btnU[i].addActionListener(this);
				pSouth.add(btnU[i]);
			}
		}else {
			pSouth.setLayout(new GridLayout(1,adminBtn.length));
			for(int i=0;i<adminBtn.length;i++) {
				btnA[i] = new JButton(adminBtn[i]);
				btnA[i].addActionListener(this);
				pSouth.add(btnA[i]);
			}
		}
		ListF.add(pSouth,"South");
	}
	
	private void userCompse() {
		JPanel pRadio = new JPanel();
		JPanel pSouth = new JPanel();
		ButtonGroup userRg = new ButtonGroup(); 
		
		pRadio.setLayout(null);
		pSouth.setLayout(null);
		pRadio.setBounds(0, 0, 700, 40);
		pSouth.setBounds(0, 250, 700, 400);
		pRadio.add(userSherchCombo1);
		userSherchCombo1.setBounds(110, 0, 60, 30);
		for(int i=0;i<userRadioName.length;i++) {
			userRadio[i] = new JRadioButton(userRadioName[i]);
			userRg.add(userRadio[i]);
			pRadio.add(userRadio[i]);
		}
		userRadio[0].setBounds(180, 0, 75, 30);
		userRadio[1].setBounds(255, 0, 75, 30);
		pRadio.add(userSherchCombo2);   
		userSherchCombo2.setBounds(340, 0, 60, 30);
		pRadio.add(userSerch);
		userSerch.setBounds(410,0,150,30);
		pRadio.add(btnUserch);
		btnUserch.setBounds(570,0,80,28);
		
		userRadio[0].setSelected(true);
		btnUserch.addActionListener(this);
		btnAuEdit.setBounds(80,300,80,25);
		btnAuDis.setBounds(130,300,80,25);
		btnAuCencle.setBounds(180,300,80,25);
		
		pRadio.setBounds(0, 3, 700, 35);
		ListU.add(pRadio);
		//pInfo
		
		JLabel lblName = new JLabel("�̸�");
		JLabel lblId = new JLabel("���̵�");
		JLabel lblPw = new JLabel("��й�ȣ");
		JLabel lblAge = new JLabel("����");
		JLabel lblGender = new JLabel("����");
		JLabel lblAddress = new JLabel("������");
		JLabel lblEmail = new JLabel("�̸���");
		JLabel lblSign_up = new JLabel("������");
		JLabel lblRank = new JLabel("���");
		
		
		pSouth.add(lblName);
		lblName.setBounds(100, 10, 70, 30);
		pSouth.add(lblAge);    
		lblPw.setBounds(370, 10, 70, 30);
		pSouth.add(lblId);      
		lblId.setBounds(100, 40, 70, 30);
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
		txtPName.setBounds(430, 12, 140, 25);
		pSouth.add(txtPPw);
		txtPPw.setBounds(150, 42, 140, 25);
		pSouth.add(txtPAge);
		txtPAge.setBounds(430, 42, 140, 25);
		pSouth.add(txtPGender);
		txtPGender.setBounds(150, 72, 140, 25);
		pSouth.add(txtPAddress);
		txtPAddress.setBounds(430, 72, 140, 25);
		pSouth.add(txtPEmail);
		txtPEmail.setBounds(150, 102, 140, 25);
		pSouth.add(txtPSign_up);
		txtPSign_up.setBounds(430, 102, 140, 25);
		pSouth.add(txtPRank);
		txtPRank.setBounds(150, 132, 140, 25);
		
		pSouth.add(btnAuEdit);
		btnAuEdit.setBounds(180, 170, 80, 25);
		pSouth.add(btnAuDis);
		btnAuDis.setBounds(310, 170, 80, 25);
		pSouth.add(btnAuCencle);
		btnAuCencle.setBounds(440, 170, 80, 25);
		ListU.add(pSouth,"South");
	}

	private void fillRowData() {
		//����Ʈ
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
			rowData[i][cnt++] = sb.getRental() == 0 ? "����":"�Ұ���";
			cnt = 0;
		}
	}
	
	private void fillUserRowData() {
		//���� ����Ʈ
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
			StoreBean userData = dao.checkUser(txtId.getText(),txtPw.getText());
			if(userData.getNo() != 0) {
				JOptionPane.showMessageDialog(this,"�α��� �Ǿ����ϴ�.","�α���",JOptionPane.DEFAULT_OPTION);
				setVisible(false);
				sm.ListLoad(userData);
			}else {
				JOptionPane.showMessageDialog(this,"ID �Ǵ� PW �� Ȯ�����ּ���.","�α���",JOptionPane.WARNING_MESSAGE);
			}
		}else if(obj == btnA[0]){
			insertInit();
		}else if(obj == btnInsert){
			int price = 0;
			boolean chk = true;
			String pub = "sysdate";
			StoreBean sb = new StoreBean();
			if(txtTitle.getText().equals("")) {
				JOptionPane.showMessageDialog(this,"������ �Է����ּ���","���� �߻�",JOptionPane.ERROR_MESSAGE);
				chk = false;
			}
			if(txtAuthor.getText().equals("")) {
				JOptionPane.showMessageDialog(this,"���ڸ� �Է����ּ���","���� �߻�",JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(this,"������ ���ڸ� �Է����ּ���","���� �߻�",JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(this,"��Ͽ� �����Ͽ����ϴ�.","��� ����",JOptionPane.ERROR_MESSAGE);
				}else {
					ListFI.setVisible(false);
					loadListData(sm.getAllUserList());
				}
			}
		}else if(obj == btnCancel){
			clearData();
			ListFI.setVisible(false);
		}else if(obj == btnA[1]){
			int cnt = 0;
			int bookno =Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
			String bookName =table.getValueAt(table.getSelectedRow(), 1).toString();
			int result = JOptionPane.showConfirmDialog(this,"'"+bookName+"'�� ���� �Ͻðڽ��ϱ�?","Ȯ��",JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION) {
				cnt = sm.deleteBook(bookno);
				if(cnt == 0) {
					JOptionPane.showMessageDialog(this,"������ �����Ͽ����ϴ�.","��� ����",JOptionPane.ERROR_MESSAGE);
				}else {
					loadListData(sm.getAllUserList());
				}
			}
		}else if(obj == btnA[2]){
			userFram();
		}else if(obj == btnUserch){
			//order , ���� , ��
			String[] sqlStr = new String[4]; 
			if(userRadio[0].isSelected()) {
				sqlStr[0] = "asc";
			}else {
				sqlStr[0] = "desc";
			}
			
			//order by
			switch(userSherchCombo1.getItemAt(userSherchCombo1.getSelectedIndex())) {
				case "��ȣ":
					sqlStr[1] = "no";
					break;
				case "�̸�":
					sqlStr[1] = "name";
					break;
				case "�ּ�":
					sqlStr[1] = "address";
					break;
				case "�̸���":
					sqlStr[1] = "email";
					break;
				case "���":
					sqlStr[1] = "rank";
					break;
			}
			
			//where
			switch(userSherchCombo2.getItemAt(userSherchCombo2.getSelectedIndex())) {
			case "��ȣ":
				sqlStr[2] = "no";
				break;
			case "�̸�":
				sqlStr[2] = "name";
				break;
			case "�ּ�":
				sqlStr[2] = "address";
				break;
			case "�̸���":
				sqlStr[2] = "email";
				break;
			case "���":
				sqlStr[2] = "rank";
				break;
			}
			sqlStr[3] = userSerch.getText();
			
			ArrayList<StoreBean> list = sm.selectBookUser(sqlStr);
			loadUserListData(list);
		}else if(obj == btnA[3]){
		}else if(obj == btnA[4]){
		}else if(obj == btnU[0]){
		}else if(obj == btnU[1]){
		}else if(obj == btnU[2]){
		}else if(obj == btnU[3]){
		}
	}

	private void insertInit() {
		ListFI = new JFrame("���弭��[å ���]");
//		ListFI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ListFI.setLayout(null);
		ListFI.setResizable(false);

		clearData();
		ListFI.setSize(250,260);
		
		Dimension frameSize = ListFI.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		ListFI.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		
		JLabel lblTitle = new JLabel("����");
		JLabel lblAuthor = new JLabel("����");
		JLabel lblPrice = new JLabel("����");
		JLabel lblPublisher = new JLabel("���ǻ�");
		JLabel lblPub_date = new JLabel("�Ⱓ��");
		
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
}