<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : jspEvent
    Created on : 29 sept. 2020, 15:47:40
    Author     : cda611
--%>

<%@page import="beans.beanEvent"%>
<%@page import="classes.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="templatecss.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="evtImg.js"></script>
    <canvas id="canvas" width="1300" height="200"></canvas>
    <script src="evtImg.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <hr>
    <jsp:useBean class="beans.beanEvent" scope="application" id="customerId" />

    <%@include file="header.html" %>   


    <p>

        <script src="evtImg.js"></script>       
    </p>


    <br> </br><br></br>
    <div class="jumbotron text-center">
        <h1>Les livres sélectionnés pour l'évenement </h1>

    </div>
    <div>
    <!-- Le container -->
<c:forEach var="Book" items="${list}">
     ${Book.title} 
</c:forEach>

</div>

     <%-- Ne pas retirer
    <%
        for (Book b : new beanEvent().returnlBook()) {
            
                   out.println("<div class=\"container\"> " + " <div class=\"row\"> "  + "  <div class=\"col-sm-4\"> " + " <figure>  <p><a href=\" book.html\" title=\"\"><img src = \'"+ b.getCoverURL() + "'" 
                           + " width=\"150\" height=\"200\"  alt= \"\" /></a> "  + " <h3> " + b.getTitle() + " </h3>"
                  + " <p>  " +  b.getPostIt() + " </p>" +
                   " <p> " + b.getPrice() + " Euros</p>" +
           " </div> ");}
          
    %>
     
     --%>
    
    </div> 
</div>

<br></br><br></br><br></br>
<%@include file="footer.html" %>      
</body>
</html>
