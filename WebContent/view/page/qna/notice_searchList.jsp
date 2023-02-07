<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.NoticeVO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
		request.setCharacterEncoding("utf-8");
		String notice_title = (String) request.getAttribute("notice_title");
		List<NoticeVO> list = (List<NoticeVO>) request.getAttribute("list");
	%>
<div class="notice_searchList_container">
	<h3>다음에 관한 검색 결과 "<%= notice_title %>"</h3>
	<hr>
		<%
			if(list==null || list.size()==0){
		%>
				<h4>결과 없음</h4>
				<br>
				<h5><a href="#">문의하기</a></h5>
		<%
			}else{
		    	for(int i = 0; i < list.size(); i++){  
		%>
					<br>
					<a href="#" name="<%= list.get(i).getNotice_no()%>" onclick="getTitle(this)" class="notice_address"><%= list.get(i).getNotice_title()%></a>
		<%
					if(list.get(i).getNotice_content().length() > 40){
		%>
						<h6> <%= list.get(i).getNotice_content().substring(0, 40)%>...</h6><br><hr>
		<%				
					}else{
		%>
						<h6> <%= list.get(i).getNotice_content()%></h6><br><hr>
		<%			
					}
	      		}
	 	  	}
		%>    
</div>
<br>
<br>
		  
	<%@ include file="/view/component/footer.jsp" %>
	
<script>
	function getTitle(a){
		let addrf = "view/page/qna/notice_detail/notice_detail";
		let num = a.getAttribute('name');
		let addrb = ".jsp";
		let address = addrf + num + addrb
		a.setAttribute('href', address);
	}
</script>
</body>
</html>