<%@page import="kr.or.ddit.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.11.4/r-2.2.9/datatables.min.css"/>
 <style type="text/css">
    #target table td {
        border: 1px solid black;
    }
</style> 
<!--   <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> -->
<!--   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->

<%-- <script src="<%=request.getContextPath()%>/js/jquery-3.6.1.min.js"></script> --%>
<!-- <script src="js/modal.js"></script> -->
<%@ include file="/WEB-INF/headMeta/headMain.jsp"%>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>

<style>
	.sizeBtn:checked{
		background: red;
		border: 1px solid green;
	}




</style>


<%
	ProdVO vo = (ProdVO)request.getAttribute("pvo");
	String price  = String.valueOf(vo.getProd_price());
	price = price.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");

%>

<script type="text/javascript">



/////////////////////////////////////////////////


let size = "";

$(function(){
	
	prod_id = "<%=vo.getProd_id() %>";
	prod_name = "<%=vo.getProd_name() %>";
	prod_price = "<%=vo.getProd_price() %>";
	mem_id = "test2"; //이건 왜 고정?
//클릭시 색변경

// 	var check = false;


/////////////////// 사이즈 선택 전 장바구니 버튼 비활성화
$('#cartBtnInshowProd').prop("disabled",true);

$('.sizeBtnInshowProd').on('click',function(){
	size = $(this).val().trim();
	
	$(this).prop("disabled",true);	
		
// 	if(!check){
// 		$(this).css("background","red");
//  		check =true;
// 	}else{
//  		check= false;
// 		$(this).css("background","#eeeeee");
// 	}
	
/////////////////// 장바구니 버튼 활성화
	console.log(size);
	if(size != ""){
		$('#cartBtnInshowProd').prop("disabled",false);
	}
})	

	

//장바구니 추가
$('#cartBtnInshowProd').on('click',function(){
		

	$.ajax({
		url : "/nikepro/insertCart.do",
		type : "get",
		data : {"prod_id" : prod_id, "size" : size, "mem_id" : mem_id, "prod_name" : prod_name, "prod_price" : prod_price},
		success : function(res){
			
			if(res.flag == "성공"){
				$('#cartModal').show();
				setTimeout(function() { 
// 					 $('#cartModal').modal('hide');	
					 $('#cartModal').hide();	
				}, 7000);
				
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


//위시리스트 추가
$('#wishBtnInshowProd').on('click',function(){
	$.ajax({
		url : "/nikepro/insertWish.do",
		type :"get",
		data :{"mem_id" : mem_id, "size" : size, "prod_id" : prod_id},
		success : function(res){
// 			alert(res.flag)
			if(res.flag="성공"){
			$('#wishModal').show();
			setTimeout(function() { 
//					 $('#cartModal').modal('hide');	
				 $('#wishModal').hide();	
			}, 5000);
			}else{//왜 여기로 안넘어오지??
			$('#wishModal').show();
			setTimeout(function() { 
//					 $('#cartModal').modal('hide');	
				 $('#wishModal').hide();	
			}, 5000);
				
			}
			
		},
		error : function(xhr){
			alert("상태" + xhr.status);
		},
		dataType : "json"
	})
})//btnWish 종료

})//function  종료 자리

</script>

</head>

<body>
<jsp:include page="/view/component/header.jsp"></jsp:include>
<!-- 사진출력 -->

<div class="onum-main">
<div class="onum-detail-container">

	<table class="onum-img-table">
	<tr>
		<td>
		<img src="/nikepro/images/prod/<%=vo.getProd_id()%>_1.png" alt="/nikepro/images/prod/<%=vo.getProd_id()%>">
		</td>
		<td>
		<%
		  if (vo.getProd_id().equals("sj_013") || vo.getProd_id().equals("sj_014")) {
	    %>
		<img src="/nikepro/images/prod/<%=vo.getProd_id()%>_2.gif" alt="/nikepro/images/prod/<%=vo.getProd_id()%>">
		<%
		  } else {
		%>
		<img src="/nikepro/images/prod/<%=vo.getProd_id()%>_2.png" alt="/nikepro/images/prod/<%=vo.getProd_id()%>">
		<%
		  }
		%> 
		</td>
	</tr>
	<tr>
		<td>
		<img src="/nikepro/images/prod/<%=vo.getProd_id()%>_3.png" alt="/nikepro/images/prod/<%=vo.getProd_id()%>">
		</td>
		<td>
		<img src="/nikepro/images/prod/<%=vo.getProd_id()%>_4.png" alt="/nikepro/images/prod/<%=vo.getProd_id()%>">
		</td>
	</tr>
	</table>


<%

// 	str1.charAt(str1.length() - 1)
	String gender="";

System.out.println(vo);
System.out.println(vo.getLprod_name());
	if ((vo.getLprod_name().charAt(vo.getLprod_name().length() - 1)) == 'M') {
		gender = "남성 ";
	} else {
		gender = "여성 ";
	}

	String lprodGu = "";
	
	if (vo.getLprod_name().substring(0, 2).equals("sh")) {
		lprodGu = "신발";
	} else if (vo.getLprod_name().substring(0, 1).equals("c")) {
		lprodGu = "의류";
	} else if (vo.getLprod_name().substring(0, 2).equals("ac")) {
		lprodGu = "용품";
	}
	
%>





<div class = "onum-detail-contents">
		<div id="inshowprod" class="onum-detail-conctents__text">
			<span><%=vo.getProd_name() %></span>
			<span><%=gender + lprodGu + vo.getProd_purpose()%></span>
			<span><%=price %> 원</span>
			<span><%=vo.getProd_content() %></span>
		</div>
<%-- 			<input type="button" class="onumBuyBtn" id="onumBuyBtn" value="Buy <%=price %> 원"> --%>

<%
if(vo.getLprod_gu().substring(0, 2).equals("sh")){
%>	

<!-- class="table table-bordered size table"	 -->
<table id="sizetable_prod" >

	<tr>
		<th colspan="3">사이즈 선택</th>
		<th colspan="2"><a href="https://www.nike.com/kr/size-fit/mens-footwear">사이즈 가이드</a></th>
	</tr>
	<tr>
		<th><input type ="button" class="sizeBtnInshowProd" value ="220" ></th>
		<th><input type ="button" class="sizeBtnInshowProd" value ="230" ></th>
		<th><input type ="button" class="sizeBtnInshowProd" value ="240" ></th>
		<th><input type ="button" class="sizeBtnInshowProd" value ="250" ></th>
		<th><input type ="button" class="sizeBtnInshowProd" value ="260" ></th>
	</tr>
	<tr>
		<th><input type ="button" class="sizeBtnInshowProd" value ="270" ></th>
		<th><input type ="button" class="sizeBtnInshowProd" value ="280" ></th>
		<th><input type ="button" class="sizeBtnInshowProd" value ="290" ></th>
		<th><input type ="button" class="sizeBtnInshowProd" value ="300" ></th>
		<th><input type ="button" class="sizeBtnInshowProd" value ="310" ></th>
	</tr>
	<tr>
	</tr>

</table>	
	
<%	
}else if(vo.getLprod_gu().substring(0, 2).equals("cl")){
%>
<table id="sizetable_prod" >
	<tr>
		<th colspan="2">사이즈 선택</th>
		<th colspan="1">사이즈 가이드</th>
	</tr>
	<tr>
		<th><input type ="button" class="sizeBtnInshowProd" value ="S" ></th>
		<th><input type ="button" class="sizeBtnInshowProd" value ="M" ></th>
		<th><input type ="button" class="sizeBtnInshowProd" value ="L" ></th>
	</tr>

</table>

<%
}else{
%>
<table  id="sizetable_prod">
	<tr>
		<th colspan="2">사이즈 선택</th>
		<th colspan="1">사이즈 가이드</th>
	</tr>
	<tr>
		<th><input type ="button" class="sizeBtnInshowProd" value ="S" ></th>
		<th><input type ="button" class="sizeBtnInshowProd" value ="M" ></th>
		<th><input type ="button" class="sizeBtnInshowProd" value ="L" ></th>
	</tr>

</table>

<%	
}
%>

<input type="button" id ="cartBtnInshowProd" class="cartBtn" value="장바구니">	
<input type="button" id ="wishBtnInshowProd" class="wishBtn" value="위시리스트">	
<br>

<a id="showDetailInShowProd"  data-toggle="modal" data-target="#prodDetail">상세정보 보기</a>
<br><br>
<!-- <button  class="btn btn-success" id="showDetailInShowProd" type ="button" data-toggle="modal" data-target="#prodDetail">상세정보 보기</button> -->





<br>
<table  id="exampleTable_review" class="table table-bordered in showProd">
</table>
<div id="detail_review" class="detail_qna_container">리뷰 내용이 여기에 표시됩니다.</div>
<hr>
<!-- 테이블 자리 -->
<input type="button" id="insertBtn_qna" value="문의하기" onclick="insertQna()" class="insertBtn_qna">
<br>
<table  id="exampleTable_qna" class="table table-bordered in showProd">

</table>
<br>
<div id="detail_qna" class="detail_qna_container">Q&A 선택시 여기에 내용이 표시됩니다.</div>
<!-- <div id="detail_qna" class="detail_qna_container">Q&A 선택시 여기에 내용이 표시됩니다.</div> -->

<!-- onum-detail-container 끝 -->
</div>	


	</div> <!-- onum-detail-contents -->
	
<!-- onum-main 끝 -->
</div>



<!----------------------------- 내가 안만든 장바구니 모달  ------------------------------->
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
          <img src="/nikepro/images/prod/<%=vo.getProd_id()%>_1.png" alt="/nikepro/images/prod/<%=vo.getProd_id()%>">	
       </div>       
       <div class="cartModal-body__content__column">
              <p><%=vo.getProd_name() %></p>
              <p><%=vo.getProd_purpose() %></p>
              <p><%=price %>원</p>
        </div>
        </form>
      </div>
      <!-- Modal footer -->
      <div class="cartModal-footer">
      	<button class="onumBuyBtn ModalCartBtn" onclick="location.href='selectAllCart.do?mem_id=test2'" >장바구니</button>
        <button type="button" class="onumBuyBtn ModalCloseBtn" onclick="proc1()">Close</button>
      </div>
    </div>
  </div>
</div>

<!----------------------------- 끝  ------------------------------->


<!----------------------------- 내가 안만든 위시리스트 모달  ------------------------------->
<div class="modal" id="wishModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="cartModal-header">
        <h4>위시리스트 추가 완료</h4>
        <button type="button" class="close" onclick="proc2()">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="cartModal-body">
       <form id="wform" class="cartModal-body__content">
       <div class="cartModal-body__content__column">
          <img src="/nikepro/images/prod/<%=vo.getProd_id()%>_1.png" alt="/nikepro/images/prod/<%=vo.getProd_id()%>">	
       </div>       
       <div class="cartModal-body__content__column">
              <p><%=vo.getProd_name() %></p>
              <p><%=vo.getProd_purpose() %></p>
              <p><%=price %>원</p>
        </div>
        </form>
      </div>
      <!-- Modal footer -->
      <div class="cartModal-footer">
      	<button class="onumBuyBtn ModalCartBtn" onclick="location.href='selectAllWish.do'">위시리스트</button>
        <button type="button" class="onumBuyBtn ModalCloseBtn" onclick="proc2()">Close</button>
      </div>
    </div>
  </div>
</div>

<!----------------------------- 끝  ------------------------------->


<!-- 상세설명 모달 -->
<div class="modal" id="prodDetail">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">제품 상세 설명</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       <form id="wform">
              <div>
              <%=vo.getProd_detail() %>
              </div>
          </form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>






<!-- 장바구니 모달  -->
<!-- <div class="modal" id="cartModal"> -->
<!--   <div class="modal-dialog"> -->
<!--     <div class="modal-content"> -->

<!--       Modal Header -->
<!--       <div class="modal-header"> -->
<!--         <h4 class="modal-title">장바구니 추가 완료</h4> -->
<!--         <button type="button" class="close" onclick="proc1()">&times;</button> -->
<!--       </div> -->

<!--       Modal body -->
<!--       <div class="modal-body"> -->
<!--        <form id="wform"> -->
<%--          <img src="/nikepro/images/prod/<%=vo.getProd_id()%>.png" alt="/nikepro/images/prod/<%=vo.getProd_id()%>">	 --%>
<%--               <p><%=vo.getProd_name() %></p> --%>
<%--               <p><%=vo.getProd_purpose() %></p> --%>
<%--               <p><%=price %></p> --%>
<!--           </form> -->
<!--       </div> -->
<!--       Modal footer -->
<!--       <div class="modal-footer"> -->
<!--       	<button  onclick="location.href='selectAllCart.do?mem_id=test2'" >장바구니 가기</button> -->
<!--         <button type="button" class="btn btn-danger" onclick="proc1()">Close</button> -->
<!--       </div> -->
<!--     </div> -->
<!--   </div> -->
<!-- </div> -->




<!-- 위시리스트 모달 (위시리스트 담기 성공시) -->
<!-- <div class="modal" id="wishModal"> -->
<!--   <div class="modal-dialog"> -->
<!--     <div class="modal-content"> -->

<!--       Modal Header -->
<!--       <div class="modal-header"> -->
<!--         <h4 class="modal-title">위시리스트에 추가되었습니다</h4> -->
<!--         <button type="button" class="close" onclick="proc2()">&times;</button> -->
<!--       </div> -->

<!--       Modal body -->
<!--       <div class="modal-body"> -->
<!--        <form id="wform"> -->
<%--        		  <img src="/nikepro/images/prod/<%=vo.getProd_id()%>.png" alt="/nikepro/images/prod/<%=vo.getProd_id()%>">	 --%>
<%--               <p><%=vo.getProd_name() %></p> --%>
<%--               <p><%=vo.getProd_purpose() %></p> --%>
<%--               <p><%=price %></p> --%>
<!--           </form> -->
<!--       </div> -->
<!--       Modal footer -->
<!--       <div class="modal-footer"> -->
<!--       	<button onclick="location.href='selectAllWish.do'">위시리스트 보기</button> -->
<!--         <button type="button" class="btn btn-danger" onclick="proc2()">Close</button> -->
<!--       </div> -->
<!--     </div> -->
<!--   </div> -->
<!-- </div> -->

<!-- <!-- 위시리스트 모달 (위시리스트 담기 성공시) --> -->
<!-- <div class="modal" id="wishModal2"> -->
<!--   <div class="modal-dialog"> -->
<!--     <div class="modal-content"> -->

<!--       Modal Header -->
<!--       <div class="modal-header"> -->
<!--         <h4 class="modal-title">Modal Heading</h4> -->
<!--         <button type="button" class="close" onclick="proc2()">&times;</button> -->
<!--       </div> -->

<!--       Modal body -->
<!--       <div class="modal-body"> -->
<!--        <form id="wform"> -->
<!--               <p> -->
<!--      			이미 위시리스트에 담아두셨네요. -->
<!--      			과연 안목이 정말! -->
<!--      		</p> -->
<!--           </form> -->
<!--       </div> -->
<!--       Modal footer -->
<!--       <div class="modal-footer"> -->
<!--       	<button onclick="location.href='selectAllWish.do'">위시리스트 보기</button> -->
<!--         <button type="button" class="btn btn-danger" onclick="proc2()">Close</button> -->
<!--       </div> -->
<!--     </div> -->
<!--   </div> -->
<!-- </div> -->















<script>

prod_id = "<%=vo.getProd_id() %>";
prod_name = "<%=vo.getProd_name() %>";
prod_price = "<%=vo.getProd_price() %>";
mem_id = "test2";

function insertQna () {
	
	const request = new XMLHttpRequest();

    request.open("post", "/nikepro/QnaInsert.do", true);

    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    request.send("req_no=" + prod_id);
    
    request.onreadystatechange = function () {
    	if (request.readyState === 4 && request.status === 200) {
    		let data = request.response;
    		
    		if (data === "로그인을 해주세요." ) {
    			alert(data);
    		} else {
    			location.href= "/nikepro/QnaInsert_prod.do?prod_id=" + prod_id;
    		}
    		
    	}
    }
}



window.onload = function() {
    
    
    const request = new XMLHttpRequest();

    request.open("post", "/nikepro/ReviewList_prod.do", true);

    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    request.send("req_no=" + prod_id);

    request.onreadystatechange = function () {
       if (request.readyState === 4 && request.status === 200) {
          let target = document.getElementById("exampleTable_review");
          let data = request.response;
         
             let str = JSON.parse(data);
             let code = "";
             
             code += "<thead><tr class='returns_list_tr'><td>Review</td></tr></thead>";
             code += '<tbody>';

             for (let i = 0; i < Object.keys(str).length; i++) {
                 
                 map_review.set(i, str[i].review_no);
                 
                code += "<tr class='returns_list_tr'><td class='returns_list_td'>"; 
                code += '<a href= "#none" onclick="details_review(' + i + ')">' + str[i].review_title + "</a></td></tr>";
                /* code += "<td class='returns_list_td'>" + str[index].prod_id + "</td>";
                code += "<td class='returns_list_td'>" + str[index].prod_name + "</td></tr>"; */
             }

             code += '</tbody>';
             target.innerHTML = code;

             $('#exampleTable_review').DataTable({
                order: [[0, 'desc']], //숫자는 0,1,2 (td 수에 맞게)
                ordering: true,
                serverSide: false,
                searching: false,
                paging: true,
                pageLength: 5,
                lengthChange: false,
                info: false,
                "language": {
                     "emptyTable" : "현재 상품 리뷰가 없습니다."
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
 //alert(map_review.get(data));

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
         
         code += '<h3>' + str.review_rating + '</h3><br>';
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
         
         /* code += '<h3 class="details_qna_h3">' + str.qna_content + '</h3>'; */
         code += '<h3>' + str.qna_content + '</h3>';
         
         target.innerHTML = code;
     }
     
 }
 
}




window.addEventListener('DOMContentLoaded', function() {
 
 const request = new XMLHttpRequest();

 request.open("post", "/nikepro/QnaList_prod.do", true);

 request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

 request.send("req_no=" + prod_id);

 request.onreadystatechange = function () {
    if (request.readyState === 4 && request.status === 200) {
       let target = document.getElementById("exampleTable_qna");
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
          
          $('#exampleTable_qna').DataTable({
             order: [[0, 'desc']], //숫자는 0,1,2 (td 수에 맞게)
             ordering: true,
             serverSide: false,
             searching: false,
             paging: true,
             pageLength: 5,
             lengthChange: false,
             info: false,
             "language": {
                 "emptyTable" : "현재 상품 문의사항이 없습니다."
             }
          });


              
 ////////////////////////////////////////////////////
 ////////////////////////////////////////////////////
 
    }
 }
});



proc1=()=>{
	$('#cartModal').hide();
}
proc2=()=>{
	$('#wishModal').hide();
}


var div2 = document.getElementsByClassName("sizeBtnInshowProd");

function handleClick(event) {
  console.log(event.target);
  // console.log(this);
  // 콘솔창을 보면 둘다 동일한 값이 나온다

  console.log(event.target.classList);

  if (event.target.classList[1] === "clicked") {
    event.target.classList.remove("clicked");
  } else {
    for (var i = 0; i < div2.length; i++) {
      div2[i].classList.remove("clicked");
    }

    event.target.classList.add("clicked");
  }
}

function init() {
  for (var i = 0; i < div2.length; i++) {
    div2[i].addEventListener("click", handleClick);
  }
}

init();




</script>



<%@ include file="/view/component/footer.jsp"%>
</body>
</html>