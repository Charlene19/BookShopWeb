<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/css/templatecss.css">
        <title>Mon Panier</title>
    </head>
    <body>

        <header><jsp:include page="/headerJsp.jsp" /></header>

        <jsp:include page="shopping_cart.jsp"/>

        <footer><jsp:include page="/footerJsp.jsp" /></footer>   

    </body>
</html>
