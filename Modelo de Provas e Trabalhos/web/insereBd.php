<?php

	$banco = 'Cabecalho';

	$link = mysqli_connect("localhost", "root", "", "dados");
	   
	   if(!$link) {
	     die('Not connected : ' . mysql_error()); 
	    }
	 
	   $db = mysqli_select_db($link, $banco); 

		$valor = $_POST['valor'];
		$titulo = $_POST['Titulo'];
		$turno = $_POST['turno'];
		$nQuest = $_POST['nquestao'];
		$elab = $_POST['prof'];
		$turma = $_POST['turmas'];
		$escola = $_POST['instituicao'];
		$duracao = $_POST['duracao'];
		
		$dataEntrega = $_POST['dataEntrega'];
		$dataRecebimento = $_POST['dataRecebimento'];
		$matricula = $_POST['matricula'];
	
		/*$dataP = explode('/', $data);
		
		$dataformatada = $dataP[2].'-'.$dataP[1].'-'.$dataP[0];*/

	    $query = "INSERT INTO teste (titulo, elaborador, matricula, valor, nQuestoes, turmas, escola, duracao)
	    	 VALUES ('$titulo', '$elab', '$matricula', '$valor', '$nQuest', '$turma', '$escola', '$duracao')";

 		//$query = "INSERT INTO Cabecalho (titulo) VALUES ('$titulo')";
	    
	    mysqli_query($link, $query) or die("Erro ao guardar Informaçoes");
	    mysqli_close($link);
	    echo "informacoes guardadas";


?>
