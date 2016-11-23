<?php
	include('cabecalho.html');
	
	echo "<h5 class=\"header col s12 light\" align=\"center\">Resultados:</h5>
			<form class=\"col s12\" action=\"pesquisa.php\" method=\"get\">
      	<div class=\"input-field row\">
				<div class=\"col s6 offset-s3\">
          		<input id=\"pesquisaText\" type=\"text\" class=\"validate\" name=\"pesquisaText\"><i class=\"material-icons prefix\">search</i>
        		</div>
      	</div>
      </form>";
	$letras = array('a)', 'b)', 'c)', 'd)');
	
	$pesquisa = $_GET['pesquisaText'];
	$sql = "SELECT * FROM questoes WHERE Conteudo like '%".$pesquisa."%' OR XML like '%".$pesquisa."%'";
	
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
	         <div class=\"col s12\">
	           <div class=\"row\">
	             <div class=\"input-field col s12\">
	             	<input type=\"hidden\" name=\"idQuestao\" value=\"".$consulta['ID']."\">
	               <h6 class=\"header col s12 light\">Questao: ".($key+1)."</h6>
	               <textarea class=\"materialize-textarea\" id=\"questao-produzida\" name=\"questao-produzida\" readonly>".$questao."</textarea>
	               <button type=\"submit\" class=\"waves-effect waves-light btn light-blue darken-4\" id=\"adicionar-pesquisar\" name=\"adicionar-pesquisar\">Adicionar a Prova
              			<i class=\"tiny material-icons white-text text-darken-1\">input</i>
            		</button>
	             </div>
	           </div>
	         </div>
	       </form>";
	}
	
	include('rodape.html');
?>
