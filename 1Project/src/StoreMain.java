import java.util.ArrayList;

import javax.swing.JFrame;

public class StoreMain extends JFrame{
	StoreDao dao = new StoreDao();
	StoreBean sb = new StoreBean();
	static StoreFrame sf = null;
	
	public static void main(String[] args) {
		sf = new StoreFrame("대장서점");

		sf.loginBtn.addActionListener(sf);
	}
	
	public void ListLoad(StoreBean vo) {
		sb = vo;
		
		sf.mainFram();
	}
	public ArrayList<StoreBean> getAllBookList() {
		return dao.getAllBookList();
	}
}
