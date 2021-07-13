<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1>
  <form action="memberInsert.do" method="post">
  <table border="1">
   <tr>
        <td>아이디</td>
        <td><input type="text" name="id"></td>
        </tr>
        
        <tr>
        <td><input type="password" name="pw"></td>
        </tr>
       
       <tr>
          <td colspan="2">
            <input type="submit" value="회원가입">
            <a href="start.do">[로그인창으로]</a>
        </td>
        </tr>
  </table>
  </form>
</body>
</html>