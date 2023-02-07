<%@page import="kr.or.ddit.prod.service.ProdServiceImpl"%>
<%@page import="kr.or.ddit.prod.service.IProdService"%>
<%@page import="kr.or.ddit.vo.ProdVO"%>
<%@page import="kr.or.ddit.vo.WishVO"%>
<%@page import="kr.or.ddit.vo.CartVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.1.min.js"></script>

<%
	List<WishVO> clist = (List<WishVO>)request.getAttribute("list");
%>
<script>

$(function(){
	
	//장바구니 추가버튼
	$('.cartBtninwish').on('click',function(){
		
		wish_no = $(this).val().trim();

		$.ajax({
			url : "/nikepro/wish/insertCart.do",
			type : "get",
			data : {"wish_no" : wish_no},
			success : function(res){
				location.reload();
			},
			error : function(xhr){
				alert("상태" + xhr.status);
			},
			dataType : "json"
			
		})	//ajax 종료 자리
		
	})	//btnCart 종료 자리

//삭제버튼
$('.deleteBtninwish').on('click',function(){
		
		wish_no = $(this).val().trim();
		
		$.ajax({
			url : "/nikepro/deleteWish.do",
			type : "post",
			data : {"wish_no" : wish_no},
			success : function(res){
		
				location.reload();
			},
			error : function(xhr){
				alert("상태" + xhr.status);
			},
			dataType : "json"
		})//ajax종료
	})//delBtn종료
	
	
	
	

//사이즈 선태 버큰
// $('#sizeBtn').on('click',function(){
	
// 	$('#wishModal').show();
	
// })//sizeBtn 종료

})//전체 function종료


</script>
</head>
<%@ include file="/WEB-INF/headMeta/headMain.jsp"%>
</head>
<jsp:include page="/view/component/header.jsp"></jsp:include>
<body>

<div class="wish-container">
<!----------------------- 위시리스트----------------------------->
<!-- ---------------------일반상품------------------------------->
<div >
<h3> 일반상품 </h3>
<div class="onum-main-container">
<%
		if(clist ==null || clist.size()==0){
%>

<h4>위시리스트에 추가한 상품이 없습니다.</h4>

<%		}else{
	for(WishVO vo : clist){
		if(!vo.getProd_id().equals("used")){
%>

<div class="onum-main-item">
<div class="onum-main-item__img inwishimg" idx=<%=vo.getWish_no()%>><!-- 상품 각각에 대한 div -->
<a href="<%=request.getContextPath() %>/showProd.do?prod_id=<%=vo.getProd_id()%>">
	<img src="/nikepro/images/prod/<%=vo.getProd_id() %>_1.png" alt="/nikepro/images/prod/<%=vo.getProd_id() %>_1.png"></a>
</div>

<%
		IProdService service = ProdServiceImpl.getInstance();
		ProdVO pvo = service.selectProd_prod_id(vo.getProd_id());
		String prod_name = pvo.getProd_name();
		int prod_price = pvo.getProd_price();
		String prod_size = vo.getProd_size();
		if(prod_size ==null){
			prod_size = "사이즈 미선택";
		}
		
%>	
<div class="onum-main-item__contents inwish">
<p><%=prod_name %></p>
	<% 
		String amount = String.valueOf(prod_price);
		amount = amount.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
	%>
	<p><%=amount %>원</p>
	<p>사이즈 : <%=prod_size %></p>
	<div class="inwish_btns"> 
		<button type="button" id="delteBtn" class="deleteBtninwish wishDelBtn" value="<%=vo.getWish_no() %>">삭제</button>	
		<button type="button" id="cartBtn" class="cartBtninwish wishCartBtn"  value="<%=vo.getWish_no() %>">장바구니 추가</button>
	</div>
	</div>
</div>

<%		
			}
		}
	}
%>
</div>

</div>

<!-- -----------------일반상품 끝------------------------------ -->
<!-- -----------------중고상품 시작--------------- ------------------>
<hr>
<div>
<h3> 중고상품 </h3>
<div class="onum-main-container">
<%
		if(clist ==null || clist.size()==0){
%>

<h4>위시리스트에 추가한 상품이 없습니다.</h4>

<%		}else{
	for(WishVO vo : clist){
		if(vo.getProd_id().equals("used")){
%>

<div class="onum-main-item">
<div class="onum-main-item__img inwishimg" idx=<%=vo.getWish_no()%>><!-- 상품 각각에 대한 div -->
<a href="<%=request.getContextPath() %>/showProd.do?prod_id=<%=vo.getProd_id()%>">
		<img src="/nikepro/images/usedprod/<%=vo.getProd_size() %>" alt="/nikepro/images/usedprod/<%=vo.getProd_size() %>"></a>
</div>

<%
		IProdService service = ProdServiceImpl.getInstance();
		ProdVO pvo = service.selectProd_prod_id(vo.getProd_id());
		String prod_name = pvo.getProd_name();
		int prod_price = pvo.getProd_price();
		String prod_size = vo.getProd_size();
		if(prod_size ==null){
			prod_size = "사이즈 미선택";
		}
		
%>	
<div class="onum-main-item__contents inwish">
<p><%=prod_name %></p>
	<% 
		String amount = String.valueOf(prod_price);
		amount = amount.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
	%>
	<p><%=prod_name %></p>
		<p><%=amount %>원</p>
	
	<button type="button" id="delteBtn" class="deleteBtninwish" value="<%=vo.getWish_no() %>">삭제</button>	
	<button type="button" id="cartBtn" class="cartBtninwish" value="<%=vo.getWish_no() %>">장바구니 추가</button>
</div>
</div>

<%		
			}
		}
	}
%>


</div>



<!-- -------------------------주문내역----------------------------->



</div><!-- wishList-container 끝 -->



<%@ include file="/view/component/footer.jsp"%>
</body>
</html>