<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.vo.CartVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CART</title>

<script src="<%=request.getContextPath()%>/js/jquery-3.6.1.min.js"></script>

<%
	List<CartVO> clist = (List<CartVO>)request.getAttribute("list");
    String json = new Gson().toJson(clist);

%>

<script>

let json = <%=json %>;
// alert(json);

// for (index in json) {
// 	alert(json[index].prod_id);
// 	alert(json[index].cart_no);
// }

$(function(){
	/*  
	//결제 버튼 로직 참고
 	$('.payBtn').on('click',function(){

 		pay_total = $(this).val().trim();
 		
 		let jsonData = JSON.stringify(json);
 		
 		$.ajax({
 			url : "/nikepro/payment.do",
			type : "post",
			data : {"cart_json" : jsonData, "pay_total" :  pay_total},
			success : function(res){
				alert(res.flag);
				location.reload();
			},
			error : function(xhr){
				alert("상태" + xhr.status);
			},
			dataType : "json"
 		})
 		
 	})//payBtn 종료*/
	
	
	//삭제 버튼
	$('.delBtn').on('click',function(){
		
		cart_no1 = $(this).val().trim();
		
		$.ajax({
			url : "/nikepro/deleteCart.do",
			type : "post",
			data : {"cart_no" : cart_no1},
			success : function(res){
		
				location.reload();
			},
			error : function(xhr){
				alert("상태" + xhr.status);
			},
			dataType : "json"
		})//ajax종료
	})//delBtn종료
	
	//위시리스트 버튼
	$('.wishBtn').on('click',function(){
		
		cart_no2 = $(this).val().trim();
		
		$.ajax({
			url : "/nikepro/insertWish.do",
			type : "post",
			data : {"cart_no" : cart_no2},
			success : function(res){

				alert("해당 상품이 위시리스트로 이동하였습니다.")

				location.reload();
			},
			error : function(xhr){
				alert("상태" + xhr.status);
			},
			dataType : "json"
			
			
		})//ajax종료
		
	})//wishBtn종료
	
	$('.Qty').on('change',function(){
		
		Qty = $(this).val().trim();
		cart_no = $(this).attr("idx");
		
		$.ajax({
			url : "/nikepro/insertCart.do",
			type : "post",
			data : {"cart_qty" : Qty, "cart_no" : cart_no},
			success : function(res){
				location.reload();		
			},
			error : function(xhr){
				alert("상태" + xhr.status);
			},
			dataType : "json"
			
			
		})//ajax종료
		
	})
	
	
})//function



</script>
<%@ include file="/WEB-INF/headMeta/headMain.jsp"%>
</head>
<jsp:include page="/view/component/header.jsp"></jsp:include>
<body>
<div class="cartProd-container">

