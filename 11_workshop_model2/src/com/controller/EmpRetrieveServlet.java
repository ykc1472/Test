package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.EmpDTO;
import com.service.EmpService;

@WebServlet("/EmpRetrieveServlet")
public class EmpRetrieveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int empno = Integer.parseInt(request.getParameter("empno"));
		EmpDTO dto = null;
		List<String> list = null;
		EmpService service = new EmpService();
		list = service.selectEmpJobList();
		dto = service.SelectEmp(empno);
		
		request.setAttribute("dto", dto);
		request.setAttribute("list", list);
		
		RequestDispatcher dis = request.getRequestDispatcher("retrieve.jsp");
		dis.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
