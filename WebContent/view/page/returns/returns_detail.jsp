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
    <br><br><br><br>
    <h2 class="returns_detail_title">내 반품요청 상세페이지</h2>
    <div class="returns_detail_container">
    <hr>
	   	<div id="target" class="returns_detail_target"></div>
	    <div class="returns_detail_btncontainer">
		    <input type="button" value="수정하기" id="updateBtn_toss" class="returns_detail_updateBtn_toss">
		    <input type="button" value="삭제하기" id="deleteBtn_toss" class="returns_detail_deleteBtn_toss">   
	    </div>
    </div>
    <hr>
    
<%@ include file="/view/component/footer.jsp" %>
</tag:main>

<script>
const urlSearch = new URLSearchParams(location.search);
let returns_no = urlSearch.get("returns_no");



window.onload = function () {
    
    //alert(returns_no);
   const request = new XMLHttpRequest();

   request.open("post", "/nikepro/returnsDetail.do", true);

   request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

   request.send("returns_no=" + returns_no);

   request.onreadystatechange = function () {
      if (request.readyState === 4 && request.status === 200) {
         let target = document.getElementById("target");
         let data = request.response;

         if (data === "로그인을 해주세요.") {
            alert(data);
            location.href = "/nikepro/SnsMain.do";

         } else if (data === "해당 게시물이 없습니다.") {
            alert(data);
            location.href = "/nikepro/SnsMain.do";

         } else {
            let str = JSON.parse(data);
            let code = "";
            
            code +=  '<table id="exampleTable" class="table table-bordered">';
            
            code += "<thead><tr><td>&nbsp;</td><td>제목</td><td>작성자</td><td>상품명</td><td>결제일</td><td>작성일</td></tr></thead>";
           
            code += '<tbody>';
            code += "<tr><td>" + str.returns_no + "</td>";
            code += "<td>" + str.returns_title + "</td>";
            code += "<td>" + str.mem_id + "</td>";
            code += "<td>" + str.prod_name + "</td>";
            code += "<td>" + str.pay_date + "</td>";
            code += "<td>" + str.returns_date + "</td></tr>";
            code += '</tbody>';
           
            code += '</table>';
            code += '<h2>작성 내용</h2>';
            code += '<div class="returns_detail_content">' + str.returns_content + '</div>';
            code += '<br>'
            
            target.innerHTML = code;

            $('#exampleTable').DataTable({
               order: [[3, 'desc']],
               ordering: true,
               serverSide: false,
               searching: false,
               paging: false,
           	   lengthChange: false,
           	   info: false
            });

         }

      }
   }
}

document.getElementById("updateBtn_toss").onclick = function () {

	location.href = "/nikepro/returnsUpdate.do?returns_no=" + returns_no;
	
}

document.getElementById("deleteBtn_toss").onclick = function () {
	
	if ( confirm("삭제하시겠습니까?") ) {
	    
	    const request = new XMLHttpRequest();

	    request.open("post", "/nikepro/returnsDelete.do", true);

	    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	    request.send("returns_no=" + returns_no);
	    
	    request.onreadystatechange = function () {
	    	 if (request.readyState === 4 && request.status === 200) {
	    		 let data = request.response;
	    		 alert(data);
	    		 
	    		 location.href = "/nikepro/returnsMyList.do";
	    	 }
	    }
	}
	
}


/* document.getElementById("updateBtn_toss").onclick = function () {
   const request = new XMLHttpRequest();

   request.open("post", "/nikepro/returnsDetail.do", true);

   request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

   request.send("returns_no=" + returns_no);

   request.onreadystatechange = function () {
      if (request.readyState === 4 && request.status === 200) {
         let target = document.getElementById("target");
         let data = request.response;

         if (data === "로그인을 해주세요.") {
            alert(data);
            location.href = "/nikepro/SnsMain.do";

         } else if (data === "해당 게시물이 없습니다.") {
            alert(data);
            location.href = "/nikepro/SnsMain.do";

         } else {
        	 
            let str = JSON.parse(data);
            
        	 
            let code = "";
            
            code +=  '<table id="exampleTable2" class="table table-bordered">';
            
            code += "<thead><tr><td>신청번호</td><td>제목</td><td>작성자</td><td>상품명</td><td>결제일</td><td>작성일</td></tr></thead>";
           
            code += '<tbody>';
            code += "<tr><td>" + str.returns_no + "</td>";
            code += "<td>" + str.returns_title + "</td>";
            code += "<td>" + str.mem_id + "</td>";
            code += "<td>" + str.prod_name + "</td>";
            code += "<td>" + str.pay_date + "</td>";
            code += "<td>" + str.returns_date + "</td></tr>";
            code += '</tbody>';
            
            code += '</table>'
            
            code += '제목 수정하기 : <input type="text" id="titleBox" placeholder="' + str.returns_title + '">';
            code += '내용 수정하기 : <input type="text" id="contentBox" placeholder="' + str.returns_content + '">';
            code += '<input type="button" value="수정하기" id="updateBtn">';
            
            document.getElementById('updateBtn').onclick = function () {
        		 location.href = "/nikepro/returnsUpdate.do?returns_no=" + str.returns_no 
        				 + "&returns_title=" + document.getElementById('titleBox').value + "&returns_content=" + document.getElementById('contentBox').value;
        	 }
            
            target.innerHTML = code;

            $('#exampleTable2').DataTable({
               order: [[3, 'desc']],
               ordering: true,
               serverSide: false
            });

         }

      }
   }
} */
</script>
