<%-- 
    Document   : register
    Created on : Sep 29, 2020, 9:42:47 AM
    Author     : Cy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/default.css" />
        <title>JSP Page</title>
    </head>
    <body>
     
    <!-- page title container -->
    <div class="k_box_page_title">
        Mon compte
    </div>

    <!-- page content container -->
    <div class="k_box_account" id="k_box_account_content">

        <!-- fields container -->
        <div class="k_box_account" id="k_box_account_login">


            <table class="k_table_form">
                <form action="servletRegister" method="post">
                    <tr>
                        <th>Creation de compte</th>
                    </tr>
                    <tr>
                        <td>
                            Nom<br />
                            <input class="k_text_field" type="text" name="last_name" value="${last_name}" />

                        </td>
                    </tr>
                    <tr>
                        <td>
                            Prénom<br />
                            <input class="k_text_field" type="text" name="first_name" value="${first_name}" />

                        </td>
                    </tr>
                    <tr>
                        <td>
                            Adresse email<br />
                            <input class="k_text_field" type="text" name="email" value="${email}" />

                        </td>
                    </tr>
                    <tr>
                        <td>
                            Nom d'utilisateur<br />
                            <input class="k_text_field" type="text" name="username" value="${username}" />

                        </td>
                    </tr>
                    <tr>
                        <td>
                            Mot de passe<br />
                            <input class="k_text_field" type="password" name="password" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td class="k_label_error">
                            ${msg}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="k_button" type="submit" name="action" value="register">Creer le compte</button>
                        </td>
                    </tr>
                </form>
            </table>
        </div>
    </div>
</body>
</html>
