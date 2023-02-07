<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
    <nav class="uk-navbar-container status-bar" uk-navbar="target: !.status-bar; align: right;">
        <div class="uk-navbar-left status-bar__left">
            <a class="uk-navbar-item uk-logo" href="https://www.nike.com/kr/jordan">
                <svg height="24px" width="24px" fill="#111" viewBox="0 0 26 32">
                    <path d="M14.4 5.52v-.08q0-.56.36-1t.92-.44 1 .36.48.96-.36 1-.96.4l-.24.08.08.12-.08.44-.16 1.28q.08.08.08.16l-.16.8q-.08.16-.16.24l-.08.32q-.16.64-.28 1.04t-.2.64V12q-.08.4-.12.64t-.28.8q-.16.32 0 1.04l.08.08q0 .24.2.56t.2.56q.08 1.6-.24 2.72l.16.48q.96.48.56 1.04l.4.16q.96.48 1.36.84t.8.76q.32.08.48.24l.24.08q1.68 1.12 3.36 2.72l.32.24v.08l-.08.16.24.16h.08q.24.16.32.16h.08q.08 0 .16-.08l.16-.08q.16-.16.32-.24h.32q.08 0 0 .08l-.32.16-.4.48h.56l.56.08q.24-.08.4-.16l.4-.24q.24-.08.48.16h.08q.08.08-.08.24l-.96.88q-.4.32-.72.4l-1.04.72q-.08.08-.16 0l-.24-.32-.16-.32-.2-.28-.24-.32-.2-.24-.16-.2-.32-.24q-.16 0-.32-.08l-1.04-.8q-.24 0-.56-.24-1.2-1.04-1.6-1.28l-.48-.32-.96-.16q-.48-.08-1.28-.48l-.64-.32q-.64-.32-.88-.32l-.32-.16q-.32-.08-.48-.16l-.16-.16q-.16 0-.32.08l-1.6.8-2 .88q-.8.64-1.52 1.04l-.88.4-1.36.96q-.16.16-.32 0l-.16.16q-.24.08-.32.08l-.32.16v.16h-.16l-.16.24q-.16.32-.32.36t-.2.12-.08.12l-.16.16-.24.16-.36-.04-.48.08-.32.08q-.4.08-.64-.12t-.4-.6q-.16-.24.16-.4l.08-.08q.08-.08.24-.08h.48L1.6 26l.32-.08q0-.16.08-.24.08-.08.24-.08v-.08q-.08-.16-.08-.32-.08-.16-.04-.24t.08-.08h.04l.08.24q.08.4.24.24l.08-.16q.08-.16.24-.16l.16.16.16-.16-.08-.08q0-.08.08-.08l.32-.32q.4-.48.96-.88 1.12-.88 2.4-1.36.4-.4.88-.4.32-.56.96-1.2.56-.4.8-.56.16-.32.4-.32H10l.16-.16q.16-.08.24-.16v-.4q0-.4.08-.64t.4-.24l.32-.32q-.16-.32-.16-.72h-.08q-.16-.24-.16-.48-.24-.4-.32-.64h-.24q-.08.24-.4.32l-.08.16q-.32.56-.56.84t-.88.68q-.4.4-.56.88-.08.24 0 .48l-.08.16h.08q0 .16.08.16h.08q.16.08.16.2t-.24.08-.36-.16-.2-.12l-.24.24q-.16.24-.32.2t-.08-.12l.08-.08q.08-.16 0-.16l-.64.16q-.08.08-.2 0t.04-.16l.4-.16q0-.08-.08-.08-.32.16-.64.08l-.4-.08-.08-.08q0-.08.08-.08.32.08.8-.08l.56-.24.64-.72.08-.16q.32-.64.68-1.16t.76-.84l.08-.32q.16-.32.32-.56t.4-.64l.24-.32q.32-.48.72-.48l.24-.24q.08-.08.08-.24l.16-.16-.08-.08q-.48-.4-.48-.72-.08-.56.36-.96t.88-.36.68.28l.16.16q.08 0 .08.08l.32.16v.24q.16.16.16.24.16-.24.48-.56l.4-1.28q0-.32.16-.64l.16-.24v-.16l.24-.96h.16l.24-.96q.08-.24 0-.56l-.32-.8z"></path>
                </svg>
            </a>
            <a class="uk-navbar-item uk-logo" href="https://www.converse.co.kr/">
                <svg height="24px" width="24px" fill="#111" viewBox="0 0 39 33">
                    <path d="M10.94 25.626l-4.236-5.501L.201 22.28l3.734-5.756L.11 10.777l6.59 2.031 4.026-5.474.14 6.785 6.64 2.175-6.594 2.446.028 6.886zm.824 7.239l13.952-16.393L11.806.107h11.697l14.871 16.389-14.8 16.369h-11.81z"></path>
                </svg>
            </a>
        </div>
        <div class="uk-navbar-right status-bar__right">
            <ul class="uk-navbar-nav">
                <li class="uk-active">
                    <a href="${pageContext.request.contextPath}/noticeMain.do"><span>고객센터</span></a>
                </li>

                <c:choose>

                    <c:when test="${sessionScope.member == null}">
                    
                        <li class="uk-active">
                            <a href="${pageContext.request.contextPath}/signUp.do"><span>가입하기</span></a>
                        </li>
                        <li class="uk-active">
                            <a href="${pageContext.request.contextPath}/login.do"><span>로그인</span></a>
                        </li>
                
                    </c:when>

					<c:otherwise>
                            
                        <li class="uk-active">
                            <a href="#">
                                <span>${sessionScope.member.getMem_name()}님, 안녕하세요</span>
                            </a>
                            <div class="uk-navbar-dropdown">
                                <ul class="uk-nav uk-navbar-dropdown-nav">
                                
                                    <c:choose>
                                
                                        <c:when test="${'ADMIN' == sessionScope.member.getMem_id()}">
                                            <!-- 관리자모드 -->
                                            <li class="uk-active">
                                                <a href="${pageContext.request.contextPath}/memberList.do">회원관리</a>
                                            </li>
             <!--                                <li class="uk-active">
                                                <a href="#">재고관리</a>
                                            </li> -->
                                            <li class="uk-active">

                                                <a href="<%=request.getContextPath() %>/view/page/ONUM/ReqList.jsp">ONUM 상품 관리</a>
                                            </li>
                                            <li class="uk-active">
                                                <a href="${pageContext.request.contextPath}/noticeList.do">공지사항 관리</a>

                                                <a href="${pageContext.request.contextPath}/noticeList.do">공지사항관리</a>

                                            </li>
                                            <li class="uk-active">
                                                <a href="${pageContext.request.contextPath}/returnsList_Admin.do">반품 요청 리스트</a>
                                            </li>
                                            
                                        </c:when>
                                        
                                        <c:otherwise>
                                            <!-- 회원모드 -->
                
                                            <li class="uk-active">
                                                <a href="<%=request.getContextPath() %>/selectAllCart.do">주문</a>

                                            </li>
                                            <%-- 임시로 구매내역 직접 링크 --%>
                                            <li class="uk-active">
                                                <a
                                                    href="${pageContext.request.contextPath}/returnsList.do"
                                                >
                                                    구매내역
                                                </a>
                                            </li>
                                            <li class="uk-active">
                                                <a
                                                    href="${pageContext.request.contextPath}/QnaMyList.do"
                                                >
                                                    문의내역
                                                </a>
                                            </li>
                                            <li class="uk-active">
                                                <a href="${pageContext.request.contextPath}/selectAllWish.do">위시리스트</a>
                                            </li>
                                            <li class="uk-active">
                                                <a
                                                    href="${pageContext.request.contextPath}/member/myInfo.do"
                                                >
                                                    회원정보관리
                                                </a>
                                            </li>
                                        
                                        </c:otherwise>
                                        
                                    </c:choose>
                                
                                    <li class="uk-active">
                                        <a href="${pageContext.request.contextPath}/logout.do">로그아웃</a>
                                    </li>
                                </ul>
                             </div>
                        </li>
                        
                    </c:otherwise>
                            
                </c:choose>
             </ul>               
        </div>
    </nav>

    <nav class="uk-navbar-container menu-bar" uk-navbar="target: !.menu-bar; align: center;">
            <div class="uk-navbar-left menu-bar__logo">
                   <a class="uk-navbar-item uk-logo" href="${pageContext.request.contextPath}/home.do">
                        <img
                            src="${pageContext.request.contextPath}/images/nikeLogo.png"
                            alt=""
                        />
                    </a>
	              
            </div>
            <div class="uk-navbar-center">
                <ul class="uk-navbar-nav">
                    <li class="uk-active">
                        <a
                            href="#"
                            class="menu-bar__nav-title"
                        >
                            About Us
                        </a>
                    </li>
                    <li class="uk-active">
                        <a href="#" class="menu-bar__nav-title">Men</a>
                        <div class="uk-navbar-dropdown uk-navbar-dropdown-width-3">
                            <div class="uk-navbar-dropdown-grid uk-child-width-1-3" uk-grid>
                                <div>
                                    <ul class="uk-nav uk-navbar-dropdown-nav">
                                        <li class="uk-active"><a href="#">신발</a></li>
                                        <li><a href="<%=request.getContextPath()%>/prodList.do?lprod_gu=sh100_M">신발 전체</a></li>
                                        <li><a href="<%=request.getContextPath()%>/prodList2.do?lprod_gu=sh100_M&prod_purpose=스포츠">스포츠</a></li>
                                        <li><a href="<%=request.getContextPath()%>/prodList2.do?lprod_gu=sh100_M&prod_purpose=일상">일상</a></li>
                                        <li><a href="<%=request.getContextPath()%>/prodList2.do?lprod_gu=sh100_M&prod_purpose=조던">조던</a></li>
                                        <%--
                                        <li><a href="#">라이프스타일</a></li>
                                        <li><a href="#">러닝</a></li>
                                        <li><a href="#">워킹</a></li>
                                        --%>
                                    </ul>
                                </div>
                                <div>
                                    <ul class="uk-nav uk-navbar-dropdown-nav">
                                        <li class="uk-active"><a href="#">의류</a></li>
                                        <li><a href="<%=request.getContextPath()%>/prodList.do?lprod_gu=cl100_M">의류 전체</a></li>
                                        <li><a href="<%=request.getContextPath()%>/prodList2.do?lprod_gu=cl100_M&prod_purpose=상의">상의</a></li>
                                        <li><a href="<%=request.getContextPath()%>/prodList2.do?lprod_gu=cl100_M&prod_purpose=하의">하의</a></li>
                                        <li><a href="<%=request.getContextPath()%>/prodList2.do?lprod_gu=cl100_M&prod_purpose=아우터">아우터</a></li>
                                        <%--
                                        <li><a href="#">탑 &amp; 티셔츠</a></li>
                                        <li><a href="#">팬츠 &amp; 타이츠</a></li>
                                        <li><a href="#">후디 &amp; 크루</a></li>
                                        --%>
                                    </ul>
                                </div>
                                <div>
                                    <ul class="uk-nav uk-navbar-dropdown-nav">
                                        <li class="uk-active"><a href="#">용품</a></li>
                                        <li><a href="<%=request.getContextPath()%>/prodList.do?lprod_gu=ac100_M">용품 전체</a></li>
                                        <li><a href="<%=request.getContextPath()%>/prodList2.do?lprod_gu=ac100_M&prod_purpose=모자">모자 &amp; 헤드밴드</a></li>
                                        <li><a href="<%=request.getContextPath()%>/prodList2.do?lprod_gu=ac100_M&prod_purpose=가방">가방</a></li>
                                        <li><a href="<%=request.getContextPath()%>/prodList2.do?lprod_gu=ac100_M&prod_purpose=애플워치">애플워치</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="uk-active">
                        <a href="#" class="menu-bar__nav-title">Women</a>
                        <div class="uk-navbar-dropdown uk-navbar-dropdown-width-3">
                            <div class="uk-navbar-dropdown-grid uk-child-width-1-3" uk-grid>
                                <div>
                                    <ul class="uk-nav uk-navbar-dropdown-nav">
                                        <li class="uk-active"><a href="#">신발</a></li>
                                        <li><a href="<%=request.getContextPath()%>/prodList.do?lprod_gu=sh100_F">신발 전체</a></li>
                                        <li><a href="<%=request.getContextPath()%>/prodList2.do?lprod_gu=sh100_F&prod_purpose=스포츠">스포츠</a></li>
                                        <li><a href="<%=request.getContextPath()%>/prodList2.do?lprod_gu=sh100_F&prod_purpose=일상">일상</a></li>
                                        <li><a href="<%=request.getContextPath()%>/prodList2.do?lprod_gu=sh100_F&prod_purpose=조던">조던</a></li>
                                        <%--
                                        <li><a href="#">라이프스타일</a></li>
                                        <li><a href="#">러닝</a></li>
                                        <li><a href="#">워킹</a></li>
                                        --%>
                                    </ul>
                                </div>
                                <div>
                                    <ul class="uk-nav uk-navbar-dropdown-nav">
                                        <li class="uk-active"><a href="#">의류</a></li>
                                        <li><a href="<%=request.getContextPath()%>/prodList.do?lprod_gu=cl100_F">의류 전체</a></li>
                                        <li><a href="<%=request.getContextPath()%>/prodList2.do?lprod_gu=cl100_F&prod_purpose=상의">상의</a></li>
                                        <li><a href="<%=request.getContextPath()%>/prodList2.do?lprod_gu=cl100_F&prod_purpose=하의">하의</a></li>
                                        <li><a href="<%=request.getContextPath()%>/prodList2.do?lprod_gu=cl100_F&prod_purpose=아우터">아우터</a></li>
                                        <%--
                                        <li><a href="#">탑 &amp; 티셔츠</a></li>
                                        <li><a href="#">팬츠 &amp; 타이츠</a></li>
                                        <li><a href="#">후디 &amp; 크루</a></li>
                                        --%>
                                    </ul>
                                </div>
                                <div>
                                    <ul class="uk-nav uk-navbar-dropdown-nav">
                                        <li class="uk-active"><a href="#">용품</a></li>
                                        <li><a href="<%=request.getContextPath()%>/prodList.do?lprod_gu=ac100_F">용품 전체</a></li>
                                        <li><a href="<%=request.getContextPath()%>/prodList2.do?lprod_gu=ac100_F&prod_purpose=모자">모자 &amp; 헤드밴드</a></li>
                                        <li><a href="<%=request.getContextPath()%>/prodList2.do?lprod_gu=ac100_F&prod_purpose=가방">가방</a></li>
                                        <li><a href="<%=request.getContextPath()%>/prodList2.do?lprod_gu=ac100_F&prod_purpose=애플워치">애플워치</a></li>

                                    </ul>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="uk-active">
                        <a
                            href="${pageContext.request.contextPath}/ONUM/onumMain.do"
                            class="menu-bar__nav-title"
                        >
                            ONUM
                        </a>
                    </li>
                    <li class="uk-active">
                        <a
                            href="${pageContext.request.contextPath}/snsMain.do"
                            class="menu-bar__nav-title"
                        >
                            SNS
                        </a>
                    </li>
                </ul>

            </div>

            <div class="uk-navbar-right">
                <div class="menu-bar__search">
                    <i class="fa-solid fa-magnifying-glass fa-lg"></i>
                    <input type="search" placeholder="검색" />
                </div>            
                <div class="menu-bar__heartnbag">
                    <a href="#"><i class="fa-regular fa-heart fa-lg"></i></a>
                    <a href="<%=request.getContextPath() %>/selectAllCart.do"><i class="fa-solid fa-bag-shopping fa-lg"></i></a>
                </div>
            </div>
            
        </nav>

</header>
