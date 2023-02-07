<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="kr.or.ddit.usedprod.service.UsedProdServiceImpl"%>
<%@page import="kr.or.ddit.usedprod.service.IUsedProdService"%>
<%@page import="kr.or.ddit.vo.UsedProdVO"%>
<%@page import="kr.or.ddit.salesrequest.service.SalesRequestServiceImpl"%>
<%@page import="kr.or.ddit.salesrequest.service.ISalesRequestService"%>
<%@page import="kr.or.ddit.vo.SalesRequestVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
<%@include file="/WEB-INF/headMeta/headMain.jsp" %>
<title>ONUM_REQ_Detail</title>
</head>
<body>
<%@include file="/view/component/header.jsp" %>

<%
// user 값이 존재하면 사용자 -> 목록 버튼 수정/ 승인, 반려 버튼 hide();/ 승인 중 삭제 불가/
		//////////////////////////////////
		HttpSession session2 = request.getSession();
	      
	    MemberVO member = (MemberVO) session2.getAttribute("member");
	        
	    String memId="";
		if(member == null){		// 비회원일 경우
			memId = "비회원";
		}else{
			memId = member.getMem_id();	// 회원일 경우 			
		}
	   
	    
	    //////////////////////////////////////
	// 상세페이지
	SalesRequestVO vo = null;
	ISalesRequestService service = SalesRequestServiceImpl.getInstance();
	String reqno = request.getParameter("reqno");
	vo = service.selectSalesRequest_req_no(reqno);
	
%>
<header>
	<div class="onum-main-header__menu">
		
	<%	
	if(!memId.equals("ADMIN")){
	%>
		<a href="<%=request.getContextPath() %>/ONUM/myPage.do">MyPage</a>
	<%}else{ %>
		<a href="<%=request.getContextPath() %>/view/page/ONUM/ReqList.jsp">판매요청관리</a>	
	<%} %>		
		
	</div>
</header>
<div class="onum-mypage__title">	
		<h3>판매요청 상세보기</h3>
</div>

<main>
<form name="reqDetail" id="reqDetail">
	
<!-- 	버튼 수행할 때 사용자인지 관리자인지 구분해 줄 전달값 -->
<%-- 	<input type="hidden" id="user" name="user" value="<%=user %>"> --%>
	
<input type="hidden" id="reqno" name="reqno" value="<%=vo.getReq_no() %>">
<div class="onum-main">
<div class="onum-detail-container">
	<table class="onum-img-table">
	<tr>
		<td>
		<img src="/nikepro/images/usedprod/<%=vo.getReq_photo()%>">
		</td>
		<td>
		<img src="/nikepro/images/usedprod/<%=vo.getReq_photo()%>">
		</td>
	</tr>
	<tr>
		<td>
		<img src="/nikepro/images/usedprod/<%=vo.getReq_photo()%>">
		</td>
		<td>
		<img src="/nikepro/images/usedprod/<%=vo.getReq_photo()%>">
		</td>
	</tr>
	</table>
		<div class = "onum-detail-contents reqDetail_contents">
		<div class="onum-detail-conctents__text reqDetail_contents__text">
<%-- 			<span><%=vo.getOrigin_name() %></span> --%>
<%-- 			<span>리셀가 : <%=vo.getReq_price() %> 원</span> --%>
<%-- 			<span>원가 : <%=vo.getOrigin_price() %> 원</span> --%>
<%-- 			<span>상품번호 : <%=vo.getReq_no() %> 원</span> --%>
<%-- 			<span>신청인 : <%=vo.getMem_id() %></span> --%>
<%-- 			<span>신청일자 : <%=vo.getReq_price() %> 원</span> --%>
			<%
			int status = vo.getReq_status();
				String showstatus = "";
			if(status == 0){
				showstatus = "대기";
			}else if(status == 1 ){
				showstatus = "승인";
			}else if(status == 2){
				showstatus = "반려";
			}else{
				showstatus = "판매완료";				
			}
			
		%>
<table id="reqDetail_content_tb">
	<tr>
		<td>상품번호</td>
		<td><%=vo.getReq_no() %></td>
	</tr>
	<tr>
		<td>신청인</td>
		<td><%=vo.getMem_id() %></td>
	</tr>
	<tr>
		<td>상품명</td>
		<td><%=vo.getOrigin_name() %></td>
	</tr>
	<tr>
				<% 
				String amount = String.valueOf(vo.getOrigin_price());
				amount = amount.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
				%>
		<td>원가</td>
		<td><%=amount %></td>
	</tr>
	<tr>
				<% 
				String amount2 = String.valueOf(vo.getReq_price());
				amount2 = amount2.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
				%>
		<td>리셀가</td>
		<td><%=amount2 %></td>
	</tr>
	<tr>
		<td>상품설명</td>
		<%String detail = vo.getReq_detail().replaceAll("\n","<br>"); %>
		<td><%=detail %></td>
	</tr>
