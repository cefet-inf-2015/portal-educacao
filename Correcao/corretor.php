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
$respostas = $_POST['resposta'];
$caminhoProva = $_FILES['prova']['tmp_name'];
function lerProva($caminhoprova){
	if (file_exists($caminhoprova)) {
 	   $xml = simplexml_load_file($caminhoprova);
	} else {
	    exit('Falha ao abrir arquivo');
	}
	return $xml;
}


function corrigir($xml, $respostas){
	$numeroCorretas = 0;
	$questao_length=count($xml->questao);
	for ($i=0; $i<$questao_length; $i++){
		$questaoAtual = $xml->questao[$i];
		$todasAlternativas = $questaoAtual->alternativa;
		foreach ($todasAlternativas as $alt){
			if ((string)$alt['correta']=="true"){
				if ($respostas[$i]==$alt){
					$numeroCorretas++;
				}
			}
		}
	}
	array_push($_SESSION["numeroCorretas"], $numeroCorretas); // keys
	array_push($_SESSION["alunos"], $_POST["nomeAluno"]); // values
	$_SESSION["respostasAssociadas"] = array_map(function($key, $val) {return array($key=>$val);}, $_SESSION["alunos"], $_SESSION["numeroCorretas"]);
	return $numeroCorretas;
}
$resultado = corrigir(lerProva($caminhoProva), $respostas);
?>
