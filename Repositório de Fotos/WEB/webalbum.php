<?php
   include("../../Gerencia/LoginPHP/ClasseLogin.php");
   session_start();
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
	$res=mysqli_query($conn, "SELECT caminho FROM fotos WHERE usuario='".$_SESSION['usuario']->getNumeroMatricula()."'");
	$vetorRes = Array();
	while($row = mysqli_fetch_assoc($res)) {
        array_push($vetorRes, $row['caminho']);
    }
	echo json_encode($vetorRes);
?>