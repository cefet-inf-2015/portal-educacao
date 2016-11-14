

<?php
$dbhost = 'cefet-inf-2015.ddns.net:43306'; // endereco do servidor de banco de dados
$dbuser = 'root'; // login do banco de dados
$dbpass = 'apenasinf-2015'; // senha
$dbname = 'bdforum'; // nome do banco de dados a ser usado
$nome = $_POST["titulo"];
$data= date('d/m/Y');
$conteudo = $_POST["pergunta"];


$conecta = @mysql_connect($dbhost, $dbuser, $dbpass);
$seleciona = @mysql_select_db($dbname);
echo $nome;
$sqlinsere= "INSERT INTO Matematica ( Titulo,Conteudo,Data,Comentario) VALUES ('$nome','$conteudo','$data','0')";


$inseretabela = @mysql_query( $sqlinsere, $conecta );

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



if(! $inseretabela )
{
  die("<br />Nao foi possivel inserir na tabela: " . mysql_error());
}
echo "<br />os dados foram inseridos!";

 
mysql_close($conecta);

?>
