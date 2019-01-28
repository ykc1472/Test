package com.notice.biz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.employee.dao.EmployeeDAO;
import com.notice.dao.NoticeDAO;
import com.notice.entity.Notice;

public class NoticeBiz implements INoticeBiz {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String user = "scott";
	private String pass = "tiger";
	private NoticeDAO dao;
	
	
	public NoticeBiz() {
		super();
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Notice> selectAllNotice() {
		Connection con = null;
		ArrayList<Notice> list = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
			dao = new NoticeDAO();
			list = dao.selectAllNotice(con);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	public Notice selectDetailNotice(String noticeNum) {
		Connection con = null;
		Notice notice = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
			dao = new NoticeDAO();
			notice = dao.selectDetailNotic(con, noticeNum);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return notice;
	}

	@Override
	public void noticeUpdate(Notice notice) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
			
			dao = new NoticeDAO();
			dao.noticeUpdate(con, notice);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void noticeDelete(String inputNum) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
			
			dao = new NoticeDAO();
			dao.noticDelete(con, inputNum);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
