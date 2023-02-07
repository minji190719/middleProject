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
		<h2>나이키 제품의 사이즈 정보는 어떻게 알 수 있나요?</h2><br>
		<p>좋은 퍼포먼스를 내기 위해서는 착용하는 옷과 장비의 알맞은 사이즈가 중요합니다. 최상의 퍼포먼스를 내실 수 있도록 나이키에서 도와드리겠습니다.</p>
		<p>어떤 사이즈의 옷과 신발을 선택해야 할지 모르신다면 아래의 버튼을 통해 알아보세요. 남성, 여성, 남녀 공용, 아동 제품을 비롯하여 아시아 사이즈, US 사이즈 등 모든 제품의 사이즈를 안내해 드리고 있습니다.</p>
		<p>더불어 각 제품 페이지에서도 링크를 통해 알아보실 수 있습니다.</p>
		
		<button>나이키 사이즈 차트</button><br>
		<p>만약 구매하신 제품의 사이즈가 맞지 않으실 경우, 나이키의 무료반품 서비스를 통해 손쉽게 환불하실 수 있는 점 잊지 말아주세요.</p>
		<button>쇼핑하기</button><br>
		<img src="<%=request.getContextPath()%>/images/notice/notice_detail12.jpg" alt="notice_detail12.jpg">
	</div>
	<div><%@ include file="/view/page/qna/notice_detail/notice_inquire_content.jsp" %></div>
</div>
<br>
<br>
  <%@ include file="/view/component/footer.jsp" %>
</body>
</html>
</html>l>l>