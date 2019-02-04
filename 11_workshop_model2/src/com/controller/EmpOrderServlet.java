package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.EmpDTO;
import com.dto.PagingDTO;
import com.service.EmpService;

@WebServlet("/EmpOrderServlet")
public class EmpOrderServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String range = request.getParameter("range");
		HashMap<String, Object> map = new HashMap<>();
		List<EmpDTO> list = null;
		PagingDTO paging = new PagingDTO(1);
		if(request.getParameter("offset") != null) {
			paging.setOffset(Integer.parseInt(request.getParameter("offset")));
		}
		EmpService service = new EmpService();
		map.put("range", range);
		
		paging = service.selectAllEmp(map, paging);
		
		request.setAttribute("range", range);
		request.setAttribute("paging", paging);
		RequestDispatcher dis = request.getRequestDispatcher("List.jsp");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
