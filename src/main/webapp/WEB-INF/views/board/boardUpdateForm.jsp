<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!-- <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
<title>boardView</title>
</head>


<script type="text/javascript">
$j(document).ready(function(){
	
	$j("#uptest").on("click",function(){
		/* var $frm = $j('.boardUp :input');
		var param = $frm.serialize(); */
		
		$j.ajax({
		    url : "/board/boardUpdate.do?boardNum=${boardNum}",
		    dataType: "json",
		    type: "POST",
		    /* data : param, */
		    success: function(data, textStatus, jqXHR)
		    {
				alert("수정완료");
				
				alert("메세지:"+data.success);
				
				location.href = "/board/boardList.do?pageNo=0";
		    },
		    error: function (jqXHR, textStatus, errorThrown)
		    {
		    	alert("실패");
		    }
		});
	});
});
</script> 
<body>
<%-- <form role="form" method="post">
<input type="hidden" name="boardNum" value="${board.boardNum}" />
</form> --%>

<table align="center">
<tr>
		<td align="right">

			
		
		</td>
	</tr>
	<tr>

		<td>
		<form class="boardUp" action="/board/boardUpdate.do?boardNum=${board.boardNum}" method="post">
			<table border ="1">
				<tr>
					<td width="120" align="center">
					Title
					</td>
					<td width="400">
					<input type="text" id="btitle" name="boardTitle" size="50" value="${board.boardTitle}"/>
					</td>
				</tr>
				<tr>
					<td height="300" align="center">
					Comment
					</td>
					<td>
					<textarea name="boardComment"  rows="20" cols="55">${board.boardComment}</textarea>
					
					</td>
				</tr>
				<tr>
					<td align="center">
					Writer
					</td>
			
				</tr>
				<tr><td colspan="2"><input id="uptest" type="button" value="가자 수정"></td></tr>
			</table>
			</form>
		</td>
	</tr>
	
	<%-- <a href="/board/boardUpdate.do?boardNum=${board.boardNum}&boardTitle=${board.boardTitle}&boardComment=${board.boardComment}">가자 수정</a> --%>
	
	
	
	
</table>



<%-- <table>
<tr>
<td><button id="delete"  style=margin-left:830px; onclick="location.href='/board/boardDelete.do?boardNum=${board.boardNum}'">삭제하기</button></td>
</tr>
</table> --%>



<!-- <script type="text/javascript">

function Update(boardNum) {
	
	let boardTitle = $("#btitle").val();
	let boardComment = $("#bcomment").val();
	
	location.href= "/board/boardUpdate.do?boardNum="+boardNum+"&boardTitle="+boardTitle+"&boardComment="+boardComment;
}


</script> -->

</body>
</html>