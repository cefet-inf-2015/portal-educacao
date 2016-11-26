<?php
	/* 
	Este codigo tem como objetivo gerar um arquivo XML contendo as questoes que 
	abrangem as caracteristicas definidas que deverao estar na prova.
	*/
	include('cabecalho.html');
	echo "<h5 class=\"header col s12 light\" align=\"center\">Prova:</h5>";
	$letras = array('a)', 'b)', 'c)', 'd)');
	
	//Inicia a sessão para permitir que a prova seja acessada por outra
	//Pagina.
	session_start();
	
	//Se for clicado botão de gerar prova aleatoria
	if(isset($_POST['pub'])){
		//Inicia XML
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
		
		//Adiciona niveis de dificuldade a escolha do usuario
		$nivelQuery = array();
		if($facilProduzir=='on') array_push($nivelQuery, '1');
		if($medioProduzir=='on') array_push($nivelQuery, '2');
		if($dificilProduzir=='on') array_push($nivelQuery, '3');
		$nivelQuery = implode(',', $nivelQuery);
		$sql .= "Dificuldade IN (".$nivelQuery.") AND ";
		
		//Adiciona tipos de questao a escolha do usuario
		$tipoQuery = array();
		if($abertaProduzir=='on') array_push($tipoQuery, '0');
		if($verdadeiraFalsaProduzir=='on') array_push($tipoQuery, '1');
		if($multiplaEscolhaProduzir=='on') array_push($tipoQuery, '2');
		$tipoQuery = implode(',', $tipoQuery);
		$sql .= "Tipo IN (".$tipoQuery.")";
		
		//Sistema de pesquisa
		if($temaProduzir!='') $sql .= "AND Conteudo like '%".$temaProduzir."%'";
		
		//Sistema de randomização
		$sql .= "ORDER BY rand() LIMIT ".$_POST['numQuestoes-produzir']."";
		
		//Conecta no BD
		$conexao = new PDO('mysql:host=localhost; dbname=banco_de_questoes', 'phpmyadmin', 'o9rtjh88');    
		
		//Pega as questoes			
		foreach($conexao->query($sql) as $key=>$consulta){
		   $provaXML .= $consulta['XML'];
		}
		$provaXML .= "</prova>";
		//Salva prova na sessão
		$_SESSION['prova'] = $provaXML;
	}
	//Se for clicado botão de excluir uma questao da prova
	else if(isset($_POST['excluirQuestao'])){
		$provaXML = simplexml_load_string($_SESSION['prova']);
		$nQ = $_POST['numeroQuestao'];
		unset($provaXML->questao[intval($nQ)]);
		$_SESSION['prova']=$provaXML->asXML();
	}
	
	//Se for adicionava uma questao por meio de pesquisa	
	else if(isset($_POST['adicionar-pesquisar'])){
		//Se a prova ja estiver iniciada
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
			
			
			$_SESSION['prova']=$provaXML->asXML();
		}
		//Se a prova não foi iniciada
		else if($_SESSION['prova']==''){
			$conexao = new PDO('mysql:host=localhost; dbname=banco_de_questoes', 'phpmyadmin', 'o9rtjh88'); 
			$sql = "SELECT * FROM questoes WHERE ID=".$_POST['idQuestao']."";
			$consulta = $conexao->query($sql);
			$consulta = $consulta->fetch(PDO::FETCH_ASSOC);
			$provaXML = "<prova>".$consulta['XML']."</prova>";
		}
	}
	
	//Se a prova foi cancelada ou ficou sem questoes
	if(isset($_POST['cancela-produzida'])||empty(simplexml_load_string($_SESSION['prova']))){
			header('location: BancoDeQuestoes.php');
			
	}
	
	//Mostrando pré-vizualização da prova ao usuario
	$provaXML = simplexml_load_string($_SESSION['prova']);
	$numeroX = 0;
	foreach($provaXML->questao as $quest){
		$texto = $quest->enunciado."\n\n";
		$textoAlt = '';
		$nAlternativas = 0;
		foreach($quest->alternativa as $alternativas){
			if($quest['tipo']=='ME')
				$textoAlt .= $letras[$nAlternativas].' '.$alternativas."\n";
			else if($quest['tipo']=='VF')
				$textoAlt .= $letras[$nAlternativas].' [  ] '.$alternativas."\n";
			$nAlternativas++;
		}
		echo "<form class=\"row\" action=\"geraProva.php\" method=\"post\">
				<input type=\"hidden\" name=\"numeroQuestao\" value=\"".$numeroX."\">
				<input type=\"hidden\" name=\"idQuestao\" value=\"".$_POST['idQuestao']."\">
	         <div class=\"col s12\">
	           <button type=\"submit\" id=\"excluirQuestao\" name=\"excluirQuestao\" class=\"btn-flat\"><i class=\"material-icons\">close</i></button>
	           <div class=\"row\">
	             <div class=\"input-field col s12\">
	               <h6 class=\"header col s12 light\">Questao: ".($numeroX+1)."</h6>
	               <div>".$texto."</div>";
		 if(array_key_exists('imagem', $quest)) echo "<img src=".$quest->imagem." width=150 height=150>";
	    echo       "<textarea class=\"materialize-textarea\" id=\"questao-produzida\" name=\"questao-produzida\" readonly>".$textoAlt."</textarea>
	             </div>
	           </div>
	         </div>
	       </form>";
	   $numeroX++;
	}
	
	//Botoes de controle da prova
	echo "<div align=\"center\">
      		<form action=\"geraProva.php\" method=\"post\">
		             <a class=\"waves-effect waves-light btn light-blue darken-4\" name=\"salvar-produzida\" align=\"center\" href=\"salvaProva.php\">
			  Enviar<i class=\"tiny material-icons white-text text-darken-1\">input</i>
      		</a>
      		<a class=\"waves-effect waves-light btn light-blue darken-4\" name=\"add-produzida\" align=\"center\" href=\"addQuestao.php\">
			  Adicionar Questão<i class=\"tiny material-icons white-text text-darken-1\">add</i>
      		</a>
      		<button type=\"submit\" class=\"waves-effect waves-light btn light-blue darken-4\" name=\"cancela-produzida\" align=\"center\" href=\"addQuestao.php\">
			  Excluir Prova<i class=\"tiny material-icons white-text text-darken-1\">add</i>
      		</button>
      		</form>
      	  </div>";
	include('rodape.html');
?>
