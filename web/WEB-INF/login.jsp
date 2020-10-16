<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/default.css" />
        <link rel="stylesheet" href="bouton.css" />
    </head>
    <body>
        
    <!-- page title container -->
    <div class="k_box_page_title">
        Mon compte
    </div>
    
    <label class="k_label_info">${message}</label>

    <!-- page content container -->
    <div class="k_box_account" id="k_box_account_content">

        
        <!-- login container -->
        <div class="k_box_account" id="k_box_account_login">

            <table class="k_table_form">
                <form action="login" method="post">
                    
                    <input type="hidden" name="origin" value="${origin}" />
                    <tr>
                        <th>Se connecter</th>
                    </tr>
                    <tr>
                        <td>
                            Email<br />
                            <input class="k_text_field" type="text" name="email" value="${email}" />
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
                            ${error_message}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="bttn-unite" type="submit" name="action" value="login">Connexion</button>
                        </td>
                    </tr>
                </form>
            </table>

        </div>

        <!-- account creation container -->
        <div class="k_box_account" id="k_box_account_create">
            <table class="k_table_form">
                <tr>
                    <th>S'enregistrer</th>
                </tr>
                <tr>
                    <td>
                        <form action="servletRegister" method="post">
                            <button class="bttn-unite" type="submit" name="action" value="register">Creer un compte</button>
                        </form>

                    </td>
                </tr>
            </table>
        </div>

    </div>
    </body>
</html>
