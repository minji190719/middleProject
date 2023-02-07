<%@page import="kr.or.ddit.vo.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/headMeta/headMain.jsp" %>
<title>공지사항 상세보기(회원/비회원용)</title>
</head>
<body>
  <%@ include file="/view/component/header.jsp" %>
  <%@ include file="/view/page/qna/notice_searchForm.jsp" %>
  
 <%
 	NoticeVO vo = (NoticeVO) request.getAttribute("noticeVO");
 %>

<form class="notice_view_form" action="<%=request.getContextPath()%>/noticeUpdate.do" method="post">
	<table border="1">
			<tr>
				<td>제목</td>
				<td colspan="2"><%=vo.getNotice_title()%></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea readonly="readonly"><%=vo.getNotice_content().replace(' ', '\n')%></textarea></td>
			</tr>
			<tr>
				<td colspan="2" class="notice_view_btn">
					<input type="button" onclick="no_list()" value="목록으로 돌아가기">
				</td>
			</tr>	
	</table>
</form>
<br>
<br>
  <%@ include file="/view/component/footer.jsp" %>
<script>

function no_list(){
	location.href = "<%=request.getContextPath()%>/noticeList.do";	
}

</script>
</body>
</html>

