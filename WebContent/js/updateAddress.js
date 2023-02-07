/**
 * 
 */

const url = "/nikepro/address/editPay.do";

function updateAddress() {
	
	const memZip = document.getElementById("memZip").value;
	const memAddr1 = document.getElementById("memAdd1").value;
	const memAddr2 = document.getElementById("memAdd2").value;
	const jsonAddr = document.getElementById("jsonAddr");
	const jsonZip = document.getElementById("jsonZip");
	
	const form = new FormData();
	
	form.append("memZip", memZip)
	form.append("memAddr1", memAddr1)
	form.append("memAddr2", memAddr2)
	
	fetch(url, {
	    method: 'POST',
	    mode: 'cors', // no-cors, *cors, same-origin
	    cache: 'no-cache',
	    credentials: 'same-origin',
	    headers: {
	      'Content-Type': 'application/json',
	    },
	    redirect: 'follow', // manual, *follow, error
	    referrerPolicy: 'no-referrer',
	    body: form
	}) // body의 데이터 유형은 반드시 "Content-Type" 헤더와 일치해야 함
	.then(function(response) {
		const resJson = response.json();
		resJson.then(function(data) {
			jsonAddr.textContent = data.memAddr1 + " " + data.memAddr2;
			jsonZip.textContent = data.memZip;
			$("#payPostForm").remove();
			$("#payOptionTitle").append(
				"<span onclick='editPost()' id='editPost' class='pay-option__edit-post'>배송지 편집</span>"
			);
		})
	});

};
