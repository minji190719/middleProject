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
    <h1 class="qna_mylist_title">내 문의사항 작성 목록</h1>
    <hr>
    <div class="returns_mylist_target">
        <table id="exampleTable" class="table table-bordered returns_mylist_table">
        </table>
        <hr>
        <div id="detail_qna"></div>
        <hr>
        <input type="button" value="구매목록으로 가기" onclick="returns_list_move()" class="returns_mylist_btn">
    </div>
    <br>
    <br>
    
<%@ include file="/view/component/footer.jsp" %>
</tag:main>

<script>
function returns_list_move(){
    location.href ="<%=request.getContextPath()%>/returnsList.do";
}

let map_qna = new Map();
let number = "1";



function update_qna (data) {
    //alert("Q" + data);
    //제목,내용 선택하게해서 수정할건지, 모달창으로 만들건지
    let qna_no = "Q" + data;
	let update_content = prompt("수정할 내용을 입력하세요.");
	
	const request = new XMLHttpRequest();

    request.open("post", "/nikepro/QnaUpdate.do", true);

    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    
    request.send("qna_no=" + qna_no + "&data=" + update_content);
    
    request.onreadystatechange = function () {
    	request.onreadystatechange = function () {
    		let data = request.response;
    		alert(data);
    		location.href = "/nikepro/QnaMyList.do";
    	}
    }
}

function delete_qna (data) {
    //alert("Q" + data);
    //제목,내용 선택하게해서 수정할건지, 모달창으로 만들건지
    let qna_no = "Q" + data;
	let choice = confirm("정말 삭제하시겠습니까?");
	
	if (choice === false) {
		alert("삭제가 취소되었습니다.");
		
	} else {
		const request = new XMLHttpRequest();
	
	    request.open("post", "/nikepro/QnaDelete.do", true);
	
	    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	    
	    request.send("qna_no=" + qna_no);
	    
	    request.onreadystatechange = function () {
	    	request.onreadystatechange = function () {
	    		let data = request.response;
	    		alert(data);
	    		location.href = "/nikepro/QnaMyList.do";
	    	}
	    }
		
	}
	 
}

function details_qna(data) {

	
     number = map_qna.get(data);	 
	
	 const request = new XMLHttpRequest();

	 request.open("post", "/nikepro/QnaDetail.do", true);

	 request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	 
	 request.send("qna_no=" + map_qna.get(data));
	 
	 request.onreadystatechange = function () {
		 request.onreadystatechange = function () {
	         let target = document.getElementById("detail_qna");
	         let datas = request.response;
	         let str = JSON.parse(datas);
	         let code = "";
	         number = str.qna_no;
	         
	         code += '<div class="qna_mylist_detail">' + str.qna_content + '</div><br>';

	         //Q56이 문자열+숫자형이라 데이터가 안넘어간다....... 그래서 문자열부분 자르고 나중에 다시 붙여줘야함
	         code += '<div><input type="button" value="수정하기" onclick="update_qna(' + str.qna_no.substring(1) + ')">';
	         code += '<input type="button" value="삭제하기" onclick="delete_qna(' + str.qna_no.substring(1) + ')"></div>';
	         target.innerHTML = code;
	         
	     }
	     
	 }
	 
	}

window.onload = function() {
    
   const request = new XMLHttpRequest();

   request.open("post", "/nikepro/QnaMyList.do", true);

   request.setRequestHeader("Content-Type", "application/json");

   request.send();

   request.onreadystatechange = function () {
      if (request.readyState === 4 && request.status === 200) {
         let target = document.getElementById("exampleTable");
         let data = request.response;

         if (data === "로그인을 해주세요.") {
            alert(data);
            location.href = "/nikepro/snsMain.do";

         } else if (data === "반품 신청 내역이 없습니다.") {
            alert(data);
            location.href = "/nikepro/snsMain.do";

         } else {
            let str = JSON.parse(data);
            let code = "";

            code += "<thead><tr><td>문의번호</td><td>제목</td><td>작성자</td><td>상품코드</td><td>작성일</td></tr></thead>";
            code += '<tbody>';

            for (let i = 0; i < Object.keys(str).length; i++) {
               map_qna.set(i, str[i].qna_no);
            	
               code += "<tr><td>" + str[i].qna_no + "</td>";
               code += "<td>";
               code += '<a href= "#none" onclick="details_qna(' + i + ')">';
               code += str[i].qna_title + "</a></td>";
               code += "<td>" + str[i].mem_id + "</td>";
               code += "<td>" + str[i].prod_id + "</td>";
               code += "<td>" + str[i].qna_date + "</td>";
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
                   "emptyTable" : "작성한 문의사항이 없습니다."
               }
            });

         }

      }
   }
}

</script>
