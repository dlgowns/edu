<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%if(session.getAttribute("loginVO")==null) {%>
	<script>
		alert("로그인 해주세요!");
		location.href="start.do";
	</script>	
	<%}%>
    
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> ${mMypage.id }님 정보</h1>
<form action="memberUpdate.do?id=${mMypage.id}" method="post">
<table border="2">
<tr>
<td width="100px">아이디</td>
<td width="100px">${mMypage.id}</td>
</tr>
<tr>
<td>비밀번호</td>
<td><input type="text" name="pw" value="${mMypage.pw}" /></td>
</tr>
</table>
<input type="submit" value="수정하기" />
<a href="sawonLoginViewStart.do">[뒤로가기]</a>

</form>
</body>
</html>