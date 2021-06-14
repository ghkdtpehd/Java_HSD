import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Create {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "jspid";
		String pw = "jsppw";
		
		try {
			// 1. ����̹� �ε�
			Class.forName(driver);
			
			// 2. ������ ����
			Connection conn = DriverManager.getConnection(url,id,pw);
			
			String sql = "drop table test";
			// 3. sql�� �м�
			PreparedStatement ps = conn.prepareStatement(sql);
			
			// 4. sql�� ����
			ps.executeUpdate();
			System.out.println("���� ����");
			
			sql = "create table test(num number, name varchar2(10), addr varchar2(10))";
			ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
			System.out.println("���� ����");
			
			// 5. ���� ����
			ps.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}