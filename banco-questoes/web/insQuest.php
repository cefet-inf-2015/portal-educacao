<?php
	include('cabecalho.html');

	//Pega os dados via POST.
	$estilo = $_POST['estilo-inserir'];
	$nivel = $_POST['nivel-inserir'];
	$disciplina = $_POST['disciplina-inserir'];
    $tema = $_POST['tema-inserir'];
    $cabecalho = $_POST['cabecalho-inserir'];
    $gabarito = $_POST['gabarito-inserir'];
    $criador = $_SERVER['SERVER_ADMIN'];
    
    //Se o estilo da questao escolhida for ME.
    if($estilo==0){    	
    	//Gera o XML.
    	$GLOBALS['xml'] = "<questao tipo=\"\"ME\"\" aleatorio=\"\"true\"\">
    			<dificuldade>".$GLOBALS['nivel']."</dificuldade> <!--dificuldade(1 a 3) -->
        		<materia>".$GLOBALS['disciplina']."</materia> <!--Materia -->
        		<conteudo>".$GLOBALS['tema']."</conteudo> <!--Conteudo -->
        		<enunciado>".$GLOBALS['cabecalho']."</enunciado> <!--enunciado -->";
        		
        //Pega as alternativas em um Array.
    	$alternativa = array();
    	$radio = $_POST['rdio'];
    	for($i=0; $i<=4; $i++){
			if(array_key_exists('alternativa'.$i, $_POST)){
				$alternativa[$i] = $_POST['alternativa'.$i];
				if('rdio'+$i==$radio){
					$GLOBALS['xml'] .= "<alternativa correta=\"\"true\"\">";
					$GLOBALS['xml'] .= $alternativa[$i]."</alternativa>";
				}else{
					$GLOBALS['xml'] .= "<alternativa correta=\"\"false\"\">";	
					$GLOBALS['xml'] .= $alternativa[$i]."</alternativa>";
				}
			}
		}
	}
	
	//Se o estilo da questao escolhida for VF.
    if($estilo==1){    	
    	//Gera o XML.
    	$GLOBALS['xml'] = "<questao tipo=\"\"VF\"\" aleatorio=\"\"true\"\">
    			<dificuldade>".$GLOBALS['nivel']."</dificuldade> <!--dificuldade(1 a 3) -->
        		<materia>".$GLOBALS['disciplina']."</materia> <!--Materia -->
        		<conteudo>".$GLOBALS['tema']."</conteudo> <!--Conteudo -->
        		<enunciado>".$GLOBALS['cabecalho']."</enunciado> <!--enunciado -->";
        		
        //Pega as alternativas em um Array.
    	$alternativa = array();
    	for($i=0; $i<=4; $i++){
			if(array_key_exists('alternativa'.$i, $_POST)){
				$alternativa[$i] = $_POST['alternativa'.$i];
				if($_POST['cBox'.$i]=='on'){
					$GLOBALS['xml'] .= "<alternativa correta=\"\"true\"\">".$alternativa[$i]."</alternativa>";
				}else{
					$GLOBALS['xml'] .= "<alternativa>".$alternativa[$i]."</alternativa>";
				}
			}	
		}
	}
	
	//Se o estilo da questao escolhida for 'aberta'.
    if($estilo==2){    	
    	//Gera o XML.
    	$GLOBALS['xml'] = "<questao tipo=\"\"aberta\"\" aleatorio=\"\"true\"\">
    			<dificuldade>".$GLOBALS['nivel']."</dificuldade> <!--dificuldade(1 a 3) -->
        		<materia>".$GLOBALS['disciplina']."</materia> <!--Materia -->
        		<conteudo>".$GLOBALS['tema']."</conteudo> <!--Conteudo -->
        		<enunciado>".$GLOBALS['cabecalho']."</enunciado> <!--enunciado -->";
	}

	//Fecha o XML.
	$GLOBALS['xml'] .= "</questao>";

    //Conecta e escreve no banco de dados.
    $conexao = new PDO('mysql:host=localhost; dbname=banco_de_questoes', 'phpmyadmin', 'o9rtjh88');    
    $sql = "INSERT INTO questoes VALUES ('', '".$disciplina."', '".$tema."', ".$nivel.", ".$estilo.", \"".$GLOBALS['xml']."\", '".$criador."')";
	
	if($conexao->exec($sql)){
		$msg = "Questão inserida com sucesso!";
	}
	else{
		$msg = "Questão não inserida!";
	}
	
	echo "<div class=\"row center\"><h5 class=\"header col s12 light\">".$msg."</h5><br><br>
		    <a class=\"waves-effect waves-light btn light-blue darken-4\" href=\"BancoDeQuestoes.php\"
			  id=\"inserir\">Voltar<i class=\"tiny material-icons white-text text-darken-1\">replay</i>
			</a>
		  </div><br><br>";
	
	include('rodape.html')
?>
