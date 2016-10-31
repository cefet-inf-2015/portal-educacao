<?php
session_start();
if(!isset($_SESSION['numeroCorretas'])){
	$_SESSION['numeroCorretas'] = array();
}
$caminhoProva = $_FILES['prova']['tmp_name'];
$caminhoGabarito = $_FILES['gabarito']['tmp_name'];
function lerProva($caminhoprova){
	if (file_exists($caminhoprova)) {
 	   $xml = simplexml_load_file($caminhoprova);
	} else {
	    exit('Falha ao abrir arquivo');
	}
	return $xml;
}
function lerGabarito($caminhogabarito){
	$a = file($caminhogabarito);
	$respostasConcatenadas = implode(",", $a);
	$respostas = explode(",", $respostasConcatenadas);
	foreach ($respostas as &$key) {
		$key = substr($key, 3);
		$key = rtrim($key);
	}
	return $respostas;
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
	array_push($_SESSION["numeroCorretas"], $numeroCorretas);
	return $numeroCorretas;
}
$resultado = corrigir(lerProva($caminhoProva), lerGabarito($caminhoGabarito));
?>
