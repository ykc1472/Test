<%@page import="com.dto.EmpDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	List<String> list = (List<String>)request.getAttribute("list");
    	EmpDTO dto = (EmpDTO)request.getAttribute("dto");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<b> [ 사원 정보 보기 ]</b>
	<hr>
	<span style="color: red;">직업(job)과 월급(sal)만 수정 가능하도록 구현한다.</span>
	<form action="EmpUpdateServlet?empno=<%= dto.getEmpno() %>" method="post">
		<table	border="1">
			<tr>
				<th>사원번호</th>
				<td><%= dto.getEmpno() %></td>
			</tr>
			<tr>
				<th>사원이름</th>
				<td><%= dto.getEname() %></td>
			</tr>
			<tr>
				<th>직업</th>
				<td><select name="job">
					<%
						for(String job : list){
							if(job.equals(dto.getJob())){
					%>
								<option value="<%= job %>" selected="selected" ><%= job %></option>
						<%
							} else{
						%>		
								<option value="<%= job %>"><%= job %></option>
						<%	
							}
						%>
					<%	
						}
					%>
				</select></td>
			</tr>
			<tr>
				<th>관리자</th>
				<td><%= dto.getMgr() %></td>
			</tr>
			<tr>
				<th>입사일</th>
				<td><%= dto.getHiredate() %></td>
			</tr>
			<tr>
				<th>월급</th>
				<td><input type="text" name="sal" value="<%= dto.getSal() %>"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="사원수정"></td>
			</tr>
		</table>
	</form>
	<a href="EmpListServlet">목록보기</a>&nbsp;&nbsp;<a href="EmpDeleteServlet?empno=<%= dto.getEmpno() %>">삭제</a>
	
</body>
</html>