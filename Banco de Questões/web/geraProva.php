<?php
	/* 
	Este codigo tem como objetivo gerar um arquivo XML contendo as questoes que 
	abrangem as caracteristicas definidas que deverao estar na prova.
	*/
	include('cabecalho.html');
	echo "<h5 class=\"header col s12 light\" align=\"center\">Prova:</h5>";
	$letras = array('a)', 'b)', 'c)', 'd)');
	session_start();
	if(isset($_POST['pub'])){
		$provaXML = "<prova>";
		
		//Pega os dados.
		$temaProduzir = $_POST['tema-produzir'];
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
		
		if($temaProduzir!='') $sql .= "AND Conteudo like '%".$temaProduzir."%'";
		
		$sql .= " LIMIT ".$_POST['numQuestoes-produzir']."";
		
		$conexao = new PDO('mysql:host=localhost; dbname=banco_de_questoes', 'phpmyadmin', 'o9rtjh88');    
			
		foreach($conexao->query($sql) as $key=>$consulta){
			$xml = simplexml_load_string($consulta['XML']);
			$questao = $xml->enunciado."\n\n";
			$nAlternativas = 0;
			foreach($xml->alternativa as $alternativas){
				if($consulta['Tipo']==0)
					$questao .= $letras[$nAlternativas].' '.$alternativas."\n";
				else if($consulta['Tipo']==1)
					$questao .= $letras[$nAlternativas].' [  ] '.$alternativas."\n";
				$nAlternativas++;
			}
			echo "<form class=\"row\" action=\"geraProva.php\" method=\"post\">
					<input type=\"hidden\" name=\"numeroQuestao\" value=\"".$key."\">
					<input type=\"hidden\" name=\"idQuestao\" value=\"".$consulta['ID']."\">
		         <div class=\"col s12\">
		           <button type=\"submit\" id=\"excluirQuestao\" name=\"excluirQuestao\" class=\"btn-flat\"><i class=\"material-icons\">close</i></button>
		           <div class=\"row\">
		             <div class=\"input-field col s12\">
		               <h6 class=\"header col s12 light\">Questao: ".($key+1)."</h6>
		               <textarea class=\"materialize-textarea\" id=\"questao-produzida\" name=\"questao-produzida\" readonly>".$questao."</textarea>
		             </div>
		           </div>
		         </div>
		       </form>";
		   $provaXML .= $consulta['XML'];
		}
		$provaXML .= "</prova>";
		
		$_SESSION['prova'] = $provaXML;
	}
	else if(isset($_POST['excluirQuestao'])){
		$provaXML = simplexml_load_string($_SESSION['prova']);
		$nQ = $_POST['numeroQuestao'];
		unset($provaXML->questao[intval($nQ)]);
		foreach($provaXML->questao as $key=>$quest){
			$texto = $quest->enunciado."\n\n";
			$nAlternativas = 0;
			foreach($quest->alternativa as $alternativas){
				if($quest['tipo']=='ME')
					$texto .= $letras[$nAlternativas].' '.$alternativas."\n";
				else if($quest['tipo']=='VF')
					$texto .= $letras[$nAlternativas].' [  ] '.$alternativas."\n";
				$nAlternativas++;
			}
			echo "<form class=\"row\" action=\"geraProva.php\" method=\"post\">
					<input type=\"hidden\" name=\"numeroQuestao\" value=\"".$key."\">
					<input type=\"hidden\" name=\"idQuestao\" value=\"".$_POST['idQuestao']."\">
		         <div class=\"col s12\">
		           <button type=\"submit\" id=\"excluirQuestao\" name=\"excluirQuestao\" class=\"btn-flat\"><i class=\"material-icons\">close</i></button>
		           <div class=\"row\">
		             <div class=\"input-field col s12\">
		               <h6 class=\"header col s12 light\">Questao: ".($key+1)."</h6>
		               <textarea class=\"materialize-textarea\" id=\"questao-produzida\" name=\"questao-produzida\" readonly>".$texto."</textarea>
		             </div>
		           </div>
		         </div>
		       </form>";
		}
		$_SESSION['prova']=$provaXML->asXML();
	}
	else if(isset($_POST['adicionar-pesquisar'])){
		if($_SESSION['prova']!=''){
			$conexao = new PDO('mysql:host=localhost; dbname=banco_de_questoes', 'phpmyadmin', 'o9rtjh88'); 
			$sql = "SELECT * FROM questoes WHERE ID=".$_POST['idQuestao']."";
			$consulta = $conexao->query($sql);
			$consulta = $consulta->fetch(PDO::FETCH_ASSOC);
			$questaoSimpleXML = simplexml_load_string($consulta['XML']);
			$provaXML = simplexml_load_string($_SESSION['prova']);
			
			$domProva = dom_import_simplexml($provaXML);
			$domQuestao = dom_import_simplexml($questaoSimpleXML);
			
			$domQuestao = $domProva->ownerDocument->importNode($domQuestao, TRUE);
			
			$domProva->appendChild($domQuestao);
			
			$numeroQuestaoX = 0;
			foreach($provaXML->questao as $quest){
				$texto = $quest->enunciado."\n\n";
				$nAlternativas = 0;
				foreach($quest->alternativa as $alternativas){
					if($quest['tipo']=='ME')
						$texto .= $letras[$nAlternativas].' '.$alternativas."\n";
					else if($quest['tipo']=='VF')
						$texto .= $letras[$nAlternativas].' [  ] '.$alternativas."\n";
					$nAlternativas++;
				}
				echo "<form class=\"row\" action=\"geraProva.php\" method=\"post\">
						<input type=\"hidden\" name=\"numeroQuestao\" value=\"".$numeroQuestaoX."\">
						<input type=\"hidden\" name=\"idQuestao\" value=\"".$_POST['idQuestao']."\">
		   	      <div class=\"col s12\">
		   	        <button type=\"submit\" id=\"excluirQuestao\" name=\"excluirQuestao\" class=\"btn-flat\"><i class=\"material-icons\">close</i></button>
		   	        <div class=\"row\">
		   	          <div class=\"input-field col s12\">
		   	            <h6 class=\"header col s12 light\">Questao: ".($numeroQuestaoX+1)."</h6>
		   	            <textarea class=\"materialize-textarea\" id=\"questao-produzida\" name=\"questao-produzida\" readonly>".$texto."</textarea>
		   	          </div>
		   	        </div>
		   	      </div>
		   	    </form>";
		   	 $numeroQuestaoX++;
			}
			$_SESSION['prova']=$provaXML->asXML();
		}
		else if($_SESSION['prova']==''){
			echo "<h5 class=\"header col s12 light\" align=\"center\">Não Iniciada!:</h5>";
		}
	}
	echo "<div align=\"center\">
		    <a class=\"waves-effect waves-light btn light-blue darken-4\" name=\"salvar-produzida\" align=\"center\" href=\"salvaProva.php\">
			  Enviar<i class=\"tiny material-icons white-text text-darken-1\">input</i>
      		</a>
      		<a class=\"waves-effect waves-light btn light-blue darken-4\" name=\"add-produzida\" align=\"center\" href=\"addQuestao.php\">
			  Adicionar Questão<i class=\"tiny material-icons white-text text-darken-1\">add</i>
      		</a>
      		<form action=\"geraProva.php\" method=\"post\">
      		<button type=\"submit\" class=\"waves-effect waves-light btn light-blue darken-4\" name=\"cancela-produzida\" align=\"center\" href=\"addQuestao.php\">
			  Excluir Prova<i class=\"tiny material-icons white-text text-darken-1\">add</i>
      		</button>
      		</form>
      	  </div>";
	include('rodape.html');
?>
