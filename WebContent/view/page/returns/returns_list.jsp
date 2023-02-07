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
    <h2 class="returns_list_title">내 구매목록</h2>
    <hr>
    <div class="returns_list_target">
	    <table id="exampleTable" class="table table-bordered returns_list_table">
	    </table>
	    <br>
	    <input type="button" value="내 반품신청 목록보기" onclick="returns_mylist_move()" class="returns_list_btn">
    </div>
    <br>
    
<%@ include file="/view/component/footer.jsp" %>
</tag:main>

<script>
function returns_mylist_move(){
	location.href ="<%=request.getContextPath()%>/returnsMyList.do";
}

window.onload = function() {
	
	
   const request = new XMLHttpRequest();

   request.open("post", "/nikepro/returnsList.do", true);

   request.setRequestHeader("Content-Type", "application/json");

   request.send();

   request.onreadystatechange = function () {
      if (request.readyState === 4 && request.status === 200) {
         let target = document.getElementById("exampleTable");
         let data = request.response;

         if (data === "로그인을 해주세요.") {
            // alert(data);
            swal('로그인을 해주세요', "회원전용 게시판입니다", 'warning');
            location.href = "/nikepro/SnsMain.do"; //로그인페이지로

         } else if (data === "구매 내역이 없습니다.") {
            alert(data);
            location.href = "/nikepro/SnsMain.do"; //메인페이지로

         } else {
            let str = JSON.parse(data);
            let code = "";
			
            code += "<thead><tr><td>카트번호</td><td>상품코드</td><td>상품명</td><td>가격</td><td>결제일</td></tr></thead>";
            code += '<tbody>';

            for (index in str) {
               code += "<tr><td>" + str[index].cart_no + "</td>";
               code += "<td>" + str[index].prod_id + "</td>";
               code += "<td>" + str[index].prod_name + "</td>";
               code += "<td>" + str[index].prod_price + "</td>";
               code += "<td>" + str[index].pay_date + "&nbsp&nbsp;";
               
               if (str[index].cart_no.substr(0,1) === "U") {
	               code += "<a href= '/nikepro/reviewInsert.do?cart_no=" + str[index].cart_no +"'><input type='button' class='returns_list_table_btn' value='리뷰쓰기'></a>";
	               code += "<input type='button' class='returns_list_table_btn_n' value='반품불가'";
	               code += 'onclick="alert(' + "'반품 불가 상품입니다.'" + ')"></td></tr>';
	               
               } else {
	               code += "<a href= '/nikepro/reviewInsert.do?cart_no=" + str[index].cart_no +"'><input type='button' class='returns_list_table_btn' value='리뷰쓰기'>";
	               code += "<a href= '/nikepro/returnsInsert.do?cart_no=" + str[index].cart_no +"'><input type='button' class='returns_list_table_btn_y' value='반품하기'></td></tr>";
	               
               }
            }

            code += '</tbody>';
            target.innerHTML = code;

            $('#exampleTable').DataTable({
               order: [[4, 'desc']],
               ordering: true,
               serverSide: false,
               searching: false,
               paging: true,
               pageLength: 5,
           	   lengthChange: false,
           	   info: false,
	           	"language": {
	                "emptyTable" : "구매목록이 없습니다."
	            }
            });

         }

      }
   }
}

</script>
