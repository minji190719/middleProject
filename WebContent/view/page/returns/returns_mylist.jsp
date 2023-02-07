<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<head>
<title>Q&A Main</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.11.4/r-2.2.9/datatables.min.css"/>
<style type="text/css">
    #target table td {
        border: 1px solid black;
    }
</style>


</head>

<tag:main>
<jsp:include page="/view/component/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">
  
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>
    <br><br><br><br>
	<h2 class="returns_mylist_title">내 반품요청목록</h2>
    <hr>
    <div class="returns_mylist_target">
	    <table id="exampleTable" class="table table-bordered returns_mylist_table">
	    </table>
	   	<br>
	    <input type="button" value="구매목록으로 돌아가기" onclick="returns_list_move()" class="returns_mylist_btn">
    </div>
    <br>
    
<%@ include file="/view/component/footer.jsp" %>
</tag:main>

<script>

function returns_list_move(){
	location.href ="<%=request.getContextPath()%>/returnsList.do";
}

window.onload = function() {
    
   const request = new XMLHttpRequest();

   request.open("post", "/nikepro/returnsMyList.do", true);

   request.setRequestHeader("Content-Type", "application/json");

   request.send();

   request.onreadystatechange = function () {
      if (request.readyState === 4 && request.status === 200) {
         let target = document.getElementById("exampleTable");
         let data = request.response;

         if (data === "로그인을 해주세요.") {
            alert(data);
            location.href = "/nikepro/SnsMain.do";

         } else if (data === "반품 신청 내역이 없습니다.") {
            alert(data);
            location.href = "/nikepro/SnsMain.do";

         } else {
            let str = JSON.parse(data);
            let code = "";

            code += "<thead><tr><td>신청번호</td><td>제목</td><td>작성자</td><td>상품명</td><td>결제일</td><td>작성일</td></tr></thead>";
            code += '<tbody>';

            for (index in str) {
               code += "<tr><td>" + str[index].returns_no + "</td>";
               code += "<td><a href='/nikepro/returnsDetail.do?returns_no=" + str[index].returns_no + "'>" + str[index].returns_title + "</a></td>";
               code += "<td>" + str[index].mem_id + "</td>";
               code += "<td>" + str[index].prod_name + "</td>";
               code += "<td>" + str[index].pay_date + "</td>";
               code += "<td>" + str[index].returns_date + "</td>"; 
               //추가로 필요한건 상품이름, 결제일. => 카트번호로 가져오기 
            }

            code += '</tbody>';
            target.innerHTML = code;

            $('#exampleTable').DataTable({
               order: [[3, 'desc']],
               ordering: true,
               serverSide: false,
               searching: false,
               paging: true,
               pageLength: 5,
           	   lengthChange: false,
           	   info: false,
	           	"language": {
	                "emptyTable" : "작성한 반품 요청이 없습니다."
	            }
            });

         }

      }
   }
}

</script>
