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
    <h2 class="return_update_title">반품 요청서 수정하기</h2>
    <hr>
    <div id="target" class="returns_update_target"></div>
    <br>
    <input type="button" value="수정완료" id="returns_update_btn" class="returns_update_btn">
    
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
            code +=  '<table id="exampleTable" class="table table-bordered returns_update_listContainer">';
            
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
            code += '<br><br>';
            code += '<h3>기존에 작성한 반품신청서를 수정합니다.</h3><br>';
            code += '<table class="returns_update_inputContainer">';
            code += '<tr><td>사유</td><td>';
            code += '<select name=returns_title" required id="titleBox">'
            code += '<option value="" disabled selected>===============변경 사유를 선택하세요==============</option>'
            code += '<option value="구매 의사 취소">구매 의사 취소</option>'
            code += '<option value="색상 및 사이즈 변경">색상 및 사이즈 변경</option>'
            code += '<option value="다른 상품 잘못 주문">다른 상품 잘못 주문</option>'
            code += '<option value="상품 정보 상이">상품 정보 상이</option>'
            code += '<option value="기타">기타</option>'
            code += '</select></td></tr>'
            
            code += '<tr><td style="word-wrap:break-word">내용</td>';
            code += '<td><textarea id="contentBox">' + str.returns_content + '</textarea></td></tr>';
            code += '</table>'
            
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

document.getElementById("returns_update_btn").onclick = function () {
   let returns_title = document.getElementById("titleBox").value;
   let returns_content = document.getElementById("contentBox").value;
   
	if(returns_title==""){
		alert("변경사유를 선택하세요.");
		return false;
		
	}else if(returns_content==""){
		alert("내용을 입력하세요.");
		return false;
	}

	
   const request = new XMLHttpRequest();

   request.open("post", "/nikepro/returnsUpdate.do", true);

   request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

   request.send("returns_no=" + returns_no + "&returns_title=" + returns_title + "&returns_content=" + returns_content);

   request.onreadystatechange = function () {
      if (request.readyState === 4 && request.status === 200) {
         let data = request.response;
    	  alert(data);
    	  location.href = "/nikepro/returnsMyList.do";
      }
   }
}


</script>
