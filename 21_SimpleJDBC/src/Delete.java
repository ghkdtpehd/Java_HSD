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
				System.out.println("������ �����Ͱ� �����ϴ�.");
			}else {
				System.out.println("������ �����ʹ� "+num+"�� �Դϴ�.");
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