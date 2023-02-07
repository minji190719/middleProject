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
<title>ReqAccept</title>
</head>
<body>

<%
	SalesRequestVO vo = null;
	ISalesRequestService service = SalesRequestServiceImpl.getInstance();
	String reqno = request.getParameter("reqno");
	vo = service.selectSalesRequest_req_no(reqno);
%>
<div class="ReqAccept__container">
<div class="onum-mypage__title">	
	<h3>ONUM 판매 등록</h3>
</div>
	
	<input type="hidden" id="reqno" name="reqno" value="<%=vo.getReq_no() %>">
<table id="ReqUpdateForm__tb">
	<tr>
		<td colspan="2"><img src="/nikepro/images/usedprod/<%=vo.getReq_photo()%>" width="200" height="140"></td>
	</tr>
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
				String amount = String.valueOf(vo.getReq_price());
				amount = amount.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
			%>
		<td>리셀가</td>
		<td><%=amount %></td>
	</tr>
	<tr>
		<td>상품설명</td>
		<td><%=vo.getReq_detail() %></td>
	</tr>
	<tr>
		<td>품질</td>
		<td>
			<input type="radio" id="quality" name="quality" value="1"> ★
			<input type="radio" id="quality" name="quality" value="2"> ★★
			<input type="radio" id="quality" name="quality" value="3"> ★★★
			<input type="radio" id="quality" name="quality" value="4"> ★★★★
			<input type="radio" id="quality" name="quality" value="5"> ★★★★★
		</td>
	</tr>
	<tr colspan="2">
		<td colspan="2">
			<input type="button" class="onumBuyBtn" id="btnList" value="닫기" onclick=window.close()> 
			<input type="submit" class="onumBuyBtn" id="btnAccept" value="최종승인">

		</td>
	</tr>
	
</table>
</div>

<script>
	$("#btnAccept").click(function(){
		$.ajax({
			url: "<%=request.getContextPath()%>/reqAccept.do",
			type: "get",
			data: {"reqno" : reqno},
			success : function(res){		
				if(res.result > 0){
					alert("승인이 완료되었습니다")
					window.close();
				}else{
					alert("승인에 실패했습니다")
					window.close();
				}
				
			},// seccess
			error : function(xhr){
				alert("상태 : " + xhr.status)
			},
			dataType: "text"
		}) // ajax
		
		
	})//#btnAccept
	
	
document.getElementById('btnAccept').onclick = function(){
	let reqno = document.getElementById("reqno").value;
    let star = document.querySelector('input[name="quality"]:checked').value;
    
	const request = new XMLHttpRequest();

	request.open('post', '/nikepro/reqAccept.do', true);
	request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	request.send("reqno=" + reqno + "&star=" + star); //get방식으로 보냈더니 send에 보낸 데이터 인식안됨. post만 가능.

	request.onreadystatechange = function () {
    if (request.readyState === 4 && request.status === 200) {
    		let data = request.response;
    		alert(data);
    		opener.parent.location = "/nikepro/view/page/ONUM/ReqList.jsp";
    		//opener.parent.location.reload();
    		window.close();
    	}
	 }
	 
}
	
	
	
</script>
</body>
</html>