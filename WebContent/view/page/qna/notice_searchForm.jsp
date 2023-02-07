<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<title>notice_searchForm</title>
</head>
<body>
	<br><br><br>
	<form action="/nikepro/noticeSearchList.do" method="get" class="notice_index_search_form">
		<h2>고객센터</h2>
		<br>
	    <div>
	    	 <div>
		        <input type="text" placeholder="무엇을 도와드릴까요?" name="title">
	    	 </div>
	         <button type="submit">
	            <i class="fa-sharp fa-solid fa-magnifying-glass fa-1x"></i>
	        </button>
	    </div>
	</form>
	<br><br><br>
</body>