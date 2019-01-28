package com.employee.biz;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.employee.dao.EmployeeDAO;
import com.employee.entity.Employee;

public class EmployeeBiz implements IEmployeeBiz {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String user = "scott";
	private String pass = "tiger";
	private EmployeeDAO dao;

	public EmployeeBiz() {
		super();
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<Employee> selectAllEmployee() {
		Connection con = null;
		ArrayList<Employee> list = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
			dao = new EmployeeDAO();
			list = dao.selectAllEmployee(con);

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
	public ArrayList<Employee> searchList(String inputSubMenu, String searchWord) {
		Connection con = null;
		ArrayList<Employee> list = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
			dao = new EmployeeDAO();
			list = dao.searchList(con, inputSubMenu, searchWord);
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

		return list;
	}

	@Override
	public int createEmployeeNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void employeeInsert(Employee emp) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
			dao = new EmployeeDAO();
			dao.employeeInsert(con, emp);
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
	public void employeeUpdate(Employee emp) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
			
			dao = new EmployeeDAO();
			dao.employeeUpdate(con, emp);
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
	public void employeeDelete(int employeeNum) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
			
			dao = new EmployeeDAO();
			dao.employeeDelete(con, employeeNum);
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
	public void employeeService(int empno, String inputColumn) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
			
			dao = new EmployeeDAO();
			dao.employeeService(con, empno, inputColumn);
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
