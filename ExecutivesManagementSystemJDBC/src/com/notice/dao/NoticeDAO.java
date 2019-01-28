package com.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.employee.entity.Engineer;
import com.employee.entity.Sales;
import com.notice.entity.Notice;

public class NoticeDAO{
	public ArrayList<Notice> selectAllNotice(Connection con){
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select no, title, content, author, writeday from NOTICE";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Notice notice = new Notice(rs.getInt("no"), rs.getString("title"), rs.getString("content"), rs.getString("author"), rs.getString("writeday"));
				list.add(notice);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public Notice selectDetailNotic(Connection con, String noticeNum) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Notice notice = null;
		String sql = "select no, title, content, author, writeday from NOTICE where no = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(noticeNum));
			rs = pstmt.executeQuery();
			rs.next();
			notice = new Notice(rs.getInt("no"), rs.getString("title"), rs.getString("content"), rs.getString("author"), rs.getString("writeday"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return notice;
	}

	public void noticeUpdate(Connection con, Notice notice) {
		PreparedStatement pstmt = null;
		
		String sql = "update notice set title = ?, content = ? where no = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, notice.getTitle());
			pstmt.setString(2, notice.getContent());
			pstmt.setInt(3, notice.getNo());
			
			int n = pstmt.executeUpdate();
			System.out.println(">> " + n + "개의 데이터 Update 완료");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void noticDelete(Connection con, String inputNum) {
		PreparedStatement pstmt = null;
		
		String sql = "delete from NOTICE where no = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(inputNum));
			
			pstmt.executeUpdate();
			System.out.println(">> " + inputNum + "번 글이 삭제되었습니다.");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
