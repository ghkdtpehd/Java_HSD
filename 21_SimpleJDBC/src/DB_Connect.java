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
			System.out.println("����̹� �ε� ����");
			
			System.out.println("DB���� ���� �õ�");
			
			Connection conn = DriverManager.getConnection(url,user,pw);
			System.out.println("DB���� ���� ����");
			
			conn.close();
			System.out.println("DB���� ���� ���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("SQLException �߻�");
		}
	}
}
//����Ŭ jdbc ���� ��ġ
//C:\Oracle\product\12.2.0\dbhome_1\jdbc\lib\ojdbc8.jar