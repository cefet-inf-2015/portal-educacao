<?php
session_start();
if(!isset($_SESSION['numeroCorretas'])){
	$_SESSION['numeroCorretas'] = array();
}
if(!isset($_SESSION['alunos'])){
	$_SESSION['alunos'] = array();
}
if(!isset($_SESSION['respostasAssociadas'])){
	$_SESSION['respostasAssociadas'] = array();
}


$caminhoProva = $_FILES['prova']['tmp_name'];
function lerProva($caminhoprova){
	if (file_exists($caminhoprova)) {
 	   $xml = simplexml_load_file($caminhoprova);
	} else {
	    exit('Falha ao abrir arquivo');
	}
	return $xml;
}
$xml = lerProva($caminhoProva);
$questao_length=count($xml->questao);
$respostas = [];
for ($i=0; $i<$questao_length; $i++){
	$nomePost = "q".strval($i);
	if (isset($_POST[$nomePost])){
		if (is_array($_POST[$nomePost])){
			$respostas[$i] = formatarArray($xml, $nomePost, $i);
		} else{
			$respostas[$i]= $_POST[$nomePost];
		}
	} else{
		$respostas[$i] = formatarArrayVazio($xml, $i);
	}
}

function formatarArray($xml, $nomePost, $iterador){
	$arrayNovo = [];
	for ($i=0; $i<count($xml->questao[$iterador]->alternativa); $i++){
		$arrayNovo[$i]=0;
	}
	for ($i=0; $i<count($_POST[$nomePost]); $i++){
		$arrayNovo[$_POST[$nomePost][$i]] = 1;
	}
	return $arrayNovo;
}

function formatarArrayVazio($xml, $iterador){
	$arrayNovo = [];
	for ($i=0; $i<count($xml->questao[$iterador]->alternativa); $i++){
		$arrayNovo[$i]=0;
	}
	return $arrayNovo;
}




function corrigir($xml, $respostas){
	$nota = 0;
	$totalPesos=0;
	$questao_length=count($xml->questao);
	for ($i=0; $i<$questao_length; $i++){
		$questaoAtual = $xml->questao[$i];
		$dificuldade = $questaoAtual->dificuldade;
		$totalPesos+=$dificuldade;
	}
	$notaBaseQuestao = $xml->valor/$totalPesos;
	for ($i=0; $i<$questao_length; $i++){
		$questaoAtual = $xml->questao[$i];
		$dificuldadeQuestao = $questaoAtual->dificuldade;
		$notaQuestao = $notaBaseQuestao*$dificuldadeQuestao;
		if ((string)$questaoAtual['tipo']=="ME"){
			$todasAlternativas = $questaoAtual->alternativa;
			foreach ($todasAlternativas as $alt){
				if ((string)$alt['correta']=="true"){
					if ($respostas[$i]==$alt){
						$nota+=$notaQuestao;
					}
				}
			}	
		} else if ((string)$questaoAtual['tipo']=="VF"){
			$arrayCorretas = [];
			$todasAlternativas = $questaoAtual->alternativa;
			$qtdAlt = count($todasAlternativas);
			$VFAcertadas = 0;
			for ($j=0; $j<$qtdAlt; $j++){
				if ((string)$todasAlternativas[$j]['correta']=="false"){
					$arrayCorretas[$j]=0;
				} else if ((string)$todasAlternativas[$j]['correta']=="true"){
					$arrayCorretas[$j]=1;
				}
			}
			for ($k=0; $k<$qtdAlt; $k++){
						if ($respostas[$i][$k]==$arrayCorretas[$k]){
							
							$VFAcertadas++;
						}
			}
			$vQuestao = $notaBaseQuestao*$dificuldadeQuestao;
			$aumento = $VFAcertadas*$vQuestao/$qtdAlt;
			$nota+=$aumento;
		}
	}
	array_push($_SESSION["numeroCorretas"], $nota); // keys
	$servidor = "localhost";
	$usuario = "root";
	$senha = "";
	$bd = "Usuarios";

	@$conecta =  new mysqli($servidor, $usuario, $senha, $bd) or print (mysqli_error()); 
	@$sql = "SELECT * FROM aluno WHERE matricula='".$_POST['matricula']."'";
	@$query = $conecta->query($sql);
	@$sql = mysqli_fetch_assoc($query);
	if (isset($sql["nome"])) {
		$nome = $sql["nome"];
	} else {
		$nome = $_POST['matricula'];
	}
	/* nome BD: Usuarios
	   nome TABELA: Alunos
	*/
	array_push($_SESSION["alunos"], $nome); // values
	$_SESSION["respostasAssociadas"] = array_map(function($key, $val) {return array($key=>$val);}, $_SESSION["alunos"], $_SESSION["numeroCorretas"]);
	return $nota;
}
$resultado = corrigir($xml, $respostas);
?>

<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>Portal Educação</title>


  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css" type="text/css" rel="stylesheet">
  
  <style type="text/css">
    body {
        display: flex;
        min-height: 100vh;
        flex-direction: column;
      }

      main {
        flex: 1 0 auto;
      }
  </style>
  <link rel="icon" href="imgs/logo.png" >
