<%@page import="java.util.UUID"%>
<%@page import="kr.or.ddit.payment.service.PaymentServiceImpl"%>
<%@page import="kr.or.ddit.payment.service.IPaymentService"%>
<%@page import="kr.or.ddit.prod.service.IProdService"%>
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.vo.AddressVO"%>
<%@page import="kr.or.ddit.vo.CartVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<title>Payment Page</title>
	<%@ include file="/WEB-INF/headMeta/headMain.jsp" %>
	<!-- iamport.payment.js -->
	<!--
	<script
		type="text/javascript"
		src="https://cdn.iamport.kr/js/iamport.payment-{SDK-최신버전}.js"
	></script>
	-->
	<script
		type="text/javascript"
		src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"
	></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<%
	List<CartVO> list = (List<CartVO>)request.getAttribute("cartList");
	AddressVO vo = (AddressVO)request.getAttribute("address");
	MemberVO mvo = (MemberVO) session.getAttribute("member");
	String json = new Gson().toJson(list);
	boolean mileage_flag = false;
	int newAmount = 0;
	
	int price=0;
	
	int save_price = 0;
	for(CartVO cvo : list){
		price += cvo.getProd_price();
	}
	
	String uid = "nike_"+UUID.randomUUID().toString();
	
%>

	<script type="text/javascript">

		var IMP = window.IMP; // 생략 가능

		let json =<%=json %>

		

	</script>
	</head>
	<body>
		<%@ include file="/view/component/header.jsp" %>	
	
		<h1 class="pay-title">결제하기</h1>
		
		<main class="pay-wrap">
			<div class="pay-content">
				<div class="pay-option">
					<div id="payOptionTitle" class="pay-option__title">
						<span>배송옵션</span>
						<span onclick="editPost()" id="editPost" class="pay-option__edit-post">배송지 편집</span>
					</div>
					<div class="pay-option__info">
						<h3>배송주소</h3>
						<span><%=mvo.getMem_name() %></span>
						<span id="jsonAddr"><%=vo.getAddr1() %>&nbsp;<%=vo.getAddr2() %></span>
						<span id="jsonZip"><%=vo.getAddr_zip() %></span>
						<span><%=mvo.getMem_mail() %></span>
						<span>+82-<%=mvo.getMem_tel() %></span>
					</div>
					<div class="pay-option__info">
						<h3>배송방법</h3>
						<span>무료</span>
						<span>도착 예정일: 10월 27일 (수)</span>
					</div>
<!-- 					<div class="pay-option__info"> -->
<!-- 						<h3>이름</h3> -->
<%-- 						<span><%=mvo.getMem_name() %></span> --%>
<!-- 						<h3>배송지 주소</h3> -->
<%-- 						<span><%=vo.getAddr1() %>&nbsp;<%=vo.getAddr2() %></span> --%>
<!-- 						<h3>우편번호</h3> -->
<%-- 						<span><%=vo.getAddr_zip() %></span> --%>
<!-- 						<h3>이메일</h3> -->
<%-- 						<span><%=mvo.getMem_mail() %></span> --%>
<!-- 						<h3>전화번호</h3> -->
<%-- 						<span><%=mvo.getMem_tel() %></span> --%>
<!-- 					</div> -->
				</div>
				
				<div class="pay-method">
					<div class="pay-method__title">
						<span>결제</span>
					</div>
					<div>
						<input type="checkbox" id="checkBoxId">
						<label> 마일리지를 사용하시겠습니까?</label> <br /><br />
						<label id="checkMileage"> 현재 나의 마일리지 : <%= mvo.getMem_mileage() %> M</label>
						<!-- 인풋박스 체크되면 사용될 마일리지 : <%= mvo.getMem_mileage() %> -->
						<!-- 총결제금액 - <%= mvo.getMem_mileage() %> -->
					</div>
					
					<div>
						<h4>결제수단 선택</h4>
						<ul>
							<li>
							 	<input id="payType" type="radio" value="kacao">
							 	<img id="payImage" src="/nikepro/images/kakaopay.png" alt="/nikepro/images/kakaopay.png">
							 	<label> 카카오페이</label>
							</li>
						</ul>
					</div>
					<div class="pay-method">
						<h4>지정된 결제 수단</h4>
						<div id="card">
							<span><i class="fa-regular fa-credit-card fa-lg"></i>신규 카드 추가</span>
						</div>
					</div>
					<div class="pay-method_btn">
						<button onclick="onDisplay()" class="onumBuyBtn" id="payBtn" >주문하기</button>
					</div>
					
					<div id ="lastPay" style="display:none;">
						<p id="agreeContent">구매약관에 동의  </p>
						<input id="agree" type="checkbox">
						<br>
					<div class="pay-method_btn">
						<button id="payBtn2" class="onumBuyBtn" name="구매약관이 눌려야 누를수 있는 버튼">주문하기</button>
					</div>
					</div>
				</div>
			</div>
			
			<div class="pay-side">
				<div class="pay-side__title">
					<span>장바구니</span>
				</div>
				<div class="pay-side__info">
					<span>상품금액</span>
				<% 
				String amount = String.valueOf(price);
				amount = amount.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
				%>
					<span id="resultPrice"><%=amount %>원</span>
					<span>배송비</span>
					<span>무료</span>
					<span>총 할인</span>
					<span>0원</span>
					<span>총 결제 금액</span>
					<span id="resultPrice2"><%=amount %>원 </span>
					<span>도착 예정일: </span>
					<span>10월 27일 (수) </span>
				</div>
			
				<div class="cart-prod__topcontainer">
		
