<?php
include '../../Gerencia/LoginPHP/ClasseLogin.php';
session_start();
// Login::conectarBanco('localhost', 'root', 'apenasinf-2015', 'chat');
// $mysqli = new mysqli("localhost", "root", "root", "chat");
$mysqli = new mysqli('localhost', 'root', '', 'Usuarios');

$resultado = false;

$query = "SELECT primeiroNome, ultimoNome, username, matricula, turma, divisao FROM ".$_GET['tipo']." WHERE username = '".$_GET['usuario']."'";
if ($stmt = $mysqli->prepare($query)) {

    /* execute statement */
    $stmt->execute();

    /* bind result variables */
    $stmt->bind_result($primeiroNome, $ultimoNome, $username, $matricula, $turma, $divisao);

    /* fetch values */
    while ($stmt->fetch()) {
       $resultado = array(
			"primeiroNome" => $primeiroNome,
			"ultimoNome" => $ultimoNome,
			"username" => $username,
			"matricula" => $matricula,
			"turma" => $turma,
			"divisao" => $divisao
	   );
    }

    /* close statement */
    $stmt->close();
}

echo json_encode($resultado);
?>
