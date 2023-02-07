<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/headMeta/headMain.jsp" %>
<title>공지사항(1)</title>
</head>
<body>
  <%@ include file="/view/component/header.jsp" %>
  <%@ include file="/view/page/qna/notice_searchForm.jsp" %>
<div class="notice_detail_container">
	<div class="notice_detail">
		<h2>주문을 취소하거나 주문 내용을 변경할 수 있나요?</h2><br>
		
		<h4>주문 취소</h4>
		<p>주문 직후 혹은 주문취소 버튼이 활성화되어있을 때에만 온라인 또는 고객센터를 통해 주문취소가 가능합니다.</p>
		<b>온라인에서 주문 취소하기</b>
		<ol>
			<li>로그인 후, 주문 페이지에 접속</li>
			<li>취소하고자 하는 주문의 '주문 상세 보기' > '주문 취소' 버튼 누르기</li>
		</ol>
		<p>유의사항:</p>
		<ul>
			<li>비회원 혹은 로그인을 하지 않고 주문하신 경우에는 이메일 주소와 문자로 받으신 주문번호를 입력하면 로그인이 가능합니다.</li>
		</ul>
		<b>주문 취소 불가</b>
		<p>'주문 취소' 버튼이 활성화된 상태가 아니라면 해당 주문은 취소가 불가합니다. 이러한 경우에는 제품을 수령하신 후, 나이키가 제공하는 무료 반품 서비스를 이용하시기 바랍니다.</p>
		
		<h4>주문 변경</h4>
		<p>이미 완료된 주문에 대해서는 제품 변경, 옵션 혹은 수량의 변경이 불가합니다. 기존 주문을 취소하신 후, 원하시는 제품으로 재주문해 주시기 바랍니다.</p>
		
		<h3>FAQs</h3>
		<b>주문 및 결제 완료 후, 배송지 주소 변경이 가능한가요?</b>
		<p>배송지 주소 변경은 불가합니다. 배송지 주소 변경을 원하시는 경우에는 주문 취소 후, 해당 정보를 변경해 주시기 바랍니다.</p>
		<br>
		<b>결제를 했으나 진행 상황이 결제 지연으로 조회됩니다. 이 경우에 결제가 완료된 것으로 봐도 될까요?</b>
		<p>아닙니다. 결제 지연으로 조회되는 경우에는 결제가 완료되지 않은 상태입니다. 시간이 더 경과된 후에 확인하시거나 계속 상태가 변경되지 않는다면 나이키코리아 고객센터로 연락 주시기 바랍니다.</p>
		<br>
		<b>한 번의 주문에 여러 개의 제품을 함께 주문한 경우, 일부분만 취소 처리가 가능한가요?</b>
		<p>부분 취소를 원하시는 경우에는 나이키코리아 고객센터로 연락 주시면 제품별로 취소 처리를 도와드리겠습니다. 온라인에서는 전체 주문에 대한 취소만 가능한 점 유의하시기 바랍니다.</p>
		<br>
		<b>주문 취소 건에 대한 환불은 어떻게 진행되나요?</b>
		<p>주문을 취소하시면 결제 취소도 함께 진행됩니다. 그러나 결제 수단에 따라서 내역 확인까지 시간이 소요될 수 있는 점 참고하시기 바랍니다.</p>
	</div>
	<div><%@ include file="/view/page/qna/notice_detail/notice_inquire_content.jsp" %></div>
</div>
<br>
<br>


  <%@ include file="/view/component/footer.jsp" %>
</body>
</html>