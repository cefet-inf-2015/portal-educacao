<?php
ob_start();
session_start();
include 'ClasseLogin.php';
$nome = $_GET['nome'];
$senha = $_GET['senha'];
$tipo = $_GET['tipo'];
//MUDAR:
Login::conectarBanco('localhost', 'root', 'apenasinf-2015', 'Usuarios');
  if ( $usuario = Login::logarUsuario($nome, $senha, $tipo)) {
		$_SESSION['usuario'] = $usuario;
    echo "Seja bem vindo, " . $_SESSION['usuario']->primeiroNome;
	}
	else {
		echo "Dados de login inválidos.";
    session_destroy();
	}
?>