<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>

<head>
<title>SNS DETAIL</title>
<style>
img {
	width : 100%;
}


</style>

</head>


<tag:social>
	<!-- 전체 박스  -->
<div class="sns-body">
	<div class="sns_detail">
	<!-- header -->
	<nav class="navbar">
			<div class="nav_wrap_snsDetail">
				<div class="nav_icons_back" >
					<a href="/nikepro/snsMain.do">
					 <i class="iconBack fa-solid fa-arrow-left-long" style="font-size: 3em; font-weight: bold; text-decoration : none; color : black;"></i>
					</a>
				</div>
				
				<a href="${pageContext.request.contextPath}/home.do">
					<img class="snslogo" src="${pageContext.request.contextPath}/images/nikeLogo.png" alt="nikeLogo.png">&nbsp;&nbsp;&nbsp;&nbsp;
				</a>
			</div>
	</nav>
		
	       <!-- main -->
        <div class="main">
            <div class="main_out_container">
      		<div class="sns_main_menu"><i class="fa-solid fa-ellipsis"></i></div>
            <div class="container" id="container"> <!-- 여기를 타겟으로 해서 아이디를 뿌리자 -->
            <!-- 아이디 출력 -->
            	<div class="user_id">
            		<p>작성자 : <p>  
            	</div>
			<!-- 사진 출력 -->
				<div class="sns_detail_photo">	<!-- 사진 뿌리기 -->
					<img alt="" src="">
					<p>좋아요♡   개 <p>
				</div>
			<!-- 내용 출력 -->
				<div class="sns_content">	<!-- 내용 뿌리기 -->
					<p>내용 : </p>
				</div>
			<!-- 댓글 기능  -->
                         
           </div>
           <div class="sns_detail_underbox">
<!--            		<div class="sns_crud_btn"> -->
<!-- 					<input type="image" id="likeBtn"  src="https://cdn-icons-png.flaticon.com/512/2961/2961957.png">&nbsp;&nbsp;&nbsp; -->
<!-- 					<input type="image" id="updateBtn"  src="https://cdn-icons-png.flaticon.com/512/1827/1827933.png">&nbsp;&nbsp; -->
<!-- 					<input type="image" id="deleteBtn"  src="https://cdn-icons-png.flaticon.com/512/565/565491.png"> -->
<!-- 				</div> -->
           		<hr><br>
	            <div class="comment_list" id="comment_list">
	            </div>
	            
	          
	            
				<div class="sns_comment">
						<input type="text" id="comment_content" placeholder="댓글을 남겨보세요..">
						<input type="submit" id="commentBtn" value="게시">
<%-- 						<input type="image" src="${pageContext.request.contextPath}/images/nikeLogo.png" id="commentBtn"> --%>

				</div>
					
				<div class="sns_crud_btn">
					<input type="image" id="likeBtn"  src="https://cdn-icons-png.flaticon.com/512/2961/2961957.png">&nbsp;&nbsp;&nbsp;
					<input type="image" id="updateBtn"  src="https://cdn-icons-png.flaticon.com/512/1827/1827933.png">&nbsp;&nbsp;
					<input type="image" id="deleteBtn"  src="https://cdn-icons-png.flaticon.com/512/565/565491.png">
<!-- 					<input type="button" class="btn btn-dark" value="삭제하기" id="deleteBtn" /> -->
<!-- 					<input type="button" class="btn btn-dark" value="수정하기" id="updateBtn" /> -->
<!-- 					<input type="button" class="btn btn-dark" value="좋아요" id="likeBtn" /> -->
				</div>
		   </div>
       </div>
		</div>
    </div>
    </div>

<script>

const urlSearch = new URLSearchParams(location.search);
let sns_no = urlSearch.get('sns_no'); //url 쿼리스트링에서 sns_no값 저장