<%
					for(CartVO cvo : list){
%>		
					
					<div class="cart-prod__container">
					<%
						if(cvo.getProd_id().equals("used")){	// 중고상품 장바구니 리스트
					%>	
						<div class="cart-prod__container__column">
						<img
							src="images/usedprod/<%=cvo.getProd_size() %>"
							alt="images/usedprod/<%=cvo.getProd_size() %>"
						>
						</div>
						<div class="cart-prod__container__column">
							<span><%=cvo.getProd_name() %></span>
							<span>수량 <%=cvo.getCart_qty() %></span>
							
											<% 
				String amount2 = String.valueOf(cvo.getProd_price());
				amount2 = amount2.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
				%>
							
							
							<span><%=amount2 %></span>
							</div>
					<%		
						}
					%>
					</div>
					<%
					if(!cvo.getProd_id().equals("used")){			// 일반상품 장바구니 리스트 
					%>
					<div class="cart-prod__container">
						<div class="cart-prod__container__column">
						<img
							src="images/prod/<%=cvo.getProd_id() %>_1.png"
							alt="images/prod/<%=cvo.getProd_id() %>_1.png"
						>
						</div>
						<div class="cart-prod__container__column">
							<span><%=cvo.getProd_name() %></span>
							<%-- <span><%=cvo.getProd_id() %></span> --%>
							<span><%=cvo.getProd_color() %></span>
							<span>사이즈 <%=cvo.getProd_size() %></span>
							<span>수량 <%=cvo.getCart_qty() %></span>
							
											<% 
				String amount2 = String.valueOf(cvo.getProd_price());
				amount2 = amount2.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
				%>
							
							
							<span><%=amount2 %></span>
					<%}%>
						</div>
<%
					}
%>
					</div>
				</div>
			</div>
		</main>

		<%@ include file="/view/component/footer.jsp" %>	
	
	
<script type="text/javascript">
let result_price = <%= price%>;

function onDisplay(){
	$('#lastPay').show();
	$('#payBtn').hide();
}


$(document).ready(function(){
    $("#checkBoxId").change(function(){
        if($("#checkBoxId").is(":checked")){
            //alert("체크박스 체크했음!");
            let target = document.getElementById("checkMileage");
            let target_price = document.getElementById("resultPrice");
            let target_price2 = document.getElementById("resultPrice2");
            target.innerHTML = " 차감될 마일리지 : -<%= mvo.getMem_mileage() %> M";
            <%
            newAmount = price - mvo.getMem_mileage();
            String new_amount = String.valueOf(newAmount);
            new_amount = new_amount.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
            mileage_flag = true;
            //save_price = price;
            //price = newAmount;
            %>
            
            result_price = <%=newAmount%>;
            target_price.innerHTML = "<%=new_amount %>원";
            target_price2.innerHTML = "<%=new_amount %>원";
            
        }else{
            //alert("체크박스 체크 해제!");
        	 let target = document.getElementById("checkMileage");
        	 let target_price = document.getElementById("resultPrice");
        	 let target_price2 = document.getElementById("resultPrice2");
             target.innerHTML = " 현재 나의 마일리지 : <%= mvo.getMem_mileage() %> M";
             target_price.innerHTML = "<%=amount %>원";
             target_price2.innerHTML = "<%=amount %>원";
             
             <%
             mileage_flag = false;
             //price = save_price;
             %>
             result_price = <%=price%>;
             //alert(<%= mileage_flag%>);
        }
    });
});



$(function(){
    

    $('#payBtn2').prop("disabled",true);

    
    $('#agree').on('click',function(){
        
        $('#payBtn2').prop("disabled",false);
        
    })
    
    
    //카카오페이에 필요한 데이터들   
    pay_total = result_price;

    let jsonData = JSON.stringify(json);
    
    $('#payBtn2').on('click',function(){
        
    IMP.init("imp40457482"); // 예: imp00000000
        
    IMP.request_pay({ // param
         pg: "kakaopay",
         pay_method: "card",
         merchant_uid: "<%=uid %>",
         name: "나이키 상품 결제",
<%--          amount: '<%=price %>', //가격 --%>
         amount: result_price, //가격
         buyer_email: "nang1825@naver.com",
         buyer_name: '<%=mvo.getMem_name() %>',
         buyer_tel: '<%=mvo.getMem_tel() %>',
         buyer_addr: '<%=vo.getAddr1()%>',
         buyer_postcode: '<%=vo.getAddr_zip()%>'
      }, function (rsp) { // callback
          if (rsp.success) {

              $.ajax({
                    url : "/nikepro/payment.do",
                    type : "post",
                    data : {"cart_json" : jsonData, "pay_total" : result_price},
                    success : function(res){
                        pay_no = res.pay_no;
                        location.href="<%=request.getContextPath()%>/showBill.do?pay_no=" + pay_no;
                    },
                    error : function(xhr){
                        alert(xhr.status)   
                    },
                    dataType : "json"
                
                    })  //ajax 종료  
              
           } else {
                //alert("결제실패!")
           }
       });  //카카오페이 결제 종료
        
        
    })  //payBtn2 버튼 종료
    
    
}) // function 종료

</script>	
<script src="${pageContext.request.contextPath}/js/appendPostInput.js"></script>	
<script src="${pageContext.request.contextPath}/js/getAddressAPI.js"></script>	
<script src="${pageContext.request.contextPath}/js/updateAddress.js"></script>	
		
		
		
		
		
		
	</body>
</html>