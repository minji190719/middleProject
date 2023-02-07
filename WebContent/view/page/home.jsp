<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>

<head>
    <title>HOME</title>
</head>

<tag:main>
	<jsp:include page="/view/component/header.jsp"></jsp:include>
    <main class="home-wrap">
        <div id="myCarousel" class="carousel slide home-imgs" data-ride="carousel"  data-interval="15000">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
      
            <!-- Wrapper for slides -->
            <!-- 새로고침하면 랜덤으로 새로울 이미지가 나온다 -->
            <div class="carousel-inner">
           
                <div class="item active">
<!--                     <img src="https://picsum.photos/1920/1200?random=1" alt="Los Angeles" style="width:100%;"> -->
                    <video type="video/mp4" src="/nikepro/media/nike_video.mp4" width="1920" muted loop autoplay></video>
                    <div class="carousel-caption">
<!--                         <h1>첫번째</h1> -->
<!--                         <p>DDIT is always so much fun!</p> -->
                    </div>
                </div>
            
                <div class="item">
                     <video type="video/mp4" src="/nikepro/media/team_video.mp4" width="1920" muted loop autoplay></video>
                    <div class="carousel-caption">
<!--                         <h1>두번째</h1> -->
<!--                         <p>Thank you, DDIT!</p> -->
                    </div>
                </div>
            
                <div class="item">
                    <video type="video/mp4" src="/nikepro/media/team2_video.mp4" width="1920" muted loop autoplay></video>
                    <div class="carousel-caption">
<!--                         <h1>세번째</h1> -->
<!--                         <p>We love the Big DDIT!</p> -->
                    </div>
                </div>
            
            </div>
      
            <!-- Left and right controls -->
            <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </main>
    
<%@ include file="/view/component/footer.jsp"%>
</tag:main>
