<?php
	$servidor = "cefet-inf-2015.ddns.net:43306";
	$usuario = "root";
	$senha = "";
	$dbname = "carometro";
	
	//Criar a conexão
	$conn = mysqli_connect($servidor, $usuario, $senha, $dbname);
	if(!$conn){
		die("Falha na conexao: " . mysqli_connect_error());
	}else{
		//echo "Conexao realizada com sucesso";
	}
?>