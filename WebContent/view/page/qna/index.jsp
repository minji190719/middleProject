<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<head>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.11.4/r-2.2.9/datatables.min.css"/>
<script src="https://kit.fontawesome.com/957fb022c5.js" crossorigin="anonymous"></script>
</head>

<tag:main>
<jsp:include page="/view/component/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>

<%@ include file="/view/page/qna/notice_searchForm.jsp" %>

<div class="notice_index_quick_support">
	<h3>빠른&nbsp;지원</h3>
	<p>클릭 한 번으로 자주 묻는 질문에 대한 답변을 확인할 수 있습니다.</p>
	<hr>
	<table table id="exampleTable" class="table table-bordered">  
	</table>
</div>

<br><br><br>
<div class="notice_index_notice">
	<h3><a href="/nikepro/noticeList.do">공지사항</a></h3>
	<hr>
</div>

<br><br><br>
<div class="notice_index_inquire_head">
	<h3>문의하기</h3>
	<hr>
</div>


<div class="notice_index_inquire_content">
    <ul>
       
        <li><i class="fa-solid fa-mobile-screen fa-4x"></i></li><br>
        <li><b>제품 및 주문</b></li>
        <li>080-022-0182</li>
        <li>09:00~20:00</li>
        <li>월요일~일요일</li>
    </ul>
    <ul>
        <li><i class="fa-solid fa-mobile-screen fa-4x"></i></li><br>
        <li><b>A/S서비스</b></li>
        <li>080-022-0182</li>
        <li>09:00~12:00, 13:00~18:00</li>
        <li>월요일~금요일(공휴일 제외)</li>
    </ul>
    <ul>
        <li><i class="fa-solid fa-location-dot fa-4x"></i></li><br>
        <li><b>매장 찾기</b></li>
        <li>가장 가까운 매장 찾기</li>
    </ul>
</div>
<br>
<br>

<%@ include file="/view/component/footer.jsp" %>
</tag:main>

<script>
window.onload = function() {
	
	const request = new XMLHttpRequest();
	
	request.open("post", "/nikepro/noticeSearchList.do", true);
	
	request.setRequestHeader("Content-Type", "application/json");
	
	request.send();
	
	request.onreadystatechange = function () {
	    if (request.readyState === 4 && request.status === 200) {
	        let data = request.response;
	        let str = JSON.parse(data);
	        let target = document.getElementById("exampleTable");
	        let code = "";
	
	        
	        code += "<thead><tr class='returns_list_tr'><td>No.</td><td>FAQ (Frequently Asked Questions)</td></tr></thead>";
            code += '<tbody>';
	       	let num = 0;
	       	
	       	for (index in str) {
	       		if(index <= 13){	       			
		       		code += "<tr class='returns_list_tr'><td class='returns_list_td'>" + str[index].notice_no + "</td>";
	                code += "<td class='returns_list_td'><a href='/nikepro/noticeDetail.do?notice_no=" 
	                    + str[index].notice_no + "' class='notice_index_a'>" + str[index].notice_title + "</a></td></tr>";
	       		}
             }
	        
	       	code += '</tbody>';
	
	        target.innerHTML = code;
	        
	        $('#exampleTable').DataTable({
                order: [[0, 'asc']], //숫자는 0,1,2 (td 수에 맞게x 정렬할 컬럼 번호)
                ordering: true,
                serverSide: false,
                searching: false,
                paging: false,
                info : false
               
             });
	    }
	}

}


/* 기존 자주묻는질문 const request = new XMLHttpRequest();

request.open("post", "/nikepro/questionCollection.do", true);

request.setRequestHeader("Content-Type", "application/json");

request.send();

request.onreadystatechange = function () {
    if (request.readyState === 4 && request.status === 200) {
        let data = request.response;
        let str = JSON.parse(data);

        let code = "";

        
        code += "<div style='display: flex; justify-content: center'>"
        code += "<ul>";
        let num = 0;
        
        for (index in str) {
            console.log(index);
            console.log("num은" + num);
            if ((num % 5) == 0) code += "</ul><ul>";
            if (num == 15) {
                num == 0;
            }
            if(index <= 13){                
            code += "<li><a href='/nikepro/view/page/qna/notice_detail/notice_detail" 
                + str[index].notice_no + ".jsp' class='notice_index_a'><b>" + str[index].notice_title + "</b></a></li><br>";
            num ++;
            }
        }
        
        code += "</ul>";
        code += "</div>";

        target.innerHTML = code;
    }
} */
</script>
