package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.EmpDTO;
import com.service.EmpService;

/**
 * Servlet implementation class EmpWriteFormServlet
 */
@WebServlet("/EmpWriteServlet")
public class EmpWriteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int empno = Integer.parseInt(request.getParameter("empno"));
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		int mgr = Integer.parseInt(request.getParameter("mgr"));
		int sal = Integer.parseInt(request.getParameter("sal"));
		
		EmpDTO dto = new EmpDTO(empno, ename, job, mgr, sal);
		
		EmpService service = new EmpService();
		int success = 0;
		
		success = service.insertEmp(dto);

		if (success == 0) {
			request.setAttribute("mesg", "사원번호가 중복되어 테이블에 추가 할 수 없습니다.");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("EmpListServlet");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
