import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
	public static void main(String[] args) {
		String driver= "oracle.jdbc.driver.OracleDriver";
		String url =  "jdbc:oracle:thin:@localhost:1524:orc";
		String id = "jspid";
		String pw = "jsppw";
		
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,id,pw);
			
			String sql = "delete from test where num = 3";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			int num = ps.executeUpdate();
			
			if(num == 0) {
				System.out.println("삭제한 데이터가 없습니다.");
			}else {
				System.out.println("삭제된 데이터는 "+num+"건 입니다.");
			}
			
			ps.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}