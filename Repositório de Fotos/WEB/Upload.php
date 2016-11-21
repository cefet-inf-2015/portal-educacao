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
  <link rel="icon" href="../imgs/logo.png" >
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
      <h1 class="header center blue-text text-darken-4">Upload de Imagens</h1>
      <div class="row center">
        <h5 class="header col s12 light"></h5>
      </div>
      <br><br>

    </div>
  </div>

  <main>
    <div class="container">
      <div class="section">
        <!-- CONTEÚDO AQUI -->
		
        
		<form method="POST" action="proc_upload.php" enctype="multipart/form-data">
			<div class="row" align="center">
				<input class="btn-large waves-effect waves-light light-blue darken-4" name="arquivo" type="file"><br><br>
			</div>
			<div class="row" align="center">
				<input class="btn-large waves-effect waves-light light-blue darken-4" type="submit" value="Enviar">
			</div>
		</form>
		
		
		
		
		
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
