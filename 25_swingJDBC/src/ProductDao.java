import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1524:orc";
//	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
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
			String sql = "select * from products order by id asc";
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

	public ArrayList<ProductBean> nameProductData(Integer id) {
		getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProductBean> list = new ArrayList<ProductBean>();
		
		String sql = "select * from products where id = ? order by id asc";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
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
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public ArrayList<ProductBean> gerProductByCategory(String category) {
		getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		ArrayList<ProductBean> list = new ArrayList<ProductBean>();
		
		String sql = "select * from products where upper(category) = upper(?) order by id asc";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, category);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
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
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public int insertData(ProductBean pb) {
		getConnection();
		int count = 0; 
		PreparedStatement ps = null;
		
		try {
			String sql = "insert into products values(prdseq.nextval,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, pb.getName());
			ps.setInt(2, pb.getStock());
			ps.setInt(3, pb.getPrice());
			ps.setString(4, pb.getCategory());
			ps.setString(5, pb.getInputdate());
			
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return count;
	}

	public int updateData(ProductBean pb) {
		getConnection();
		PreparedStatement ps = null;
		int count = 0;
		String sql = "update products set name=?,stock=?,price=?,category=?,inputdate=? where id = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setInt(2, pb.getStock());
			ps.setInt(3, pb.getPrice());
			ps.setString(4, pb.getCategory());
			ps.setString(5, pb.getInputdate());
			ps.setInt(6, pb.getId());
			
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	public int deleteData(int deleteId) {
		getConnection();
		PreparedStatement ps = null;
		int count = 0;
		
		String sql ="delete from products where id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, deleteId);
			
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
}
