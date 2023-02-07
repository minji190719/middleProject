<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>

<head>
    <title>My Page</title>
</head>

<tag:main>

	<main class="myPageWrap">
	<h1>My Page</h1>
	
    <div class="container">
			<h1>내 정보 수정</h1>
			<form
				action="${pageContext.request.contextPath}/signUp.do"
				method="post"
				id="signUpForm"
				class="signUpForm">
				<div class="form-group"
			>
					<label for="memName">이름 :</label>
					<input
						type="text"
						value="${sessionScope.member.getMem_name()}"
						placeholder="Enter name"
						pattern="^[가-힣]{3,4}$"
						name="memName"
						id="memName"
						class="form-control"
					>
				</div>
				<div class="form-group">
					<label for="memPass">비밀번호 :</label>
					<input
						type="password"
						value="${sessionScope.member.getMem_pass()}"
						placeholder="Enter password"
						pattern="^[^A-Z@]{3,}$"
						name="memPass"
						id="memPass"
						class="form-control"
						required
					>
				</div>
				<div class="form-group">
					<label for="confirmPass">비밀번호 확인 :</label>
					<input
						type="password"
						placeholder="Confirm password"
						pattern="^[^A-Z@]{3,}$"
						name="confirmPass"
						id="confirmPass"
						class="form-control"
						required
					>
					<button id="confirmBtn">확인</button>
				</div>
				<div class="form-group">
					<label for="memZip">우편번호 :</label>
					<input
						type="text"
						value="${sessionScope.member.getMem_zip()}"
						placeholder="Enter zipcode"
						name="memZip"
						id="memZip"
						class="form-control"
					>
				</div>
				<div class="form-group">
					<label for="memAdd1">주소 :</label>
					<input
						type="text"
						value="${sessionScope.member.getMem_add1()}"
						placeholder="Enter address"
						name="memAdd1"
						id="memAdd1"
						class="form-control"
					>
				</div>
				<div class="form-group">
					<label for="memAdd2">상세 주소 :</label>
					<input
						type="text"
						value="${sessionScope.member.getMem_add2()}"
						placeholder="Enter detail address"
						name="memAdd2"
						id="memAdd2"
						class="form-control"
					>
				</div>
				<div class="form-group">
					<label for="memTel">전화번호 확인 :</label>
					<input
						type="tel"
						value="${sessionScope.member.getMem_tel()}"
						placeholder="Enter phone"
						name="memTel"
						id="memTel"
						class="form-control"
					>
				</div>
				
				<div class="checkbox">
					<label><input type="checkbox" name="remember">
						Remember me</label>
				</div>
				
				<button type="submit" class="btn btn-default">수정</button>
			</form>
		</div>
    
	</main>
	
    <a href="${pageContext.request.contextPath}/home.do">홈으로</a>
    
</tag:main>