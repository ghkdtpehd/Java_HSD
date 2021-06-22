import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StoreDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
//	String url = "jdbc:oracle:thin:@localhost:1524:orc";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";
	Connection conn = null;
	
	StoreDao(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public StoreBean checkUser(String id, String pw) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		StoreBean sb = new StoreBean();
		
		try {
			String sql = "select * from book_user where id = ? and pw = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				sb.setNo(rs.getInt("no"));
				sb.setName(rs.getString("name"));
				sb.setRank(rs.getInt("rank"));
				sb.setRental_cnt(rs.getInt("rental_cnt"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sb;
	}

	public ArrayList<StoreBean> getAllBookList() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<StoreBean> list = new ArrayList<StoreBean>();
		try {
			String sql = "select * from bookstore order by no asc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				StoreBean sb = new StoreBean();
				sb.setNo(rs.getInt("no"));
				sb.setTitle(rs.getString("title"));
				sb.setAuthor(rs.getString("author"));
				sb.setPrice(rs.getInt("price"));
				sb.setPublisher(rs.getString("publisher"));
				sb.setPub_date(String.valueOf(rs.getDate("pub_date")));
				sb.setRental(rs.getInt("rental"));
				
				list.add(sb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public ArrayList<StoreBean> getAllUserList() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<StoreBean> list = new ArrayList<StoreBean>();
		try {
			String sql = "select * from book_user order by no asc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				StoreBean sb = new StoreBean();
				sb.setNo(rs.getInt("no"));
				sb.setName(rs.getString("name"));
				sb.setId(rs.getString("id"));
				sb.setPw(rs.getString("pw"));
				sb.setAge(rs.getInt("age"));
				sb.setGender(rs.getString("gender"));
				sb.setAddress(rs.getString("address"));
				sb.setEmail(rs.getString("email"));
				sb.setSign_up(String.valueOf(rs.getDate("sign_up")));
				sb.setRank(rs.getInt("rank"));
				sb.setRental_cnt(rs.getInt("rental_cnt"));
				
				list.add(sb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int insertBook(StoreBean vo) {
		PreparedStatement ps = null;
		int cnt = 0;
		String pub = "";
		try {
			if(vo.getPub_date().equals("")) {
				pub = "sysdate";
			}else {
				pub = "'"+vo.getPub_date()+"'";
			}
			String sql = "insert into bookstore values(bookseq.nextval,?,?,?,?,"+pub+",0)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getAuthor());
			ps.setInt(3, vo.getPrice());
			ps.setString(4, vo.getPublisher());
			
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt ;
	}

	public int deleteBook(int bookno) {
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			String sql = "delete from bookstore where no = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bookno);
			
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt ;
	}

	public ArrayList<StoreBean> selectBookUser(String[] sqlStr) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<StoreBean> list = new ArrayList<StoreBean>();
		String sql = "select * from book_user";

		if(!sqlStr[3].equals("")) {
			sql+=" where "+sqlStr[2]+" like '%"+sqlStr[3]+"%' ";
		}
		if(!sqlStr[0].equals("")) {
			sql+=" order by "+sqlStr[1]+" "+sqlStr[0];
		}
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				StoreBean sb = new StoreBean();
				sb.setNo(rs.getInt("no"));
				sb.setName(rs.getString("name"));
				sb.setId(rs.getString("id"));
				sb.setPw(rs.getString("pw"));
				sb.setAge(rs.getInt("age"));
				sb.setGender(rs.getString("gender"));
				sb.setAddress(rs.getString("address"));
				sb.setEmail(rs.getString("email"));
				sb.setSign_up(String.valueOf(rs.getDate("sign_up")));
				sb.setRank(rs.getInt("rank"));
				sb.setRental_cnt(rs.getInt("rental_cnt"));
				
				list.add(sb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
