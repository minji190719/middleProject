<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/headMeta/headMain.jsp" %>
<title>공지사항(3)</title>
</head>
<body>
  <%@ include file="/view/component/header.jsp" %>
  <%@ include file="/view/page/qna/notice_searchForm.jsp" %>
<div class="notice_detail_container">
	<div class="notice_detail">
		<h2>주문 및 배송 상황은 어떻게 조회할 수 있나요?</h2><br>
		<p>나이키 제품 주문 관련된 가장 최신의 상태 정보는 nike.com/kr/orders에서 확인하실 수 있습니다. 나이키 멤버는 로그인 후, 보다 편리하게 주문 상태를 확인할 수 있습니다.</p>
		<button type="button">로그인하기</button>
		<button type="button">주문 확인하기</button>
		<p>주문이 완료되면 나이키는 주문 번호와 함께 주문 내역을 조회할 수 있는 링크를 휴대폰 문자메시지로 보내드립니다.</p>
		<p>혹은 nike.com/kr/orders에 접속하여 직접 배송 상황을 확인하실 수도 있습니다. 멤버는 로그인 후, 주문 페이지의 '주문 상세 보기' > '조회하기' 버튼을 통해 손쉽게 조회할 수 있습니다.</p>
		<p>로그인 없이 주문하신 경우에는 주문번호와 이메일 주소로 로그인 후, 위와 동일한 과정을 통해 배송 진행 상황을 확인하실 수 있습니다.</p>
		<br>
		<h4>FAQs</h4>
		<b>주문 정보 조회는 언제부터 할 수 있나요?</b>
		<p>주문을 완료하면 나이키로부터 주문번호와 주문 정보를 조회할 수 있는 링크를 휴대폰 문자 메시지로 받게 됩니다. 해당 정보로 주문 정보 조회가 가능합니다.</p>
		<br>
		<p>더불어 제품의 배송 완료 후에는 조회 번호가 안내된 문자가 한 번 더 전송됩니다.</p>
		<br>
		<b>주문한 제품 중 왜 일부만 먼저 배송이 되었나요?</b>
		<p>여러 개의 제품을 한 번에 함께 주문하신 경우에는 배송이 여러 번에 걸쳐서 진행될 수 있습니다.</p>
	</div>
	<div><%@ include file="/view/page/qna/notice_detail/notice_inquire_content.jsp" %></div>
</div>
<br>
<br>


  <%@ include file="/view/component/footer.jsp" %>
</body>
</html>