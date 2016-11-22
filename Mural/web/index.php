<?php
   session_start();  
   if (!isset($_SESSION['usuario'])) { 
     header('Location: ../../index.php'); 
   } 
   else {
    $GLOBALS['usuario'] = (array) $_SESSION['usuario'];
    /* pra acessar os dados do usuario, utilize o nome da coluna do BD.
    *  ex p acessar matricula:  $GLOBALS['usuario']['numeroMatricula'];
    *  colunas: numeroMatricula, primeiroNome, ultimoNome, turma, username, divisao, senha
    */
   }
?> 

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>Portal Educação</title>


    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="../../styles/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="../../styles/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="../../styles/css/layoutmural.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <style type="text/css">
    body {
        display: flex;
        min-height: 100vh;
        flex-direction: column;
      }

      main {
        flex: 1 0 auto;
      }
    </style>
    <link rel="icon" href="../../imgs/logo.png" >
  </head>
  <body>
    <!-- NAVBAR --> 
    <?php  
		include('../../navbar.php'); 
	?> 
     <!-- Modal de login --> 
	<?php  
    	include('../../modal.php'); 
	?>

	<!-- ESPAÇO PARA MARQUEE-->

	<div class="section no-pad-bot" id="index-banner">
	  <div class="container">
	    <br><br>
	    <h1 class="header center blue-text text-darken-4">Mural</h1>
	    <div class="row center">
	      <h5 class="header col s12 light">Mural de postagens</h5>
	    </div>
	    <br><br>
	  </div>
	</div>

	<main>
	  <div class="container">
	     <div class="section">
	 	 <!-- CONTEUDO AQUI --> 
	    	<div class="container">
	    	  <div class="section" id="posts">
	    	    <!-- Postar -->
	    	    <div class="col s1 m8 offset-m2 l6 offset-l3" >
	    	      <div class="card-panel grey lighten-5 z-depth-1">
	    	       <form>
	    	        <div class="row valign-wrapper">
	    	          <div class="col s6 m4 l2">
	    	            <img src="http://elaele.com.br/img/anonimo.png" alt="" class="square responsive-img" id="perfil">
	    	          </div>
	    	          <div class="col s10">
	    	            <textarea id="post" name="post" placeholder="Poste algo aqui!" class="materialize-textarea"></textarea>
	    	          </div>
	    	        </div>
	    	        <div class="row valign-wrapper">
	    	        
	    	          <div class="col s4 m3 l2">
	    	            <a class = "waves-effect waves-light btn light-blue darken-4 right" id="btnPost" name="pload">Publicar</a>
	    	          </div>
	    	        </div>
	    	       </form>
	    	      </div>
	    	    </div>
	    	  </div>  
	 	   </div>
	 	 </div>
	  </div>
	</main>

	<?php
		include('../../footer.php');
	?>

	<!--  Scripts-->
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="../../template/js/materialize.js"></script>
	<script src="../../template/js/init.js"></script>
	<script src="../../index.js"></script>
	<script src="../../scripts/mural.js"></script>

	</body>
	</html>
 
