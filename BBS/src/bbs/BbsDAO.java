package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import User.Database;

public class BbsDAO {
	private Connection conn;
	private ResultSet rs;

	public BbsDAO() {
		conn = Database.getInstance().getConn();
	}

	// 작성일자 메소드
	public String getDate() {
		String sql = "select now()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ""; // 데이터베이스 오류
	}

	// 게시글 번호 부여 메소드
	public int getNext() {
		// 현재 게시글을 내림차순으로 조회하여 가장 마지막 글의 번호를 구한다
		String sql = "select bbsID from bbs order by bbsID desc";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1; // 첫 번째 게시물인 경우
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1; // 데이터베이스 오류
	}

	// 글쓰기 메소드
	public int write(String bbsTitle, String userID, String bbsContent) {
		String sql = "insert into bbs values(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, bbsTitle);
			pstmt.setString(3, userID);
			pstmt.setString(4, getDate());
			pstmt.setString(5, bbsContent);
			pstmt.setInt(6, 1); // 글의 유효번호
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}

	public ArrayList<Bbs> getList(int pageNumber) {
		String sql = "SELECT * FROM BBS WHERE bbsID < ? AND bbsAvailable = 1 ORDER BY bbsID DESC LIMIT 10";
		ArrayList<Bbs> list = new ArrayList<Bbs>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			int next = getNext();

			if (next == -1) {
				System.out.println("데이터베이스에러");

			} else if (next == 1) {
				System.out.println("첫번째 게시물");

			}

			pstmt.setInt(1, next - (pageNumber - 1) * 10);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setBbsID(rs.getInt(1));
				bbs.setBbsTitle(rs.getString(2));
				bbs.setUserID(rs.getString(3));
				bbs.setBbsDate(rs.getString(4));
				bbs.setBbsContent(rs.getString(5));
				bbs.setBbsAvailable(rs.getInt(6));
				list.add(bbs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list; // 데이터베이스 오류
	}

//	public ArrayList<Bbs> getList(int startRow, int endRow){
//		String sql = "SELECT * FROM"+"(select rownum rn, bbsID, userID, bbsTitle, bbsDate from"+ "select from bbs order by desc)) where rn between ? and ?"; 
//		
//		ArrayList<Bbs> list = new ArrayList<Bbs>();
//		
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, startRow);
//			pstmt.setInt(2, endRow);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				Bbs bbs = new Bbs();
//				bbs.setBbsID(rs.getInt(1));
//				bbs.setBbsTitle(rs.getString(2));
//				bbs.setUserID(rs.getString(3));
//				bbs.setBbsDate(rs.getString(4));
//				bbs.setBbsContent(rs.getString(5));
//				bbs.setBbsAvailable(rs.getInt(6));
//				list.add(bbs);
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list; //데이터베이스 오류
//	}
	public boolean nextPage(int pageNumber) {
		String sql = "SELECT * FROM BBS WHERE bbsID < ? AND bbsAvailable = 1 ORDER BY bbsID DESC LIMIT 10";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Bbs getBbs(int bbsID) {
		String sql = "SELECT * FROM BBS WHERE bbsID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bbsID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setBbsID(rs.getInt(1));
				bbs.setBbsTitle(rs.getString(2));
				bbs.setUserID(rs.getString(3));
				bbs.setBbsDate(rs.getString(4));
				bbs.setBbsContent(rs.getString(5));
				bbs.setBbsAvailable(rs.getInt(6));
				return bbs;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Bbs o = getBbs(1);

		if (o != null)
			System.out.println(o.getBbsDate());

		return null;
	}

	public int update(int bbsID, String userID, String bbsTitle, String bbsContent) {
		String sql = "UPDATE BBS SET userID =?,bbsTitle =?, bbsContent =? WHERE bbsID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, bbsTitle);
			pstmt.setString(3, bbsContent);
			pstmt.setInt(4, bbsID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}

	public int delete(int bbsID) {
		String sql = "UPDATE BBS SET bbsAvailable = 0 WHERE bbsID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bbsID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}

	public int getCount() {
		int count = 0;
		String sql = "SELECT COUNT(*) from BBS";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	/*
	 * public List<Bbs> getList(int startRow, int endRow){ String sql =
	 * "SELECT * FORM" + "(SELECT rownum rn, bbsID, bbsTitle, userID, bbsDate from"
	 * +"(select * from bbs order by bbsID desc)) where rn between ? and ?";
	 * List<Bbs> list = null; }
	 */
}
