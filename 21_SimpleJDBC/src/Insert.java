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
			
//			String sql = "insert into test(num,name,addr) values(3,'choi','대전')";
			int vnum = 6;
			String vname = "oh",vaddr = "광주";
//			String sql = "insert into test(num,name,addr) values("+vnum+",'"+vname+"','"+vaddr+"')";

			String sql = "insert into test(num,name,addr) values(?,?,?)";	//?: 위치홀더
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, vnum);
			ps.setString(2, vname);
			ps.setString(3, vaddr);
			
			int count = ps.executeUpdate(); // 성공적으로 실행된 레고크 개수 리턴
			
			System.out.println(count+"개가 없데이트 되었습니다.");
			ps.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}