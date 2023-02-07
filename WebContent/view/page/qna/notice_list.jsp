<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="kr.or.ddit.vo.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/headMeta/headMain.jsp" %>
<title>공지사항 리스트</title>
</head>
<body>
  <%@ include file="/view/component/header.jsp" %>
  <%@ include file="/view/page/qna/notice_searchForm.jsp" %>
  
<%
   request.setCharacterEncoding("utf-8");
   String mem_id = (String) request.getAttribute("mem_id");
   List<NoticeVO> noticeList = (List<NoticeVO>) request.getAttribute("noticeList");
   //int deleteResult = (int) request.getAttribute("deleteResult");
%>

<div class="notice_list_title_container">
	<h2>공지사항 및 고객 알림&nbsp;&nbsp;</h2>
<%  if(mem_id!=null && mem_id.equals("ADMIN")){
%>
	<input type="button" class="notice_list_btnAdd" id="notice_btnAdd" value="공지사항 추가" onclick="notice_insert_move()">
<%
	}
%>	
</div>
<br>
<ul class="notice_list_rowSet">
	
<%
      for(int i = 14; i < noticeList.size(); i++){  
    	  if(noticeList.get(i)==null){
%>
	<li><h3>작성된 공지사항이 없습니다.</h3></li>
<%   		  
    	  }else{
%>		
	<li><a href="<%=request.getContextPath() %>/noticeView.do?notice_no=<%=noticeList.get(i).getNotice_no()%>"><%=noticeList.get(i).getNotice_title()%></a></li>	
<%
      	  }      

	   }	
%>
</ul>
<br>
<h4 class="notice_list_row_bottom">그 외 궁금하신 점은 Q/A 게시판을 이용해주세요</h4>
<br><br>
<script>
	function notice_insert_move(){
		location.href = "<%=request.getContextPath()%>/noticeForm.do";
	}

</script>
  <%@ include file="/view/component/footer.jsp" %>
</body>
</html>