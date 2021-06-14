import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connect {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//		String url = "jdbc:oracle:thin:@localhost:1524:orc";
		String user = "jspid";
		String pw = "jsppw";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
			
			System.out.println("DB와의 연결 시도");
			
			Connection conn = DriverManager.getConnection(url,user,pw);
			System.out.println("DB와의 연결 성공");
			
			conn.close();
			System.out.println("DB와의 연결 끊기 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("SQLException 발생");
		}
	}
}
//오라클 jdbc 파일 위치
//C:\Oracle\product\12.2.0\dbhome_1\jdbc\lib\ojdbc8.jar