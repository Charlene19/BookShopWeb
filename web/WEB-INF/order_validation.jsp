<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="k_box_page_content">
    <link rel="stylesheet"  type="text/css"  href="bouton.css" />
    <!-- page title container -->
    <div class="k_box_page_title">
        Ma commande
    </div>

    <!-- page content container -->
    <div id="k_box_shopping_cart_content">

        <jsp:useBean id="bean_shopping_cart" scope="session" class="model.bean.ShoppingCartBean" />

        <!-- displayed when unexpected stuffs happen -->
        <label class="k_label_error">${error_msg}</label>

        <!-- Informative message -->
        <label class="k_label_info">${message}</label>



        <!-- Contains products -->
        <table class="k_table_form" id="k_table_form_shopping_cart">
            <form action="ordervalidation" method="post">
                <tr>
                    <th>Titre</th>
                    <th>Prix HT</th>
                    <th>&nbsp;&nbsp;TVA&nbsp;&nbsp;</th>
                    <th>Prix TTC</th>
                    <th>Remise</th>
                    <th>Quantité</th>
                    <th>Prix Total HT</th>
                    <th>Prix Total TTC</th>
                </tr>

                <jsp:useBean id="bookBean" scope="request" class="model.bean.BookBean" />

                <c:forEach var="book" items="${bean_shopping_cart.books}">

                    <jsp:setProperty name="bookBean" property="book" value="${book}" />
                    <!-- This whole tr contains product's info -->
                    <tr>
                    <input type="hidden" name="ref" value="15684" />
                    <td><a href="book?isbn=${book.isbn}">${book.title}</a></td>
                    <td>${bookBean.priceText} &euro;</td>
                    <td>${bookBean.book.vat.rate} %</td>
                    <td>${bookBean.fullPriceText} &euro;</td>
                    <td>N/A</td>
                    <td>${bookBean.book.cartQuantity}</td>
                    <td>${bookBean.priceTotalText} &euro;</td>
                    <td>${bookBean.fullPriceTotalText} &euro;</td>
                    </tr>
                </c:forEach>

            </form>
        </table>
        <br/>

        <div id="k_box_order_validation_total">
            <!-- Contains products -->
            <table class="k_table_form" id="k_table_form_shopping_cart">
                <form>
                    <tr>
                        <th>Prix Total HT</th>
                        <th>Prix Total TTC</th>
                    </tr>
                    <tr>
                        <td>${bean_shopping_cart.totalPriceText} &euro;</td>
                        <td>${bean_shopping_cart.totalFullPriceText} &euro;</td>
                    </tr>
                </form>
            </table>
        </div>

        <!-- This has to be displayed only if the cart contains products -->
        <form action="ordervalidation" method="post">

            <br/><br/>
            <br/><br/>

            <div id="k_box_order_validation_total">

                <table class="k_table_form" id="k_table_form_shopping_cart">
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>
                            <%-- Shipping offer selection --%>
                            <label>Mode de livraison</label>
                        </th>
                        <td>
                            <select id="shipping_offers" name="shipping_offer">
                                <c:forEach var="shippingOffer" items="${bean_order_val.genericShippingOffers}">
                                    <option name="shippingOffer" value="${shippingOffer.shippingOfferId}">${shippingOffer.shippingOfferName} - ${shippingOffer.shippingOfferDetails}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>
                            <%-- Delivery Address selection --%>
                            <label>Addresse de livraison</label>
                        </th>
                        <td>
                            <%-- If the customer has at least one address --%>
                            <c:if test="${customer.deliveryAddresses.size() > 0 ? true : false}">
                                <select id="delivery_addresses" name="delivery_address">
                                    <c:forEach var="delivery_address" items="${customer.deliveryAddresses}">
                                        <option name="delivery_address" value="${delivery_address.id}">${delivery_address.firstName} ${delivery_address.lastName} ${delivery_address.street}</option>
                                    </c:forEach>
                                </select>
                            </c:if>
                            <br/><a href="/adresse?action=livraison">Ajouter une adresse...</a>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <%-- Billing Address selection --%>
                            <label>Addresse de facturation</label>
                        </th>
                        <td>
                            <%-- If the customer has at least one address --%>
                            <c:if test="${customer.billingAddresses.size() > 0}">
                                <select id="billing_addresses" name="billing_address">
                                    <c:forEach var="billing_address" items="${customer.billingAddresses}">
                                        <option name="billing_address" value="${billing_address.id}">${billing_address.firstName} ${billing_address.lastName} ${billing_address.street}</option>
                                    </c:forEach>
                                </select>
                            </c:if>
                            <br/><a href="/adresse?action=facturation">Ajouter une adresse...</a>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>
                            <%-- Card type selection --%>
                            <label>Type de Carte</label>
                        </th>
                        <td> 
                            <br/>
                            <input type="radio" name="card" value="VISA" checked="checked"/>Visa<br/>
                            <input type="radio" name="card" value="MASTERCARD" />MasterCard<br/>
                            <input type="radio" name="card" value="AMEX" />American Express<br/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </div> 

            <div id="k_box_shopping_cart_actions">

                <div id="k_box_shopping_cart_clear">
                    <button class="bttn-unite" type="submit" name="action" value="cart">Revenir au panier</button>
                </div>

                <div id="k_box_shopping_cart_order">
                    <button class="bttn-unite" type="submit" name="action" value="create_order">Valider cette commande</button>
                </div>

            </div>
        </form>
    </div>
</div>