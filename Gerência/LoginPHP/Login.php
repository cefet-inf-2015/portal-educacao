<?php
include 'ClasseLogin.php';
$nome = $_GET['nome'];
$senha = $_GET['senha'];
$tipo = $_GET['tipo'];
//MUDAR:
Login::conectarBanco('localhost', 'root', 'apenasinf-2015', 'Usuarios');
	if ( $usuario = Login::logarUsuario($nome, $senha, $tipo)) {
		session_start();
		$_SESSION['usuario'] = $usuario;
    echo "Validado!";
	}
	else {
		echo "Dados de login inválidos.";
	}
?>