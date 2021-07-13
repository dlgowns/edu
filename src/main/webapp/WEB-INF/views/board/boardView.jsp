<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>boardView</title>
</head>
 <script type="text/javascript">

	$j(document).ready(function(){
		
		$j("#deltest").on("click",function(){
			
			/* var $frm = $j('.boardDel :input');
			var param = $frm.serialize(); */
			
			$j.ajax({
			    url : "/board/boardDelete.do?boardNum=${boardNum}",			
			    dataType: "json",
			    type: "GET",
			    /* data : param, */
			    success: function(data, textStatus, jqXHR)
			    {
			    						
					if(data.success=="Y") {
						alert("삭제완료");
						alert("메세지:"+ data.success);
						location.href = "/board/boardList.do?pageNo=0"; 
					} else if(data.success=="N"){
						alert("이미 삭제된 게시물입니다.");
					}
					
					 
					
					/* if(resultCnt =="success") {
						alert("삭제완료");
						alert("메세지:"+ data.success);
						
						location.href = "/board/boardList.do?pageNo=0";
					
					}else {
						alert("이미 삭제된 데이터입니다.")
						
						location.href = "/board/boardList.do?pageNo=0";
					} */
			    },
			    error: function (jqXHR, textStatus, errorThrown)
			    {
			    	alert("실패");
			    	/* location.href = "/board/boardList.do?pageNo=0"; */
			    }
			});
		});
	});
</script>  
<body>
<form class="boardDel" action="/board/boardDelete.do?boardNum=${boardNum}" method="GET">
<table align="center">
   <tr>
      <td>
         <table border ="1">
            
            <tr>
               <td width="120" align="center">
               Title
               </td>
               <td width="400">
               ${board.boardTitle}
               </td>
            </tr>
            <tr>
               <td height="300" align="center">
               Comment
               </td>
               <td>
               ${board.boardComment}
               </td>
            </tr>
            <tr>
               <td align="center">
               Writer
               </td>
               <td>
               </td>
            </tr>
         </table>
      </td>
   </tr>
   <tr>
      <td align="right">
         <input id="deltest" type="button" value="삭제하기">
         <a href="/board/${board.boardType}/${board.boardNum}/boardUpdateForm.do">수정하기</a>
         <a href="/board/boardList.do">List</a>
      </td>
   </tr>
</table>   
</form>


<!-- <script type="text/javascript">

 function boardDelete(boardNum, boardType) {
   
   $j.ajax({
       url : "/board/boardDelete.do",
       dataType: "json",
       type: "GET",
       contentType : "application/json; charset:UTF-8",
       data : {"boardNum" : boardNum, "boardType" : boardType},
       success: function(data, textStatus, jqXHR)
       {
          alert("성공");
         
         alert("메세지:"+data.success);
         
         location.href = "/board/boardList.do?pageNo=0";
         
       },
       error: function (jqXHR, textStatus, errorThrown)
       {
          alert("실패");
       }
   });

}

</script>  -->
</body>
</html>