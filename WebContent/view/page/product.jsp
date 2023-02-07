<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>

<head>
    <title>Product</title>
</head>

<tag:main>
    <jsp:include page="/view/component/header.jsp"></jsp:include>

    <!-- product -->
    <!-- product head -->
    <div class="product-top">
        <div class="product-top__column">
            <span>신상품 / 신발</span>
            <span>신상품 남성 신발 </span>
        </div>
        <div class="product-top__column">
            <div>
                <span id="filter">필터 숨기기</span>
                <svg
                    aria-hidden="true"
                    class="icon-filter-ds"
                    focusable="false"
                    role="img"
                    width="24px"
                    height="24px"
                    fill="none"
                >
                    <path
                        stroke="currentColor"
                        stroke-width="1.5"
                        d="M21 8.25H10m-5.25 0H3"
                    ></path>
                    <path
                        stroke="currentColor"
                        stroke-width="1.5"
                        d="M7.5 6v0a2.25 2.25 0 100 4.5 2.25 2.25 0 000-4.5z"
                        clip-rule="evenodd"
                    ></path>
                    <path
                        stroke="currentColor"
                        stroke-width="1.5"
                        d="M3 15.75h10.75m5 0H21"
                    ></path>
                    <path
                        stroke="currentColor"
                        stroke-width="1.5"
                        d="M16.5 13.5v0a2.25 2.25 0 100 4.5 2.25 2.25 0 000-4.5z"
                        clip-rule="evenodd"
                    ></path>
                </svg>
            </div>
            <div>
                <span id="sort"
                    >정렬기준:&nbsp;&nbsp;<i
                        class="fa-solid fa-chevron-down fa-lg"
                    ></i
                ></span>
            </div>
        </div>
    </div>

    <!-- product nav -->
    <nav class="product-nav" id="product-nav">
        <div class="product-nav__sprots">
            <ul>
                <li>라이프스타일</li>
                <li>조던</li>
                <li>농구</li>
                <li>트레이닝 및 짐</li>
                <li>스케이트보딩</li>
                <li>골프</li>
                <li>테니스</li>
                <li>샌들 &amp; 슬리퍼</li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
            </ul>
        </div>
        <div class="product-nav__gender">
            <h3>성별</h3>
            <span
                ><input type="checkbox" name="gender" value="male" checked />
                남성</span
            ><br />
            <span
                ><input type="checkbox" name="gender" value="female" />
                여성</span
            ><br />
            <span
                ><input type="checkbox" name="gender" value="unisex" />
                유니섹스</span
            ><br />
        </div>
        <div class="product-nav__color">
            <h3>색상</h3>
            <a href="#" id="black">블랙</a>
            <a href="#" id="blue">블루</a>
            <a href="#" id="brown">브라운</a>
            <a href="#" id="green">그린</a>
            <a href="#" id="gray">그레이</a>
            <a href="#" id="orange">오렌지</a>
            <a href="#" id="pink">핑크</a>
            <a href="#" id="white">화이트</a>
        </div>
        <div class="product-nav__price">
            <h3>가격대</h3>
            <input type="checkbox" name="price" value="100" checked />
            50,000 - 100,000 원<br />
            <input type="checkbox" name="price" value="150" /> 100,000 - 150,000
            원<br /> <input type="checkbox" name="price" value="200" /> 150,000
            - 200,000 원<br />
            <input type="checkbox" name="price" value="200over" /> 200,000 원
            +<br />
        </div>
    </nav>
    
    <%@ include file="/view/component/footer.jsp" %>
    
</tag:main>

<script src="${pageContext.request.contextPath}/js/product-nav.js"></script>
