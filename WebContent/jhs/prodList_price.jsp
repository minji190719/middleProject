<%@page import="kr.or.ddit.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    String lprod_gu = (String) request.getAttribute("lprod_gu");
    String prod_purpose = (String) request.getAttribute("prod_purpose");
    String prod_price = (String) request.getParameter("prod_price");
    
    String lprodGu = "";
    
    if (lprod_gu.substring(0, 2).equals("sh")) {
        lprodGu = "신발";
    } else if (lprod_gu.substring(0, 1).equals("c")) {
        lprodGu = "의류";
    } else if (lprod_gu.substring(0, 2).equals("ac")) {
        lprodGu = "용품";
    }
    
//  str1.charAt(str1.length() - 1)
    String gender="";

    if ((lprod_gu.charAt(lprod_gu.length() - 1)) == 'M') {
        gender = "남성";
    } else {
        gender = "여성";
    }
    
    String pp1 = "";
    
    if (prod_purpose == null) {
        pp1 = "";
    } else {
        pp1 = " / " + prod_purpose; 
    }
    
    String pp2 = "";
    
    if (prod_purpose == null) {
        pp2 = "";
    } else {
        pp2 = prod_purpose; 
    }
    
    pageContext.setAttribute("lprodGu", lprodGu);
    pageContext.setAttribute("gender", gender);
    pageContext.setAttribute("pp1", pp1);
    pageContext.setAttribute("pp2", pp2);
%>

<!DOCTYPE html>
<html lang="ko">
    <head>
        <%@ include file="/WEB-INF/headMeta/headMain.jsp"%>
        <title>PROD_LIST</title>
<script>
//alert(<%=prod_price%>);

function priceBtns(data) {
        //alert(data);
        let id = "radio" + data;
        $("input:radio[id='" + id +"']").prop("checked", true); 
        location.href="/nikepro/prodList_price.do?prod_price=" + data + "&lprod_gu=<%= lprod_gu %>";
<%--        
        
        
        const request = new XMLHttpRequest();

        request.open("post", "/nikepro/prodList_price.do", true);

        request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

        request.send("prod_price=" + data + "&lprod_gu=<%= lprod_gu %>");
        
        request.onreadystatechange = function () {
            if (request.readyState === 4 && request.status === 200) {
                location.href="/nikepro/prodList_color.do?prod_price=" + data + "&lprod_gu=<%= lprod_gu %>";
            }
        } --%>
}
</script>
    </head>

    <body>

        <%@ include file="/view/component/header.jsp" %>
        <%@ include file="/view/component/productTop.jsp" %>
        
        <div class="prodlist-container">
        
            <nav class="product-nav slide-side" id="product-nav">
