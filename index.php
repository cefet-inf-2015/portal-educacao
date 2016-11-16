<?php session_start() ?>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>Portal Educação</title>


  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="styles/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="styles/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
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
  <link rel="icon" href="imgs/logo.png" >
</head>
<body>
  <!-- AQUI FICA A NAVBAR -->
  <?php 
    include('navbar.php');
  ?>
  
  <?php 
    if(!isset($_SESSION['usuario'])) {
      include('modal.php');
    }
   ?>

  <!-- ESPAÇO PARA MARQUEE -->
  <div>
    
  </div>

          


  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br><br>
      <h1 class="header center blue-text text-darken-4">Portal Educação</h1>
      <div class="row center">
        <h5 class="header col s12 light">Um portal com soluções para sistemas educacionais</h5>
      </div>
      <br><br>

    </div>
  </div>

  <main>
    <div class="container">
      <div class="section">
        <!-- CONTEÚDO AQUI -->
        <h1>Inserir conteudo aquii</h1>
      </div>
    </div>
  </main>
  <!-- AQUI FICA O FOOTER -->
  <?php 
    include('footer.php');
  ?>

  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="template/js/materialize.js"></script>
  <script src="template/js/init.js"></script>
  <script src="index.js"></script>

  </body>
</html>
