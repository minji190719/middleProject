<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<head>
<title>Insert title here</title>
<style>
.qna_insert_title{
	width: 1000px;
	margin: 0 auto;
	font-size: 2em;
	font-weight: bold;
	text-align: center;
}
</style>
</head>

<tag:main>
<jsp:include page="/view/component/header.jsp"></jsp:include>

<br><br><br><br>
<h2 class="qna_insert_title">Q&amp;A 문의글 작성하기</h2>
<br>
<hr>
<br>
<table class="qna_insert_table">
	<tr>
		<td>제목</td>
		<td><input type="text" id="qna_title" name="qna_title"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea rows="5" cols="33" id="qna_content" name="qna_title"></textarea></td>
	</tr>
</table>
<br>
<input type="button" id="insertBtn" class="qna_insert_btn" value="Q&A 작성하기">
<hr>
<br>

<%@ include file="/view/component/footer.jsp" %>
</tag:main>

<script>

const urlSearch = new URLSearchParams(location.search);
let prod_id = urlSearch.get("prod_id");

   document.getElementById("insertBtn").onclick = function () {
	   
      let qna_title = document.getElementById("qna_title").value;
      let qna_content = document.getElementById("qna_content").value;

      const request = new XMLHttpRequest();

      request.open("post", "/nikepro/QnaInsert_prod.do", true);
      request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
      request.send("prod_id=" + prod_id + "&qna_title=" + qna_title + "&qna_content=" + qna_content);
      

      request.onreadystatechange = function () {
         if (request.readyState === 4 && request.status === 200) {
            let data = request.response;
            alert(data);
            location.href = "/nikepro/QnaMyList.do";
         }
      }
   }
</script>