<%@page import="res.Values"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : jspEvent
    Created on : 29 sept. 2020, 15:47:40
    Author     : cda611
--%>

<%@page import="model.entity.Book"%>

<%@page import="model.entity.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Order</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/templatecss.css">
        <meta charset="UTF-8">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    </head>
    <body>

        
        <%@include file="headerJsp.jsp" %>  
        <!-- Premiere ligne sous l'en tete -->
        <div style="margin-left:40px">
            <div> Vos commandes  </div>
      
            <%@include file="searchOrder.html" %>  

        </div>

    <center> 
        <h3> Dernier mois</h3>  
        <br> </br> <br> </br>
 </center> 
       



            <!-- bean used to round up price -->
            <jsp:useBean id="bookBean" scope="application" class="model.bean.BookBean" />

            <c:forEach var="book" items="${listMonth}">
                
                <jsp:setProperty name="bookBean" property="book" value="${book}" />
                
                 <div class="container"> 
                <div class="row">  
                    <div class="col-sm-4"> 
                        <figure>  <p><a href="book?isbn=${book.isbn} "><img src ="${book.coverURL}" width="150" height="200"  alt= "" /></a>
                            <h3>  ${book.title}  </h3>

                            <p>   ${book.postIt} </p>
                            <p>  ${bookBean.priceText}  Euros HT</p>


                            <br></br><br></br>
                    </div> 
                </div>


            </c:forEach>

                     <center>
            <h3> 6 derniers mois</h3> 
<br> </br> <br> </br>
          </center>




                <c:forEach var="book" items="${listSixMonth}">


                    <jsp:setProperty name="bookBean" property="book" value="${book}" />
  <div class="container"> 
                    <div class="row">  
                        <div class="col-sm-4"> 
                            <figure>  <p><a href="book?isbn=${book.isbn} "><img src ="${book.coverURL}" width="150" height="200"  alt= "" /></a>
                                <h3>  ${book.title}  </h3>

                                <p>   ${book.postIt} </p>

                                <p>  ${bookBean.priceText}  Euros HT</p>


                                <br></br><br></br>
                        </div> 
                    </div>


                </c:forEach>



 <center>
                <h3> Plus de 6 mois</h3> 
<br> </br> <br> </br>
                </center>



                    <c:forEach var="book" items="${listPast}">

                        
                        <jsp:setProperty name="bookBean" property="book" value="${book}" />
                        
                        <center>
                        <div class="container"> 
                        <div class="row">
                            <div class="col-sm-4"> 

                                <figure>  <p><a href="book?isbn=${book.isbn} "><img src ="${book.coverURL}" width="150" height="200"  alt= "" /></a>
                                    <h3>  ${book.title}  </h3>

                                    <p>   ${book.postIt} </p>

                                    <p>  ${bookBean.priceText}  Euros HT</p>

                                    <br></br><br></br>
                            </div> 
                        </div>
</center>

                    </c:forEach>



                    <%@include file="footerJsp.jsp" %>  


                    </body>

                    </html>