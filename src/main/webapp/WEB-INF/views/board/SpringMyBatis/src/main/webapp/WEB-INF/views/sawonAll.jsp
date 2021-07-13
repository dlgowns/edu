<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<%if(session.getAttribute("loginVO")==null) {%>
	<script>
		alert("로그인 해주세요!");
		location.href="start.do";
	</script>	
<%}%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<h1>사원 전체 명단</h1>
	<table border="2">
	<thead>	<tr><th>번호</th>	<th>이름</th>	<th>전화</th>	</tr>
	</thead>
	<tbody>
		<c:forEach var="imsi" items="${alist}">
		<tr><td>${imsi.id}</td>
			<%-- <td>${imsi.name}</td> --%>
			<td><a href="getTelinfo.do?name=${imsi.name}"> ${imsi.name}</a>
			<td>${imsi.tel}</td> </tr>
		</c:forEach>
	</tbody>
	</table>
	<div>
	<a href="<c:url value='/sawonInsertForm.do' />">[사원등록]</a>
	<a href="<c:url value='/sawonAll.do' />">[모두보기]</a>
	</div>
	
	
	
	
	
		
</body>
</html>
