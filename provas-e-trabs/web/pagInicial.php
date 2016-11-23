<?php
   session_start();  
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


   <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="../../template/js/materialize.js"></script>
  <script src="../../template/js/init.js"></script>
  <script src="script.js"></script>
  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="../../styles/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="../../styles/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="../../styles/css/layoutmural.css" type="text/css" rel="stylesheet" media="screen,projection">
  <link rel="icon" href="../../imgs/logo.png" >
  <link rel="stylesheet" type="text/css" href="estilo.css">
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
  <main>
    <div class="section no-pad-bot" id="index-banner">
      <div class="container">
        <br><br>
        <h1 class="header center blue-text text-darken-4">Modelos de Provas e Trabalhos</h1>
        <div class="row center">
          <h5 class="header col s12 light">Faça Seu Cabeçalho</h5>
          <br><br><br><br>
               <a href="formulario.php" class="waves-effect waves-light blue darken-4 btn"><i class="material-icons left">cloud</i>Novo Arquivo</a>&emsp; 
               <a href="formEdicao.php" class="waves-effect waves-light blue darken-4 btn"><i class="material-icons left">cloud</i>Editar</a>
        </div>
        <br><br><br><br>
      </div>
    </div>
  </main>


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

  </body>
</html>

