/**
 * 
 */

function editPost(event) {
	
	let code = "<form id='payPostForm' class='payPostForm'>";
	code += "<div class='form-group'>";
	code +=	"    <label for='memZip'>우편번호 :</label>";
	code +=	"    <input";
	code +=	"        type='text'";
	code +=	"        name='memZip'";
	code +=	"        id='memZip'";
	code +=	"        class='form-control'";
	code +=	"    >";
	code +=	"</div>";
	code +=	"<button";
	code +=	"    type='button'";
	code +=	"    class='btn btn-default'";
	code +=	"    onclick='execDaumPostcode()'";
	code +=	">";
	code +=	"    우편번호 찾기";
	code +=	"</button>";
	code +=	"<div class='form-group'>";
	code +=	"    <label for='memAdd1'>주소 :</label>";
	code +=	"    <input";
	code +=	"        type='text'";
	code +=	"        name='memAdd1'";
	code +=	"        id='memAdd1'";
	code +=	"        class='form-control'";
	code +=	"    >";
	code +=	"</div>";
	code +=	"<div class='form-group'>";
	code +=	"    <label for='memAdd2'>상세 주소 :</label>";
	code +=	"    <input";
	code +=	"        type='text'";
	code +=	"        name='memAdd2'";
	code +=	"        id='memAdd2'";
	code +=	"        class='form-control'";
	code +=	"    >";
	code +=	"</div>";
	code +=	"<button id='payEditAddr'";
	code +=	"    type='button'";
	code +=	"    class='btn btn-default'";
	code +=	"    onclick='updateAddress()'";
	code +=	">";
	code +=	"    편집";
	code +=	"</button>";
	code +=	"</form>";
	
	$(".pay-option__title").after(code);
	
	$("#editPost").remove();
	
};
