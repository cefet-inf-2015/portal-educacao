<?php
	$conexao = new mysqli('localhost', 'root', '', 'mural');
	$text = $_GET['texto'];
	$dataPostString = $_GET['dataPostString'];
	//$imagem = htmlentities($_FILES['arq']);
	if ( isset($_SESSION["usuario"]) ) { 
	  $userData = (array) $_SESSION["usuario"];
	  $usuario = $userData['primeiroNome']+ " " +$userData['ultimoNome'];
	} 


	$sql = "INSERT INTO mural (conteudo, data, usuario) VALUES ('$text', '$dataPostString', '$usuario')";

	if ($conexao->query($sql) === TRUE) {
	    header("Location:index.html");
	} else {
	    echo "Error: " . $sql . "<br>" . $conexao->error;
	}

	$conexao->close();	
?>