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
<%@include file="/WEB-INF/headMeta/headMain.jsp" %>
<title>ONUM_My_Page</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
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
    List<SalesRequestVO> list = service.selectSalesRequest_writer(member.getMem_id());
	%>
    <div class="onum-main-container">
    <div class="onum-mypage__title">    
        <h3><%=member.getMem_id() %> 중고물품 판매요청 내역</h3>
        <button  id="OnumInsertBtn" type="button" data-toggle="modal" data-target="#wModal">중고상품등록</button>
    </div>
        <% 
        if(list == null){
        %>	
        	<span>등록된 중고물품이 없습니다</span>
        <%} 
        
        for(SalesRequestVO vo : list){
        %>
        <div class="onum-main-item" idx=<%=vo.getReq_no()%>>
            <div class="onum-main-item__img">
                <a href="<%=request.getContextPath() %>/view/page/ONUM/ReqDetail.jsp?reqno=<%=vo.getReq_no()%>&user=1">
                <img src="/nikepro/images/usedprod/<%=vo.getReq_photo()%>" alt="/nikepro/images/usedprod/<%=vo.getReq_photo()%>">
                </a>
            </div>
            <div class="onum-main-item__contents">
            	<% 
				String amount = String.valueOf(vo.getReq_price());
				amount = amount.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
				%>
            <div class="onum-main-item__price"><%=amount %> 원</div>
<%--             <div class="onum-main-item__price"><span>등록일 : <%=vo.getReq_date()%></span></div> --%>
                <div class="onum-main-item__price"><a href="<%=request.getContextPath() %>/view/page/ONUM/ReqDetail.jsp?reqno=<%=vo.getReq_no()%>&user=1"><span><%=vo.getOrigin_name() %></span></a></div>
        
        
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
                <div class="onum-main-item__title" id="status"><span><%=showstatus %></span></div>
                
            </div> 
        </div>
        <%} %> 
    </div>


</main>



    <!---------------------------------------- The Modal ---------------------------------------->
    <div class="modal" id="wModal">
      <div class="modal-dialog">
        <div class="modal-content">
    
          <!-- Modal Header -->
          <div class="modal-header" id="onumInsertHeader">
            <h4 class="modal-title">중고상품등록</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>

          <!-- Modal body -->
          <div class="modal-body" id="onumInsertBody">
                <form id="wform" enctype="multipart/form-data">
                
                    
<!------------- 회원 아이디 세션 추가 필요 ------------->
                    
                            
                   <input type="hidden" id="memid" name="memid" value="<%=member.getMem_id()%>">
                    
                   <!-- 본인 구매목록에서 select 할 수 있도록 변경...! -->
                   <label>제품명 </label>
                   <input type="text" class="txt" id="origin_name" name="origin_name"><br>
                   
                   <label>원가 </label>
                   <input type="text" class="txt" id="origin_price" name="origin_price"><br>
                   
                   <label>리셀가 </label>
                   <input type="text"  class="txt" id="req_price" name="req_price"><br>                
                   
                   <label>상품설명 </label><br>
                   <textarea rows="10"  class="txt" cols="50" id="req_detail" name="req_detail"></textarea><br>
                  
                   <div class="filebox">
                       <input class="onum-upload-name" value="첨부파일" placeholder="첨부파일">
                       <label for="reqFile">파일찾기</label> 
                       <input type="file" id="reqFile">
                   </div>
<!--                   <label>상품사진 </label> -->
<!--                   <input type="file"  class="file" id="req_photo" name="req_photo"><br> -->
                   <br>
              </form>
          </div>
    
          <!-- Modal footer -->
          <div class="modal-footer">
            <input type="button" id="onumInsertSubmit" value="전송">
            <button type="button" class="btn btn-danger" id="onumInsertClose" data-dismiss="modal">Close</button>
          </div>
    
        </div>
      </div>
</div>

<script>

const statuses = document.querySelectorAll("#status span")

statuses.forEach(function(item){
    console.log(item)
    if(item.textContent == "승인" ){
        item.style.color= "#41a172"
    }else if(item.textContent == "반려"){
        item.style.color= "#9e3552"
    }
})


/////////////////////////// 모 달 /////////////////////////// 
    $("#reqFile").on('change',function(){
    var fileName = $("#reqFile").val();
     $(".onum-upload-name").val(fileName);
      });
    
    

    // 글쓰기 모달창에서 전송버튼 클릭 이벤트
    $("#onumInsertSubmit").click(function(){
        // 입력한 모든 값을 가져온다
//      indata = $("#wform").serializeJSON();
        
        let formData = new FormData();
        formData.append("mem_id", $("#memid").val());
        formData.append("origin_name", $("#origin_name").val());
        formData.append("origin_price", $("#origin_price").val());
        formData.append("req_price", $("#req_price").val());
        formData.append("req_photo", $("#reqFile")[0].files[0]);
        formData.append("req_detail", $("#req_detail").val());
        
        
        // 서버로 전송
        $.ajax({
            url:"<%=request.getContextPath()%>/reqInsert.do",
            type:"post",
            data : formData,
            processData : false,
            contentType : false,
            success: function(res){
                if(res > 0 ){
                    alert("판매 요청이 완료되었습니다.")               
                    location.reload();
                }else{
                    alert("등록 실패..")
                }
                
            },
            error: function(xhr){
                alert("상태 :" + xhr.status)
            }           
            
        })
        
        $("#wModal").modal("hide");
        $("#wModal .txt").val("");
    })
    
</script>
</body>
</html>