<?php 
  session_start();
  if (!isset($_SESSION['usuario'])) {
    header('Location: ../../index.php');
  }
 ?>
<!DOCTYPE html>
<html lang="en">
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		
	
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>Correção Provas</title>

  <!-- CSS  -->
	
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css" type="text/css" rel="stylesheet">
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>
	<script src="criaInputs.js"></script>
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
  <?php 
    include('../../navbar.php');
  ?>
  
   <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br><br>
      <h4 class="header center blue-text text-darken-4"> Correção de provas </h4>
      <div class="row center">
        <h6 class="header col s12 center blue-text text-darken-4 "><p> Ferramenta para correção de provas feitas no papel.<br>Insira a prova para poder inserir o gabarito.</p></h6>
      </div>
      <br><br>

    </div>
  </div>

  <form action="corretor.php" method="post" enctype="multipart/form-data">
    <div class="container">
      <br><br>
      <div class="file-field input-field">
          <div class="blue darken-4 hoverable btn"><i class="material-icons right">send</i>
            <span>Insira a Prova</span>
            <input type="file" id="inputProva" name="prova" accept=".xml" onchange='openFile(event)'>
          </div>
          <div class="file-path-wrapper">
            <input class="file-path validate" type="text">
          </div>
      </div>
    </div>

    <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br>
      <h6 class="header center blue-text text-darken-4"> Questões fechadas deverão ser escolhidas nos botões radio. Nas questões de verdadeiro ou falso, quando a resposta for verdadeira, marque a caixa de seleção. </h6>
       <h6 class="header center blue-text text-darken-4"> Para corrigir a prova, em questões fechadas, alguma alternativa deve ser escolhida. </h6> 
      </div>
  </div>


    <div id="containerInput" class="container" >
			
      <br><br>
    </div>
    <div class="container">
      <br><br>
      <div class="input-field col s12">
          <input name="matricula" type="text" class="validate">
          <label for="matricula">Matrícula do aluno</label>
        </div>
    </div>
    <div class="container">
      <br><br>
      <div class="row">
        <div class="col s6">
          <button href="provaCorrigida.php" class="hoverable blue darken-4 btn-large" type="submit"><i class="material-icons right">edit</i>Corrigir</button>
        </div>
      </div>
    </div>
  </form>
  
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
  

  <?php 
    include('../../footer.php');
  ?>


  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="../../template/js/materialize.js"></script>
  <script src="../../template/js/init.js"></script>
  <script src="../../index.js"></script>

</body>

</html>
