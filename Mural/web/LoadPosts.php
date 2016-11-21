<?php

$linha = $_GET['linha'];

$dados = array();

$servidor = 'localhost';
$usuario = 'root';
$senha = '';
$bd = 'mural';

$mysqli = new mysqli($servidor, $usuario, $senha, $bd);


$load= $mysqli->query("SELECT conteudo, data, usuario FROM mural ORDER BY ID DESC");

for($i = 0; $i< $linha; $i++){
	$dados = $load->fetch_assoc();
}

echo json_encode($dados);

?>