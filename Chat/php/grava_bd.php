<?php
$mysqli = new mysqli("localhost", "root", "root", "chat");
$query = "INSERT INTO mensagens (mensagem, usuario) VALUES ('".$_POST['mensagem']."', '')";

$mysqli->query($query);

?>