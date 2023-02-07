<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<head>
<title>Q&A Main</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.11.4/r-2.2.9/datatables.min.css"/>


</head>

<tag:main>
<jsp:include page="/view/component/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">
  
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>
    <br><br><br><br>
    <h2 class="returns_insert_title">반품 대상 상품</h2>
    <hr>
    <div class="returns_insert_container1">
	    <table id="exampleTable" class="table table-bordered returns_insert_table1">	    
	    </table>
    </div>
    
    <hr>
    
    <div class="returns_insert_container2">
	    <h2>반품 사유를 기입해주세요</h2>
	    <br>
	    <table class="returns_insert_table2">
	    	<tr>
	    		<td>사유를 선택하세요</td>
	    		<td>
	    			<select name=returns_title" id="titleBox">
	    				<option value="구매의사취소" selected>구매의사취소</option>
	    				<option value="색상 및 사이즈 변경">색상 및 사이즈 변경</option>
	    				<option value="다른 상품 잘못 주문">다른 상품 잘못 주문</option>
	    				<option value="상품 정보 상이">상품 정보 상이</option>
	    				<option value="기타">기타</option>
	    			</select>
	    		</td>    		
	    	</tr>
	    	<tr>
	    		<td>내용을 입력하세요</td>
	    		<td><textarea placeholder="내용을 입력하세요." id="contentBox" name="notice_content"></textarea></td>    		
	    	</tr>
	    	<tr>
	    		<td colspan="2">    			
						<input type="button" value="작성하기" id="insertBtn">
						<input type="button" onclick="returns_list()" value="구매내역으로 돌아가기">
				</td>
	    	</tr>
	    </table> 
    </div>
    <br><br>
    
<%@ include file="/view/component/footer.jsp" %>
</tag:main>
<script>

function returns_list(){
	location.href = "<%=request.getContextPath()%>/returnsList.do";
	
}
    const urlSearch = new URLSearchParams(location.search);
    let cart_no = urlSearch.get("cart_no");

    document.getElementById("insertBtn").onclick = function () {
        let returns_title = document.getElementById("titleBox").value;
        let returns_content = document.getElementById("contentBox").value;
        const request = new XMLHttpRequest();

        request.open("post", "/nikepro/returnsInsert.do", true);

        request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

        request.send("cart_no=" + cart_no + "&returns_title=" + returns_title + "&returns_content=" + returns_content);

        request.onreadystatechange = function () {
            if (request.readyState === 4 && request.status === 200) {
                let data = request.response;
                alert(data);
                //반품작성목록으로 로케이션
                location.href = "/nikepro/returnsMyList.do";
            }
        }
    }

    window.onload = function () {
        const request = new XMLHttpRequest();

        request.open("post", "/nikepro/returnsList.do", true);

        request.setRequestHeader("Content-Type", "application/json");

        request.send("cart_no=" + cart_no);

        request.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                let target = document.getElementById("exampleTable");
                let data = request.response;

                if (data === "로그인을 해주세요.") {
                    alert(data);
                    location.href = "/nikepro/SnsMain.do";

                } else if (data === "구매 내역이 없습니다.") {
                    alert(data);
                    location.href = "/nikepro/SnsMain.do";

                } else {
                    let str = JSON.parse(data);
                    let code = "";

                    code += "<thead><tr><td>카트번호</td><td>상품코드</td><td>상품명</td><td>가격</td><td>결제일</td></tr></thead>";
                    code += '<tbody>';

                    for (index in str) {

                        if (str[index].cart_no === cart_no) {
                            code += "<tr><td>" + str[index].cart_no + "</td>";
                            code += "<td>" + str[index].prod_id + "</td>";
                            code += "<td>" + str[index].prod_name + "</td>";
                            code += "<td>" + str[index].prod_price + "</td>";
                            code += "<td>" + str[index].pay_date + "</td></tr>";

                        }

                    }

                    code += '</tbody>';
                    target.innerHTML = code;

                    $('#exampleTable').DataTable({
                        order: [[3, 'desc']],
                        ordering: true,
                        serverSide: false,
                        searching: false,
                        paging: false,
                    	lengthChange: false,
                    	info: false
                    });
                }
            }
        }
    }

</script>
