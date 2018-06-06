<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>Index</title>
    	<spring:url var="css" value="/static/css/bootstrap.css"/>
    	<link type="text/css" rel="stylesheet" href="${css }"/>
    	<spring:url var="login" value="../WEB-INF/resources/bootstrap/user/style.css"/>
    	<link rel="stylesheet" href="${login }"/>
    	<link rel="stylesheet" href="style.css"/>
	</head>
	<body>
		<div class="container">
            <div class="card card-container" id="formulario">
                <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
                <img id="profile-img" class="profile-img-card" src="" />
                <p id="profile-name" class="profile-name-card">Hotelnet</p>
                <form class="form-signin" method="post" action="userAuthentication.php">
                    <input type="text" id="inputUsername" class="form-control" placeholder="Usuário" required autofocus name="login">
                    <input type="password" id="inputPassword" class="form-control" placeholder="Senha" required name="senha">
                    <div id="remember" class="checkbox">
                        <label>
                            <input type="checkbox" value="remember-me"> Lembre-se de mim!
                        </label>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" id="buttonLogin">Login</button>
                </form><!-- /form -->
                <a href="#" class="forgot-password" id="forgot">
                    Esqueceu a senha?
                </a>
            </div><!-- /card-container -->s
        </div><!-- /container -->

        <footer>
            <div id="footer" class="animated fadeInUp footerLogin">
                <div style="float: left">
                    <p id="developedBy">Powered by Italo Gouveia</p>
                </div>
                <div><img src="" align="right" style="height: 30px; margin-top: 5px; margin-right: 5px"></div>
            </div>
        </footer>
	
	</body>
</html>
