<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/headMeta/headMain.jsp" %>
<title>공지사항(7)</title>
</head>
<body>
  <%@ include file="/view/component/header.jsp" %>
  <%@ include file="/view/page/qna/notice_searchForm.jsp" %>
<div class="notice_detail_container">
	<div class="notice_detail">
		<h2>나이키의 환불 절차는 어떻게 되나요?</h2><br>
		<p>반품의 검수가 완료되면 반품 확정 여부가 휴대폰 문자메시지로 안내됩니다.</p>
		<p>반품 확정 처리 후, 나이키에서 결제 승인이 취소되고 바로 환불 절차가 진행됩니다.</p>
		<b>신용카드/ 체크카드 환불</b>
		<ul>
			<li>결제 승인 취소 후, 약 3영업일 이내에 카드사에서 취소내역을 확인하실 수 있습니다.
				<ul>
					<li>단, 결제일이 이전 달인 경우에는 결제일의 다음 달 대금 청구 시에 해당 금액이 환급처리됩니다.</li>
				</ul>
			</li>
		</ul>
		<b>카카오페이</b>
				<ul>
			<li>결제 승인 취소 후, 카드는 약 3영업일 이내에 취소내역을 확인하실 수 있으며, 카카오머니는 즉시 환불됩니다.
				<ul>
					<li>카카오페이로 발송되는 알림 톡은 취소 즉시 발송되며, 카드사로부터 받는 문자는 결제 취소 완료 후 발송됩니다.
					</li>
				</ul>
			</li>
		</ul>
		<b>네이버페이</b>
		<ul>
			<li>결제 수단에 따라 환불 방법 및 기간이 다르게 적용됩니다.</li>
		</ul>
		<b>현금 환불(실시간 계좌이체)</b>
		<ul>
			<li>실시간 계좌이체로 결제하신 경우에는 고객님의 은행 계좌로 환불해 드립니다. 결제 승인 취소 후, 약 3영업일 이내로 환불 금액이 반영됩니다.</li>
		</ul>
		<h4>유의사항</h4>
		<p>멤버데이즈와 같이 주문 및 고객 문의가 증가하는 기간에는 환불이 다소 지연될 수 있습니다.</p>
	</div>
	<div><%@ include file="/view/page/qna/notice_detail/notice_inquire_content.jsp" %></div>
</div>
<br>
<br>


  <%@ include file="/view/component/footer.jsp" %>
</body>
</html>
</html>