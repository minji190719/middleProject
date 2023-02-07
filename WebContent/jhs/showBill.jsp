<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="kr.or.ddit.vo.DeliveryVO"%>
<%@page import="kr.or.ddit.vo.PaymentVO"%>
<%@page import="kr.or.ddit.vo.CartVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/headMeta/headMain.jsp" %>

<script
		type="text/javascript"
		src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"
	></script>



<%
	List<CartVO> list = (List<CartVO>)request.getAttribute("clist"); 
	PaymentVO pvo = (PaymentVO)request.getAttribute("pvo");
	DeliveryVO dvo = (DeliveryVO)request.getAttribute("dvo");
	MemberVO mvo = (MemberVO)request.getAttribute("mvo");	
	int price =0;
	
	for(CartVO vo : list){
		price += vo.getProd_price(); //여기가 문제.
	}
%>




</head>
	<body>
		<%@ include file="/view/component/header.jsp" %>	
	
		<h1 class="pay-title">감사합니다!</h1>
		
		<main class="pay-wrap">
		
			<div class="pay-content">
				<div class="pay-option">
					<div class="bill-option__title">
					<div><h4>주문이 성공적으로 완료되었습니다.</h4></div>
					</div>
					<div class="bill-option__info">
						<div>주문 확인을 위해 이메일를 확인하세요</div><br>
						<div>주문번호 : <%=pvo.getPay_no() %></div><br>
						<div>주문날짜 : <%=pvo.getPay_date() %></div><br>
						<div>주문 확인서를 이메일로 보냈습니다.</div>
					</div>
				</div>
				<hr>
				<div class="pay-method bill-res">
					<div class="pay-method__title bill-res__title">
						<span>배송</span>
					</div>
					<div class="bill-res__contents">
						<span>배송 주소</span><br>
						<div> 
							<span><%=mvo.getMem_name() %></span><br>
							<span><%=mvo.getMem_add1() %></span><br>
							<span><%=mvo.getMem_add2() %></span><br>
							<span><%=mvo.getMem_zip() %></span><br>
						</div>
						<span>배송방법</span><br>
						<div>
							<span>무료</span><br>
							<span>도착예정일 :</span>
							<span>10월 27일 (수)</span>
						</div>
					</div>
					
					<hr>
					
					<div class="bill-res__pay_contents">
						<div class="pay-method__title bill-res__title">
							<span>결제</span><br>
						</div>
						<div>결제 수단</div><br>
						<img id="payImage" src="/nikepro/images/kakaopay.png" alt="/nikepro/images/kakaopay.png">
						</div>
					
<!-- 					<div class="pay-method_btn"> -->
<!-- 						<button class="onumBuyBtn" id="billsBtn" >주문 확인서 인쇄</button> -->
<!-- 					</div> -->
									
				</div>
			</div>
			
			<div class="pay-side">
				<div class="pay-side__title bill-side__title">
					<span>주문 내역</span>
				</div>
				<div class="bill-side__info">
<!-- 				<div class="pay-side__info"> -->
					<span>도착예정일: 10월 27일 (수)</span>
	<%
		for(CartVO cvo : list){
			if(cvo.getProd_id().equals("used")){	// 중고 상품일 경우
	%>		
					
					
					<img src="images/usedprod/<%=cvo.getProd_size() %>" alt="images/usedprod/<%=cvo.getProd_size() %>">
	
					<span><%=cvo.getProd_name() %></span>
					<span>수량 <%=cvo.getCart_qty() %></span>
					<span><%=cvo.getProd_price() %> 원</span>
			
	<%
		}else{	// 일반 상품일 경우
	%>				
					
					<img src="images/prod/<%=cvo.getProd_id() %>_1.png" alt="images/prod/<%=cvo.getProd_id() %>_1.png">
	
					<span><%=cvo.getProd_name() %></span>
					<span>사이즈 <%=cvo.getProd_size() %></span>
					<span>수량 <%=cvo.getCart_qty() %></span>
					<span><%=cvo.getProd_price() %> 원</span>
	<%	}
	}%>
					
				</div>
			
				<div class="bill-side__res">
		
				<% 
				String amount = String.valueOf(price);
				amount = amount.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
				%>
				<!--  -->
						<span>상품 금액</span>
						<span><%=amount %> 원</span>
						<span>배송비</span>
						<span>무료</span>
						<span>주문합계</span>
						<span><%=amount %> 원</span>
				</div>
			</div>
		</main>

		<%@ include file="/view/component/footer.jsp" %>	
	

		
	</body>
</html>