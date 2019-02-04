package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.EmpService;

@WebServlet("/EmpDeleteServlet")
public class EmpDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int empno = Integer.parseInt(request.getParameter("empno"));
		int success = 0;
		
		EmpService service = new EmpService();
		success = service.deleteEmp(empno);
		
		if(success == 0) {
			request.setAttribute("mesg", "사원번호를 삭제 할 수 없습니다.");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("EmpListServlet");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
