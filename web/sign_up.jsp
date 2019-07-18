<%--
  Created by IntelliJ IDEA.
  User: nev0
  Date: 7/14/2019
  Time: 10:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="include" uri="/WEB-INF/script.tld" %>

<%
    ServletContext sc = request.getServletContext();
    String support_email = sc.getInitParameter("support-email");

    Cookie[] cookies = null;

    // Get an array of Cookies associated with the this domain
    cookies = request.getCookies();

    if( cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            if(cookies[i].getName().equals("member")){
                request.setAttribute("member", cookies[i].getValue());
            }
        }
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Sign up</title>
    <%--    Created by custom Tag--%>
    <include:css file="fa-font.css"/>
    <include:css file="base.css"/>
    <include:css file="login.css"/>
    <include:js file="login.js"/>
</head>
<body>
<header>
    <div class="header-text">
        <h1>Welcome to My BookStore</h1>
        <p>Web Application Programming project</p>
    </div>
</header>
<nav id="myMenu">
    <div class="menu">
        <ul>
            <li class="active"><a href="${pageContext.request.contextPath}"><i class="fas fa-home"></i> Home</a></li>

            <%--              right menu--%>
            <li class="right"><a href="checkout"><i class="fas fa-shopping-cart"></i> [ <span id="cardValue">${cart.getSize()}</span> ]</a></li>
            <li class="right"><a href="login">Login</a></li>
            <li class="right"><a href="#">Guest</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="myForm">
        <form class="formLogin" action="create" method="post">
            <input type="text" placeholder="username" name='username' />
            <input type="password" placeholder="password" name='password'/>
            <button type="submit">Sign up</button>
            <p><strong>${message}</strong></p>
            <p class="message">Already registered? <a href="login">Sign in</a></p>
        </form>
    </div>
</div>

<footer>
    <h4>If you need any help contact us <a href="<c:url value="#"/>"> <%= support_email %></a></h4>
</footer>
</body>
</html>