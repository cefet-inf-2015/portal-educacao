<?php
	// ATENÇÃO GERENCIA!!
	// LINHA 14!!
	// LINHA 105!!

	//inclui cabecalho que pode ser reaproveitado
	include('cabecalho.html');

	//Pega os dados via POST.
	$estilo = $_POST['estilo-inserir'];
	$nivel = $_POST['nivel-inserir'];
	$disciplina = $_POST['disciplina-inserir'];
    $tema = $_POST['tema-inserir'];
    $cabecalho = $_POST['cabecalho-inserir'];
    
    //CRIADOR DEVE SER IGUAL AO USERNAME
    $criador = $_SERVER['SERVER_ADMIN']; //USERNAME AQUI AO INVES DE SERVER ADMIN
    
    //Se o estilo da questao escolhida for ME.
    if($estilo==0){    	
    	//Gera o XML.
    	$GLOBALS['xml'] = "<questao tipo=\"ME\" aleatorio=\"true\">
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
					$GLOBALS['xml'] .= "<alternativa correta=\"true\">";
					$GLOBALS['xml'] .= $alternativa[$i]."</alternativa>";
				}else{
					$GLOBALS['xml'] .= "<alternativa correta=\"false\">";	
					$GLOBALS['xml'] .= $alternativa[$i]."</alternativa>";
				}
			}
		}
	}
	
	//Se o estilo da questao escolhida for VF.
    if($estilo==1){    	
    	//Gera o XML.
    	$GLOBALS['xml'] = "<questao tipo=\"VF\" aleatorio=\"true\">
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
					$GLOBALS['xml'] .= "<alternativa correta=\"true\">".$alternativa[$i]."</alternativa>";
				}else{
					$GLOBALS['xml'] .= "<alternativa correta=\"false\">".$alternativa[$i]."</alternativa>";
				}
			}	
		}
	}
	
	//Se o estilo da questao escolhida for 'aberta'.
    if($estilo==2){    	
    	//Gera o XML.
    	$GLOBALS['xml'] = "<questao tipo=\"aberta\" aleatorio=\"true\">
    			<dificuldade>".$GLOBALS['nivel']."</dificuldade> <!--dificuldade(1 a 3) -->
        		<materia>".$GLOBALS['disciplina']."</materia> <!--Materia -->
        		<conteudo>".$GLOBALS['tema']."</conteudo> <!--Conteudo -->
        		<enunciado>".$GLOBALS['cabecalho']."</enunciado> <!--enunciado -->";
	}
	
    //Conecta e escreve no banco de dados.
    $conexao = new PDO('mysql:host=localhost; dbname=banco_de_questoes', 'phpmyadmin', 'o9rtjh88');    
    $sql = "INSERT INTO questoes VALUES ('', '".$disciplina."', '".$tema."', ".$nivel.", ".$estilo.", '', '".$criador."')";
	
	//Testa se conexão deu certo
	if($conexao->exec($sql)){
		$msg = "Questão inserida com sucesso!";
	}
	else{
		$msg = "Questão não inserida!";
	}


	//Realiza uma consulta para receber o ultimo ID gerado pelo BD para esse user		
	$sql = "SELECT ID FROM questoes WHERE User='".$criador."' ORDER BY ID DESC LIMIT 1";
	$consulta = $conexao->query($sql);
	$consulta = $consulta->fetch(PDO::FETCH_ASSOC);
	
	//Usa este ID para salvar uma possivel imagem
  	if($consulta!=null){
		if(isset($_FILES['userfile']['name'])&&$_FILES['userfile']['error']==0){
			$arquivo_tmp = $_FILES['userfile']['tmp_name'];
			$nome = $_FILES['userfile']['name'];
			
			$extensao = pathinfo($nome, PATHINFO_EXTENSION);
			$entensao = strtolower($extensao);
			if(strstr('.jpg;.jpeg;.gif;.png', $extensao)){
				//A variavel destino é a pasta que estarão as fotos.
				//A alteração ou não para uma nova pasta fica a criterio da
				//gerencia.
				$novoNome = $consulta['ID'].'.'.$extensao;
				$destino = 'uploads/'.$novoNome;
				
				move_uploaded_file($arquivo_tmp, $destino);
				$GLOBALS['xml'] .= "<imagem>\"".$destino."\"</imagem>";
				//Fecha o XML.
				$GLOBALS['xml'] .= "</questao>";
			}
			else $msg .= "Imagem não inserida!";
		}
		else $GLOBALS['xml'] .= "</questao>";
	}
	
	//Atualiza XML para conter caminho da imagem no servidor
	$sql = "UPDATE questoes SET XML='".$GLOBALS['xml']."' WHERE ID='".$consulta['ID']."'";
	$conexao->exec($sql);
	
	//Exibe mensagem que comunica ao usuario o estado da operação
	echo "<div class=\"row center\"><h5 class=\"header col s12 light\">".$msg."</h5><br><br>
		    <a class=\"waves-effect waves-light btn light-blue darken-4\" href=\"BancoDeQuestoes.php\"
			  id=\"inserir\">Voltar<i class=\"tiny material-icons white-text text-darken-1\">replay</i>
			</a>
			</div><br><br>";
	//Inclui rodapé que pode ser re-aproveitado
	include('rodape.html')
?>
