package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.EmpDTO;
import com.service.EmpService;

@WebServlet("/EmpUpdateServlet")
public class EmpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empno = Integer.parseInt(request.getParameter("empno"));
		String job = request.getParameter("job");
		int sal = Integer.parseInt(request.getParameter("sal"));
		EmpDTO dto = new EmpDTO(empno, job, sal);
		
		EmpService service = new EmpService();
		int success = 0;
		success = service.updateEmp(dto);
		
		if (success == 0) {
			request.setAttribute("mesg", "사원의 정보를 수정할 수 없습니다.");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("EmpListServlet");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
