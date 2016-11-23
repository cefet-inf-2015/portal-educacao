<?php
ob_start();
session_start();
include 'ClasseLogin.php';
$nome = $_GET['nome'];
$senha = $_GET['senha'];
$tipo = $_GET['tipo'];
//MUDAR:
Login::conectarBanco('localhost', 'root', '', 'usuarios');
  if ( $usuario = Login::logarUsuario($nome, $senha, $tipo)) {
		$_SESSION['usuario'] = $usuario;
    echo 'passed';
	}
	else {
		echo "Dados de login inválidos.";
    session_destroy();
	}
?>