<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<head>
<title>qna_update_title</title>
<style>
.qna_update_btn_container{
	width: 1000px;
	margin: 0 auto;
	text-align: center;	
}

.qna_update_btn_container input{
	display: inline-block;
	background-color: rgba(128, 128, 128, 0.187);
	border-radius: 20px;
	padding: 5px 10px;
	margin: 5px;
}
</style>
</head>


<tag:main>
<jsp:include page="/view/component/header.jsp"></jsp:include>
	<br><br><br><br>
	<h1 class="qna_update_title">Q&A 제목 수정하기</h1><br>
	<br><br>
    <div id="target" class="qna_update_target">
        새로운 제목 : <input type="text" id="newData" autofocus>
    </div>
    <br>
    <div class="qna_update_btn_container"> 
	    <input type="button" value="수정" id="qna_updateBtn"><br>
	    <input type="button" value="목록보기" onclick="location.href='/nikepro/view/page/qna/qna_main.jsp'">
	</div>
	<br><br>
<%@ include file="/view/component/footer.jsp" %>
</tag:main>

<script>
    const urlSearch = new URLSearchParams(location.search);
    let qna_no = urlSearch.get('qna_no');


    document.getElementById('qna_updateBtn').onclick = function () {
        let newData = document.getElementById('newData').value;
        const request = new XMLHttpRequest();

        request.open("post", "/nikepro/QnaUpdate.do", true);
        request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        request.send("qna_no=" + qna_no + "&column=qna_title&data=" + newData );

        request.onreadystatechange = function () {

            if (request.readyState === 4 && request.status === 200) {
                let data = request.response;
                let str = JSON.parse(data);

                let code = "";
                code += "<table border='1' class='qna_update_table'>";
                code += "<tr><td>글번호</td><td>제목</td><td>작성자</td><td>작성일</td></tr>";
                code += "<tr><td>" + str.qna_no + "</td><td>" + str.qna_title
                    + "</td><td>" + str.mem_id + "</td><td>" + str.qna_date + "</td></tr>";
                code += "<tr><td>" + str.qna_content + "</td></tr>";
                code += "</table>";

                let target = document.getElementById('target');
                target.innerHTML = code;
            }

        }

    }

</script>