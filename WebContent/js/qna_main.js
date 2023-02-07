    $(document).ready( function () {
//        $('#exampleTable').DataTable();
    } ); 

/*    function paging(index) {
        //index = 페이지 번호
        const request = new XMLHttpRequest();

        request.open("post", "/nikepro/QnaAllList.do", true);

        request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

        request.send("pageNumber=" + index);

        request.onreadystatechange = function () {
            if (request.readyState === 4 && request.status === 200) {
                let target = document.getElementById('target');
                let data = request.response;

                let str = JSON.parse(data);
    
                let code = "";
    
                code += '<table id="table_id" class="display" border="1">';
                code += "<thead><tr><td>글번호</td><td>제목</td><td>작성자</td><td>작성일</td></tr></thead>";
                code += '<tbody>';
                for (let i = 0; i < str.length; i++) {
                    code += "<tr><td>" + str[i].qna_no + "</td>";
                    code += "<td><a href='/nikepro/view/page/qna/qna_detail.jsp?qna_no=" + str[i].qna_no + "'>" + str[i].qna_title + "</a></td>";
                    code += "<td>" + str[i].mem_id + "</td>";
                    code += "<td>" + str[i].qna_date + "</td></tr>";
                }
                code += '</tbody>';
    
                code += "</table>";

                if ( index > 1 ) code += "<a href='javascript:paging("+ parseInt(index - 1) +");'>" + "이전페이지</a>";

                if (index <= 3  && index <= (totalPageNumber/10) + 1) {
                    
                    for (let i = 1; i < 6; i++) {
                        code += "<a href='javascript:paging("+ i +");'>" + i + "</a>";
                    }
                    
                } else {

                    for (let i = index-2; i < index+3; i++) {
                        code += "<a href='javascript:paging("+ i +");'>" + i + "</a>";
                    }
                    
                }
                
                if ( index < Math.ceil(totalPageNumber/10) && index > 1) code += "<a href='javascript:paging("+ parseInt(index + 1) +");'>다음페이지</a>";
                target.innerHTML = code;
            }
        }
    }*/
/*    let totalPageNumber = 0; //토탈 게시글 수를 저장.
    const pageLength = 10; //한 페이지에 보여줄 게시글 수 
    
    
    window.addEventListener('DOMContentLoaded', function() {
        let request = new XMLHttpRequest();

    request.open("get", "/nikepro/QnaCount.do", true);

    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    request.send();

    request.onreadystatechange = function() {
        if (request.readyState === 4 && request.status === 200) {
            let target2 = document.getElementById("exampleTable");
            let data = request.response;
            */
            //totalPageNumber에 값 저장
           // totalPageNumber = data; //(총 게시글 수 / 10) => 페이지 갯수
            //let code = "";
            
 /*            for (let i = 1; i < 6; i++) {
                code += "<a href='javascript:paging("+ i +");'>" + i + "</a>";
            } */

/*            target2.innerHTML = code;
        }

    }

    });       */                                                                                        
/* 1 == 1 10 --> index*10-10+1, index*10
2 == 11 20 --> index*10-10+1, index*10
3 == 21 30 --> index*10-10+1, index*10
4 == 31 40 --> index*10-10+1, index*10 */



    window.onload = function() { 
        
    const request = new XMLHttpRequest();

    request.open("post", "/nikepro/QnaAllList.do", true);

    request.setRequestHeader("Content-Type", "application/json");

    request.send();

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            let target = document.getElementById('target');
            let target2 = document.getElementById('exampleTable');
            let data = request.response;

            let str = JSON.parse(data);

            let code = "";

            //code += '<table id="table_id" class="display" border="1">';
            code += "<thead><tr><td>글번호</td><td>제목</td><td>작성자</td><td>작성일</td></tr></thead>";

            code += '<tbody>';
            for (index in str) {
                code += "<tr><td>" + str[index].qna_no + "</td>";
                code += "<td><a href='/nikepro/view/page/qna/qna_detail.jsp?qna_no=" + str[index].qna_no + "'>" + str[index].qna_title + "</a></td>";
                code += "<td>" + str[index].mem_id + "</td>";
                code += "<td>" + str[index].qna_date + "</td></tr>";
            }
/*            for (let i = 0; i < 10; i++) {
                code += "<tr><td>" + str[i].qna_no + "</td>";
                code += "<td><a href='/nikepro/view/page/qna/qna_detail.jsp?qna_no=" + str[i].qna_no + "'>" + str[i].qna_title + "</a></td>";
                code += "<td>" + str[i].mem_id + "</td>";
                code += "<td>" + str[i].qna_date + "</td></tr>";
            }
*/            
            code += '</tbody>';

            //code += "</table>";

/*            for (let i = 1; i < 6; i++) {
                code += "<a href='javascript:paging("+ i +");'>" + i + "</a>";
            }*/

            target2.innerHTML = code;
            $('#exampleTable').DataTable({
                order:[[3, 'desc']],
                ordering: true,
                serverSide: false,
                searching: false,
           	    lengthChange: false,
           	    info: false
            });
        }
    }
    
    }
    
    document.getElementById('searchBtn_title').onclick = function () {
        let searchTitle = document.getElementById('searchTitle').value;
        const request = new XMLHttpRequest();
        request.open("post", "/nikepro/QnaSearch_title.do", true);
        request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        request.send("qna_title=" + searchTitle);

        request.onreadystatechange = function () {

            if (request.readyState === 4 && request.status === 200) {
                let target = document.getElementById('target');
                let data = request.response;

                let str = JSON.parse(data);

                let code = "";
				code += "<h2>검색하신 결과는 다음과 같습니다.</h2>";
				code += "<br>";	
                code += "<table border='1' class='qna_search'>";
                code += "<tr><td>글번호</td><td>제목</td><td>작성자</td><td>작성일</td></tr>";

                for (index in str) {
                    code += "<tr><td>" + str[index].qna_no + "</td>";
                    code += "<td><a href='/nikepro/view/page/qna/qna_detail.jsp?qna_no=" + str[index].qna_no + "'>" + str[index].qna_title + "</a></td>";
                    code += "<td>" + str[index].mem_id + "</td>";
                    code += "<td>" + str[index].qna_date + "</td></tr>";
                }

                code += "</table>";

                target.innerHTML = code;
            }
        }
    }
    
    document.getElementById('searchBtn_mem_id').onclick = function () {
        let mem_id = document.getElementById('searchMem_id').value;
        const request = new XMLHttpRequest();

        request.open("post", "/nikepro/QnaSearch_mem_id.do", true);
        request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        request.send("mem_id=" + mem_id);

        request.onreadystatechange = function () {

            if (request.readyState === 4 && request.status === 200) {
                let target = document.getElementById('target');
                let data = request.response;

                let str = JSON.parse(data);

                let code = "";

				code += "<h2>검색하신 결과는 다음과 같습니다.</h2>";	
				code += "<br>";			
                code += "<table border='1' class='qna_search'>";
                code += "<tr><td>글번호</td><td>제목</td><td>작성자</td><td>작성일</td></tr>";

                for (index in str) {
                    code += "<tr><td>" + str[index].qna_no + "</td>";
                    code += "<td><a href='/nikepro/view/page/qna/qna_detail.jsp?qna_no=" + str[index].qna_no + "'>" + str[index].qna_title + "</a></td>";
                    code += "<td>" + str[index].mem_id + "</td>";
                    code += "<td>" + str[index].qna_date + "</td></tr>";
                }

                code += "</table>";

                target.innerHTML = code;
            }
        }
    }
    
    
