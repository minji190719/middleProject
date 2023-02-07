<%@page import="kr.or.ddit.vo.NoticeVO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/headMeta/headMain.jsp" %>
<title>공지사항 상세보기(관리자용)</title>
</head>
<body>
  <%@ include file="/view/component/header.jsp" %>
  <%@ include file="/view/page/qna/notice_searchForm.jsp" %>
  
 <%
 	NoticeVO vo = (NoticeVO) request.getAttribute("noticeVO");
 %>

<form action="<%=request.getContextPath()%>/noticeUpdate.do" method="post" class="notice_update_form">
	<table border="1">
			<tr>
				<td colspan="2"><input type="hidden" name="noValue" value="<%=vo.getNotice_no() %>">[관리자] 공지사항 <%=vo.getNotice_no() %>번</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" id="titleValue" name="titleValue" value="<%=vo.getNotice_title()%>"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea id="contentValue" name="contentValue"><%=vo.getNotice_content()%></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<div>
						<div>
							<input type="submit" value="글 수정" onclick="return no_inputCheck()">
						</div>
						<div>
							<input type="button" onclick="no_delete()" value="글 삭제">
						</div>
						<div>
							<input type="button" onclick="no_list()" value="목록으로 돌아가기">
						</div>
					</div>	
				</td>
			</tr>	
	</table>
</form>
<br>
  <%@ include file="/view/component/footer.jsp" %>
<script>
function no_update(){
	location.href = "<%=request.getContextPath()%>/noticeList.do";
}


function no_list(){
	location.href = "<%=request.getContextPath()%>/noticeList.do";
	
}

function no_delete(){
	if(confirm("삭제시 되돌릴 수 없습니다. 정말 삭제하시겠습니까?")==true){
		let notice_no = <%=vo.getNotice_no()%>;	
		location.href = "<%=request.getContextPath()%>/noticeDelete.do?notice_no=<%=vo.getNotice_no()%>";
	}
}

function no_inputCheck(){
	title = document.querySelector('#titleValue').value;
	content = document.querySelector('#contentValue').value;
	
	if(title==""){
		alert("제목을 입력하세요.");
		return false;
	}else if(content==""){
		alert("내용을 입력하세요.");
		return false;
	}
}

</script>
</body>
</html>



