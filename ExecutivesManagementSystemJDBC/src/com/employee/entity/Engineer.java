package com.employee.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.common.util.CommonUtil;

public class Engineer extends Employee {

	public Engineer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Engineer(int empno, String ename, String hiredate, String loc, int sal, String state) {
		super(empno, ename, hiredate, loc, sal, state);
		// TODO Auto-generated constructor stub
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
		return super.getEmpno() + "\t" + super.getEname() + "\t개발\t" + super.getLoc() + "\t" + common.getCurrency(super.getSal()) + "\t\t"
				+ common.getDate(d) + "\t" + super.getState();
	}

}
