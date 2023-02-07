<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="kr.or.ddit.vo.UsedProdVO"%>
<%@page import="kr.or.ddit.vo.SalesRequestVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/headMeta/headMain.jsp" %>
<title>ONUM_Detail</title>
</head>
<body>
<%@include file="/view/component/header.jsp" %>
<% 
	MemberVO member = (MemberVO)session.getAttribute("member");
	String memId ="";
	if(member == null){		// 비회원일 경우
		memId = "비회원";
	}else{
		memId = member.getMem_id();	// 회원일 경우 			
	}

	
	SalesRequestVO reqvo = (SalesRequestVO)request.getAttribute("reqvo");
	UsedProdVO uvo = (UsedProdVO)request.getAttribute("uvo");
%>
<header>
	<div class="onum-main-header__menu">		
	<%	
	if(!memId.equals("ADMIN")){
	%>
		<a href="<%=request.getContextPath() %>/ONUM/myPage.do">MyPage</a>
	<%}else{ %>
		<a href="<%=request.getContextPath() %>/view/page/ONUM/ReqList.jsp">판매요청관리</a>	
	<%} %>		
		
	</div>
</header>
<main>
<div class="onum-main">
<div class="onum-detail-container">
	<table class="onum-img-table">
	<tr>
		<td>
		<img src="/nikepro/images/usedprod/<%=reqvo.getReq_photo()%>">
		</td>
		<td>
		<img src="/nikepro/images/usedprod/<%=reqvo.getReq_photo()%>">
		</td>
	</tr>
	<tr>
		<td>
		<img src="/nikepro/images/usedprod/<%=reqvo.getReq_photo()%>">
		</td>
		<td>
		<img src="/nikepro/images/usedprod/<%=reqvo.getReq_photo()%>">
		</td>
	</tr>
	</table>
		<div class = "onum-detail-contents">
		<div class="onum-detail-conctents__text">
			<span><%=reqvo.getOrigin_name() %></span>
				<% 
				String amount = String.valueOf(reqvo.getReq_price());
				amount = amount.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
				%>
			<span><%=amount %> 원</span>
			
			<%
					String star ="";
					switch((String)uvo.getU_prod_quality()){
						case "1": star = "★"; break;
						case "2": star = "★★"; break;
						case "3": star = "★★★"; break;
						case "4": star = "★★★★"; break;
						case "5": star = "★★★★★"; break;
					}

				%>
			
			
			
			
			<span><%=star %></span>
			<div><%=reqvo.getReq_detail() %></div>
			<span>판매자 : <%=reqvo.getMem_id() %></span>
		</div>
			<input type="button" class="onumBuyBtn" id="onumBuyBtn" value="Buy <%=amount %> 원">
<!-- 테이블 자리 -->
<br>
<hr>
<br>
<br>
<br>
<br>

<!--
<table table id="exampleTable" class="table table-bordered table-hover">

</table>
<div id="detail_review"></div>
<br>
<br>
--!>
<!-- 테이블 자리 -->
<table table id="exampleTable2" class="table table-bordered table-hover">

</table>
<div id="detail_qna"></div>
	</div>
</div>
</div>
</main>



<!----------------------------- 장바구니 모달  ------------------------------->
<div class="modal" id="cartModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="cartModal-header">
        <h4>장바구니 추가 완료</h4>
        <button type="button" class="close" onclick="proc1()">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="cartModal-body">
       <form id="wform" class="cartModal-body__content">
         <div class="cartModal-body__content__column">
         <img src="/nikepro/images/usedprod/<%=reqvo.getReq_photo()%>" alt="/nikepro/images/usedprod/<%=reqvo.getReq_photo()%>">	
         </div>    
         <div class="cartModal-body__content__column">
              <p><%=reqvo.getOrigin_name() %></p>
              <p>중고상품 <%=reqvo.getReq_no() %></p>
              <p><%=amount %> 원</p>
         </div>    
        </form>
      </div>
      <!-- Modal footer -->
      <div class="cartModal-footer">
      	<button class="onumBuyBtn ModalCartBtn" onclick="location.href='selectAllCart.do?mem_id=<%=memId %>'" >장바구니</button>
        <button type="button" class="onumBuyBtn ModalCloseBtn" onclick="proc1()">Close</button>
      </div>
    </div>
  </div>
</div>

<!----------------------------- 끝  ------------------------------->












<script>
let req_no = "<%=reqvo.getReq_no()%>";
let mem_id = "<%=memId%>";
let req_name = "<%=reqvo.getOrigin_name()%>";
let prod_price = "<%=reqvo.getReq_price() %>";




