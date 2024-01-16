package yeseonTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import miniSkyScanner.Util;

public class DataController {
	public static String insert(String id, String name, String birthDate, String email, String adress, String pw) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = Util.getConnection();
			
			pstmt = conn.prepareStatement("insert into membership values (?, ?, ?, ?, ?, ?)");
			
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, birthDate);
			pstmt.setString(4, email);
			pstmt.setString(5, adress);
			pstmt.setString(6, pw);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				return "저장 성공";
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			Util.close(conn, pstmt);
		}
		
		return "저장 실패";
	}
}
