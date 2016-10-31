<?php
    $conexao = new PDO('mysql:host=localhost; dbname=banco_de_questoes', 'phpmyadmin', 'o9rtjh88');  
    $sql = "SELECT * FROM questoes WHERE criador='".$_SERVER['SERVER_ADMIN']."'";
	
    
    foreach($conexao->query($sql) as $consulta){
		$xml = simplexml_load_string($consulta['XML']);
		echo "
			<br>
			<p>  
            <select class=\"browser-default\" id=\"estilo-alterar\" name=\"estilo-alterar\">
              <option value=\"\" disabled selected>(Inalterado)</option>
              <option value=\"0\">Múltipla Escolha</option>
              <option value=\"1\">Verdadeiro ou Falso</option>
              <option value=\"2\">Dissertativa</option>
            </select>
          </p>
         
          <p>
            <select class=\"browser-default\" id=\"nivel-alterar\" name=\"nivel-alterar\">
              <option value=\"\" disabled selected>(Inalterado)</option>
              <option value=\"1\">Fácil</option>
              <option value=\"2\">Mediana</option>
              <option value=\"3\">Difícil</option>
            </select>
          </p>

          <p>
            <select class=\"browser-default\" id=\"disciplina-alterar\" name=\"disciplina-alterar\">
              <option value=\"\" disabled selected>(Inalterado)</option>
              <option value=\"Aplicações para Web\">Aplicações para Web</option>
              <option value=\"Arquitetura de Sistemas Digitais\">Arquitetura de Sistemas Digitais</option>
              <option value=\"Linguagem de Programação\">Linguagem de Programação - JAVA</option>
              <option value=\"Manutenção de Computadores\">Manutenção de Computadores</option>
              <option value=\"Biologia\">Biologia</option>
              <option value=\"Filosofia\">Filosofia</option>
              <option value=\"Física\">Física</option>
              <option value=\"Geografia\">Geografia</option>
              <option value=\"Historia\">História</option>
              <option value=\"Matemática\">Matemática</option>
              <option value=\"Português\">Português</option>
              <option value=\"Química\">Química</option>
              <option value=\"Sociologia\">Sociologia</option>
              <option value=\"outro\">Outra</option>
            </select>
          </p> 

          <p>
            <div class=\"row\" align=\"left\">
              <div class=\"input-field col s12\">
                <input type=\"text\" class=\"validate\" id=\"tema-alterar\" name=\"tema-alterar\" value=".$consulta['Conteudo'].">
                <label class=\"active\" for=\"tema-alterar\">Digite o tema:</label>
              </div>
            </div>
          </p>

          <div class=\"row\">
            <div class=\"col s12\">
              <div class=\"row\">
                <div class=\"input-field col s12\">
                  <textarea class=\"materialize-textarea\" id=\"cabecalho-alterar\" name=\"cabecalho-alterar\">".$xml->enunciado."</textarea>
                  <label for=\"cabecalho-alterar\">Digite o cabeçalho da questão:</label>
                </div>
              </div>
            </div>
          </div><!-- Espaço onde as alternativas serão inseridas --> ";
          
          foreach($xml->alternativa as $alternativa){
				 	echo "<br>".$alternativa."<br>";
				}
          
          echo "<div id=\"alternativas-alterar\" name=\"alternativas-alterar\">
          
          
     			</div> 

          <!-- Botões específicos para questões de Múltipla Escolha ou VF -->
          
          <div class=\"esconder\" id=\"adicionar_excluir\" align=\"left\">
            <a class=\"btn-floating btn waves-effect waves-light light-blue darken-4\" id=\"inserirAlternativa-alterar\">
			   <i class=\"material-icons\">add</i>
			</a>
			<a class=\"btn-floating btn waves-effect waves-light light-blue darken-4\" id=\"excluirAlternativa-alterar\">
			   <i class=\"material-icons\">delete</i>
			</a>
            <a class=\"btn-floating btn waves-effect waves-light light-blue darken-4\" id=\"limparAlternativa-inserir\">
			   <i class=\"material-icons\">delete_forever</i>
			</a>
          </div><div class=\"row\">
             <div class=\"row\">
                <div class=\"input-field col s12\">
                  <textarea class=\"materialize-textarea\" id=\"gabarito-inserir\" name=\"gabarito-inserir\"></textarea>
                  <label for=\"gabarito-inserir\">Digite o gabarito da questão:</label>
                </div>
             </div>
          </div>

          <button type=\"submit\" class=\"waves-effect waves-light btn light-blue darken-4\" id=\"enviar-inserir\">Enviar
            <i class=\"tiny material-icons white-text text-darken-1\">input</i>
          </button>
          <button type=\"reset\" class=\"waves-effect waves-light btn light-blue darken-4\" id=\"refazer-inserir\">Refazer
            <i class=\"tiny material-icons white-text text-darken-1\">replay</i>
          </button><br>";
	}
?>
<script src="scriptPHP.js"></script>
