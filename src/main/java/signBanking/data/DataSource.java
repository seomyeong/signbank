package signBanking.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * 데이터에 관련된 정보 캡슐화하는 클래스
 * Singleton 싱글톤 패턴
 */
public class DataSource {
	private static DataSource ds = new DataSource();

	private String url;
	private String user;
	private String pass;
	
	
	//생성자의 접근제한자를 private으로.
	private DataSource() {
	}
	
	public static DataSource getInstance() { return ds; }
	
	
	
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, pass);
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
	public void initDataSource(String driver, String url, String user, String pass) {
		
		try {
			Class.forName(driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		this.url=url;
		this.user=user;
		this.pass=pass;
	}
	
	public void close(PreparedStatement pstmt, Connection con) throws SQLException {
		if(pstmt != null) {
			pstmt.close();
		}
		if(con != null) {
			con.close();
		}
	}

	public void close(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if(rs != null) {
			rs.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
		if(con != null) {
			con.close();
		}
	}

	
	
}
