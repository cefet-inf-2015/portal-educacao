<?php
include '../../Gerencia/LoginPHP/ClasseLogin.php';
session_start();
// Login::conectarBanco('localhost', 'root', 'apenasinf-2015', 'chat');
// $mysqli = new mysqli("localhost", "root", "root", "chat");
$mysqli = new mysqli('localhost', 'root', '', 'usuarios');

$resultado = array();
$tabelas = array('alunos','professores','coordenadores','diretores');
$mysqli->query('SET CHARACTER SET utf8');
foreach($tabelas as $tabela) {
	$query = "SELECT primeiroNome, username FROM ".$tabela." WHERE username <> '".$_SESSION['usuario']->nickname."'";
	if ($stmt = $mysqli->prepare($query)) {

	    /* execute statement */
	    $stmt->execute();

	    /* bind result variables */
	    $stmt->bind_result($primeiroNome, $username);
		
	   /* fetch values */
	    while ($stmt->fetch()) {
	       array_push($resultado,
		   		array(
					"nome" => $primeiroNome,
					"username" => $username,
					"tabela" => $tabela
			   )
		   );
	    }


	    /* close statement */
	    $stmt->close();
	}
}
echo json_encode($resultado);
?>
