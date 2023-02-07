<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<tag:main>
<jsp:include page="/view/component/header.jsp"></jsp:include>

   <br><br><br><br>
   <h1 class="qna_detail_title">Q&A 세부 내용 보기</h1>
   <br>
   <hr>
   <div id="target" class="qna_detail_target"></div>
   <br>
   <div class="qna_detail_btn_container">
	   <input type="button" value="제목 수정" onclick="updataTitle()">
	   <input type="button" value="내용 수정" onclick="updateContent()">
	   <input type="button" value="삭제하기" onclick="deleteQna()">
   </div>
   <br><br>


<%@ include file="/view/component/footer.jsp" %>
</tag:main>

<script>
   const urlSearch = new URLSearchParams(location.search);
   let qna_no = urlSearch.get('qna_no');

   function updataTitle() {
      location.href = "/nikepro/view/page/qna/qna_update_Title.jsp?qna_no=" + qna_no;
   }
   
   function updateContent() {
      location.href = "/nikepro/view/page/qna/qna_update_Content.jsp?qna_no=" + qna_no;
   }

   function deleteQna() {
      request.open('post', '/nikepro/QnaDelete.do', true);
      request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
      request.send("qna_no=" + qna_no);

      request.onreadystatechange = function () {
         if (request.readyState === 4 && request.status === 200) {
            let data = request.response;
            alert(data);
            location.href = "/nikepro/view/page/qna/qna_main.jsp";
         }
      }
   }

   const request = new XMLHttpRequest();

   request.open('post', '/nikepro/QnaDetail.do', true);
   request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
   request.send("qna_no=" + qna_no); //get방식으로 보냈더니 send에 보낸 데이터 인식안됨. post만 가능.

   request.onreadystatechange = function () {
      if (request.readyState === 4 && request.status === 200) {
         let target = document.getElementById('target');
         let data = request.response;

         let str = JSON.parse(data);

         let code = "";
         code += "<table border='1' class='qna_detail_table'>";
         code += "<tr><td>글번호</td><td>제목</td><td>작성자</td><td>작성일</td></tr>";
         code += "<tr><td>" + str.qna_no + "</td>";
         code += "<td>" + str.qna_title + "</td>";
         code += "<td>" + str.mem_id + "</td>";
         code += "<td>" + str.qna_date + "</td></tr>";
         code += "<tr><td colspan='4'>내용</td></tr>";
         code += "<tr><td colspan='4'>" + str.qna_content + "</td></tr>";
         code += "</table>";

         target.innerHTML = code;
      }
   }

</script>