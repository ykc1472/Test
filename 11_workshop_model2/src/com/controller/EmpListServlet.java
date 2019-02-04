package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.EmpDTO;
import com.dto.PagingDTO;
import com.service.EmpService;

@WebServlet("/EmpListServlet")
public class EmpListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HashMap<String, Object> map = new HashMap<>();
		int year = 0;
		int type = 0;
		String ename = null;
		EmpDTO dto = new EmpDTO();
		
		EmpService service = new EmpService();
		PagingDTO paging = new PagingDTO(1);
		
		if(request.getParameter("offset") != null) {
			paging.setOffset(Integer.parseInt(request.getParameter("offset")));
		}
		
		if(request.getParameter("searchType") != null) {
			type = Integer.parseInt(request.getParameter("searchType"));
			if(type == 1) {
				year = Integer.parseInt(request.getParameter("search")); 
				map.put("year", year);
			} else if (type == 2) {
				ename = request.getParameter("search");
				dto.setEname(ename);
				map.put("dto", dto);
			}
			request.setAttribute("searchType", type);
			request.setAttribute("search", request.getParameter("search"));
		}
		paging = service.selectAllEmp(map, paging);

		request.setAttribute("paging", paging);
		RequestDispatcher dis = request.getRequestDispatcher("List.jsp");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
