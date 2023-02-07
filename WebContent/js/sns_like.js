/**
 * 
 */
function enterkey() {
    if (window.event.keyCode == 13) {

        let data = $('#search_box').val();
        // 엔터키가 눌렸을 때
        $.ajax({
            url: "/nikepro/snsSearch.do",
            type: "post",
            data: { "search_box": data }, //전송데이터
            success: function (data) {
//                alert("성공");

                let result = JSON.parse(data);
                let code = "";

                $.each(result, function (i, item) {
                    code += '<div class="pictures">';
                    code += '<a href="/nikepro/snsDetail.do?sns_no=' + item.sns_no + '"><img src="/nikepro/images/sns/' + item.sns_photo + '">'
                    code += '</div>';
                })

                $('#main_list').html(code);
            },
            error: function (xhr) {
                alert("에러 : " + xhr.status);
            },
            dataType: 'text'
        });

    }
}



$(function () {

    $('#sns_send').on('click', function () {

        //serialize로 한번에 긁어서 전송
        //		insertData = $('#sns_form').serialize();

        // form데이터 객체 생성해서 map처럼 하나씩 추가해서 담기.
        var formData = new FormData();
        formData.append("sns_title", $("input[name=sns_title]").val());
        formData.append("sns_content", $("textarea[name=sns_content]").val());
        formData.append("sns_photo", $("input[name=sns_photo]")[0].files[0]);
        formData.append("prod_name", $("select#sprod_list").val());


        // insertServer 메소드 호출
        insertServer(formData);

        // 모달창 숨기고 내용 리셋
        $('#sns_modal .txt').val("");
        //		$('#sns_modal').modal('hide');
        $('#modalClose').trigger("click");
        //		$('#sns_modal').hide();
        //		$('#sns_modal').removeClass("modal-backdrop");
    })


});


insertServer = function (formData) {
    $.ajax({
        url: '/nikepro/snsInsert.do',
        type: 'post',
        //		data : insertData,
        data: formData,
        processData: false,
        contentType: false,
        success: function (res) {
            // console.log(res);
            //console.log(JSON.parse(res));
            //if(res == "OK"){
            //	location.href = "/nikepro/snsList.do";
            //}
            //			alert("성공");
            alert(res);
            setTimeout(() => listServer(), 3500); //3초 후 리스트 재출력

        },
        error: function (xhr) {
            alert(xhr.status);

        }
        //		dataType : '',

    })

}

listServer = function () {
    const request = new XMLHttpRequest();

    request.open("post", "/nikepro/snsList.do", true);

    request.setRequestHeader("Content-Type", "application/json");

    request.send();

    request.onreadystatechange = function () {

        if (request.readyState === 4 && request.status === 200) {
            let target = document.getElementById("main_list")
            let data = request.response;
            let str = JSON.parse(data);
            let code = "";

            console.log(str)
            for (index in str) {
                code += '<div class="pictures">';
                code += '<a href="/nikepro/snsDetail.do?sns_no=' + str[index].sns_no + '"><img src="/nikepro/images/sns/' + str[index].sns_photo + '">'
                code += '</div>';
            }

            target.innerHTML = code;

        }
    }
}

window.onload = function () {
    const request = new XMLHttpRequest();

    request.open("post", "/nikepro/snsLikeList.do", true);

    request.setRequestHeader("Content-Type", "application/json");

    request.send();

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            let target = document.getElementById("main_list")
            let data = request.response;

            if (data === "로그인을 해주세요.") {
                alert(data);
                location.href = "/nikepro/snsMain.do";

            } else {
                let str = JSON.parse(data);
                let code = "";

                for (index in str) {
                    code += '<div class="pictures">';
                    code += '<a href="/nikepro/snsDetail.do?sns_no=' + str[index].sns_no + '"><img src="/nikepro/images/sns/' + str[index].sns_photo + '"></a>'
                    code += '</div>';
                }

                target.innerHTML = code;

            }

        }
    }
}

document.getElementById("sns_delete").onclick = function () {
    let input = prompt("삭제할 게시글 번호를 입력하세요");

    const request = new XMLHttpRequest();

    request.open("post", "/nikepro/snsDetail.do", true);

    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    request.send("sns_no=" + input);

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            let result = request.response;
            alert(result);

            listServer();
        }
    }
}
document.getElementById("sns_update").onclick = function () {
    let sns_no = prompt("삭제할 게시글 번호를 입력하세요");
    let sns_content = prompt("내용만 수정할 수 있습니다. 수정할 내용을 입력하세요.");

    const request = new XMLHttpRequest();

    request.open("post", "/nikepro/snsUpdate.do", true);

    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    request.send("sns_no=" + sns_no + "&sns_content=" + sns_content);

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            let result = request.response;
            alert(result);

            listServer();
        }
    }
}

//$('#commentBtn').on('submit', function(){
//
//		commentData = $('.sns_comment').serialize();
//
//		insertComment(commentData);
//
//
//	})
//
//
//insertComment = function(commentData){
//
//	$.ajax({
//			url : '/nikepro/CommentInsert.do',
//			type : 'post',
//			data : commentData,
//			dataType : text,
//			processData: false,
//        	contentType: false,
//			success : function(data){
//				console.log(data)
//			},
//			error : function (xhr){
//				alert(xhr.status);
//			}
//		})
//}


