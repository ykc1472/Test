package com.employee.entity;

import java.util.Date;

public class Employee {
	private int empno;
	private String ename;
	private String hiredate;
	private String loc;
	private int sal;
	private String state;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int empno, String ename, String hiredate, String loc, int sal, String state) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.hiredate = hiredate;
		this.loc = loc;
		this.sal = sal;
		this.state = state;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return empno + "\t" + ename + "\t" + loc + "\t" + sal + "\t" + hiredate + "t" + state;
	}

}
