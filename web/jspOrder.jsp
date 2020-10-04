<%@page import="res.Values"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : jspEvent
    Created on : 29 sept. 2020, 15:47:40
    Author     : cda611
--%>


<%@page import="model.entity.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Order</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="templatecss.css">
        <meta charset="UTF-8">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>

        <hr>

        <%@include file="headerJsp.jsp" %>  
        <!-- Premiere ligne sous l'en tete -->
        <div>
            <div> Vos commandes  <a href="cadeau" >Achat Cadeau</a> </div>
        </div>

        <div> 
            <form name="order" action="searchOrder" method="post">
                <input type="text" name="inputOrder" value="Recherche par ID" /><input type="image" name="doSearch" src="img/buton1.png">
            </form>
        </div>


        <h3> Dernier mois</h3>  

        <div class="container"> 
            <div class="row">  



                <c:forEach var="book" items="${listMonth}">

                    <div class="col-sm-4"> 
                        <figure>  <p><a href="book?isbn=${book.isbn} "><img src ="${book.coverURL}" width="150" height="200"  alt= "" /></a>
                            <h3>  ${book.title}  </h3>

                            <p>   ${book.postIt} </p>
                            <p>  ${book.price}  Euros</p>

                            <br></br><br></br>
                    </div> 
                </div>


            </c:forEach>


            <h3> 6 derniers mois</h3> 

            <div class="container"> 
                <div class="row">  



                    <c:forEach var="book" items="${listSixMonth}">

                      

                        <div class="col-sm-4"> 
                            <figure>  <p><a href="book?isbn=${book.isbn} "><img src ="${book.coverURL}" width="150" height="200"  alt= "" /></a>
                                <h3>  ${book.title}  </h3>

                                <p>   ${book.postIt} </p>
                                <p>  ${book.price}  Euros</p>

                                <br></br><br></br>
                        </div> 
                    </div>


                </c:forEach>




                <h3> Plus de 6 mois</h3> 

                <div class="container"> 
                    <div class="row">


                        <c:forEach var="book" items="${listPast}">


                            <div class="col-sm-4"> 
                                <figure>  <p><a href="book?isbn=${book.isbn} "><img src ="${book.coverURL}" width="150" height="200"  alt= "" /></a>
                                    <h3>  ${book.title}  </h3>

                                    <p>   ${book.postIt} </p>
                                    <p>  ${book.price}  Euros</p>

                                    <br></br><br></br>
                            </div> 
                        </div>


                    </c:forEach>



                    <%@include file="footerJsp.jsp" %>  


                    </body>

                    </html>