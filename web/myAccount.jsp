<%-- 
    Document   : myAccount
    Created on : 30 sept. 2020, 12:19:09
    Author     : Loïc
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>

<html>





    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Bookshop - Bienvenue sur votre librairie en ligne !</title>
        <meta name="description" content="">
        <link rel="stylesheet" href="css/templatecss.css">
    </head>

    <header><jsp:include page="headerJsp.jsp" /></header>


    <body>
        <div id="font"> 


            <section>


                <h1 class="titre">Bienvenue ${customer.customerFName} ${customer.customerLName}</h1>

                <h2> <%--    --%>    
                  
                        Mes Commandes
                </h2>
                <ul>
                    <li class="llMyAccount"><a href="/allOrder">Toutes mes commandes</a></li>
                    <li class="llMyAccount"><a href="/orderStatusActive">Commandes en cours</a></li>
                </ul>
            </section>


            <section>
                <h2>Mes paramètres</h2>
                <ul>
                    <li class="llMyAccount"><a href="/login">Paramètres de sécurité et de connexion</a></li>
                    <li class="llMyAccount"><a href="/adresse">Gérer mes adresses</a></li>
                </ul>
            </section>

            <br><br>

            <!-- bean used to round up price -->
            <jsp:useBean id="bean_order_val" scope="session" class="model.bean.OrderValidationBean" />
            
            <c:if test="${not empty bean_order_val.books}">
                <p><a href="/ordervalidation">Continuer la commande en cours</a></p>
            </c:if>
                
            <p><button class="bttn-unite" type="button"><a href="login?action=logout">Déconnexion</a></button></p>




        </div>

        <footer><jsp:include page="footerJsp.jsp" /></footer>

    </body>
</html>