</head>
<body>
  <nav class="light-blue darken-4" role="navigation">
    <div class="nav-wrapper container">
        <!-- MENU SLIDE OUT STRUCTURE-->
    <ul id="slide-out" class="side-nav">
      <br>
      <li>
        <div class="logo">
          <img class="background center-block responsive" src="imgs/logo.png">
        </div>
      </li>
      <br>
      <li><a class="waves-effect" href="index.html">Página Inicial</a></li>
      <li><a class="waves-effect" href="#!">Modelo de Provas/Trabalhos</a></li>
      <li><a class="waves-effect" href="#!">Fórum</a></li>
      <li><a class="waves-effect" href="#!">Download/Upload Aplicativos</a></li>
      <li><a class="waves-effect" href="#!">Correção Provas e Trabalhos</a></li>
      <li><a class="waves-effect" href="Mural/projeto/index.html">Mural</a></li>
      <li><a class="waves-effect" href="#!">Chat</a></li>
      <li><a class="waves-effect" href="#!">Repositório de Fotos</a></li>
      <li><a class="waves-effect" href="#!">Banco de Questões</a></li>
      <li><a class="waves-effect" href="#!">Calendário</a></li>
      <!--<li><div class="divider"></div></li>-->
      <!--<li><a class="subheader">Subheader</a></li>-->
    </ul>
      <ul class="left ">
        <li>
          <button data-activates="slide-out" class="waves-effect waves-light btn-flat button-collapse white-text light-blue darken-4">Menu</button>
        </li>
      </ul>
      <ul class="right ">
        <!-- <li><button class="waves-effect waves-light btn-flat white-text light-blue darken-4">Entrar</button></li> -->
        <li><a class="waves-effect waves-light btn modal-trigger white-text light-blue darken-3" href="#modal1">Entrar</a></li>
      </ul>
    </div>
  </nav>
  
  <!-- Modal de login -->
  <div id="modal1" class="modal modal-fixed-footer">
    <div class="modal-content">
      <h4>Login</h4>
      <div class="row">
        <p>Insira dados</p>
        <form>
          <label for="username">Nome de usuario</label>
          <input type="text" name="username">
          <label for="senha">Senha</label>
          <input type="password" name="senha">
          <label for="tipoUsuario">Tipo de usuário</label>
          <select name="tipoUsuario">
            <option value="" disabled selected>Tipo de Usuario</option>
            <option value="1">Aluno</option>
            <option value="2">Professor</option>
            <option value="3">Coordenador</option>
            <option value="4">Diretor</option>
          </select>
          <button class="col s12 btn-flat waves-effect waves-light green white-text" type="submit" name="action">Entrar
              <i class="material-icons right">input</i>
            </button>
        </form>

      </div>
    </div>
    <div class="modal-footer">
      <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat red white-text">Sair</a>
    </div>
  </div>

  <!-- ESPAÇO PARA MARQUEE -->
  <div>
    
  </div>

  

  <main>
    <div class="container">
      <div class="section">
      <br>
      <h4 class="center blue-text text-darken-4">Prova corrigida com sucesso.</h4>
        <h4 class="center blue-text text-darken-4">Nota obtida: <?= $resultado ?></h4>
      </div>
    </div>

    <div class="container">
      <br><br>
      <div class="row">
        <div class="col s6 m6 l8">
          <a href="ProvaOffline.html" class="blue darken-4 hoverable btn"><i class="material-icons left">edit</i>Corrigir mais Provas</a>
        </div>
        <div class="col s6 m6 l4">
          <a href="mainpage.php" class="blue darken-4 hoverable btn"><i class="material-icons left">equalizer</i>Mostrar gráficos</a>
        </div>
      </div>
    </div>



  </main>
  <footer class="page-footer blue">
    <div class="container">
      <div class="row">
        <div class="col l6 s12">
          <h5 class="white-text">Desenvolvedores</h5>
          <p class="grey-text text-lighten-4">
            Somos a turma de Informática 2A do ano de 2016 do CEFET-MG (Centro Federal de Educação Tecnológica de Minas Gerais) desenvolvendo o trabalho final multidisciplinar de Linguagem de Programação 1 e Aplicações para WEB.
            <br><a class="white-text link" href="colaboradores.html">Clique aqui</a> para saber mais
          </p>
        </div>
        <div class="col l3 s12">
          <h5 class="white-text">Sobre a Instituição</h5>
          <p class="grey-text text-lighten-4">
            Centro Federal de Educação Tecnológica de Minas Gerais
            <br>Av. Amazonas 5253 - Nova Suiça - Belo Horizonte - MG - Brasil
            <br>Telefone: +55 (31) 3319-7000 - Fax: +55 (31) 3319-7001
          </p>
        </div>
        <div class="col l3 s12">
          <h5 class="white-text">Recursos</h5>
          <ul>
            <li><a class="white-text link" href="https://github.com/cefet-inf-2015/portal-educacao/" target="_blank">Github</a></li>
            <li><a class="white-text link" href="http://cefetmg.br/" target="_blank">CEFET-MG</a></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container">
      Made by <a class="blue-text text-lighten-3" href="http://materializecss.com">Materialize</a>
      </div>
    </div>
  </footer>


  <!--  Scripts-->
  <script src="template/js/init.js"></script>
  <script src="index.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>

  </body>
</html>
