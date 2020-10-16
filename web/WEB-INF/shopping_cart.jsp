<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/default.css" />
        <link rel="stylesheet" href="bouton.css" />
    </head>

    <body>

        <div class="k_box_page_content">

            <!-- page title container -->
            <div class="k_box_page_title">
                Mon Panier
            </div>

            <!-- page content container -->
            <div id="k_box_shopping_cart_content">

                <label class="k_label_error">${error_message}</label>

                <label class="k_label_info">${message}</label>


                <!-- If the cart is empty -->
                <c:if test="${!isEmpty}">

                    <!-- This has to be displayed only if the cart contains products -->
                    <table class="k_table_form" id="k_table_form_shopping_cart">

                        <tr>
                            <th>Produit</th>
                            <th>Prix unitaire TTC</th>
                            <th>Quantité</th>
                            <th>Prix total TTC</th>
                            <th>Ajouter</th>
                            <th>Retirer</th>
                            <th>Supprimer</th>
                        </tr>
                        <jsp:useBean id="bookBean" scope="application" class="model.bean.BookBean" />

                        <c:forEach var="book" items="${books}">
                            <form action="shoppingcart" method="post">
                                <jsp:setProperty name="bookBean" property="book" value="${book}" />
                                <!-- This whole tr contains product's info -->
                                <tr>
                                <input type="hidden" name="isbn" value="${book.isbn}" />
                                <td><a href="book?isbn=${book.isbn}">${book.title}</a></td>
                                <td>${bookBean.fullPriceText} &euro;</td>
                                <td>${book.cartQuantity}</td>
                                <td>${bookBean.fullPriceTotalText} &euro;</td>
                                <td><button class="bttn-unite" type="submit" name="action" value="inc_book">+1</button></td>
                                <td><button class="bttn-unite" type="submit" name="action" value="dec_book">-1</button></td>
                                <td><button class="bttn-unite" type="submit" name="action" value="rem_book">X</button></td>
                                </tr>
                            </form>
                        </c:forEach>

                    </table>
                        
                    <div id="k_box_order_validation_total">
                        <table class="k_table_form" id="k_table_form_shopping_cart">
                                <tr>
                                    <th>Prix Total TTC : ${bean_shopping_cart.totalFullPriceText} &euro;</th>
                                </tr>
                        </table>
                    </div>
                        
                    <!-- This has to be displayed only if the cart contains products -->
                    <form action="shoppingcart" method="post">
                        <div id="k_box_shopping_cart_actions">

                            <div id="k_box_shopping_cart_clear">
                                <button class="bttn-unite" type="submit" name="action" value="empty_cart">Vider le panier</button>
                            </div>

                            <div id="k_box_shopping_cart_order">
                                <button class="bttn-unite" type="submit" name="action" value="create_order">Commander</button>
                            </div>

                        </div>
                    </form>

                </c:if>

            </div>
        </div>
    </body>
</html>
