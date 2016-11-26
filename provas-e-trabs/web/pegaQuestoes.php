<?php

	$conecta = new mysqli('localhost', 'root', '', 'questoes') or print (mysql_error()); 
	print "Conexão OK!";

	$sql = "SELECT XMLq FROM questoes";
	$query = $conecta->query($sql);
	$linhas = $query->num_rows;
	$conteudo = "";
	if($linhas >= 1) {
		while($colunas = $query->fetch_assoc()) {
			$conteudo .= " {$colunas["XMLq"]} ";
		}
		$query->free();
	} else {
		echo "Não há resultados";
	}

	$fp = fopen("XMLq.xml", "a+");
	$escreve = fwrite($fp, $conteudo);

	fclose($fp);
	$conecta->close(); // FECHANDO A CONEXÃO
?>