window.onload = function () {
    const request = new XMLHttpRequest();

    request.open("post", "/nikepro/snsDetail.do", true);

    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    request.send("sns_no=" + sns_no);

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
        	let target = document.getElementById("container");
			let data = request.response;
			let str = JSON.parse(data);

// 			alert(str.sns_content);

			let code="";
				
				code += '<div class="user">';
				code += '<div class="user_profile">';
				code += '<img class="img_profile" alt="프로필 사진" src="https://mblogthumb-phinf.pstatic.net/20151117_229/design_zz_1447767353353aoKk2_JPEG/C.JPG?type=w2">'
				code += '</div>';
				
				code += '<div class="sns_detail_head">'
				
				code += '<div class="user_id">';
                code += '<span style="font-family: Montserrat, Pretendard, sans-serif; font-weight : 700; color:#3c3c3c;">&nbsp;&nbsp;' + str.mem_id;
                code +=	'&nbsp;<img id="user_id_influencer" src="';
                code += 'data:image/png;base64,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">';
                code +='</span>';
                code += '</div>';
                
                code += '<div class="sns_date">';
                code += '<p style="font-family: Montserrat, Pretendard, sans-serif; color : #c8c0b9;">&nbsp;&nbsp;&nbsp;'+ str.sns_date +'</p>';
                code += '</div>';
                
                code += '</div>';
                
                code += '<div class="sns_detail_photo">' ;
                code += '<img src="/nikepro/images/sns/' + str.sns_photo + '">';
                code += '</div>';
                
                code += '<div class="sns_content_box">'
                
                code += '<div class="sns_likes">';
                code += '<p style="font-family: Montserrat, Pretendard, sans-serif; font-weight : bold; color:#3c3c3c;">좋아요<i class="fa-solid fa-heart" style="color:#ff3761;"></i>&nbsp' + str.sns_like + '개</p>';
                code += '</div>'
                code += '<br>'
                
                code += '<p style="font-family: Montserrat, Pretendard, sans-serif; color:#3c3c3c;">' + str.sns_title + '</p><br>'
                code += '<div class="sns_contents"> ';
               	code += '<p><span style="font-family: Montserrat, Pretendard, sans-serif; font-weight : bold; color:#3c3c3c;">' + str.mem_id + '&nbsp;&nbsp;</span>';
                code += '<span style="font-family: Montserrat, Pretendard, sans-serif;">' + str.sns_content + ' </span></p>';
                code += '</div><br>';
                
//             	code += '<p style="font-family: Montserrat, Pretendard, sans-serif; color : #c8c0b9;">착용 제품</p><br>';
            	code += '<hr><br><br>';
            	code += '<span style="font-family: Montserrat, Pretendard, sans-serif; color : #626262;">&nbsp;착용제품</span>'
            	
            	var prod_names = str.prod_name.split(',');
            	console.log(prod_names);
            	$.each(prod_names, function(i, v){
	            	code += '<div class="snsProd_name">';
	             	code += '<a href="/nikepro/snsProdDetail.do?prod_name=' + v  + '"  style="text-decoration: none";><span style="color : white;">' + v + '</span></a>';
				 	code += '</div>';
            	});
            	
			 	code += '</div>';
			 	
            target.innerHTML = code;
        }
    }
}

document.getElementById("deleteBtn").onclick = function () {

    const request = new XMLHttpRequest();

    request.open("post", "/nikepro/snsDelete.do", true);

    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    request.send("sns_no=" + sns_no );

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            let result = request.response;
            alert(result);
			location.href = "/nikepro/snsMain.do";
        }
    }
}

// sns게시글 수정 기능!
document.getElementById("updateBtn").onclick = function () {
    
	//sns_no
    let sns_content = prompt("내용만 수정할 수 있습니다. 수정할 내용을 입력하세요.");

    const request = new XMLHttpRequest();

    request.open("post", "/nikepro/snsUpdate.do", true);

    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    request.send("sns_no=" + sns_no + "&sns_content=" + sns_content);

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            let result = request.response;
            alert(result);

            location.href ="/nikepro/snsDetail.do?sns_no=" + sns_no;
        }
    }
}

// 좋아요 기능!
document.getElementById("likeBtn").onclick = function () {
    
	//sns_no

    const request = new XMLHttpRequest();

    request.open("post", "/nikepro/snsLike.do", true);

    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    request.send("sns_no=" + sns_no); //멤버아이디는 어떻게 보내줄 것인가

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            let result = request.response;
            alert(result);

            location.href ="/nikepro/snsDetail.do?sns_no=" + sns_no;
        }
    }
}

