package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.common.util.CommonUtil;
import com.employee.entity.Employee;
import com.employee.entity.Engineer;
import com.employee.entity.Sales;

public class EmployeeDAO {
	public ArrayList<Employee> selectAllEmployee(Connection con) {
		ArrayList<Employee> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select empno, ename, dname, loc, sal, hiredate, state from employee";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Employee employee = null;

				if (rs.getString("dname").equals("영업")) {
					employee = new Sales(rs.getInt("empno"), rs.getString("ename"), rs.getString("hiredate"),
							rs.getString("loc"), rs.getInt("sal"), rs.getString("state"));
				} else if (rs.getString("dname").equals("개발")) {
					employee = new Engineer(rs.getInt("empno"), rs.getString("ename"), rs.getString("hiredate"),
							rs.getString("loc"), rs.getInt("sal"), rs.getString("state"));
				}

				list.add(employee);
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

	public ArrayList<Employee> searchList(Connection con, String inputSubMenu, String searchWord) {
		Employee employee = new Employee();
		ArrayList<Employee> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;


		String sql = "";
		try {
			if(inputSubMenu.equals("1")) {
				employee = searchEmployee(con, Integer.parseInt(searchWord));
				list.add(employee);
			}
			else{
				if (inputSubMenu.equals("2")) {
					sql = "select empno, ename, dname, loc, sal, hiredate, state from employee where ename = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, searchWord);
				}
				else if (inputSubMenu.equals("3")) {
					sql = "select empno, ename, dname, loc, sal, hiredate, state from employee where dname = ?";
					pstmt = con.prepareStatement(sql);
					if(searchWord.equals("1")) {
						pstmt.setString(1, "영업");
					}
					else if (searchWord.equals("2")) {
						pstmt.setString(1, "개발");
					}
				}
				else if (inputSubMenu.equals("4")) {
					sql = "select empno, ename, dname, loc, sal, hiredate, state from employee where loc = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, searchWord);
				}
				else if (inputSubMenu.equals("5")) {
					sql = "select empno, ename, dname, loc, sal, hiredate, state from employee where sal = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, Integer.parseInt(searchWord));
				}
				
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					if (rs.getString("dname").equals("영업")) {
						employee = new Sales(rs.getInt("empno"), rs.getString("ename"), rs.getString("hiredate"),
								rs.getString("loc"), rs.getInt("sal"), rs.getString("state"));
					} else if (rs.getString("dname").equals("개발")) {
						employee = new Engineer(rs.getInt("empno"), rs.getString("ename"), rs.getString("hiredate"),
								rs.getString("loc"), rs.getInt("sal"), rs.getString("state"));
					}
					list.add(employee);
				}
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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

	public int createEmployeeNum(Connection con) {

		return 0;
	}

	public void employeeInsert(Connection con, Employee emp) {
		PreparedStatement pstmt = null;

		String sql = "insert into EMPLOYEE (empno, ename, dname, loc, sal, hiredate, state)" + 
				"values (?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			if (emp instanceof Sales) {
				pstmt.setString(3, "영업");
			}
			else if(emp instanceof Engineer) {
				pstmt.setString(3, "개발");
			}
			pstmt.setString(4, emp.getLoc());
			pstmt.setInt(5, emp.getSal());
			if (emp.getHiredate().equals("")){
				java.sql.Date daySql = new java.sql.Date(System.currentTimeMillis());
				
				pstmt.setDate(6, daySql);
			}
			else {
				CommonUtil common = new CommonUtil();
				java.sql.Date daySql = new java.sql.Date(common.getDate(emp.getHiredate()).getTime());
				pstmt.setDate(6, daySql);
			}
			pstmt.setString(7, emp.getState());
			int n = pstmt.executeUpdate();
			System.out.println(">> " + n + "개의 데이터 Insert 완료");

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
	private Employee searchEmployee(Connection con, int empno) {
		Employee employee = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select empno, ename, dname, loc, sal, hiredate, state from employee where empno = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("dname").equals("영업")) {
					employee = new Sales(rs.getInt("empno"), rs.getString("ename"), rs.getString("hiredate"),
							rs.getString("loc"), rs.getInt("sal"), rs.getString("state"));
				} else if (rs.getString("dname").equals("개발")) {
					employee = new Engineer(rs.getInt("empno"), rs.getString("ename"), rs.getString("hiredate"),
							rs.getString("loc"), rs.getInt("sal"), rs.getString("state"));
				}
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
		return employee;
	}

	public void employeeUpdate(Connection con, Employee emp) {
		PreparedStatement pstmt = null;
		
		String sql = "update EMPLOYEE set ename = ?, dname = ?, loc = ?, sal = ?" + 
				" where empno = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(5, emp.getEmpno());
			
			pstmt.setString(1, emp.getEname());
			if (emp instanceof Sales) {
				pstmt.setString(2, "영업");
			}
			else if(emp instanceof Engineer) {
				pstmt.setString(2, "개발");
			}

			pstmt.setString(3, emp.getLoc());
			pstmt.setInt(4, emp.getSal());
			
			
			
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

	public void employeeDelete(Connection con, int empno) {
		PreparedStatement pstmt = null;
		
		String sql = "delete from employee where empno = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, empno);
			
			int n = pstmt.executeUpdate();
			System.out.println(">> " + n + "개의 데이터 Delete 완료");
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
	
	public void employeeService(Connection con, int empno, String inputColumn) {
		PreparedStatement pstmt = null;
		
		String sql = "update EMPLOYEE set state = ?" + 
				" where empno = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, inputColumn);
			
			pstmt.setInt(2, empno);
			
			int n = pstmt.executeUpdate();
			System.out.println(">> " + n + "개의 근태 데이터 Update 완료");

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

}
