<?php
//Capta o usuário logado no momento
session_start();
$usuario = $_SESSION['usuario']->getPrimeiroNome() . " " . 
$_SESSION['usuario']->getUltimoNome();

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
$sql = "INSERT INTO `calendario` (`atividade`, `dia`, `mes`, `ano`, `hora`, `descricao`, `materia`) VALUES ('$atividade', '$dataForm[0]', '$dataForm[1]', '$dataForm[2]', '$hora', '$descricao', '$materia')";
$query = $mysqli->query($sql);

//Envia a atividade para o mural caso esteja marcado o checkbox
if(isset($_POST["enviarMural"])) {
	//Define o counteúdo da mensagem
	$conteudo = "Atividade: " . $atividade . "\n" . "Descrição: " . $descricao
	. "\n" . "Data: " . $data . "   Hora: " . $hora . "\n" . "Matéria: " . $materia;

	//Define o id da mensagem
	$sql = "SELECT MAX(id) FROM Mural";
	$id = $mysqli->query($sql);
	$id++;

	//Capta a data atual
	date_default_timezone_set('America/Sao_Paulo');
	$data = date('d-m-Y');

	$sql = "INSERT INTO `Mural` (`id`, `usuario`, `data`, `conteudo`) VALUES ('$id', '$usuario', '$data', '$conteudo')";
	$query = $mysqli->query($sql);
}

//Chama a página de volta
header('Location: ../index.html');
?>