

<?php
session_start();
if ( isset($_SESSION["usuario"]) ) {
                
                var_dump($_SESSION['usuario']);
                $userData = (array) $_SESSION["usuario"];
                $nome = $userData['primeiroNome']; //." ".$userData['ultimoNome'];
                $matricula = $userData['numeroMatricula'];
                $foto = $userData['foto'];
                switch ($userData['permissao']) {
                                                case '0':$tipo= "Aluno"; break;
                                                case '1':$tipo= "Professor"; break;                                                
                                                case '2':$tipo= "Coordenador";break;
                                                case '3':$tipo= "Diretor";break;
                                            } // pegar tipo de usuario
              }
              else {
               
                $nome = "Rafael";
                $tipo = "Aluno";
                $foto = "/carometro/RAFAEL_NEVES 201511130237.jpg";
                $matricula = '201511130237';
}

/*
$dbhost = 'cefet-inf-2015.ddns.net:43306'; // endereco do servidor de banco de dados
$dbuser = 'root'; // login do banco de dados
$dbpass = 'apenasinf-2015'; // senha
*/

$dbhost = 'localhost'; // endereco do servidor de banco de dados
$dbuser = 'root'; // login do banco de dados

$dbname = 'bdforum'; // nome do banco de dados a ser usado
$titulo = $_POST["titulo"];
$data= date('d/m/Y');
$conteudo = $_POST["pergunta"];
$comentario = $_POST["comentario"]; //0-novo topico 1-nova resposta
$categoria = $_POST["categoria"];


              
//$conecta = @mysql_connect($dbhost, $dbuser, $dbpass);
$conecta = @mysql_connect($dbhost, $dbuser);
$seleciona = @mysql_select_db($dbname);
$sqlinseretopico= "INSERT INTO $categoria ( Titulo,Autor,Conteudo,Data,Comentario) VALUES ('$titulo','$nome','$conteudo','$data','$comentario')";
$inseretabela = mysql_query( $sqlinseretopico, $conecta );

$sqlinsereusuario= "INSERT INTO usuarios ( nome,tipo,foto,matricula) VALUES ('$nome','$tipo','$foto','$matricula')";
$insererusuario = @mysql_query($sqlinsereusuario, $conecta);



$sqlsomatopico = "UPDATE usuarios SET criados = criados + 1 WHERE nome = '$nome'";

$sqlsomacomentario= "UPDATE usuarios SET comentarios = comentarios + 1 WHERE nome = '$nome'";


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




if ($comentario==0) {
	$somatopico= mysql_query($sqlsomatopico , $conecta);
	$somatopico;
   echo "topico".$comentario;
} else {
	$somacomentario = mysql_query($sqlsomacomentario , $conecta);
	$somacomentario;
	echo "comentario".$comentario;
}





 
mysql_close($conecta);



echo "<script>location.href='Categorias/".$categoria.".php';</script>";
?>
