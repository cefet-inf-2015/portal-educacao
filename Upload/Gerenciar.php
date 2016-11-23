<?php
	$nome = $_GET['nome'];
    date_default_timezone_set("America/Sao_Paulo");
    $conexao = mysqli_connect('localhost','root','123','bd_upload');
	$result = mysqli_query($conexao,"UPDATE arquivo SET arquivo_int_status='1' WHERE arquivo_char_nome='$nome'");
	header("Location:admin.php");
?>