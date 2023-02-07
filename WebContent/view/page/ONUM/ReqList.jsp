<%@page import="kr.or.ddit.vo.MemberVO"%>
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
<title>ONUM_REQ_LIST</title>
 
    <script
      src="https://code.jquery.com/jquery-3.6.1.js"
    ></script>

<!--     ✅ load DataTables ✅

 <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">
 -->


<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.11.4/r-2.2.9/datatables.min.css"/>
<%@include file="/WEB-INF/headMeta/headMain.jsp" %>

</head>


  
<body>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">
  
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>
<%@include file="/view/component/header.jsp" %>

<% 
    MemberVO member = (MemberVO)session.getAttribute("member");
    String memId ="";
    if(member == null){     // 비회원일 경우
        memId = "비회원";
    }else{
        memId = member.getMem_id(); // 회원일 경우           
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

<%
    ISalesRequestService service = SalesRequestServiceImpl.getInstance();
    List<SalesRequestVO> wlist = service.selectAllShowProd(0);  // 대기
    List<SalesRequestVO> alist = service.selectAllShowProd(1);  // 승인 
    List<SalesRequestVO> rlist = service.selectAllShowProd(2);  // 반려
    List<SalesRequestVO> slist = service.selectAllShowProd(3);  // 구매완료
    
%>
<div class="onum-admin onum-admin2">

<div class="onum-mypage__title">
    <h1>판매요청 리스트</h1>
</div>
<div class="onum-admin-list">

    <div class="onum-mypage__title">
        <h3>판매요청 대기건</h3>
    </div>
    
    
    <table class="onum-admin__tb" id="onumAdminWList">
        <thead>
        <tr>
            <th><b>상품번호</b></th>
            <th><b>신청인</b></th>
            <th><b>상품명</b></th>
            <th><b>리셀가</b></th>
            <th><b>신청일자</b></th>
            <th><b>신청상태</b></th>
        </tr>
        </thead>
        
        
            <%
                
            for(SalesRequestVO vo : wlist){
            %>
            <tbody>
            <tr>
                <td><a href="<%=request.getContextPath()%>/view/page/ONUM/ReqDetail.jsp?reqno=<%=vo.getReq_no()%>"><%=vo.getReq_no() %></a></td>
                <td><%=vo.getMem_id() %></td>
                <td><a href="<%=request.getContextPath()%>/view/page/ONUM/ReqDetail.jsp?reqno=<%=vo.getReq_no()%>"><%=vo.getOrigin_name() %></a></td>
                <% 
                String amount = String.valueOf(vo.getReq_price());
                amount = amount.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
                %>
                <td><%=amount %> 원</td>
                <td><%=vo.getReq_date().substring(0,11) %></td>
                
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
                <td><%=showstatus %></td>
            </tr>
            </tbody>
            <%} %> 
            
    </table>
</div>  
<div class="onum-admin-list">   
    <div class="onum-mypage__title">    
            <h3>판매요청 반려건</h3>
    </div>
    
    
    <table class="onum-admin__tb" id="onumAdminRList">
    <thead>
        <tr>
            <th><b>상품번호</b></th>
            <th><b>신청인</b></th>
            <th><b>상품명</b></th>
            <th><b>리셀가</b></th>
            <th><b>신청일자</b></th>
            <th><b>신청상태</b></th>
        </tr>
        </thead>
        
            <%
                
            for(SalesRequestVO vo : rlist){
            %>
            <tbody>
            <tr>
                <td><a href="<%=request.getContextPath()%>/view/page/ONUM/ReqDetail.jsp?reqno=<%=vo.getReq_no()%>"><%=vo.getReq_no() %></a></td>
                <td><%=vo.getMem_id() %></td>
                <td><a href="<%=request.getContextPath()%>/view/page/ONUM/ReqDetail.jsp?reqno=<%=vo.getReq_no()%>"><%=vo.getOrigin_name() %></a></td>
                <% 
                String amount1 = String.valueOf(vo.getReq_price());
                amount1 = amount1.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
                %>
                <td><%=amount1 %> 원</td>
                <td><%=vo.getReq_date().substring(0,11) %></td>
                
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
                <td><%=showstatus %></td>
            </tr>
            </tbody>
            <%} %> 
        
            
    </table>
</div>
<div class="onum-admin-list">   
    <div class="onum-mypage__title">    
            <h3>판매요청 승인건</h3>
    </div>
    <table class="onum-admin__tb" id="onumAdminAList">
    <thead>
        <tr>
            <th><b>상품번호</b></th>
            <th><b>신청인</b></th>
            <th><b>상품명</b></th>
            <th><b>리셀가</b></th>
            <th><b>신청일자</b></th>
            <th><b>신청상태</b></th>
        </tr>
        </thead>
            <%
                
            for(SalesRequestVO vo : alist){
            %>
            <tbody>
            <tr>
                <td><a href="<%=request.getContextPath()%>/view/page/ONUM/ReqDetail.jsp?reqno=<%=vo.getReq_no()%>"><%=vo.getReq_no() %></a></td>
                <td><%=vo.getMem_id() %></td>
                <td><a href="<%=request.getContextPath()%>/view/page/ONUM/ReqDetail.jsp?reqno=<%=vo.getReq_no()%>"><%=vo.getOrigin_name() %></a></td>
                <% 
                String amount2 = String.valueOf(vo.getReq_price());
                amount2 = amount2.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
                %>
                <td><%=amount2 %> 원</td>
                <td><%=vo.getReq_date().substring(0,11) %></td>
                
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
                <td><%=showstatus %></td>
            </tr>
            </tbody>
            <%} %> 
        
            
    </table>
</div>
<div class="onum-admin-list">   
    <div class="onum-mypage__title">    
            <h3>판매완료</h3>
    </div>
    <table class="table table-bordered returns_list_admin_table" id="onumSdminWList">
        <thead>
        <tr>
            <th><b>상품번호</b></th>
            <th><b>신청인</b></th>
            <th><b>상품명</b></th>
            <th><b>리셀가</b></th>
            <th><b>신청일자</b></th>
            <th><b>신청상태</b></th>
        </tr>
        </thead>
            <%
                
            for(SalesRequestVO vo : slist){
            %>
            <tbody>
            <tr>
                <td><a href="<%=request.getContextPath()%>/view/page/ONUM/ReqDetail.jsp?reqno=<%=vo.getReq_no()%>"><%=vo.getReq_no() %></a></td>
                <td><%=vo.getMem_id() %></td>
                <td><a href="<%=request.getContextPath()%>/view/page/ONUM/ReqDetail.jsp?reqno=<%=vo.getReq_no()%>"><%=vo.getOrigin_name() %></a></td>
                <% 
                String amount3 = String.valueOf(vo.getReq_price());
                amount3 = amount3.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
                %>
                <td><%=amount3 %> 원</td>
                <td><%=vo.getReq_date().substring(0,11) %></td>
                
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
                <td><%=showstatus %></td>
            </tr>
            </tbody>
            <%} %> 
        
            
    </table>
    </div>
</div>
<%-- <button onClick="location.href='<%=request.getContextPath()%>/ONUM/onumMain.do'">메인페이지</button > --%>

</body>
<script>
$('#onumSdminWList').DataTable({
    order: [[4, 'desc']],
    ordering: true,
    serverSide: false,
    searching: true,
    paging: true,
    pageLength: 5,
    lengthChange: false,
    info: false,
    "language": {
        "emptyTable" : "현재 판매 완료 상품이 없습니다."
    }
 });
 
$('#onumAdminWList').DataTable({
    order: [[4, 'desc']],
    ordering: true,
    serverSide: false,
    searching: true,
    paging: true,
    pageLength: 5,
    lengthChange: false,
    info: false,
    "language": {
        "emptyTable" : "현재 요청 대기 상품이 없습니다."
    }
 });
 
$('#onumAdminRList').DataTable({
    order: [[4, 'desc']],
    ordering: true,
    serverSide: false,
    searching: true,
    paging: true,
    pageLength: 5,
    lengthChange: false,
    info: false,
    "language": {
        "emptyTable" : "현재 반려된 상품이 없습니다."
    }
 });
 
$('#onumAdminAList').DataTable({
    order: [[4, 'desc']],    
    ordering: true,
    serverSide: false,
    searching: true,
    paging: true,
    pageLength: 5,
    lengthChange: false,
    zeroRecords: "일치하는 데이터가 없습니다.",
    info: false,
    "language": {
        "emptyTable" : "현재 승인된 상품이 없습니다."
    }
 });
</script>

</html>