<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/headMeta/headMain.jsp" %>
<title>새글 등록</title>
</head>
<body>
  <%@ include file="/view/component/header.jsp" %>
<br><br>
<h3 class="notice_insert_title">[관리자] 공지사항 새 글을 등록합니다.</h3> 
<br><br>
<form class="notice_insert_form" id="noticeInsertForm" method="post" action="<%=request.getContextPath()%>/noticeInsert.do">
	<table border="1">
			<tr>
				<td>제목</td>
				<td colspan="2"><input type="text" placeholder="제목을 입력하세요." id="notice_title" name="notice_title"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="2"><textarea placeholder="내용을 입력하세요." rows="15"  cols="100%" id="notice_content" name="notice_content" style="resize: none;"></textarea></td>
			</tr>
			<tr>	
				<td colspan="3" class="notice_insert_btn">
					<div>
						<i class="fa-solid fa-pen-to-square" style="color: black"></i>
						<input type="submit" value="글 등록" onclick="return inputCheck()">
					</div>
					<div>
						<i class="fa-solid fa-eraser" style="color: black"></i>
						<input type="reset" value ="초기화">
					</div>
					<div>
						<i class="fa-solid fa-list" style="color: black"></i>
						<input type="button" onclick="no_list()" value="목록으로 돌아가기">
					</div>
				</td>
			</tr>	
	</table>
	<br>
</form>
  <%@ include file="/view/component/footer.jsp" %>
<script>


function inputCheck(){
	title = document.querySelector('#notice_title').value;
	content = document.querySelector('#notice_content').value;
	
	if(title==""){
		alert("제목을 입력하세요.");
		return false;
	}else if(content==""){
		alert("내용을 입력하세요.");
		return false;
	}
}

function no_list(){
	location.href = "<%=request.getContextPath()%>/noticeList.do";
	
}

</script>
</body>
</html>
