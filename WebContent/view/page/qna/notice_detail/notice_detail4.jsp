<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/headMeta/headMain.jsp" %>
<title>공지사항(4)</title>
</head>
<body>
  <%@ include file="/view/component/header.jsp" %>
  <%@ include file="/view/page/qna/notice_searchForm.jsp" %>
<div class="notice_detail_container">
	<div class="notice_detail">
		<h2>결제 방법에는 어떤 것이 있나요?</h2><br>
		<p>나이키 온라인에서 제품 구매 시, 결제하실 수 있는 방법은 다음과 같습니다. SNKRS 제품의 경우에는 카드 결제만 가능합니다.</p>
		<ul>
			<li>신용카드/ 체크카드</li>
			<li>카카오페이</li>
			<li>네이버페이</li>
			<li>페이코</li>
			<li>실시간 계좌이체 (현금결제)</li>
		</ul>
		<p>단, SNKRS(DRAW, LINE) 제품은 카드로만 결제가 가능합니다.</p>
		<p>멤버는 한 계정에 최대 4개의 카드 정보를 등록할 수 있습니다. 더불어 카드 정보를 미리 등록하시면 보다 편리하게 결제 시스템을 이용할 수 있습니다.</p>
		<a href="<%=request.getContextPath()%>/signUp.do"><button type="button">멤버 가입하기</button></a>
		<a href="<%=request.getContextPath()%>/home.do"><button type="button">쇼핑하기</button></a>
		<button type="button">카드정보 저장하기</button>
		<h4>결제 카드 정보 저장 방법</h4>
		<ul>
			<li>미리 저장하기
				<ol>
					<li>나이키 로그인하기</li>
					<li>우측 상단의 '계정' 접속 후, '결제 수단 관리' 누르기</li>
					<li>'결제 수단 추가' 버튼 누른 후, 청구 주소 정보 입력하기 (단, 청구 주소는 배송 주소에 입력한 내용과 동일해야 합니다).</li>
					<li>휴대폰 본인 인증 후, 카드 정보 입력하기</li>
					<li>저장 완료하기</li>
				</ol>
			</li>
			<li>구매 과정에서 결제 수단 저장하기
				<ol>
					<li>구매하실 제품을 '장바구니'에 추가한 후, '주문결제' 버튼 누르기</li>
					<li>결제 페이지에서 배송 주소 입력 후 '결제>결제 수단 선택'에서 '신용카드' 선택</li>
					<li>'저장된 결제 수단>신규 카드 추가' 선택하기</li>
					<li>하단에 생성된 '입력한 카드 정보를 향후 결제 수단으로 저장' 박스 체크하기</li>
					<li>'주문하기' 버튼 누른 후, 약관 확인하고 휴대폰 본인 인증 진행하기</li>
					<li>카드 정보 입력 후, 저장 완료하기</li>
				</ol>
			</li>
		</ul>
		<br>
		<h4>추가 안내 사항</h4>
		<ul>
			<li>카드사 할부 정보는 매월 변경되며, 공지사항에서 확인하실 수 있습니다.</li>
			<li>결제정보 입력 시, 청구 주소와 배송지 주소가 일치해야 합니다.</li>
		</ul>
	</div>
	<div><%@ include file="/view/page/qna/notice_detail/notice_inquire_content.jsp" %></div>
</div>
<br>
<br>


  <%@ include file="/view/component/footer.jsp" %>
</body>
</html>