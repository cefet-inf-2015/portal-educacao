<html>
<head>
	
</head>
<body>
	
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
    <div id="barchart_material" style="width: 600px; height: 400px;"></div>
		<div class="container">
			<h5 id="media" class="center blue-text text-darken-4"></h5>
		</div>

  </body>
</html>
<?php
session_destroy();
?>