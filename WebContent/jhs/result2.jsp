<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//서블릿에서 저장된 결과값 꺼내기
	int res = (Integer)request.getAttribute("result");
	String pay_no = (String)request.getAttribute("pay_no");
	
	if(res>0){
%>	
	{
		"flag" : "성공",
		"pay_no" : "<%=pay_no %>"
	}
	
	
		
<%	}else{%>
	
	{
		"flag" : "실패"	
	}
	
<%		
	}
	
%>