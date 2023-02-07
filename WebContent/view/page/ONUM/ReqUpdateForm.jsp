<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="kr.or.ddit.salesrequest.service.SalesRequestServiceImpl"%>
<%@page import="kr.or.ddit.salesrequest.service.ISalesRequestService"%>
<%@page import="kr.or.ddit.vo.SalesRequestVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.1.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
<title>ONUM_REQ_Update</title>
</head>
<body>
<%
		//////////////////////////////////
		HttpSession session2 = request.getSession();
	      
	    MemberVO member = (MemberVO) session2.getAttribute("member");
	        
	    String memId = member.getMem_id();
	    //////////////////////////////////////

	SalesRequestVO vo = (SalesRequestVO)request.getAttribute("reqVo");
%>

<header>
	      <div class="menu-bar">
            <div class="menu-bar__left">
                <a href="<%=request.getContextPath() %>/home.do">
                    <div>
                        <svg
                            height="24px"
                            width="24px"
                            fill="#111"
                            viewBox="0 0 26 32"
                        >
                            <path
                                d="M14.4 5.52v-.08q0-.56.36-1t.92-.44 1 .36.48.96-.36 1-.96.4l-.24.08.08.12-.08.44-.16 1.28q.08.08.08.16l-.16.8q-.08.16-.16.24l-.08.32q-.16.64-.28 1.04t-.2.64V12q-.08.4-.12.64t-.28.8q-.16.32 0 1.04l.08.08q0 .24.2.56t.2.56q.08 1.6-.24 2.72l.16.48q.96.48.56 1.04l.4.16q.96.48 1.36.84t.8.76q.32.08.48.24l.24.08q1.68 1.12 3.36 2.72l.32.24v.08l-.08.16.24.16h.08q.24.16.32.16h.08q.08 0 .16-.08l.16-.08q.16-.16.32-.24h.32q.08 0 0 .08l-.32.16-.4.48h.56l.56.08q.24-.08.4-.16l.4-.24q.24-.08.48.16h.08q.08.08-.08.24l-.96.88q-.4.32-.72.4l-1.04.72q-.08.08-.16 0l-.24-.32-.16-.32-.2-.28-.24-.32-.2-.24-.16-.2-.32-.24q-.16 0-.32-.08l-1.04-.8q-.24 0-.56-.24-1.2-1.04-1.6-1.28l-.48-.32-.96-.16q-.48-.08-1.28-.48l-.64-.32q-.64-.32-.88-.32l-.32-.16q-.32-.08-.48-.16l-.16-.16q-.16 0-.32.08l-1.6.8-2 .88q-.8.64-1.52 1.04l-.88.4-1.36.96q-.16.16-.32 0l-.16.16q-.24.08-.32.08l-.32.16v.16h-.16l-.16.24q-.16.32-.32.36t-.2.12-.08.12l-.16.16-.24.16-.36-.04-.48.08-.32.08q-.4.08-.64-.12t-.4-.6q-.16-.24.16-.4l.08-.08q.08-.08.24-.08h.48L1.6 26l.32-.08q0-.16.08-.24.08-.08.24-.08v-.08q-.08-.16-.08-.32-.08-.16-.04-.24t.08-.08h.04l.08.24q.08.4.24.24l.08-.16q.08-.16.24-.16l.16.16.16-.16-.08-.08q0-.08.08-.08l.32-.32q.4-.48.96-.88 1.12-.88 2.4-1.36.4-.4.88-.4.32-.56.96-1.2.56-.4.8-.56.16-.32.4-.32H10l.16-.16q.16-.08.24-.16v-.4q0-.4.08-.64t.4-.24l.32-.32q-.16-.32-.16-.72h-.08q-.16-.24-.16-.48-.24-.4-.32-.64h-.24q-.08.24-.4.32l-.08.16q-.32.56-.56.84t-.88.68q-.4.4-.56.88-.08.24 0 .48l-.08.16h.08q0 .16.08.16h.08q.16.08.16.2t-.24.08-.36-.16-.2-.12l-.24.24q-.16.24-.32.2t-.08-.12l.08-.08q.08-.16 0-.16l-.64.16q-.08.08-.2 0t.04-.16l.4-.16q0-.08-.08-.08-.32.16-.64.08l-.4-.08-.08-.08q0-.08.08-.08.32.08.8-.08l.56-.24.64-.72.08-.16q.32-.64.68-1.16t.76-.84l.08-.32q.16-.32.32-.56t.4-.64l.24-.32q.32-.48.72-.48l.24-.24q.08-.08.08-.24l.16-.16-.08-.08q-.48-.4-.48-.72-.08-.56.36-.96t.88-.36.68.28l.16.16q.08 0 .08.08l.32.16v.24q.16.16.16.24.16-.24.48-.56l.4-1.28q0-.32.16-.64l.16-.24v-.16l.24-.96h.16l.24-.96q.08-.24 0-.56l-.32-.8z"
                            ></path>
                        </svg>
                    </div>
                </a>
 
            </div>
            <div class="menu-bar__right">
                <a href="${pageContext.request.contextPath}/view/page/qna/index.jsp"><span>고객센터</span></a><!-- 우선qna게시판에연결 -->
                <span>&nbsp;|&nbsp;</span>

                <c:choose>
                
                    <c:when test="${sessionScope.member == null}">
                        <a href="${pageContext.request.contextPath}/signUp.do"><span>가입하기</span></a>
                        <span>&nbsp;|&nbsp;</span>
                        <a href="${pageContext.request.contextPath}/login.do"><span>로그인</span></a>
                    </c:when>
                    
                    <c:otherwise>
        				<a href="${pageContext.request.contextPath}/member/myPage.do"><span>${sessionScope.member.getMem_name()}님, 안녕하세요</span></a>
                        <span>&nbsp;|&nbsp;</span>
                        <a href="${pageContext.request.contextPath}/logout.do"><span>로그아웃</span></a>
                    </c:otherwise>
                    
                </c:choose>

            </div>
        </div>
	<div class="onum-main-header__menu">
		<a href="<%=request.getContextPath() %>/ONUM/onumMain.do">ONUM</a>

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
		<h3>판매요청 수정</h3>
