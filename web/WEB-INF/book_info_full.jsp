<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="stylesheet" href="/css/templatecss.css">
        <title>Fiche du livre</title>
    </head>
    
    <body>

        <header><jsp:include page="/headerJsp.jsp" /></header>

        <jsp:include page="book_info.jsp"/>

        <footer><jsp:include page="/footerJsp.jsp" /></footer>   

    </body>
</html>