import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StoreDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1524:orc";
//	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
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
				// TODO Auto-generated catch block
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
			String sql = "select * from bookstore";
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
		}
		return list;
	}
}