</div>


<div class="onum-main">
<div class="onum-detail-container">

<form action="<%=request.getContextPath()%>/reqUpdate.do" method="post" enctype="multipart/form-data">
<%-- 	<input type="hidden" id="user" name="user" value="<%=user %>"> --%>
	<input type="hidden" id="reqno" name="reqno" value="<%=vo.getReq_no() %>">
	<input type="hidden" id="memid" name="memid" value="<%=vo.getMem_id() %>">
	<input type="hidden" id="old_photo" name="old_photo" value="<%=vo.getReq_photo() %>">
	
	
	<div id="reqUpadateImg">
		<img src="/nikepro/images/usedprod/<%=vo.getReq_photo()%>">
	</div>
<table id="ReqUpdateForm__tb">
<!-- 	<tr> -->
<%-- 		<td colspan="2"><img src="/nikepro/images/usedprod/<%=vo.getReq_photo()%>" width="200" height="200"></td> --%>
<!-- 	</tr> -->
	<tr>
		<td>신청번호</td>
		<td><%=vo.getReq_no() %></td>
	</tr>
	<tr>
		<td>신청인</td>
		<td><%=vo.getMem_id() %></td>
	</tr>
	<tr>
		<td>상품명</td>
		<td><input type="text" name="prodName" value="<%=vo.getOrigin_name() %>"></td>
	</tr>
	<tr>
		<td>원가</td>
		<td><input type="text" name="Origin_price" value="<%=vo.getOrigin_price() %>"></td>
	</tr>
	<tr>

		<td>리셀가</td>
		<td><input type="text" name="Req_price" value="<%=vo.getReq_price() %>"></td>
		
	</tr>
	<tr>
		<td colspan="2">상품설명</td>
	</tr>
			<%String detail = vo.getReq_detail().replaceAll("<br>","\n"); %>
	<tr>
		<td colspan="2">
		<textarea rows="10"  class="txt" cols="50" name="prodDetail" ><%=detail %></textarea> 
		</td>
	</tr>
	<tr>
		<td>상품사진</td>
		<td><input type="file" name="newphoto"></td>
	</tr>
			<%
			int status = vo.getReq_status();
				String showstatus = "";
			if(status == 0){
				showstatus = "대기";
			}else if(status == 1 ){
				showstatus = "승인";
			}else{
				showstatus = "반려";
			}
			
		%>
	
	<tr>
		<td>신청상태</td>
		<td><%=showstatus %></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="button" class="onumBuyBtn" id="btnList" value="목록" > 
			<input type="submit" class="onumBuyBtn" id="btnSave" value="저장">
		</td>
	</tr>
	
</table>
</form>
</div>
</div>
<script>

$("#btnList").click(function(){
	<%
	if(memId.equals("ADMIN")){
	%> 
		location.href='<%=request.getContextPath()%>/view/page/ONUM/ReqList.jsp';	// 관리자면 신청내역			
	<%}else{%>
		location.href='<%=request.getContextPath()%>/view/page/ONUM/OnumMypage.jsp';	// 사용자면 본인 마이페이지	
	<%}%>
})


</script>

</body>
</html>