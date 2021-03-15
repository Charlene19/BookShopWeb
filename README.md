# Bookshop-front
## Projet Netbeans - Partie front-office de la librairie en ligne 


<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Thanks again! Now go create something AMAZING! :D
***
***
***
*** To avoid retyping too much info. Do a search and replace for the following:
*** github_username, repo_name, twitter_handle, email, project_title, project_description
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]




<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/Charlene19/BookShopWeb">
    <img src="https://github.com/Charlene19/BookShopWeb/blob/master/static/img/sdbn.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">BookShop Web</h3>

  <p align="center">
    L'application web d'une librairie en ligne. En lien avec [BookShop](https://github.com/Charlene19/BookShop). Réalisée durant ma formation CDA.
    <br />
    <a href="https://github.com/Charlene19/BookShopWeb"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/Charlene19/BookShopWeb/edit/master/README.md">Projet en capacité d'être déployé</a>
    ·
    <a href="https://github.com/Charlene19/BookShopWeb/issues">Report Bug</a>
    ·
    <a href="href="https://github.com/Charlene19/BookShopWeb/issues">Request Feature</a>
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#about-the-project">À propos du projet</a>
      <ul>
        <li><a href="#built-with">Built avec</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Démarrer le projet</a>
      <ul>
        <li><a href="#prérequis">Prérequis</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contribuer</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgements">À savoir</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

![Product Name Screen Shot](https://github.com/Charlene19/Charlene19/blob/main/PortFolio/Animated%20GIF-downsized_large.gif)

BookShop Web est une application web qui offre une librairie. Projet construit avec Java/EE et des servlets. C'est un site web dynamique. Il est soutenu par une base de données SQL Server. 
Il est possible de nourir un panier avec un historique, faire des recherches adaptés par rapport au nom, à la catégorie ou au prix. 

L'interface graphique est réalisée avec Bootstrap et est responsive. 

Structure des packages/dossiers :
```
------------------------------------------------------------------
src/java       
  model/dao      : DAOs
  model/bean     : Beans
  model/entity   : Objets JAVA
  
  controller     : Servlet(s)
  
  db             : Gestion directe Base de données
 
  res            : Stockage de ressources diverses ( constantes )
------------------------------------------------------------------
web              : HTML
  WEB-INF        : JSP
  css            : CSS
  img            : Images
------------------------------------------------------------------
scripts          : SQL ( creation DB, jeu d'essai, etc... )
------------------------------------------------------------------
```

### Built With

* [GlassFish 4.x](https://gohugo.io/)
* [JDBC DataSource ](https://ox-hugo.scripter.co/)
* [JRE/JDK 9](https://themes.gohugo.io/hermit/)




<!-- GETTING STARTED -->
## Démarrer le projet

 
JavaEE, SQL Server.

### Prérequis

* GlassFish

* Le projet [BookShop](https://github.com/Charlene19/BookShop) afin de supporter les insertions dans la base de données.

* Une base de données avec un jeu de données et un schéma. 



### Installation

Mon template peut aussi servir de base :

1. Cloner le repo
   ```sh
   git clone https://github.com/Charlene19/BookShopWeb.git
   ```
2. Start Glassfish
  
3. Créer un pool de connexion : JDBC Database  





<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.



<!-- CONTACT -->
## Contact

Je suis joignable via mon [site](https://charlene19.github.io/)


Project Link:  Link: [https://github.com/Charlene19/secondBrain/](https://github.com/Charlene19/BookShopWeb/)


<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements

* [Template ReadMe](https://github.com/Charlene19/Best-README-Template/edit/master/README.md)





<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/Charlene19/BookShopWeb.svg?style=for-the-badge
[contributors-url]: https://github.com/Charlene19/BookShopWeb/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/Charlene19/BookShopWeb.svg?style=for-the-badge
[forks-url]: https://github.com/Charlene19/secondBrain/network/members
[stars-shield]: https://img.shields.io/github/stars/Charlene19/BookShopWeb.svg?style=for-the-badge
[stars-url]: https://github.com/Charlene19/BookShopWeb/stargazers
[issues-shield]: https://img.shields.io/github/issues/Charlene19/BookShopWeb.svg?style=for-the-badge
[issues-url]: https://github.com/Charlene19/BookShopWeb/issues
[license-shield]: https://img.shields.io/github/license/Charlene19/BookShopWeb.svg?style=for-the-badge
[license-url]: https://github.com/Charlene19/BookShopWeb/blob/master/LICENSE.txt

