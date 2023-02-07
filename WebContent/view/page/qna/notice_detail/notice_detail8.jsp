<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/headMeta/headMain.jsp" %>
<title>공지사항(8)</title>
</head>
<body>
  <%@ include file="/view/component/header.jsp" %>
  <%@ include file="/view/page/qna/notice_searchForm.jsp" %>
<div class="notice_detail_container">
	<div class="notice_detail">
		<h2>나이키 멤버가 되면 어떤 혜택을 받나요?</h2><br>
		<p>나이키는 멤버 여러분께 다양한 혜택을 드리기 위해 항상 노력하고 있습니다. 멤버에 가입하신 후, 나이키가 준비한 다양한 혜택이 제공됩니다.</p>
		<button type="button">멤버 가입하기</button>
		<button type="button">멤버 혜택 더 알아보기</button>
		<br><br>
		<b>MEMBER SHOP</b>
		<ul><Li>멤버에게는 특별 제품 구매 기회와 신제품 우선 구매 기회를 제공합니다.</Li></ul>
		<br>
		<b>SPECIAL EVENT & SERVICE</b>
		<ul><Li>멤버는 시즌별로 나이키가 준비한 이벤트와 서비스를 누릴 수 있습니다.</Li></ul>
		<br>
		<b>오늘도착 서비스</b>
		<ul><Li>멤버에게는 온라인으로 주문한 제품을 당일에 받아 볼 수 있는 오늘도착 서비스를 제공합니다.</Li></ul>
		<br>
		<b>DRAW</b>
		<ul><Li>멤버에게는 트렌드를 이끄는 한정판 제품 구매 기회를 제공합니다.</Li></ul>
		<br>
		<b>프로모션 코드 혜택</b>
		<ul><Li>멤버에게는 웰컴 프로모션 코드와 생일 프로모션 코드 등 다양한 할인 혜택을 제공합니다.</Li></ul>
		<br>
		<b>나이키 매장에서의 다양한 혜택</b>
		<ul><Li>멤버를 위해 나이키 매장에서는 Fast Lane, Early Access, 멤버 프로모션 등의 다양한 이벤트와 맞춤형 서비스를 준비합니다. (단, 나이키 멤버 서비스 및 제공 혜택은 매장별로 다를 수 있습니다.)</Li></ul>
		<br>
		<b>나이키의 디지털 환경을 하나의 계정으로 이용할 수 있는 서비스 제공</b>
		<ul><Li>멤버는 하나의 나이키 계정으로 나이키닷컴을 비롯하여 NRC, NTC 앱도 함께 이용할 수 있습니다.</Li></ul>
		<img src="<%=request.getContextPath()%>/images/notice/notice_detail8.jpg" alt="notice_detail8.jpg">
	</div>
	<div><%@ include file="/view/page/qna/notice_detail/notice_inquire_content.jsp" %></div>
</div>
<br>
<br>


  <%@ include file="/view/component/footer.jsp" %>
</body>
</html>
</html>