import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1524:orc";
	String id = "jspid";
	String pw = "jsppw";
	Connection conn = null;
	PersonDao(){
		try {
			Class.forName(driver);
			System.out.println("드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException 발생");
			e.printStackTrace();
		}
	}
	
	void getConnect(){
		try {
			conn = DriverManager.getConnection(url,id,pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<PersonBean> getAllPerson() {
		getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<PersonBean> list = new ArrayList<PersonBean>();
		
		String sql = "select * from person";
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String brith = String.valueOf(rs.getDate("birth"));
				
				PersonBean bean = new PersonBean();
				
				bean.setNum(num);
				bean.setName(name);
				bean.setAge(age);
				bean.setGender(gender);
				bean.setBirth(brith);
				
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public ArrayList<PersonBean> getPersonByGender(String igender) {
		getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<PersonBean> list = new ArrayList<PersonBean>();

		String sql = "select * from person where gender = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, igender);

			rs = ps.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String brith = String.valueOf(rs.getDate("birth"));
				
				PersonBean bean = new PersonBean();
				
				bean.setNum(num);
				bean.setName(name);
				bean.setAge(age);
				bean.setGender(gender);
				bean.setBirth(brith);
				
				list.add(bean);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int insertDara(PersonBean pb) {
		getConnect();
		PreparedStatement ps = null;
		int count = 0;
		
		String sql = "insert into person values(persqe.nextval,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setInt(2, pb.getAge());
			ps.setString(3, pb.getGender());
			ps.setString(4, pb.getBirth());
			
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}

	public int updateData(PersonBean pb) {
		getConnect();
		PreparedStatement ps= null;
		int count = 0;
		
		try {
			String sql = "update person set name=?,age=?,gender=?,birth=? where num =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setInt(2, pb.getAge());
			ps.setString(3, pb.getGender());
			ps.setString(4, pb.getBirth());
			ps.setInt(5, pb.getNum());
			
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	public int deleteData(int num) {
		getConnect();
		PreparedStatement ps = null;
		int count = 0;
		try {
			String sql = "delete from person where num = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return count;
	}
}
