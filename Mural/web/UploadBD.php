<?php
	$conexao = new mysqli('localhost', 'root', '', 'mural') or print("zona");
	$text = $_GET['texto'];
	$dataPostString = $_GET['dataPostString'];
	//$imagem = htmlentities($_FILES['arq']);

	$sql = "INSERT INTO mural (conteudo, data) VALUES ('$text', '$dataPostString')";

	if ($conexao->query($sql) === TRUE) {
	    echo "CRIOU";
	} else {
	    echo "Error: " . $sql . "<br>" . $conexao->error;
	}

	$conexao->close();	
?>