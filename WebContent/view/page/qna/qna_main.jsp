<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<head>
<title>Q&A Main</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.11.4/r-2.2.9/datatables.min.css"/>

</head>

<tag:main>
<jsp:include page="/view/component/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">
  
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>
	<div class="qna_main">	
		<br><br><br><br>
		<h1>Q&A</h1>
	    <br>
	    <input type="button" value="글쓰기" class="qna_main_input1" onclick="return loginCheck()">
	    <hr>
	        제목으로 검색하기 : <input type="text" id="searchTitle" class="qna_main_input2"><input type="button" value="검색" id="searchBtn_title">
	        아이디로 검색하기 : <input type="text" id="searchMem_id" class="qna_main_input3"><input type="button" value="검색" id="searchBtn_mem_id">    
	    <hr>
	    <table id="exampleTable" class="table table-bordered">   
	    </table>
	    <br>
	    <div id="target" class="qna_main"></div>
	</div>
	<br><br>
    
<%@ include file="/view/component/footer.jsp" %>
</tag:main>

<script src="/nikepro/js/qna_main.js"></script>
<script>
function loginCheck(){
	<%
		request.setCharacterEncoding("UTF-8");
		request.getSession(false);
		MemberVO member = (MemberVO) session.getAttribute("member");
		if(member==null){			
	%>
			alert("비회원은 글쓰기 대상이 아닙니다. 로그인 후 이용하세요.")
			return false;
	<%
		}else{
	%>
			location.href = "<%=request.getContextPath()%>/view/page/qna/qna_insert.jsp";
	<%
		}
	%>
}
</script>
