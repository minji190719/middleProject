<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>

<head>
	<title>Login</title>
</head>

<tag:main>

	<main class="memberWrap">

		<div class="container">
			<h1>로그인을 위해 아이디와 비밀번호를 입력하세요.</h1>
			<form
				action="${pageContext.request.contextPath}/login.do"
				method="post"
				id="memberForm"
				class="memberForm"
			>
				<div class="form-group">
					<label for="memId">아이디 </label>
					<input
						type="text"
						placeholder="Enter id"
						name="memId"
						id="memId"
						class="form-control"
						required
					>
				</div>
				<div class="form-group">
					<label for="memPass">비밀번호 </label>
					<input
						type="password"
						placeholder="Enter password"
						name="memPass"
						id="memPass"
						class="form-control"
						required
					>
				</div>
				<%--
				<div class="checkbox">
					<label><input type="checkbox" name="remember">
						Remember me</label>
				</div>
				--%>
				<button type="submit" class="onumBuyBtn logInBtn">로그인</button>
			</form>
				<button class="onumBuyBtn homeBtn" onclick="location.href='${pageContext.request.contextPath}/home.do'">HOME</button>
		</div>
	</main>

</tag:main>