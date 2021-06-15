import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1524:orc";
		String id = "jspid";
		String pw = "jsppw";
		
		try {
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,id,pw);
			
//			String sql = "update test set name = 'hong', addr='제주' where num = 4";
			int vnum = 2;
			String name = "pack", addr = "마산";
			String sql = "update test set name=?,addr=? where num=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, addr);
			ps.setInt(3, vnum);
			int count = ps.executeUpdate();
			
			if(count == 0) {
				System.out.println("수정 실패");
			}else {
				System.out.println("수정 성공");
			}
			
			ps.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}