<!------------------- 장바구니  ------------------->
  <!---------------- 일반상품 ------------------>
  <div class="cartProd-column">
	<div class="cartProd-title">
		<h3>장바구니</h3>
	</div>
			
	<h3> 일반상품 </h3>
	<div class="cartProd-item__container__down">
		<%
			for(CartVO vo : clist){
				if(!vo.getProd_id().equals("used")){
		%>		
	 <div class="cartProd-item__container">
		<div class="cartProd-item__container__column">
					<a href="<%=request.getContextPath() %>/showProd.do?prod_id=<%=vo.getProd_id()%>">
					<img src="images/prod/<%=vo.getProd_id() %>_1.png" alt="images/prod/<%=vo.getProd_id() %>_1.png"></a>			
		</div>
		<div class="cartProd-item__container__column">
					<p><%=vo.getProd_name() %></p>
					<p>사이즈 <%=vo.getProd_size() %></p>
					<p>색상 <%=vo.getProd_color() %></p>
					수량
					<select class='Qty' idx='<%=vo.getCart_no()%>'>
					<option value='<%=vo.getCart_qty() %>' selected><%=vo.getCart_qty() %></option>
					<option value='1' >1</option>
					<option value='2' >2</option>
					<option value='3' >3</option>
					<option value='4' >4</option>
					<option value='5' >5</option>
					<option value='6' >6</option>
					<option value='7' >7</option>
					<option value='8' >8</option>
					<option value='9' >9</option>
					<option value='10'>10</option>
					</select>
					<br>
					<button class="wishBtn" value="<%=vo.getCart_no() %>"><i class="fa-regular fa-heart fa-lg"></i></button>
					<button class="delBtn" value="<%=vo.getCart_no() %>"><i class="fa-solid fa-trash-can fa-lg"></i></button>
		</div>
		<div class="cartProd-item__container__column">
				<% 
				String amount = String.valueOf(vo.getProd_price());
				amount = amount.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
				%>
					<p><%=amount %> 원</p>			
		</div>		
			
<!-- 			<div class="cartProd-item__container__row"> -->
	</div>
	<%		} // IF문 끝
		}// FOR 문 끝 %>
  </div>
  
  
  
  <!---------------- 중고상품 ------------------>
	<h3> 중고상품 </h3>
	<div class="cartProd-item__container__down">
		<%
			if(clist.isEmpty()){
		%>
			<span> 장바구니에 담긴 중고상품이 없습니다 </span>
		<% 
			}else{
		
			for(CartVO vo : clist){
				if(vo.getProd_id().equals("used")){
		%>		
	 <div class="cartProd-item__container">
		<div class="cartProd-item__container__column">
					<a href="<%=request.getContextPath() %>/showProd.do?prod_id=<%=vo.getProd_id()%>">
					<img src="/nikepro/images/usedprod/<%=vo.getProd_size() %>" alt="/images/usedprod/<%=vo.getProd_size() %>"></a>			
		</div>
		<div class="cartProd-item__container__column">
					<p><%=vo.getProd_name() %></p>
					<button class="wishBtn" value="<%=vo.getCart_no() %>"><i class="fa-regular fa-heart fa-lg"></i></button>
					<button class="delBtn" value="<%=vo.getCart_no() %>"><i class="fa-solid fa-trash-can fa-lg"></i></button>
		</div>
		<div class="cartProd-item__container__column">
				<% 
				String amount = String.valueOf(vo.getProd_price());
				amount = amount.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
				%>
					<p><%=amount %> 원</p>			
		</div>		
			
	</div>
	<%		
					} // IF문 끝
				}// FOR 문 끝 
			} // if 문 끝
	%>
  </div>
</div>
	
	 
	
	
	

	
<!------------------- 주문내역  ------------------->
	<div class="cartProd-column">
		<div class="cartProd-title">
			<h3>주문 내역</h3>
		</div>
		<div class="cartProd-order__content"> 
			<%
			int price=0;
			for(CartVO vo : clist){
				price += vo.getProd_price();
			}
			 
			String amount = String.valueOf(price);
			amount = amount.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
			
			%>
			
			<div class="cartProd-order__content__column">
			<span>상품 금액</span>
			<span>배송비</span>
			<span>총 할인</span>
			</div>
			<div class="cartProd-order__content__column">
			<span><%=amount %> 원</span>
			<span>무료</span>
			<span>0 원</span>
			</div>
			<div class="cartProd-order__content__column">
			<span>총 결제 금액 </span>
			</div>
			<div class="cartProd-order__content__column">
			<span><%=amount %> 원 </span>
			</div>
			<button class="payBtn onumBuyBtn" value ="<%=price %>" onClick="location.href='<%=request.getContextPath() %>/payPage.do'">주문결제</button>
		</div>
	</div> <!-- cartProd-column 끝 -->
	
	
<!----------------------- 진짜 끝 ----------------------->	
</div> <!--  cartProd-container 끝 -->




<%@ include file="/view/component/footer.jsp"%>
</body>
</html>