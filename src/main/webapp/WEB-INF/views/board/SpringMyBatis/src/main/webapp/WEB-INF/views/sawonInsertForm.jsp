<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- form태그 대신 이렇게도 쓸수있음 taglib을 선언해주고 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr"/>
<title>사원등록</title>
</head>
<body>
	<h1>사원 등록</h1>
	<!-- 여기서 태그립을 사용한 form을 사용할 수 있음 -->
	<form action="sawonInsert.do" method="post">
  <table border="2">
	<tr><td>사번</td>
			<td><input type="text" name="id"></td></tr>
	<tr><td>이름</td>
	  		<td><input type="text" name="name"></td></tr>
   <tr><td>전화번호</td>
			<td><input type="text" name="tel"></td></tr>
   <tr><td colspan="2"><input type="submit" value="추가"></td></tr>
  </table>
</form>	 
</body>
</html>
