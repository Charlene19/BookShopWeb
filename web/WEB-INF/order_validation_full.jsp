<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/css/templatecss.css">
        <title>Validation commande</title>
    </head>
    <body>
        
        <header><jsp:include page="/headerJsp.jsp" /></header>
        
        <jsp:include page="order_validation.jsp"/>
        
        <footer><jsp:include page="/footerJsp.jsp" /></footer>
        
    </body>
</html>
