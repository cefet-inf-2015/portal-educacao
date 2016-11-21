<?php
//Capta dados do formulário
$atividade = $_POST["atividade"];
$dataForm = $_POST["dataForm"];
$hora = $_POST["hora"];
$descricao = $_POST["descricao"];
$materia = $_POST["materia"];

$dataForm = explode("/", (string)$dataForm);

//Dados do servidor para conexão
$servidor = 'localhost';
$usuario = 'root';
$senha = '';
$banco = 'cadastro';

//Conecta-se ao banco de dados MySQL
$mysqli = new mysqli($servidor, $usuario, $senha, $banco);

//Caso algo tenha dado errado, exibe uma mensagem de erro
if (mysqli_connect_errno()) trigger_error(mysqli_connect_error());

//Insere os dados no servidor
$sql = "INSERT INTO `calendario` (`atividade`, `dia`, `mes`, `ano`, `hora`, `descricao`, `materia`) VALUES ('$atividade', '$dataForm[2]', '$dataForm[1]', '$dataForm[0]', '$hora', '$descricao', '$materia')";
$query = $mysqli->query($sql);

//Chama a página de volta
header('Location: ../index.html');
?>