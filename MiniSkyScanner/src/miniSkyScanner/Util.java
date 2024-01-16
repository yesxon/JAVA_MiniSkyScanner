package miniSkyScanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
	static {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();//예외 발생 상황을 디테일하게 출력
		}
	}
	
	// get Connection
	public static Connection getConnection() throws SQLException{
		String url = "jdbc:mysql://woori-fisa2.cfnz7hfzq9bn.ap-northeast-2.rds.amazonaws.com/fisa?characterEncoding=UTF-8&serverTimezone=UTC";
		String id = "admin";
		String pw = "woorifisa2!";
		
		return DriverManager.getConnection(url, id, pw);
	}
	


	
	// close 전용 함수
	public static void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException{
		rs.close();
		stmt.close();
		conn.close();
	}




	public static void close(Connection conn, PreparedStatement pstmt) throws SQLException {
		pstmt.close();
		conn.close();
	}
}