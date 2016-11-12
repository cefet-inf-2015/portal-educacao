<?php
    $conexao = new PDO('mysql:host=localhost; dbname=banco_de_questoes', 'phpmyadmin', 'o9rtjh88');  
    $sql = "SELECT * FROM questoes WHERE criador='".$_SERVER['SERVER_ADMIN']."'";
	
    $qc =0;
    foreach($conexao->query($sql) as $consulta){
		$xml = simplexml_load_string($consulta['XML']);
		echo "<form class=\"form_alterar\" action=\"altera.php\" method=\"post\" id=\"".$consulta['ID']."\">
				<input type=\"hidden\" name=\"formID\" value=\"".$consulta['ID']."\">
			<br>
			<p><h5 class=\"header col s12 light\">Questão: ".($qc+1)."</h5><p>
			<p>  
            <select class=\"browser-default\" id=\"estilo-alterar-".$qc."\" name=\"estilo-alterar\">
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
            <select class=\"browser-default\" id=\"nivel-alterar-".$qc."\" name=\"nivel-alterar\">
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
            <select class=\"browser-default\" id=\"disciplina-alterar-".$qc."\" name=\"disciplina-alterar\">
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
                <input type=\"text\" class=\"validate\" id=\"tema-alterar-".$qc."\" name=\"tema-alterar\" value=\"".$consulta['Conteudo']."\">
                <label class=\"active\" for=\"tema-alterar-".$qc."\">Digite o tema:</label>
              </div>
            </div>
          </p>

          <div class=\"row\">
            <div class=\"col s12\">
              <div class=\"row\">
                <div class=\"input-field col s12\">
                  <textarea class=\"materialize-textarea\" id=\"cabecalho-alterar-".$qc."\" name=\"cabecalho-alterar\">".$xml->enunciado."</textarea>
                  <label for=\"cabecalho-alterar-".$qc."\">Digite o cabeçalho da questão:</label>
                </div>
              </div>
            </div>
          </div><!-- Espaço onde as alternativas serão inseridas --> ";
                    
          echo "<div id=\"alternativas-alterar-".$qc."\" name=\"alternativas-alterar\">";
          $ic = 0;
          foreach($xml->alternativa as $key => $alternativa){
				 	echo "<div class=\"col s12\">
				 				<div class=\"row\">
				 					<label for=\"altEdit-".$qc."-".$ic."\">Alternativa: ".($ic+1)."</label>
				 					<textarea name=\"alternativaEdit-".$ic."\" id=\"altEdit-".$qc."-".$ic."\" class=\"materialize-textarea\">
				 					".$alternativa."</textarea>
				 					<div class=\"checkboxesEdit-".$qc." esconder\">
				 						<input class=\"filled-in checkboxesEditar-".$qc."\" name=\"cBoxEdit-".$ic."\" id=\"cBoxEdit-".$qc."-".$ic."\" type=\"checkbox\">
				 						<label for=\"cBoxEdit-".$qc."-".$ic."\">Verdadeiro</label>
				 					</div>
				 					<div class=\"rdiosEdit-".$qc." mostrar\">
				 						<input class=\"rdiosEditar-".$qc."\" value=\"rdioEdit".$ic."\" name=\"rdioEdit-\" id=\"rdioEdit-".$qc."-".$ic."\" type=\"radio\">
				 						<label for=\"rdioEdit-".$qc."-".$ic."\">Correto</label>
				 					</div>
				 				</div>
				 				<br>
				 				<br>
				 			</div>";
				 	$ic++;
				}
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
			
			
          <br>
          <br>

			
          <button type=\"submit\" class=\"waves-effect waves-light btn light-blue darken-4\" id=\"enviar-alterar-".$qc."\">Enviar
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
<script src="scriptPHP.js"></script>
