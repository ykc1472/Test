package com.employee.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.common.util.CommonUtil;

public class Sales extends Employee {
	public final double COMMISSION_RATE = 0.2;
	private double commission;

	public Sales() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sales(int empno, String ename, String hiredate, String loc, int sal, String state) {
		super(empno, ename, hiredate, loc, sal, state);
		commission = sal*COMMISSION_RATE;
	}

	public Sales(int empno, String ename, String hiredate, String loc, int sal, String state, double commission) {
		super(empno, ename, hiredate, loc, sal, state);
		this.commission = commission;
	}

	@Override
	public String toString() {
		CommonUtil common = new CommonUtil();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = sdf.parse(super.getHiredate());
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
		return super.getEmpno() + "\t" + super.getEname() + "\t영업\t" + super.getLoc() + "\t" + common.getCurrency(super.getSal()) + "\t"
				+ common.getCurrency((int)commission) + "\t" + common.getDate(d) + "\t" + super.getState();
	}

}
