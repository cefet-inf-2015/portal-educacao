<?php
//Variáveis recebidas do lado do cliente
$mes = $_GET['mes'];
$ano = $_GET['ano'];
$linha = $_GET['linha'];

//Contêm os dados a serem retornados
$dados = array();

//Dados do servidor para conexão
$servidor = 'localhost';
$usuario = 'root';
$senha = '';
$banco = 'cadastro';

//Conecta-se ao banco de dados MySQL
$mysqli = new mysqli($servidor, $usuario, $senha, $banco);

//Caso algo tenha dado errado, exibe uma mensagem de erro
if (mysqli_connect_errno()) trigger_error(mysqli_connect_error());	

//Query para seleção de dados
$exec = $mysqli->query("SELECT `atividade`, `dia`, `mes`, `ano`, `hora`, `descricao`, `materia` FROM calendario WHERE mes = " . $mes . " AND ano = " . $ano);

//Pega os dados da linha da tabela
for($n = 0; $n < $linha; $n++) {
	$dados = $exec->fetch_assoc();
}

//Envia para o JavaScript os dados em JSON
echo json_encode($dados);
?>