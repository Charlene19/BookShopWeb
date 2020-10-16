<%-- 
    Document   : adresseC
    Created on : 5 oct. 2020, 19:56:37
    Author     : jabar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/css/adresse.css">  
        <link rel="stylesheet" href="/css/templatecss.css">
    </head>

    <header><jsp:include page="/headerJsp.jsp" /></header>

    <body>

        <div id="font">

            <h2>Adresses de livraison</h2>
            <div id="containerLiv">
                    <c:forEach items="${addressLiv}" var="adresseLiv" varStatus="boucle">    
                    <div class="liv">
                        ${adresseLiv.companyName}<br> ${adresseLiv.lastName} ${adresseLiv.firstName}<br>${adresseLiv.street}<br>${adresseLiv.streetExtra}<br>
                        ${adresseLiv.postcode}<br>${adresseLiv.city}<br>${adresseLiv.phone}
                    </div>
                    </c:forEach>
                <div id="liv6"><form method="get" action="adresse"><button class="bttn-unite" type="submit" name="action" value="livraison"><h3>Ajouter adresse de livraison</h3></button></form></div> 
            </div>
            <h2 id="fac">Adresses de facturation</h2>
            <div id="containerFac">
                <c:forEach items="${addressBil}" var="adresseBil" varStatus="boucle">    
                    <div class="fac">${adresseBil.companyName}<br> ${adresseBil.lastName} ${adresseBil.firstName}<br>${adresseBil.street}<br>${adresseBil.streetExtra}<br>${adresseBil.postcode}<br>${adresseBil.city}<br>${adresseBil.phone}</div>    
                </c:forEach>
                <div id="fac6"><form method="get" action="adresse"><button class="bttn-unite" type="submit" name="action" value="facturation"><h3>Ajouter adresse de facturation</h3></button></form></div> 
            </div>

        </div>

        <footer><jsp:include page="/footerJsp.jsp" /></footer>

    </body>
</html>