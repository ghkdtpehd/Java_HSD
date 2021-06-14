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
			// 1. 드라이버 로드
			Class.forName(driver);
			
			// 2. 계정에 접속
			Connection conn = DriverManager.getConnection(url,id,pw);
			
			String sql = "drop table test";
			// 3. sql문 분석
			PreparedStatement ps = conn.prepareStatement(sql);
			
			// 4. sql문 실행
			ps.executeUpdate();
			System.out.println("삭제 성공");
			
			sql = "create table test(num number, name varchar2(10), addr varchar2(10))";
			ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
			System.out.println("생성 성공");
			
			// 5. 접속 끊기
			ps.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}