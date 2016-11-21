<?php
	/* 
	Este codigo tem como objetivo gerar um arquivo XML contendo as questoes que 
	abrangem as caracteristicas definidas que deverao estar na prova.
	*/
	include('cabecalho.html');
	echo "<h5 class=\"header col s12 light\" align=\"center\">Prova:</h5>";
	$letras = array('a)', 'b)', 'c)', 'd)');
	$provaXML = "<prova>";
	
	//Pega os dados.
	$disciplinaProduzir = $_POST['disciplina-produzir'];
	$facilProduzir = array_key_exists('facil-produzir', $_POST) ? $_POST['facil-produzir'] : null;
	$medioProduzir = array_key_exists('medio-produzir', $_POST) ? $_POST['medio-produzir'] : null;
	$dificilProduzir = array_key_exists('dificil-produzir', $_POST) ? $_POST['dificil-produzir'] : null;
	$abertaProduzir = array_key_exists('dissertativas-produzir', $_POST) ? $_POST['dissertativas-produzir'] : null;
	$verdadeiraFalsaProduzir = array_key_exists('v_f-produzir', $_POST) ? $_POST['v_f-produzir'] : null;
	$multiplaEscolhaProduzir = array_key_exists('multipla_escolha-produzir', $_POST) ? $_POST['multipla_escolha-produzir'] : null;
	$numQuestoesProduzir = array_key_exists('numQuestoes-produzir', $_POST) ? $_POST['numQuestoes-produzir'] : null;
	
	//Gera o SQL.
	$sql = "SELECT * FROM questoes WHERE ";
	$sql .= "Materia=\"".$disciplinaProduzir."\" AND ";
	
	$nivelQuery = array();
	if($facilProduzir=='on') array_push($nivelQuery, '1');
	if($medioProduzir=='on') array_push($nivelQuery, '2');
	if($dificilProduzir=='on') array_push($nivelQuery, '3');
	$nivelQuery = implode(',', $nivelQuery);
	$sql .= "Dificuldade IN (".$nivelQuery.") AND ";
	
	$tipoQuery = array();
	if($abertaProduzir=='on') array_push($tipoQuery, '0');
	if($verdadeiraFalsaProduzir=='on') array_push($tipoQuery, '1');
	if($multiplaEscolhaProduzir=='on') array_push($tipoQuery, '2');
	$tipoQuery = implode(',', $tipoQuery);
	$sql .= "Tipo IN (".$tipoQuery.")";
	
	$conexao = new PDO('mysql:host=localhost; dbname=banco_de_questoes', 'phpmyadmin', 'o9rtjh88');    
		
	foreach($conexao->query($sql) as $key=>$consulta){
		$xml = simplexml_load_string($consulta['XML']);
		$questao = $xml->enunciado."\n\n";
		$nAlternativas = 0;
		foreach($xml->alternativa as $alternativas){
			$questao .= $letras[$nAlternativas].' '.$alternativas."\n";
			$nAlternativas++;
		}
		echo "<div class=\"row\">
	         <div class=\"col s12\">
	           <div class=\"row\">
	             <div class=\"input-field col s12\">
	               <h6 class=\"header col s12 light\">Questao: ".($key+1)."</h6>
	               <textarea class=\"materialize-textarea\" id=\"questao-produzida\" name=\"questao-produzida\" readonly>
	               ".$questao."
	               </textarea>
	             </div>
	           </div>
	         </div>
	       </div>";
	   $provaXML .= $consulta['XML'];
	}
	$provaXML .= "</prova>";
	
	session_start();
	$_SESSION['prova'] = $provaXML;
	
	echo "<div align=\"center\">
		    <a class=\"waves-effect waves-light btn light-blue darken-4\" name=\"salvar-produzida\" align=\"center\" href=\"salvaProva.php\">
			  Enviar<i class=\"tiny material-icons white-text text-darken-1\">input</i>
      		</a>
      	  </div>";
	include('rodape.html');
?>
