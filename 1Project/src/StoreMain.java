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

}
