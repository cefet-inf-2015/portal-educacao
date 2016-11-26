<?php 
	require_once 'partPHP.php';
	
	$tipoGeral = $_SESSION['tipoGeral'];

	if($tipoGeral == 'individual'){
		$nome = $_SESSION['nome'];
		$matricula = $_SESSION['matricula'];
		$filename = "$nome $matricula.docx"; 	
		echo "<br>$filename";
		echo "<a href='$filename' download/>Documento</a>";
	} else if ($tipoGeral == 'turma') {
		$nomeTurma = $_SESSION['nomeTurma'];
		$matTurma  = $_SESSION['matTurma'];
		$filename2 = "$nomeTurma $matTurma.docx";
		$caminho   = 'C:\xampp\htdocs\portal-educacao-master\Modelo-de-Provas-e-Trabalhos\web';
		$files = glob('*.docx');
		$filecount = count( $files );
		//echo $filecount;
		for ($i=0; $i < count($files) ; $i++) { 
			echo "
			<<!DOCTYPE html>
			<html>
			<head>
				<head>
  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
  <meta name='viewport' content='width=device-width, initial-scale=1, maximum-scale=1.0'/>
  <title>Portal Educação</title>


  <!-- CSS  -->
  <link href='https://fonts.googleapis.com/icon?family=Material+Icons' rel='stylesheet'>
  <link href='styles/css/materialize.css' type='text/css' rel='stylesheet' media='screen,projection'/>
  <link href='styles/css/style.css' type='text/css' rel='stylesheet' media='screen,projection'/>
  <style type='text/css'>
    body {
        display: flex;
        min-height: 100vh;
        flex-direction: column;
      }

      main {
        flex: 1 0 auto;
      }
  </style>
  <link rel='icon' href='imgs/logo.png' >
</head>
			</head>
			<body>
			<div class='container'>
				<a name='documento' href='$files[$i]' download/>Documento[$i]</a>
			</div>
			</body>
			</html>";
		}	
	}

 ?>