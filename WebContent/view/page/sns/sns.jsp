<%@page import="kr.or.ddit.vo.SnsVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>

<head>
<title>SNS MAIN</title>
<style>
div {
    display: flex;
    justify-content: space-around;
    align-items: flex-start;
}


img { 
/*    max-width: 100%;  */
/*    max-height: 100%;  */
	width: 100%; 
	height: 100%; 
	object-fit: cover;
	filter: brightness(1);
 } 
 
img:hover {
	filter: brightness(0.4);
}

*:focus {
    outline : none;
}

/* ::-webkit-input-placeholder { /* Chrome/Opera/Safari */ */
/*     color: red; */
/* } */
</style>
</head>

<tag:social>

<div class="sns-body">

	
<!-- 	<div class="sns_all_container"> -->
	<!--header-->
	<nav class="navbar">
		<div class="nav_wrap">
		
			<a href="${pageContext.request.contextPath}/home.do">
			<img class="snslogo" src="${pageContext.request.contextPath}/images/nikeLogo.png" alt="nikeLogo.png">
			</a>
			<!-- 커뮤니티 게시판 검색 기능 -->
				<input type="text" class="search_box" name="search_box" id="search_box" 
				    onkeyup="enterkey()" placeholder="상품명을 입력하세요.">

			<!-- 오른쪽 상단 아이콘. 게시물 추가 아이콘 -->
			<div class="nav_icons">
				<a href="/nikepro/snsMain.do"><!-- 커뮤니티 홈 아이콘 -->
				<i class="icon fa-sharp fa-solid fa-house"></i> 
				</a>
				<!-- 사진 업로드 데이터 전송 아이콘 -->
				<a data-toggle="modal" href="#sns_modal">
				<i class="icon fa-regular fa-square-plus"></i>
				</a> 
				
				<!-- 좋아요 목록 -->
				<a href="/nikepro/snsLikeList.do">
				<i class="icon fa-regular fa-heart"></i></a>
				
<!-- 				<div class="icon user_profile"> -->
					<!-- 내가 작성한 게시글 보여주기 -->
				<a href="javascript:mypage();"><i class="icon fa-solid fa-user"></i></a>
<!-- 				</div> -->
			</div>
		</div>

	</nav>

	<div class="main_container">
	<!-- section -->
<!-- 	<div class="sns__btns"> -->
<!-- 		<input type="button" value="삭제하기" id="sns_delete" > -->
<!-- 		<input type="button" value="수정하기" id="sns_update" > -->
<!-- 	</div><hr> -->
		<div class="main_list" id="main_list">
		<%-- 업로드하는 상품사진 --%>
		</div>
	</div>
	
	<!--sns_main_container -->
  </div>
<!-- The Modal -->
<div class="modal" id="sns_modal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">새 게시물</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <form id="sns_form" method="post" enctype="multipart/form-data">
                            
               <label>Title </label>
               <input type="text" class="txt" id="sns_title" name="sns_title"><br><br>
                           
               <label>Text </label><br><br>
               <textarea  rows="10"  class="txt" cols="50" id="sns_content" name="sns_content" placeholder="내용을 입력해 주세요."></textarea>
               <br><br>
               <!-- 파일선택 -->
               <label class="sns_file_button" for="sns_photo">사진 선택</label>
               <input type="file" class="txt" id="sns_photo" name="sns_photo" accept="image/*"><br><br>
               
               <select name="sprod_list" id="sprod_list"  multiple="multiple" style="width:300px;height:100px;">
               
               </select>
               
<!--                작성 전송버튼 -->
<!--                <input type="button" value="작성" id="sns_send"> -->
              
          </form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
      <!-- 작성 전송버튼 -->
        <button type="button" class="sns_close_button" data-dismiss="modal" id="modalClose">취소하기</button>
        <input type="button" value="저장하기" id="sns_send">
      </div>

    </div>
  </div>
</div>

<div id="list_content">
</div>

<!-- </div> -->



<script>
$(function(){
 $.ajax({
	type: 'get',
	url: '/nikepro/snsSelectProd.do',
	success: function(res){
		console.log(res);
		var code = '';
		
		$.each(res, function(i, v){
			code +=  '<option value="' + v.prod_name + '">' + v.prod_name + '</option>';
			
		});
		$('#sprod_list').html(code);
	},
	error : function(xhr){
		alert(xhr.status);
	},
	dataType: "json"
 })//ajax
}); 
</script>
</tag:social>

<script src="${pageContext.request.contextPath}/js/sns.js"></script>


