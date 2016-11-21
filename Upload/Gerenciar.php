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
    <style type="text/css">
      body {
          display: flex;
          min-height: 100vh;
          flex-direction: column;
      }

      main {
          flex: 1 0 auto;
      }
    </style>
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
        <ul class="left ">
          <li>
            <button data-activates="slide-out" class="waves-effect waves-light btn-flat button-collapse white-text light-blue darken-4">Menu</button>
          </li>
        </ul>
        <ul class="right ">
          <!-- <li><button class="waves-effect waves-light btn-flat white-text light-blue darken-4">Entrar</button></li> -->
          <li><a class="waves-effect waves-light btn modal-trigger white-text light-blue darken-3" href="#modal1">Entrar</a></li>
        </ul>
      </div>
    </nav>

    <!-- Modal de login -->
    <div id="modal1" class="modal modal-fixed-footer">
      <div class="modal-content">
        <h4>Login</h4>
        <div class="row">
          <p>Insira dados</p>
          <form>
            <label for="username">Nome de usuario</label>
            <input type="text" name="username">
            <label for="senha">Senha</label>
            <input type="password" name="senha">
            <label for="tipoUsuario">Tipo de usuário</label>
            <select name="tipoUsuario">
              <option value="" disabled selected>Tipo de Usuario</option>
              <option value="1">Aluno</option>
              <option value="2">Professor</option>
              <option value="3">Coordenador</option>
              <option value="4">Diretor</option>
            </select>
            <button class="col s12 btn-flat waves-effect waves-light green white-text" type="submit" name="action">Entrar
              <i class="material-icons right">input</i>
            </button>
          </form>

        </div>
      </div>
      <div class="modal-footer">
        <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat red white-text">Sair</a>
      </div>
    </div>

    <!-- ESPAÇO PARA MARQUEE -->
    <div>

    </div>

    <div class="section no-pad-bot" id="index-banner">
      <div class="container">
        <br><br>
        <h1 class="header center blue-text text-darken-4">Download</h1>
        <div class="row center">
          <h5 class="header col s12 light">Arquivos Com As Tags Especificadas</h5>
        </div>
        <br><br>
      </div>
    </div>

    <main>
      <div class="container">
        <div class="section">
          <!-- CONTEÚDO AQUI -->
<?php
            date_default_timezone_set("America/Sao_Paulo");
            $conexao = mysql_connect('localhost','root','123');
			mysql_select_db('teste',$conexao);
            $result = mysql_query("SELECT * FROM new_table WHERE status=0");
			$numCard = 0;   //Se houverem 4 cards pula uma linha
			if($_POST['palavrasChave']!=""){
            $tags = explode(',', $_POST['palavrasChave']);
				echo '<div class="row">';
                while ($arrArq = mysql_fetch_assoc($result)) {
                    $enc = false;
                    $tagsArq = explode(',', $arrArq["tags1"]);
                    foreach ($tags as $t) {
                        foreach ($tagsArq as $tA) {
                            if ($t == $tA) {
                                $enc = true;
                                $numCard++;
                                 echo '<div class="card sticky-action col s3">
                            <div class="card-image waves-effect waves-block waves-light">
                              <img class="activator" src="icon.png">
                            </div>
                            <div class="card-content">
                              <span class="card-title activator grey-text text-darken-4 truncate">' . $arrArq['nome'] . '<i class="material-icons right">more_vert</i></span>
                              <a class="col btn-large" href="' . $arrArq['path'] . '" download>BAIXAR</a>
                            </div>
                            <div class="card-reveal">
                              <span class="card-title grey-text text-darken-4">' . $arrArq['nome'] . '<i class="material-icons right">close</i></span>
                              <p> Tags: ' . $arrArq['tags1'] . '</p>
                            </div>
                          </div>
						  <div class="container">
        <div class="section">
          <!-- CONTEÚDO AQUI -->
          <div>
            <form enctype= "multipart/form-data" class="col s12" action="Download.php" method="post">
              <div class="row center">
                <div class="input-field col s10">
                  <input type="text" name = "palavrasChave" id="palavrasChave" class="materialize-textarea tooltipped" data-position="left" data-delay="50" data-tooltip="Palavras simples separadas por vírgula" placeholder="Exemplo: &quot;vídeo,matemática,etc&quot;"/>
                  <label for="palavrasChave">Palavras-chave</label>
                </div>
                <div class="right-align">
                  <button class="btn-large waves-effect waves-light" type="submit" name="enviar">Procurar
                    <i class="material-icons right">search</i>
                  </button>
                </div>
              </div>
            </form>
          </div>
        </div>';
                                break;
                            }
                        }
                        if ($numCard == 4) {
                            echo '</div>
                    <div class="row">';
                        }
                        if ($enc) {
                            break;
                        }
                    }
                }
				echo '</div>';
            } else{
				echo '<div class="row">';
                while ($arrArq = mysql_fetch_assoc($result)) {
                    $numCard++;
                      echo '<div class="card sticky-action col s3">
                            <div class="card-image waves-effect waves-block waves-light">
                              <img class="activator" src="icon.png">
                            </div>
                            <div class="card-content">
                              <span class="card-title activator grey-text text-darken-4 truncate">' . $arrArq['nome'] . '<i class="material-icons right">more_vert</i></span>
                              <a class="col btn-large" href="' . $arrArq['path'] . '" download>BAIXAR</a>
							  <a class="col btn-large" onclick="mudaStatus()"><i id="' . $arrArq['nome'] . '" class="material-icons right" onload="exibeStatus(' . $arrArq['status'] . ',this.id)"></i></a>
                            </div>
                            <div class="card-reveal">
                              <span class="card-title grey-text text-darken-4">' . $arrArq['nome'] . '<i class="material-icons right">close</i></span>
                              <p> Tags: ' . $arrArq['tags1'] . '</p>
                            </div>
                          </div>';
                    if ($numCard == 4) {
                        echo '</div>
                    <div class="row">';
                    }
                }
				echo '</div>';
            }
            ?>
	<!--  Não-Tabela-->
    </main>

    <!--  Footer-->
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
    <script src="index.js"></script>
	<script type="text/javascript">
        function mudaStatus(status, id) {
		if (status == 0) {
                document.getElementById(id).querySelector("#child").innerHTML = "visibility";
                //Aqui modifica a tabela pra colocar status 1 <? //n sei como exatamente    ?>
            } else if (status == 1) {
                document.getElementById(id).querySelector("#child").innerHTML = "visibility_off";
                //Aqui modifica a tabela pra colocar status 0
            }
        }
        function exibeStatus(status, id) {
            if (status == 0) {
                document.getElementById(id).innerHTML = "visibility_off";
            } else if (status == 1) {
                document.getElementById(id).innerHTML = "visibility";
            }
        }
    </script>

  </body>
</html>