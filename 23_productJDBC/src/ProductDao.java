import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1524:orc";
	String id = "jspid";
	String pw = "jsppw";
	Connection conn = null;
	
	ProductDao(){
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void getConnection(){
		try {
			conn = DriverManager.getConnection(url,id,pw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<ProductBean> AllProductData() {
		getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProductBean> list = null;
		
		try {
			String sql = "select * from products";
			list = new ArrayList<ProductBean>();
			ps = conn.prepareStatement(sql);
			
			rs =ps.executeQuery();
			while(rs.next()) {
				ProductBean pd = new ProductBean();
				pd.setId(rs.getInt("id"));
				pd.setName(rs.getString("name"));
				pd.setStock(rs.getInt("stock"));
				pd.setPrice(rs.getInt("price"));
				pd.setCategory(rs.getString("category"));
				pd.setInputdate(String.valueOf(rs.getDate("inputdate")));
				
				list.add(pd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
				if(rs != null) rs.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
