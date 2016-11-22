<?php
	// requires php5
	
	date_default_timezone_set("America/Sao_Paulo");
	include_once("../../Gerencia/LoginPHP/ClasseLogin.php");
	include_once("conexao.php");
	session_start();
	$idFoto=uniqid();
	$query = "INSERT INTO fotos VALUES ('".$_SESSION['usuario']->getNumeroMatricula()."','imagens/".$_SESSION['usuario']->getNumeroMatricula().$idFoto.".png','".$_SESSION['usuario']->getNumeroMatricula().$idFoto.".png')";
	$conn->query($query);
	
	define('UPLOAD_DIR', 'imagens/');
	$img = $_POST['img'];
	$img = str_replace('data:image/png;base64,', '', $img);
	$img = str_replace(' ', '+', $img);
	$data = base64_decode($img);
	$file = UPLOAD_DIR .$_SESSION['usuario']->getNumeroMatricula(). $idFoto . '.png';
	$success = file_put_contents($file, $data);
	print $success ? $file : 'Unable to save the file.';
	echo "Success"
?>