window.onload = function() {
    
    
	   const request = new XMLHttpRequest();

	   request.open("post", "/nikepro/ReviewList_prod.do", true);

	   request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	   request.send("req_no=" + req_no);

	   request.onreadystatechange = function () {
	      if (request.readyState === 4 && request.status === 200) {
	         let target = document.getElementById("exampleTable");
	         let data = request.response;
	        
	            let str = JSON.parse(data);
	            let code = "";
	            
	            code += "<thead><tr class='returns_list_tr'><td>Review</td></tr></thead>";
	            code += '<tbody>';

	            for (let i = 0; i < Object.keys(str).length; i++) {
	            	
	            	map_review.set(i, str[i].review_no);
	            	
	               code += "<tr class='returns_list_tr'><td class='returns_list_td'>"; 
	               code += '<a href= "#none" onclick="details_review(' + i + ')">' + str[i].prod_name + "</a></td></tr>";
	               /* code += "<td class='returns_list_td'>" + str[index].prod_id + "</td>";
	               code += "<td class='returns_list_td'>" + str[index].prod_name + "</td></tr>"; */
	            }

	            code += '</tbody>';
	            target.innerHTML = code;

	            $('#exampleTable').DataTable({
	               order: [[0, 'desc']], //숫자는 0,1,2 (td 수에 맞게)
	               ordering: true,
	               serverSide: false,
	               searching: false,
	               paging: false,
	               info: false,
	               "language": {
	                    "emptyTable" : "현재 리뷰 없음"
	                }
	            });
	      }
	   }
	}
	
//let fncMap = {}; //동적 함수 저장할 곳
//let test = "";

//let test1 = "";
//let arr = [];
let map_qna = new Map();
let map_review = new Map();

function details_review(data) {
	alert(map_review.get(data));

	//alert(fncMap.index);
	//target.innerHTML = fncMap.index;
	
	const request = new XMLHttpRequest();

    request.open("post", "/nikepro/ReviewDetail_prod.do", true);

    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    
    request.send("review_no=" + map_review.get(data));
    
    request.onreadystatechange = function () {
    	if (request.readyState === 4 && request.status === 200) {
    		let target = document.getElementById("detail_review");
    		let data = request.response;
    		let str = JSON.parse(data);
    		let code = "";
    		
    		code += '<h3>' + str.review_content + '</h3>';
    		
    		target.innerHTML = code;
    	}
    	
    }
	
}

function details_qna(data) {
    //alert(map_qna.get(data));

    //alert(fncMap.index);
    //target.innerHTML = fncMap.index;
    
    const request = new XMLHttpRequest();

    request.open("post", "/nikepro/QnaDetail.do", true);

    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    
    request.send("qna_no=" + map_qna.get(data));
    
    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            let target = document.getElementById("detail_qna");
            let data = request.response;
            let str = JSON.parse(data);
            let code = "";
            
            code += '<h3 class="details_qna_h3">' + str.qna_content + '</h3>';
            
            target.innerHTML = code;
        }
        
    }
    
}




window.addEventListener('DOMContentLoaded', function() {
	
    const request = new XMLHttpRequest();

    request.open("post", "/nikepro/QnaList_prod.do", true);

    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    request.send("req_no=" + req_no);

    request.onreadystatechange = function () {
       if (request.readyState === 4 && request.status === 200) {
          let target = document.getElementById("exampleTable2");
          let data = request.response;
       
             let str = JSON.parse(data);
             let code = "";

             code += "<thead><tr class='returns_list_tr'><td>QnA</td></tr></thead>";
             code += '<tbody>';

             for (let i = 0; i < Object.keys(str).length; i++) { //index는 사용할 수 없다
            	 //arr.push(str[index].qna_no);
            	 
            	 map_qna.set(i, str[i].qna_no);
            	 //alert(map.get(i));
            	 
                code += "<tr class='returns_list_tr'><td class='returns_list_td'>";
                code += '<a href= "#none" onclick="details_qna(' + i + ')">';
                code += str[i].qna_title + "</td></tr>";
                /* code += "<td class='returns_list_td'>" + str[index].prod_id + "</td>";
                code += "<td class='returns_list_td'>" + str[index].prod_name + "</td></tr>"; */
             
             }
             
             code += '</tbody>';
             target.innerHTML = code;
             
             ///////////////////////////////////

             ///////////////////////////////////
             
             $('#exampleTable2').DataTable({
                order: [[0, 'desc']], //숫자는 0,1,2 (td 수에 맞게)
                ordering: true,
                serverSide: false,
                searching: false,
                paging: false,
                info : false,
                "language": {
                	"emptyTable" : "문의사항 없음"
                }
             });


                 
    ////////////////////////////////////////////////////
    ////////////////////////////////////////////////////
    
       }
    }
});



//detail('+ str[index].qna_no +');
    


$('#onumBuyBtn').on('click',function(){

	$.ajax({
		url : "/nikepro/insertCart.do",
		type : "get",
		data : {"prod_id" : req_no, "mem_id" : mem_id, "prod_name" : req_name, 
				"prod_price" : prod_price},
		success : function(res){				
			if(res.flag == "성공"){
				$('#cartModal').show();
// 				setTimeout(function() { 
// 					 $('#cartModal').hide();	
// 				}, 7000);
				
			}else{
				location.href="<%=request.getContextPath()%>/login.do";
			}
		},
		error : function(xhr){
			alert("상태" + xhr.status);
		},
		dataType : "json"
		
	})	//ajax 종료 자리
	
})	//btnCart 종료 자리



// 모달 닫기 
proc1=()=>{
	$('#cartModal').hide();
}
</script>




</body>
</html>