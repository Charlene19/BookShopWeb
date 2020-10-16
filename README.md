# bookshop-front
## Projet Netbeans - Partie front-office de la librairie en ligne 

Requiert : 
- GlassFish 4.x
- JDBC DataSource faisant reference a la base de données ( "jdbc/bookshop", modifiable dans la classe "Database.java" ) 
- JRE/JDK 9 (?)

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
