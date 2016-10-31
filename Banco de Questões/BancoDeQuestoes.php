<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>Portal Educação</title>


  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="styles/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="styles/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link rel="icon" href="imgs/logo.png" >
</head>
<body>
  <nav class="light-blue darken-4" role="navigation">
    <div class="nav-wrapper container">
      <!-- MENU SLIDE OUT STRUCTURE-->
      <ul id="slide-out" class="side-nav">
	   <br>
	   <li>
		    <div class="logo">
		      <img class="background center-block responsive" src="imgs/logo.png">
		    </div>
	    </li>
	    <br>
      <li><a class="waves-effect" href="index.html">Página Inicial</a></li>
	    <li><a class="waves-effect" href="#!">Modelo de Provas/Trabalhos</a></li>
	    <li><a class="waves-effect" href="#!">Fórum</a></li>
	    <li><a class="waves-effect" href="#!">Download/Upload Aplicativos</a></li>
	    <li><a class="waves-effect" href="#!">Correção Provas e Trabalhos</a></li>
	    <li><a class="waves-effect" href="Mural/projeto/index.html">Mural</a></li>
	    <li><a class="waves-effect" href="#!">Chat</a></li>
	    <li><a class="waves-effect" href="#!">Repositório de Fotos</a></li>
	    <li><a class="waves-effect" href="#!">Banco de Questões</a></li>
	    <li><a class="waves-effect" href="#!">Calendário</a></li>
	    <!--<li><div class="divider"></div></li>-->
	    <!--<li><a class="subheader">Subheader</a></li>-->
	  </ul>
      <ul class="left hide-on-med-and-down">
        <li>
        	<button data-activates="slide-out" class="waves-effect waves-light btn-flat button-collapse white-text light-blue darken-4">Menu</button>
        </li>
      </ul>
      <ul class="right hide-on-med-and-down">
        <li><button class="waves-effect waves-light btn-flat white-text light-blue darken-4">Entrar</button></li>
      </ul>
    </div>
  </nav>
  
  <!-- ESPAÇO PARA MARQUEE -->
  <div>
    
  </div>

  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br><br>
      <h1 class="header center blue-text text-darken-4">Banco de Questões</h1>
      <div class="row center">
        <h5 class="header col s12 light">A ferramenta que produz provas de maneira simples e funcional</h5>
      </div>
      <br><br>
    </div>
  </div>


  <div class="container">
    <div class="section" align="center">
      
      <!-- Criação e posicionamento dos botões na página -->
      
      <a class="waves-effect waves-light btn light-blue darken-4" id="inserir">Inserir Questões
        <i class="tiny material-icons white-text text-darken-1">add</i>
      </a>

      <a class="waves-effect waves-light btn light-blue darken-4" id="editar">Editar Questões
        <i class="tiny material-icons white-text text-darken-1">mode_edit</i>
      </a>

      <a class="waves-effect waves-light btn light-blue darken-4" id="produzir">Produzir Prova
        <i class="tiny material-icons white-text text-darken-1">library_books</i>
      </a>
      <br><br>

      <!-- Criação do formulário (Inserir Questões) -->

      <form id="FORMinserir" name="FORMiserir" action="insQuest.php" method="post">
        <div class="esconder" id="inserir_questoes">
          <p>  
            <select class="browser-default" id="estilo-inserir" name="estilo-inserir">
              <option value="" disabled selected>Escolha o estilo da questão a ser inserida.</option>
              <option value="0">Múltipla Escolha</option>
              <option value="1">Verdadeiro ou Falso</option>
              <option value="2">Dissertativa</option>
            </select>
          </p>
         
          <p>
            <select class="browser-default" id="nivel-inserir" name="nivel-inserir">
              <option value="" disabled selected>Escolha o nível de dificuldade da questão.</option>
              <option value="1">Fácil</option>
              <option value="2">Mediana</option>
              <option value="3">Difícil</option>
            </select>
          </p>

          <p>
            <select class="browser-default" id="disciplina-inserir" name="disciplina-inserir">
              <option value="" disabled selected>Defina a disciplina.</option>
              <option value="Aplicações para Web">Aplicações para Web</option>
              <option value="Arquitetura de Sistemas Digitais">Arquitetura de Sistemas Digitais</option>
              <option value="Linguagem de Programação">Linguagem de Programação - JAVA</option>
              <option value="Manutenção de Computadores">Manutenção de Computadores</option>
              <option value="Biologia">Biologia</option>
              <option value="Filosofia">Filosofia</option>
              <option value="Física">Física</option>
              <option value="Geografia">Geografia</option>
              <option value="Historia">História</option>
              <option value="Matemática">Matemática</option>
              <option value="Português">Português</option>
              <option value="Química">Química</option>
              <option value="Sociologia">Sociologia</option>
              <option value="outro">Outra</option>
            </select>
          </p> 

          <p>
            <div class="row" align="left">
              <div class="input-field col s12">
                <input type="text" class="validate" id="tema-inserir" name="tema-inserir">
                <label class="active" for="tema-inserir">Digite o tema:</label>
              </div>
            </div>
          </p>

          <div class="row">
            <div class="col s12">
              <div class="row">
                <div class="input-field col s12">
                  <textarea class="materialize-textarea" id="cabecalho-inserir" name="cabecalho-inserir"></textarea>
                  <label for="cabecalho-inserir">Digite o cabeçalho da questão:</label>
                </div>
              </div>
            </div>
          </div>

          <!-- Espaço onde as alternativas serão inseridas -->
          
          <div id="alternativas-inserir" name="alternativas-inserir">
          </div> 

          <!-- Botões específicos para questões de Múltipla Escolha ou VF -->
          
          <div class="esconder" id="adicionar_excluir-inserir" align="left">
            <a class="btn-floating btn waves-effect waves-light light-blue darken-4" id="inserirAlternativa-inserir">
			   <i class="material-icons">add</i>
			</a>
			<a class="btn-floating btn waves-effect waves-light light-blue darken-4" id="excluirAlternativa-inserir">
			   <i class="material-icons">delete</i>
			</a>
            <a class="btn-floating btn waves-effect waves-light light-blue darken-4" id="limparAlternativa-inserir">
			   <i class="material-icons">delete_forever</i>
			</a>
          </div>
			
			
			<br>
          <div class="row">
             <div class="row">
                <div class="input-field col s12">
                  <textarea class="materialize-textarea" id="gabarito-inserir" name="gabarito-inserir"></textarea>
                  <label for="gabarito-inserir">Digite o gabarito da questão:</label>
                </div>
             </div>
          </div>

          <button type="submit" class="waves-effect waves-light btn light-blue darken-4" id="enviar-inserir">Enviar
            <i class="tiny material-icons white-text text-darken-1">input</i>
          </button>
          <button type="reset" class="waves-effect waves-light btn light-blue darken-4" id="refazer-inserir">Refazer
            <i class="tiny material-icons white-text text-darken-1">replay</i>
          </button> 
        </div>
      </form>
	  
	    <!-- Criação do formulário (Editar Questoes) -->

      <div class="esconder" id="editar_questoes">
        <?php
			include('altQuest.php');
        ?>
      </div>

      <!-- Criação do formulário (Produzir Prova) -->

      <form id="FORMproduzir" name="FORMproduzir" action="prodProva.php" method="post">
        <div class="esconder" id="produzir_prova">
          <p>
            <select class="browser-default" id="disciplina-produzir" name="disciplina-produzir">
              <option value="" disabled selected>Defina a disciplina.</option>
              <option value="1">Aplicações para Web</option>
              <option value="2">Arquitetura de Sistemas Digitais</option>
              <option value="3">Linguagem de Programação - JAVA</option>
              <option value="4">Manutenção de Computadores</option>
              <option value="5">Biologia</option>
              <option value="6">Filosofia</option>
              <option value="7">Física</option>
              <option value="8">Geografia</option>
              <option value="9">História</option>
              <option value="10">Matemática</option>
              <option value="11">Português</option>
              <option value="12">Química</option>
              <option value="13">Sociologia</option>
              <option value="14">Outra</option>
            </select>
          </p> 

          <p>
            <div class="row" align="left">
              <div class="input-field col s12">
                <input type="text" class="validate" id="tema-produzir" name="tema-produzir">
                <label class="active" for="tema-produzir">Digite o tema:</label>
              </div>
            </div>
          </p>  


            <p>Escolha o nível de dificuldade das questões da prova:</p> 
            <p>
              <input type="radio" id="facil-produzir" name="nivel-produzir" value="facil"/>
              <label for="facil-inserir">Fáceis</label>
            </p>
            <p>
              <input type="radio" id="medio-produzir" name="nivel-produzir" value="medio"/>
              <label for="medio-produzir">Medianas</label>
            </p>
            <p>
              <input type="radio" id="dificil-produzir" name="nivel-produzir" value="medio"/>
              <label for="dificil-produzir">Difíceis</label>
            </p>

          <br>
            <p>Defina o estilo das questões que estarão presentes na prova:</p>
            <p>
              <input type="checkbox" class="filled-in" id="dissertativas-produzir" name="estilo-produzir"/>
              <label for="dissertativas-produzir">Dissertativas</label>
            </p>
            <p>
              <input type="checkbox" class="filled-in" id="multipla_escolha-produzir" name="estilo-produzir"/>
              <label for="multipla_escolha-produzir">Multipla Escolha</label>
            </p>
            <p>
              <input type="checkbox" class="filled-in" id="v_f-produzir" name="estilo-produzir"/>
              <label for="v_f-produzir">Verdadeiro ou Falso</label>
            </p>

          <br>
            <p>Escolha o número de questões:</p>
            <p class="range-field">
              <input type="range" min="0" max="100"  id="numQuestoes-produzir"/>
            </p>

          <br><br>
          <button type="submit" class="waves-effect waves-light btn light-blue darken-4" id="pub">Gerar Prova
            <i class="tiny material-icons white-text text-darken-1">description</i>
          </button>
        </div>
      </form> 

    </div>
  </div>

  <footer class="page-footer blue">
    <div class="container">
      <div class="row">
        <div class="col l6 s12">
          <h5 class="white-text">Desenvolvedores</h5>
          <p class="grey-text text-lighten-4">
            Somos a turma de Informática 2A do ano de 2016 do CEFET-MG (Centro Federal de Educação Tecnológica de Minas Gerais) desenvolvendo o trabalho final multidisciplinar de Linguagem de Programação 1 e Aplicações para WEB.
            <br><a class="white-text link" href="colaboradores.html">Clique aqui</a> para saber mais
          </p>
        </div>
        <div class="col l3 s12">
          <h5 class="white-text">Sobre a Instituição</h5>
          <p class="grey-text text-lighten-4">
            Centro Federal de Educação Tecnológica de Minas Gerais
            <br>Av. Amazonas 5253 - Nova Suiça - Belo Horizonte - MG - Brasil
            <br>Telefone: +55 (31) 3319-7000 - Fax: +55 (31) 3319-7001
          </p>
        </div>
        <div class="col l3 s12">
          <h5 class="white-text">Recursos</h5>
          <ul>
            <li><a class="white-text link" href="https://github.com/cefet-inf-2015/portal-educacao/" target="_blank">Github</a></li>
            <li><a class="white-text link" href="http://cefetmg.br/" target="_blank">CEFET-MG</a></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container">
      Made by <a class="blue-text text-lighten-3" href="http://materializecss.com">Materialize</a>
      </div>
    </div>
  </footer>


  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="template/js/materialize.js"></script>
  <script src="template/js/init.js"></script>
  <script src="Script.js"></script>

  </body>
</html>
