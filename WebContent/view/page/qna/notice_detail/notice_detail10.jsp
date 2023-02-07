<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/headMeta/headMain.jsp" %>
<title>공지사항(10)</title>
</head>
<body>
  <%@ include file="/view/component/header.jsp" %>
  <%@ include file="/view/page/qna/notice_searchForm.jsp" %>
<div class="notice_detail_container">
	<div class="notice_detail">
		<h2>Nike Training Club과 Nike Run Club 안내</h2><br>
		<b>NIKE TRAINING CLUB</b>
		<h4>시작하기</h4>
		<ul>
			<li>Nike Training Club에서 제공하는 기능은 무엇인가요?</li>
			<li>Nike Training Club 앱 운동은 어떻게 시작하나요?</li>
			<li>Nike Performance Council은 무엇인가요?</li>
			<li>나이키 트레이너는 누구인가요?</li>
		</ul>
		<h4>고객센터</h4>
		<ul>
			<li>Nike Training Club 운동을 TV로 보려면 어떻게 해야 하나요?</li>
			<li>Nike Training Club 플랜은 어떻게 바뀌었나요?</li>
			<li>왜 NTC가 작동하지 않나요?</li>
		</ul>
		<button>NTC 다운로드(iOS)</button>
		<button>NTC 다운로드(Android)</button>
		<button>NTC 자세히 알아보기</button><br><br>
		
		<b>Nike Run Club</b>
		<h4>시작하기</h4>
		<ul>
			<li>Nike Run Club 앱은 어떻게 시작하나요?</li>
			<li>Nike Run Club 앱에는 어떤 유형의 러닝이 있나요?</li>
			<li>Nike Run Club 앱에서 맞춤 설정할 수 있는 설정은 무엇인가요?</li>
			<li>Nike Run Club 러닝 도중 사용할 수 있는 기능은 무엇인가요?</li>
			<li>Nike Run Club 앱의 챌린지는 무엇인가요?</li>
			<li>Nike Run Club 앱을 실내에서도 사용할 수 있나요?</li>
		</ul>
		<h4>고객센터</h4>
		<ul>
			<li>Nike Run Club 앱에서 음악을 어떻게 재생하나요?</li>
			<li>왜 Nike Run Club 앱에 내 러닝이 동기화되지 않나요?</li>
			<li>왜 Nike Run Club 앱에 내 러닝이 전부 반영되지 않았나요?</li>
			<li>Nike Run Club 앱에서 내 러닝을 어떻게 확인하나요?</li>
		</ul>
		<h4>연결하기</h4>
		<ul>
			<li>Nike Run Club 앱과 파트너 앱 및 기기를 어떻게 연결하나요?</li>
			<li>Nike Run Club 앱과 Apple 건강 앱을 어떻게 연결하나요?</li>
			<li>내 심박수 모니터와 Nike Run Club 앱을 어떻게 연결하나요?</li>
			<li>Nike Run Club 앱에서 내 러닝을 소셜 미디어에 어떻게 공유하나요?</li>
		</ul>
		<button>NRC 다운로드(iOS)</button>
		<button>NRC 다운로드(Android)</button>
		<button>NRC 자세히 알아보기</button>
		<br>
		<img src="<%=request.getContextPath()%>/images/notice/notice_detail10.jpg" alt="notice_detail10.jpg">
		<br>
	</div>
	<div><%@ include file="/view/page/qna/notice_detail/notice_inquire_content.jsp" %></div>
</div>
<br>
<br>
  <%@ include file="/view/component/footer.jsp" %>
</body>
</html>
</html>l>l>