<!--     <div class="product-nav__sprots">
        <ul>
            <li>조던</li>
            <li>라이프스타일</li>
            <li>스포츠</li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div> -->
 
    <div class="product-nav__color">
        <h3>색상</h3>
        <a href="/nikepro/prodList_color.do?lprod_gu=<%=lprod_gu %>&prod_color=black&prod_purpose=<%=prod_purpose %>" id="black"><!-- 블랙 --><img src="/nikepro/images/colors/black.jpg" alt="black.jpg" style="width: 50px; height: 70px;"></a>
        <a href="/nikepro/prodList_color.do?lprod_gu=<%=lprod_gu %>&prod_color=blue&prod_purpose=<%=prod_purpose %>" id="blue"><!-- 블루 --><img src="/nikepro/images/colors/blue.jpg" alt="black.jpg" style="width: 50px; height: 70px;"></a>
        <a href="/nikepro/prodList_color.do?lprod_gu=<%=lprod_gu %>&prod_color=brown&prod_purpose=<%=prod_purpose %>" id="brown"><!-- 브라운 --><img src="/nikepro/images/colors/brown.jpg" alt="black.jpg" style="width: 50px; height: 70px;"></a>
        <a href="/nikepro/prodList_color.do?lprod_gu=<%=lprod_gu %>&prod_color=green&prod_purpose=<%=prod_purpose %>" id="green"><!-- 그린 --><img src="/nikepro/images/colors/green.jpg" alt="black.jpg" style="width: 50px; height: 70px;"></a>
        <a href="/nikepro/prodList_color.do?lprod_gu=<%=lprod_gu %>&prod_color=gray&prod_purpose=<%=prod_purpose %>" id="gray"><!-- 그레이 --><img src="/nikepro/images/colors/gray.jpg" alt="black.jpg" style="width: 50px; height: 70px;"></a>
        <a href="/nikepro/prodList_color.do?lprod_gu=<%=lprod_gu %>&prod_color=orange&prod_purpose=<%=prod_purpose %>" id="orange"><!-- 오렌지 --><img src="/nikepro/images/colors/orange.jpg" alt="black.jpg" style="width: 50px; height: 70px;"></a>
        <a href="/nikepro/prodList_color.do?lprod_gu=<%=lprod_gu %>&prod_color=pink&prod_purpose=<%=prod_purpose %>" id="pink"><!-- 핑크 --><img src="/nikepro/images/colors/pink.jpg" alt="black.jpg" style="width: 50px; height: 70px;"></a>
        <a href="/nikepro/prodList_color.do?lprod_gu=<%=lprod_gu %>&prod_color=white&prod_purpose=<%=prod_purpose %>" id="white"><!-- 화이트 --><img src="/nikepro/images/colors/white.jpg" alt="black.jpg" style="width: 50px; height: 70px;"></a>
    </div>
    <div class="product-nav__price">
    
       <div class="product-nav__gender">

    </div>
    
        <h3>가격대</h3>
        
        <%
        switch (prod_price) {
        case "100":
            %>
                    <input class="priceRadio" type="radio" id="radio100" name="price" value="100" checked />
        <input type="button" class="priceBtn" value="50,000 - 100,000 원" onclick="priceBtns(100)"><br />
        
        <input type="radio" id="radio150" name="price" value="150" /> 
        <input type="button" class="priceBtn" value="100,000 - 150,000 원" onclick="priceBtns(150)"><br /> 
        
        <input type="radio" id="radio200" name="price" value="200" /> 
        <input type="button" class="priceBtn" value="150,000 - 200,000 원" onclick="priceBtns(200)"><br />
        
        <input type="radio" id="radio250" name="price" value="250" /> 
        <input type="button" class="priceBtn" value="200,000 원 +" onclick="priceBtns(250)">
        <br />
        
        <%
            break;
            
        case "150":
            %>
                    <input class="priceRadio" type="radio" id="radio100" name="price" value="100" />
        <input type="button" class="priceBtn" value="50,000 - 100,000 원" onclick="priceBtns(100)"><br />
        
        <input type="radio" id="radio150" name="price" value="150" checked /> 
        <input type="button" class="priceBtn" value="100,000 - 150,000 원" onclick="priceBtns(150)"><br /> 
        
        <input type="radio" id="radio200" name="price" value="200" /> 
        <input type="button" class="priceBtn" value="150,000 - 200,000 원" onclick="priceBtns(200)"><br />
        
        <input type="radio" id="radio250" name="price" value="250" /> 
        <input type="button" class="priceBtn" value="200,000 원 +" onclick="priceBtns(250)">
        <br />
        
        <%
            break;
            
        case "200":
            %>
            
                    <input class="priceRadio" type="radio" id="radio100" name="price" value="100" />
        <input type="button" class="priceBtn" value="50,000 - 100,000 원" onclick="priceBtns(100)"><br />
        
        <input type="radio" id="radio150" name="price" value="150" /> 
        <input type="button" class="priceBtn" value="100,000 - 150,000 원" onclick="priceBtns(150)"><br /> 
        
        <input type="radio" id="radio200" name="price" value="200" checked/> 
        <input type="button" class="priceBtn" value="150,000 - 200,000 원" onclick="priceBtns(200)"><br />
        
        <input type="radio" id="radio250" name="price" value="250" /> 
        <input type="button" class="priceBtn" value="200,000 원 +" onclick="priceBtns(250)">
        <br />
        <%
            break;
            
        case "250":
            %>
                    <input class="priceRadio" type="radio" id="radio100" name="price" value="100" />
        <input type="button" class="priceBtn" value="50,000 - 100,000 원" onclick="priceBtns(100)"><br />
        
        <input type="radio" id="radio150" name="price" value="150" /> 
        <input type="button" class="priceBtn" value="100,000 - 150,000 원" onclick="priceBtns(150)"><br /> 
        
        <input type="radio" id="radio200" name="price" value="200" /> 
        <input type="button" class="priceBtn" value="150,000 - 200,000 원" onclick="priceBtns(200)"><br />
        
        <input type="radio" id="radio250" name="price" value="250" checked /> 
        <input type="button" class="priceBtn" value="200,000 원 +" onclick="priceBtns(250)">
        <br />
        <%
            break;
        
        }
        %>
       
    </div>
</nav>


            <div id="prod-container" class="prod-container">
            
<%
                List<ProdVO> plist = (List<ProdVO>) request.getAttribute("plist");

                for (ProdVO vo : plist) {
%>

                <div class="prod-item" idx=<%=vo.getProd_id() %>>
                    <div class="prod-item__img" >
                        <a href="<%=request.getContextPath() %>/showProd.do?prod_id=<%=vo.getProd_id()%>"><img src="/nikepro/images/prod/<%=vo.getProd_id()%>_1.png"></a>
                    </div>
                    <div class="prod-item__contents">
                        <table>
                            <tr>
                                <td><%=vo.getProd_name() %></td>
                            </tr>
                            <tr>
                            
<%
                                String prodGu = "";
    
                                if (vo.getLprod_gu().substring(0, 2).equals("sh")) {
                                    prodGu = "신발";
                                } else if (vo.getLprod_gu().substring(0, 1).equals("c")) {
                                    prodGu = "의류";
                                } else if (vo.getLprod_gu().substring(0, 2).equals("ac")) {
                                    prodGu = "용품";
                                }
                                
                                String prodGender="";
                                
                                if ((vo.getLprod_gu().charAt(vo.getLprod_gu().length() - 1)) == 'M') {
                                    gender = "남성";
                                } else {
                                    gender = "여성";
                                }
%>

                                <td><%=prodGender%> <%=prodGu%></td>
                            </tr>
                            <tr>
                                <td><%=vo.getProd_color() %></td>
                            </tr>
                            <tr>
                                <td><span><%=vo.getProd_price() %> 원</span></td>
                            </tr>
                        </table>
                    </div>
                </div>
                    
<%
                                } 
%>

            </div>
        </div>
    <%@ include file="/view/component/footer.jsp"%>
    

    <script src="${pageContext.request.contextPath}/js/product-nav.js"></script>
    </body>
</html>




