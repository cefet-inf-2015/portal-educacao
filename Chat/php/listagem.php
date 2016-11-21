<?php
include '../../Gerencia/LoginPHP/ClasseLogin.php';
session_start();
// Login::conectarBanco('localhost', 'root', 'apenasinf-2015', 'chat');
// $mysqli = new mysqli("localhost", "root", "root", "chat");
$mysqli = new mysqli('localhost', 'root', '', 'chat');

//inicio do retorno
$inicio = ($_GET['id']) ? $_GET['id'] : 0;

//verificando se ha um filtro a ser aplicado
if(!isset($_GET['pesquisa']))
	$query = "SELECT id, mensagem, usuario, DATE_FORMAT(horario,'%d/%c/%y às %H:%i') AS horas FROM mensagens WHERE ((alvo = '".$_GET['alvo']."' AND usuario = '".$_SESSION['usuario']->nickname."') OR (usuario = '".$_GET['alvo']."' AND alvo = '".$_SESSION['usuario']->nickname."')) AND id > ".$inicio." ORDER BY id LIMIT 50";
else
	$query = "SELECT id, mensagem, usuario, DATE_FORMAT(horario,'%d/%c/%y às %H:%i') AS horas FROM mensagens WHERE ((alvo = '".$_GET['alvo']."' AND usuario = '".$_SESSION['usuario']->nickname."') OR (usuario = '".$_GET['alvo']."' AND alvo = '".$_SESSION['usuario']->nickname."')) AND mensagem LIKE '%".$_GET['pesquisa']."%' AND id > ".$inicio." ORDER BY id LIMIT 50";

$resultado = array();
$ids = array();
$mysqli->query('SET CHARACTER SET utf8');
if ($stmt = $mysqli->prepare($query)) {

    /* execute statement */
    $stmt->execute();
    /* bind result variables */
    $stmt->bind_result($id, $mensagem, $usuario, $horas);
    /* fetch values */
    while ($stmt->fetch()) {
	   array_push($ids, $id);
	   array_push($resultado,
	   		array(
				"id" => $id,
				"horas" => $horas,
				"mensagem" => $mensagem,
				"usuario" => $usuario,
				"proprio" => ($usuario == $_SESSION['usuario']->nickname)
		   )
	   );
    }

    /* close statement */
    $stmt->close();
	foreach($ids as $i){
		$mysqli->query("UPDATE `mensagens` SET `visualizado` = 1 WHERE `id` = ".$i." AND `alvo` ='".$_SESSION['usuario']->nickname."'");
	}
}

echo json_encode($resultado);
?>
