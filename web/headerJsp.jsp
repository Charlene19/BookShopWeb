

<%@page contentType="text/html" pageEncoding="UTF-8"%>

         <style>
body {font-family: Arial, Helvetica, sans-serif;}

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
  position: relative;
  background-color: #fefefe;
  margin: auto;
  padding: 0;
  border: 1px solid #888;
  width: 80%;
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
  -webkit-animation-name: animatetop;
  -webkit-animation-duration: 0.4s;
  animation-name: animatetop;
  animation-duration: 0.4s
}

/* Add Animation */
@-webkit-keyframes animatetop {
  from {top:-300px; opacity:0} 
  to {top:0; opacity:1}
}

@keyframes animatetop {
  from {top:-300px; opacity:0}
  to {top:0; opacity:1}
}

/* The Close Button */
.close {
  color: white;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}

.modal-header {
  padding: 2px 16px;
  background-color: #5cb85c;
  color: white;
}

.modal-body {padding: 2px 16px;}

.modal-footer {
  padding: 2px 16px;
  background-color: #5cb85c;
  color: white;
}
.banniere {
    display : inline-block;
}

#logoBookshop {
	width: 30vmin;
	width: 20vmax;
    margin-left: 0; 
}
</style>



<!-- Trigger/Open The Modal -->

<ul> <form method="POST" action="book">
        <li class="banniere"><a href="homePageJsp.jsp"><figure><img src="img/0.png" alt="Logo Bookshop" id="logoBookshop"></figure></a></li>
            <!-- recherche rapide -->
            <li class="banniere"><label for="recherche">Recherche</label>
                <input type="text" id="recherche" name="isbn">
                <button type="submit">OK</button></li>
            <li class="banniere"><a href="shoppingcart"><span id="barreMenuD">Panier</span></a></li>
                    <li class="banniere"><button id="myBtn" type="button">Se connecter</button></li>
                    <li class="banniere">
                         <form action="/allOrder">   
          <button> <a href="myAccount.jsp">Mon compte</a> </button> </li>
    </form>
    </form>
            </ul>
            
            




<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header">
      <span class="close">&times;</span>
      <br></br>
    </div>
    <div class="modal-body">
      
        <jsp:include page="WEB-INF/login.jsp" />
        
        
    </div>
    <div class="modal-footer">
        <br></br>
    </div>
  </div>

</div>

<script>
// Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
  modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
</script>

            
            
            
      
        
       
         <div id="font">   
            <nav> <!-- Menu de sélection thématique-->
                
                <ul id="menuNav">
                    <!-- <div id="gauche"> -->
                    <li class="barreMenuG"><a href="">Littérature</a></li>
                    <li class="barreMenuG"><a href="">Sciences Humaines</a></li>
                    <li class="barreMenuG"><a href="">Arts</a></li>
                    <li class="barreMenuG"><a href="">Jeunesse</a></li>
                    <li class="barreMenuG"><a href="">BD / Manga</a></li>
                    <!-- </div> -->
                </ul>
                
            </nav>
