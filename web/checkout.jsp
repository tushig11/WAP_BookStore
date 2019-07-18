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
    <include:js file="cart.js"/>

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
    <div class="container">
        <div class="shopping-cart">
            <!-- Title -->
            <div class="title">
                <h4>Shopping Cart</h4>
                <h4 id="totalTxt">Total Price: ${cart.getTotal()}</h4>
                <a href="success"><button id="checkOutBtn">Checkout</button></a>
            </div>
            <c:forEach items="${myProducts}" var="product">
                <div class="item">
                    <div class="buttons">
                        <span class="delete-btn"></span>
                        <span class="like-btn"></span>
                    </div>
                    <div class="image">
                        <include:img file="${product.getPicturePath()}" alt="${product.getPicturePath()}"/>
                    </div>
                    <div class="description">
                        <span><c:out value="${product.getName()}"/></span>
                        <span><c:out value="${product.getAuthor()}" /></span>
                    </div>
                    <div class="quantity">
                        <button class="plus-btn" type="button" name="button">
                            <img src="resources/images/plus.svg" alt="" />
                        </button>
                        <input type="text" name="name" value="1">
                        <button class="minus-btn" type="button" name="button">
                            <img src="resources/images/minus.svg" alt="" />
                        </button>
                    </div>
                    <div class="total-price"><c:out value="${product.getPrice()}$" /></div>
                </div>
            </c:forEach>
        </div>
    </div>
    <footer>
        <h4>If you need any help contact us <a href="<c:url value="#"/>"><%= support_email %></a></h4>
    </footer>
</body>
</html>
