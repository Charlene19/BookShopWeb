<%-- 
    Document   : validPay
    Created on : 8 oct. 2020, 19:04:10
    Author     : Loïc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validation du paiement</title>
    </head>
    <body>
        <p>Faut-il valider le règlement soumis ?</p>
        
        <form action="ordervalidation" method="POST">
            <input type="submit" value="oui" name="action"/>
            <input type="submit" value="non" name="action"/>
        </form>
    </body>
</html>
