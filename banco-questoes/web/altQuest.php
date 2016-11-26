<?php
    //Estabelece a conexao com o banco de dados.
    $conexao = new PDO('mysql:host=localhost; dbname=banco_de_questoes', 'phpmyadmin', 'o9rtjh88');  
    $sql = "SELECT * FROM questoes WHERE User='".$_SERVER['SERVER_ADMIN']."'";
	
    $qc = 0; //Variavel utilizada para contar o numero de questoes (questaoCounter).
    foreach($conexao->query($sql) as $consulta){
  		$xml = simplexml_load_string($consulta['XML']);
  		
      //Mostra na tela as questoes inseridas no banco de dados. 
      echo "<form class=\"form_alterar\" action=\"altera.php\" method=\"post\" id=\"".$consulta['ID']."\">
  				  <input type=\"hidden\" name=\"formID\" value=\"".$consulta['ID']."\">
  				  <input type=\"hidden\" name=\"numQuestao\" value=\"".$qc."\">
  			    <br>
  			    <p><h5 class=\"header col s12 light\">Questão: ".($qc+1)."</h5><p>
  			    <p>  
              <select class=\"browser-default\" id=\"estilo-alterar-".$qc."\" name=\"estilo-alterar\" required>
                <option value=\"0\"";
                if($consulta['Tipo']==0) echo "selected";
                echo ">Múltipla Escolha</option>
                <option value=\"1\"";
                if($consulta['Tipo']==1) echo "selected";
                echo ">Verdadeiro ou Falso</option>
                <option value=\"2\"";
                if($consulta['Tipo']==2) echo "selected";
                echo">Dissertativa</option>
              </select>
            </p>
           
            <p>
              <select class=\"browser-default\" id=\"nivel-alterar-".$qc."\" name=\"nivel-alterar\" required>
                <option value=\"1\"";
                if($consulta['Dificuldade']==1) echo "selected";
                echo ">Fácil</option>
                <option value=\"2\"";
                if($consulta['Dificuldade']==2) echo "selected";
                echo">Mediana</option>
                <option value=\"3\"";
                if($consulta['Dificuldade']==3) echo "selected";
                echo ">Difícil</option>
              </select>
            </p>

            <p>
              <select class=\"browser-default\" id=\"disciplina-alterar-".$qc."\" name=\"disciplina-alterar\" required>
                <option value=\"Aplicações para Web\"";
                if($consulta['Materia']=="Aplicações para Web") echo "selected";
                echo ">Aplicações para Web</option>
                
                <option value=\"Arquitetura de Sistemas Digitais\"";
                if($consulta['Materia']=="Arquitetura de Sistemas Digitais") echo "selected";
                echo ">Arquitetura de Sistemas Digitais</option>
                
                <option value=\"Linguagem de Programação\"";
                if($consulta['Materia']=="Linguagem de Programação") echo "selected";
                echo">Linguagem de Programação - JAVA</option>
                
                <option value=\"Manutenção de Computadores\"";
                if($consulta['Materia']=="Manutenção de Computadores") echo "selected";
                echo ">Manutenção de Computadores</option>
                
                <option value=\"Biologia\"";
                if($consulta['Materia']=="Biologia") echo "selected";
                echo ">Biologia</option>
                
                <option value=\"Filosofia\"";
                if($consulta['Materia']=="Filosofia") echo "selected";
                echo ">Filosofia</option>
                
                <option value=\"Física\"";
                if($consulta['Materia']=="Física") echo "selected";
                echo ">Física</option>
                
                <option value=\"Geografia\"";
                if($consulta['Materia']=="Geografia") echo "selected";
                echo ">Geografia</option>
                
                <option value=\"Historia\"";
                if($consulta['Materia']=="Historia") echo "selected";
                echo ">História</option>
                
                <option value=\"Matemática\"";
                if($consulta['Materia']=="Matemática") echo "selected";
                echo ">Matemática</option>
                
                <option value=\"Português\"";
                if($consulta['Materia']=="Português") echo "selected";
                echo ">Português</option>
                
                <option value=\"Química\"";
                if($consulta['Materia']=="Química") echo "selected";
                echo ">Química</option>
                
                <option value=\"Sociologia\"";
                if($consulta['Materia']=="Sociologia") echo "selected";
                echo ">Sociologia</option>
                
                <option value=\"outro\"";
                if($consulta['Materia']=="outro") echo "selected";
                echo ">Outra</option>
              </select>
            </p> 

            <p>
              <div class=\"row\" align=\"left\">
                <div class=\"input-field col s12\">
                  <input type=\"text\" class=\"validate\" id=\"tema-alterar-".$qc."\" name=\"tema-alterar\" value=\"".$consulta['Conteudo']."\" required>
                  <label class=\"active\" for=\"tema-alterar-".$qc."\">Digite o tema:</label>
                </div>
              </div>
            </p>

            <div class=\"row\">
              <div class=\"col s12\">
                <div class=\"row\">
                  <div class=\"input-field col s12\">
                    <textarea class=\"materialize-textarea\" id=\"cabecalho-alterar-".$qc."\" name=\"cabecalho-alterar\" required>".$xml->enunciado."</textarea>
                    <label for=\"cabecalho-alterar-".$qc."\">Digite o cabeçalho da questão:</label>
                  </div>
                </div>
              </div>
            </div><!-- Espaço onde as alternativas serão inseridas -->";
          
          //Mostra na tela as alternativas referentes a cada questao de ME ou VF inserida no banco de dados.         
          echo "<div id=\"alternativas-alterar-".$qc."\" name=\"alternativas-alterar\">";
          
          $ic = 0; //Variavel utilizada para contar o numero de alternativas.
          foreach($xml->alternativa as $key => $alternativa){
				 	echo "<div class=\"col s12 alternativaEditar\">
				 				<div class=\"row\">
				 					<label for=\"altEdit-".$qc."-".$ic."\" class=\"labelAltEdit\">Alternativa: ".($ic+1)."</label>
				 					<textarea class=\"materialize-textarea\" id=\"altEdit-".$qc."-".$ic."\" name=\"alternativaEdit-".$qc."-".$ic."\">".$alternativa."</textarea>
				 					<div class=\"checkboxesEdit-".$qc." esconder\">
				 						<input id=\"cBoxEdit-".$qc."-".$ic."\" name=\"cBoxEdit-".$qc."-".$ic."\" type=\"checkbox\" class=\"filled-in checkboxesEditar-".$qc."\"";
				 	if($alternativa['correta']=='true'){
						echo 'checked';
					}					
				 	echo				">
				 						<label for=\"cBoxEdit-".$qc."-".$ic."\" class=\"cBoxEditLabel\">Verdadeiro</label>
				 					</div>
				 					<div class=\"radioEdit-".$qc." mostrar\">
				 						<input id=\"rdioEdit-".$qc."-".$ic."\" name=\"rdioEdit-".$qc."\" type=\"radio\" value=\"rdioEdit-".$qc."-".$ic."\" class=\"rdiosEdit-".$qc."\"";
				 	if($alternativa['correta']=='true'){
						echo 'checked';
					}					
				 	echo			">
				 						<label for=\"rdioEdit-".$qc."-".$ic."\" class=\"radioEditLabel\">Correto</label>
				 					</div>
				 					<div align=\"right\">
				 						<input id=\"cBoxExcluirEditar-".$qc."-".$ic."\" name=\"cBoxExcluirEditar-".$qc."-".$ic."\" type=\"checkbox\" class=\"filled-in checkboxesExcluirEditar\" align=\"right\">
				 						<label for=\"cBoxExcluirEditar-".$qc."-".$ic."\" class=\"cBoxExcluirLabelEditar\"> Excluir</label>
				 					</div>
				 					<br><br>
				 				</div>
				 			</div>";
				 	$ic++;
				}
				
	     //Mostra na tela os botoes que devem aparecer quando o estilo da questao selecionada for ME ou FV.
        echo "</div> 
              <!-- Botões específicos para questões de Múltipla Escolha ou VF -->
              <div class=\"esconder\" id=\"adicionar_excluir-alterar-".$qc."\" align=\"left\">
                <a class=\"btn-floating btn waves-effect waves-light light-blue darken-4\" id=\"inserirAlternativa-alterar-".$qc."\">
		   	          <i class=\"material-icons\">add</i>
			          </a>
        				<a class=\"btn-floating btn waves-effect waves-light light-blue darken-4\" id=\"excluirAlternativa-alterar-".$qc."\">
        			   	<i class=\"material-icons\">delete</i>
        				</a>
                <a class=\"btn-floating btn waves-effect waves-light light-blue darken-4\" id=\"limparAlternativa-alterar-".$qc."\">
		   	          <i class=\"material-icons\">delete_forever</i>
			          </a>
		          </div>
		        <div class=\"row\">
              <div class=\"col s12\">";
              if(array_key_exists('imagem', $xml)){
              	echo  "<div class=\"row\">
              	     <img src=".$xml->imagem." width=150 height=150 name=\"imagemDivEditar\"/>
              	     <label id=\"excluirFotoEditar-".$qc."\" name=\"excluirFotoEditar-".$qc."\" class=\"material-icons\">close</label>
              	  </div>";
              }
              echo  "<div id=\"uploadImg-Editar\" class=\"esconder\">
					  <div class=\"file-field input-field\">
					    <div class=\"blue darken-4 btn\">
					      <span><i class=\"material-icons right\">attach_file</i>Anexar Imagem</span>
					      <input type=\"hidden\" name=\"MAX_FILE_SIZE_EDITAR\" value=\"30000\">
					      <input type=\"file\" name=\"userfile-Editar\">
					    </div>
					    <div class=\"file-path-wrapper\">";
					if(array_key_exists('imagem', $xml)){
					echo  "<input type=\"hidden\" name=\"excluido-".$qc."\" id=\"excluido-".$qc."\" value=''><input class=\"file-path validate\" type=\"text\" value=".substr(substr($xml->imagem, 9), 0, -1)." name=\"imagemTFIeld-".$qc."\" id=\"imagemTField-".$qc."\">";
					}
					else echo "<input class=\"file-path validate\" type=\"text\" value='' name=\"imagemTFIeld-".$qc."\" id=\"imagemTField-".$qc."\">";
				  echo   "</div>
					  </div>
					</div>
              </div>
            </div>
              <br><br>
              <button type=\"submit\" class=\"waves-effect waves-light btn light-blue darken-4\" id=\"enviar-alterar-".$qc."\">Salvar
                <i class=\"tiny material-icons white-text text-darken-1\">input</i>
              </button>
              <button type=\"reset\" class=\"waves-effect waves-light btn light-blue darken-4\" id=\"refazer-alterar-".$qc."\">Refazer
                <i class=\"tiny material-icons white-text text-darken-1\">replay</i>
              </button>
              <button type=\"submit\" class=\"waves-effect waves-light btn light-blue darken-4\" id=\"excluir-alterar-".$qc."\" name=\"excluir-alterar\">Excluir
                <i class=\"tiny material-icons white-text text-darken-1\">delete</i>
              </button>
              <br>
            </form>
      	   <br><br>";
			$qc++;
	}
?>

<!-- Chama o script que vai manipular esse arquivo PHP. -->
<script src="scriptPHP.js"></script>
