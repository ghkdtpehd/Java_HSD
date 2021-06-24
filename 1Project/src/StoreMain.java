import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class StoreMain extends JFrame{
	StoreDao dao = new StoreDao();
	StoreBean sb = new StoreBean();
	int userRank = 0;
	static StoreFrame sf = null;
	
	public static void main(String[] args) {
		sf = new StoreFrame("대장서점");

		sf.loginBtn.addActionListener(sf);
	}
	
	public void ListLoad(StoreBean vo) {
		sb = vo;
		userRank = sb.getRank();
		
		sf.mainFram(userRank);
	}
	public ArrayList<StoreBean> getAllBookList() {
		return dao.getAllBookList();
	}

	public ArrayList<StoreBean> getAllUserList() {
		return  dao.getAllUserList();
	}
	
	public int insertBook(StoreBean vo) {
		int cnt = dao.insertBook(vo);
		return cnt;
	}

	public int deleteBook(int bookno) {
		int cnt = dao.deleteBook(bookno);
		return cnt;
	}

	public ArrayList<StoreBean> selectBookUser(String[] sqlStr) {
		return dao.selectBookUser(sqlStr);
	}

	public int deleteUserData(int no) {
		return dao.deleteUserData(no);
	}

	public int updateUserData(StoreBean vo) {
		return dao.updateUserData(vo);
	}

	public ArrayList<StoreBean> selectBookData(String[] sqlStr) {
		return dao.selectBookData(sqlStr);
	}

	public int coReturnBook(int bookNo) {
		//사용자의 대여목록 삭제, 강제반납
		int cnt = 0;
		int userNo = dao.getRentUserNo(bookNo);
		String renStr = dao.RemoveUserRentalStr(bookNo,userNo);
		cnt += dao.updateUserRent(renStr,userNo);
		cnt += dao.updateRemoveBookRent(bookNo);
		return cnt;
	}

	public boolean checkRentalCnt() {
		return dao.checkRentalCnt(sb.getNo());
	}

	public int userRentalBook(int bookNo) {
		int cnt = 0;
		String renStr = dao.addUserRentalStr(bookNo,sb.getNo());
		cnt += dao.updateUserRent(renStr,sb.getNo());
		cnt += dao.updateAddBookRent(bookNo,sb.getNo());
		return cnt;
	}

	public boolean getRentalUserNo(int bookNo) {
		return dao.getRentalUserNo(bookNo,sb.getNo());
	}

	public int userReturnBook(int bookNo) {
		int cnt = 0;
		String renStr = dao.RemoveUserRentalStr(bookNo,sb.getNo());
		cnt += dao.updateUserRent(renStr,sb.getNo());
		cnt += dao.updateRemoveBookRent(bookNo);
		return cnt;
	}

	public StoreBean getMyInfoData() {
		return sb;
	}

	public int updateInfoData(StoreBean vo) {
		vo.setNo(sb.getNo());
		int cnt = dao.updateInfoData(vo);
		if(cnt != 0) {
			sb.setPw(vo.getPw());
			sb.setAge(vo.getAge());
			sb.setGender(vo.getGender());
			sb.setAddress(vo.getAddress());
			sb.setEmail(vo.getName());
		}
		return cnt;
	}

	public int insertApplayData(StoreBean vo) {
		vo.setNo(sb.getNo());
		return dao.insertApplayData(vo);
	}

	public ArrayList<StoreBean> getAllApplayList() {
		return dao.getAllApplayList();
	}

	public ArrayList<StoreBean> selectApplayData(String[] sqlStr) {
		return dao.selectApplayData(sqlStr);
	}

	public int userApplayChange(int applayNo) {
		return dao.userApplayChange(applayNo);
	}
}
