<?php
	include('cabecalho.html');
	if(isset($_POST['excluir-alterar'])){
		//Pegando dados via POST
		$id = $_POST['formID'];
		
		//Conectando e escrevendo no BD
   	$conexao = new PDO('mysql:host=localhost; dbname=banco_de_questoes', 'phpmyadmin', 'o9rtjh88');    
   	$sql = "DELETE FROM questoes WHERE id=\"".$id."\"";
   	
   	if($conexao->exec($sql)){
			$msg = "Questão apagada com sucesso!";
		}
		else{
			$msg = "Questão não apagada!";
		}
		
		echo "<div class=\"row center\"><h5 class=\"header col s12 light\">".$msg."</h5><br><br>
			<a class=\"waves-effect waves-light btn light-blue darken-4\" href=\"BancoDeQuestoes.php\"
			 id=\"inserir\">Voltar<i class=\"tiny material-icons white-text text-darken-1\">replay</i></a>
			 </div><br><br>";
	
		include('rodape.html');	
	}
	else{
		//Pegando dados via POST
		$id = $_POST['formID'];
		$estilo = $_POST['estilo-alterar'];
		$nivel = $_POST['nivel-alterar'];
		$disciplina = $_POST['disciplina-alterar'];
   	$tema = $_POST['tema-alterar'];
   	$cabecalho = $_POST['cabecalho-alterar'];
   	$gabarito = $_POST['gabarito-alterar'];
   	$criador = $_SERVER['SERVER_ADMIN'];
   	 
   	 
   	 
   	 //Se questao for multipla escolha
   	 if($estilo==0){    	
   	 	//Gerando XML
   	 	$GLOBALS['xml'] = "<questao tipo=\"\"ME\"\" aleatorio=\"\"true\"\">
   	 			<dificuldade>".$GLOBALS['nivel']."</dificuldade> <!--dificuldade(1 a 3) -->
   	     		<materia>".$GLOBALS['disciplina']."</materia> <!--Materia -->
   	     		<conteudo>".$GLOBALS['tema']."</conteudo> <!--Conteudo -->
   	     		<enunciado>".$GLOBALS['cabecalho']."</enunciado> <!--enunciado -->";
   	     		
   	   //Pegando Alternativas em Array
   	 	$alternativa = array();
   	 	$radio = $_POST['rdioEdit'];
   	 	for($i=0; $i<=4; $i++){
				if(array_key_exists('alternativaEdit-'.$i, $_POST)){
					$alternativa[$i] = $_POST['alternativaEdit-'.$i];
					if('rdio'+$i==$radio)
						$GLOBALS['xml'] .= "<alternativa correta=\"\"true\"\">";
					else
						$GLOBALS['xml'] .= "<alternativa>";	
					$GLOBALS['xml'] .= $alternativa[$i]."</alternativa>";
				}
				
			}
	
		}
		
		//Se questao for VF
   	 if($estilo==1){    	
   	 	//Gerando XML
   	 	$GLOBALS['xml'] = "<questao tipo=\"\"VF\"\" aleatorio=\"\"true\"\">
   	 			<dificuldade>".$GLOBALS['nivel']."</dificuldade> <!--dificuldade(1 a 3) -->
   	     		<materia>".$GLOBALS['disciplina']."</materia> <!--Materia -->
   	     		<conteudo>".$GLOBALS['tema']."</conteudo> <!--Conteudo -->
   	     		<enunciado>".$GLOBALS['cabecalho']."</enunciado> <!--enunciado -->";
   	     		
   	     //Pegando Alternativas em Array
   	 	$alternativa = array();
   	 	for($i=0; $i<=4; $i++){
				if(array_key_exists('alternativaEdit-'.$i, $_POST)){
					$alternativa[$i] = $_POST['alternativaEdit-'.$i];
					if($_POST['cBoxEdit-'.$i]=='on'){
						$GLOBALS['xml'] .= "<alternativa correta=\"\"true\"\">".$alternativa[$i]."</alternativa>";
					}else{
						$GLOBALS['xml'] .= "<alternativa>".$alternativa[$i]."</alternativa>";
					}
				}	
			}
		}
		
		//Se questao for aberta
   	 if($estilo==2){    	
   	 	//Gerando XML
   	 	$GLOBALS['xml'] = "<questao tipo=\"\"aberta\"\" aleatorio=\"\"true\"\">
   	 			<dificuldade>".$GLOBALS['nivel']."</dificuldade> <!--dificuldade(1 a 3) -->
   	     		<materia>".$GLOBALS['disciplina']."</materia> <!--Materia -->
   	     		<conteudo>".$GLOBALS['tema']."</conteudo> <!--Conteudo -->
   	     		<enunciado>".$GLOBALS['cabecalho']."</enunciado> <!--enunciado -->";
		}
	
		//fechando XML
		$GLOBALS['xml'] .= "</questao>";
	
   	 //Conectando e escrevendo no BD
   	 $conexao = new PDO('mysql:host=localhost; dbname=banco_de_questoes', 'phpmyadmin', 'o9rtjh88');    
   	 $sql = "UPDATE questoes SET Materia='".$disciplina."', Conteudo='".$tema."', Dificuldade='".$nivel."', Tipo='".$estilo."', XML=\"".$GLOBALS['xml']."\" WHERE id='".$id."'";
		
		if($conexao->exec($sql)){
			$msg = "Questão alterada com sucesso!";
		}
		else{
			$msg = "Questão não alterada!";
		}
		
		echo "<div class=\"row center\"><h5 class=\"header col s12 light\">".$msg."</h5><br><br>
			<a class=\"waves-effect waves-light btn light-blue darken-4\" href=\"BancoDeQuestoes.php\"
			 id=\"inserir\">Voltar<i class=\"tiny material-icons white-text text-darken-1\">replay</i></a>
			 </div><br><br>";
	
		include('rodape.html');
	}
?>
