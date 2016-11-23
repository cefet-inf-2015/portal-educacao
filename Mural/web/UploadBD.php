<?php
	session_start();  
	$conexao = new mysqli('localhost', 'root', '', 'mural');
	$text = $_GET['texto'];
	$dataPostString = $_GET['dataPostString'];
	$GLOBALS['usuario'] = (array) $_SESSION['usuario'];
	$usuario = $GLOBALS['usuario']['primeiroNome'].' '.$GLOBALS['usuario']['ultimoNome'];

	$sql = "INSERT INTO mural (conteudo, data, usuario) VALUES ('$text', '$dataPostString', '$usuario')";

	if ($conexao->query($sql) === TRUE) {
	    header("Location:index.php");
	} else {
	    echo "Error: " . $sql . "<br>" . $conexao->error;
	}

	$conexao->close();	
?>