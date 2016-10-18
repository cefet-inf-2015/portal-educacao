<?php
$mysqli = new mysqli("localhost", "root", "root", "chat");

$query = "SELECT mensagem,usuario FROM mensagens ORDER BY id LIMIT 50";
$resultado = array();
if ($stmt = $mysqli->prepare($query)) {

    /* execute statement */
    $stmt->execute();

    /* bind result variables */
    $stmt->bind_result($mensagem, $usuario);

    /* fetch values */
    while ($stmt->fetch()) {
       array_push($resultado, $mensagem);
    }

    /* close statement */
    $stmt->close();
}

echo json_encode($resultado);
?>