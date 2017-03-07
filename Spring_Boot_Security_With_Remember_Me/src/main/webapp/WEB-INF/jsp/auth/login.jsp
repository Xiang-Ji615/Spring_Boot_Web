<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel='stylesheet'
	href='/webjars/bootstrap/3.3.7/css/bootstrap.min.css'>
<link rel='stylesheet' href='/css/login/login.css'>
</head>
<body>
	<div class="container">
		<div class="card card-container">
			<!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
			<img id="profile-img" class="profile-img-card"
				src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
			<p id="profile-name" class="profile-name-card"></p>
			<c:if test="${not empty Error}">
				<p class="bg-danger">${Error}</p>
			</c:if>
			<c:if test="${not empty Msg}">
				<p class="bg-primary">${Msg}</p>
			</c:if>
			<form class="form-signin" method="post"
				action="/Web/Login/j_spring_security_check?targetUrl=/Web/Index">
				<span id="reauth-email" class="reauth-email"></span> <input
					type="text" id="inputUsername" class="form-control"
					placeholder="username" name="username" required autofocus>
				<input type="password" id="inputPassword" class="form-control"
					name="password" placeholder="Password" required> <input
					type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<div id="remember" class="checkbox">
					<label> <input type="checkbox" name="remember-me">
						Remember me
					</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block btn-signin"
					type="submit" name="submit" value="submit" >Sign in</button>
			</form>
			<!-- /form -->
			<!--  a href="#" class="forgot-password"> Forgot the password? </a -->
		</div>
		<!-- /card-container -->
	</div>
	<!-- /container -->
	<script type="text/javascript"
		src="/webjars/jquery/3.0.0/jquery.min.js"></script>
	<script type="text/javascript"
		src="/webjars/bootstrap/3.3.7/js/bootstrap.js"></script>
	<script type="text/javascript" src="/js/login/login.js"></script>
</body>
</html>