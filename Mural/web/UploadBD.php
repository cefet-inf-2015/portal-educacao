<?php
	$conexao = new mysqli('localhost', 'root', '', 'Mural') or die("Erro na conexão");
	$textoPostagem = htmlentities($_GET['post']);
	$imagem = htmlentities($_FILES['arq']);
	$dataPostagem = date("d-m-Y H:i:s");
	
	$query = "INSERT INTO Mural (data, conteudo, arquivo) VALUES ($dataPostagem, $textoPostagem, $arquivo)";
	$conexao ->query($query);
	
?>