<!-- 	<tr> -->
<!-- 		<td>신청일자</td> -->
<%-- 		<td><%=vo.getReq_date() %></td> --%>
<!-- 	</tr> -->

	
	<tr>
		<td>신청상태</td>
		<td><%=showstatus %></td>
	</tr>
</table>	

<%-- 			<span><%=showstatus %></span> --%>
<%-- 			<div><%=vo.getReq_detail() %></div> --%>
		</div>
		<div class="reqDetail_btns">
		<table class="reqDetail_btns__tb">
			<tr>
				<td>
				<input type="button" class="onumBuyBtn" id="reqbtnModify" value="수정">				
				</td>
				<td>
				<input type="button" class="onumBuyBtn" id="reqbtnDelete" value="삭제">
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="button" class="onumBuyBtn" id="reqbtnList" value="목록">  				
				</td>
			</tr>
			<tr>
				<td>
				<input type="button" class="onumBuyBtn" id="reqbtnReject" value="반려">				
				</td>
				<td>
				<input type="button" class="onumBuyBtn" id="reqbtnAccept" value="승인">				
				</td>
			</tr>
		
		</table>
	    </div>
	</div>                                          
</div>

</div>
</form>
</main>


<script>
	let form = document.getElementById("reqDetail");

// 사용자 : 목록 버튼 수정/ 승인, 반려 버튼 hide();/ 
	<%
	if(!memId.equals("ADMIN")){
	%>
	
		$("#reqbtnList").click(function(){
			location.href="<%=request.getContextPath()%>/view/page/ONUM/ReqList.jsp";
		});
	
	
		$("#reqbtnAccept").hide();
		$("#reqbtnReject").hide();	
	
	<%}%>
	
	
	
// 	관리자 : 승인 상태엔 승인버튼 및 수정 버튼 사용 불가/ 반려 상태에 반려 버튼 사용 불가
	
	<%
	if(status == 1){
	%>
		$("#reqbtnAccept").prop("disabled",true);
		$("#reqbtnModify").prop("disabled",true);
	<%}%>
	
	<%
		if(status == 2){
	%>
		$("#reqbtnReject").prop("disabled",true);
		$("#reqbtnModify").prop("disabled",false);
	<%}%>
	
	<%
		if(status == 3){
	%>
		$("#reqbtnAccept").prop("disabled",true);
		$("#reqbtnReject").prop("disabled",true);
		$("#reqbtnDelete").prop("disabled",true);
		$("#reqbtnModify").prop("disabled",true);
	<%}%>
	
	
	$("#reqbtnList").click(function(){
		
		<%
		if(memId.equals("ADMIN")){
		%> 
			location.href='<%=request.getContextPath()%>/view/page/ONUM/ReqList.jsp';	// 관리자면 신청내역			
		<%}else{%>
			location.href='<%=request.getContextPath()%>/view/page/ONUM/OnumMypage.jsp';	// 사용자면 본인 마이페이지	
		<%}%>
		
	})
	
	
	
	$("#reqbtnModify").click(function(){
		let form = document.getElementById("reqDetail");
		form.method = "GET";
		form.action="<%=request.getContextPath()%>/reqUpdate.do";
		form.submit();
	}) // #btnModify
	
	
	$("#reqbtnReject").click(function(){
		let delchk = confirm("해당 판매요청을 반려하시겠습니까?");

		if(delchk == true){
			form.action = "<%=request.getContextPath()%>/reqReject.do";
			form.submit();	
		}
		
	}) // #btnReject
	
	
	
	
	$("#reqbtnAccept").click(function(){

		let delchk = confirm("해당 판매요청 최종검토 후 최종승인해주시기 바랍니다.");
		
		if(delchk == true){
			
			form.action = window.open("ReqAccept.jsp?reqno=<%=reqno%>", "판매요청승인", "width=600 height=1000");
		}
		
		//일단 꼼수
		
	}) // #btnAccept
	
	$("#reqbtnDelete").click(function(){
		
		let delchk = confirm("해당 판매요청을 정말 삭제하시겠습니까?");

		if(delchk == true){
			form.action = "<%=request.getContextPath()%>/reqDelete.do";
			form.submit();			
		}
	})


</script>

</body>
</html>