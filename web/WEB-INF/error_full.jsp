<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erreur</title>
        <meta name="description" content="">
        <link rel="stylesheet" href="css/templatecss.css">
    </head>


    <body>
        <header>
            <jsp:include page="/headerJsp.jsp" />
        </header>

        <section>
            <h1>Erreur</h1>

            <p>${error_msg}</p>
            <ul>
                <li><a onclick="goBack()">Précédent</a></li>
                <script>
                    function goBack() {
                        window.history.back();
                    }
                </script>

                <li><a href="HomePage">Page d'accueil</a></li>

            </ul>
        </section>

        <footer>
            <jsp:include page="/footerJsp.jsp" />
        </footer>

    </body>
</html>

