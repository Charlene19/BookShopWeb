<%-- 
    Document   : ajoutadresse
    Created on : 5 oct. 2020, 23:01:51
    Author     : jabar
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/css/adresseajout.css">
        <link rel="stylesheet" href="/css/templatecss.css">
        <link rel="stylesheet"  type="text/css"  href="bouton.css" />
    </head>

    <header><jsp:include page="/headerJsp.jsp" /></header>

    <body>

        <div id="font">

            <div class="div1"> Ajouter adresse</div>    
            <div class="div2" > 
                <div class="div2" id="div3">
                    <form method="post" action="adresse">
                        <label for="nom">Nom</label><br>
                        <input id="nom" type="text" name="nom" placeholder="Veillez entrer votre Nom"><br><br>
                        <label for="prenom">Prénom</label><br>
                        <input id="prenom" type="text" name="prenom" placeholder="Veillez entrer votre Prénom"><br><br>
                        <label for="societe">Société</label><br>
                        <input id="societe" type="text" name="societe" placeholder="Veillez entrer le nom de votre société"><br><br>
                        <label for="rue">rue</label><br>
                        <input id="rue" type="text" name="rue" placeholder="Veillez entrer votre numero et nom de rue"><br><br>
                        <label for="rue1">Bat,Eta</label><br>
                        <input id="rue1" type="text" name="rue1" placeholder="Veillez entrer votre Nom"><br><br>
                        <label for="ville">Ville</label><br>
                        <input id="ville" type="text" name="ville" placeholder="Vuillez entrer le nom de votre ville"><br><br>
                        <label for="codepostal">Code Postal</label><br>
                        <input id="codepostal" type="text" name="codepostal" placeholder="Veillez entrer votre code postal"><br><br>
                        <label for="portable">Portable</label><br>
                        <input id="portable" type="text" name="portable" placeholder="Vuillez entrer votre numéro de portable"><br><br>
                        <input type="hidden" name="type" value="${type}">
                        <button class="bttn-unite" type="submit" name="action" value="valider">Valider</button>
                    </form>
                </div>
            </div>  
        </div>
        <footer><jsp:include page="/footerJsp.jsp" /></footer>                 
    </body>
</html>
