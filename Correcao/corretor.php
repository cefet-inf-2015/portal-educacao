<?php

$respostas = array("Quinze","Sessenta e quatro");
$numeroCorretas = 0;
if (file_exists('ModeloProva.xml')) {
    $xml = simplexml_load_file('ModeloProva.xml');
    //print_r($xml);
} else {
    exit('Failed to open ModeloProva.xml.');
}
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

echo "
<!DOCTYPE html>
<html>
<head>
	<title>Correção</title>
	<meta charset=\"utf-8\">
</head>
<body><p>Questões acertadas: ".$numeroCorretas."</p></body></html>"
?>