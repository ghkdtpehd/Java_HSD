import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";
	
	Connection conn = null;
	
	BookDao(){
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	void getConnection() {
		try {
			conn = DriverManager.getConnection(url,id,pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BookBean> getBookList() {
		getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BookBean> list = new ArrayList<BookBean>();
		
		String sql = "select * from book order by no asc";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BookBean bb = new BookBean();
				bb.setNo(rs.getInt("no"));
				bb.setTitle(rs.getString("title"));
				bb.setAuthor(rs.getString("author"));
				bb.setPublisher(rs.getString("publisher"));
				bb.setPrice(rs.getInt("price"));
				bb.setPub_day(String.valueOf(rs.getDate("pub_day")));
				
				list.add(bb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public ArrayList<BookBean> getBookChoiceList(String[] data) {
		getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BookBean> list = new ArrayList<BookBean>();
		
		String sql = "select * from book where "+data[0]+" like ? order by no asc";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+data[1]+"%");
			
			rs = ps.executeQuery();
			while(rs.next()) {
				BookBean bb = new BookBean();
				bb.setNo(rs.getInt("no"));
				bb.setTitle(rs.getString("title"));
				bb.setAuthor(rs.getString("author"));
				bb.setPublisher(rs.getString("publisher"));
				bb.setPrice(rs.getInt("price"));
				bb.setPub_day(String.valueOf(rs.getDate("pub_day")));
				
				list.add(bb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public int updateBook(BookBean bb) {
		getConnection();
		PreparedStatement ps = null;
		int count = 0;
		
		String sql = "update book set title=?,author=?,publisher=?,price=?,pub_day=? where no = ?";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,bb.getTitle());
			ps.setString(2,bb.getAuthor());
			ps.setString(3,bb.getPublisher());
			ps.setInt(4,bb.getPrice());
			ps.setString(5,bb.getPub_day());
			ps.setInt(6,bb.getNo());
			
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return count;
	}

	public int deleteBook(int no) {
		getConnection();
		PreparedStatement ps = null;
		int count = 0;
		
		String sql = "delete from book where no = ?";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1,no);
			
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	public int insertBook(BookBean bb) {
		getConnection();
		PreparedStatement ps = null;
		int count = 0;
		
		String sql = "insert into book values(bseq.nextval,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,bb.getTitle());
			ps.setString(2,bb.getAuthor());
			ps.setString(3,bb.getPublisher());
			ps.setInt(4,bb.getPrice());
			ps.setString(5,bb.getPub_day());
			
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return count;
	}
	
}