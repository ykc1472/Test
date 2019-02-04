<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<b>[ 사원 등록] </b>
	<hr>
	<span style="color: red;">emp 테이블에 누락된 컬럼은 모두 null 또는  0 저장한다.</span>
	<form action="EmpWriteServlet" method="post">
		<table border="1">
			<tr>
				<th>사원번호</th>
				<td><input type="text" value="1100" name="empno">
				<span id="result">DB 확인후에 중복되지 않는 값을  사원번호 설정한다.</span></td>
			</tr>
			<tr>
				<th>사원이름</th>
				<td><input type="text" name="ename"></td>
			</tr>
			<tr>
				<th>직업</th>
				<td>
					<select name="job">
						<option value="CLERK">CLERK</option>
						<option value="MANAGER">MANAGER</option>
						<option value="ANALYST">ANALYST</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>관리자</th>
				<td><input type="text" name="mgr" value="7962"></td>
			</tr>
			<tr>
				<th>입사일</th>
				<td>입사일은 현재 날짜로 저장한다.</td>
			</tr>
			<tr>
				<th>월급</th>
				<td><input type="text" name="sal" value="1500">실습을 위해서 1500으로 고정</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="사원등록">
				<input type="reset" value="다시입력"></td>
			</tr>
		</table>
	</form>
	<a href="EmpListServlet">목록보기</a>
</body>
</html>