<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/headMeta/headMain.jsp" %>
<title>공지사항(12)</title>
</head>
<body>
  <%@ include file="/view/component/header.jsp" %>
  <%@ include file="/view/page/qna/notice_searchForm.jsp" %>
<div class="notice_detail_container">
	<div class="notice_detail">
		<h2>나이키의 친환경 노력에는 어떤 활동이 있나요?</h2><br>
		<p>나이키는 제로 탄소와 제로 폐기물을 목표로 하는 Move to Zero 활동을 이어가고 있습니다. 제품의 생산부터 배송까지의 과정에서 환경에 주는 영향을 최소화하고자 하며, 이를 위한 나이키의 노력은 아래와 같습니다.</p>
		<p>환경을 생각하는 나이키의 노력에 동참해 주시는 고객 여러분께 감사드립니다.</p>
		<b></b>
		<ul>
			<li>나이키의 Move to Zero 제품은 신발 박스에 운송장이 부착되어 배송됩니다.</li>
			<li>신발 박스 자체로 배송되기 때문에 배송 과정 중 신발 박스가 손상될 수 있습니다. 이로 인한 박스 재발송은 어려운 점 양해 부탁드립니다.</li>
			<li>나이키의 Move to Zero 제품을 반품하실 때는 단일 신발 박스에 제품을 포장해 주시면 됩니다. 단, 제품이 분실되지 않도록 유의하여 박스를 테이핑해 주시기 바랍니다.</li>
		</ul>
		<img src="<%=request.getContextPath()%>/images/notice/notice_detail13_1.jpg" alt="notice_detail13_1.jpg">
		<p>(좌) 일반 제품 배송 포장 (우) 단일 박스 배송 포장</p>
		<b>신발 속지 없이 배송</b>
		<ul>
			<li>나이키의 Move to Zero 제품은 신발 박스 내에 종이 속지 및 고정재가 없이 신발만 배송됩니다.</li>
		</ul>
		<img src="<%=request.getContextPath()%>/images/notice/notice_detail13_2.jpg" alt="notice_detail13_2.jpg">
		<p>(좌) 종이 속지가 있는 일반 배송 제품 (우) 종이 속지 없이 배송되는 제품</p>
		<b>주문 확인서 없이 배송</b>
		<ul>
			<li>온라인으로 주문하신 제품의 배송 시, 택배 상자 안에 주문 확인서가 제공되지 않습니다.</li>
			<li>해당 주문의 결제 내역은 나이키에 로그인하신 후, 주문 화면 내의 주문 상세 보기 버튼을 통해 확인할 수 있습니다.</li>
		</ul>
		<b>나이키 지속 가능 컬렉션</b>
		<ul>
			<li>나이키 헤리티지 로고가 표기된 제품은 재활용 소재를 포함하고 있습니다.</li>
		</ul>
		<button>나이키 지속가능 컬렉션 바로가기</button>
	</div>
	<div><%@ include file="/view/page/qna/notice_detail/notice_inquire_content.jsp" %></div>
</div>
<br>
<br>
  <%@ include file="/view/component/footer.jsp" %>
</body>
</html>