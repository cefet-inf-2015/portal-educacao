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
	
</body>
</html>
<html>
  <head>
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
		<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script src=criarGrafico.js></script>
		<script type=text/javascript>
			var nomes = Array();
			var notas = Array();
			$(document).ready(function(){
				var obj = <?php session_start(); echo json_encode($_SESSION['respostasAssociadas']); ?>;
				for (i=0; i<obj.length; i++){
					nomes.push(Object.keys(obj[i]));
					notas.push(obj[i][nomes[i]]);
				}	
			})
		</script>
		<script src=media.js></script>
  </head>
  <body>
		<br>
		<div class="container">
			<div class="center" id="barchart_material" style="width: 700px; height: 800px; display: table;
    	margin: 0 auto; "></div>
		</div>
		<div class="container">
			<h5 id="media" class="center blue-text text-darken-4"></h5>
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
    
    <div class="section">

    </div>
  

  <?php 
    include('../../footer.php');
  ?>


  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="C:\Users\Aluno\Desktop\portal-educacao\portal-educacao-master\template/js/materialize.js"></script>
  <script src="C:\Users\Aluno\Desktop\portal-educacao\portal-educacao-master\template/js/init.js"></script>
  <script src="C:\Users\Aluno\Desktop\portal-educacao\portal-educacao-master\index.js"></script>

</body>

</html>

  </body>
</html>
<?php
unset($_SESSION['alunos']);
unset($_SESSION['numeroCorretas']);
unset($_SESSION['respostasAssociadas']);
?>