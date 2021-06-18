import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlbumsDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";
	Connection conn = null;
	
	AlbumsDao(){
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url,id,pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<AlbumsBean> getAllAlbumList(){
		getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from albums order by num asc";
		ArrayList<AlbumsBean> list = new ArrayList<AlbumsBean>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				AlbumsBean ab = new AlbumsBean();
				ab.setNum(rs.getInt("num"));
				ab.setSong(rs.getString("song"));
				ab.setSinger(rs.getString("singer"));
				ab.setCompany(rs.getString("company"));
				ab.setPrice(rs.getInt("price"));
				ab.setPub_day(String.valueOf(rs.getDate("pub_day")));
				
				list.add(ab);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int updateAlbum(AlbumsBean ab) {
		getConnection();
		PreparedStatement ps = null;
		int count = 0;
		String sql = "update albums set song=?,singer=?,company=?,price=?,pub_day=? where num=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ab.getSong());
			ps.setString(2, ab.getSinger());
			ps.setString(3, ab.getCompany());
			ps.setInt(4, ab.getPrice());
			ps.setString(5, ab.getPub_day());
			ps.setInt(6, ab.getNum());
			
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

	public int deleteAlbum(int val) {
		getConnection();
		PreparedStatement ps = null;
		int count = 0;
		String sql = "delete from albums where num = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, val);
			
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

	public int insertAlbum(AlbumsBean ab) {
		getConnection();
		PreparedStatement ps = null;
		int count = 0;
		String sql = "insert into albums values(albumseq.nextval,?,?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ab.getSong());
			ps.setString(2, ab.getSinger());
			ps.setString(3, ab.getCompany());
			ps.setInt(4, ab.getPrice());
			ps.setString(5, ab.getPub_day());
			
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

	public ArrayList<AlbumsBean> getAlubmBySerch(String str, String val) {
		getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<AlbumsBean> list = new ArrayList<AlbumsBean>();
		
		String sql =  "select * from albums where upper("+str+") like ? order by num asc";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+val.toUpperCase()+"%");
			
			rs = ps.executeQuery();
			while(rs.next()) {
				AlbumsBean ab = new AlbumsBean();
				ab.setNum(rs.getInt("num"));
				ab.setSong(rs.getString("song"));
				ab.setSinger(rs.getString("singer"));
				ab.setCompany(rs.getString("company"));
				ab.setPrice(rs.getInt("price"));
				ab.setPub_day(String.valueOf(rs.getDate("pub_day")));
				
				list.add(ab);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public ArrayList<AlbumsBean> getAlbumByRange(int stratNum, int endNum) {
		getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * "
				   + "from (select num,song,singer,company,price,pub_day,"
				   + "				dense_rank() over(order by price desc,singer asc) rank "
				   + "		from albums) "
				   + "where rank between ? and ?";
		ArrayList<AlbumsBean> list = new ArrayList<AlbumsBean>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, stratNum);
			ps.setInt(2, endNum);
			rs = ps.executeQuery();
			while(rs.next()) {
				AlbumsBean ab = new AlbumsBean();
				ab.setNum(rs.getInt("num"));
				ab.setSong(rs.getString("song"));
				ab.setSinger(rs.getString("singer"));
				ab.setCompany(rs.getString("company"));
				ab.setPrice(rs.getInt("price"));
				ab.setPub_day(String.valueOf(rs.getDate("pub_day")));
				
				list.add(ab);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public ArrayList<AlbumsBean> refindAlbum(String str1, String str2) {
		getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from albums order by "+str1+" "+str2;
		ArrayList<AlbumsBean> list = new ArrayList<AlbumsBean>();
		
		try {
			ps = conn.prepareStatement(sql);,.,.kl
			rs = ps.executeQuery();
			while(rs.next()) {
				AlbumsBean ab = new AlbumsBean();
				ab.setNum(rs.getInt("num"));
				ab.setSong(rs.getString("song"));
				ab.setSinger(rs.getString("singer"));
				ab.setCompany(rs.getString("company"));
				ab.setPrice(rs.getInt("price"));
				ab.setPub_day(String.valueOf(rs.getDate("pub_day")));
				
				list.add(ab);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
