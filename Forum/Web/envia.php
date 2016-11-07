

<?php
$dbhost = 'localhost'; // endereco do servidor de banco de dados
$dbuser = 'root'; // login do banco de dados
$dbpass = ''; // senha
$dbname = 'forum'; // nome do banco de dados a ser usado
$nome = $_POST["titulo"];
$today = date("Y-m-d H:i:s");
$categoria = $_POST["categoria"];
$conteudo = $_POST["pergunta"];
//$aux = array("?",".",",","!"," ");
//$nomebd = str_replace($aux,"",$nome);
$conecta = @mysql_connect($dbhost, $dbuser, $dbpass);
$seleciona = mysql_select_db($dbname);

$sqlcriatabela = "CREATE TABLE IF NOT EXISTS topico (ID int AUTO_INCREMENT,idtopico int,idresposta int, titulo text, categoria VARCHAR(50), conteudo Text,dia timestamp, autor VARCHAR(50),primary key (ID))DEFAULT CHARSET = utf8;";
$sqlinsere= "INSERT INTO topico (ID, titulo, categoria,conteudo,dia) VALUES (DEFAULT,'$nome','$categoria','$conteudo','$today')";
$criatabela = mysql_query( $sqlcriatabela, $conecta );
$inseretabela = mysql_query( $sqlinsere, $conecta );

// inicia a conexao ao servidor de banco de dados

if(! $conecta )
{

  die("<br />Nao foi possivel conectar: " . mysql_error());

}

echo "<br />Conexao realizada!";

 


if (! $seleciona)
{
  die("<br />Nao foi possivel selecionar o banco de dados $dbname");
}

echo "<br />selecionado o banco de dados $dbname";

if(! $criatabela )
{
  die("<br />Nao foi possivel criar a tabela: " . mysql_error());
}
echo "<br />A tabela foi criada!";

if(! $inseretabela )
{
  die("<br />Nao foi possivel inserir na tabela: " . mysql_error());
}
echo "<br />os dados foram inseridos!";
 
mysql_close($conecta);

?>
