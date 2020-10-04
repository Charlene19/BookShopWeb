<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fiche du livre</title>
        <link rel="stylesheet" href="css/default.css" />
    </head>

    <body>


        <div class="k_box_page_content" id="k_box_book_page_content">

            <!-- page title container -->
            <div class="k_box_page_title">
                Fiche du livre
            </div>

            <div id="k_box_book_content">

                <div id="k_box_book_image">

                    <img src="${book.coverURL}" />
                    <br></br>
                    <form action="/shopping_cart.html" method="get">

                        <!-- This button could be disabled if the book is already in the shopping cart
                            and change its label too -->
                        <button class="k_button" type="submit" name="action" value="add_book">Ajouter au panier</button>
                        <input type="hidden" name="ref" value=${book} />
                    </form>
                </div>

                <div id="k_box_book_info">

                    <!-- title and subtitle container -->
                    <div id="k_book_info_title">
                        <label id="k_label_book_title">${book.title}</label><br>
                        <label id="k_label_book_subtitle">${book.subTitle}</label>
                    </div>

                    <!-- author, publisher, summary etc -->
                    <div id="k_box_book_details">

                        <div id="k_box_book_plus">
                            
                            Auteur : 
                            <c:forEach var="author" items="${book.authors}">
                                ${author.firstName} ${author.lastName}
                            </c:forEach><br/><br/>
                                
                            Editeur : ${book.publisher}<br/><br/>
                            
                            Categories : <br />
                            <c:forEach var="category" items="${book.categories}">
                                ${category.name}<br/> 
                            </c:forEach><br />
                                
                            Mots-clés : <br />
                            <c:forEach var="keyword" items="${book.keywords}">
                                ${keyword.name}<br/> 
                            </c:forEach><br />
                        </div>

                        <div id="k_book_info_summary">
                            Resumé : ${book}<br />
                        </div>
                    </div>

                    <div id="k_book_info_customer">
                        <label id="k_label_book_price">Prix: ${book.price}€</label>
                        <label id="k_label_book_stock">Quantité disponible: ${book.quantity}</label>
                    </div>
                </div>
            </div>

            <!-- book comments section -->
            <div id="k_box_book_comments">

                <!-- title container -->
                <div class="k_box_page_title">
                    Commentaires
                </div>
            </div>
        </div>
    </body>
</html>