// 댓글 등록하기!!!
document.getElementById("commentBtn").onclick = function () {

    const request = new XMLHttpRequest();
    let str = document.getElementById("comment_content").value;

    request.open("post", "/nikepro/CommentInsert.do", true);

    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    request.send("sns_no=" + sns_no + "&com_content=" + str);

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            let result = request.response;
//             alert(result);
			location.href = "/nikepro/snsDetail.do?sns_no=" + sns_no;
        }
    }
}
// 댓글 삭제..!
function locations_delete (data) {
	
		 const request = new XMLHttpRequest();

	    request.open("post", "/nikepro/CommentDelete.do", true);

	    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	    request.send("com_no=" + data);
	    
	    request.onreadystatechange = function () {
	    	if (request.readyState === 4 && request.status === 200) {
	    		let result = request.response;
	    		
	    		alert(result);
	    		
	    		location.href= "/nikepro/snsDetail.do?sns_no=" + sns_no;
	    	}
	    }
	
}

// 댓글 유효성 검사
function locations_update (data) {
	
	const request = new XMLHttpRequest();
	
	request.open("post", "/nikepro/commentUpdate.do", true);
	
	request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    request.send("com_no=" + data);
	
    request.onreadystatechange = function () {
    	if (request.readyState === 4 && request.status === 200) {
    		let result = request.response;
    		
    		alert(result);
    		
    		if (result === "일치") {
    			let str = prompt("수정할 내용 입력 : ");
	    		locations_update2(str, data);
    		} else {
    			alert("본인의 댓글만 수정할 수 있습니다.");
    		    location.href= "/nikepro/snsDetail.do?sns_no=" + sns_no;
    		}
    		
    	}
    }
}

// 댓글 수정..!!
function locations_update2 (str, data) {
	
    const request = new XMLHttpRequest();
    
    request.open("post", "/nikepro/commentUpdate2.do", true);
    
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    request.send("com_no=" + data + "&com_content=" + str);
    
    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
        	let result = request.response;
            
            alert(result);
            
            location.href= "/nikepro/snsDetail.do?sns_no=" + sns_no;
        }
    }
}

// 댓글 리스트 뽑기~~~~
window.addEventListener( 'DOMContentLoaded', function () {
    const request = new XMLHttpRequest();

    request.open("post", "/nikepro/commentList.do", true);

    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    request.send("sns_no=" + sns_no);

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
        	let target = document.getElementById("comment_list");
			let data = request.response;
			let str = JSON.parse(data);

// 			alert(str.com_content);
//			css 안먹어서 코드에 직접 넣었어요!!!!!!!!!!!!
			let code="";
			 for (index in str) {
                code += '<div class="comment_detail">';
                code += '<p style="font-family: Montserrat, Pretendard, sans-serif;"><span  style="font-weight: 700;">&nbsp;&nbsp;' + str[index].mem_id +'</span>';
                code += '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ' + str[index].com_content ;
                code += '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color : #c8c0b9; font-size:0.8em;"> ' + str[index].com_date + '&nbsp;&nbsp;&nbsp;</span>'; 
                code += '<input type="image" style="width : 10px; height: 10px;" src="https://cdn-icons-png.flaticon.com/512/7175/7175371.png" onclick="locations_update(' +  str[index].com_no + ');">&nbsp;';
                code += '<input type="image" style="width : 10px; height: 10px;" src="https://cdn-icons-png.flaticon.com/512/1632/1632708.png" onclick="locations_delete(' +  str[index].com_no + ');">';
//                 code += '<input type="button" value="삭제" onclick="locations_delete(' +  str[index].com_no + ');">';
//                 code += '<input type="button" value="수정" onclick="locations_update(' +  str[index].com_no + ');">';
                code += '</p>';
                code += '</div><br>';
			 } 
            target.innerHTML = code;
        }
    }
})



</script>
	
</tag:social>

