<?php
	//Cabecalho que pode ser reutilizado
	include('cabecalho.html');
	
	//Simples barra de pesquisa
	echo "<h5 class=\"header col s12 light\" align=\"center\">Resultados:</h5>
			<form class=\"col s12\" action=\"pesquisa.php\" method=\"get\">
      	<div class=\"input-field row\">
				<div class=\"col s6 offset-s3\">
          		<input id=\"pesquisaText\" type=\"text\" class=\"validate\" name=\"pesquisaText\"><i class=\"material-icons prefix\">search</i>
        		</div>
      	</div>
      </form>";
      
	//Letras para impressão de alternativas
	$letras = array('a)', 'b)', 'c)', 'd)');
	
	//Pegando dados
	$pesquisa = $_GET['pesquisaText'];
	$sql = "SELECT * FROM questoes WHERE Conteudo like '%".$pesquisa."%' OR XML like '%".$pesquisa."%'";
	
	//Conectando ao BD
	$conexao = new PDO('mysql:host=localhost; dbname=banco_de_questoes', 'phpmyadmin', 'o9rtjh88');    
		
	//Realizando pesquisa		
	foreach($conexao->query($sql) as $key=>$consulta){
		$xml = simplexml_load_string($consulta['XML']);
		$texto = $xml->enunciado."\n\n";
		$questao = '';
		$nAlternativas = 0;
		foreach($xml->alternativa as $alternativas){
			if($consulta['Tipo']==0)
				$questao .= $letras[$nAlternativas].' '.$alternativas."\n";
			else if($consulta['Tipo']==1)
				$questao .= $letras[$nAlternativas].' [  ] '.$alternativas."\n";
			$nAlternativas++;
		}
		//Imprimindo resultados dinamicamente
		echo "<form class=\"row\" action=\"geraProva.php\" method=\"post\">
	         <div class=\"col s12\">
	           <div class=\"row\">
	             <div class=\"input-field col s12\">
	             	<input type=\"hidden\" name=\"idQuestao\" value=\"".$consulta['ID']."\">
	               <h6 class=\"header col s12 light\">Questao: ".($key+1)."</h6>
	               <div>".$texto."</div><br>";
	   if(array_key_exists('imagem', $xml)) echo "<img src=".$xml->imagem." width=150 height=150 name=\"imagemDivPesquisar\"/>";
	   echo "<textarea class=\"materialize-textarea\" id=\"questao-produzida\" name=\"questao-produzida\" readonly>".$questao."</textarea>
	               <button type=\"submit\" class=\"waves-effect waves-light btn light-blue darken-4\" id=\"adicionar-pesquisar\" name=\"adicionar-pesquisar\">Adicionar a Prova
              			<i class=\"tiny material-icons white-text text-darken-1\">input</i>
            		</button>
	             </div>
	           </div>
	         </div>
	       </form>";
	}
	
	//Incluido rodapé
	include('rodape.html');
?>
