<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : jspOrder
    Created on : 29 sept. 2020, 16:35:43
    Author     : cda611
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Order</title>
    </head>
    <body>
          <hr>
          
    <jsp:useBean class="beans.beanOrder" scope="session" id="customerId" />

    <%@include file="header.html" %>  
       <!-- Premiere ligne sous l'en tete -->
        <div>
            <div> Vos commandes  <a href="cadeau" >Achat Cadeau</a> </div>
        </div>

        <div> 
            <form name="search" action="searchOrder">
                <input type="text" name="inputOrder" value="" /><input type="image" name="doSearch" src="img/buton1.png">
            </form>
        </div>


        <h3> Dernier mois</h3>  
      
        
      
        <h3> 6 derniers mois</h3> 
        
        <%-- mettre la condition par rapport à la date de commande --%>
    <c:forEach var="Book" items="listOrder">
    </c:forEach>
        
    <%@include file="footer.html" %>  
    </body>
</html>
