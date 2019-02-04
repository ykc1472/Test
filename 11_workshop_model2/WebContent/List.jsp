<%@page import="com.dto.PagingDTO"%>
<%@page import="com.dto.EmpDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	PagingDTO paging = (PagingDTO)request.getAttribute("paging");
    	List<EmpDTO> list = paging.getList();
    	String range = (String)request.getAttribute("range");
    	int totalPage = paging.getTotalCount() / paging.getLimit();
    	if (paging.getTotalCount() % paging.getLimit() != 0){
    		totalPage++;
    	}
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	<% 
		if(request.getAttribute("mesg") != null){
	%>
		alert("Message : <%= request.getAttribute("mesg") %>");
	<% 
		}
	%>
</script>
</head>
<body>
	<b>[사원 목록]</b>
	<hr>
		<table border="1">
			<tr>
				<td colspan="5">
					<form action="" method="post">
						<select name="searchType">
							<% 
								if(request.getAttribute("searchType") != null){ 
									if((int)request.getAttribute("searchType") == 1){
							%>
										<option value = "1" selected="selected" >입사일(년도만)</option>
										<option value = "2">이름</option>
							<%
									} else {
							%>
										<option value = "1">입사일(년도만)</option>
										<option value = "2" selected="selected">이름</option>
							<%
									}
								} else {
							%>
								<option value = "1" selected="selected" >입사일(년도만)</option>
								<option value = "2">이름</option>
							<%
								}
							%>
						
						</select>
						<input type="text" name="search" id="search" <% if(request.getAttribute("search") != null){ %>
							value = "<%= request.getAttribute("search") %>"
						<% } %>
						>
						<input type="submit" id="searchButton"value="검색">
					</form>
				</td>
			</tr>
			<tr>
				<th>정렬기준</th>
				<td colspan="4">
					<form action="EmpOrderServlet" method="post">
					<% 
					if(range != null){
						if(range.equals("desc")){
					%>
							월급 높은 순:<input type="radio" name="range" value="desc" checked="checked">
							월급 낮은 순 : <input type="radio" name="range" value="asc">
						<%
						} else {
						%>
							월급 높은 순:<input type="radio" name="range" value="desc">
							월급 낮은 순 : <input type="radio" name="range" value="asc" checked="checked">
						<%
						} 
					} else {
						%>
						월급 높은 순:<input type="radio" name="range" value="desc">
						월급 낮은 순 : <input type="radio" name="range" value="asc">		
					<%
					}
					%>
						<input type="submit" id="rangeButton" value="정렬">
					</form>
				</td>
			</tr>
			<tr>
				<th>사원번호</th>
				<th>사원이름</th>
				<th>직업</th>
				<th>입사일</th>
				<th>월급</th>
			</tr>
			<%
				for(EmpDTO dto : list){
			%>
				<tr>
					<td><a href="EmpRetrieveServlet?empno=<%= dto.getEmpno()%>" ><%= dto.getEmpno()%></a></td>
					<td><%= dto.getEname() %></td>
					<td><%= dto.getJob() %></td>
					<td><%= dto.getHiredate() %></td>
					<td><%= dto.getSal() %></td>
				</tr>
			<%
				}
			%>
				<tr>
					<td colspan="5" align="center">
					<%
						for(int i = 1 ; i <= totalPage ; i++){
							if(i == paging.getOffset()){
					%>
							<span style="color: red;"><%= i %></span> &nbsp;
					<%
							} else {
					%>
						<% if(range == null){ %>
							<a href="EmpListServlet?offset=<%= i %>" ><%= i %></a> &nbsp;
						<% } else {%>
							<a href="EmpOrderServlet?offset=<%= i %>&range=<%= range %>" ><%= i %></a> &nbsp;
						<% } %>
							
					<%
							}
						}
					%>
					</td>
				</tr>
		</table>
	<a href="EmpWriteFormServlet">사원등록</a>
</body>
</html>