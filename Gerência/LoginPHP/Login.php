<?php
	include 'ClasseLogin.php';
	$nome = $_GET['nome'];
	$senha = $GET['senha'];
	$tipo = $GET['tipo'];

 	if ( $usuario = Login::logarUsuario($nome, $senha, $tabela, $tipo)) {
 		session_register();
 		session_start();
 		$_SESSION['usuario'] = $usuario;	
 		
 	}


?>