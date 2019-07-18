<%--
  Created by IntelliJ IDEA.
  User: nev0
  Date: 7/15/2019
  Time: 2:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="include" uri="/WEB-INF/script.tld" %>

<%
    ServletContext sc = request.getServletContext();
    String support_email = sc.getInitParameter("support-email");
%>
<html>
<head>
    <title>Checkout</title>
    <%--    Created by custom Tag--%>
    <include:css file="fa-font.css"/>
    <include:css file="base.css"/>
    <include:css file="cart.css"/>
    <include:js file="jquery-1.12.4.js"/>
    <include:js file="jquery-ui.js"/>

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
            <li class="right"><a href="checkout"><i class="fas fa-shopping-cart"></i> [ ${cart.getSize()} ]</a></li>
            <c:if test="${user!='Guest'}"><li class="right"><a href="logout">Log out</a></li></c:if>
            <li class="right"><a href="">${user}</a></li>
        </ul>
    </div>
</nav>
<div class="containerSuccess">
    <div class="shipped"><h2>Thank you! Your order will be shipped soon!</h2></div>
    <div class="continue"><a href="${pageContext.request.contextPath}"><button>Continue Shopping</button></a></div>
</div>
<footer>
    <h4>If you need any help contact us <a href="<c:url value="#"/>"><%= support_email %></a></h4>
</footer>
</body>
</html>
