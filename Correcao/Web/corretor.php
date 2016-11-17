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
			$respostas[$i] = formatarArray($xml, $nomePost);
		} else{
			$respostas[$i]= $_POST[$nomePost];
		}
	}
}

function formatarArray($xml, $nomePost){
	$arrayNovo = [];
	for ($i=0; $i<count($xml->questao[1]->alternativa); $i++){
		$arrayNovo[$i]=0;
	}
	for ($i=0; $i<count($_POST[$nomePost]); $i++){
		$arrayNovo[$_POST[$nomePost][$i]] = 1;
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
	array_push($_SESSION["alunos"], $_POST["nomeAluno"]); // values
	$_SESSION["respostasAssociadas"] = array_map(function($key, $val) {return array($key=>$val);}, $_SESSION["alunos"], $_SESSION["numeroCorretas"]);
	return $nota;
}
$resultado = corrigir($xml, $respostas);
?>
