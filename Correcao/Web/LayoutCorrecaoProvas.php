<?php 
  if (!isset($_SESSION['usuario'])) {
    header('Location: ../../index.php');
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
    if(!isset($_SESSION['usuario'])) {
      include('../../modal.php');
    }
  ?>

  <!-- ESPAÇO PARA MARQUEE -->
  <div>
    
  </div>

  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br><br>
      <h1 class="header center blue-text text-darken-4"> Correção de provas </h1>
      <div class="row center">
        <h5 class="header col s12 light"><p>As provas aplicadas por veículos eletrônicos são corrigidas no botão "Corrigir prova online"</p><p>As provas impressas são corrigidas no botão: "Corrigir prova offline"</p></h5>
      </div>
      <br><br>

    </div>
  </div>

  	<div class="container">
  		<br><br>
  		<div class="row">
  			<div class="col s6 m6 l8">
  				<a href="ProvaOffline.html" class="blue darken-4 hoverable btn" ><i class="material-icons left">edit</i>Corrigir prova offline</a>
 			</div>
  			<div class="col s6 m6 l4">
  				<a href="ProvaOnline.html" class="blue darken-4 hoverable btn"><i class="material-icons left">edit</i>Corrigir prova online</a>
  			</div>
  		</div>
  	</div>

  	<div class="container">
    <div class="section">

      <!--   Icon Section   -->
      <div class="row">
        <div class="col s12 m4">
          </div>
        </div>
      </div>

    </div>
    <br><br>

    <div class="section">

    </div>
  </div>


  <?php 
      include('../../footer.php');
  ?>

  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="../../template/js/materialize.js"></script>
  <script src="../../template/js/init.js"></script>
  <script src="../../index.js"></script>

</body>

</html>