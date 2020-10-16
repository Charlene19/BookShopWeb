<%-- 
    Document   : PaymentInfoMastercard
    Created on : 9 oct. 2020, 17:38:49
    Author     : Loïc
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"  type="text/css"  href="css/templatecss.css"/>
        <title>Paiement bancaire</title>
    </head>
    <body>

        <header><img src="logos/Banque Honnête.png" class="headerBank"></header>

        <div class="bankText">
            <h1>Paiement par Mastercard</h1>


            <p><img src="logos/Mastercard.png" class="logoBank">Règlement à Bookshop du montant de ${bean_shopping_cart.totalFullPriceText} euros.<br>
                <span class="errorBank">${messageMC}</span><br>
                Veuillez entrer les informations de paiement suivantes :</p>
            <form action="ServletPayMC" method="post">
                <table class="bankTable">
                    <tr>
                    <label>
                        <td>Titulaire de la Mastercard</td>
                        <td><input type="text" name="lName">*</td>
                    </label>
                    </tr>
                    <tr>
                    <label>
                        <td>Numéro de carte</td>
                        <td><input type="text" name="digitsMC">*</td>
                    </label>
                    </tr>
                    <tr>
                    <label>
                        <td>Numéro de sécurité à 3 chiffres</td>
                        <td><input type="text" name="secuMC">*</td>
                    </label>
                    </tr>
                    <tr>
                    <label>
                        <td>Date d'expiration</td>
                        <td>Mois <select name="mois">
                                <option>01</option>
                                <option>02</option>
                                <option>03</option>
                                <option>04</option>
                                <option>05</option>
                                <option>06</option>
                                <option>07</option>
                                <option>08</option>
                                <option>09</option>
                                <option>10</option>
                                <option>11</option>
                                <option>12</option>
                            </select>
                            Année <select name="annee">
                                <option>2021</option>
                                <option>2022</option>
                                <option>2023</option>
                                <option>2024</option>
                            </select></td>
                    </label>
                    </tr>


                </table>

                <p>Les champs marqués d'un astérisque * doivent impérativement être renseignés.</p>

                <input type="submit" value="Valider" name="valider" />

            </form>
            <form action="ordervalidation">
                <input type="submit" value="Annuler" name="annuler" />
            </form>

        </div>


    </body>
</html>
