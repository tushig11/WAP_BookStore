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
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <title>Home</title>
  <link rel="icon" href="resources/images/favicon.ico" type="image/gif" sizes="16x16">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <%--    Created by custom Tag--%>
    <include:css file="fa-font.css"/>
    <include:css file="base.css"/>
    <include:css file="product.css"/>
    <include:js file="jquery-1.12.4.js"/>
    <include:js file="jquery-ui.js"/>
    <include:js file="base.js"/>
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
            <li class="active"><a href="${request.getContextPath()}"><i class="fas fa-home"></i> Home</a></li>

<%--              right menu--%>
            <li class="right"><a href="checkout"><i class="fas fa-shopping-cart"></i> [ <span id="cardValue">${cart.getSize()}</span> ]</a></li>
            <c:choose>
                <c:when test="${username!='Guest'}">
                    <li class="right"><a href="logout">Log out</a></li>
                </c:when>
                <c:otherwise>
                    <li class="right"><a href="login">Login</a></li>
                </c:otherwise>
            </c:choose>
            <li class="right"><a href="#"><c:if test = "${username != null}"><c:out value = "${username}"/></c:if></a></li>
          </ul>
      </div>
  </nav>

  <div class="container">
      <div class="side">
          <div class="filter">
              <div class="search-container">
                  <input type="text" id="searchTxt" placeholder="Search.." name="search">
                  <button type="submit" id="searchBtn"><i class="fas fa-search"></i></button>
              </div>
          </div>
          <div class="filter">
              <h3>Price range: lower than <span id="priceRange"></span></h3>
              <div class="slideContainer">
                  <input type="range" min="1" max="50" value="50" class="slider" id="myRange">
              </div>
          </div>
          <div class="filter">
              <h3>Categories: <span id="selectedCategories"></span></h3>
              <label class="checkBoxContainer"> Biography
                  <input type="checkbox" id="bio" value="biography">
                  <span class="checkMark"></span>
              </label>

              <label class="checkBoxContainer"> Business
                  <input type="checkbox" id="bus" value="business">
                  <span class="checkMark"></span>
              </label>

              <label class="checkBoxContainer"> History
                  <input type="checkbox" id="his" value="history">
                  <span class="checkMark"></span>
              </label>

              <label class="checkBoxContainer"> Mystery
                  <input type="checkbox" id="mys" value="mystery">
                  <span class="checkMark"></span>
              </label>
          </div>
      </div>
      <div class="main">
          <div class="content" id="content">
          </div>
      </div>
  </div>

  <footer>
    <h4>If you need any help contact us <a href="<c:url value="#"/>"><%= support_email %></a></h4>
  </footer>
</body>
</html>