import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
//		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String url = "jdbc:oracle:thin:@localhost:1524:orc";
		String id = "jspid";
		String pw = "jsppw";
		
		try {
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,id,pw);
			
//			String sql = "insert into test(num,name,addr) values(3,'choi','����')";
			int vnum = 6;
			String vname = "oh",vaddr = "����";
//			String sql = "insert into test(num,name,addr) values("+vnum+",'"+vname+"','"+vaddr+"')";

			String sql = "insert into test(num,name,addr) values(?,?,?)";	//?: ��ġȦ��
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, vnum);
			ps.setString(2, vname);
			ps.setString(3, vaddr);
			
			int count = ps.executeUpdate(); // ���������� ����� ����ũ ���� ����
			
			System.out.println(count+"���� ������Ʈ �Ǿ����ϴ�.");
			ps.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}