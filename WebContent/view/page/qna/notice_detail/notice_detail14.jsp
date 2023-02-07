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
		<h2>내 나이키 신발을 재활용할 수 있나요?</h2><br>
		<p>네, 러닝이나 코트 위 경기, 필드 위 질주가 더 이상 어려운 신발은 재활용이 가능합니다.</p>
		<p>나이키에서는 중고 운동화와 의류를 재활용 및 기부하고 있습니다. 이는 탄소 제로, 폐기물 제로를 향한 나이키의 Move to Zero 여정 중 하나입니다. 사용한 운동화를 캠페인 참여 매장에 가져다 주시면, 재활용 가능 제품과 세탁 후 기부 가능한 제품으로 분류하게 됩니다. 두 방법 모두 쓰레기를 줄이는 데 도움이 될 수 있습니다.</p>
		<p>대부분의 매장에서 브랜드에 상관 없이 운동화를 수거하고 있지만, 샌들과 구두, 부츠, 금속이 달린 신발(클리트 또는 스파이크)은 접수가 불가능합니다. 근처 나이키 매장에서 신발을 수거하는지 먼저 확인하세요.</p>
		<p>운동용 상의나 하의는 브랜드에 상관 없이 일부 매장으로 가져오실 수 있지만 양말이나 속옷, 금속(스냅, 지퍼, 버튼)이 달린 의류는 접수가 불가능합니다.</p>
		<button>재활용+기부 자세히 알아보기</button>
		<button>매장 찾기</button><br>
		<button>Move to Zero에 대해 자세히 알아보기</button><br>
		<p>재활용 접수 장비는 나이키의 혁신을 통해 거듭나게 됩니다.</p>
		<button>나이키 구매하기</button><br>
		<img src="<%=request.getContextPath()%>/images/notice/notice_detail14.jpg" alt="notice_detail14.jpg">

	</div>
	<div><%@ include file="/view/page/qna/notice_detail/notice_inquire_content.jsp" %></div>
</div>
<br>
<br>
  <%@ include file="/view/component/footer.jsp" %>
</body>
</html>