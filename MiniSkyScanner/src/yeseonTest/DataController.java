package yeseonTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import miniSkyScanner.Membership;
import miniSkyScanner.Util;


public class DataController {
	// Connection 객체 생성
	
	public static void main(String[] args) throws SQLException {
		
		// 각 국가에 대한 National 객체 생성
		try {
			Membership member = new Membership();
			member.membershipGuide();

			System.out.println("정상출력");

		} catch (Exception e) {
			e.printStackTrace();//관리자만 확인 가능한 콘솔 메세지
			//fail view
			//client 브라우저에 잘못된 상황을 알림정보로 가공해서 브라우저 실행
			System.out.println("잘못된 정보를 입력하셨습니다.");
		}  


	}
	
	public static String insert(String id, String name, String birthDate, String email, String adress, String pw) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//Membership member = new Membership();
			conn = Util.getConnection();
			
			pstmt = conn.prepareStatement("insert into membership (id, name, birthDate, email, address, pw) values (?, ?, ?, ?, ?, ?)");
			
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

