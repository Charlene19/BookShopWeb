
<%@page import="model.dao.CommentDAO"%>
<%@page import="model.entity.Customer"%>
<%@page import="res.Values"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fiche du livre</title>
        <link rel="stylesheet" href="css/default.css" />
        <link rel="stylesheet"  type="text/css"  href="bouton.css" />
    </head>

    <body>


        <div class="k_box_page_content" id="k_box_book_page_content">

            <!-- page title container -->
            <div class="k_box_page_title">
                Fiche du livre
            </div>

            <label class="k_label_info">${message}</label>
            
            <div id="k_box_book_content">

                <jsp:useBean id="bookBean" scope="application" class="model.bean.BookBean" />
                <jsp:setProperty name="bookBean" property="book" value="${book}" />
                
                <div id="k_box_book_image">

                    <img src="${book.coverURL}" width="360" height="480" />
                    <br></br>
                    <form action="/shoppingcart" method="post">

                        <!-- This button could be disabled if the book is already in the shopping cart
                            and change its label too -->
                        <input type="hidden" name="isbn" value=${book.isbn} />

                        
                        <%-- If the book quantity is > 0 --%>
                        <c:if test="${!(bookBean.book.quantity <= 0) }" var="is_out_of_stock" scope="application">
                            <button class="bttn-unite" type="submit" name="action" value="add_book">Ajouter au panier</button>
                        </c:if>
                            
                        <%-- If the book quantity is <= 0 --%>   
                        <c:if test="${(bookBean.book.quantity <= 0)}" var="is_out_of_stock" scope="application">
                            <button class="bttn-unite" disabled >En rupture de stock</button>
                        </c:if>
                            
                    </form>
                </div>

                <div id="k_box_book_info">

                    <!-- title and subtitle container -->
                    <div id="k_book_info_title">
                        <label id="k_label_book_title">${book.title}</label><br>
                        <label id="k_label_book_subtitle">${book.subTitle} ( ${book.isbn} )</label><br>
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
                                + ${category.name}<br/> 
                            </c:forEach><br />
                                
                            Mots-clés : <br />
                            <c:forEach var="keyword" items="${book.keywords}">
                                + ${keyword.name}<br/> 
                            </c:forEach><br />
                        </div>

                        <div id="k_book_info_summary">
                            Resumé : ${book.summary}<br />
                        </div>
                    </div>

                    <div id="k_book_info_customer">
                        <label id="k_label_book_price">Prix: ${bookBean.fullPriceText} &euro;</label>
                        <label id="k_label_book_stock">Quantité disponible: ${book.quantity}</label>TTC
                        ${remise}
                    </div>
                </div>
            </div>

            <!-- book comments section -->
              

                <%
                    String isbn = request.getParameter("isbn"); 
                  if (session.getAttribute(Values.PARAM_CUSTOMER) != null){
         Customer customer = (Customer) session.getAttribute(Values.PARAM_CUSTOMER); 
        Long id = customer.getCustomerId(); 
        String cusId = String.valueOf(id); 
        CommentDAO commentDao = new CommentDAO(); 
        if(commentDao.autorise(cusId, isbn) == true){
        
            %>
             <%@include file="/commentJSP.jsp" %>
       
             <%}}%>
           
     
              
   
                <!-- title container -->
                <div class="k_box_page_title">
                    Commentaires
                </div>
            </div>
        </div>
    </body>
</html>
