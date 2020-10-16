<%-- 
    Document   : commentJSP
    Created on : 9 oct. 2020, 17:36:14
    Author     : cda611
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
        <script data-require="jquery@*" data-semver="2.2.0" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
        <link data-require="fontawesome@*" data-semver="4.5.0" rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.css" />
        <link rel="stylesheet" href="style.css" />
        <link rel="stylesheet"  type="text/css"  href="bouton.css" />

        <script src="script.js"></script>


        <title>JSP Page</title>
    </head>
    <body>
        <div class="authoComment">
            <!-- title container -->
            <div class="k_box_page_title">
                Commentaires
            </div>
            <!-- customer comment container -->
            <div id="k_box_book_comment">

                <!--  method should be POST
                 <form action="/commentServlet" method="post"> -->

                <div id="k_box_book_comment_title">
                    Titre du commentaire :
                    <input class="k_text_field" type="text" name="comment_title" />
                </div>

                <div id="k_box_book_comment_msg">
                    Message :
                    <textarea class="k_text_field" name="comment_msg" cols="50" rows="4"></textarea>
                </div>

                <input type="hidden" name="isbn" value="" />
                <div> <input type="number" name="rating" id="rating-input" min="1" max="5" /></div>


                <div class="rating" role="optgroup">
                    <!-- in Rails just use 1.upto(5) -->  
                    <i class="fa fa-star-o fa-2x rating-star" id="rating-1" data-rating="1" tabindex="0" aria-label="Rate as one out of 5 stars" role="radio"></i>
                    <i class="fa fa-star-o fa-2x rating-star" id="rating-2" data-rating="2" tabindex="0" aria-label="Rate as two out of 5 stars" role="radio"></i>
                    <i class="fa fa-star-o fa-2x rating-star" id="rating-3" data-rating="3" tabindex="0" aria-label="Rate as three out of 5 stars" role="radio"></i>
                    <i class="fa fa-star-o fa-2x rating-star" id="rating-4" data-rating="4" tabindex="0" aria-label="Rate as four out of 5 stars" role="radio"></i>
                    <i class="fa fa-star-o fa-2x rating-star" id="rating-5" data-rating="5" tabindex="0" aria-label="Rate as five out of 5 stars" role="radio"></i>
                </div>
                <script>

                    $(document).ready(function () {

                        function setRating(rating) {
                            $('#rating-input').val(rating);
                            // fill all the stars assigning the '.selected' class
                            $('.rating-star').removeClass('fa-star-o').addClass('selected');
                            // empty all the stars to the right of the mouse
                            $('.rating-star#rating-' + rating + ' ~ .rating-star').removeClass('selected').addClass('fa-star-o');
                        }

                        $('.rating-star')
                                .on('mouseover', function (e) {
                                    var rating = $(e.target).data('rating');
                                    // fill all the stars
                                    $('.rating-star').removeClass('fa-star-o').addClass('fa-star');
                                    // empty all the stars to the right of the mouse
                                    $('.rating-star#rating-' + rating + ' ~ .rating-star').removeClass('fa-star').addClass('fa-star-o');
                                })
                                .on('mouseleave', function (e) {
                                    // empty all the stars except those with class .selected
                                    $('.rating-star').removeClass('fa-star').addClass('fa-star-o');
                                })
                                .on('click', function (e) {
                                    var rating = $(e.target).data('rating');
                                    setRating(rating);
                                })
                                .on('keyup', function (e) {
                                    // if spacebar is pressed while selecting a star
                                    if (e.keyCode === 32) {
                                        // set rating (same as clicking on the star)
                                        var rating = $(e.target).data('rating');
                                        setRating(rating);
                                    }
                                });
                    });
                </script>

                <div class="k_right">
                    <button class="bttn-unite" onclick="myFunction()">Envoyer le commentaire</button>
                </div>
                <div>
                    <button class="bttn-unite" type="button"><a href="myAccount.jsp">Retour</a></button>
          </div>
                
                <script>
                    function myFunction() {
                        alert("Commentaire enregistré ! Merci");
                       
                    }
                </script>

            </div>

            <!-- </form> -->

        </div>


    </body>
</html>
