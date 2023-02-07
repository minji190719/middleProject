<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="kr.or.ddit.vo.UsedProdVO"%>
<%@page import="kr.or.ddit.usedprod.service.UsedProdServiceImpl"%>
<%@page import="kr.or.ddit.usedprod.dao.UsedProdDaoImpl"%>
<%@page import="kr.or.ddit.usedprod.service.IUsedProdService"%>
<%@page import="kr.or.ddit.vo.SalesRequestVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.salesrequest.service.SalesRequestServiceImpl"%>
<%@page import="kr.or.ddit.salesrequest.service.ISalesRequestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
<%@include file="/WEB-INF/headMeta/headMain.jsp" %>
<title>ONUM</title>
</head>
<body>


<%@include file="/view/component/header.jsp" %>
<% 
	MemberVO member = (MemberVO)session.getAttribute("member");
	String memId ="";
	if(member == null){		// 비회원일 경우
		memId = "비회원";
	}else{
		memId = member.getMem_id();	// 회원일 경우 			
	}
	

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



<main>
	
	<%
	ISalesRequestService service = SalesRequestServiceImpl.getInstance();
	List<SalesRequestVO> alist = service.selectAllShowProd(1);	// 승인
	List<SalesRequestVO> slist = service.selectAllShowProd(3);	// 판매완료
	
	IUsedProdService service2 = UsedProdServiceImpl.getInstance();
	%>
	<div class="onum-main-container">
  	<%  for(SalesRequestVO reqvo : alist){
		UsedProdVO uvo = service2.selectUsedProd(reqvo.getReq_no());
	%>
	
		<div class="onum-main-item" idx=<%=reqvo.getReq_no()%>>
			<div class="onum-main-item__img">
				<a href="<%=request.getContextPath() %>/showUsedProd.do?reqno=<%=reqvo.getReq_no()%>"><img src="/nikepro/images/usedprod/<%=reqvo.getReq_photo()%>"></a>
			</div>
			<div class="onum-main-item__contents">
				<% 
				String amount = String.valueOf(reqvo.getReq_price());
				amount = amount.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
				%>
				<div class="onum-main-item__price"><%=amount %> 원</div>
				<div class="onum-main-item__title"><a href="<%=request.getContextPath() %>/showUsedProd.do?reqno=<%=reqvo.getReq_no()%>"><span><%=reqvo.getOrigin_name() %></span></a></div>
				<%
					String star ="";
					switch((String)uvo.getU_prod_quality()){
						case "1": star = "★"; break;
						case "2": star = "★★"; break;
						case "3": star = "★★★"; break;
						case "4": star = "★★★★"; break;
						case "5": star = "★★★★★"; break;
					}
				%>

				    <div class="onum-main-item__qual"><%=star %></div>
                </div>
			</div>
 	<%}%> 
 	
<!-------------------------------------  	판매완료 ------------------------------------->
  	<%  for(SalesRequestVO reqvo : slist){
		UsedProdVO uvo = service2.selectUsedProd(reqvo.getReq_no());
	%>
	
		<div class="onum-main-item" idx=<%=reqvo.getReq_no()%>>
			<div class="onum-main-item__img">
				<img id="soldout" src="/nikepro/images/usedprod/<%=reqvo.getReq_photo()%>">
			</div>
			<div class="onum-main-item__contents">
				<% 
				String amount = String.valueOf(reqvo.getReq_price());
				amount = amount.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
				%>
				<div class="onum-main-item__price"><%=amount %> 원</div>
				<div class="onum-main-item__title"><span><%=reqvo.getOrigin_name() %></span></div>

				    <div class="onum-main-item__qual">판매완료</div>
                </div>
			</div>
 	<%}%> 
	

	</div>
</main>


</body>
</html>