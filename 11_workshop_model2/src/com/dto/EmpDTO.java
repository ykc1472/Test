package com.dto;

public class EmpDTO {
	private int empno;
	private String ename;
	private String ename_upper;
	private String ename_lower;
	private String job;
	private int mgr;
	private String hiredate;
	private int sal;
	private int comm;
	private int deptno;

	public EmpDTO() {
		super();
	}

	public EmpDTO(int empno, String ename, String job, int mgr, int sal) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.ename_lower = ename.toLowerCase();
		this.ename_upper = ename.toUpperCase();
		this.job = job;
		this.mgr = mgr;
		this.sal = sal;
	}

	public EmpDTO(int empno, String job, int sal) {
		super();
		this.empno = empno;
		this.job = job;
		this.sal = sal;
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
		this.ename_lower = ename.toLowerCase();
		this.ename_upper = ename.toUpperCase();
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getEname_upper() {
		return ename_upper;
	}

	public void setEname_upper(String ename_upper) {
		this.ename_upper = ename_upper;
	}

	public String getEname_lower() {
		return ename_lower;
	}

	public void setEname_lower(String ename_lower) {
		this.ename_lower = ename_lower;
	}

	@Override
	public String toString() {
		return "EmpDTO [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate="
				+ hiredate + ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}

}
