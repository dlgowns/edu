<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%if(session.getAttribute("loginVO")==null) {%>
    <script>
    	alert("로그인 해주세요!");
    	location.href="start.do";
    </script>
    <%} %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <h1>${loginVO.id}님 환영합니다!</h1>
 <table border="1">
 <tr><th colspan="4">[메뉴선택]</th></tr>
 <tr>
     <td><a href="sawonAll.do">[사원 모두보기]</a>
     <td><a href="memberMypage.do?id=${loginVO.id}">[내 정보 보기]</a></td>
     <td><a href="memberLogout.do">[로그아웃]</a>
     <td><a href="memberDelete.do?id=${loginVO.id}">[회원탈퇴]</a></td>
	</tr>
 </table>
</body>
</html>