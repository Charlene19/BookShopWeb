
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="res.Values"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>

<html lang="en">

    <head>

        <meta charset="utf-8">
        <!--[if IE]><meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'><![endif]-->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="assets/img/ico/favicon.ico">
        <link rel="apple-touch-icon" sizes="144x144" href="assets/img/ico/apple-touch-icon-144x144.png">
        <link rel="apple-touch-icon" sizes="114x114" href="assets/img/ico/apple-touch-icon-114x114.png">
        <link rel="apple-touch-icon" sizes="72x72" href="assets/img/ico/apple-touch-icon-72x72.png">
        <link rel="apple-touch-icon" href="assets/img/ico/apple-touch-icon-57x57.png">

        <title>Bienvenue sur BookShop</title>

        <!-- Bootstrap Core CSS -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/animate.css" rel="stylesheet">
        <link href="assets/css/plugins.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="assets/css/style.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="assets/css/pe-icons.css" rel="stylesheet">

    </head>

    <body id="page-top" class="index">

        <div class="master-wrapper">

            <div class="preloader">
                <div class="preloader-img">
                    <span class="loading-animation animate-flicker"><img src="assets/img/loading.GIF" alt="loading"/></span>
                </div>
            </div>

            <!-- Navigation -->

            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header page-scroll">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#main-navigation">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand smoothie logo" href="homePageJsp.jsp"><img src="assets/img/logoN2.png" alt="logo"></a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->



                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="main-navigation">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Mon compte <span class="pe-7s-angle-down"></span></a>
                            <ul class="dropdown-menu">
                                <li> <a href="login">Se connecter</a></li>
                                <li class="dropdown-submenu">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Mes commandes</a>

                                    <ul class="dropdown-menu">
                                        <li><a href="index-agency-1.html">Commandes passées</a></li>
                                        <li><a href="index-agency-2.html">Commande active</a></li>

                                    </ul>
                                </li>        
                            </ul>
                        </li>   
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown">Gestion compte <span class="pe-7s-angle-down"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="header-1.html">Paramètres de sécurisation</a></li>
                                <li><a href="header-2.html">Gestion des adresses</a></li>


                            </ul>
                        </li>

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown">Panier <span class="pe-7s-angle-down"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="WEB-INF/shopping_cart.jsp">Mon panier</a></li>
                                <li><a href="index-corporate-2.html">Historique de navigation</a></li>
                                <li><a href="index-corporate-3.html">Suggestion</a></li>

                            </ul>
                        </li>


                        <li><a href="#search"><i class="pe-7s-search"></i></a></li>
                        <li><a href="#flexpanel" class="side-menu-trigger hidden-xs"><i class="fa fa-bars"></i></a></li>
                    </ul>
                </div>
            </div> 



            <div id="search-wrapper">
                <button type="button" class="close">×</button>



                <script>function sendData(data) {
                        var XHR = new XMLHttpRequest();
                        var urlEncodedData = "/Resultats";
                        var urlEncodedDataPairs = [];
                        var name;
                        var formElement = document.querySelector("recherche");

                        // Transformez l'objet data en un tableau de paires clé/valeur codées URL.
                        for (formElement in data) {
                            urlEncodedDataPairs.push(encodeURIComponent(formElement) + '=' + encodeURIComponent(data[formElement]));
                        }

                        // Combinez les paires en une seule chaîne de caractères et remplacez tous
                        // les espaces codés en % par le caractère'+' ; cela correspond au comportement
                        // des soumissions de formulaires de navigateur.
                        urlEncodedData = urlEncodedDataPairs.join('&').replace(/%20/g, '+');

                        // Définissez ce qui se passe en cas de succès de soumission de données
                        XHR.addEventListener('load', function (event) {
                            window.location.href = '/Resultats';
                            XHR.send(urlEncodedData);
                        });

                        // Définissez ce qui arrive en cas d'erreur
                        XHR.addEventListener('error', function (event) {
                            alert('Oups! Quelque chose s\'est mal passé.');
                        });

                        // Configurez la requête
                        XHR.open('POST', '/Resultats');

                        // Ajoutez l'en-tête HTTP requise pour requêtes POST de données de formulaire 
                        XHR.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

                        // Finalement, envoyez les données.
                        XHR.send(urlEncodedData);
                    }</script>
                <div class="vertical-center text-center">

                    <div id="formSearch">    
                        <form id="formSearch" method="post" action="Resultats">
                            <input type="text" name="recherche" value="" placeholder="Enter Search Term" />
                            <button type="button" onclick="sendData({test: 'ok'})"> Search </button>
                        </form>
                    </div>

                </div>
            </div>


        <!-- Header -->
        <header id="headerwrap" class="fullheight dark-wrapper opaqued parallax" data-parallax="scroll" data-image-src="assets/img/bg/bg5.jpg" data-speed="0.7">
            <div class="container vertical-center">
                <div class="intro-text vertical-center text-left smoothie">
                    <div class="intro-heading wow fadeIn heading-font" data-wow-delay="0.2s">404</div>
                    <div class="intro-sub-heading wow fadeIn secondary-font" data-wow-delay="0.4s"><span class="rotate">The requested URL, isnt here im afraid.</span></div>
                </div>
            </div>
        </header>
           <ul>
            <li><a onclick="goBack()">Précédent</a></li>
            <script>
                function goBack() {
                window.history.back();
                }
            </script>
            
            <li><a href="/HomePage">Page d'accueil</a></li>
            
        </ul>

      
                        <div id="footer-wrapper" class="footer-image-bg">
                            <section class="transparent-wrapper">
                                <div class="section-inner">
                                    <div class="container">
                                        <div class="row">
                                            <div class="col-md-4">
                                                <div class="widget about-us-widget">
                                                    <h4 class="widget-title"><strong>BookShop</strong> Actus</h4>
                                                    <p>Professionally monetize team building materials for 24/7 results. Holisticly transition corporate platforms vis-a-vis cutting-edge experiences. Dynamically strategize ubiquitous applications for premier initiatives. Interactively seize resource sucking niche markets.</p>
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="widget">
                                                    <h4 class="widget-title"><strong>Blog</strong> Littéraires</h4>
                                                    <div>
                                                        <div class="media">
                                                            <div class="pull-left">
                                                                <img class="widget-img" src="assets/img/widget/widget1.jpg" alt="">
                                                            </div>
                                                            <div class="media-body">
                                                                <span class="media-heading"><a href="#">Blog Post A</a></span>
                                                                <small class="muted">Posted 14 April 2015</small>
                                                            </div>
                                                        </div>
                                                        <div class="media">
                                                            <div class="pull-left">
                                                                <img class="widget-img" src="assets/img/widget/widget2.jpg" alt="">
                                                            </div>
                                                            <div class="media-body">
                                                                <span class="media-heading"><a href="#">Blog Post B</a></span>
                                                                <small class="muted">Posted 14 April 2015</small>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="widget">
                                                    <h4 class="widget-title">Catégories populaires</h4>
                                                    <div class="tagcloud">
                                                        <a href="#" class="tag-link btn btn-theme btn-white btn-xs smoothie" title="3 topics"> Littérature </a>
                                                        <a href="#" class="tag-link btn btn-theme btn-white btn-xs smoothie" title="3 topics"> BD </a>
                                                        <a href="#" class="tag-link btn btn-theme btn-white btn-xs smoothie" title="3 topics"> Roman </a>
                                                        <a href="#" class="tag-link btn btn-theme btn-white btn-xs smoothie" title="3 topics"> Historique </a>
                                                        <a href="#" class="tag-link btn btn-theme btn-white btn-xs smoothie" title="3 topics"> Medécine </a>
                                                        <a href="#" class="tag-link btn btn-theme btn-white btn-xs smoothie" title="3 topics"> Mode </a>
                                                        <a href="#" class="tag-link btn btn-theme btn-white btn-xs smoothie" title="3 topics"> Actualité </a>
                                                        <a href="#" class="tag-link btn btn-theme btn-white btn-xs smoothie" title="3 topics"> Sciences </a>
                                                        <a href="#" class="tag-link btn btn-theme btn-white btn-xs smoothie" title="3 topics"> Economique </a>
                                                        <a href="#" class="tag-link btn btn-theme btn-white btn-xs smoothie" title="3 topics"> Musique </a>
                                                        <a href="#" class="tag-link btn btn-theme btn-white btn-xs smoothie" title="3 topics"> Sociologie </a>
                                                        <a href="#" class="tag-link btn btn-theme btn-white btn-xs smoothie" title="3 topics">Philosophie </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </section>

                            <footer class="white-wrapper">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-md-6 text-left match-height">
                                            <ul class="list-inline social-links wow">
                                                <li>
                                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                                </li>
                                                <li>
                                                    <a href="#"><i class="fa fa-pinterest"></i></a>
                                                </li>
                                                <li>
                                                    <a href="#"><i class="fa fa-dribbble"></i></a>
                                                </li>
                                                <li>
                                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                                </li>
                                                <li>
                                                    <a href="#"><i class="fa fa-behance"></i></a>
                                                </li>
                                                <li>
                                                    <a href="#"><i class="fa fa-linkedin"></i></a>
                                                </li>
                                            </ul>
                                        </div>

                                        <div class="col-md-6 text-right match-height">
                                            <div class="vertical-center">
                                                <span class="copyright">Copyright 2019. Designed by DISTINCTIVE THEMES</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </footer>
                        </div>

                    </div>

                    <div class="flexpanel">
                        <div class="viewport-wrap">
                            <div class="viewport">
                                <div class="widget mb50">
                                    <h4 class="widget-title">Recherche avancée</h4>
                                    <div>
                                        <jsp:include page="advancedSearch.html" />
                                    </div>
                                </div>
                            </div>
                            <div class="widget mb50">
                                <h4 class="widget-title"><strong>Latest</strong> Articles</h4>
                                <div class="tagcloud">
                                     <a href="advSearchServlet?category=categorie_B" class="tag-link btn btn-theme btn-xs" title="3 topics">Local</a>
                                    <a href="advSearchServlet?category=categorie_C" class="tag-link btn btn-theme btn-xs" title="3 topics">Business</a>
                                    <a href="advSearchServlet?category=categorie_A_0" class="tag-link btn btn-theme btn-xs" title="3 topics">Media</a>
                                    <a href="advSearchServlet?category=categorie_A_1" class="tag-link btn btn-theme btn-xs" title="3 topics">Photogtraphy</a>
                                    <a href="advSearchServlet?category=categorie_C" class="tag-link btn btn-theme btn-xs" title="3 topics">Aid</a>
                                    <a href="advSearchServlet?category=categorie_A_0" class="tag-link btn btn-theme btn-xs" title="3 topics">Fashion</a>
                                    <a href="advSearchServlet?category=categorie_A_1" class="tag-link btn btn-theme btn-xs" title="3 topics">News</a>
                                    <a href="advSearchServlet?category=categorie_A_0" class="tag-link btn btn-theme btn-xs" title="3 topics">Cars</a>
                                    <a href="advSearchServlet?category=categorie_A_0" class="tag-link btn btn-theme btn-xs" title="3 topics">Global Affairs</a>
                                    <a href="advSearchServlet?category=categorie_B" class="tag-link btn btn-theme btn-xs" title="3 topics">Music</a>
                                    <a href="advSearchServlet?category=categorie_B" class="tag-link btn btn-theme btn-xs" title="3 topics">Downloads</a>
                                    <a href="advSearchServlet?category=categorie_B" class="tag-link btn btn-theme btn-xs" title="3 topics">MP3</a>
                                </div>
                            </div>
                            <div class="widget about-us-widget mb50">
                                <h4 class="widget-title">About Kompleet</h4>
                                <p>Professionally monetize team building materials for 24/7 results. Holisticly transition corporate platforms vis-a-vis cutting-edge experiences. Dynamically strategize ubiquitous applications for premier initiatives. Interactively seize resource sucking niche markets.</p>
                            </div>
                        </div>
                    </div>
                    <script src="assets/js/jquery.js"></script>
                    <script src="assets/js/bootstrap.min.js"></script>
                    <script src="assets/js/plugins.js"></script>
                    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
                    <script src="assets/js/init.js"></script>

                    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
                    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
                    <!--[if lt IE 9]>
                        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
                        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
                    <![endif]-->

                    <script type="text/javascript">
                                $(document).ready(function () {
                                    'use strict';
                                    jQuery('#headerwrap').backstretch([
                                        "assets/img/shop/hero1.jpeg",
                                        "assets/img/shop/hero2.jpg",
                                        "assets/img/shop/hero3.jpeg"
                                    ], {
                                        duration: 8000,
                                        fade: 500
                                    });
                                });
                    </script>
                    <script src="search.js"></script>
                    </body>

                    </html>
