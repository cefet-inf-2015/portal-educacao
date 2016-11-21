<?php
include '../../Gerencia/LoginPHP/ClasseLogin.php';
session_start();
// $mysqli = new mysqli("localhost", "root", "root", "chat");
$mysqli = new mysqli('localhost', 'root', '', 'chat');

$query = "INSERT INTO mensagens (mensagem, usuario, alvo, visualizado) VALUES ('".$_POST['mensagem']."', '".$_SESSION['usuario']->nickname."', '".$_POST['alvo']."', FALSE)";

$mysqli->query($query);

?>
