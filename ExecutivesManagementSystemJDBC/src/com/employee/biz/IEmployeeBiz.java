package com.employee.biz;

import java.util.ArrayList;

import com.employee.entity.Employee;

public interface IEmployeeBiz {
	public abstract ArrayList<Employee> selectAllEmployee();

	public abstract ArrayList<Employee> searchList(String inputSubMenu, String searchWord);

	public abstract int createEmployeeNum();

	public abstract void employeeInsert(Employee emp);

	public abstract void employeeUpdate(Employee emp);

	public abstract void employeeDelete(int employeeNum);

	public abstract void employeeService(int empno, String inputColumn);

}
