<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>



    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Bookshop - Modification de votre compte</title>
        <meta name="description" content="">
        <link rel="stylesheet" href="css/templatecss.css">
    </head>


    <body>



        <header>
            <jsp:include page="headerJsp.jsp" />
        </header>


        <!-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
        -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        CODE POUR LE HAUT DE PAGE
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->




        <section>
            <h2>Modification des informations</h2>

            <div>
                Tous les champs marqués d'un astérisque * doivent impérativement être renseignés afin de valider les modifications.
                <br><br>
                NB. Les caractères spéciaux et accentués ne sont pas autorisés.
                <br>
                ${message}
                <br /><br>
            </div>

            <form action="/ServletMyAccount" method="post">
                <table>
                    <tr>
                    <label>
                        <td>Nom (50 caractères maximum)</td>
                        <td><input type="text" name="lName" value="${customer.customerLName}">*</td>
                    </label>
                    </tr>

                    <tr>
                    <label>
                        <td>Prénom (50 caractères maximum)</td>
                        <td><input type="text" name="fName" value="${customer.customerFName}">*</td>
                    </label>
                    </tr>

                    <tr>
                    <label>
                        <td>Pseudonyme (20 caractères maximum)</td>
                        <td><input type="text" name="pseudo" value="${customer.customerUsername}">*</td>
                    </label>
                    </tr>

                    <tr>
                    <label>
                        <td>Nouveau mot de passe</td>
                        <td><input type="password" name="newPassword" placeholder="Nouveau mot de passe">*<td/>
                    </label>
                    </tr>

                    <tr>
                    <label>
                        <td>Confirmer le mot de passe</td>
                        <td><input type="password" name="newPasswordConf" placeholder="Confirmer le mot de passe">*</td>
                    </label>
                    </tr>

                </table>

                <br>
                <span></span>

                <section>

                    <button class="bttn-unite" type="submit">Confirmer</button>
                    <input class="bttn-unite" type="reset" name="" value="Restaurer les valeurs initiales">
                    <button class="bttn-unite" type="submit" formaction="myAccount.jsp">Annuler</button>
                </section>
            </form>    
        </section>




        <!-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
        -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        CODE POUR LE PIED DE PAGE
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->



    </div>

    <footer>
        <jsp:include page="footerJsp.jsp" />
    </footer>

</body>

<!-- Site web créé par la fine équipe -->


</html>
